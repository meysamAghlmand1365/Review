package azki.product.review.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_id")
    private long providerId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "representable")
    private boolean representable;
    @Column(name = "public_comment_active")
    private boolean publicCommentActive;
    @Column(name = "public_rate_active")
    private boolean publicRateActive;
}
