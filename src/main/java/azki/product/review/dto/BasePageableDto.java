package azki.product.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BasePageableDto {
    private int pageNum;
    private int pageSize=5;
}
