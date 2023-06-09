package azki.product.review.dao.specification;

import azki.product.review.entity.Comment;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

import static azki.product.review.constant.StateValue.STATE_NOT_CHECKED;

public class CommentSpecifications {

    public static Specification<Comment> notChecked(){
        return (root,query,builder)->{
            return builder.equal(root.get("status"), STATE_NOT_CHECKED);
        };
    }

    public static Specification<Comment> productIdIs(Long productId){
        return (root,query,builder)->{
            return builder.equal(root.get("productId"), STATE_NOT_CHECKED);
        };
    }

    public static Specification<Comment> fromDate(LocalDate date){
        return (root,query,builder)->{
            if(date!=null){
                return builder.greaterThanOrEqualTo(root.get("createdDate"),date);
            }
            return null;
        };
    }

    public static Specification<Comment> toDate(LocalDate date){
        return (root,query,builder)->{
            if(date!=null){
                return builder.lessThanOrEqualTo(root.get("createdDate"),date);
            }
            return null;
        };
    }
}
