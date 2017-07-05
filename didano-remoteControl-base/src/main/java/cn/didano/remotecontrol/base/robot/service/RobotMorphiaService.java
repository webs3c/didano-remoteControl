package cn.didano.remotecontrol.base.robot.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/**
 * 诊断平台信息服务，面对mongodb数据库
 * 
 * @author stephen.wang
 *
 */
@Service
public class RobotMorphiaService {
	static Logger logger = Logger.getLogger(RobotMorphiaService.class);
	@Autowired
	private Datastore datastore;
	//全局时间转换
	public SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
	
	//判断是否是指定的格式  是指定的格式转化为formatter  不是一律转换为formatter2
	public boolean getDate(String str){
		boolean a=true;
		try {
			formatter.parse(str);
		} catch (Exception e) {
			a=false;
		}
		return a;
	}
	
	/**
	 * ==============================================linu硬件表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(String arr) {
		List<robot_LinuxHardWareUsed> query=new ArrayList<robot_LinuxHardWareUsed>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_LinuxHardWareUsed> query1 = datastore.createQuery(robot_LinuxHardWareUsed.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_cpu_used")){
					query1.filter("linux_cpu_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_cpu_used_app")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("linux_cpu_used_app =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_cpu_used_time1")){
					query1.filter("linux_cpu_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_flash_used")){
					query1.filter("linux_flash_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_flash_used_time1")){
					query1.filter("linux_flash_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used")){
					query1.filter("linux_memory_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used_app")){
					query1.filter("linux_memory_used_app =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used_time1")){
					query1.filter("linux_memory_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_wifi_signal")){
					query1.filter("linux_wifi_signal =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_wifi_signal_time1")){
					query1.filter("linux_wifi_signal_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_LinuxHardWareUsed robot_LinuxHardWareUsed : query1) {
				query.add(robot_LinuxHardWareUsed);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================照片表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(String arr) {
		List<robot_PhotographicQualityInfo> query=new ArrayList<robot_PhotographicQualityInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_PhotographicQualityInfo> query1 = datastore.createQuery(robot_PhotographicQualityInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("confidence_statistics_max1")){
					query1.filter("confidence_statistics_max =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("confidence_statistics_average1")){
					query1.filter("confidence_statistics_average =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("confidence_statistics_min1")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("confidence_statistics_min =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_PhotographicQualityInfo photographicQualityInfo : query1) {
				query.add(photographicQualityInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================安卓硬件表格数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_AndroidHardWareUsed> queryAndroidHardWareUsed(String arr) {
		List<robot_AndroidHardWareUsed> query=new ArrayList<robot_AndroidHardWareUsed>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_AndroidHardWareUsed> query1 = datastore.createQuery(robot_AndroidHardWareUsed.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_cpu_used")){
					query1.filter("android_cpu_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_cpu_used_app")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("android_cpu_used_app =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_cpu_used_time1")){
					query1.filter("android_cpu_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_flash_used")){
					query1.filter("android_flash_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_flash_used_time1")){
					query1.filter("linux_flash_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used")){
					query1.filter("linux_memory_used =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used_app")){
					query1.filter("linux_memory_used_app =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_memory_used_time1")){
					query1.filter("linux_memory_used_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_wifi_signal")){
					query1.filter("linux_wifi_signal =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_wifi_signal_time1")){
					query1.filter("linux_wifi_signal_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_AndroidHardWareUsed robot_androidHardWareUsed : query1) {
				query.add(robot_androidHardWareUsed);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================安卓软件版本数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(String arr) {
		List<robot_AndroidSoftWareVersion> query=new ArrayList<robot_AndroidSoftWareVersion>();
		try {
			//分割数组
			
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_AndroidSoftWareVersion> query1 = datastore.createQuery(robot_AndroidSoftWareVersion.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("andriod_version_software")){
					query1.filter("andriod_version_software =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("andriod_version_system")){
					query1.filter("andriod_version_system =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("andriod_version_kernel")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("andriod_version_kernel =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_AndroidSoftWareVersion androidSoftWareVersion : query1) {
				query.add(androidSoftWareVersion);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_AppRunningStatus> queryAppRunningStatus(String arr,String system_type) {
		List<robot_AppRunningStatus> query=new ArrayList<robot_AppRunningStatus>();
		try {
			//分割数组
			
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_AppRunningStatus> query1 = datastore.createQuery(robot_AppRunningStatus.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_app_status")){
					query1.filter("linux_app_status =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("motion_app_status")){
					query1.filter("motion_app_status =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("andriod_version_kernel")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("andriod_version_kernel =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_AppRunningStatus appRunningStatus : query1) {
				query.add(appRunningStatus);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_CalibrateInfo> queryCalibrateInfo(String arr) {
		List<robot_CalibrateInfo> query=new ArrayList<robot_CalibrateInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_CalibrateInfo> query1 = datastore.createQuery(robot_CalibrateInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("calibrate_zero_weight")){
					query1.filter("calibrate_zero_weight =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("calibrate_standard_weight")){
					query1.filter("calibrate_standard_weight =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("calibrate_raw_weight")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("calibrate_raw_weight =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_CalibrateInfo calibrateInfo : query1) {
				query.add(calibrateInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_CandidatesInfo> queryCandidatesInfo(String arr) {
		List<robot_CandidatesInfo> query=new ArrayList<robot_CandidatesInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_CandidatesInfo> query1 = datastore.createQuery(robot_CandidatesInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_id")){
					query1.filter("candidates_id =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_score")){
					query1.filter("candidates_score =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_whole_brightness")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("candidates_whole_brightness =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_lftface_brightness")){
					query1.filter("candidates_lftface_brightness =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_rgtface_brightness")){
					query1.filter("candidates_rgtface_brightness =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_height_diff")){
					query1.filter("candidates_height_diff =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_final_score")){
					query1.filter("candidates_final_score =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("candidates_weight_diff")){
					query1.filter("candidates_weight_diff =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_CandidatesInfo candidatesInfo : query1) {
				query.add(candidatesInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_FinalRecogResult> queryFinalRecogResult(String arr) {
		List<robot_FinalRecogResult> query=new ArrayList<robot_FinalRecogResult>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_FinalRecogResult> query1 = datastore.createQuery(robot_FinalRecogResult.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("recognition_result_scene")){
					query1.filter("recognition_result_scene =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("recognition_result_id")){
					query1.filter("recognition_result_id =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("recognition_result_reason")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("recognition_result_reason =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("recognition_result_time_consumed_ms")){
					query1.filter("recognition_result_time_consumed_ms =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_FinalRecogResult finalRecogResult : query1) {
				query.add(finalRecogResult);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */ 
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(String arr,String system_type) {
		List<robot_LinuxEnvTemperatureInfo> query=new ArrayList<robot_LinuxEnvTemperatureInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_LinuxEnvTemperatureInfo> query1 = datastore.createQuery(robot_LinuxEnvTemperatureInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_env_temperature")){
					query1.filter("linux_env_temperature =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_cpu_temperature")){
					query1.filter("linux_cpu_temperature =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_temperature_time1")){
					//时间是用来查询两者之间的，如果前台传的只有起始时间，就会查询所有大于这个起始时间的数据，如果只传结束时间，查询所有比结束时间小的数据
					//如果起始时间和结束时间都穿过来，就查询这两个时间之内的数据。(还要将string类型转换为时间类型)
					query1.filter("linux_temperature_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_LinuxEnvTemperatureInfo linuxEnvTemperatureInfo : query1) {
				query.add(linuxEnvTemperatureInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_LinuxHardWareInfo> queryLinuxHardWareInfo(String arr,String system_type) {
		List<robot_LinuxHardWareInfo> query=new ArrayList<robot_LinuxHardWareInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_LinuxHardWareInfo> query1 = datastore.createQuery(robot_LinuxHardWareInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_hard_ecid_0")){
					query1.filter("linux_hard_ecid_0 =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_hard_ecid_1")){
					query1.filter("linux_hard_ecid_1 =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_hard_ecid_2")){
					query1.filter("linux_hard_ecid_2 =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("linux_hard_ecid_3")){
					query1.filter("linux_hard_ecid_3 =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_LinuxHardWareInfo linuxHardWareInfo : query1) {
				query.add(linuxHardWareInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================运用程序控制数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(String arr,String system_type) {
		List<robot_LinuxSoftWareVersion> query=new ArrayList<robot_LinuxSoftWareVersion>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_LinuxSoftWareVersion> query1 = datastore.createQuery(robot_LinuxSoftWareVersion.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_LinuxSoftWareVersion linuxSoftWareVersion : query1) {
				query.add(linuxSoftWareVersion);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================启动记录数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_LinuxStartUpRecord> queryLinuxStartUpRecord(String arr,String system_type) {
		List<robot_LinuxStartUpRecord> query=new ArrayList<robot_LinuxStartUpRecord>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_LinuxStartUpRecord> query1 = datastore.createQuery(robot_LinuxStartUpRecord.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("startup_reason")){
					query1.filter("startup_reason =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("poweroff_time")){
					query1.filter("poweroff_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("startup_time")){
					query1.filter("startup_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_LinuxStartUpRecord linuxStartUpRecord : query1) {
				query.add(linuxStartUpRecord);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================运用运动软件版本数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_MotionSoftWareVersion> queryMotionSoftWareVersion(String arr) {
		List<robot_MotionSoftWareVersion> query=new ArrayList<robot_MotionSoftWareVersion>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_MotionSoftWareVersion> query1 = datastore.createQuery(robot_MotionSoftWareVersion.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			for (robot_MotionSoftWareVersion motionSoftWareVersion : query1) {
				query.add(motionSoftWareVersion);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================自检信息数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_SelfLnspectionInfo> querySelfLnspectionInfo(String arr,String system_type) {
		List<robot_SelfLnspectionInfo> query=new ArrayList<robot_SelfLnspectionInfo>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_SelfLnspectionInfo> query1 = datastore.createQuery(robot_SelfLnspectionInfo.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("selfcheck_rfid")){
					query1.filter("selfcheck_rfid =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("selfcheck_voice")){
					query1.filter("selfcheck_voice =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_SelfLnspectionInfo selfLnspectionInfo : query1) {
				query.add(selfLnspectionInfo);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
	
	
	/**
	 * ==============================================自检信息数据查询使用==================================================
	 * 不带翻页
	 * @return
	 */
	public List<robot_AndriodCPUTemperature> queryAndriodCPUTemperature(String arr,String system_type) {
		List<robot_AndriodCPUTemperature> query=new ArrayList<robot_AndriodCPUTemperature>();
		try {
			//分割数组
			String[]  strs=arr.split(",");
			datastore.ensureIndexes();
			Query<robot_AndriodCPUTemperature> query1 = datastore.createQuery(robot_AndriodCPUTemperature.class);
			for(int i=0;i<strs.length;i++){
				String[] aa=strs[i].split("__");
				//filter之间使用and连接起来
				if(!aa[1].equals("null") && aa[0].equals("deviceNo")){
					query1.filter("deviceNo =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_cpu_temperature")){
					query1.filter("android_cpu_temperature =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("android_temperature_time")){
					query1.filter("android_temperature_time =",aa[1]);
				}else if(!aa[1].equals("null") && aa[0].equals("createDate1")){
					if(getDate(aa[1])){
						query1.filter("createDate >",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate >",formatter2.parse(aa[1]));
					}
				}else if(!aa[1].equals("null") && aa[0].equals("createDate2")){
					if(getDate(aa[1])){
						query1.filter("createDate <",formatter.parse(aa[1]));
					}else{
						query1.filter("createDate <",formatter2.parse(aa[1]));
					}
				}
			}
			query1.filter("systemType =",system_type);
			for (robot_AndriodCPUTemperature andriodCPUTemperature : query1) {
				query.add(andriodCPUTemperature);
			}
		} catch (Exception e) {
			logger.error("Morphia异常："+e.getMessage());
		}
		return query;
	}
}
