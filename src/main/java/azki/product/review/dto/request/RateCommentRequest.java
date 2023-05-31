package azki.product.review.dto.request;

import azki.product.review.dto.CommentDto;
import azki.product.review.dto.RateDto;
import lombok.Getter;

@Getter
public class RateCommentRequest {
    private RateDto rateDto;
    private CommentDto commentDto;
}
