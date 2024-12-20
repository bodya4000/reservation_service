package reservation.api.reservation.repository.hotelRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>, CustomHotelRepository {

//    @Query("select new reservation.api.reservation.dto.hotel.HotelDto(" +
//            "h.name, h.logoImg, h.address, h.rating, h.popularity, collect(r.id))" +
//            "from Hotel h " +
//            "left join fetch h.rooms r")
//    HotelDto findHotelDtoById(@Param("id") Long id);

    @Query("select h " +
            "from Hotel h " +
            "left join fetch h.rooms r")
    Hotel findHotelById(@Param("id") Long id);
}
