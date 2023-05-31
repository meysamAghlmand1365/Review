package azki.product.review.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_item_tbl")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "order_id")
    private long orderId;
    @Column(name = "product_id")
    private long productId ;
    @Column(name = "quantity")
    private int quantity;
}
