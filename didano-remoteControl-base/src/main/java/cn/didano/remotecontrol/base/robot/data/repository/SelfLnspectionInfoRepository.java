package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_SelfLnspectionInfo;
/**
 * 自检信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface SelfLnspectionInfoRepository extends MongoRepository<Robot_SelfLnspectionInfo, String> {
	public Robot_SelfLnspectionInfo findByDeviceNo(String device_no);
	public List<Robot_SelfLnspectionInfo> findBySystemType(String system_type);
}