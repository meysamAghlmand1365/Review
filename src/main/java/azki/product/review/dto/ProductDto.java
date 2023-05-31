package azki.product.review.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private long providerId;
    private String name;
    private String description;
    private boolean representable;
    private boolean publicCommentActive;
    private boolean publicRateActive;
 }
