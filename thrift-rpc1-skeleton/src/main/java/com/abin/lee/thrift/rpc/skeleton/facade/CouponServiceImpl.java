package com.abin.lee.thrift.rpc.skeleton.facade;

import com.abin.lee.thrift.rpc.api.CouponService;
import com.abin.lee.thrift.rpc.model.CouponInfo;
import com.abin.lee.thrift.rpc.model.OrderInfo;
import com.google.common.collect.Lists;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by abin on 2017/9/9 2017/9/9.
 * thrift-rpc1
 * com.abin.lee.thrift.rpc.skeleton.facade
 */
public class CouponServiceImpl implements CouponService.Iface {

    @Override
    public List<Long> findById(long id) throws TException {
        List<Long> list = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            list.add(111111111111111111L+i);
        }
        return list;
    }

    @Override
    public CouponInfo findCouponById(long id) throws TException {
        CouponInfo coupon = new CouponInfo();
        coupon.setSource("SYSTEM");
        coupon.setCouponId(10000000000000000L);
        coupon.setCouponName("大仙桃");
        coupon.setCouponPrice(157.23);
        coupon.setCouponInventory(500);
        return coupon;
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
    public List<CouponInfo> findListById(long id) throws TException {
        return null;
    }

    @Override
    public void insert(CouponInfo coupon) throws TException {

    }

    @Override
    public CouponInfo findCouponByIdAndSource(long id, String source) throws TException {
        return null;
    }
}
