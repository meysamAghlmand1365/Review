package azki.product.review.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "provider_tbl")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
}
