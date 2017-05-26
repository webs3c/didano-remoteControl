package cn.didano.remotecontrol.robot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.didano.remotecontrol.base.robot.data.Robot_AndroidHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.Robot_AndroidSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.Robot_AppRunningStatus;
import cn.didano.remotecontrol.base.robot.data.Robot_CalibrateInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_CandidatesInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_FinalRecogResult;
import cn.didano.remotecontrol.base.robot.data.Robot_LinuxEnvTemperatureInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_LinuxHardWareInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_LinuxHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.Robot_LinuxSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.Robot_LinuxStartUpRecord;
import cn.didano.remotecontrol.base.robot.data.Robot_MotionSoftWareVersion;
import cn.didano.remotecontrol.base.robot.data.Robot_PhotographicQualityInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_SelfLnspectionInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_UploadType;
import cn.didano.remotecontrol.base.robot.data.Robot_school;
import cn.didano.remotecontrol.base.robot.service.RobotMongoDbFindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊断平台api服务
 * 诊断查询服务
 * 
 * @author stephen Created on 2016年12月17日 下午6:38:30
 */
@Api(value = "诊断查询服务", tags = "诊断查询服务")
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
	@RequestMapping(value = "queryAndroidHardWareUsed", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_AndroidHardWareUsed> queryAndroidHardWareUsed() {
		List<Robot_AndroidHardWareUsed> rAndroidHardWareUsed=null;
		try {
			rAndroidHardWareUsed = robotMongoDbFindService.queryAndroidHardWareUsed();
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
	@RequestMapping(value = "queryAndroidSoftWareVersion", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion() {
		List<Robot_AndroidSoftWareVersion> rAndroidSoftWareVersion=null;
		try {
			rAndroidSoftWareVersion = robotMongoDbFindService.queryAndroidSoftWareVersion();
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
	@RequestMapping(value = "queryCalibrateInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_CalibrateInfo> queryCalibrateInfo() {
		List<Robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo();
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
	@RequestMapping(value = "queryAppRunningStatus", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_AppRunningStatus> queryAppRunningStatus() {
		List<Robot_AppRunningStatus> rAppRunningStatus=null;
		try {
			rAppRunningStatus = robotMongoDbFindService.queryAppRunningStatus();
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
	@RequestMapping(value = "queryCandidatesInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_CandidatesInfo> queryCandidatesInfo() {
		List<Robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo();
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
	@RequestMapping(value = "queryFinalRecogResult", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_FinalRecogResult> queryFinalRecogResult() {
		List<Robot_FinalRecogResult> rFinalRecogResult=null;
		try {
			rFinalRecogResult = robotMongoDbFindService.queryFinalRecogResult();
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
	@RequestMapping(value = "queryLinuxEnvTemperatureInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo() {
		List<Robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
		try {
			rLinuxEnvTemperatureInfo = robotMongoDbFindService.queryLinuxEnvTemperatureInfo();
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
	@RequestMapping(value = "queryLinuxHardWareInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_LinuxHardWareInfo> queryLinuxHardWareInfo() {
		List<Robot_LinuxHardWareInfo> rLinuxHardWareInfo=null;
		try {
			rLinuxHardWareInfo = robotMongoDbFindService.queryLinuxHardWareInfo();
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
	@RequestMapping(value = "queryLinuxHardWareUsed", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_LinuxHardWareUsed> queryLinuxHardWareUsed() {
		List<Robot_LinuxHardWareUsed> rLinuxHardWareUsed=null;
		try {
			rLinuxHardWareUsed = robotMongoDbFindService.queryLinuxHardWareUsed();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rLinuxHardWareUsed;
	}
	
	/**
	 * lunix版本信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxSoftWareVersion", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion() {
		List<Robot_LinuxSoftWareVersion> rVersionInfo=null;
		try {
			rVersionInfo = robotMongoDbFindService.queryLinuxSoftWareVersion();
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
	@RequestMapping(value = "queryLinuxStartUpRecord", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_LinuxStartUpRecord> queryLinuxStartUpRecord() {
		List<Robot_LinuxStartUpRecord> rLinuxStartUpRecord=null;
		try {
			rLinuxStartUpRecord = robotMongoDbFindService.queryLinuxStartUpRecord();
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
	@RequestMapping(value = "queryMotionSoftWareVersion", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_MotionSoftWareVersion> queryMotionSoftWareVersion() {
		List<Robot_MotionSoftWareVersion> rMotionSoftWareVersion=null;
		try {
			rMotionSoftWareVersion = robotMongoDbFindService.queryMotionSoftWareVersion();
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
	@RequestMapping(value = "queryPhotographicQualityInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_PhotographicQualityInfo> queryPhotographicQualityInfo() {
		List<Robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo();
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
	@RequestMapping(value = "querySelfLnspectionInfo", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_SelfLnspectionInfo> querySelfLnspectionInfo() {
		List<Robot_SelfLnspectionInfo> rSelfLnspectionInfo=null;
		try {
			rSelfLnspectionInfo = robotMongoDbFindService.querySelfLnspectionInfo();
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
	public List<Robot_school> selectSchool() {
		List<Robot_school> operationInfo=null;
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
	public List<Robot_school> selectSchoolName(@PathVariable("schoolName") String schoolName) {
		List<Robot_school> operationInfo=null;
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
	public List<Robot_UploadType> selectType() {
		List<Robot_UploadType> operationInfo=null;
		try {
			operationInfo = robotMongoDbFindService.selectType();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return operationInfo;
	}
	
}