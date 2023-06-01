package azki.product.review.service;

import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.CommentDto;
import azki.product.review.dto.GenericPageableList;
import azki.product.review.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ICommentService {
    List<CommentDto> fetchTopNComment(long productId, int limit);

    Long countAllConfirmedComment(Long productId);

    Comment saveComment(CommentDto dto);

    //GenericPageableList<Comment> fetchAllNotCheckedComment(BasePageableRequestDto dto);

    Page<CommentDto> fetchComment(Specification<Comment> specification, BasePageableRequestDto dto);
}
