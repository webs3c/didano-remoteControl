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
public class robot_LinuxEnvTemperatureInfoGraph extends rInfo {

	@ApiModelProperty(value = "Linux板环境温度", required = true)
	private String linux_env_temperature;
	@ApiModelProperty(value = "Linux板CPU当前温度", required = true)
	private String linux_cpu_temperature;
	@ApiModelProperty(value = "Linux板环境温度", required = true)
	private String linux_env_temperature2;
	@ApiModelProperty(value = "Linux板CPU当前温度", required = true)
	private String linux_cpu_temperature2;
	@ApiModelProperty(value = "时间", required = true)
	private long createDate1;
	@ApiModelProperty(value = "时间", required = true)
	private long createDate2;
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
	public String getLinux_env_temperature2() {
		return linux_env_temperature2;
	}
	public void setLinux_env_temperature2(String linux_env_temperature2) {
		this.linux_env_temperature2 = linux_env_temperature2;
	}
	public String getLinux_cpu_temperature2() {
		return linux_cpu_temperature2;
	}
	public void setLinux_cpu_temperature2(String linux_cpu_temperature2) {
		this.linux_cpu_temperature2 = linux_cpu_temperature2;
	}
	public long getCreateDate1() {
		return createDate1;
	}
	public void setCreateDate1(long createDate1) {
		this.createDate1 = createDate1;
	}
	public long getCreateDate2() {
		return createDate2;
	}
	public void setCreateDate2(long createDate2) {
		this.createDate2 = createDate2;
	}
	
}
