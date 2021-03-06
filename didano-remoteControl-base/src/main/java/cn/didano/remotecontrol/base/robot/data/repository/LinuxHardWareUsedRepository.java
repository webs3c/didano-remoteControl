package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.didano.remotecontrol.base.robot.data.robot_LinuxHardWareUsed;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface LinuxHardWareUsedRepository extends MongoRepository<robot_LinuxHardWareUsed, String>{
	public robot_LinuxHardWareUsed findByDeviceNo(String device_no);
	public List<robot_LinuxHardWareUsed> findBySystemType(String system_type);
	//根据指定模块模糊查询所有的数据
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2}]}")
	public List<robot_LinuxHardWareUsed> findByCreateDate1(Date createDate1,Date createDate2,String system_type);
	//根据指定模块模糊查询所有的数据(对应的设备编号)
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2},{'DeviceNo':?3}]}")
	public List<robot_LinuxHardWareUsed> findByCreateDate2(Date createDate1,Date createDate2,String system_type,String deviceNo);
}
