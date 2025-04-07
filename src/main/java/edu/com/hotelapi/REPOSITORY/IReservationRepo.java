package edu.com.hotelapi.REPOSITORY;

import edu.com.hotelapi.ENTITY.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepo extends JpaRepository<Reservation, Long> {
}
