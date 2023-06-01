package azki.product.review.service;

import azki.product.review.dto.RateDto;
import azki.product.review.dto.projection.RateProductView;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.request.FetchCommentRateRequest;
import azki.product.review.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;


public interface IRateService {
    Double getAverageRateOfConfirmedRate(long productId);

    Rate saveRate(RateDto rateDto);

    Page<RateDto> fetchRate(Specification<Rate> specification, BasePageableRequestDto dto);

    Page<RateProductView> fetchRate(FetchCommentRateRequest request);

    RateDto updateRate(Long id, RateDto rateDto);
}
