package azki.product.review.service;

import azki.product.review.dto.CommentDto;
import azki.product.review.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<CommentDto> fetchTopNComment(long productId, int count);

    Long countAllConfirmedComment();

    Comment saveComment(CommentDto dto);
}
