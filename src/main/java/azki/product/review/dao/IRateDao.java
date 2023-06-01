package azki.product.review.dao;

import azki.product.review.dto.projection.RateProductView;
import azki.product.review.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRateDao extends JpaRepository<Rate,Long>, JpaSpecificationExecutor<Rate> {


    @Query(value = "select AVG(rate_number) from rate_tbl where status=1 and product_id=?1",nativeQuery = true)
    public Double getAverageRate(long productId);


    @Query(value = "select rate_tbl.*,product_tbl.name from rate_tbl inner join product_tbl on rate_tbl.product_id=product_tbl.id and rate_tbl.status=0" +
            " and (:fromDate is null or rate_tbl.created_date> :fromDate) and (:toDate is null or rate_tbl.created_date< :toDate)",nativeQuery = true)
    Page<RateProductView> fetchRateProduct(@Param("fromDate") String fromDate, @Param("toDate") String toDate, Pageable pageable);
}
