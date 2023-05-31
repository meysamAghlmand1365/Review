package azki.product.review.service.impl;

import azki.product.review.dao.IOrderDao;
import azki.product.review.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IOrderDao orderDao;


    @Override
    public boolean existUserOrderForProduct(long userId, long productId){
        return orderDao.findAnyUserOrderForProduct(userId, productId) != null;
    }
}
