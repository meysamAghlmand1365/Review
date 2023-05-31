package azki.product.review.dto.response;

import azki.product.review.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ProductReviewDetailResponse {
    List<CommentDto> commentDtos;
    long commentCount;

    Double rateAverage;

    boolean commentAllowed;
    boolean rateAllowed;
}
