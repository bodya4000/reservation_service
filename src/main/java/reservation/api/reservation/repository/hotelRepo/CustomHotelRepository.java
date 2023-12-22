package reservation.api.reservation.repository.hotelRepo;

import reservation.api.reservation.dto.hotel.HotelDto;

public interface CustomHotelRepository {
    HotelDto findHotelDtoById(Long id);
}
