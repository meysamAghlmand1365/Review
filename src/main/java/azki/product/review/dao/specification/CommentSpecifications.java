package azki.product.review.dao.specification;

import azki.product.review.entity.Comment;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class CommentSpecifications {

    public static Specification<Comment> notChecked(){
        return (root,query,builder)->{
            return root.get("confirmStatus").isNull();
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
