```python
com.ejemplo.hotelapi

├── Controller
│   ├── HistorialController.java
│   ├── ReservationController.java
│   ├── RoomController.java
│   ├── TotalController.java
│   └── UserController.java
├── Dto
│	├── Dto/Historial
│	│	├── HistorialFullResponseDTO.java
│	│	├── HistorialRequestDTO.java
│	│	└── HistorialResponseDTO.java
│   ├── Dto/Reservation
│	│	├── HistorialPlanoDTO.java
│	│	├── ReservationPlanoResponseDTO.java
│	│	├── ReservationRequestDTO.java
│	│	├── ReservationResponseDTO.java
│	│	└── TotalPlanoDTO.java
│   ├── Dto/Room
│	│	├── RoomRequestDTO.java
│	│	└── RoomResponseDTO.java
│   ├── Dto/Total
│	│	├── TotalFullResponseDTO.java
│	│	├── TotalRequestDTO.java
│	│	└── TotalResponseDTO.java
│   └── Dto/Usuario
│		├── UsuarioRequestDTO.java
│		└── UsuarioResponseDTO.java
├── Entity
│   ├── Reservation.java
│   ├── ReservationHistory.java
│   ├── ReservationTotal.java
│   ├── Room.java
│   └── User.java
├── Exception
│   ├── Exception/Erros
│	│	└── ExDataNotFoundException.java
│   └──GlobalExceptionHandler.java
├── Mapper
│   ├── HistorialMapper.java
│   ├── ReservationMapper.java
│   ├── RoomMapper.java
│   ├── TotalMapper.java
│   └── UsuarioMapper.java
├── Page
│   └── PageResponseDTO.java
├── Repository
│   ├── IHistoryRepo.java
│   ├── IReservationRepo.java
│   ├── IRoomRepo.java
│   ├── ITotalRepo.java
│   └── IUserRepo.java
├── Response
│   ├── ResponseDTO.java
│   └── ResponseMessage.java
├── Service
│   ├── HistoriaService.java
│   ├── ReservationService.java
│   ├── RoomService.java
│   ├── TotalService.java
│   ├── UserService.java
│   └── Service/Impl
│		├── HistoriasServiceImpl.java
│		├── ReservationServiceImpl.java
│		├── RoomServiceImpl.java
│		├── TotalServiceImpl.java
│		└── UsuarioServiceImpl.java
├── Utill
│   └── Utill/ReservationServiceImpl
│		└── ReservationCalculationService.java
└── HotelApiApplication.java
```

# Entity
### Room.java
```java
@Entity  
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
@Table(name = "rooms")  
public class Room {  
    @Id  
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name = "room_id")  
    private Long id;  
  
    @Column(name = "room_type")  
    private String type;  
  
    @Column(name = "room_price")  
    private BigDecimal price;  
}
```

### User.java
```java
@Entity  
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
@Table(name = "users")  
public class User {  
    @Id  
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name = "user_id")  
    private Long id;  
  
    @Column(name = "user_name", nullable = false)  
    private String name;  
  
    @Column(name = "user_email", nullable = false)  
    private String email;  
  
    @Column(name = "user_telephone", nullable = false)  
    private String telephone;  
  
    @Column(name = "user_password", nullable = false)  
    private String password;  
  
    @Column(name = "user_role", nullable = false)  
    private String role;  
}
```

### Reservation.java
```java
@Entity  
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
@Table(name = "Reservations")  
public class Reservation {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "reservation_id")  
    private Long id;  
  
    @Column(name = "reservation_start", nullable = false)  
    private LocalDateTime resv_start;  
  
    @Column(name = "reservation_end", nullable = false)  
    private LocalDateTime resv_end;  
  
    @Column(name = "reservation_status", nullable = false)  
    private String resv_status;  
  
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
  
    // Tablas asociadas  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    @JoinColumn(name = "reservation_history_id")  
    private List<ReservationHistory> historials = new ArrayList<>();  
  
  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    @JoinColumn(name = "reservation_total_id")  
    private List<ReservationTotal> totals = new ArrayList<>();  
}
```

### ReservationHistory.java
```java
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
    @JoinColumn(name = "reservation_history_id", nullable = false)  
    //@JsonIgnoreProperties({"historials","totals","room","user"})  
    @JsonIgnore  
    private Reservation reservation;  
}
```

### ReservationTotal
```java
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
```

# DTO
## Room
### RoomRequest.DTO
```java
public record RoomRequestDTO(  
        String type,  
        BigDecimal price  
) {}
```
### RoomResponseDTO
```java
public record RoomResponseDTO(  
        Long id,  
        String type,  
        BigDecimal price  
) {}
```

## Usuario
### UsuarioRequestDTO.java
```java
public record UsuarioRequestDTO(  
        String name,  
        String email,  
        String telephone,  
        String password,  
        String role  
) {}
```
### UsuarioResponseDTO.java
```java
public record UsuarioResponseDTO(  
         Long id,  
         String name,  
         String email,  
         String telephone,  
         String password,  
         String role  
) {}
```
## Historial
### HistorialFullResponseDTO.java
```java
public record HistorialFullResponseDTO(  
        Long id,  
        LocalDateTime history_date,  
        String history_status,  
        String history_notes,  
        Reservation reservation  
) {}
```

### HistorialRequestDTO.java
```java
public record HistorialRequestDTO(  
        String history_status,  
        String history_notes  
) {}
```
### HistorialResponseDTO.java
```java
public record HistorialResponseDTO(  
        Long id,  
        LocalDateTime history_date,  
        String history_status,  
        String history_notes,  
        Long reservation_history_id  
) {}
```
## Total
### TotalFullResponseDTO.java
```java
public record TotalFullResponseDTO(  
        Long id,  
        String total_title,  
        BigDecimal total_amount,  
        Reservation reservation  
) {}
```
### TotalRequestDTO.java
```java
public record TotalRequestDTO(  
        String total_title,  
        BigDecimal total_amount  
) {}
```
### TotalResponseDTO.java
```java
public record TotalResponseDTO(  
        Long id,  
        String total_title,  
        BigDecimal total_amount,  
        Long reservation_total_id  
) {}
```
---
## Reservation
### HistorialPlanoDTO.java
```java
public record HistorialPlanoDTO(  
        Long id,  
        LocalDateTime history_date,  
        String history_status,  
        String history_notes,  
        Long reservation_history_id  
) { }
```
### ReservationPlanoResponseDTO.java
```java
public record ReservationPlanoResponseDTO(  
        Long id,  
        LocalDateTime resv_start,  
        LocalDateTime resv_end,  
        String resv_status,  
        String bill_name,  
        String bill_email,  
        String bill_telephone,  
        //usuario  
        Long user_id,  
        String user_name,  
        String user_email,  
        String user_tel,  
        //room  
        Long room_id,  
        String room_type,  
        BigDecimal room_price,  
        //totals  
        List<TotalPlanoDTO> totals,  
        // historials  
        List<HistorialPlanoDTO> historials  
  
) {}
```

### ReservationRequestDTO.java
```java
public record ReservationRequestDTO(  
        LocalDateTime resv_start,  
        LocalDateTime resv_end,  
        String resv_status,  
        String bill_name,  
        String bill_email,  
        String bill_telephone,  
        // datos a ingresar  
        Long userId,  
        Long roomId,  
        List<HistorialRequestDTO> historials,  
        List<TotalRequestDTO> totals  
) {}
```
### ReservationResponseDTO.java
```java
public record ReservationResponseDTO(  
        Long id,  
        LocalDateTime resv_start,  
        LocalDateTime resv_end,  
        String resv_status,  
        String bill_name,  
        String bill_email,  
        String bill_telephone,  
        // datos a ingresar  
        UsuarioResponseDTO user,  
        RoomResponseDTO room,  
        List<HistorialResponseDTO> historials,  
        List<TotalResponseDTO> totals  
) {}
```

### TotalPlanoDTO.java
```java
public record TotalPlanoDTO(  
        Long id,  
        String total_title,  
        BigDecimal total_amount,  
        Long reservation_total_id  
) {}
```
---
# Mapper
### HistorialMapper.java
```java
@Mapper (componentModel = "spring")  
public interface HistorialMapper {  
  
    // Modelo full para reserva  
    @Mapping(target = "reservation_history_id", source = "reservation.id")  
    HistorialResponseDTO toHistorialResponseDto(ReservationHistory reservationHistory);  
  
    // Modelo plano para reserva  
    @Mapping(target = "reservation_history_id", source = "reservation.id")  
    HistorialPlanoDTO toHistorialPlanoDto(ReservationHistory reservationHistory);  
  
    // Modelo Full para Historial  
    HistorialFullResponseDTO toHistorialFullResponseDto(ReservationHistory reservationHistory);  
  
}
```

### ReservationMapper.java
```java
@Mapper (componentModel = "spring" , uses = {TotalMapper.class, HistorialMapper.class})  
public interface ReservationMapper {  
  
    Reservation toReservationDto(ReservationRequestDTO reservationRequestDTO);  
  
    ReservationResponseDTO toReservationResponseDto(Reservation reservation);  
  
    @Mapping(target = "user_id", source = "user.id")  
    @Mapping(target = "user_name", source = "user.name")  
    @Mapping(target = "user_email", source = "user.email")  
    @Mapping(target = "user_tel", source = "user.telephone")  
    @Mapping(target = "room_id", source = "room.id")  
    @Mapping(target = "room_type", source = "room.type")  
    @Mapping(target = "room_price", source = "room.price")  
    ReservationPlanoResponseDTO toReservationPlanoResponseDto(Reservation reservation);  
}
```

### RoomMapper.java
```java
@Mapper(componentModel = "spring")  
public interface RoomMapper {  
  
    Room toRoom (RoomRequestDTO roomRequestDTO);  
    RoomResponseDTO toRoomResponseDTO (Room room);  
}
```

### TotalMapper.java
```java
@Mapper (componentModel = "spring")  
public interface TotalMapper {  
  
    // Modelo full para reserva  
    @Mapping(target = "reservation_total_id", source = "reservation.id")  
    TotalResponseDTO toTotalResponseDTO(ReservationTotal reservationTotal);  
  
    // Modelo plano para reserva  
    @Mapping(target = "reservation_total_id", source = "reservation.id")  
    TotalPlanoDTO toDto(ReservationTotal total);  
  
    // Modelo full para Total  
    TotalFullResponseDTO toTotalFullResponseDTO(ReservationTotal reservationTotal);  
}
```

### UsuarioMapper.java
```java
@Mapper(componentModel = "spring")  
public interface UsuarioMapper {  
    User toUser (UsuarioRequestDTO usuarioRequestDTO);  
    UsuarioResponseDTO toUsuarioResponseDTO (User user);  
}
```
---
# Repository
### IHistoryRepo.java
```java
@Repository  
public interface IHistoryRepo extends JpaRepository<ReservationHistory, Long> {  
}
```
### IReservationRepo.java
```java
@Repository  
public interface IReservationRepo extends JpaRepository<Reservation, Long> {  
}
```
### IRoomRepo.java
```java
@Repository  
public interface IRoomRepo extends JpaRepository<Room, Long> { 
}
```
### ITotalRepo.java
```java
@Repository  
public interface ITotalRepo extends JpaRepository<ReservationTotal, Long> {  
}
```
### IUseRepo.java
```java
@Repository  
public interface IUserRepo extends JpaRepository<User, Long> { 
}
```
---
# Exception

## Exception/Errors
### ExDatNotFoundException.java
```java
public class ExDataNotFoundException extends RuntimeException {  
    public ExDataNotFoundException(String message) {  
        super(message);  
    }  
}
```
### GlobalExceptionHandler.java
```java
@RestControllerAdvice  
public class GlobalExceptionHandler {  
  
    // Constantes para keys de respuesta  
    private static final String MESSAGE = "message";  
    private static final String CODE = "code";  
    private static final String ERRORS = "errors";  
  
    //  
    @ExceptionHandler(ExDataNotFoundException.class)  
    public ResponseEntity<Map<String, Object>> handleDataNotFound(ExDataNotFoundException ex) {  
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);  
    }  
  
    // Metodo helper para respuestas consistentes  
    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {  
        Map<String, Object> response = new HashMap<>();  
        response.put(MESSAGE, message);  
        response.put(CODE, status.value());  
        return ResponseEntity.status(status).body(response);  
    }  
}
```
---
# Response
### ResponseDTO.java
```java
public record ResponseDTO(  
        String mensaje,  
        Object data  
) {}
```
### ResponseMessage.java
```java
@Getter  
public enum ResponseMessage {  
  
    SUCCESSFUL_ADDITION("Added successfully"),  
    SUCCESSFUL_MODIFICATION("Modification completed successfully"),  
    SUCCESSFUL_DELETION("Deletion completed successfully");  
  
    private final String message;  
  
    ResponseMessage(String message) {  
        this.message = message;  
    }  
}
```
---
# Page
### PageResponseDTO
```java
public record PageResponseDTO<T>(  
        List<T> content,  
        int page,  
        int size,  
        long totalElements,  
        int totalPages,  
        boolean isLast,  
        boolean isFirst,  
        int numberOfElements  
) {public PageResponseDTO(Page<T> page) {  
    this(page.getContent(),  
            page.getNumber(),  
            page.getSize(),  
            page.getTotalElements(),  
            page.getTotalPages(),  
            page.isLast(),  
            page.isFirst(),  
            page.getNumberOfElements());  
}  
}
```
---
# Service
### HistorialService.java
```java
public interface HistoriaService {  
    List<HistorialFullResponseDTO> listarHistorial();  
    HistorialFullResponseDTO buscarHistorial(Long id);  
}
```

### ReservationService.java
```java
public interface ReservationService {  
    // buscar  
    ReservationPlanoResponseDTO buscar(Long id);  
    // listar  
    List<ReservationPlanoResponseDTO> listarReservas();  
    // crear  
    ReservationResponseDTO crearReserva(ReservationRequestDTO reservationRequestDTO);  
}
```
### RoomService.java
```java
public interface RoomService {  
  
    List<RoomResponseDTO> listar();  
    RoomResponseDTO buscar(Long id);  
    RoomResponseDTO registrar(RoomRequestDTO room);  
    RoomResponseDTO actualizar(RoomRequestDTO room,Long id);  
    void eliminar(Long id);  
}
```

### TotalService.java
```java
public interface TotalService {  
  
    List<TotalFullResponseDTO> listarTotal();  
    TotalFullResponseDTO buscarTotal(Long id);  
}
```
### UserService.java
```java
public interface UserService {  
  
    List<UsuarioResponseDTO> listar();  
    UsuarioResponseDTO buscar(Long id);  
    UsuarioResponseDTO registrar(UsuarioRequestDTO usuario);  
    UsuarioResponseDTO actualizar(UsuarioRequestDTO usuario,Long id);  
    void eliminar(Long id);  
}
```
### Service/Impl
### HistoriasServiceImpl.java
```java
@Service  
@RequiredArgsConstructor  
public class HistoriasServiceImpl implements HistoriaService {  
    private final IHistoryRepo historyRepo;  
    private final HistorialMapper historialMapper;  
      
    @Override  
    public List<HistorialFullResponseDTO> listarHistorial() {  
        List<ReservationHistory> reservationHistories = historyRepo.findAll();  
        return reservationHistories.stream()  
                .map(reservationHistory -> historialMapper.toHistorialFullResponseDto(reservationHistory))  
                .toList();  
    }  
  
    @Override  
    public HistorialFullResponseDTO buscarHistorial(Long id) {  
        ReservationHistory reservationHistory = historyRepo.findById(id)  
                .orElseThrow(()-> new RuntimeException("Historial no encontrado : "+id));  
        return historialMapper.toHistorialFullResponseDto(reservationHistory);  
    }  
}
```

### ReservationServiceImpl.java
```java
@Service  
@RequiredArgsConstructor  
public class ReservationServiceImpl implements ReservationService {  
  
    // mapper  
    private final ReservationMapper reservationMapper;  
      
    // repos  
    private final IReservationRepo reservationRepo;  
  
    private final IRoomRepo roomRepo;  
    private final IUserRepo userRepo;  
  
    // metodos  
    private final ReservationCalculationService reservationCalculationService;  
  
    @Override  
    public ReservationPlanoResponseDTO buscar(Long id) {  
        Reservation reservation = reservationRepo.findById(id)  
                .orElseThrow(()-> new RuntimeException("Reservation with id " + id + " not found"));  
        return reservationMapper.toReservationPlanoResponseDto(reservation);  
    }  
  
    @Override  
    public List<ReservationPlanoResponseDTO> listarReservas() {  
        List<Reservation> reservations = reservationRepo.findAll();  
        return reservations.stream()  
                .map(reservation -> reservationMapper.toReservationPlanoResponseDto(reservation))  
                .toList();  
    }  
  
    @Transactional  
    @Override    public ReservationResponseDTO crearReserva(ReservationRequestDTO reservationRequestDTO) {  
  
        Reservation reservation = new Reservation();  
        reservation.setResv_start(reservationRequestDTO.resv_start());  
        reservation.setResv_end(reservationRequestDTO.resv_end());  
        reservation.setResv_status(reservationRequestDTO.resv_status());  
        reservation.setBill_name(reservationRequestDTO.bill_name());  
        reservation.setBill_email(reservationRequestDTO.bill_email());  
        reservation.setBill_telephone(reservationRequestDTO.bill_telephone());  
  
        // user id  
        User usuarioExiste = userRepo.findById(reservationRequestDTO.userId())  
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado :"+reservationRequestDTO.userId()));  
        reservation.setUser(usuarioExiste);  
  
        Room roomExiste = roomRepo.findById(reservationRequestDTO.roomId())  
                .orElseThrow(() -> new RuntimeException("Room no encontrado :"+reservationRequestDTO.roomId()));  
        reservation.setRoom(roomExiste);  
  
  
        // create automatico historials  
        List<ReservationHistory> histories = reservationRequestDTO.historials().stream()  
                .map(dto -> {  
                    ReservationHistory h = new ReservationHistory();  
                    h.setHistory_date(LocalDateTime.now());  
                    h.setHistory_status(dto.history_status());  
                    h.setHistory_notes(dto.history_notes());  
                    h.setReservation(reservation); // muy importante para la relación con Reservation  
                    return h;  
                })  
                .toList();  
        reservation.setHistorials(histories);  
  
        // create automatico totals  
        List<ReservationTotal> totals = reservationRequestDTO.totals().stream()  
                .map(dto ->{  
                    ReservationTotal t = new ReservationTotal();  
                    t.setTotal_title("Costo Total");  
  
                    // calcular totalamount  
                    BigDecimal precioRoom = roomExiste.getPrice();  
  
                    Integer cantDias = reservationCalculationService.calcularDias(reservation.getResv_start(), reservation.getResv_end());  
                    BigDecimal totalAmount = precioRoom.multiply(BigDecimal.valueOf(cantDias));  
                    t.setTotal_amount(totalAmount);  
                    t.setReservation(reservation);  
                    return t;  
                })  
                .toList();  
        reservation.setTotals(totals);  
  
        reservationRepo.save(reservation);  
        return reservationMapper.toReservationResponseDto(reservation);  
    }  
}
```
### RoomServiceImpl.java
```java
@Slf4j  
@Service  
@RequiredArgsConstructor  
public class RoomServiceImpl implements RoomService {  
  
    private final RoomMapper roomMapper;  
    private final IRoomRepo roomRepo;  
  
    @Override  
    public List<RoomResponseDTO> listar() {  
        List<Room> rooms = roomRepo.findAll();  
        return rooms.stream()  
                .map(room -> roomMapper.toRoomResponseDTO(room))  
                .toList();  
    }  
  
    @Override  
    public RoomResponseDTO buscar(Long id) {  
        Room model = roomRepo.findById(id).  
                orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));  
        return roomMapper.toRoomResponseDTO(model);  
    }  
  
    @Override  
    public RoomResponseDTO registrar(RoomRequestDTO roomRequestDTO) {  
        Room room = roomMapper.toRoom(roomRequestDTO);  
  
        roomRepo.save(room);  
        return roomMapper.toRoomResponseDTO(room);  
    }  
  
    @Override  
    public RoomResponseDTO actualizar(RoomRequestDTO roomRequestDTO, Long id) {  
        Room room = roomRepo.findById(id)  
                .orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));  
        room.setType(roomRequestDTO.type());  
        room.setPrice(roomRequestDTO.price());  
  
        roomRepo.save(room);  
        return roomMapper.toRoomResponseDTO(room);  
    }  
  
    @Override  
    public void eliminar(Long id) {  
        Room room = roomRepo.findById(id)  
                .orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));  
        roomRepo.delete(room);  
    }  
}
```

### TotalServiceImpl.java
```java
@Service  
@RequiredArgsConstructor  
public class TotalServiceImpl implements TotalService {  
  
    private final TotalMapper totalMapper;  
    private final ITotalRepo totalRepo;  
  
  
    @Override  
    public List<TotalFullResponseDTO> listarTotal() {  
        List<ReservationTotal> totals = totalRepo.findAll();  
        return totals.stream()  
                .map(reservationTotal -> totalMapper.toTotalFullResponseDTO(reservationTotal))  
                .toList();  
    }  
  
    @Override  
    public TotalFullResponseDTO buscarTotal(Long id) {  
        ReservationTotal total = totalRepo.findById(id)  
                .orElseThrow(() -> new ExDataNotFoundException("Reservation Total no encontrado : "+id));  
        return totalMapper.toTotalFullResponseDTO(total);  
    }  
}
```
### UsuarioServiceImpl
```java
@Slf4j  
@Service  
@RequiredArgsConstructor  
public class UsuarioServiceImpl  implements UserService {  
  
    private final UsuarioMapper usuarioMapper;  
    private final IUserRepo userRepo;  
  
    @Override  
    public List<UsuarioResponseDTO> listar() {  
        List<User> usuarios = userRepo.findAll();  
        return usuarios.stream()  
                .map(user -> usuarioMapper.toUsuarioResponseDTO(user))  
                .toList();  
    }  
  
    @Override  
    public UsuarioResponseDTO buscar(Long id) {  
        User user = userRepo.findById(id).  
                orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));  
        return usuarioMapper.toUsuarioResponseDTO(user);  
    }  
  
    @Override  
    public UsuarioResponseDTO registrar(UsuarioRequestDTO usuario) {  
        User user = usuarioMapper.toUser(usuario);  
  
        userRepo.save(user);  
        return usuarioMapper.toUsuarioResponseDTO(user);  
    }  
  
    @Override  
    public UsuarioResponseDTO actualizar(UsuarioRequestDTO usuario, Long id) {  
        User user = userRepo.findById(id)  
                .orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));  
        user.setName(usuario.name());  
        user.setEmail(usuario.email());  
        user.setPassword(usuario.password());  
        user.setRole(usuario.role());  
        user.setTelephone(usuario.telephone());  
        userRepo.save(user);  
        return usuarioMapper.toUsuarioResponseDTO(user);  
    }  
  
    @Override  
    public void eliminar(Long id) {  
        User user = userRepo.findById(id)  
                .orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));  
        userRepo.delete(user);  
    }  
}
```

---
# Controller
### HistorialController.java
```java
@RestController  
@RequestMapping("/api/historial")  
@RequiredArgsConstructor  
public class HistorialController {  
    private final HistoriaService historialService;  
  
    @GetMapping("/listar")  
    public ResponseEntity<List<HistorialFullResponseDTO>> listarHistorial() {  
        return ResponseEntity.ok(historialService.listarHistorial());  
    }  
  
    @GetMapping("/buscar/{id}")  
    public ResponseEntity<HistorialFullResponseDTO> buscarHistorial(@PathVariable Long id) {  
        return ResponseEntity.ok(historialService.buscarHistorial(id));  
    }  
}
```

### ReservationController.java
```java
@RestController  
@RequestMapping("/api/reserva")  
@RequiredArgsConstructor  
public class ReservationController {  
    private final ReservationService reservationService;  
  
    @GetMapping("/buscar/{id}")  
    public ResponseEntity<ReservationPlanoResponseDTO> buscar(@PathVariable Long id) {  
        return new ResponseEntity<>(reservationService.buscar(id), HttpStatus.OK);  
    }  
  
    @GetMapping("/listar")  
    public ResponseEntity<List<ReservationPlanoResponseDTO>> listar() {  
        return ResponseEntity.ok(reservationService.listarReservas());  
    }  
  
    @PostMapping("/registrar")  
    public ResponseEntity<ReservationResponseDTO> registrar(@RequestBody ReservationRequestDTO reservationRequestDTO) {  
        ReservationResponseDTO res = reservationService.crearReserva(reservationRequestDTO);  
        return ResponseEntity.status(HttpStatus.CREATED).body(res);  
    }  
}
```
### RoomController.java
```java
@RestController  
@RequestMapping("/api/room")  
@RequiredArgsConstructor  
public class RoomController {  
    private final RoomService roomService;  
  
    @GetMapping("/listar")  
    public ResponseEntity<List<RoomResponseDTO>> listar() {  
        return ResponseEntity.ok(roomService.listar());  
    }  
  
    @GetMapping("/buscar/{id}")  
    public ResponseEntity<RoomResponseDTO> buscar(@PathVariable Long id) {  
        return ResponseEntity.ok(roomService.buscar(id));  
    }  
  
    @PostMapping("/registrar")  
    public ResponseEntity<RoomResponseDTO> registrar(@RequestBody RoomRequestDTO roomRequestDTO) {  
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.registrar(roomRequestDTO));  
    }  
  
    @PutMapping("/modificar/{id}")  
    public ResponseEntity<RoomResponseDTO> modificar(@RequestBody RoomRequestDTO roomRequestDTO,@PathVariable Long id) {  
        return ResponseEntity.ok(roomService.actualizar(roomRequestDTO,id));  
    }  
  
    @DeleteMapping("/eliminar/{id}")  
    public ResponseEntity<RoomResponseDTO> eliminar(@PathVariable Long id) {  
        roomService.eliminar(id);  
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
    }  
}
```
### TotalController.java
```java
@RestController  
@RequestMapping("/api/total")  
@RequiredArgsConstructor  
public class TotalController {  
  
    private final TotalService totalService;  
  
    @GetMapping("/listar")  
    public ResponseEntity<List<TotalFullResponseDTO>> listarTotal() {  
        return ResponseEntity.ok(totalService.listarTotal());  
    }  
  
    @GetMapping("/buscar/{id}")  
    public ResponseEntity<TotalFullResponseDTO> buscarTotal(@PathVariable Long id) {  
        return ResponseEntity.ok(totalService.buscarTotal(id));  
    }  
}
```
### UserController.java
```java
@RestController  
@RequestMapping("/api/user")  
@RequiredArgsConstructor  
public class UserController {  
  
    private final UserService userService;  
  
    @GetMapping("/listar")  
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {  
        return ResponseEntity.status(HttpStatus.OK).body(userService.listar());  
    }  
  
    @GetMapping("/buscar/{id}")  
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {  
        return ResponseEntity.status(HttpStatus.OK).body(userService.buscar(id));  
    }  
  
    @PostMapping("/registrar")  
    public ResponseEntity<UsuarioResponseDTO> registrar(@RequestBody  UsuarioRequestDTO usuario) {  
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registrar(usuario));  
    }  
  
    @PutMapping("/modificar/{id}")  
    public ResponseEntity<UsuarioResponseDTO> modificar(@RequestBody UsuarioRequestDTO usuario,@PathVariable Long id) {  
        return ResponseEntity.status(HttpStatus.OK).body(userService.actualizar(usuario,id));  
    }  
    @DeleteMapping("/eliminar/{id}")  
    public ResponseEntity<UsuarioResponseDTO> eliminar(@PathVariable Long id) {  
        userService.eliminar(id);  
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
    }  
}
```