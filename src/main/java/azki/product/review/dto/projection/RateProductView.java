package azki.product.review.dto.projection;

import java.time.LocalDate;
import java.time.LocalTime;

public interface RateProductView {


    public Long getId();

    public LocalDate getCreated_date();

    public LocalTime getCreated_time();

    public byte getStatus() ;

    public String getRate_number();

    public Long getUser_id();

    public Long getProduct_id();
}
