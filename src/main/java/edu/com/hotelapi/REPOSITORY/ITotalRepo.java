package edu.com.hotelapi.REPOSITORY;

import edu.com.hotelapi.ENTITY.ReservationTotal;
import edu.com.hotelapi.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITotalRepo extends JpaRepository<ReservationTotal, Long> {
}
