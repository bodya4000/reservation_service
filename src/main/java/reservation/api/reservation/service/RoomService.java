package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.api.reservation.dto.ClientDto;
import reservation.api.reservation.dto.RoomDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Room;
import reservation.api.reservation.repository.ClientRepository;
import reservation.api.reservation.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;
    public void save(Room room) {
        repository.save(room);
    }

    public RoomDto findById(Long id) {
        return repository.findRoomDtoById(id);
    }
}
