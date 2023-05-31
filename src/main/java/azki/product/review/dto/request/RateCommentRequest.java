package azki.product.review.dto.request;

import azki.product.review.dto.CommentDto;
import azki.product.review.dto.RateDto;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;

@Getter
public class RateCommentRequest {

    @Valid
    private RateDto rateDto;

    @Valid
    private CommentDto commentDto;
}
