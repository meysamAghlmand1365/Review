package azki.product.review.dao;

import azki.product.review.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderDao extends JpaRepository<Order,Long> {

    @Query(value = "select id from order_tbl otb where user_id=?1 and " +
            "exists(select id from order_item_tbl where order_id=otb.id and product_id=?2) limit 1",nativeQuery = true)
    public Long findAnyUserOrderForProduct(long userId,long productId);
}
