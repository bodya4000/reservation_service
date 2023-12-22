package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.dto.reservation.ReservationCreateDto;
import reservation.api.reservation.dto.reservation.ReservationReadDto;
import reservation.api.reservation.exceptions.NotFoundIdException;
import reservation.api.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void createReservation(@RequestBody ReservationCreateDto reservationCreateDto) throws NotFoundIdException {
        reservationService.parseAndSaveFrontReservationDto(reservationCreateDto);
    }

    @GetMapping("{id}")
    public ReservationReadDto getById(@PathVariable("id") Long id) throws NotFoundIdException {
        return reservationService.getById(id);
    }

}
