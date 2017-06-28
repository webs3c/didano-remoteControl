package cn.didano.remotecontrol.base.robot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.didano.base.model.Robot_School;
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
public class RobotMongoDbFindService {
	@Autowired
	private LinuxSoftWareVersionRepository v_repository;
	@Autowired
	private AndroidHardWareUsedRepository ahwr_repository;
	@Autowired
	private AppRunningStatusRepository arsr_repository;
	@Autowired
	private AndroidSoftWareVersionRepository aswr_repository;
	@Autowired
	private CalibrateInfoRepository cir_repository;
	@Autowired
	private CandidatesInfoRepository cdir_repository;
	@Autowired
	private FinalRecogResultRepository frrr_repository;
	@Autowired
	private LinuxEnvTemperatureInfoRepository letr_repository;
	@Autowired
	private LinuxHardWareInfoRepository lhwr_repository;
	@Autowired
	private LinuxHardWareUsedRepository lhur_repository;
	@Autowired
	private LinuxStartUpRecordRepository lsupr_repository;
	@Autowired
	private MotionSoftWareVersionRepository mtwr_repository;
	@Autowired
	private PhotographicQualityInfoRepository pqr_repository;
	@Autowired
	private SelfLnspectionInfoRepository str_repository;
	@Autowired
	private SchoolRepository sr_repository;
	@Autowired
	private TypeNameRepository tn_repository;
	
	
	public List<robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(String system_type) {
		return this.v_repository.findBySystemType(system_type);
	}
	public List<robot_AndroidHardWareUsed> queryAndroidHardWareUsed(String system_type) {
		return this.ahwr_repository.findBySystemType(system_type);
	}
	public List<robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(String system_type) {
		return this.aswr_repository.findBySystemType(system_type);
	}
	public List<robot_AppRunningStatus> queryAppRunningStatus(String system_type) {
		return this.arsr_repository.findBySystemType(system_type);
	}
	public List<robot_CalibrateInfo> queryCalibrateInfo(String system_type) {
		return this.cir_repository.findBySystemType(system_type);
	}
	public List<robot_CandidatesInfo> queryCandidatesInfo(String system_type) {
		return this.cdir_repository.findBySystemType(system_type);
	}
	
	public List<robot_FinalRecogResult> queryFinalRecogResult(String system_type) {
		return this.frrr_repository.findBySystemType(system_type);
	}
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(String system_type) {
		return this.letr_repository.findBySystemType(system_type);
	}
	public List<robot_LinuxHardWareInfo> queryLinuxHardWareInfo(String system_type) {
		return this.lhwr_repository.findBySystemType(system_type);
	}
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(String system_type) {
		return this.lhur_repository.findBySystemType(system_type);
	}
	public List<robot_LinuxStartUpRecord> queryLinuxStartUpRecord(String system_type) {
		return this.lsupr_repository.findBySystemType(system_type);
	}
	
	public List<robot_MotionSoftWareVersion> queryMotionSoftWareVersion(String system_type) {
		return this.mtwr_repository.findBySystemType(system_type);
	}
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(String system_type) {
		return this.pqr_repository.findBySystemType(system_type);
	}
	public List<robot_SelfLnspectionInfo> querySelfLnspectionInfo(String system_type) {
		return this.str_repository.findBySystemType(system_type);
	}
	
	
	
	//___________________________版本信息曲线图查询___________________
	public List<robot_LinuxHardWareUsed> findRobot_LinuxHardWareUsed(Date time1,Date time2,String system_type) {
		return this.lhur_repository.findByCreateDate1(time1,time2,system_type);
	}
	public List<robot_LinuxHardWareUsed> findRobot_LinuxHardWareUsed(Date time1,Date time2,String system_type,String deviceNo) {
		return this.lhur_repository.findByCreateDate2(time1,time2,system_type,deviceNo);
	}
	//+++++++++++++++++++++++++++++++照片片曲线图查询+++++++++++++++++++++++++++++++++
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(Date time1,Date time2,String system_type) {
		return this.pqr_repository.findByCreateDate1(time1,time2,system_type);
	}
	public List<robot_PhotographicQualityInfo> queryPhotographicQualityInfo(Date time1,Date time2,String system_type,String deviceNo) {
		return this.pqr_repository.findByCreateDate2(time1,time2,system_type,deviceNo);
	}
	//===================================体重校准信息查询============================================
	public List<robot_CalibrateInfo> queryCalibrateInfo(Date time1,Date time2,String system_type) {
		return this.cir_repository.findBySystemType1(time1,time2,system_type);
	}
	public List<robot_CalibrateInfo> queryCalibrateInfo(Date time1,Date time2,String system_type,String deviceNo) {
		return this.cir_repository.findBySystemType2(time1,time2,system_type,deviceNo);
	}
	//+++++++++++++++++++++++++++++++++++候选人信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_CandidatesInfo> queryCandidatesInfo(Date time1,Date time2,String system_type) {
		return this.cdir_repository.findBySystemType1(time1,time2,system_type);
	}
	
	public List<robot_CandidatesInfo> queryCandidatesInfo(Date time1,Date time2,String system_type,String deviceNo) {
		return this.cdir_repository.findBySystemType2(time1,time2,system_type,deviceNo);
	}
	//+++++++++++++++++++++++++++++++++++最终结果信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_FinalRecogResult> queryFinalRecogResult(Date time1,Date time2,String system_type) {
		return this.frrr_repository.findBySystemType1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++板子温度信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(Date time1,Date time2,String system_type) {
		return this.letr_repository.findBySystemType1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++版本信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_MotionSoftWareVersion> queryMotionSoftWareVersion(Date time1,Date time2,String system_type) {
		return this.mtwr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++启动信息+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_LinuxStartUpRecord> queryLinuxStartUpRecord(Date time1,Date time2,String system_type) {
		return this.lsupr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//++++++++++++++++++++++++++++++++++软件版本信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(Date time1,Date time2,String system_type) {
		return this.v_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++硬件使用信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_LinuxHardWareUsed> queryLinuxHardWareUsed(Date time1,Date time2,String system_type) {
		return this.lhur_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++ECID号信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_LinuxHardWareInfo> queryLinuxHardWareInfo(Date time1,Date time2,String system_type) {
		return this.lhwr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++运用程序运行状态信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_AppRunningStatus> queryAppRunningStatus(Date time1,Date time2,String system_type) {
		return this.arsr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++安卓软件版本度信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(Date time1,Date time2,String system_type) {
		return this.aswr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++安卓软件使用信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_AndroidHardWareUsed> queryAndroidHardWareUsed(Date time1,Date time2,String system_type) {
		return this.ahwr_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++自检信息查询+++++++++++++++++++++++++++++++++++++++++++++
	public List<robot_SelfLnspectionInfo> querySelfLnspectionInfo(Date time1,Date time2,String system_type) {
		return this.str_repository.findByCreateDate1(time1,time2,system_type);
	}
	//+++++++++++++++++++++++++++++++++++板子温度信息查询+++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++板子温度信息查询+++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++板子温度信息查询+++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	public List<Robot_School> selectSchool() {
		return this.sr_repository.findAll();
	}
	
	public List<Robot_School> selectSchoolName(String schoolName) {
		return this.sr_repository.findBySchoolName(schoolName);
	}
	
	public List<robot_UploadType> selectType() {
		return this.tn_repository.findAll();
	}
	
}
