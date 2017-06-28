package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.didano.remotecontrol.base.robot.data.robot_MotionSoftWareVersion;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface MotionSoftWareVersionRepository extends MongoRepository<robot_MotionSoftWareVersion, String> {
	public robot_MotionSoftWareVersion findByDeviceNo(String device_no);
	public List<robot_MotionSoftWareVersion> findBySystemType(String system_type);
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2}]}")
	public List<robot_MotionSoftWareVersion> findByCreateDate1(Date createDate1,Date createDate2,String system_type);
}
