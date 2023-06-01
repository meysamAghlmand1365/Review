package azki.product.review.service;

import azki.product.review.dto.CommentDto;
import azki.product.review.dto.projection.RateProductView;
import azki.product.review.dto.request.FetchCommentRateRequest;
import azki.product.review.dto.projection.CommentProductView;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.GenericPageableList;
import azki.product.review.dto.ProductDto;
import azki.product.review.dto.request.RateCommentRequest;
import azki.product.review.dto.request.ReviewRequest;
import azki.product.review.dto.response.ProductReviewDetailResponse;
import org.springframework.transaction.annotation.Transactional;

public interface IReviewService {
    GenericPageableList<ProductDto> fetchAllRepresentableProducts(BasePageableRequestDto request);

    ProductReviewDetailResponse productReviewDetail(ReviewRequest request);

    @Transactional
    boolean registerCommentAndRate(RateCommentRequest request);

    GenericPageableList<CommentDto> fetchNotCheckedCommentt(FetchCommentRateRequest commentRequest);

    GenericPageableList<CommentProductView> fetchNotCheckedComment(FetchCommentRateRequest commentRequest);

    GenericPageableList<RateProductView> fetchNotCheckedRate(FetchCommentRateRequest request);
}
