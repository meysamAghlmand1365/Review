package azki.product.review.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class CommentDto {


    private Long id;

    private LocalDate createdDate;
    private LocalTime createdTime;
    private Boolean confirmStatus;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;



}
