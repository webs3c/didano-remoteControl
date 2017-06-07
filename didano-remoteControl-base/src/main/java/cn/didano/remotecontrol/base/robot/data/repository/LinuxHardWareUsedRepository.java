package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_LinuxHardWareUsed;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface LinuxHardWareUsedRepository extends MongoRepository<Robot_LinuxHardWareUsed, String> {
	public Robot_LinuxHardWareUsed findByDeviceNo(String device_no);
	public List<Robot_LinuxHardWareUsed> findBySystemType(String system_type);
}
