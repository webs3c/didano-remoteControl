package cn.didano.base.dao;


import java.util.List;

import cn.didano.base.model.Robot_School;

public interface Robot_SchoolMapper {
	Robot_School findSchoolName(Robot_School r_school);
	List<Robot_School> findSheBei(Integer system_type);
	List<Robot_School> findSheBei1();
	List<Robot_School> findDeviceNo(Robot_School rs);
	Robot_School studentNumber(Integer system_type);
}