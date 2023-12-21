package reservation.api.reservation.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import reservation.api.reservation.dto.ClientDto;
import reservation.api.reservation.dto.HotelDto;
import reservation.api.reservation.dto.ReservationDto;
import reservation.api.reservation.dto.RoomDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Hotel;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.model.Room;

import java.util.List;

public class HotelRepositoryImpl implements CustomHotelRepository {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public HotelDto findHotelDtoById(Long id) {
        var hotel = entityManager.createQuery("select h from Hotel h "
                + "left join fetch h.rooms"
                + " where h.id=:id", Hotel.class)

                .setParameter("id", id)
                .getSingleResult();

        var rooms = entityManager.createQuery(
                "select r from Room r " +
                        "left join fetch r.reservations res " +
                        "left join fetch res.client" +
                        " where r.hotel.id=:id", Room.class)
                .setParameter("id", id)
                .getResultList();

        return mapToHotelDto(hotel, rooms);
    }

    private HotelDto mapToHotelDto(Hotel hotel, List<Room> rooms) {

        List<RoomDto> roomDtos = rooms.stream().map(this::mapToRoomDto).toList();

        return new HotelDto(hotel.getName(), hotel.getLogoImg(), hotel.getAddress(), hotel.getRating(), hotel.getPopularity(), roomDtos);
    }

    private RoomDto mapToRoomDto(Room room) {

        List<ReservationDto> reservationDtos = room.getReservations().stream().map(this::mapToReservationDto).toList();

        return new RoomDto(room.getId(), room.getStatus(), reservationDtos);
    }

    private ReservationDto mapToReservationDto(Reservation reservation) {

        ClientDto clientDto = mapToClientDto(reservation.getClient());

        return new ReservationDto(reservation.getId(), reservation.getStartDate(), reservation.getEndDate(), clientDto);
    }

    private ClientDto mapToClientDto(Client client) {
        return new ClientDto(client.getFirstName(), client.getLastName());
    }
}
