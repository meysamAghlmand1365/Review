package azki.product.review.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;
    @Column(name = "order_status")
    private Byte orderStatus;

    @Column(name = "created_date")
    private LocalDate createdDate;



}
