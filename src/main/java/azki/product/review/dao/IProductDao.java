package azki.product.review.dao;

import azki.product.review.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductDao extends JpaRepository<Product,Long> {
    Page<Product> findProductsByRepresentableTrue(Pageable pageable);

}
