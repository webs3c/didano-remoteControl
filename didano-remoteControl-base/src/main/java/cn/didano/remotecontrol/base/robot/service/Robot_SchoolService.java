package cn.didano.remotecontrol.base.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.didano.base.dao.Robot_SchoolMapper;
import cn.didano.base.model.Robot_School;

/**
 * 诊断平台信息服务，面对mongodb数据库
 * 
 * @author stephen.wang
 *
 */
@Service
public class Robot_SchoolService {
	@Autowired
	private Robot_SchoolMapper fsnr_repository;
	
	
	/**
	 * 创建人：SevenYang
	 * @创建时间：2017年3月17日 下午4:13:13
	 * @Title: saveTemperatureInfo
	 * @Description: （保存机器人运行在线信息）
	 * @return saveOperationInfo 
	 * 修改人：
	 * 版本：1.0.0
	 * @throws
	 */
	public Robot_School findSchollName(Robot_School r_school) {
		System.err.println("________________wo  lai l");
		 Robot_School findSchollName = fsnr_repository.findSchoolName(r_school);
		 return findSchollName;
	}
}
