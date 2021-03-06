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
package cn.didano.base.model;

import org.springframework.data.annotation.TypeAlias;

import cn.didano.remotecontrol.base.robot.data.rInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运行在线信息类
 */
@ApiModel
@TypeAlias("预警")
public class Robot_warning extends rInfo {
	
	@ApiModelProperty(value = "所属学校的名称", required = true)
	public String schoolName;
	@ApiModelProperty(value = "产品硬件识别码", required = true)
	public String deviceNo;
	@ApiModelProperty(value = "学校人数", required = true)
	public Integer schoolNumber  ;
	@ApiModelProperty(value = "参加晨检人数", required = true)
	public String morningNumber;
	@ApiModelProperty(value = "相差人数", required = true)
	public String betweenNumber;
	@ApiModelProperty(value = "设备类型", required = true)
	public Integer systemType;
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
	public Integer getSchoolNumber() {
		return schoolNumber;
	}
	public void setSchoolNumber(Integer schoolNumber) {
		this.schoolNumber = schoolNumber;
	}
	public String getMorningNumber() {
		return morningNumber;
	}
	public void setMorningNumber(String morningNumber) {
		this.morningNumber = morningNumber;
	}
	public String getBetweenNumber() {
		return betweenNumber;
	}
	public void setBetweenNumber(String betweenNumber) {
		this.betweenNumber = betweenNumber;
	}
	public Integer getSystemType() {
		return systemType;
	}
	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}
	@Override
	public String toString() {
		return "Robot_warning [schoolName=" + schoolName + ", deviceNo=" + deviceNo + ", schoolNumber=" + schoolNumber
				+ ", morningNumber=" + morningNumber + ", betweenNumber=" + betweenNumber + ", systemType=" + systemType
				+ "]";
	}
}
