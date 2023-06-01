package azki.product.review.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CommentDto {


    private Long id;


    private LocalDate createdDate;
    private LocalTime createdTime;
    private byte status;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;



}
