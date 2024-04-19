package com.demo.service.impl;

import com.demo.entity.AppUser;
import com.demo.entity.Stu;
import com.demo.entity.UserOrder;
import com.demo.mapper.KwMapper;
import com.demo.model.UserOrderVo;
import com.demo.service.KwService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JHYe
 * @date 2024/4/8
 */
@Service
public class KwServiceImpl implements KwService {

    @Resource
    private KwMapper kwMapper;

    @Override
    public List<UserOrderVo> listUserOrders(UserOrder userOrder) {
        return kwMapper.listUserOrders(userOrder);
    }

    @Override
    public List<AppUser> listAppUsers(AppUser appUser) {
        return kwMapper.listAppUsers(appUser);
    }

    @Override
    public void insert(UserOrder userOrder) {
        kwMapper.insertUserOrder(userOrder);
    }

    @Override
    public void insertUser(AppUser appUser) {
        kwMapper.insertUser(appUser);
    }

    @Override
    public void initShardingModTables() {
        kwMapper.initShardingModTables();
    }

    @Override
    public void insertStu(Stu stu) {
        kwMapper.insertStu(stu);
    }

    @Override
    public void insertUserOrder(UserOrder userOrder) {
        kwMapper.insertUserOrder(userOrder);
    }

    @Override
    public void initShardingInlineTables() {
        kwMapper.initShardingInlineTables();
    }
}
