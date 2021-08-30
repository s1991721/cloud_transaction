package com.work.order.controller;

import com.jef.transaction.spring.annotation.GlobalTransactionalInterceptor;
import com.jef.transaction.tm.api.DefaultFailureHandlerImpl;
import com.work.order.feign.StorageFeignClient;
import com.work.order.service.OrderService;
import com.work.order.service.OrderServiceJar;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private StorageFeignClient storageFeignClient;


    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @RequestMapping("/placeOrder/commit")
    public Boolean placeOrderCommit() {

        Object instance = new OrderServiceJar();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(instance);
        proxyFactory.addAdvice(new GlobalTransactionalInterceptor(new DefaultFailureHandlerImpl()));

        instance = proxyFactory.getProxy();
        try {
            Method method = OrderServiceJar.class.getMethod("placeOrder");
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        orderService.placeOrder("1", "product-1", 1);
        return true;
    }

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @RequestMapping("/placeOrder/rollback")
    public Boolean placeOrderRollback() {
        // product-2 扣库存时模拟了一个业务异常,
        orderService.placeOrder("1", "product-2", 1);
        return true;
    }


    @RequestMapping("/placeOrder")
    public Boolean placeOrder(String userId, String commodityCode, Integer count) {
        orderService.placeOrder(userId, commodityCode, count);
        return true;
    }
}
