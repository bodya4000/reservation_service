package reservation.api.reservation.dto;

import java.util.List;

public record RoomDto(
        Long id,
        Status status,
//        List<String> images,

        List<ReservationDto> reservationDtos

){}
