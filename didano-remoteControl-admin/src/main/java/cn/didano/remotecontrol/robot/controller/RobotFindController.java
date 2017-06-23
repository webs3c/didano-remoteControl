package cn.didano.remotecontrol.robot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.didano.base.model.Robot_School;
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
	@Autowired
	private Datastore datastore;
	
	
	/**
	 * 安卓版本信息查询----------------------------------------------------------------------------------------------------------------------------
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryAndroidHardWareUsed/{system_type}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "查询版本信息,并且不分页", notes = "查询版本信息,并且不分页")
	@ResponseBody
	public List<Robot_AndroidHardWareUsed> queryAndroidHardWareUsed(@PathVariable("system_type") String system_type) {
		List<Robot_AndroidHardWareUsed> rAndroidHardWareUsed=null;
		try {
			System.err.println(system_type+"查询版本讯息");
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
	public List<Robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<Robot_AndroidSoftWareVersion> rAndroidSoftWareVersion=null;
		try {
			rAndroidSoftWareVersion = robotMongoDbFindService.queryAndroidSoftWareVersion(system_type);
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
	public List<Robot_CalibrateInfo> queryCalibrateInfo(@PathVariable("system_type") String system_type) {
		List<Robot_CalibrateInfo> rCalibrateInfo=null;
		try {
			rCalibrateInfo = robotMongoDbFindService.queryCalibrateInfo(system_type);
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
	public List<Robot_AppRunningStatus> queryAppRunningStatus(@PathVariable("system_type") String system_type) {
		List<Robot_AppRunningStatus> rAppRunningStatus=null;
		try {
			rAppRunningStatus = robotMongoDbFindService.queryAppRunningStatus(system_type);
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
	public List<Robot_CandidatesInfo> queryCandidatesInfo(@PathVariable("system_type") String system_type) {
		List<Robot_CandidatesInfo> rCandidatesInfo=null;
		try {
			rCandidatesInfo = robotMongoDbFindService.queryCandidatesInfo(system_type);
			for (Robot_CandidatesInfo robot_CandidatesInfo : rCandidatesInfo) {
				System.err.println(robot_CandidatesInfo.getCreateDate());
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
	public List<Robot_FinalRecogResult> queryFinalRecogResult(@PathVariable("system_type") String system_type) {
		List<Robot_FinalRecogResult> rFinalRecogResult=null;
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
	public List<Robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(@PathVariable("system_type") String system_type) {
		List<Robot_LinuxEnvTemperatureInfo> rLinuxEnvTemperatureInfo=null;
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
	public List<Robot_LinuxHardWareInfo> queryLinuxHardWareInfo(@PathVariable("system_type") String system_type) {
		List<Robot_LinuxHardWareInfo> rLinuxHardWareInfo=null;
		try {
			rLinuxHardWareInfo = robotMongoDbFindService.queryLinuxHardWareInfo(system_type);
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
	public List<Robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type) {
		List<Robot_LinuxHardWareUsed> query=null;
		try {
//			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date beginDate = new Date();
//			Calendar date = Calendar.getInstance();
//			date.setTime(beginDate);
//			date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
//			Date endDate = dft.parse(dft.format(date.getTime()));
//			System.err.println(beginDate);
//			System.err.println(endDate);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("一个小时前的时间：" + df.format(calendar.getTime()));
			System.out.println("当前的时间：" + df.format(new Date()));
			query = robotMongoDbFindService.queryLinuxHardWareUsed(system_type);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return query;
	}
	/**
	 * ==============================================linu硬件表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	@RequestMapping(value = "queryLinuxHardWareUsed/{system_type}/{arr}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "版本信息初始化曲线查询数据", notes = "版本信息初始化曲线查询数据")
	@ResponseBody
	public List<Robot_LinuxHardWareUsed> queryLinuxHardWareUsed(@PathVariable("system_type") String system_type,@PathVariable("arr") String arr) {
		List<Robot_LinuxHardWareUsed> query=null;
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<Robot_LinuxHardWareUsed> query123 = datastore.createQuery(Robot_LinuxHardWareUsed.class);
			for(int i=0,len=strs.length;i<len;i++){
				String[] aa=strs[i].split(":");
				//filter之间使用and连接起来
				if(aa[1].toString()!="" && aa[0].toString()=="deviceNo"){
					query123.filter("deviceNo=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_cpu_used"){
					query123.filter("linux_cpu_used=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_cpu_used_app"){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。
					query123.filter("linux_cpu_used_app=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_cpu_used_time1"){
					query123.filter("linux_cpu_used_time1>=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_cpu_used_time2"){
					query123.filter("linux_cpu_used_time2<=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_flash_used"){
					query123.filter("linux_flash_used=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_flash_used_time1"){
					query123.filter("linux_flash_used_time1>=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_flash_used_time2"){
					query123.filter("linux_flash_used_time2<=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_memory_used"){
					query123.filter("linux_memory_used=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_memory_used_app"){
					query123.filter("linux_memory_used_app=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_memory_used_time1"){
					query123.filter("linux_memory_used_time1>=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_memory_used_time2"){
					query123.filter("linux_memory_used_time2<=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_wifi_signal"){
					query123.filter("linux_wifi_signal=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_wifi_signal_time1"){
					query123.filter("linux_wifi_signal_time1>=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="linux_wifi_signal_time2"){
					query123.filter("linux_wifi_signal_time2<=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="createDate1"){
					query123.filter("createDate1>=",aa[1].toString());
				}else if(aa[1].toString()!="" && aa[0].toString()=="createDate2"){
					query123.filter("createDate2<=",aa[1].toString());
				}
			}
			for (Robot_LinuxHardWareUsed robot_LinuxHardWareUsed : query123) {
				System.err.println(robot_LinuxHardWareUsed.getCreateDate());
			}
			/*Morphia morphia; 
			MongoClient mongoClient; 

			morphia = new Morphia();
			// Person is an entity object with Morphia annotations
			morphia.map(Robot_LinuxHardWareUsed.class);
			System.err.println(Robot_LinuxHardWareUsed.class);
			// THESE properties MUST be read from environment variables in Spring BOOT.
			 String host = "localhost";
			 int port = 27017;

			mongoClient = new MongoClient(host, port);*/
			
			//Set database
			// this instance would be autowired all data access classes
			/*Morphia morphia;
			morphia = new Morphia();
			morphia.map(Robot_LinuxHardWareUsed.class);*/
			//Datastore ds  = morphia.createDatastore(mongoClient, "remoteControl");
//			Datastore ds  = morphia.createDatastore(mongoClient, "test");
//			ds.ensureIndexes();
//			Query<Robot_LinuxHardWareUsed> query123 = ds.createQuery(Robot_LinuxHardWareUsed.class);
			
			//Query<Robot_LinuxHardWareUsed> filter = query123.filter("linux_cpu_used", "800");
			//MorphiaIterator<Robot_LinuxHardWareUsed,Robot_LinuxHardWareUsed> fetch = query123.where("{deviceNo:123}").fetch();
			
			
//			Robot_LinuxHardWareUsed robot_LinuxHardWareUsed2 = query123.get();
//			System.err.println(robot_LinuxHardWareUsed2.getDeviceNo());
//			for (Robot_LinuxHardWareUsed robot_LinuxHardWareUsed : user) {
//				System.err.println(robot_LinuxHardWareUsed.getCreateDate());
//			}
			
			
//			Morphia morphia;
//			Datastore datastore;
			//不是任何的包，而是定义的类
			/*QRobot_LinuxHardWareUsed qRobot_LinuxHardWareUsed = new QRobot_LinuxHardWareUsed("robot_LinuxHardWareUsed");
			MorphiaQuery<Robot_LinuxHardWareUsed> query1 = new MorphiaQuery<Robot_LinuxHardWareUsed>(morphia, ds, qRobot_LinuxHardWareUsed);
			List<Robot_LinuxHardWareUsed> list =query1.fetch();
			
			for (Robot_LinuxHardWareUsed robot_LinuxHardWareUsed : list) {
				System.err.println(robot_LinuxHardWareUsed.getDeviceNo()+"-----------");
			}*/
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
	public List<Robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<Robot_LinuxSoftWareVersion> rVersionInfo=null;
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
	public List<Robot_LinuxStartUpRecord> queryLinuxStartUpRecord(@PathVariable("system_type") String system_type) {
		List<Robot_LinuxStartUpRecord> rLinuxStartUpRecord=null;
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
	public List<Robot_MotionSoftWareVersion> queryMotionSoftWareVersion(@PathVariable("system_type") String system_type) {
		List<Robot_MotionSoftWareVersion> rMotionSoftWareVersion=null;
		try {
			rMotionSoftWareVersion = robotMongoDbFindService.queryMotionSoftWareVersion(system_type);
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
	public List<Robot_PhotographicQualityInfo> queryPhotographicQualityInfo(@PathVariable("system_type") String system_type) {
		List<Robot_PhotographicQualityInfo> rPhotographicQualityInfo=null;
		try {
			
			rPhotographicQualityInfo = robotMongoDbFindService.queryPhotographicQualityInfo(system_type);
			System.err.println(rPhotographicQualityInfo.size());
			int i=0;
			for (Robot_PhotographicQualityInfo robot_PhotographicQualityInfo : rPhotographicQualityInfo) {
				i=i+1;
			}
			System.err.println(i);
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
	public List<Robot_SelfLnspectionInfo> querySelfLnspectionInfo(@PathVariable("system_type") String system_type) {
		List<Robot_SelfLnspectionInfo> rSelfLnspectionInfo=null;
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