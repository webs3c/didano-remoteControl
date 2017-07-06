package cn.didano.remotecontrol.robot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.didano.base.model.Robot_School;
import cn.didano.base.model.Robot_warning;
import cn.didano.remotecontrol.base.robot.data.robot_FinalRecogResult;
import cn.didano.remotecontrol.base.robot.service.RobotMongoDbFindService;
import cn.didano.remotecontrol.base.robot.service.Robot_SchoolService;
import cn.didano.remotecontrol.robot.core.RobotWebsocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊断平台api服务
 * 诊断查询服务
 * 
 * @author stephen Created on 2016年12月17日 下午6:38:30
 */
@Api(value = "诊断平台预警报告服务", tags = "对数据或设备进行检查并显示结果")
@RestController
@RequestMapping(value = "/robot/warning/")
public class RobotWarningController {
	static Logger logger = Logger.getLogger(RobotWarningController.class);
	@Autowired
	private RobotMongoDbFindService robotMongoDbFindService;
	@Autowired
	private Robot_SchoolService fsnr_SchoolService;
	@Autowired
	private RobotWebsocketServer robotWebsocketServer;
	
	@RequestMapping(value = "warning1", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "预警报告", notes = "预警报告")
	@ResponseBody
	public List<Robot_warning> warning1(){
		List<Robot_warning> Listrw=new ArrayList<Robot_warning>();
		try {
			Date date2 = getDate1();
			Date date1 = getDate2();
			List<Robot_School> findSheBei = fsnr_SchoolService.findSheBei(2);
			for (Robot_School robot_School : findSheBei) {
				Robot_warning rw=new Robot_warning();
				System.err.println(robot_School.getSchoolName()+"=========");
				//查询条数
				Robot_School studentNumber = fsnr_SchoolService.studentNumber(robot_School.getSystemType());
				System.err.println("学校id："+robot_School.getSystemType()+"-----------------人数："+studentNumber.getSystemType());
				//利用谁被号查询今天的数据条数
				List<robot_FinalRecogResult> queryFinalRecogResult1 = robotMongoDbFindService.queryFinalRecogResult1(date1, date2,robot_School.getDeviceNo());
				System.err.println(queryFinalRecogResult1.size()+"____晨检条数");
				rw.setSchoolName(robot_School.getSchoolName());
				rw.setDeviceNo(robot_School.getDeviceNo());
				rw.setSchoolNumber(studentNumber.getSystemType());
				rw.setMorningNumber(queryFinalRecogResult1.size()+"");
				rw.setBetweenNumber((studentNumber.getSystemType()-queryFinalRecogResult1.size())+"");
				Listrw.add(rw);
			}
			for (Robot_warning robot_School : Listrw) {
				System.err.println(robot_School);
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		return Listrw;
	}
	
	
	//------------------判断设备号是否在线
	@RequestMapping(value = "judgeDeviceNumber/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "判断设备号是否在线", notes = "判断设备号是否在线")
	@ResponseBody
	public List<Robot_School> judgeDeviceNumber(@PathVariable("system_type") String system_type){
		List<Robot_School> findSheBei=null;
		try {
			System.err.println("设备在线查询");
			//查询数据库中存在的设备号并且有学校
			 findSheBei = fsnr_SchoolService.findSheBei(Integer.parseInt(system_type));
			//查询我的session中存在的设备还
			List<Robot_School> sessionValue = robotWebsocketServer.getSessionValue();
			//得到两个值进行循环判断，最初最后在线设备的统计
			for(int i=0;i<findSheBei.size();i++){
				if(sessionValue.size()>0){
					for(int j=0;j<sessionValue.size();j++){
						String deviceNo = sessionValue.get(j).getDeviceNo();
						String deviceNo2 = findSheBei.get(i).getDeviceNo();
						if(deviceNo.equals(deviceNo2)){
							System.err.println("已连接");
							findSheBei.get(i).setIsOnline("已连接");
						}
					}
				}
			}
			for(int i=0;i<findSheBei.size();i++){
				String isOnline = findSheBei.get(i).getIsOnline();
				System.err.println(isOnline+":+++++++++");
				if(isOnline==null){
					findSheBei.get(i).setIsOnline("设备以掉线");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		} 
		return findSheBei;
	}
	
	
	
	
	
	
	 //得到当天零点时间
	public Date getDate1() throws Exception{
		//得到当前时间，只要年月日
		Date d = new Date();
		//得到当天时间的零点
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String dateNowStr = sdf.format(d);
		//再将得到的零点时间转换为date类型
		Date today = sdf.parse(dateNowStr);
		return today;
	}
	//传递当天的零点时间得到第二天的零点时间
	public Date getDate2() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar calendar = Calendar.getInstance();
		//将零点加上24小时，得到第二天的零点时间
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 24);
		//将时间转为String
		String format = sdf.format(calendar.getTime());
		//再转化为时间类型
		Date parse = sdf.parse(format);
		return parse;
	}
}    