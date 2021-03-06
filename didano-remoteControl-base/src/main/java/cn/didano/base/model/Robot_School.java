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
@TypeAlias("保存小学校")
public class Robot_School extends rInfo {
	
	@ApiModelProperty(value = "产品硬件识别码", required = true)
	public String deviceNo;
	
	@ApiModelProperty(value = "所属学校的名称", required = true)
	public String schoolName;

	@ApiModelProperty(value = "设备类型", required = true)
	public Integer systemType;
	
	@ApiModelProperty(value = "在线说明", required = true)
	public String isOnline;
	
	public Integer getSystemType() {
		return systemType;
	}

	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	
}
