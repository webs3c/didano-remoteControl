package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.didano.remotecontrol.base.robot.data.Robot_CalibrateInfo;
import cn.didano.remotecontrol.base.robot.data.Robot_PhotographicQualityInfo;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface CalibrateInfoRepository extends MongoRepository<Robot_CalibrateInfo, String> {
	public Robot_CalibrateInfo findByDeviceNo(String device_no);
	public List<Robot_CalibrateInfo> findBySystemType(String system_type);
	
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2}]}")
	public List<Robot_CalibrateInfo> findBySystemType1(Date createDate1,Date createDate2,String system_type);
	@Query("{'$and':[{'createDate':{'$gt' : ?1, '$lt' : ?0}},{'SystemType':?2},{'DeviceNo':?3}]}")
	public List<Robot_CalibrateInfo> findBySystemType2(Date createDate1,Date createDate2,String system_type,String deviceNo);
		
	
}
