package cn.didano.remotecontrol.base.robot.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_LinuxEnvTemperatureInfo;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface LinuxEnvTemperatureInfoRepository extends MongoRepository<Robot_LinuxEnvTemperatureInfo, String> {
	public Robot_LinuxEnvTemperatureInfo findByDeviceNo(String device_no);
}
