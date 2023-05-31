package azki.product.review.service.impl;

import azki.product.review.dao.IRateDao;
import azki.product.review.dto.RateDto;
import azki.product.review.entity.Rate;
import azki.product.review.service.IRateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements IRateService {

    private final IRateDao rateDao;

    private final ModelMapper modelMapper;

    @Override
    public Double getAverageRateOfConfirmedRate(long productId){
        return rateDao.getAverageRate(productId);
    }

    @Override
    public Rate saveRate(RateDto rateDto){
        rateDto.setConfirmStatus(null);
        return rateDao.saveAndFlush(modelMapper.map(rateDto,Rate.class));
    }
}
