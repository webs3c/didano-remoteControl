package cn.didano.robot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.didano.robot.data.Robot_AndroidHardWareUsed;
import cn.didano.robot.data.Robot_AndroidSoftWareVersion;
import cn.didano.robot.data.Robot_AppRunningStatus;
import cn.didano.robot.data.Robot_CalibrateInfo;
import cn.didano.robot.data.Robot_CandidatesInfo;
import cn.didano.robot.data.Robot_FinalRecogResult;
import cn.didano.robot.data.Robot_LinuxEnvTemperatureInfo;
import cn.didano.robot.data.Robot_LinuxHardWareInfo;
import cn.didano.robot.data.Robot_LinuxHardWareUsed;
import cn.didano.robot.data.Robot_LinuxSoftWareVersion;
import cn.didano.robot.data.Robot_LinuxStartUpRecord;
import cn.didano.robot.data.Robot_MotionSoftWareVersion;
import cn.didano.robot.data.Robot_PhotographicQualityInfo;
import cn.didano.robot.data.Robot_SelfLnspectionInfo;
import cn.didano.robot.data.Robot_UploadType;
import cn.didano.robot.data.Robot_school;
import cn.didano.robot.data.repository.AndroidHardWareUsedRepository;
import cn.didano.robot.data.repository.AndroidSoftWareVersionRepository;
import cn.didano.robot.data.repository.AppRunningStatusRepository;
import cn.didano.robot.data.repository.CalibrateInfoRepository;
import cn.didano.robot.data.repository.CandidatesInfoRepository;
import cn.didano.robot.data.repository.FinalRecogResultRepository;
import cn.didano.robot.data.repository.LinuxEnvTemperatureInfoRepository;
import cn.didano.robot.data.repository.LinuxHardWareInfoRepository;
import cn.didano.robot.data.repository.LinuxHardWareUsedRepository;
import cn.didano.robot.data.repository.LinuxSoftWareVersionRepository;
import cn.didano.robot.data.repository.LinuxStartUpRecordRepository;
import cn.didano.robot.data.repository.MotionSoftWareVersionRepository;
import cn.didano.robot.data.repository.PhotographicQualityInfoRepository;
import cn.didano.robot.data.repository.SchoolRepository;
import cn.didano.robot.data.repository.SelfLnspectionInfoRepository;
import cn.didano.robot.data.repository.TypeNameRepository;

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
	
	
	public List<Robot_LinuxSoftWareVersion> queryLinuxSoftWareVersion() {
		return this.v_repository.findAll();
	}
	public List<Robot_AndroidHardWareUsed> queryAndroidHardWareUsed() {
		return this.ahwr_repository.findAll();
	}
	public List<Robot_AndroidSoftWareVersion> queryAndroidSoftWareVersion() {
		return this.aswr_repository.findAll();
	}
	public List<Robot_AppRunningStatus> queryAppRunningStatus() {
		return this.arsr_repository.findAll();
	}
	public List<Robot_CalibrateInfo> queryCalibrateInfo() {
		return this.cir_repository.findAll();
	}
	public List<Robot_CandidatesInfo> queryCandidatesInfo() {
		return this.cdir_repository.findAll();
	}
	
	public List<Robot_FinalRecogResult> queryFinalRecogResult() {
		return this.frrr_repository.findAll();
	}
	public List<Robot_LinuxEnvTemperatureInfo> queryLinuxEnvTemperatureInfo() {
		return this.letr_repository.findAll();
	}
	public List<Robot_LinuxHardWareInfo> queryLinuxHardWareInfo() {
		return this.lhwr_repository.findAll();
	}
	public List<Robot_LinuxHardWareUsed> queryLinuxHardWareUsed() {
		return this.lhur_repository.findAll();
	}
	public List<Robot_LinuxStartUpRecord> queryLinuxStartUpRecord() {
		return this.lsupr_repository.findAll();
	}
	
	public List<Robot_MotionSoftWareVersion> queryMotionSoftWareVersion() {
		return this.mtwr_repository.findAll();
	}
	
	public List<Robot_PhotographicQualityInfo> queryPhotographicQualityInfo() {
		return this.pqr_repository.findAll();
	}
	public List<Robot_SelfLnspectionInfo> querySelfLnspectionInfo() {
		return this.str_repository.findAll();
	}
	
	
	
	public List<Robot_school> selectSchool() {
		return this.sr_repository.findAll();
	}
	
	public List<Robot_school> selectSchoolName(String schoolName) {
		return this.sr_repository.findBySchoolName(schoolName);
	}
	
	public List<Robot_UploadType> selectType() {
		return this.tn_repository.findAll();
	}
	
}
