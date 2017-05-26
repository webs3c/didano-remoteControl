package cn.didano.robot.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.robot.data.Robot_AppRunningStatus;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface AppRunningStatusRepository extends MongoRepository<Robot_AppRunningStatus, String> {
	public Robot_AppRunningStatus findByDeviceNo(String device_no);
}
