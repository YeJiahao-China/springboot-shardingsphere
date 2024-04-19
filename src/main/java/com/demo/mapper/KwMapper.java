package com.demo.mapper;

import com.demo.entity.AppUser;
import com.demo.entity.Stu;
import com.demo.entity.UserOrder;
import com.demo.model.UserOrderVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author JHYe
 * @date 2024/4/8
 */
public interface KwMapper {

    @Select({"<script>","select user_order.id,user_id,app_user.`name` as user_name, user_order.name ,consume,discount from app_user\n" +
            "        INNER JOIN user_order ON app_user.id = user_order.user_id\n" +
            "        <where>\n" +
            "            <if test=\"id!=null\">and user_order.id = #{id}</if>\n" +
            "            <if test=\"user_id!=null\">and user_order.user_id = #{user_id}</if>\n" +
            "            <if test=\"name!=null and name!= ''\">and user_order.name like concat('%', #{name},'%')</if>\n" +
            "            <if test=\"consume!=null\">and user_order.consume = #{consume}</if>\n" +
            "        </where>",
            "</script>"})
    List<UserOrderVo> listUserOrders(UserOrder userOrder);

    @Insert("insert into user_order (id,name,user_id,consume,discount) values (#{id},#{name},#{user_id},#{consume},#{discount})")
    int insertUserOrder(UserOrder userOrder);

    @Select({"<script>",
            "select id,name ,phone,age,email,gender from app_user\n" +
            "        <where>\n" +
            "            <if test=\"id!=null\">and id = #{id}</if>\n" +
            "            <if test=\"age!=null\">and age = #{age}</if>\n" +
            "            <if test=\"name!=null and name!= ''\">and name like concat('%', #{name},'%')</if>\n" +
            "        </where> limit 100",
            "</script>"})
    List<AppUser> listAppUsers(AppUser appUser);

    @Insert("insert into app_user( name, email, phone, gender, age) values(#{name},#{email},#{phone},#{gender},#{age})")
    void insertUser(AppUser appUser);

    @Insert("CREATE TABLE `stu`  (\n" +
            "  `number` bigint(19) NOT NULL,\n" +
            "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
            "  `country` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`number`) USING BTREE,\n" +
            "  INDEX `idx_name`(`name`) USING BTREE\n" +
            ") ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;")
    void initShardingModTables();

    @Insert("insert into stu (number,name,country) values (#{number},#{name},#{country})")
    void insertStu(Stu stu);

    @Insert("CREATE TABLE `stu`  (\n" +
            "  `number` bigint(19) NOT NULL,\n" +
            "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
            "  `country` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`number`) USING BTREE,\n" +
            "  INDEX `idx_name`(`name`) USING BTREE\n" +
            ") ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;")
    void initShardingInlineTables();

}
