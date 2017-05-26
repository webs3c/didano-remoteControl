package cn.didano.remotecontrol.base.robot.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_CalibrateInfo;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface CalibrateInfoRepository extends MongoRepository<Robot_CalibrateInfo, String> {
	public Robot_CalibrateInfo findByDeviceNo(String device_no);
}
