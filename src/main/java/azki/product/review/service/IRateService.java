package azki.product.review.service;

import azki.product.review.dto.RateDto;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.entity.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


public interface IRateService {
    Double getAverageRateOfConfirmedRate(long productId);

    Rate saveRate(RateDto rateDto);

    Page<RateDto> fetchComment(Specification<Rate> specification, BasePageableRequestDto dto);

    RateDto updateRate(Long id, RateDto rateDto);
}
