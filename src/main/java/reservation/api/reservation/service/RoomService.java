package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.api.reservation.model.Room;
import reservation.api.reservation.repository.roomRepo.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;
    public void save(Room room) {
        repository.save(room);
    }

//    public RoomCreateDto findById(Long id) {
//        return repository.findRoomDtoById(id);
//    }
}
