package cn.didano.remotecontrol.base.robot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public List<Robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion(String system_type) {
		return this.v_repository.findBySystemType(system_type);
	}
	public List<Robot_AndroidHardWareUsed> queryAndroidHardWareUsed(String system_type) {
		System.err.println(system_type+"--------------");
		return this.ahwr_repository.findBySystemType(system_type);
	}
	public List<Robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion(String system_type) {
		return this.aswr_repository.findBySystemType(system_type);
	}
	public List<Robot_AppRunningStatus> queryAppRunningStatus(String system_type) {
		return this.arsr_repository.findBySystemType(system_type);
	}
	public List<Robot_CalibrateInfo> queryCalibrateInfo(String system_type) {
		return this.cir_repository.findBySystemType(system_type);
	}
	public List<Robot_CandidatesInfo> queryCandidatesInfo(String system_type) {
		return this.cdir_repository.findBySystemType(system_type);
	}
	
	public List<Robot_FinalRecogResult> queryFinalRecogResult(String system_type) {
		return this.frrr_repository.findBySystemType(system_type);
	}
	public List<Robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo(String system_type) {
		return this.letr_repository.findBySystemType(system_type);
	}
	public List<Robot_LinuxHardWareInfo> queryLinuxHardWareInfo(String system_type) {
		return this.lhwr_repository.findBySystemType(system_type);
	}
	public List<Robot_LinuxHardWareUsed> queryLinuxHardWareUsed(String system_type) {
		return this.lhur_repository.findBySystemType(system_type);
	}
	public List<Robot_LinuxStartUpRecord> queryLinuxStartUpRecord(String system_type) {
		return this.lsupr_repository.findBySystemType(system_type);
	}
	
	public List<Robot_MotionSoftWareVersion> queryMotionSoftWareVersion(String system_type) {
		return this.mtwr_repository.findBySystemType(system_type);
	}
	
	public List<Robot_PhotographicQualityInfo> queryPhotographicQualityInfo(String system_type) {
		return this.pqr_repository.findBySystemType(system_type);
	}
	public List<Robot_SelfLnspectionInfo> querySelfLnspectionInfo(String system_type) {
		return this.str_repository.findBySystemType(system_type);
	}
	
	
	
	
	
	public List<Robot_School> selectSchool() {
		return this.sr_repository.findAll();
	}
	
	public List<Robot_School> selectSchoolName(String schoolName) {
		return this.sr_repository.findBySchoolName(schoolName);
	}
	
	public List<Robot_UploadType> selectType() {
		return this.tn_repository.findAll();
	}
	
}
