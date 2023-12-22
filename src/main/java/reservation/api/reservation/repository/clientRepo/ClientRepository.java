package reservation.api.reservation.repository.clientRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.client.ClientDto;
import reservation.api.reservation.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select new reservation.api.reservation.dto.client.ClientDto(c.id,c.firstName, c.lastName)" +
            "from Client c")
    ClientDto findClientDtoById(@Param("id") Long id);
}
