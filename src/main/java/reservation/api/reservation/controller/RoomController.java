package reservation.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.api.reservation.model.Room;
import reservation.api.reservation.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public void createRoom(@RequestBody Room room){
        roomService.save(room);
    }


}
