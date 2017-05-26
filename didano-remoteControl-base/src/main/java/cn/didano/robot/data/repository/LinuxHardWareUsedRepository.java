package cn.didano.robot.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.robot.data.Robot_LinuxHardWareUsed;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface LinuxHardWareUsedRepository extends MongoRepository<Robot_LinuxHardWareUsed, String> {
	public Robot_LinuxHardWareUsed findByDeviceNo(String device_no);
}
