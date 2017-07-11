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
public class robot_AndriodCPUTemperatureGraph extends rInfo {
	@ApiModelProperty(value = "Android板CPU当前温度", required = true)
	private String android_cpu_temperature;
	
	@ApiModelProperty(value = "Android板CPU当前温度", required = true)
	private String android_cpu_temperature2;
	
	@ApiModelProperty(value = "时间1", required = true)
	private long createDate1;
	
	@ApiModelProperty(value = "时间2", required = true)
	private long createDate2;

	public String getAndroid_cpu_temperature() {
		return android_cpu_temperature;
	}

	public void setAndroid_cpu_temperature(String android_cpu_temperature) {
		this.android_cpu_temperature = android_cpu_temperature;
	}

	public String getAndroid_cpu_temperature2() {
		return android_cpu_temperature2;
	}

	public void setAndroid_cpu_temperature2(String android_cpu_temperature2) {
		this.android_cpu_temperature2 = android_cpu_temperature2;
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
