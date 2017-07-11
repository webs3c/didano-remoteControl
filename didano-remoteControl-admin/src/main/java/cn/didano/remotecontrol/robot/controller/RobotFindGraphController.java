package cn.didano.remotecontrol.robot.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.didano.base.model.Robot_School;
import cn.didano.remotecontrol.base.exception.BackType;
import cn.didano.remotecontrol.base.json.Out;
import cn.didano.remotecontrol.base.robot.data.robot_AndriodCPUTemperature;
import cn.didano.remotecontrol.base.robot.data.robot_AndriodCPUTemperatureGraph;
import cn.didano.remotecontrol.base.robot.data.robot_AndroidHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.robot_AndroidHardWareUsedGraph;
import cn.didano.remotecontrol.base.robot.data.robot_AndroidSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_AppRunningStatus;
import cn.didano.remotecontrol.base.robot.data.robot_CalibrateInfo;
import cn.didano.remotecontrol.base.robot.data.robot_CandidatesInfo;
import cn.didano.remotecontrol.base.robot.data.robot_FinalRecogResult;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxEnvTemperatureInfo;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxEnvTemperatureInfoGraph;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareInfo;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareUsedGraph;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxStartUpRecord;
import cn.didano.remotecontrol.base.robot.data.robot_MotionSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_PhotographicQualityInfo;
import cn.didano.remotecontrol.base.robot.data.robot_PhotographicQualityInfoGraph;
import cn.didano.remotecontrol.base.robot.data.robot_SelfLnspectionInfo;
import cn.didano.remotecontrol.base.robot.data.robot_UploadType;
import cn.didano.remotecontrol.base.robot.service.RobotMongoDbFindService;
import cn.didano.remotecontrol.base.robot.service.Robot_SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊断平台条件查询服务
 * 
 * @author stephen Created on 2016年12月17日 下午6:38:30
 */
@Api(value = "诊断平台条件查询服务", tags = "使用mongodb自身对数据库进行操作")
@RestController
@RequestMapping(value = "/robot/findGraph/")
public class RobotFindGraphController {
	static Logger logger = Logger.getLogger(RobotFindGraphController.class);
	@Autowired
	private RobotMongoDbFindService robotMongoDbFindService;
	@Autowired
	private Robot_SchoolService fsnr_SchoolService;
	
	/**
	 * 创建人：SevenYang 
	 * @创建时间：2017年3月17日 下午3:59:48 
	 * @Title:
	 * reportMeetSpeedInfo 
	 * @Description: （存上传类型信息） 
	 * @return Out<String> 修改人：
	 * 版本：1.0.0 @throws
	 */
	@PostMapping(value = "schoolDeviceNoFindAll/{system_type}")
	@ApiOperation(value = "查询设备号所对应的学校", notes = "查询设备号所对应的学校")
	@ResponseBody
	public List<Robot_School> schoolDeviceNoFindAll(@PathVariable("system_type") Integer system_type) {
		Out<String> out = new Out<String>();
		List<Robot_School> findSchollName=null;
		try {
			findSchollName = fsnr_SchoolService.findSheBei(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_MONGO_SAVE, e.getMessage());
		}
		return findSchollName;
	}
	/**
	 * 创建人：SevenYang 
	 * @创建时间：2017年3月17日 下午3:59:48 
	 * @Title:
	 * reportMeetSpeedInfo 
	 * @Description: （存上传类型信息） 
	 * @return Out<String> 修改人：
	 * 版本：1.0.0 @throws
	 */
	@PostMapping(value = "findAll/{system_type}")
	@ApiOperation(value = "查询设备号所对应的学校", notes = "查询设备号所对应的学校")
	@ResponseBody
	public List<Robot_School> findAll(@PathVariable("system_type") Integer system_type) {
		Out<String> out = new Out<String>();
		List<Robot_School> findSchollName=null;
		try {
			if(system_type==0){
				findSchollName = fsnr_SchoolService.findSheBei();
			}else{
				findSchollName = fsnr_SchoolService.findSheBei(system_type);
			}
			//将重复的学校取出来后重新进行组装
			for  ( int  i  =   0 ; i  <  findSchollName.size()  -   1 ; i ++ )  {       
		      for  ( int  j  =  findSchollName.size()  -   1 ; j  >  i; j -- )  {       
		           if  (findSchollName.get(j).getSchoolName().equals(findSchollName.get(i).getSchoolName()))  {       
		        	   findSchollName.remove(j);       
		            }        
		        }        
		      }
		} catch (Exception e) {
			logger.error(e.getMessage());
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_MONGO_SAVE, e.getMessage());
		}
		return findSchollName;
	}
	
	@PostMapping(value = "findDeviceNo/{schoolName}/{system_type}")
	@ApiOperation(value = "查询设备号所对应的学校", notes = "查询设备号所对应的学校")
	@ResponseBody
	public List<Robot_School> findDeviceNo(@PathVariable("schoolName") String schoolName,@PathVariable("system_type") Integer system_type) {
		Out<String> out = new Out<String>();
		List<Robot_School> findSchollName=null;
		Robot_School rs=new Robot_School();
		try {
			rs.setSystemType(system_type);
			rs.setSchoolName(schoolName);
			findSchollName=fsnr_SchoolService.findDeviceNo(rs);
		} catch (Exception e) {
			logger.error(e.getMessage());
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_MONGO_SAVE, e.getMessage());
		}
		return findSchollName;
	}
	/**
	 * ==============================================linu硬件的使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "版本信息初始化曲线查询数据----------------------------", notes = "版本信息初始化曲线查询数据")
	@ResponseBody
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type) {
		List<robot_LinuxHardWareUsed> query=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			query = robotMongoDbFindService.findRobot_LinuxHardWareUsed(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(query.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					query = robotMongoDbFindService.findRobot_LinuxHardWareUsed(beginDate,calendar.getTime(),system_type);
				}else{
					return query;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_LinuxHardWareUsed> query=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			query = robotMongoDbFindService.findRobot_LinuxHardWareUsed(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_LinuxHardWareUsed> query=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			query = robotMongoDbFindService.findRobot_LinuxHardWareUsed(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}/{qsTime}/{jsTime}/{deviceNo}/{deviceNo2}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_LinuxHardWareUsedGraph> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo,@PathVariable("deviceNo2") String deviceNo2) {
		List<robot_LinuxHardWareUsed> query=null;
		List<robot_LinuxHardWareUsed> query1=null;
		List<robot_LinuxHardWareUsedGraph> linuxHardWareUsedGraph=new ArrayList<robot_LinuxHardWareUsedGraph>();
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			//得到学校1的信息
			System.err.println(deviceNo+"============="+deviceNo2);
			query = robotMongoDbFindService.findRobot_LinuxHardWareUsed(jsTime1,qsTime1,system_type,deviceNo);
			query1 = robotMongoDbFindService.findRobot_LinuxHardWareUsed(jsTime1,qsTime1,system_type,deviceNo2);
			System.err.println(query.size()+"=========="+query1.size());
			//得出查询出来的信息条数最大的
			if(query.size()>query1.size()){
				for(int i=0;i<query.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===if1========"+i);
					robot_LinuxHardWareUsedGraph graph =new robot_LinuxHardWareUsedGraph();
					graph.setLinux_cpu_used(query.get(i).getLinux_cpu_used());
					graph.setLinux_flash_used(query.get(i).getLinux_flash_used());
					graph.setLinux_memory_used(query.get(i).getLinux_memory_used());
					graph.setLinux_wifi_signal(query.get(i).getLinux_wifi_signal());
					graph.setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
					linuxHardWareUsedGraph.add(graph);
				}
				for(int i=0;i<query1.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===if2==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					linuxHardWareUsedGraph.get(i).setLinux_cpu_used2(query1.get(i).getLinux_cpu_used());
					linuxHardWareUsedGraph.get(i).setLinux_flash_used2(query1.get(i).getLinux_flash_used());
					linuxHardWareUsedGraph.get(i).setLinux_memory_used2(query1.get(i).getLinux_memory_used());
					linuxHardWareUsedGraph.get(i).setLinux_wifi_signal2(query1.get(i).getLinux_wifi_signal());
					linuxHardWareUsedGraph.get(i).setCreateDate2(query1.get(i).getCreateDate().getTime()/1000);
				}
			}else{
				for(int i=0;i<query1.size();i++){
					System.err.println(query1.size());
					System.err.println("===else1==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					robot_LinuxHardWareUsedGraph graph =new robot_LinuxHardWareUsedGraph();
					graph.setLinux_cpu_used2(query1.get(i).getLinux_cpu_used());
					graph.setLinux_flash_used2(query1.get(i).getLinux_flash_used());
					graph.setLinux_memory_used2(query1.get(i).getLinux_memory_used());
					graph.setLinux_wifi_signal2(query1.get(i).getLinux_wifi_signal());
					graph.setCreateDate2(query1.get(i).getCreateDate().getTime()/1000);
					linuxHardWareUsedGraph.add(graph);
				}
				for(int i=0;i<query.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===else2==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					linuxHardWareUsedGraph.get(i).setLinux_cpu_used(query.get(i).getLinux_cpu_used());
					linuxHardWareUsedGraph.get(i).setLinux_flash_used(query.get(i).getLinux_flash_used());
					linuxHardWareUsedGraph.get(i).setLinux_memory_used(query.get(i).getLinux_memory_used());
					linuxHardWareUsedGraph.get(i).setLinux_wifi_signal(query.get(i).getLinux_wifi_signal());
					linuxHardWareUsedGraph.get(i).setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return linuxHardWareUsedGraph;
	}
	
	
	/**
	 *======================================================照片质量本信息======================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "照片信息曲初始化线数据查询", notes = "照片信息曲初始化线数据查询")
	@ResponseBody
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type) {
		List<robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(rPhotographicQualityInfo.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(beginDate,calendar.getTime(),system_type);
				}else{
					return rPhotographicQualityInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rPhotographicQualityInfo;
	}
	
	/**
	 *照片质量本信息
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.POST})
	@ApiOperation(value = "照片信息曲线数据查询", notes = "照片信息曲线数据查询")
	@ResponseBody
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rPhotographicQualityInfo;
	}
	/**
	 *照片质量本信息
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.POST})
	@ApiOperation(value = "照片信息曲线数据查询", notes = "照片信息曲线数据查询")
	@ResponseBody
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rPhotographicQualityInfo;
	}
	/**
	 *照片质量本信息
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{system_type}/{qsTime}/{jsTime}/{deviceNo}/{deviceNo2}", method = {RequestMethod.POST})
	@ApiOperation(value = "照片信息曲线数据查询", notes = "照片信息曲线数据查询")
	@ResponseBody
	public List<robot_PhotographicQualityInfoGraph> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo,@PathVariable("deviceNo2") String deviceNo2) {
		List<robot_PhotographicQualityInfoGraph> rPhotographicQualityInfo=new ArrayList<robot_PhotographicQualityInfoGraph>();
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(jsTime1,qsTime1,system_type,deviceNo);
			List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo2 = robotMongoDbFindService.queryPhotographicQualityInfo(jsTime1,qsTime1,system_type,deviceNo2);
			if(queryPhotographicQualityInfo.size()>queryPhotographicQualityInfo2.size()){
				for(int i=0;i<queryPhotographicQualityInfo.size();i++){
					robot_PhotographicQualityInfoGraph ph=new robot_PhotographicQualityInfoGraph();
					ph.setConfidence_statistics_average(queryPhotographicQualityInfo.get(i).getConfidence_statistics_average());
					ph.setConfidence_statistics_max(queryPhotographicQualityInfo.get(i).getConfidence_statistics_max());
					ph.setConfidence_statistics_min(queryPhotographicQualityInfo.get(i).getConfidence_statistics_min());
					ph.setCreateDate1(queryPhotographicQualityInfo.get(i).getCreateDate().getTime()/1000);
					rPhotographicQualityInfo.add(ph);
				}
				for(int i=0;i<queryPhotographicQualityInfo2.size();i++){
					rPhotographicQualityInfo.get(i).setConfidence_statistics_average2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_average());
					rPhotographicQualityInfo.get(i).setConfidence_statistics_max2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_max());
					rPhotographicQualityInfo.get(i).setConfidence_statistics_min2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_min());
					rPhotographicQualityInfo.get(i).setCreateDate2(queryPhotographicQualityInfo2.get(i).getCreateDate().getTime()/1000);
				}
			}else{
				for(int i=0;i<queryPhotographicQualityInfo2.size();i++){
					robot_PhotographicQualityInfoGraph ph=new robot_PhotographicQualityInfoGraph();
					ph.setConfidence_statistics_average2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_average());
					ph.setConfidence_statistics_max2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_max());
					ph.setConfidence_statistics_min2(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_min());
					ph.setCreateDate2(queryPhotographicQualityInfo2.get(i).getCreateDate().getTime()/1000);
					rPhotographicQualityInfo.add(ph);
				}
				for(int i=0;i<queryPhotographicQualityInfo.size();i++){
					rPhotographicQualityInfo.get(i).setConfidence_statistics_average(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_average());
					rPhotographicQualityInfo.get(i).setConfidence_statistics_max(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_max());
					rPhotographicQualityInfo.get(i).setConfidence_statistics_min(queryPhotographicQualityInfo2.get(i).getConfidence_statistics_min());
					rPhotographicQualityInfo.get(i).setCreateDate1(queryPhotographicQualityInfo2.get(i).getCreateDate().getTime()/1000);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rPhotographicQualityInfo;
	}
	
	/**
	 * ===========================================体重校准信息查询================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCalibrateInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type) {
		List<robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(rCalibrateInfo.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(beginDate,calendar.getTime(),system_type);
				}else{
					return rCalibrateInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCalibrateInfo;
	}
	
	
	@RequestMapping(value = "queryCalibrateInfo/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCalibrateInfo;
	}

	
	@RequestMapping(value = "queryCalibrateInfo/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCalibrateInfo;
	}
	
	/**
	 * =======================================候选人信息查询==========================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCandidatesInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type) {
		List<robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(rCandidatesInfo.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					
					rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(beginDate,calendar.getTime(),system_type);
				}else{
					return rCandidatesInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCandidatesInfo;
	}
	
	@RequestMapping(value = "queryCandidatesInfo/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCandidatesInfo;
	}
	
	@RequestMapping(value = "queryCandidatesInfo/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCandidatesInfo;
	}
	
	/**
	 *======================================================linux板温度信息查询======================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxEnvTemperatureInfoGraph/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "linux板温度信息曲初始化线数据查询", notes = "linux板温度信息曲初始化线数据查询")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfoGraph(@PathVariable("system_type") String system_type) {
		List<robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(rLinuxEnvTemperatureInfo.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(beginDate,calendar.getTime(),system_type);
				}else{
					return rLinuxEnvTemperatureInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	@RequestMapping(value = "queryLinuxEnvTemperatureInfoGraph/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "linux板温度信息曲按条件据查询", notes = "linux板温度信息曲按条件据查询")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfoGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	@RequestMapping(value = "queryLinuxEnvTemperatureInfoGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfoGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	
	@RequestMapping(value = "queryLinuxEnvTemperatureInfoGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}/{deviceNo2}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfoGraph> queryLinuxEnvTemperatureInfoGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo,@PathVariable("deviceNo2") String deviceNo2) {
		List<robot_LinuxEnvTemperatureInfoGraph> rLinuxEnvTemperatureInfo=new ArrayList<robot_LinuxEnvTemperatureInfoGraph>();
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			List<robot_LinuxEnvTemperatureInfo> query = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(jsTime1,qsTime1,system_type,deviceNo);
			List<robot_LinuxEnvTemperatureInfo> query2 = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(jsTime1,qsTime1,system_type,deviceNo2);
			if(query.size()>query2.size()){
				for(int i=0;i<query.size();i++){
					robot_LinuxEnvTemperatureInfoGraph rl=new robot_LinuxEnvTemperatureInfoGraph();
					rl.setLinux_cpu_temperature(query.get(i).getLinux_cpu_temperature());
					rl.setLinux_env_temperature(query.get(i).getLinux_env_temperature());
					rl.setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
					rLinuxEnvTemperatureInfo.add(rl);
				}
				for(int i=0;i<query2.size();i++){
					rLinuxEnvTemperatureInfo.get(i).setLinux_cpu_temperature2(query2.get(i).getLinux_cpu_temperature());
					rLinuxEnvTemperatureInfo.get(i).setLinux_env_temperature2(query2.get(i).getLinux_env_temperature());
					rLinuxEnvTemperatureInfo.get(i).setCreateDate2(query2.get(i).getCreateDate().getTime()/1000);
				}
			}else{
				for(int i=0;i<query2.size();i++){
					robot_LinuxEnvTemperatureInfoGraph rl=new robot_LinuxEnvTemperatureInfoGraph();
					rl.setLinux_cpu_temperature2(query2.get(i).getLinux_cpu_temperature());
					rl.setLinux_env_temperature2(query2.get(i).getLinux_env_temperature());
					rl.setCreateDate2(query2.get(i).getCreateDate().getTime()/1000);
					rLinuxEnvTemperatureInfo.add(rl);
				}
				for(int i=0;i<query.size();i++){
					rLinuxEnvTemperatureInfo.get(i).setLinux_cpu_temperature(query.get(i).getLinux_cpu_temperature());
					rLinuxEnvTemperatureInfo.get(i).setLinux_env_temperature(query.get(i).getLinux_env_temperature());
					rLinuxEnvTemperatureInfo.get(i).setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	/**
	 *======================================================安卓CPU温度信息查询======================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndriodCPUTemperatureGraph/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "linux板温度信息曲初始化线数据查询", notes = "linux板温度信息曲初始化线数据查询")
	@ResponseBody
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperatureGraph(@PathVariable("system_type") String system_type) {
		List<robot_AndriodCPUTemperature> rAndriodCPUTemperature=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			rAndriodCPUTemperature = robotMongoDbFindService.queryAndriodCPUTemperature(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(rAndriodCPUTemperature.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rAndriodCPUTemperature = robotMongoDbFindService.queryAndriodCPUTemperature(beginDate,calendar.getTime(),system_type);
				}else{
					return rAndriodCPUTemperature;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndriodCPUTemperature;
	}
	
	@RequestMapping(value = "queryAndriodCPUTemperatureGraph/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "linux板温度信息曲按条件据查询", notes = "linux板温度信息曲按条件据查询")
	@ResponseBody
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperatureGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_AndriodCPUTemperature> rAndriodCPUTemperature=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rAndriodCPUTemperature = robotMongoDbFindService.queryAndriodCPUTemperature(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndriodCPUTemperature;
	}
	
	@RequestMapping(value = "queryAndriodCPUTemperatureGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperatureGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_AndriodCPUTemperature> rLinuxEnvTemperatureInfo=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryAndriodCPUTemperature(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	
	@RequestMapping(value = "queryAndriodCPUTemperatureGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}/{deviceNo2}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_AndriodCPUTemperatureGraph> queryAndriodCPUTemperatureGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo,@PathVariable("deviceNo2") String deviceNo2) {
		List<robot_AndriodCPUTemperatureGraph> rAndriodCPUTemperature=new ArrayList<robot_AndriodCPUTemperatureGraph>();
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			List<robot_AndriodCPUTemperature> query = robotMongoDbFindService.queryAndriodCPUTemperature(jsTime1,qsTime1,system_type,deviceNo);
			List<robot_AndriodCPUTemperature> query2 = robotMongoDbFindService.queryAndriodCPUTemperature(jsTime1,qsTime1,system_type,deviceNo2);
			System.err.println(query.size()+"========="+query2.size());
			if(query.size()>query2.size()){
				for(int i=0;i<query.size();i++){
					robot_AndriodCPUTemperatureGraph rl=new robot_AndriodCPUTemperatureGraph();
					rl.setAndroid_cpu_temperature(query.get(i).getAndroid_cpu_temperature());
					rl.setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
					rAndriodCPUTemperature.add(rl);
				}
				for(int i=0;i<query2.size();i++){
					rAndriodCPUTemperature.get(i).setAndroid_cpu_temperature2(query2.get(i).getAndroid_cpu_temperature());
					rAndriodCPUTemperature.get(i).setCreateDate2(query2.get(i).getCreateDate().getTime()/1000);
				}
			}else{
				for(int i=0;i<query2.size();i++){
					robot_AndriodCPUTemperatureGraph rl=new robot_AndriodCPUTemperatureGraph();
					rl.setAndroid_cpu_temperature2(query2.get(i).getAndroid_cpu_temperature());
					rl.setCreateDate2(query2.get(i).getCreateDate().getTime()/1000);
					rAndriodCPUTemperature.add(rl);
				}
				for(int i=0;i<query.size();i++){
					rAndriodCPUTemperature.get(i).setAndroid_cpu_temperature(query2.get(i).getAndroid_cpu_temperature());
					rAndriodCPUTemperature.get(i).setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndriodCPUTemperature;
	}
	/**
	 * ==============================================android硬件的使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryandroidHardWareUsedGraph/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "版本信息初始化曲线查询数据----------------------------", notes = "版本信息初始化曲线查询数据")
	@ResponseBody
	public List<robot_AndroidHardWareUsed> queryandroidHardWareUsedGraph(@PathVariable("system_type") String system_type) {
		List<robot_AndroidHardWareUsed> query=null;
		try {
			//由于硬件的使用数据非诚的多，所以在初次显示曲线图时只查询一个小时
			Date beginDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			query = robotMongoDbFindService.queryAndroidHardWareUsed(beginDate,calendar.getTime(),system_type);
			int num=1;
			for(int i=1;i>0;i++){
				num=num+1;
				if(query.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					query = robotMongoDbFindService.queryAndroidHardWareUsed(beginDate,calendar.getTime(),system_type);
				}else{
					return query;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryandroidHardWareUsedGraph/{system_type}/{qsTime}/{jsTime}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_AndroidHardWareUsed> queryandroidHardWareUsedGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime) {
		List<robot_AndroidHardWareUsed> query=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			query = robotMongoDbFindService.queryAndroidHardWareUsed(jsTime1,qsTime1,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryandroidHardWareUsedGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_AndroidHardWareUsed> queryandroidHardWareUsedGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo) {
		List<robot_AndroidHardWareUsed> query=null;
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			query = robotMongoDbFindService.queryAndroidHardWareUsed(jsTime1,qsTime1,system_type,deviceNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	/**
	 * linu硬件的使用
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryandroidHardWareUsedGraph/{system_type}/{qsTime}/{jsTime}/{deviceNo}/{deviceNo2}", method = {RequestMethod.POST})
	@ApiOperation(value = "版本信息曲线查询数据", notes = "版本信息曲线查询数据")
	@ResponseBody
	public List<robot_AndroidHardWareUsedGraph> queryandroidHardWareUsedGraph(@PathVariable("system_type") String system_type,@PathVariable("qsTime") String qsTime,@PathVariable("jsTime") String jsTime,@PathVariable("deviceNo") String deviceNo,@PathVariable("deviceNo2") String deviceNo2) {
		List<robot_AndroidHardWareUsed> query=null;
		List<robot_AndroidHardWareUsed> query1=null;
		List<robot_AndroidHardWareUsedGraph> androidHardWareUsedGraph=new ArrayList<robot_AndroidHardWareUsedGraph>();
		try {
			//将string类型转换为时间类型
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date jsTime1 =  formatter.parse(jsTime);
			Date qsTime1 =	formatter.parse(qsTime);
			//得到学校1的信息
			System.err.println(deviceNo+"============="+deviceNo2);
			query = robotMongoDbFindService.queryAndroidHardWareUsed(jsTime1,qsTime1,system_type,deviceNo);
			query1 = robotMongoDbFindService.queryAndroidHardWareUsed(jsTime1,qsTime1,system_type,deviceNo2);
			System.err.println(query.size()+"=========="+query1.size());
			//得出查询出来的信息条数最大的
			if(query.size()>query1.size()){
				for(int i=0;i<query.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===if1========"+i);
					robot_AndroidHardWareUsedGraph graph =new robot_AndroidHardWareUsedGraph();
					graph.setAndroid_cpu_used(query.get(i).getAndroid_cpu_used());
					graph.setAndroid_flash_used(query.get(i).getAndroid_flash_used());
					graph.setAndroid_memory_used(query.get(i).getAndroid_memory_used());
					graph.setLinux_wifi_signal(query.get(i).getLinux_wifi_signal());
					graph.setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
					androidHardWareUsedGraph.add(graph);
				}
				for(int i=0;i<query1.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===if2==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					androidHardWareUsedGraph.get(i).setAndroid_cpu_used(query1.get(i).getAndroid_cpu_used());
					androidHardWareUsedGraph.get(i).setAndroid_flash_used2(query1.get(i).getAndroid_flash_used());
					androidHardWareUsedGraph.get(i).setAndroid_memory_used2(query1.get(i).getAndroid_memory_used());
					androidHardWareUsedGraph.get(i).setLinux_wifi_signal2(query1.get(i).getLinux_wifi_signal());
					androidHardWareUsedGraph.get(i).setCreateDate2(query1.get(i).getCreateDate().getTime()/1000);
				}
			}else{
				for(int i=0;i<query1.size();i++){
					System.err.println(query1.size());
					System.err.println("===else1==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					robot_AndroidHardWareUsedGraph graph =new robot_AndroidHardWareUsedGraph();
					graph.setAndroid_cpu_used2(query1.get(i).getAndroid_cpu_used());
					graph.setAndroid_flash_used2(query1.get(i).getAndroid_flash_used());
					graph.setAndroid_memory_used2(query1.get(i).getAndroid_memory_used());
					graph.setLinux_wifi_signal2(query1.get(i).getLinux_wifi_signal());
					graph.setCreateDate2(query1.get(i).getCreateDate().getTime()/1000);
					androidHardWareUsedGraph.add(graph);
				}
				for(int i=0;i<query.size();i++){
					System.err.println(formatter.format(query.get(i).getCreateDate())+"===else2==="+formatter.format(query1.get(i).getCreateDate())+"====="+i);
					androidHardWareUsedGraph.get(i).setAndroid_cpu_used(query.get(i).getAndroid_cpu_used());
					androidHardWareUsedGraph.get(i).setAndroid_flash_used(query.get(i).getAndroid_flash_used());
					androidHardWareUsedGraph.get(i).setAndroid_memory_used(query.get(i).getAndroid_memory_used());
					androidHardWareUsedGraph.get(i).setLinux_wifi_signal(query.get(i).getLinux_wifi_signal());
					androidHardWareUsedGraph.get(i).setCreateDate1(query.get(i).getCreateDate().getTime()/1000);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return androidHardWareUsedGraph;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 安卓版本信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndroidHardWareUsed/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_AndroidHardWareUsed> queryAndroidHardWareUsed(@PathVariable("system_type") String system_type) {
		List<robot_AndroidHardWareUsed> rAndroidHardWareUsed=null;
		try {
			rAndroidHardWareUsed = robotMongoDbFindService.queryAndroidHardWareUsed(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndroidHardWareUsed;
	}
	/**
	 * 安卓运行环境信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndroidSoftWareVersion/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<robot_AndroidSoftWareVersion> rAndroidSoftWareVersion=null;
		try {
			rAndroidSoftWareVersion = robotMongoDbFindService.queryAndroidSoftWareVersion(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndroidSoftWareVersion;
	}
	
	
	
	/**
	 * 程序运行状态----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAppRunningStatus/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_AppRunningStatus> queryAppRunningStatus(@PathVariable("system_type") String system_type) {
		List<robot_AppRunningStatus> rAppRunningStatus=null;
		try {
			rAppRunningStatus = robotMongoDbFindService.queryAppRunningStatus(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAppRunningStatus;
	}
	
	
	
	

	/**
	 * 候选人信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryFinalRecogResult/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_FinalRecogResult> queryFinalRecogResult(@PathVariable("system_type") String system_type) {
		List<robot_FinalRecogResult> rFinalRecogResult=null;
		try {
			rFinalRecogResult = robotMongoDbFindService.queryFinalRecogResult(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rFinalRecogResult;
	}
	
	
	/**
	 * linux运行环境温度查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxEnvTemperatureInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(@PathVariable("system_type") String system_type) {
		List<robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
		try {
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxEnvTemperatureInfo;
	}
	
	/**
	 * linuc的CPU的ECID号----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxHardWareInfo> queryLinuxHardWareInfo(@PathVariable("system_type") String system_type) {
		List<robot_LinuxHardWareInfo> rLinuxHardWareInfo=null;
		try {
			rLinuxHardWareInfo = robotMongoDbFindService.queryLinuxHardWareInfo(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxHardWareInfo;
	}
	/**
	 * lunix版本信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxSoftWareVersion/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<robot_LinuxSoftWareVersion> rVersionInfo=null;
		try {
			rVersionInfo = robotMongoDbFindService.queryLinuxSoftWareVersion(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rVersionInfo;
	}
	/**
	 *linux的重启信息----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxStartUpRecord/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxStartUpRecord> queryLinuxStartUpRecord(@PathVariable("system_type") String system_type) {
		List<robot_LinuxStartUpRecord> rLinuxStartUpRecord=null;
		try {
			rLinuxStartUpRecord = robotMongoDbFindService.queryLinuxStartUpRecord(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxStartUpRecord;
	}
	/**
	 *运动控制软件版本信息----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryMotionSoftWareVersion/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_MotionSoftWareVersion> queryMotionSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<robot_MotionSoftWareVersion> rMotionSoftWareVersion=null;
		try {
			rMotionSoftWareVersion = robotMongoDbFindService.queryMotionSoftWareVersion(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rMotionSoftWareVersion;
	}
	
	
	
	/**
	 *自检信息----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "querySelfLnspectionInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_SelfLnspectionInfo> querySelfLnspectionInfo(@PathVariable("system_type") String system_type) {
		List<robot_SelfLnspectionInfo> rSelfLnspectionInfo=null;
		try {
			rSelfLnspectionInfo = robotMongoDbFindService.querySelfLnspectionInfo(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rSelfLnspectionInfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 查询所有的学校----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "selectSchool", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询所有的学校", notes = "查询所有的学校")
	@ResponseBody
	public List<Robot_School> selectSchool() {
		List<Robot_School> operationInfo=null;
		try {
			operationInfo = robotMongoDbFindService.selectSchool();
			//去掉重复的学校名称并返回
			for  ( int  i  =   0 ; i  <  operationInfo.size()  -   1 ; i ++ )  {       
		        for  ( int  j  =  operationInfo.size()  -   1 ; j  >  i; j -- )  {       
		           if  (operationInfo.get(j).getSchoolName().equals(operationInfo.get(i).getSchoolName()))  {
		        	   operationInfo.remove(j);
		            }        
		        }        
		     }        
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return operationInfo;
	}
	/**
	 * 查询所属学校的小诺----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "selectSchoolName／{schoolName}", method = {RequestMethod.POST})
	@ApiOperation(value = "查询所属学校的小诺", notes = "查询所属学校的小诺")
	@ResponseBody
	public List<Robot_School> selectSchoolName(@PathVariable("schoolName") String schoolName) {
		List<Robot_School> operationInfo=null;
		try {
			operationInfo = robotMongoDbFindService.selectSchoolName(schoolName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return operationInfo;
	}
	@RequestMapping(value = "selectType", method = {RequestMethod.POST})
	@ApiOperation(value = "查询所有需要上传的类型", notes = "查询所有需要上传的类型")
	@ResponseBody
	public List<robot_UploadType> selectType() {
		List<robot_UploadType> operationInfo=null;
		try {
			operationInfo = robotMongoDbFindService.selectType();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return operationInfo;
	}
	
	//查询linux板温度信息曲线 queryLinuxEnvTemperatureInfoGraph
	
}