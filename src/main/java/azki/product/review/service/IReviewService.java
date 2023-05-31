package azki.product.review.service;

import azki.product.review.dto.BasePageableDto;
import azki.product.review.dto.GenericPageableList;
import azki.product.review.dto.ProductDto;
import azki.product.review.dto.request.RateCommentRequest;
import azki.product.review.dto.request.ReviewRequest;
import azki.product.review.dto.response.ProductReviewDetailResponse;
import org.springframework.transaction.annotation.Transactional;

public interface IReviewService {
    GenericPageableList<ProductDto> fetchAllRepresentableProducts(BasePageableDto request);

    ProductReviewDetailResponse productReviewDetail(ReviewRequest request);

    @Transactional
    boolean registerCommentAndRate(RateCommentRequest request);
}
