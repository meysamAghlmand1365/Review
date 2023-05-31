package azki.product.review.service.impl;

import azki.product.review.dao.IProductDao;
import azki.product.review.dto.*;
import azki.product.review.dto.request.RateCommentRequest;
import azki.product.review.dto.request.ReviewRequest;
import azki.product.review.dto.response.ProductReviewDetailResponse;
import azki.product.review.service.ICommentService;
import azki.product.review.service.IOrderService;
import azki.product.review.service.IRateService;
import azki.product.review.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService {
    private final IProductDao productDao;

    private final ICommentService commentService;

    private final IRateService rateService;

    private final IOrderService orderService;

    private final ModelMapper mapper;

    @Override
    public GenericPageableList<ProductDto> fetchAllRepresentableProducts(BasePageableDto request){
            return new GenericPageableList<>(productDao
                    .findProductsByRepresentableTrue(request!=null?PageRequest.of(request.getPageNum(),request.getPageSize()):PageRequest.of(0,5))
                    .stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList()));
    }





    @Override
    public ProductReviewDetailResponse productReviewDetail(ReviewRequest request){

        ProductReviewDetailResponse response=fetchLatestCommentAndRate(request.getProductId(),request.getNTopRow()>0? request.getNTopRow() : 3);
        if(!request.isPublicCommentActive()||!request.isPublicRateActive()){

            boolean existUserOrder=orderService.existUserOrderForProduct(request.getUserId(), request.getProductId());

            if(!request.isPublicCommentActive()){
                response.setCommentAllowed(existUserOrder);
            }

            if(!request.isPublicRateActive()){
                response.setRateAllowed(existUserOrder);
            }
        }else{
            response.setCommentAllowed(true);
            response.setRateAllowed(true);
        }
        return response;
    }


    private ProductReviewDetailResponse fetchLatestCommentAndRate(Long productId, int count){
        ProductReviewDetailResponse response=new ProductReviewDetailResponse();
        response.setCommentDtos(commentService.fetchTopNComment(productId,count));
        response.setCommentCount(commentService.countAllConfirmedComment());
        response.setRateAverage(rateService.getAverageRateOfConfirmedRate(productId));
        return response;
    }


    @Transactional
    @Override
    public boolean registerCommentAndRate(RateCommentRequest request){
         if(request.getCommentDto()!=null){
             commentService.saveComment(request.getCommentDto());
         }

         if(request.getRateDto()!=null){
             rateService.saveRate(request.getRateDto());
         }
         return true;
    }










}
