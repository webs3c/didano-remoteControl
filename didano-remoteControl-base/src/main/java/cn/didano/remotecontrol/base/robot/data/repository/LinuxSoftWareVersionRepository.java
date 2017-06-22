package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_LinuxSoftWareVersion;
/**
 * 版本信息容器
 * @author stephen.wang  2017年3月11日 
 */
//@Repository("Robot_LinuxSoftWareVersion")
public interface LinuxSoftWareVersionRepository extends MongoRepository<Robot_LinuxSoftWareVersion, String> {
	public Robot_LinuxSoftWareVersion findByDeviceNo(String device_no);
	public List<Robot_LinuxSoftWareVersion> findBySystemType(String system_type);
}