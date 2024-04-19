package com.demo.utils;

/**
 * @author JHYe
 * @date 2024/4/8
 */
public class SnowflakeIdGenerator {

    // 起始的时间戳
    private final long START_TIMESTAMP = 1616563200000L; // 2021-03-24 00:00:00 UTC

    // 每一部分占用的位数
    private final long SEQUENCE_BIT = 12; // 序列号占用的位数
    private final long MACHINE_BIT = 5;   // 机器标识占用的位数
    private final long DATA_CENTER_BIT = 5;// 数据中心占用的位数

    // 每一部分的最大值
    private final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);

    // 每一部分向左的位移
    private final long MACHINE_LEFT = SEQUENCE_BIT;
    private final long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    private long dataCenterId;  // 数据中心
    private long machineId;     // 机器标识
    private long sequence = 0L; // 序列号
    private long lastTimestamp = -1L; // 上一次时间戳

    //最大抖动上限值，最好设置为奇数,注意该值必须小于等于MAX_SEQUENCE即4095
    private int maxVibrationOffset=1;
    //跨毫秒时的序列号,跨毫秒获取时该序列号+1
    private volatile int sequenceOffset = -1;
    private static volatile SnowflakeIdGenerator instance;

    // 私有构造函数
    private SnowflakeIdGenerator() {
        // 初始化逻辑
    }

    // 获取单例实例的方法
    public static SnowflakeIdGenerator getInstance() {
        if (instance == null) {
            synchronized (SnowflakeIdGenerator.class) {
                if (instance == null) {
                    instance = new SnowflakeIdGenerator(0,1);
                }
            }
        }
        return instance;
    }

    public SnowflakeIdGenerator(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException("Data Center Id can't be greater than " + MAX_DATA_CENTER_NUM + " or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("Machine Id can't be greater than " + MAX_MACHINE_NUM + " or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    public synchronized long generateId() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                currentTimestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 2.不同毫秒,处理抖动上限,超过了抖动上限则将sequenceOffset计数器归0,否则sequenceOffset累加1
            //将sequence设置为sequenceOffset
//            vibrateSequenceOffset();
//            sequence = sequenceOffset;
            sequence = currentTimestamp % 2 == 0 ? 0L : 1L;
//            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;

        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT)
                | (dataCenterId << DATA_CENTER_LEFT)
                | (machineId << MACHINE_LEFT)
                | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }


    private void vibrateSequenceOffset() {
        //不同毫秒时间,处理抖动上限,超过了抖动上限则将sequenceOffset计数器归0,否则sequenceOffset累加1
        sequenceOffset = sequenceOffset >= maxVibrationOffset ? 0 : sequenceOffset + 1;
    }
}
