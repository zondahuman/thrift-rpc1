package com.abin.lee.thrift.rpc.skeleton;

import com.abin.lee.thrift.rpc.api.CouponService;
import com.abin.lee.thrift.rpc.api.OrderService;
import com.abin.lee.thrift.rpc.api.TeamService;
import com.abin.lee.thrift.rpc.skeleton.facade.CouponServiceImpl;
import com.abin.lee.thrift.rpc.skeleton.facade.OrderServiceImpl;
import com.abin.lee.thrift.rpc.skeleton.facade.TeamServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.*;

/**
 * Created by abin on 2017/9/7 14:19.
 * march-svr
 * com.abin.lee.march.svr.thrift.server
 */
public class ThriftServer {

    public static void main(String[] args) throws TTransportException {
        //synchronous
        main_sync();
        //asynchronous
//        main_async();
    }


    public static void main_sync() throws TTransportException {
        TMultiplexedProcessor processor = new TMultiplexedProcessor();

        TServerTransport transport = new TServerSocket(30000);
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(transport).processor(processor));

        processor.registerProcessor("TeamService", new TeamService.Processor<TeamService.Iface>(new TeamServiceImpl()));
        processor.registerProcessor("OrderService", new OrderService.Processor<OrderService.Iface>(new OrderServiceImpl()));
        processor.registerProcessor("CouponService", new CouponService.Processor<CouponService.Iface>(new CouponServiceImpl()));

//         TSimpleServer server = new TSimpleServer(new Args(t).processor(processor));
        System.out.println(".........................................................................................................");
        System.out.println("...........................the server is started and is listening at 30000...............................");
        System.out.println(".........................................................................................................");

        server.serve();
    }


    public static void main_async() throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(30000);
        final TeamService.Processor teamProcessor = new TeamService.Processor(new TeamServiceImpl());
        final OrderService.Processor orderProcessor = new OrderService.Processor(new OrderServiceImpl());
        final CouponService.Processor couponProcessor = new CouponService.Processor(new CouponServiceImpl());

        THsHaServer.Args arg = new THsHaServer.Args(socket);
        // 高效率的、密集的二进制编码格式进行数据传输
        // 使用非阻塞方式，按块的大小进行传输，类似于 Java 中的 NIO
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(teamProcessor));
        arg.processorFactory(new TProcessorFactory(orderProcessor));
        arg.processorFactory(new TProcessorFactory(couponProcessor));
        TServer server = new THsHaServer(arg);

        System.out.println(".........................................................................................................");
        System.out.println("...........................the server is started and is listening at 30000...............................");
        System.out.println(".........................................................................................................");

        server.serve();
        System.out.println("#服务启动-使用:非阻塞&高效二进制编码");
    }


}
