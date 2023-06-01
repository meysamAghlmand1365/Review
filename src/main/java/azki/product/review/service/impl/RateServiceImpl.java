package azki.product.review.service.impl;

import azki.product.review.constant.ErrorMessage;
import azki.product.review.dao.IRateDao;
import azki.product.review.dto.RateDto;
import azki.product.review.dto.projection.RateProductView;
import azki.product.review.dto.request.BasePageableRequestDto;
import azki.product.review.dto.request.FetchCommentRateRequest;
import azki.product.review.entity.Rate;
import azki.product.review.service.IRateService;
import azki.product.review.util.PageRequestBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static azki.product.review.constant.StateValue.STATE_NOT_CHECKED;

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
    public Rate saveRate( RateDto rateDto){
        rateDto.setId(null);
        rateDto.setStatus(STATE_NOT_CHECKED);
        return rateDao.saveAndFlush(modelMapper.map(rateDto,Rate.class));
    }

    @Override
    public Page<RateDto> fetchRate(Specification<Rate> specification, BasePageableRequestDto dto){
        return rateDao.findAll(Specification.where(specification),PageRequestBuilder.buildPageRequest(dto)).map(a->modelMapper.map(a,RateDto.class));
    }


    @Override
    public Page<RateProductView> fetchRate(FetchCommentRateRequest request){
        return rateDao.fetchRateProduct(request.getFromDate()!=null?request.getFromDate().toString():null,
                request.getToDate()!=null?request.getToDate().toString():null,
                PageRequestBuilder.buildPageRequest(request));
    }

    @Override
    public RateDto updateRate(Long id, RateDto rateDto){
        Optional<Rate> rate =rateDao.findById(id);
        if(rate.isPresent()){
            rate.get().setStatus(rateDto.getStatus());
            return modelMapper.map(rateDao.saveAndFlush(rate.get()),RateDto.class);
        }else{
            throw new EntityNotFoundException(ErrorMessage.ID+id.toString()+ ErrorMessage.NOT_FOUND);
        }
    }
}
