package azki.product.review.service.impl;

import azki.product.review.dao.IProductDao;
import azki.product.review.dao.specification.CommentSpecifications;
import azki.product.review.dto.*;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.request.RateCommentRequest;
import azki.product.review.dto.request.ReviewRequest;
import azki.product.review.dto.response.ProductReviewDetailResponse;
import azki.product.review.entity.Comment;
import azki.product.review.entity.Product;
import azki.product.review.service.ICommentService;
import azki.product.review.service.IOrderService;
import azki.product.review.service.IRateService;
import azki.product.review.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
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
    public GenericPageableList<ProductDto> fetchAllRepresentableProducts(BasePageableRequestDto request){
        Page<Product> pages =productDao.findProductsByRepresentableTrue(request!=null?PageRequest.of(request.getPageNum(),request.getPageSize()):PageRequest.of(0,5));

        return new GenericPageableList<>(pages.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList()),pages.getTotalPages(),pages.getTotalElements());

    }





    @Override
    public ProductReviewDetailResponse productReviewDetail(ReviewRequest request){

        ProductReviewDetailResponse response=fetchLatestCommentAndRate(request.getProductId(),request.getNTopRow()>0? request.getNTopRow() : 3);
        if(!request.isPublicCommentActive()||!request.isPublicRateActive()){
            if(request.getUserId()!=null){
                boolean existUserOrder=orderService.existUserOrderForProduct(request.getUserId(), request.getProductId());

                if(!request.isPublicCommentActive()){
                    response.setCommentAllowed(existUserOrder);
                }

                if(!request.isPublicRateActive()){
                    response.setRateAllowed(existUserOrder);
                }
            }
        }else{
            response.setCommentAllowed(true);
            response.setRateAllowed(true);
        }
        return response;
    }


    private ProductReviewDetailResponse fetchLatestCommentAndRate(Long productId, int limit){
        ProductReviewDetailResponse response=new ProductReviewDetailResponse();
        response.setCommentDtos(commentService.fetchTopNComment(productId,limit));
        response.setCommentCount(commentService.countAllConfirmedComment(productId));
        response.setRateAverage(rateService.getAverageRateOfConfirmedRate(productId));
        return response;
    }


    @Transactional
    @Override
    public boolean registerCommentAndRate( RateCommentRequest request){
         if(request.getCommentDto()!=null){

             commentService.saveComment(request.getCommentDto());
         }

         if(request.getRateDto()!=null){
             rateService.saveRate(request.getRateDto());
         }
         return true;
    }

    @Override
    public GenericPageableList<CommentDto> fetchNotCheckedComment(FetchCommentRequest commentRequest){
        Page<CommentDto> page=commentService.fetchComment(CommentSpecifications.notChecked().and(CommentSpecifications.fromDate(commentRequest.getFromDate())),commentRequest);
        return new GenericPageableList<>(page.toList(),page.getTotalPages(), page.getTotalElements());
    }








}
