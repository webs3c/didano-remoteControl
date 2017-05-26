package cn.didano.remotecontrol.base.robot.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_SelfLnspectionInfo;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface SelfLnspectionInfoepository extends MongoRepository<Robot_SelfLnspectionInfo, String> {
	public Robot_SelfLnspectionInfo findByDeviceNo(String device_no);
}
