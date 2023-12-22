package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.api.reservation.model.Hotel;
import reservation.api.reservation.repository.hotelRepo.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

//    public HotelDto findById(Long id) {
//        return hotelRepository.findHotelDtoById(id);
//    }
}
