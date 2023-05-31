package azki.product.review.service;

public interface IOrderService {
    boolean existUserOrderForProduct(long userId, long productId);
}
