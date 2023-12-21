package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.dto.HotelDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{name}")
    public HotelDto getByName(
            @PathVariable String name
    ){
        return null;
    }


    @PostMapping
    public void createClient(@RequestBody Client client){
        clientService.save(client);
    }


}
