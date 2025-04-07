package edu.com.hotelapi.ENTITY;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private long id;

    @Column(name = "reservation_start", nullable = false)
    private LocalDateTime resv_start;

    @Column(name = "reservation_end", nullable = false)
    private LocalDateTime resv_end;

    @Column(name = "reservation_status", nullable = false)
    private String resv_status;

    @Column(name = "reservation_user_name", nullable = false)
    private String user_name;

    @Column(name = "reservation_user_email", nullable = false)
    private String user_email;

    @Column(name = "reservation_user_telephone", nullable = false)
    private String user_telephone;

    @Column(name = "reservation_bill_name", nullable = false)
    private String bill_name;

    @Column(name = "reservation_bill_email", nullable = false)
    private String bill_email;

    @Column(name = "reservation_bill_telephone", nullable = false)
    private String bill_telephone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}
