package com.demo.controller;

import com.demo.entity.AppUser;
import com.demo.entity.UserOrder;
import com.demo.model.UserOrderVo;
import com.demo.service.KwService;
import com.demo.utils.SnowflakeIdGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JHYe
 * @date 2024/4/8
 */
@RestController
@RequestMapping("/kw")
public class KwController {

    @Resource
    private KwService kwService;

    @GetMapping("/user/page")
    public List<AppUser> listAppUser(AppUser appUser) {
        return kwService.listAppUsers(appUser);
    }

    @GetMapping("/order/page")
    public List<UserOrderVo> listOrder(UserOrder userOrder) {
        return kwService.listUserOrders(userOrder);
    }

    @PostMapping("/order")
    public void insertUserOrder(@RequestBody UserOrder userOrder) {
        userOrder.setId(SnowflakeIdGenerator.getInstance().generateId());
        kwService.insertUserOrder(userOrder);
    }

}
