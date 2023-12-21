package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.dto.HotelDto;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation){
        reservationService.save(reservation);
    }


}
