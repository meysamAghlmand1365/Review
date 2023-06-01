package azki.product.review.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FetchCommentRateRequest extends BasePageableRequestDto {

     private LocalDate fromDate;
     private LocalDate toDate;
}
