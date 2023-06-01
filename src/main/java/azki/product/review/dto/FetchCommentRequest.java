package azki.product.review.dto;

import azki.product.review.dto.request.BasePageableRequestDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FetchCommentRequest extends BasePageableRequestDto {

     private LocalDate fromDate;
     private LocalDate toDate;
}
