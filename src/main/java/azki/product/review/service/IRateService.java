package azki.product.review.service;

import azki.product.review.dto.RateDto;
import azki.product.review.entity.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface IRateService {
    Double getAverageRateOfConfirmedRate(long productId);

    Rate saveRate(RateDto rateDto);
}
