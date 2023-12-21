package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.api.reservation.dto.ClientDto;
import reservation.api.reservation.dto.ReservationDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Reservation;
import reservation.api.reservation.repository.ClientRepository;
import reservation.api.reservation.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    public ReservationDto findById(Long id) {
        return repository.findReservationDtoById(id);
    }
}
