package com.graduation.bean;

/**
 * 定义公共常量
 */
public class Constants {

    public interface File {

        // 头像和背景图拼接的url
        public static final String URL = "http://localhost:9191/hs/";

        // 文件存储位置
        public static final String PATH = "D:/IDEAProjects/hs/src/main/resources/static/";//"D:/IDEAProjects/file/";

        // 本地映射位置 如果没有热部署的话，新增的静态文件不能被访问，需要配置本地映射位置
        public static final String LOCALPATH = "file:D:\\IDEAProjects\\hs\\src\\main\\resources\\static\\";
    }

    public interface SkillSub {

        // 洗剪吹 sql片段
        public static final String XJC = " and skill in ('" + SkillType.FXSJ + "','" + SkillType.RF + "','" + SkillType.TF + "','" + SkillType.XJC + "') ";

        // 烫发 sql片段
        public static final String TF = " and skill in ('" + SkillType.FXSJ + "','" + SkillType.RF + "','" + SkillType.TF + "') ";

        // 染发 sql片段
        public static final String RF = " and skill in ('" + SkillType.FXSJ + "','" + SkillType.RF + "') ";

        // 发型设计 sql片段
        public static final String FXSJ = " and skill in ('" + SkillType.FXSJ + "') ";

    }

    public interface AppType {

        // 底部导航栏
        public static final String DBDHL = "tabbar";

        // 发型师轮播图
        public static final String FXSLBT = "haircuter";

        // 价格
        public static final String JG = "%Price%";

        // 首页轮播图
        public static final String SYLBT = "swiper";

        // 消息通知
        public static final String XXTZ = "notice";

    }

    public interface UserType {

        // 游客
        public static final String YK = "游客";

        // vip
        public static final String VIP = "vip";

        // 管理员
        public static final String GLY = "管理员";

    }

    public interface SkillType {

        // 洗剪吹
        public static final String XJC = "洗剪吹";

        // 烫发
        public static final String TF = "烫发";

        // 染发
        public static final String RF = "染发";

        // 发型设计
        public static final String FXSJ = "发型设计";

    }

    public interface PositionType {

        // 初级发型师
        public static final String CJFXS = "初级发型师";

        // 中级发型师
        public static final String ZJFXS = "中级发型师";

        // 高级发型师
        public static final String GJFXS = "高级发型师";

        // 总监
        public static final String ZJ = "总监";

    }

    public interface StatusType {

        // 排队
        public static final String PD = "排队";

        // 取消排队
        public static final String QXPD = "取消排队";

        // 服务中
        public static final String FWZ = "服务中";

        // 待评价
        public static final String DPJ = "待评价";

        // 完成
        public static final String WC = "完成";

    }

    public interface StatusSub {

        // 用户 有订单正在进行中
        public static final String YHYDDZZJXZ = " and status in('" + StatusType.PD + "','" + StatusType.FWZ + "') ";

        // 理发师 有订单正在进行中
        public static final String LFSYDDZZJXZ = " and status in('" + StatusType.PD + "','" + StatusType.FWZ + "') ";

        // 排队排序
        public static final String PDPX = " and status in('" + StatusType.PD + "') ";

    }

    public interface LimitSub {

        // 获取第一个排队的订单
        public static final String HQDYGPDDDD = " order by start_time LIMIT 1 ";

    }

    public interface Price {

        // 洗剪吹 价格对应的 app表id
        public static final String XJC = "15";

        // 烫发 价格对应的 app表id
        public static final String TF = "16";

        // 染发 价格对应的 app表id
        public static final String RF = "17";

        // 发型设计 价格对应的 app表id
        public static final String FXSJ = "18";

        // 初级理发师 手艺费对应的 app表id
        public static final String CJLFS = "19";

        // 中级理发师 手艺费对应的 app表id
        public static final String ZJLFS = "20";

        // 高级理发师 手艺费对应的 app表id
        public static final String GJLFS = "21";

        // 总监 手艺费对应的 app表id
        public static final String ZJ = "22";

    }

    public interface Result {

        // 参数不能为空
        public static final String CSBNWK = "参数不能为空";

        // 理发师不在工作时间内
        public static final String LFSBZGZSJN = "理发师不在工作时间内";

        // 您有订单正在进行中
        public static final String NYDDZZJXZ = "您有订单正在进行中";

    }
}
