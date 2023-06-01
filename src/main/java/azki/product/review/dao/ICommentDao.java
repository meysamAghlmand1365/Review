package azki.product.review.dao;

import azki.product.review.dto.projection.CommentProductView;
import azki.product.review.entity.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {
    public Long countAllByStatusAndProductId(byte confirmStatus,Long productId);

    @Query(value = "select * from comment_tbl where status=1 and" +
            " product_id=?1 order by created_date desc limit ?2",nativeQuery = true)
    List<Comment> fetchTopNComment(long productId,int limit);

    @Query(value = "select comment_tbl.*,product_tbl.name from comment_tbl inner join product_tbl on comment_tbl.product_id=product_tbl.id and comment_tbl.status=0" +
            " and (:fromDate is null or comment_tbl.created_date> :fromDate) and (:toDate is null or comment_tbl.created_date< :toDate)",nativeQuery = true)
    Page<CommentProductView> fetchCommentProduct(@Param("fromDate") String fromDate, @Param("toDate") String toDate, Pageable pageable);


}
