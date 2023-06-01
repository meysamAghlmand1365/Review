package azki.product.review.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "comment_tbl")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    @Column(name = "confirm_status")
    private Boolean confirmStatus;
    @Column(name = "content")
    private String content;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "created_time" )
    private LocalTime createdTime;

}
