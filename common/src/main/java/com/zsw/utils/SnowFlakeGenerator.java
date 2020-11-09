package com.zsw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 雪花算法 - 生成唯一主键id
 *
 * @author zhangshiwei
 * @since 2020年11月10日 上午12:31:23
 */
public class SnowFlakeGenerator {
    /**
     * 机房id, 占的位数, roomId最大的正整数(32)
     */
    private long roomId;
    private long roomIdBit      = 5L;
    private long maxRoomId      = -1 ^ (-1 << roomIdBit);
    /**
     * 机器id, 占的位数, workId最大的正整数(32)
     */
    private long workId;
    private long workIdBit      = 5L;
    private long maxWorkId      = -1 ^ (-1 << workIdBit);
    /**
     * 递增开始数, 占的位数, 递增序列能够存储的最大数值(4095)
     */
    private long sequence       = 1L;
    private long sequenceBits   = 12L;
    private long sequenceMask   = -1 ^ (-1 << sequenceBits);

    /**
     * workId左移的位数, roomId左移的位数, 时间戳左移的位数
     */
    private long workIdShift    = sequenceBits;
    private long roomIdShift    = sequenceBits + workIdBit;
    private long timeStampShift = sequenceBits + workIdBit + roomIdBit;

    public SnowFlakeGenerator(long roomId, long workId, long sequence) throws Exception {
        if (roomId > maxRoomId || roomId < 0) {
            throw new Exception("roomId值错误!");
        }
        if (workId > maxWorkId || workId < 0) {
            throw new Exception("workId值错误!");
        }
        this.roomId = roomId;
        this.workId = workId;
        this.sequence = sequence;
    }

    /**
     * 上一个时间戳
     */
    private long lastTimeStamp  = -1;

    /**
     * 初始时间戳
     */
    private long startTimeStamp = 1596372483166L;

    public synchronized long nextVal() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < lastTimeStamp) {
            throw new Exception("时间戳异常!");
        }
        if (currentTimeMillis == lastTimeStamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // sequence == 0 , 表示sequence超过了4095, 等待到下一个时间毫秒, 重新赋值时间毫秒的值
                currentTimeMillis = waitToNextMills(currentTimeMillis);
            }
        } else {
            // 进入到了新的时间毫秒, 计数序列从0开始
            sequence = 0;
        }

        lastTimeStamp = currentTimeMillis;

        long result = (currentTimeMillis - startTimeStamp) << timeStampShift | (roomId << roomIdShift)
                | (workId << workIdShift) | sequence;
        //        System.out.println("最新的id: " + result);

        return result;
    }

    /**
     * 当前毫秒内的唯一id已经生成了4095个, 等待到下一个毫秒
     *
     * @param timeStamp 当前时间毫秒
     * @return 下一个时间毫秒
     */
    public long waitToNextMills(long timeStamp) {
        long timeMillis = System.currentTimeMillis();
        while (timeMillis <= timeStamp) {
            timeMillis = System.currentTimeMillis();
        }
        return timeMillis;
    }

    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator(1L, 1L, 1L);
        for (int i = 0; i < 100000; i++) {
            long nextVal = snowFlakeGenerator.nextVal();
            System.out.println(simpleDateFormat.format(new Date()) + " 最新id : " + nextVal);
        }
    }
}
