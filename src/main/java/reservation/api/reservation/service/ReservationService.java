package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.api.reservation.dto.client.ClientDto;
import reservation.api.reservation.dto.reservation.ReservationCreateDto;
import reservation.api.reservation.dto.reservation.ReservationReadDto;
import reservation.api.reservation.dto.room.RoomReadDto;
import reservation.api.reservation.exceptions.NotFoundIdException;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.model.Room;
import reservation.api.reservation.repository.clientRepo.ClientRepository;
import reservation.api.reservation.repository.reservation.ReservationRepository;
import reservation.api.reservation.repository.roomRepo.RoomRepository;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;
    private RoomRepository roomRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void parseAndSaveFrontReservationDto(ReservationCreateDto reservationCreateDto) throws NotFoundIdException {
        var roomId = reservationCreateDto.roomId();
        var room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundIdException(roomId, Room.class));

        var clientId = reservationCreateDto.clientId();
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundIdException(clientId, Client.class));

        var reservation = new Reservation();
        reservation.setStartDate(reservationCreateDto.startDate());
        reservation.setEndDate(reservationCreateDto.endDate());
        reservation.setClient(client);
        reservation.setRoom(room);

        reservationRepository.save(reservation);
    }

    @Transactional(readOnly = true)
    public ReservationReadDto getById(Long id) throws NotFoundIdException {
        var reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException(id, Reservation.class));

        return new ReservationReadDto(
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                new ClientDto(
                        reservation.getClient().getId(),
                        reservation.getClient().getFirstName(),
                        reservation.getClient().getLastName()
                ),
                new RoomReadDto(
                        reservation.getRoom().getId(),
                        reservation.getRoom().getStatus()
                )
        );
    }
}
