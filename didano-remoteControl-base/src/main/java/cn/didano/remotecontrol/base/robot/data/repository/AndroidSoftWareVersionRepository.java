package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_AndroidSoftWareVersion;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface AndroidSoftWareVersionRepository extends MongoRepository<Robot_AndroidSoftWareVersion, String> {
	public Robot_AndroidSoftWareVersion findByDeviceNo(String device_no);
	public List<Robot_AndroidSoftWareVersion> findBySystemType(String system_type);
}
