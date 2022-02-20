package com.graduation.util;

import com.graduation.bean.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

    public static boolean isEmpty(String str) {
        return str != null && str.length() != 0;
    }

    /**
     * 自动匹配app配置表对应的id 例如：入参 ：洗剪吹 返回app表洗剪吹价格配置的id值
     * 详细配置见Constants类
     * @param type
     * @return
     */
    public static String matchAppId(Object type) {
        if (Constants.SkillType.XJC.equals(type.toString())) {
            return Constants.Price.XJC;
        } else if (Constants.SkillType.TF.equals(type.toString())) {
            return Constants.Price.TF;
        } else if (Constants.SkillType.RF.equals(type.toString())) {
            return Constants.Price.RF;
        } else if (Constants.SkillType.FXSJ.equals(type.toString())) {
            return Constants.Price.FXSJ;
        } else if (Constants.PositionType.CJFXS.equals(type.toString())) {
            return Constants.Price.CJLFS;
        } else if (Constants.PositionType.ZJFXS.equals(type.toString())) {
            return Constants.Price.ZJLFS;
        } else if (Constants.PositionType.GJFXS.equals(type.toString())) {
            return Constants.Price.GJLFS;
        } else if (Constants.PositionType.ZJ.equals(type.toString())) {
            return Constants.Price.ZJ;
        }
        return null;
    }

    /**
     * 自动匹配 手艺 对应的查询的拼接sql
     * 详细配置见Constants类
     * @param skill
     * @return
     */
    public static String matchSub(String skill) {
        if (skill.equals(Constants.SkillType.XJC)) {
            return Constants.SkillSub.XJC;
        } else if (skill.equals(Constants.SkillType.TF)) {
            return Constants.SkillSub.TF;
        } else if (skill.equals(Constants.SkillType.RF)) {
            return Constants.SkillSub.RF;
        } else if (skill.equals(Constants.SkillType.FXSJ)) {
            return Constants.SkillSub.FXSJ;
        }
        return null;
    }

    /**
     * 比较现在的时间是否处于 startTime 和 endTime 之间
     * @param startTime HH:mm
     * @param endTime HH:mm
     * @return
     * @throws ParseException
     */
    public static boolean isWork(Object startTime, Object endTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String now = simpleDateFormat.format(date);
        return isAfter(now,startTime) && isAfter(endTime,now);
    }

    /**
     * 判断 time1 是否比 time2 大
     * @param time1 HH:mm
     * @param time2 HH:mm
     * @return
     * @throws ParseException
     */
    public static boolean isAfter(Object time1, Object time2) throws ParseException {
        int time1Hour = Integer.parseInt(time1.toString().substring(0,2));
        int time2Hour = Integer.parseInt(time2.toString().substring(0,2));
        int time1Minute = Integer.parseInt(time1.toString().substring(3));
        int time2Minute = Integer.parseInt(time2.toString().substring(3));
        if (time1Hour > time2Hour) {
            return true;
        } else if (time1Hour < time2Hour) {
            return false;
        } else if (time1Hour == time2Hour) {
            if (time1Minute > time2Minute) {
                return true;
            } else if (time1Minute <= time2Minute) {
                return false;
            }
        }
        return false;
    }

    public static String switchStatus(String status) {
        if ("0".equals(status)) {
            return Constants.StatusType.PD;
        } else if ("1".equals(status)) {
            return Constants.StatusType.FWZ;
        } else if ("2".equals(status)) {
            return Constants.StatusType.DPJ;
        } else if ("3".equals(status)) {
            return Constants.StatusType.WC;
        } else if ("4".equals(status)) {
            return Constants.StatusType.QXPD;
        }
        return Constants.StatusType.PD;
    }

    public static String timeFormat(String time) {
        return time.substring(0,10) + " " + time.substring(11,19);
    }
}
