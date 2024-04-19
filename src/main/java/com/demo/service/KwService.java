package com.demo.service;

import com.demo.entity.AppUser;
import com.demo.entity.Stu;
import com.demo.entity.UserOrder;
import com.demo.model.UserOrderVo;

import java.util.List;

/**
 * @author JHYe
 * @date 2024/4/8
 */
public interface KwService {

    List<UserOrderVo> listUserOrders(UserOrder userOrder);

    List<AppUser> listAppUsers(AppUser appUser);

    void insert(UserOrder userOrder);

    void insertUser(AppUser appUser);

    void initShardingModTables();

    void insertStu(Stu stu);

    void insertUserOrder(UserOrder userOrder);

    void initShardingInlineTables();


}
