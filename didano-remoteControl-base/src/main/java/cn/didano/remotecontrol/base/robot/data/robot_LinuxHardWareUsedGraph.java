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
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *机器的运行环境类
 *主要是上行和下行的信息容器
 */
@QueryEntity
@Document
@ApiModel
@TypeAlias("Linux的硬件使用信息")
public class robot_LinuxHardWareUsedGraph extends rInfo{
	@ApiModelProperty(value = "linux版CPU最高使用率", required = true)
	private String linux_cpu_used;
	@ApiModelProperty(value = "linux版flash的CPU使用率", required = true)
	private String linux_flash_used;
	
	@ApiModelProperty(value = "linux板内存最高使用率", required = true)
	private String linux_memory_used;
	
	@ApiModelProperty(value = "wifi信号", required = true)
	private String linux_wifi_signal;
	
	@ApiModelProperty(value = "linux版CPU最高使用率", required = true)
	private String linux_cpu_used2;
	@ApiModelProperty(value = "linux版flash的CPU使用率", required = true)
	private String linux_flash_used2;
	
	@ApiModelProperty(value = "linux板内存最高使用率", required = true)
	private String linux_memory_used2;
	
	@ApiModelProperty(value = "wifi信号", required = true)
	private String linux_wifi_signal2;
	
	@ApiModelProperty(value = "时间", required = true)
	private long createDate1;
	
	@ApiModelProperty(value = "时间", required = true)
	private long createDate2;
	
	public String getLinux_cpu_used() {
		return linux_cpu_used;
	}

	public void setLinux_cpu_used(String linux_cpu_used) {
		this.linux_cpu_used = linux_cpu_used;
	}

	public String getLinux_flash_used() {
		return linux_flash_used;
	}

	public void setLinux_flash_used(String linux_flash_used) {
		this.linux_flash_used = linux_flash_used;
	}

	public String getLinux_memory_used() {
		return linux_memory_used;
	}

	public void setLinux_memory_used(String linux_memory_used) {
		this.linux_memory_used = linux_memory_used;
	}

	public String getLinux_wifi_signal() {
		return linux_wifi_signal;
	}

	public void setLinux_wifi_signal(String linux_wifi_signal) {
		this.linux_wifi_signal = linux_wifi_signal;
	}

	public String getLinux_cpu_used2() {
		return linux_cpu_used2;
	}

	public void setLinux_cpu_used2(String linux_cpu_used2) {
		this.linux_cpu_used2 = linux_cpu_used2;
	}

	public String getLinux_flash_used2() {
		return linux_flash_used2;
	}

	public void setLinux_flash_used2(String linux_flash_used2) {
		this.linux_flash_used2 = linux_flash_used2;
	}

	public String getLinux_memory_used2() {
		return linux_memory_used2;
	}

	public void setLinux_memory_used2(String linux_memory_used2) {
		this.linux_memory_used2 = linux_memory_used2;
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
