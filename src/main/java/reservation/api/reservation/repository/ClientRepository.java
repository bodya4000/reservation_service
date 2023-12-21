package reservation.api.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.ClientDto;
import reservation.api.reservation.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select new reservation.api.reservation.dto.ClientDto(c.firstName, c.lastName)" +
            "from Client c")
    ClientDto findClientDtoById(@Param("id") Long id);
}
