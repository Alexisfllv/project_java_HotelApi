package edu.com.hotelapi.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservations_history")
public class ReservationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rh_id")
    private long id;

    @Column(name = "rh_date")
    private LocalDateTime history_date;

    @Column(name = "rh_status")
    private String history_status;

    @Column(name = "rh_notes")
    private String history_notes;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    @JsonIgnore
    private Reservation reservation;
}
