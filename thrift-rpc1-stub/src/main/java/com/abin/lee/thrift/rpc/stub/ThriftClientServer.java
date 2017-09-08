package com.abin.lee.thrift.rpc.stub;

import com.abin.lee.thrift.rpc.api.CouponService;
import com.abin.lee.thrift.rpc.api.OrderService;
import com.abin.lee.thrift.rpc.api.TeamService;
import com.abin.lee.thrift.rpc.common.util.JsonUtil;
import com.abin.lee.thrift.rpc.enums.BusinessRoleEnum;
import com.abin.lee.thrift.rpc.model.Business;
import com.abin.lee.thrift.rpc.model.CouponInfo;
import com.abin.lee.thrift.rpc.model.OrderInfo;
import com.abin.lee.thrift.rpc.model.TeamInfo;
import com.abin.lee.thrift.rpc.stub.callback.StubCallback;
import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TSocket;

import java.io.IOException;
import java.util.List;

/**
 * Created by abin on 2017/9/7 14:20.
 * march-svr
 * com.abin.lee.march.svr.thrift.client
 */
public class ThriftClientServer {
    private static final String HOST = "localhost" ;
    private static final Integer PORT = 30000 ;
    private static final Integer clientTimeout = 60000 ;

    public static void main(String[] args) throws TException, InterruptedException {
        //synchronous
        main_sync();
        //asynchronous
//        main_async();
    }


    public static void main_sync() throws TException {
        TSocket transport = new TSocket(HOST, PORT);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        TMultiplexedProtocol teamProtocol = new TMultiplexedProtocol(protocol, "TeamService");
        TeamService.Client teamService = new TeamService.Client(teamProtocol);

        TMultiplexedProtocol orderProtocol = new TMultiplexedProtocol(protocol,"OrderService");
        OrderService.Client orderService = new OrderService.Client(orderProtocol);

        TMultiplexedProtocol couponProtocol = new TMultiplexedProtocol(protocol,"CouponService");
        CouponService.Client couponService = new CouponService.Client(couponProtocol);

        transport.open();

        //------------------------------------TeamService----------------------------------------------
        System.out.println("------------------------------------TeamService----------------------------------------------start-----");
        List<TeamInfo> teamInfoList = teamService.findTeamListById(5L);
        System.out.println("teamInfoList= : " + JsonUtil.toJson(teamInfoList));
        TeamInfo teamInfo = teamService.findTeamById(5L);
        System.out.println("teamInfo= : " + JsonUtil.toJson(teamInfo));
        long price1 = teamService.findByIdAndType(5L, "SYSTEM");
        System.out.println("price1= : " + price1);
        double price2 = teamService.findById(5L);
        System.out.println("price2= : " + price2);
        BusinessRoleEnum businessRoleEnum = teamService.findByBid(5L);
        System.out.println("businessRoleEnum= : " + businessRoleEnum);

        Business business = new Business();
        business.setAccountId(10000000000000000L);
        business.setBusinessId(20000000000000000L);
        business.setBusinessAddress("Los Angeles");
        business.setBusinessName("Holly Wood");
        business.setContractId(30000000000000000L);
        ;
        teamService.insert(business);

        Business businessResult = teamService.findBusinessByBid(5L);
        System.out.println("businessResult= : " + businessResult);
        System.out.println("------------------------------------TeamService----------------------------------------------end-----");
        //------------------------------------TeamService----------------------------------------------

        //------------------------------------OrderService----------------------------------------------
        System.out.println("------------------------------------OrderService----------------------------------------------start-----");
        List<Long> orderList = orderService.findById(5L);
        System.out.println("orderList= : " + JsonUtil.toJson(orderList));
        OrderInfo orderInfo = orderService.findOrderById(5L);
        System.out.println("orderInfo= : " + JsonUtil.toJson(orderInfo));
        System.out.println("------------------------------------OrderService----------------------------------------------end-----");
        //------------------------------------OrderService----------------------------------------------

        //------------------------------------OrderService----------------------------------------------
        System.out.println("------------------------------------CouponService----------------------------------------------start-----");
        List<Long> couponList = couponService.findById(5L);
        System.out.println("couponList= : " + JsonUtil.toJson(couponList));
        CouponInfo couponInfo = couponService.findCouponById(5L);
        System.out.println("couponInfo= : " + JsonUtil.toJson(couponInfo));
        System.out.println("------------------------------------CouponService----------------------------------------------end-----");
        //------------------------------------OrderService----------------------------------------------


        transport.close();
    }


    public static void main_async() throws TException, InterruptedException {
        try {
            TAsyncClientManager clientManager = new TAsyncClientManager();
            TNonblockingTransport transport = new TNonblockingSocket(HOST, PORT, clientTimeout);
            TProtocolFactory protocol = new TCompactProtocol.Factory();
            TeamService.AsyncClient asyncClient = new TeamService.AsyncClient(protocol, clientManager, transport);
            System.out.println("Client calls .....");
            StubCallback callBack = new StubCallback();
            asyncClient.findTeamById(5L, callBack);

            while (true) {
                Thread.sleep(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
