package com.abin.lee.thrift.rpc.skeleton.facade;

import com.abin.lee.thrift.rpc.api.OrderService;
import com.abin.lee.thrift.rpc.model.OrderInfo;
import com.abin.lee.thrift.rpc.model.TeamInfo;
import com.google.common.collect.Lists;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by abin on 2017/9/9 2017/9/9.
 * thrift-rpc1
 * com.abin.lee.thrift.rpc.skeleton.facade
 */
public class OrderServiceImpl implements OrderService.Iface {
    @Override
    public List<Long> findById(long id) throws TException {
        List<Long> list = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            list.add(111111111111111111L+i);
        }
        return list;
    }

    @Override
    public OrderInfo findOrderById(long id) throws TException {
        OrderInfo order = new OrderInfo();
        order.setSource("SYSTEM");
        order.setOrderId(10000000000000000L);
        order.setOrderName("大仙桃");
        order.setOrderPrice(157.23);
        order.setOrderInventory(500);
        return order;
//        return null;
    }

    @Override
    public long findBysource(String source) throws TException {
        return 0;
    }

    @Override
    public double findPriceById(long id) throws TException {
        return 0;
    }

    @Override
    public List<OrderInfo> findListById(long id) throws TException {
        return null;
    }

    @Override
    public void insert(OrderInfo orderInfo) throws TException {

    }

    @Override
    public OrderInfo findOrderByIdAndSource(long id, String source) throws TException {
        return null;
    }

    @Override
    public void update(OrderInfo orderInfo) throws TException {

    }
}
