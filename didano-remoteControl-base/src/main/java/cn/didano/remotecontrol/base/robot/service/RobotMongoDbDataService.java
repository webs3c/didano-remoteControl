package cn.didano.remotecontrol.base.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import cn.didano.remotecontrol.base.robot.data.repository.AndroidHardWareUsedRepository;
import cn.didano.remotecontrol.base.robot.data.repository.AndroidSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.AppRunningStatusRepository;
import cn.didano.remotecontrol.base.robot.data.repository.CalibrateInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.CandidatesInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.FinalRecogResultRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxHardWareInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxHardWareUsedRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.LinuxStartUpRecordRepository;
import cn.didano.remotecontrol.base.robot.data.repository.MotionSoftWareVersionRepository;
import cn.didano.remotecontrol.base.robot.data.repository.PhotographicQualityInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.SchoolRepository;
import cn.didano.remotecontrol.base.robot.data.repository.SelfLnspectionInfoRepository;
import cn.didano.remotecontrol.base.robot.data.repository.TemperatureInfoRepsitory;
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
	private TemperatureInfoRepsitory t_repository;
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
	
	
	
	
	/**
	 * 查询
	 * 
	 * @return
	 */
	public Robot_LinuxSoftWareVersion findRVersionInfo(String device_no) {
		return this.v_repository.findByDeviceNo(device_no);
	}
	
	/**
	 * 保存版本数据
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public Robot_LinuxSoftWareVersion saveRVersionInfo(Robot_LinuxSoftWareVersion linuxSoftWareVersion) {
		return this.v_repository.save(linuxSoftWareVersion);
	}
	
	/**
	 * 保存androd版本数据
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public Robot_AndroidSoftWareVersion saveRandroidSoftWareVersion(Robot_AndroidSoftWareVersion AndroidSoftWareVersion) {
		return this.ar_sepository.save(AndroidSoftWareVersion);
	}
	/**
	 * 运动控制软件版本信息
	 * 
	 * @param record
	 * @return 更新行数
	 */
	public Robot_MotionSoftWareVersion saveRandroidSoftWareVersion(Robot_MotionSoftWareVersion motionSoftWareVersion) {
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
	public Robot_LinuxEnvTemperatureInfo saveTemperatureInfo(Robot_LinuxEnvTemperatureInfo temperatureInfo) {
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
	public Robot_LinuxHardWareUsed saveOperationInfo(Robot_LinuxHardWareUsed linuxHarfWareUsed) {
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
	public Robot_CandidatesInfo saveCandidatesInfo(Robot_CandidatesInfo candidatesInfo) {
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
	public Robot_FinalRecogResult saveFinalRecogResult(Robot_FinalRecogResult inalRecogResult) {
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
	public Robot_AndroidHardWareUsed saveAndroidHardWareUsed(Robot_AndroidHardWareUsed androidHardWareUsed) {
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
	public Robot_LinuxStartUpRecord saveLinuxStartUpRecord(Robot_LinuxStartUpRecord linuxStartUpRecord) {
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
	public Robot_SelfLnspectionInfo saveSelfLnspectionInfo(Robot_SelfLnspectionInfo selfLnspectionInfo) {
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
	public Robot_LinuxHardWareInfo saveLinuxHardWareInfo(Robot_LinuxHardWareInfo linuxHardWareInfo) {
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
	public Robot_AppRunningStatus saveAppRunningStatus(Robot_AppRunningStatus calibrateInfo) {
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
	public Robot_CalibrateInfo saveCalibrateInfo(Robot_CalibrateInfo calibrateInfo) {
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
	public Robot_PhotographicQualityInfo savePhotographicQualityInfo(Robot_PhotographicQualityInfo onLineInfo) {
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
	public Robot_school saveRobot_school(Robot_school robot_school) {
		return this.sr_sepository.save(robot_school);
	}
	public Robot_UploadType saveRobot_UploadType(Robot_UploadType robot_UploadType) {
		return this.tn_sepository.save(robot_UploadType);
	}
}
