/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.didano.remotecontrol.base.robot.data;

import org.springframework.data.annotation.TypeAlias;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author stephen.wang
 * @Todo 没有安卓操作系统版本号
 */
@ApiModel
@TypeAlias("运动控制软件版本信息")
public class robot_MotionSoftWareVersion extends rInfo {
	
	@ApiModelProperty(value = "产品硬件识别码", required = true)
	private String deviceNo;
	@ApiModelProperty(value = "版本类型", required = true)
	private String systemType;
	@ApiModelProperty(value = "运动控制软件版本号", required = true)
	private String motion_version_software;
	@ApiModelProperty(value = "学校名称", required = true)
	private String schoolName;
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getMotion_version_software() {
		return motion_version_software;
	}
	public void setMotion_version_software(String motion_version_software) {
		this.motion_version_software = motion_version_software;
	}
	@Override
	public String toString() {
		return "Robot_MotionSoftWareVersion [deviceNo=" + deviceNo + ", motion_version_software="
				+ motion_version_software + "]";
	}
	
}
