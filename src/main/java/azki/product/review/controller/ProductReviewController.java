package azki.product.review.controller;


import azki.product.review.constant.ApiMethodNames;
import azki.product.review.dto.*;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.request.RateCommentRequest;
import azki.product.review.dto.request.ReviewRequest;
import azki.product.review.dto.response.ProductReviewDetailResponse;
import azki.product.review.service.ICommentService;
import azki.product.review.service.IRateService;
import azki.product.review.service.IReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static azki.product.review.constant.ApiServiceNames.REVIEW;

@RestController
@RequestMapping(path = REVIEW)
@RequiredArgsConstructor
public class ProductReviewController {

    private final IReviewService reviewService;

    private final ICommentService commentService;

    private final IRateService rateService;

    @GetMapping(path = ApiMethodNames.FETCH_ALL_PRODUCTS)
    public ResponseEntity<GenericPageableList<ProductDto>> fetchAllRepresentableProducts(@RequestBody BasePageableRequestDto request){
        return new ResponseEntity<>(reviewService.fetchAllRepresentableProducts(request), HttpStatus.OK);
    }

    @GetMapping(path = ApiMethodNames.FETCH_PRODUCT_REVIEW_DETAIL)
    public ResponseEntity<ProductReviewDetailResponse> fetchProductReviewDetail(@Valid @RequestBody  ReviewRequest request){
        return new ResponseEntity<>(reviewService.productReviewDetail(request), HttpStatus.OK);
    }

    @GetMapping(path = ApiMethodNames.FETCH_NOT_CHECKED_COMMENT)
    public ResponseEntity<GenericPageableList<CommentDto>> fetchNotCheckedComment(@RequestBody FetchCommentRequest request){
        return new ResponseEntity<>(reviewService.fetchNotCheckedComment(request), HttpStatus.OK);
    }

    @PostMapping(path = ApiMethodNames.REGISTER_COMMENT_AND_RATE)
    public ResponseEntity<Boolean> registerCommentAndRateNumber(@Valid @RequestBody RateCommentRequest request){
        return new ResponseEntity<>( reviewService.registerCommentAndRate(request),HttpStatus.OK);
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("id") long id,@RequestBody CommentDto dto){
        return new ResponseEntity<>(commentService.updateComment(id,dto),HttpStatus.OK);
    }

    @PutMapping("/rate/{id}")
    public ResponseEntity<RateDto> updateComment(@PathVariable("id") long id,@RequestBody RateDto dto){
        return new ResponseEntity<>(rateService.updateRate(id,dto),HttpStatus.OK);
    }


}
