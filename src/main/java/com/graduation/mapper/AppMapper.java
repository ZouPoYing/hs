package com.graduation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.graduation.domain.App;

@Mapper
public interface AppMapper {

	@Select("select * from app where type='my-menu' and auth <= (select CASE WHEN user_type='vip' THEN 2 " +
			"WHEN user_type='管理员' THEN 9 ELSE 0 END AS user_type from user where phone_number=#{phoneNumber})")
	public List<Map<String, Object>> getAppByPhoneNumber(String phoneNumber);

	@Select("select * from app where type=#{type} ")
	public List<Map<String, Object>> getAppByType(String type);

	@Update("update app set img='/images/tabbar/home.png', title='首页' where id=4;" +
			"update app set img='/images/tabbar/haircut.png', title='剪发' where id=5;" +
			"update app set img='/images/tabbar/order.png', title='订单' where id=6;" +
			"update app set img='/images/tabbar/my.png', title='我的', link='/pages/my/my' where id=7;")
	public void setCommon();

	@Update("update app set img='/images/tabbar/x.png', title='新' where id=4;\n" +
			"update app set img='/images/tabbar/c.png', title='春' where id=5;\n" +
			"update app set img='/images/tabbar/k.png', title='快' where id=6;\n" +
			"update app set img='/images/tabbar/l.png', title='乐' where id=7;")
	public void setNewYear();

	@Select("select * from app where type like #{type} ")
	public List<Map<String, Object>> getAppLikeType(String type);

	@Update("update app set img=#{positionPrice1} where id=15;" +
			"update app set img=#{positionPrice2} where id=16;" +
			"update app set img=#{positionPrice3} where id=17;" +
			"update app set img=#{positionPrice4} where id=18;")
	public void updatePositionPrice(String positionPrice1,String positionPrice2,String positionPrice3,String positionPrice4);

	@Update("update app set img=#{skillPrice1} where id=19;" +
			"update app set img=#{skillPrice2} where id=20;" +
			"update app set img=#{skillPrice3} where id=21;" +
			"update app set img=#{skillPrice4} where id=22;")
	public void updateSkillPrice(String skillPrice1,String skillPrice2,String skillPrice3,String skillPrice4);

	@Select("select * from app where type='my-menu' and auth <= #{auth}")
	public List<Map<String, Object>> getAppByAuth(String auth);

	@Select("select img from app where id = #{id}")
	public String getPriceById(String id);

}
