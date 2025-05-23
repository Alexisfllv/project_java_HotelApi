package edu.com.hotelapi.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservation_total")
public class ReservationTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_id")
    private Long id;

    @Column(name = "total_title")
    private String total_title;

    @Column(name = "total_amount")
    private BigDecimal total_amount;

    @ManyToOne
    @JoinColumn(name = "reservation_total_id", nullable = false)
    @JsonIgnore
    private Reservation reservation;
}
