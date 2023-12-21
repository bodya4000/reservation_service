package reservation.api.reservation.dto;

import java.util.List;

public record HotelDto(
        String name,
        String logoImg,
        String address,
        float rating,
        float popularity,
        List<RoomDto> roomDtos
){}
