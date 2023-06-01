package azki.product.review.dto;

import azki.product.review.dto.response.BasePageableResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenericPageableList<T> extends BasePageableResponseDto {
    List<T> responseList;

    public GenericPageableList(List<T> responseList,int totalPage,long totalElement){
        super(totalPage,totalElement);
        this.responseList=responseList;
    }


}
