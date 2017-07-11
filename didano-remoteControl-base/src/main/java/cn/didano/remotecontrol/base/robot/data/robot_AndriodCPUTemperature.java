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
@TypeAlias("安卓的cpu温度")
public class robot_AndriodCPUTemperature extends rInfo {
	@ApiModelProperty(value = "产品硬件识别码", required = true)
	private String deviceNo;
	@ApiModelProperty(value = "类型", required = true)
	private String systemType;
	@ApiModelProperty(value = "Android板CPU当前温度", required = true)
	private String android_cpu_temperature;
	@ApiModelProperty(value = "Android板获取温度的时间", required = true)
	private String android_temperature_time;
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
	public String getAndroid_cpu_temperature() {
		return android_cpu_temperature;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public void setAndroid_cpu_temperature(String android_cpu_temperature) {
		this.android_cpu_temperature = android_cpu_temperature;
	}
	public String getAndroid_temperature_time() {
		return android_temperature_time;
	}
	public void setAndroid_temperature_time(String android_temperature_time) {
		this.android_temperature_time = android_temperature_time;
	}
	@Override
	public String toString() {
		return "robot_AndriodCPUTemperature [deviceNo=" + deviceNo + ", android_cpu_temperature="
				+ android_cpu_temperature + ", android_temperature_time=" + android_temperature_time + ", schoolName="
				+ schoolName + "]";
	}
}
