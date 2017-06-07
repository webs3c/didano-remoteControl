package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_PhotographicQualityInfo;
/**
 * 照片质量信息
 * @author stephen.wang  2017年3月14日 
 */
public interface PhotographicQualityInfoRepository extends MongoRepository<Robot_PhotographicQualityInfo, String> {
	public Robot_PhotographicQualityInfo findByDeviceNo(String device_no);
	public List<Robot_PhotographicQualityInfo> findBySystemType(String system_type);
}
