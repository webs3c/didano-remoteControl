package cn.didano.remotecontrol.robot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import cn.didano.remotecontrol.base.robot.service.RobotMorphiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊断平台api服务
 * 诊断查询服务
 * 
 * @author stephen Created on 2016年12月17日 下午6:38:30
 */
@Api(value = "诊断平台morphia查询服务", tags = "自身的mongodb查询已经不满足需求，引入morphia")
@RestController
@RequestMapping(value = "/robot/morphia/")
public class RobotMorphiaController {
	static Logger logger = Logger.getLogger(RobotMorphiaController.class);
	@Autowired
	private RobotMorphiaService robotMorphiaService;
	
	/**
	 * ==============================================linu硬件表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "linu硬件表格数据查询使用", notes = "linu硬件表格数据查询使用")
	@ResponseBody
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_LinuxHardWareUsed> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryLinuxHardWareUsed(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================照片表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryPhotographicQualityInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "照片表格数据查询使用", notes = "照片表格数据查询使用")
	@ResponseBody
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_PhotographicQualityInfo> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryPhotographicQualityInfo(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================安卓软件版本表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndroidSoftWareVersion/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "安卓软件版本表格数据查询使用", notes = "安卓软件版本表格数据查询使用")
	@ResponseBody
	public List<robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_AndroidSoftWareVersion> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryAndroidSoftWareVersion(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return query;
	}
	
	/**
	 * ==============================================程序运行状态表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAppRunningStatus/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "程序运行状态表格数据查询使用", notes = "程序运行状态表格数据查询使用")
	@ResponseBody
	public List<robot_AppRunningStatus> queryAppRunningStatus(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_AppRunningStatus> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryAppRunningStatus(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================校准信息查询表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCalibrateInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "校准信息查询表格数据查询使用", notes = "校准信息查询表格数据查询使用")
	@ResponseBody
	public List<robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_CalibrateInfo> query=null;
		try { 
			System.err.println(arr);
			query = robotMorphiaService.queryCalibrateInfo(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	

	/**
	 * ==============================================候选人信息查询表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryCandidatesInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "校准信息查询表格数据查询使用", notes = "校准信息查询表格数据查询使用")
	@ResponseBody
	public List<robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_CandidatesInfo> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryCandidatesInfo(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================校准信息查询表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryFinalRecogResult/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "校准信息查询表格数据查询使用", notes = "最终识别结果表格数据查询使用")
	@ResponseBody
	public List<robot_FinalRecogResult> queryFinalRecogResult(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_FinalRecogResult> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryFinalRecogResult(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================Linux板温度信息表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxEnvTemperatureInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "校准信息查询表格数据查询使用", notes = "最终识别结果表格数据查询使用")
	@ResponseBody
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_LinuxEnvTemperatureInfo> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryLinuxEnvTemperatureInfo(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================硬件信息表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "校准信息查询表格数据查询使用", notes = "最终识别结果表格数据查询使用")
	@ResponseBody
	public List<robot_LinuxHardWareInfo> queryLinuxHardWareInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_LinuxHardWareInfo> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryLinuxHardWareInfo(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================Linux软件版本信息表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxSoftWareVersion/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "Linux软件版本信息表格数据查询使用", notes = "Linux软件版本信息表格数据查询使用")
	@ResponseBody
	public List<robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_LinuxSoftWareVersion> query=null;
		try { 
			System.err.println(arr);
			query = robotMorphiaService.queryLinuxSoftWareVersion(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}

	/**
	 * ==============================================启动原因信息表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxStartUpRecord/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "启动原因信息表格数据查询使用", notes = "启动原因信息表格数据查询使用")
	@ResponseBody
	public List<robot_LinuxStartUpRecord> queryLinuxStartUpRecord(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_LinuxStartUpRecord> query=null;
		try {
			System.err.println(arr);
			query = robotMorphiaService.queryLinuxStartUpRecord(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ===============================================运用运动软件版本数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryMotionSoftWareVersion/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "=运用运动软件版本数据查询使用", notes = "=运用运动软件版本数据查询使用")
	@ResponseBody
	public List<robot_MotionSoftWareVersion> queryMotionSoftWareVersion(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<robot_MotionSoftWareVersion> query=null;
		try {
			query = robotMorphiaService.queryMotionSoftWareVersion(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ===============================================自检信息数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "querySelfLnspectionInfo/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "自检信息数据查询使用", notes = "自检信息数据查询使用")
	@ResponseBody
	public List<robot_SelfLnspectionInfo> querySelfLnspectionInfo(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		
		List<robot_SelfLnspectionInfo> query=null;
		try {
			System.err.println(arr+"++++++++++++"+arr);
			query = robotMorphiaService.querySelfLnspectionInfo(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
	/**
	 * ===============================================自检信息数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndroidHardWareUsed/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "自检信息数据查询使用", notes = "自检信息数据查询使用")
	@ResponseBody
	public List<robot_AndroidHardWareUsed> queryAndroidHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		
		List<robot_AndroidHardWareUsed> query=null;
		try {
			System.err.println(arr+"++++++++++++"+arr);
			query = robotMorphiaService.queryAndroidHardWareUsed(arr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	/**
	 * ===============================================自检信息数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndriodCPUTemperature/{arr}/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "自检信息数据查询使用", notes = "自检信息数据查询使用")
	@ResponseBody
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperature(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		
		List<robot_AndriodCPUTemperature> query=null;
		try {
			System.err.println(arr+"++++++++++++"+arr);
			query = robotMorphiaService.queryAndriodCPUTemperature(arr,system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	
}