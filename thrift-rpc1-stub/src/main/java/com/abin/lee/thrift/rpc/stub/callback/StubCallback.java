package com.abin.lee.thrift.rpc.stub.callback;

import com.abin.lee.thrift.rpc.api.TeamService;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by abin on 2017/9/7 18:49.
 * march-svr
 * com.abin.lee.march.svr.thrift.callback
 */
public class StubCallback implements AsyncMethodCallback<TeamService.AsyncClient.findTeamById_call> {

    // 返回结果
    @Override
    public void onComplete(TeamService.AsyncClient.findTeamById_call response) {
        System.out.println("onComplete");
        try {
            System.out.println("onComplete----response : " + response.getResult().toString());
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    // 返回异常
    @Override
    public void onError(Exception exception) {
        System.out.println("onError................");
    }

}