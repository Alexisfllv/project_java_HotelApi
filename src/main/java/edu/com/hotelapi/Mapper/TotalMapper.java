package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Reservation.TotalPlanoDTO;
import edu.com.hotelapi.DTO.Total.TotalRequestDTO;
import edu.com.hotelapi.DTO.Total.TotalResponseDTO;
import edu.com.hotelapi.ENTITY.ReservationTotal;
import edu.com.hotelapi.ENTITY.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface TotalMapper {

    // request

    ReservationTotal toReservationTotal(TotalRequestDTO totalRequestDTO);

    @Mapping(target = "reservation_total_id", source = "reservation.id")
    TotalResponseDTO toTotalResponseDTO(ReservationTotal reservationTotal);

    // plano
    @Mapping(target = "reservation_total_id", source = "reservation.id")
    TotalPlanoDTO toDto(ReservationTotal total);
}
