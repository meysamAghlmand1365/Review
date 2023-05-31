package azki.product.review.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRequest {

    @NotNull
    private Long productId;

    private Long userId;
    private boolean publicCommentActive;
    private boolean publicRateActive;

    private int nTopRow;
}
