package azki.product.review.util;

import azki.product.review.dto.request.BasePageableRequestDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageRequestBuilder {

    public static Pageable buildPageRequest(BasePageableRequestDto request){
        if(request.getPageNum()>=0&&request.getPageSize()>0){
            return PageRequest.of(request.getPageNum(), request.getPageSize());
        }
        return PageRequest.of(0,5);
    }
}
