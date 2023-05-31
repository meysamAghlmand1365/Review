package azki.product.review.dao;

import azki.product.review.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Long> {
}
