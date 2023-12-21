package reservation.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.api.reservation.dto.ClientDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public void save(Client client) {
        clientRepository.save(client);
    }

    public ClientDto findById(Long id) {
        return clientRepository.findClientDtoById(id);
    }
}
