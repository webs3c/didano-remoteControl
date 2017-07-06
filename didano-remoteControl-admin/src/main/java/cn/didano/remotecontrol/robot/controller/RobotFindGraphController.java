package cn.didano.remotecontrol.robot.controller;

import java.text.SimpleDateFormat;
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
import cn.didano.remotecontrol.base.robot.data.robot_AndroidHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.robot_AndroidSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_AppRunningStatus;
import cn.didano.remotecontrol.base.robot.data.robot_CalibrateInfo;
import cn.didano.remotecontrol.base.robot.data.robot_CandidatesInfo;
import cn.didano.remotecontrol.base.robot.data.robot_FinalRecogResult;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxEnvTemperatureInfo;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareInfo;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_LinuxStartUpRecord;
import cn.didano.remotecontrol.base.robot.data.robot_MotionSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.robot_PhotographicQualityInfo;
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
//	/**
//	 * 自定义的查询服务：首先我们来看看MongoRepository的仓库中只有简单的怎删查改的基本方法，想要实现自己的查询，只有遵循把的规则自己定义查询的方法
//	 * 需求：查询最新数据的最后50条的数据
//	 * 只用一次的查询时做不到的，那么只能间接性的查询服务，首先得到数据库中的总数据条数，
//	 * @return
//	 */
//	@RequestMapping(value = "selectSchoolName", method = {RequestMethod.POST})
//	@ApiOperation(value = "查询所属学校的小诺", notes = "查询所属学校的小诺")
//	@ResponseBody
//	public void aaa() {
//		 	MongoClient mongoClient = new MongoClient( "119.23.152.164" , 27017);//建立连接  
//	        DB get_db_credit = mongoClient.getDB("remoteControl");//数据库名  
//	        DBCollection collection = get_db_credit.getCollection("Robot_PhotographicQualityInfo");//集合名，对应mysql中的表名  
//	        BasicDBObject filter_dbobject = new BasicDBObject();  
//	  
//	        //建立查询条件,如果还有其他条件，类似的写即可  
//	        // 如:version=3,filter_dbobject.put("version", 3),mongod区分String 和 Integer类型，所以要小心"3"!=3  
//	        filter_dbobject.put("user_id", "10065716153075");  
//	  
//	        //下面执行查询，设置limit,只要10条数据,排序(类mysql orderby) 再建一个BasicDBObject即可，－1表示倒序  
//	        DBCursor cursor = collection.find(filter_dbobject).limit(10).sort(new BasicDBObject("create_time",-1));  
//	  
//	        //把结果集输出成list类型  
//	        List<DBObject> list = cursor.toArray();  
//	        System.out.println(list.size());//list的长度  
//	        System.err.println(cursor.count());//计算结果的数量，类似于(mysql count()函数),不受limit的影响  
//	  
//	          
//	        //遍历结果集  
//	        while(cursor.hasNext()) {  
//	            System.out.println(cursor.next());  
//	        }  
//	}
}