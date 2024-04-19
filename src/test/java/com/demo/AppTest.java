package com.demo;

import com.demo.entity.AppUser;
import com.demo.entity.Stu;
import com.demo.entity.UserOrder;
import com.demo.service.KwService;
import com.demo.utils.SnowflakeIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.function.SingletonSupplier;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author JHYe
 * @date 2024/4/8
 */
//@SpringBootTest(classes = Application.class)
//@RunWith(SpringRunner.class)
public class AppTest {

    @Resource
    private KwService kwService;

    private static String[] names = new String[]{"耐克篮球鞋", "飞鹤奶粉", "手套", "阿迪达斯跑鞋", "雅培奶粉", "手表",
            "新百伦跑鞋", "婴儿尿布",
            "T恤", "宝宝湿巾", "慢跑机", "科威特原油", "美的空调", "韩国泡菜", "橄榄油", "电视机", "小米手机", "纸巾", "手机壳", "床上用品", "运动短裤", "毛巾", "电动牙刷", "吉他", "碗碟套装", "儿童自行车", "太阳镜", "金属水瓶", "背包", "电脑", "游泳圈", "智能手环", "车载手机支架", "平板电脑", "香水",
            "短袖衬衫", "婴儿推车", "球拍", "扩音器", "贝亲奶瓶", "宝宝餐具", "护理套装", "魔方", "纸杯", "游乐场门票", "酸奶机", "麦克风", "书包", "沙滩浴巾", "遥控飞机", "眼镜", "披肩", "钥匙链",
            "自行车头盔", "美甲套装", "数码相机", "恒温杯", "酒店预订", "蓝牙耳机", "电动剃须刀", "咖啡机", "洗发水", "护发素", "瑜伽垫", "马桶盖", "手机支架", "餐具", "饭盒", "电子秤", "电热毯",
            "相框", "保温杯", "维生素片", "钢笔", "毛绒玩具", "地毯", "洗衣液", "腰包", "坐垫", "餐巾纸", "沙发", "水壶", "电饭煲", "餐桌", "空气净化器", "空气加湿器", "空气炸锅", "女性卫生用品", "刀具套装", "电子琴", "跑步机", "美发工具", "瑜伽球", "行李箱", "毛衫", "羽绒服",
            "风衣", "运动鞋", "卫生纸", "电扇", "音响系统", "精油香薰灯", "蒸汽熨斗", "丝巾", "伞", "钱包", "穿孔刀", "烧烤炉", "移动硬盘", "毛笔", "挂钟", "指甲油", "美容仪", "空气清新剂",
            "月饼", "公仔", "泳衣", "连衣裙", "洗面奶", "滑板车", "游戏机", "电动车", "电动滑板", "遮阳伞", "水族箱", "摄像机", "口红", "礼品卡", "电磁炉", "姨妈巾", "学习桌", "针线包",
            "鼠标", "笔记本电脑", "雪茄", "雨靴", "学步车", "相机镜头", "自拍杆", "高跟鞋", "雪糕机", "高压锅", "防晒霜", "情侣衣服", "学生床", "学生桌", "学生椅", "微波炉", "屏幕保护膜", "DVD播放机",
            "双肩书包", "音乐播放器", "藏书抽屉", "跳跳球", "尿布垫", "象棋", "四轮自行车", "长靴", "滑雪板", "奶茶机", "游泳眼镜", "长裙", "睡衣", "电烤箱", "随身听", "婴儿车床", "牛仔裤", "马克杯",
            "可乐", "面膜", "洗碗机", "小吃车", "电钻", "美容面霜", "美容面膜", "雕塑", "石榴", "电动工具", "电冰箱", "吊灯", "马桶", "烤鸭", "酒精", "法拉利", "红酒", "平衡车", "卫生巾", "项链", "手链", "手镯", "电焊机", "美食礼盒", "水彩笔", "饼干", "蛋糕",
            "木地板", "外套", "运动裤", "摄像头", "导航仪", "电子书阅读器", "儿童床", "儿童衣柜", "儿童电动车", "儿童玩具", "茶具", "中药", "坐便盖板", "浴巾", "龙虾", "炉灶", "充电器", "太阳能充电板",
            "枕头", "蜡烛", "香薰精油", "香薰蜡烛", "马桶刷", "储物盒", "太阳眼镜", "电脑鼠标垫", "电脑音箱", "头盔", "抓绒衣", "羊奶粉", "洗衣粉", "鱼龙椅", "直发器", "电视机底座", "洗衣机", "毛线",
            "沙拉油", "耐克运动裤", "优衣库T恤", "阿迪达斯运动鞋", "ZARA连衣裙", "Levi's牛仔裤", "苹果iPhone手机", "三星液晶电视", "小米手环", "索尼音响", "华为笔记本电脑", "奥利奥饼干", "可口可乐汽水", "三全速冻水饺", "卫龙辣条", "雀巢咖啡", "宜家家具", "飞利浦LED灯泡", "松下电饭煲", "联想电视机", "夏普空气净化器", "米兰达排球", "罗斯托特高尔夫球杆",
            "耐克篮球", "阿迪达斯足球", "费尔哈伦自行车", "卡特彼勒挖掘机", "施耐德电气开关", "戴尔台式电脑", "惠普打印机", "西门子冰箱", "奔驰轿车", "宝马摩托车", "丰田卡罗拉汽车", "本田雅阁轿车", "尼康相机", "佳能单反相机", "索尼游戏机", "微软Xbox", "任天堂Switch", "雅马哈吉他", "马丁吉他", "爱马仕手袋", "路易威登皮包", "香奈儿口红", "迪奥香水", "兰蔻粉底", "欧莱雅洗发水",
            "资生堂护肤品", "克鲁斯托夫墨镜", "雷朋太阳眼镜", "巴宝莉围巾", "柯达相纸", "富士胶片", "惠普墨盒", "爱普生投影仪", "博世洗碗机", "飞利浦电吹风", "三星洗衣机", "LG冰柜", "松下微波炉", "小米平板电脑", "华硕路由器", "雷神游戏笔记本", "惠普工作站", "戴尔服务器", "康宝莱蛋白粉", "美素佳儿奶粉", "君乐宝牛奶", "蒙牛酸奶", "可口可乐零度", "百事可乐", "统一方便面",
            "康师傅饮料", "娃哈哈果汁", "好丽友巧克力", "德芙巧克力", "费列罗巧克力", "哈根达斯冰淇淋", "雀巢冰激凌", "三只松鼠坚果", "良品铺子零食", "百草味蜜饯", "酷派手机", "努比亚智能手表", "美的空调", "格力电风扇", "海尔洗衣机", "TCL电视", "小米空调", "苏泊尔炒锅", "美的电饭煲", "老板热水器", "格兰仕电磁炉", "华为平板电脑", "vivo手机", "OPPO手机", "一加手机",
            "劳力士手表", "卡地亚项链", "宝格丽耳环", "尊皇手链", "汤米·希尔费格外套", "迈克·范杜斯运动裤", "阿尔玛尼西装", "蔻驰高跟鞋", "卡尔文·克莱恩钱包", "李维斯皮带", "阿迪达斯帽子", "耐克手套", "斯凯奇运动袜", "范思哲墨镜", "普拉达手表", "宝格丽项链", "蒂芙尼戒指", "香奈儿耳环", "迪奥口红", "兰蔻粉饼", "欧莱雅睫毛膏", "娇韵诗面膜", "雅诗兰黛防晒霜"};


    private static final String[] USER_NAMES = new String[]{"张磊", "李泽", "王阳", "刘鹏", "陈宇", "杨帆", "赵明", "黄健", "周华", "吴洋", "宋天", "马飞",
            "许鹏", "郭俊", "郑力", "朱勇", "潘宏", "高飞", "韩杰", "解军", "谢宇",
            "何涛", "曹伦", "唐林", "罗阳", "孙伦", "邓峰", "董刚", "袁霖", "祝浩", "毛坤", "许明", "钟东", "陆宁",
            "丁凯", "黎辉", "廖健", "戴翔", "范聪", "汪新", "金辰", "程俊", "邱龙", "谭博", "姜磊", "万成", "秦骏", "巫峰", "韦豪", "蒋天", "何宏", "蔡彬", "阳飞", "邵鹏",
            "梁诚", "留骏", "姚航", "傅达", "钱晨", "钟嘉", "关旭", "严宝", "喻鹤",
            "洪豪", "安明", "庄翔", "邢华", "詹奇", "严飞", "崔军", "骆威", "褚宇", "喜涛",
            "王婷", "李雅", "张瑞", "王秀", "杨琳", "王晶", "刘婷", "孙英", "李婷", "张丽华", "曾琳", "杨晴", "王婉", "高婷", "王丹", "张曼", "王婷婷", "刘晶", "李丽丽", "曹洁",
            "王瑞琳", "尤心", "杨洁", "高丽娜", "张美", "王艳", "梁雪", "吕雯", "马婷", "王文", "杨慧", "王睿",
            "张倩倩", "刘美", "李晶晶", "王欣", "梁洁", "赵玲", "杨蓉", "尹雪", "高晶", "张珊珊", "王艳艳", "李思", "张薇", "李雯雯", "王洁洁", "刘雪", "王晶晶", "张蓉蓉", "杨梅",
            "王丽丽", "张佳佳", "李红梅", "王雅婷", "魏婷婷", "刘婷婷", "李艳艳",
            "张慧慧", "刘琳琳", "王丽娜", "杨萍萍", "王玉玉", "张晶晶", "李欣欣", "李磊", "张涛", "王华", "刘鑫", "陈健", "杨勇", "赵宇", "黄智", "周强", "吴鹏", "宋飞", "马明", "许杰",
            "郭斌", "郑文", "朱涛", "潘辉", "高鹏", "韩峰", "解明", "谢宏", "何阳", "曹飞", "唐宇", "罗力", "孙军", "邓伟", "董强", "袁飞", "祝刚", "毛峰", "许宇", "钟浩", "陆斌", "丁明",
            "黎华", "廖勇", "戴杰", "范飞", "汪明", "金宏", "程飞", "邱刚", "谭明", "姜杰", "万强", "秦飞", "巫明", "韦鹏", "蒋波", "何力", "蔡飞", "阳明", "邵宇", "梁强", "留宇", "姚飞",
            "傅刚", "钱波", "钟杰", "关飞", "严宏", "喻杰", "洪斌", "安飞", "庄明", "邢华", "詹飞", "严强", "崔宇", "骆飞", "褚明", "喜杰", "杜明", "仇杰", "萧强", "赖飞", "云杰", "查明",
            "蒲宇", "习明", "牛强", "宓飞", "郄杰", "庚明", "晋飞", "谷刚", "轩杰", "丘宇", "松飞", "井明", "逯飞", "苑宏", "商飞", "戚明", "闻宇", "桓飞", "尉刚", "弓宇", "始明", "巴飞",
            "衣飞", "栾杰", "郗飞", "甯明", "海强", "冼宏", "陈杰", "宓杰", "牟峰", "眭红", "洗宏", "涂杰", "谷飞", "戚强", "闻宏", "朴飞", "桑杰", "乔明", "法飞", "石宇", "艾宇", "邸明",
            "曾飞", "饶明", "蓝飞", "秋宇", "辜宇", "锺宏", "甄刚", "韩宇", "桑明", "茹杰", "金强", "韩宏", "魏强", "曾宏", "师杰", "蓟刚", "邴杰", "浦杰", "郏明", "朱飞", "池明", "龚杰",
            "艾飞", "卞宇", "弓明", "邢飞", "孙强", "养飞", "逢强", "绳飞", "李娜", "张雅", "王梦", "刘娟", "陈洁", "杨萍", "赵玉", "黄婷", "周琳", "吴倩", "宋瑞", "马丽", "许娟", "郭娜",
            "郑文", "朱瑶", "潘琪", "高倩", "韩娟", "解萍", "谢艳", "何晴", "曹霞", "唐娟", "罗雪", "孙丽", "邓瑞", "董霞", "袁萍", "祝丽", "毛娟", "许婷", "钟倩", "陆婷", "丁洁", "黎琳",
            "廖倩", "戴艳", "范萍", "汪丽", "金倩", "程霞", "邱倩", "谭萍", "姜瑞", "万倩", "秦娟", "巫萍", "韦瑞", "蒋倩", "何洁", "蔡瑞", "阳丽", "邵倩", "梁霞", "留娟", "姚萍", "傅娟",
            "钱萍", "钟丽", "关娟", "严洁", "喻艳", "洪瑞", "安倩", "庄倩", "邢文", "詹丽", "严晴", "崔倩", "骆丽", "褚娟", "喜洁", "杜洁", "仇晴", "萧倩", "赖瑞", "云瑞", "查洁", "蒲瑞",
            "习晴", "牛倩", "宓洁", "郄瑞", "庚瑞", "晋倩", "谷洁", "轩洁", "丘瑞", "松倩", "井娟", "逯洁", "苑丽", "商倩", "戚倩", "闻文", "桓丽", "尉晴", "弓洁", "始婷", "巴萍", "衣洁",
            "栾倩", "郗婷", "甯丽", "海洁", "冼文", "陈洁", "宓洁", "牟丽", "眭洁", "洗瑞", "涂娟", "谷萍", "戚洁", "闻洁", "朴丽", "桑倩", "乔晴", "法倩", "石婷", "艾洁", "邸洁", "曾倩",
            "饶丽", "蓝晴", "秋洁", "辜倩", "锺瑞", "甄晴", "韩倩", "桑瑞", "茹萍", "金娟", "韩洁", "魏瑞", "曾萍", "师瑞", "蓟文", "邴萍", "浦白", "请宙", "朱丽", "池婷", "龚瑞", "艾萍",
            "卞洁", "弓倩", "邢倩", "商洁", "毛萍", "洪娟", "养洁", "风丽", "绳洁"


    };

    @Test
    public void insertAppUsers() {
        int randomTop = names.length;
        for (int i = 1; i <= 100; i++) {
            long l = SnowflakeIdGenerator.getInstance().generateId();
            UserOrder userOrder = new UserOrder();
            userOrder.setId(l);
            userOrder.setUser_id((long) new Random().nextInt(3999999) + 1);
            userOrder.setConsume(new Random().nextInt(1000) + 100);
            userOrder.setDiscount('0');
            userOrder.setName(names[new Random().nextInt(randomTop - 1)] + i);
            kwService.insert(userOrder);
        }
//        List<AppUser> appUsers1 = kwService.listAppUsers(null);
//        List<AppUser> appUsers2 = kwService.listAppUsers(null);
    }

    @Test
    public void queryAppUsers() {
        int randomTop = USER_NAMES.length;
        AppUser appUser = new AppUser();
        appUser.setAge(new Random().nextInt(50) + 18);
        appUser.setEmail("sjakdsj@gmail.com");
        appUser.setGender(1);
        appUser.setName(USER_NAMES[new Random().nextInt(randomTop - 1)]);
        appUser.setPhone("18397007254");
        kwService.insertUser(appUser);
        List<AppUser> appUsers1 = kwService.listAppUsers(null);
        List<AppUser> appUsers2 = kwService.listAppUsers(null);
    }

    /**
     * 由shardingsphere 创建MOD分片表stu
     */
    @Test
    public void initShardingModTables() {
        kwService.initShardingModTables();
    }

    /**
     * 由shardingsphere 创建INLINE分片表stu
     */
    @Test
    public void initShardingInlineTables() {
        kwService.initShardingInlineTables();
    }


    /**
     * 测试使用MOD分片算法，修改sharding-count是否会自动创建表 ?
     * 结论：报错Table 'test_db.stu_8' doesn't exist , 并不会在改变规则之后动态生成表
     */
    @Test
    public void shardingModInsert() {
        int randomTop = USER_NAMES.length;
        for (int i = 0; i < 100; i++) {
            Stu stu = new Stu(SnowflakeIdGenerator.getInstance().generateId(), USER_NAMES[new Random().nextInt(randomTop - 1)], "中国");
            kwService.insertStu(stu);
        }
    }

    /**
     * 测试使用INLINE分片算法，修改配置是否会自动创建表 ?
     * 结论：报错Table 'test_db.stu_2' doesn't exist , 并不会在改变规则之后动态生成表
     */
    @Test
    public void shardingInlineInsert() {
        int randomTop = USER_NAMES.length;
        for (int i = 0; i < 100; i++) {
            Stu stu = new Stu(SnowflakeIdGenerator.getInstance().generateId(), USER_NAMES[new Random().nextInt(randomTop - 1)], "中国");
            kwService.insertStu(stu);
        }
    }

    @Test
    public void testThreadLocal() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("threadLocal1");
        threadLocal.set("threadLocal2");

        ThreadLocal<String> initThreadLocal = ThreadLocal.withInitial(() -> "withInitial");

        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set("threadLocal1_1");
        threadLocal1.set("threadLocal1_2");

        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());

        System.out.println(threadLocal1.get());
        System.out.println(threadLocal1.get());
        System.out.println(initThreadLocal.get());

    }

    @Test
    public void java8() {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
//        Arrays.sort(array,AppTest::cmp);
        Arrays.sort(array,(s1,s2)->{
            return -s1.compareTo(s2);
        });
        System.out.println(String.join(", ",array));
    }
}
