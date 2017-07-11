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
 *机器的运行环境类
 *主要是上行和下行的信息容器
 */
@ApiModel
@TypeAlias("安卓的硬件使用")
public class robot_AndroidHardWareUsedGraph extends rInfo {
	
	@ApiModelProperty(value = "Android版CPU最高使用率", required = true)
	private String android_cpu_used;
	
	@ApiModelProperty(value = "Android版flash的CPU使用率", required = true)
	private String android_flash_used;
	
	@ApiModelProperty(value = "Android板内存最高使用率", required = true)
	private String android_memory_used;
	
	@ApiModelProperty(value = "wifi信号", required = true)
	private String linux_wifi_signal;
	
	@ApiModelProperty(value = "Android版CPU最高使用率", required = true)
	private String android_cpu_used2;
	
	@ApiModelProperty(value = "Android版flash的CPU使用率", required = true)
	private String android_flash_used2;
	
	@ApiModelProperty(value = "Android板内存最高使用率", required = true)
	private String android_memory_used2;
	
	@ApiModelProperty(value = "wifi信号", required = true)
	private String linux_wifi_signal2;
	
	@ApiModelProperty(value = "时间1", required = true)
	private long createDate1;
	
	@ApiModelProperty(value = "时间2", required = true)
	private long createDate2;

	public String getAndroid_cpu_used() {
		return android_cpu_used;
	}

	public void setAndroid_cpu_used(String android_cpu_used) {
		this.android_cpu_used = android_cpu_used;
	}

	public String getAndroid_flash_used() {
		return android_flash_used;
	}

	public void setAndroid_flash_used(String android_flash_used) {
		this.android_flash_used = android_flash_used;
	}

	public String getAndroid_memory_used() {
		return android_memory_used;
	}

	public void setAndroid_memory_used(String android_memory_used) {
		this.android_memory_used = android_memory_used;
	}

	public String getLinux_wifi_signal() {
		return linux_wifi_signal;
	}

	public void setLinux_wifi_signal(String linux_wifi_signal) {
		this.linux_wifi_signal = linux_wifi_signal;
	}

	public String getAndroid_cpu_used2() {
		return android_cpu_used2;
	}

	public void setAndroid_cpu_used2(String android_cpu_used2) {
		this.android_cpu_used2 = android_cpu_used2;
	}

	public String getAndroid_flash_used2() {
		return android_flash_used2;
	}

	public void setAndroid_flash_used2(String android_flash_used2) {
		this.android_flash_used2 = android_flash_used2;
	}

	public String getAndroid_memory_used2() {
		return android_memory_used2;
	}

	public void setAndroid_memory_used2(String android_memory_used2) {
		this.android_memory_used2 = android_memory_used2;
	}

	public String getLinux_wifi_signal2() {
		return linux_wifi_signal2;
	}

	public void setLinux_wifi_signal2(String linux_wifi_signal2) {
		this.linux_wifi_signal2 = linux_wifi_signal2;
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
