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
 * @类名称：TemperatureInfo
 * @类描述：上报环境温度信息
 * @创建人：杨朝强
 * @创建时间：2017年3月17日 下午3:38:14：
 * @version
 */
@ApiModel
@TypeAlias("linux运行环境温度")
public class robot_LinuxEnvTemperatureInfo extends rInfo {

	@ApiModelProperty(value = "产品硬件识别码", required = true)
	private String deviceNo;
	@ApiModelProperty(value = "版本类型", required = true)
	private String systemType;
	@ApiModelProperty(value = "Linux板环境温度", required = true)
	private String linux_env_temperature;
	@ApiModelProperty(value = "Linux板CPU当前温度", required = true)
	private String linux_cpu_temperature;
	@ApiModelProperty(value = "得到Linux板CPU当前温度的时间", required = true)
	private String linux_temperature_time;
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
	public String getLinux_env_temperature() {
		return linux_env_temperature;
	}
	public void setLinux_env_temperature(String linux_env_temperature) {
		this.linux_env_temperature = linux_env_temperature;
	}
	public String getLinux_cpu_temperature() {
		return linux_cpu_temperature;
	}
	public void setLinux_cpu_temperature(String linux_cpu_temperature) {
		this.linux_cpu_temperature = linux_cpu_temperature;
	}
	public String getLinux_temperature_time() {
		return linux_temperature_time;
	}
	public void setLinux_temperature_time(String linux_temperature_time) {
		this.linux_temperature_time = linux_temperature_time;
	}
	@Override
	public String toString() {
		return "Robot_TemperatureInfo [deviceNo=" + deviceNo + ", linux_env_temperature=" + linux_env_temperature
				+ ", linux_cpu_temperature=" + linux_cpu_temperature + ", linux_temperature_time="
				+ linux_temperature_time + "]";
	}
}
