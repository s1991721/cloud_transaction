package com.work.order.service;

import com.jef.transaction.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;

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
public class OrderServiceJar {


    /**
     * 下单：创建订单、减库存，涉及到两个服务
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder() {
        System.out.println("aaaaaaa");
    }

}
