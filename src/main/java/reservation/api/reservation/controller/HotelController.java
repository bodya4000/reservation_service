package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.dto.HotelDto;
import reservation.api.reservation.model.Hotel;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.repository.HotelRepository;
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
