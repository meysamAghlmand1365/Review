package azki.product.review.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class RateDto {

    private Long id;
    private LocalDate createdDate;
    private LocalTime createdTime;
    private Boolean confirmStatus ;


    private int rateNumber    ;

    @NotNull
    private Long userId  ;

    @NotNull
    private Long productId ;


}
