package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.base.model.Robot_School;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface SchoolRepository extends MongoRepository<Robot_School, String> {
	public Robot_School findByDeviceNo(String device_no);
	public List<Robot_School> findBySchoolName(String schoolName);
	
}
