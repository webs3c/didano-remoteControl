package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.didano.remotecontrol.base.robot.data.Robot_LinuxHardWareUsed;
import cn.didano.remotecontrol.base.robot.data.Robot_PhotographicQualityInfo;
/**
 * 照片质量信息
 * @author stephen.wang  2017年3月14日 
 */
public interface PhotographicQualityInfoRepository extends MongoRepository<Robot_PhotographicQualityInfo, String> {
	public Robot_PhotographicQualityInfo findByDeviceNo(String device_no);
	public List<Robot_PhotographicQualityInfo> findBySystemType(String system_type);
	//根据指定模块模糊查询所有的数据
	//@Query("{'createDate' : {'$gt' : ?1, '$lt' : ?0}}")
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2}]}")
	public List<Robot_PhotographicQualityInfo> findByCreateDate1(Date createDate1,Date createDate2,String system_type);
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2},{'DeviceNo':?3}]}")
	public List<Robot_PhotographicQualityInfo> findByCreateDate2(Date createDate1,Date createDate2,String system_type,String deviceNo);
		
}
