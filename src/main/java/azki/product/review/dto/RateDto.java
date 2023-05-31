package azki.product.review.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateDto {

    private long id;
    private LocalDateTime createdDate;
    private Boolean confirmStatus ;


    private int rateNumber    ;


    private Long userId  ;

    @NotNull
    private Long productId ;


}
