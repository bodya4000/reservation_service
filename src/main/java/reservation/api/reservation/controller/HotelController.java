package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.dto.hotel.HotelDto;
import reservation.api.reservation.model.Hotel;
import reservation.api.reservation.repository.hotelRepo.HotelRepository;
import reservation.api.reservation.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/{id}")
    public HotelDto getByName(
            @PathVariable Long id) {
        return hotelRepository.findHotelDtoById(id);
    }


    @PostMapping
    public void createHotel(@RequestBody Hotel hotel){
        hotelService.save(hotel);
    }


}
