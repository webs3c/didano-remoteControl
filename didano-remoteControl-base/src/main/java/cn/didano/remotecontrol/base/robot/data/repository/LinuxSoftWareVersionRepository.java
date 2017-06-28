package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.didano.remotecontrol.base.robot.data.robot_LinuxSoftWareVersion;
/**
 * 版本信息容器
 * @author stephen.wang  2017年3月11日 
 */
//@Repository("Robot_LinuxSoftWareVersion")
public interface LinuxSoftWareVersionRepository extends MongoRepository<robot_LinuxSoftWareVersion, String> {
	public robot_LinuxSoftWareVersion findByDeviceNo(String device_no);
	public List<robot_LinuxSoftWareVersion> findBySystemType(String system_type);
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2}]}")
	public List<robot_LinuxSoftWareVersion> findByCreateDate1(Date createDate1,Date createDate2,String system_type);
}