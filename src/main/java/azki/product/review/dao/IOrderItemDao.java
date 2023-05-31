package azki.product.review.dao;

import azki.product.review.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemDao extends JpaRepository<OrderItem,Long> {
}
