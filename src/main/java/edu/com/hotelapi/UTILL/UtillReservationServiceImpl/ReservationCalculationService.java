package edu.com.hotelapi.UTILL.UtillReservationServiceImpl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ReservationCalculationService {

    public int calcularDias(LocalDateTime startDate, LocalDateTime endDate) {
        return (int) ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
    }

    public BigDecimal calcularPrecio(Long roomId) {
        return switch (roomId.intValue()) {
            case 1 -> BigDecimal.valueOf(100);
            case 2 -> BigDecimal.valueOf(200);
            case 3 -> BigDecimal.valueOf(300);
            default -> BigDecimal.ZERO;
        };
    }
}
