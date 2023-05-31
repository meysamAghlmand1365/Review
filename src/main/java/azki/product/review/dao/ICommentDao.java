package azki.product.review.dao;

import azki.product.review.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment_tbl where confirm_status=true and" +
            " product_id=?1 order by created_date desc limit ?2",nativeQuery = true)
    List<Comment> fetchTopNComment(long productId,int count);
    public Long countAllByConfirmStatusTrue();


}