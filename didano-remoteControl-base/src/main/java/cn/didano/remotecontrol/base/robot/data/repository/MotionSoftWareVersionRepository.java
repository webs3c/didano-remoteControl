package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_MotionSoftWareVersion;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface MotionSoftWareVersionRepository extends MongoRepository<Robot_MotionSoftWareVersion, String> {
	public Robot_MotionSoftWareVersion findByDeviceNo(String device_no);
	public List<Robot_MotionSoftWareVersion> findBySystemType(String system_type);
}
