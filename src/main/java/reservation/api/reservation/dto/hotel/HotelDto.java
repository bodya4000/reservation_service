package reservation.api.reservation.dto.hotel;

import reservation.api.reservation.dto.room.RoomReadDto;
import reservation.api.reservation.dto.room.RoomReadWithReservation;

import java.util.List;

public record HotelDto(
        String name,
        String logoImg,
        String address,
        float rating,
        float popularity,
        List<RoomReadWithReservation> rooms
){}
