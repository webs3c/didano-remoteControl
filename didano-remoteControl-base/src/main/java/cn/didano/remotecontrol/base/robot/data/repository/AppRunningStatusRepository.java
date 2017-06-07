package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_AppRunningStatus;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface AppRunningStatusRepository extends MongoRepository<Robot_AppRunningStatus, String> {
	public Robot_AppRunningStatus findByDeviceNo(String device_no);
	public List<Robot_AppRunningStatus> findBySystemType(String system_type);
}
