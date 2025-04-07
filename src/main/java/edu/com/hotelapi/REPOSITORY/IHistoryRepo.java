package edu.com.hotelapi.REPOSITORY;

import edu.com.hotelapi.ENTITY.ReservationHistory;
import edu.com.hotelapi.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryRepo extends JpaRepository<ReservationHistory, Long> {
}
