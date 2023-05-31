package azki.product.review.dao;

import azki.product.review.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRateDao extends JpaRepository<Rate,Long> {

    @Query(value = "select AVG(rate_number) from rate_tbl where confirm_status=true and product_id=?1",nativeQuery = true)
    public Double getAverageRate(long productId);
}
