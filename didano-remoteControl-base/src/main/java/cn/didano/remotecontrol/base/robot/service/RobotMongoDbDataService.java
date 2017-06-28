package cn.didano.remotecontrol.base.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import cn.didano.remotecontrol.base.robot.data.repository.AndriodCPUTemperatureRepository;
import cn.didano.remotecontrol.base.robot.data.repository.AndroidHardWareUsedRepository;
import cn.didano.remotecontrol.base.robot.data.repository.AndroidSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.AppRunningStatusRepository;
import cn.didano.remotecontrol.base.robot.data.repository.CalibrateInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.CandidatesInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.FinalRecogResultRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxEnvTemperatureInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxHardWareInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxHardWareUsedRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxStartUpRecordRepository;
import cn.didano.remotecontrol.base.robot.data.repository.MotionSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.PhotographicQualityInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.SchoolRepository;
import cn.didano.remotecontrol.base.robot.data.repository.SelfLnspectionInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.TypeNameRepository;

/**
 * 诊断平台信息服务，面对mongodb数据库
 * 
 * @author stephen.wang
 *
 */
@Service
public class RobotMongoDbDataService {
	@Autowired
	private LinuxSoftWareVersionRepository v_repository;
	@Autowired
	private LinuxEnvTemperatureInfoRepository t_repository;
	@Autowired
	private LinuxHardWareUsedRepository o_repository;
	@Autowired
	private LinuxStartUpRecordRepository lsur_sepository;
	@Autowired
	private PhotographicQualityInfoRepository p_sepository;
	@Autowired
	private SchoolRepository sr_sepository;
	@Autowired
	private TypeNameRepository tn_sepository;
	@Autowired
	private AndroidSoftWareVersionRepository ar_sepository;
	@Autowired
	private MotionSoftWareVersionRepository mv_sepository;
	@Autowired
	private SelfLnspectionInfoRepository slr_sepository;
	@Autowired
	private LinuxHardWareInfoRepository lw_sepository;
	@Autowired
	private CalibrateInfoRepository clr_sepository;
	@Autowired
	private AndroidHardWareUsedRepository aur_sepository;
	@Autowired
	private FinalRecogResultRepository fr_sepository;
	
	@Autowired
	private CandidatesInfoRepository cir_sepository;
	@Autowired
	private AppRunningStatusRepository app_sepository;
	@Autowired
	private AndriodCPUTemperatureRepository actr_sepository;
	
	
	
	/**
	 * 查询
	 * 
	 * @return
	 */
	public robot_LinuxSoftWareVersion findRVersionInfo(String device_no) {
		return this.v_repository.findByDeviceNo(device_no);
	}
	
	/**
	 * 保存版本数据
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public robot_LinuxSoftWareVersion saveRVersionInfo(robot_LinuxSoftWareVersion linuxSoftWareVersion) {
		return this.v_repository.save(linuxSoftWareVersion);
	}
	
	/**
	 * 保存androd版本数据
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public robot_AndroidSoftWareVersion saveRandroidSoftWareVersion(robot_AndroidSoftWareVersion AndroidSoftWareVersion) {
		return this.ar_sepository.save(AndroidSoftWareVersion);
	}
	/**
	 * 运动控制软件版本信息
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public robot_MotionSoftWareVersion saveRandroidSoftWareVersion(robot_MotionSoftWareVersion motionSoftWareVersion) {
		return this.mv_sepository.save(motionSoftWareVersion);
	}
	
	
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的温度信息）
	 * @return TemperatureInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_LinuxEnvTemperatureInfo saveTemperatureInfo(robot_LinuxEnvTemperatureInfo temperatureInfo) {
		return this.t_repository.save(temperatureInfo);
	}
	
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的运行环境信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_LinuxHardWareUsed saveOperationInfo(robot_LinuxHardWareUsed linuxHarfWareUsed) {
		return this.o_repository.save(linuxHarfWareUsed);
	}
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的运行环境信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_CandidatesInfo saveCandidatesInfo(robot_CandidatesInfo candidatesInfo) {
		return this.cir_sepository.save(candidatesInfo);
	}
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （最终的识别结果）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_FinalRecogResult saveFinalRecogResult(robot_FinalRecogResult inalRecogResult) {
		return this.fr_sepository.save(inalRecogResult);
	}
	
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （安卓的保存机器人的运行环境信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_AndroidHardWareUsed saveAndroidHardWareUsed(robot_AndroidHardWareUsed androidHardWareUsed) {
		return this.aur_sepository.save(androidHardWareUsed);
	}
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的自检信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_LinuxStartUpRecord saveLinuxStartUpRecord(robot_LinuxStartUpRecord linuxStartUpRecord) {
		return this.lsur_sepository.save(linuxStartUpRecord);
	}
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的自检信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_SelfLnspectionInfo saveSelfLnspectionInfo(robot_SelfLnspectionInfo selfLnspectionInfo) {
		return this.slr_sepository.save(selfLnspectionInfo);
	}
	
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人的自检信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_LinuxHardWareInfo saveLinuxHardWareInfo(robot_LinuxHardWareInfo linuxHardWareInfo) {
		return this.lw_sepository.save(linuxHardWareInfo);
	}
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （体重校准信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_AppRunningStatus saveAppRunningStatus(robot_AppRunningStatus calibrateInfo) {
		return this.app_sepository.save(calibrateInfo);
	}
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （体重校准信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_CalibrateInfo saveCalibrateInfo(robot_CalibrateInfo calibrateInfo) {
		return this.clr_sepository.save(calibrateInfo);
	}
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人运行在线信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_PhotographicQualityInfo savePhotographicQualityInfo(robot_PhotographicQualityInfo onLineInfo) {
		return this.p_sepository.save(onLineInfo);
	}
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人运行在线信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public robot_AndriodCPUTemperature saveAndriodCPUTemperature(robot_AndriodCPUTemperature andriodCPUTemperature) {
		return this.actr_sepository.save(andriodCPUTemperature);
	}
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人运行在线信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public Robot_School saveRobot_school(Robot_School robot_school) {
		return this.sr_sepository.save(robot_school);
	}
	public robot_UploadType saveRobot_UploadType(robot_UploadType robot_UploadType) {
		return this.tn_sepository.save(robot_UploadType);
	}
}
