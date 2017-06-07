package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_CandidatesInfo;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface CandidatesInfoRepository extends MongoRepository<Robot_CandidatesInfo, String> {
	public Robot_CandidatesInfo findByDeviceNo(String device_no);
	public List<Robot_CandidatesInfo> findBySystemType(String system_type);
}
