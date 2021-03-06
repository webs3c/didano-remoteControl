package cn.didano.remotecontrol.robot.controller;

import java.text.SimpleDateFormat;
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
import cn.didano.remotecontrol.base.robot.data.robot_AndriodCPUTemperature;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊断平台api服务
 * 诊断查询服务
 * 
 * @author stephen Created on 2016年12月17日 下午6:38:30
 */
@Api(value = "诊断平台初始化查询服务", tags = "根据不同的条件需求进行初始化的查询服务")
@RestController
@RequestMapping(value = "/robot/find/")
public class RobotFindController {
	static Logger logger = Logger.getLogger(RobotFindController.class);
	@Autowired
	private RobotMongoDbFindService robotMongoDbFindService;
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
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			System.err.println(system_type+"查询版本讯息");
			rAndroidHardWareUsed = robotMongoDbFindService.queryAndroidHardWareUsed(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rAndroidHardWareUsed.size()<1){
					num=num+10;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rAndroidHardWareUsed = robotMongoDbFindService.queryAndroidHardWareUsed(getDate(),calendar.getTime(),system_type);
					if(num>=480){
						return null;
					}
				}else{
					return rAndroidHardWareUsed;
				}
			}
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
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rAndroidSoftWareVersion = robotMongoDbFindService.queryAndroidSoftWareVersion(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rAndroidSoftWareVersion.size()<1){
					num=num+10;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rAndroidSoftWareVersion = robotMongoDbFindService.queryAndroidSoftWareVersion(getDate(),calendar.getTime(),system_type);
					if(num>=480){
						return null;
					}
				}else{
					return rAndroidSoftWareVersion;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAndroidSoftWareVersion;
	}
	
	/**
	 * 体重校准信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCalibrateInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type) {
		List<robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rCalibrateInfo.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rCalibrateInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCalibrateInfo;
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
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rAppRunningStatus = robotMongoDbFindService.queryAppRunningStatus(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rAppRunningStatus.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rAppRunningStatus = robotMongoDbFindService.queryAppRunningStatus(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rAppRunningStatus;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rAppRunningStatus;
	}
	
	
	/**
	 * 识别信息你查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCandidatesInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type) {
		List<robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			int num=1;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 12);
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rCandidatesInfo.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rCandidatesInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rCandidatesInfo;
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
			int num=2;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rFinalRecogResult = robotMongoDbFindService.queryFinalRecogResult(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rFinalRecogResult.size()<1){
					num=num+2;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rFinalRecogResult = robotMongoDbFindService.queryFinalRecogResult(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rFinalRecogResult;
				}
			}
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
			int num=2;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			//僵尸间转换后显示
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = formatter.format(getDate());
			String format1 = formatter.format(calendar.getTime());
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rLinuxEnvTemperatureInfo.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rLinuxEnvTemperatureInfo;
				}
			}
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
			int num=3;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rLinuxHardWareInfo = robotMongoDbFindService.queryLinuxHardWareInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rLinuxHardWareInfo.size()<1){
					num=num+3;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rLinuxHardWareInfo = robotMongoDbFindService.queryLinuxHardWareInfo(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rLinuxHardWareInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxHardWareInfo;
	}
	
	
	/**
	 * linu硬件的使用----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type) {
		List<robot_LinuxHardWareUsed> query=null;
		try {
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			query = robotMongoDbFindService.queryLinuxHardWareUsed(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(query.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					query = robotMongoDbFindService.queryLinuxHardWareUsed(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
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
			int num=12;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rVersionInfo = robotMongoDbFindService.queryLinuxSoftWareVersion(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rVersionInfo.size()<1){
					num=num+2;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rVersionInfo = robotMongoDbFindService.queryLinuxSoftWareVersion(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rVersionInfo;
				}
			}
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
			int num=12;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rLinuxStartUpRecord = robotMongoDbFindService.queryLinuxStartUpRecord(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rLinuxStartUpRecord.size()<1){
					num=num+2;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rLinuxStartUpRecord = robotMongoDbFindService.queryLinuxStartUpRecord(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rLinuxStartUpRecord;
				}
			}
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
			int num=12;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rMotionSoftWareVersion = robotMongoDbFindService.queryMotionSoftWareVersion(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rMotionSoftWareVersion.size()<1){
					num=num+2;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rMotionSoftWareVersion = robotMongoDbFindService.queryMotionSoftWareVersion(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
				}else{
					return rMotionSoftWareVersion;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rMotionSoftWareVersion;
	}
	
	/**
	 *照片质量本信息----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type) {
		List<robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			int num=1;
			//初始化查询一天的数据
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rPhotographicQualityInfo.size()<1){
					num=num+1;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(getDate(),calendar.getTime(),system_type);
					if(num>=24){
						return null;
					}
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
			int num=24;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -num);
			rSelfLnspectionInfo = robotMongoDbFindService.querySelfLnspectionInfo(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				if(rSelfLnspectionInfo.size()<1){
					num=num+2;
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rSelfLnspectionInfo = robotMongoDbFindService.querySelfLnspectionInfo(getDate(),calendar.getTime(),system_type);
					if(num>=48){
						return null;
					}
				}else{
					return rSelfLnspectionInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rSelfLnspectionInfo;
	}
	
	
	/**
	 *安卓cpu温度信息----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndriodCPUTemperature/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "安卓cpu温度信息", notes = "安卓cpu温度信息")
	@ResponseBody
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperature(@PathVariable("system_type") String system_type) {
		List<robot_AndriodCPUTemperature> rSelfLnspectionInfo=null;
		try {
			int num=12;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -12);
			rSelfLnspectionInfo = robotMongoDbFindService.queryAndriodCPUTemperature(getDate(),calendar.getTime(),system_type);
			for(int i=1;i>0;i++){
				num=num+1;
				if(rSelfLnspectionInfo.size()<1){
					calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - num);
					rSelfLnspectionInfo = robotMongoDbFindService.queryAndriodCPUTemperature(getDate(),calendar.getTime(),system_type);
				}else{
					return rSelfLnspectionInfo;
				}
			}
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
	
	public Date getDate(){
		return new Date();
	}
}