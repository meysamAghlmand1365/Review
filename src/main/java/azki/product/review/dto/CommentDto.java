package azki.product.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {


    private long id;

    private LocalDateTime createdDate;
    private Boolean confirmStatus;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;



}
