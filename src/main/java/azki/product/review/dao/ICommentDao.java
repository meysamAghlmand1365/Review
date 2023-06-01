package azki.product.review.dao;

import azki.product.review.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {
    public Long countAllByStatusAndProductId(byte confirmStatus,Long productId);

    @Query(value = "select * from comment_tbl where status=1 and" +
            " product_id=?1 order by created_date desc limit ?2",nativeQuery = true)
    List<Comment> fetchTopNComment(long productId,int limit);


}
