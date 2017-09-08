package com.abin.lee.thrift.rpc.skeleton.facade;

import com.abin.lee.thrift.rpc.api.TeamService;
import com.abin.lee.thrift.rpc.common.util.JsonUtil;
import com.abin.lee.thrift.rpc.enums.BusinessRoleEnum;
import com.abin.lee.thrift.rpc.model.Business;
import com.abin.lee.thrift.rpc.model.TeamInfo;
import com.google.common.collect.Lists;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by abin on 2017/9/7 15:52.
 * march-svr
 * com.abin.lee.march.svr.thrift.service
 */
public class TeamServiceImpl implements TeamService.Iface {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<TeamInfo> findTeamListById(long id) throws TException {
        List<TeamInfo> teamInfoList = Lists.newArrayList();
        for (int i = 0; i <3 ; i++) {
            TeamInfo teamInfo = new TeamInfo();
            teamInfo.setSource("SYSTEM");
            teamInfo.setTeamId(10000000000000000L);
            teamInfo.setTeamName("大仙桃");
            teamInfo.setTeamPrice(157.23);
            teamInfo.setTeamInventory(500);
            teamInfoList.add(teamInfo);
        }
        return teamInfoList;
//                return null;
    }

    @Override
    public TeamInfo findTeamById(long id) throws TException {
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setSource("SYSTEM");
        teamInfo.setTeamId(10000000000000000L);
        teamInfo.setTeamName("大仙桃");
        teamInfo.setTeamPrice(157.23);
        teamInfo.setTeamInventory(500);
        return teamInfo;
//        return null;
    }

    @Override
    public long findByIdAndType(long id, String species) throws TException {
        if(id > 100)
            return 999999999999999L;
        return -1;
    }

    @Override
    public double findById(long id) throws TException {
        if(id > 100)
            return 100.9999d;
        return 0.0001d;
    }

    @Override
    public BusinessRoleEnum findByBid(long id) throws TException {
        if(id > 100)
            return BusinessRoleEnum.ADMIN;
        return BusinessRoleEnum.DEFAULT;
    }

    @Override
    public void insert(Business business) throws TException {
        LOGGER.info("business={}", JsonUtil.toJson(business));
    }

    @Override
    public Business findBusinessByBid(long id) throws TException {
        Business business = new Business();
        business.setAccountId(10000000000000000L);
        business.setBusinessId(20000000000000000L);
        business.setBusinessAddress("Los Angeles");
        business.setBusinessName("Holly Wood");
        business.setContractId(30000000000000000L);

        return business;
//        return null;
    }
}
