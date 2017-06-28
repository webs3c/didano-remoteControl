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
@TypeAlias("linux的CPU的ECID号")
public class robot_LinuxHardWareInfo extends rInfo {
	
	@ApiModelProperty(value = "产品硬件识别码", required = true)
	private String deviceNo;
	@ApiModelProperty(value = "版本类型", required = true)
	private String systemType;
	@ApiModelProperty(value = "CPU的ECID号1", required = true)
	private String linux_hard_ecid_0;
	@ApiModelProperty(value = "CPU的ECID号2", required = true)
	private String linux_hard_ecid_1;
	@ApiModelProperty(value = "CPU的ECID号3", required = true)
	private String linux_hard_ecid_2;
	@ApiModelProperty(value = "CPU的ECID号4", required = true)
	private String linux_hard_ecid_3;
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
	public String getLinux_hard_ecid_0() {
		return linux_hard_ecid_0;
	}
	public void setLinux_hard_ecid_0(String linux_hard_ecid_0) {
		this.linux_hard_ecid_0 = linux_hard_ecid_0;
	}
	public String getLinux_hard_ecid_1() {
		return linux_hard_ecid_1;
	}
	public void setLinux_hard_ecid_1(String linux_hard_ecid_1) {
		this.linux_hard_ecid_1 = linux_hard_ecid_1;
	}
	public String getLinux_hard_ecid_2() {
		return linux_hard_ecid_2;
	}
	public void setLinux_hard_ecid_2(String linux_hard_ecid_2) {
		this.linux_hard_ecid_2 = linux_hard_ecid_2;
	}
	public String getLinux_hard_ecid_3() {
		return linux_hard_ecid_3;
	}
	public void setLinux_hard_ecid_3(String linux_hard_ecid_3) {
		this.linux_hard_ecid_3 = linux_hard_ecid_3;
	}
	@Override
	public String toString() {
		return "Robot_LinuxhardwareInfo [deviceNo=" + deviceNo + ", linux_hard_ecid_0=" + linux_hard_ecid_0
				+ ", linux_hard_ecid_1=" + linux_hard_ecid_1 + ", linux_hard_ecid_2=" + linux_hard_ecid_2
				+ ", linux_hard_ecid_3=" + linux_hard_ecid_3 + "]";
	}
}
