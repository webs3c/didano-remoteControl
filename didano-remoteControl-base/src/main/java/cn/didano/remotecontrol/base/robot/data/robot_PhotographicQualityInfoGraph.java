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
 * 照片的质量信息类
 * @Todo 
 */
@ApiModel
@TypeAlias("照片质量")
public class robot_PhotographicQualityInfoGraph extends rInfo {
	@ApiModelProperty(value = "最大信心指数", required = true)
	private String confidence_statistics_max;
	@ApiModelProperty(value = "平均的信心指数", required = true)
	private String confidence_statistics_average;
	@ApiModelProperty(value = "最小信心指数", required = true)
	private String confidence_statistics_min;
	@ApiModelProperty(value = "时间", required = true)
	private long createDate1;

	@ApiModelProperty(value = "最大信心指数", required = true)
	private String confidence_statistics_max2;
	@ApiModelProperty(value = "平均的信心指数", required = true)
	private String confidence_statistics_average2;
	@ApiModelProperty(value = "最小信心指数", required = true)
	private String confidence_statistics_min2;
	@ApiModelProperty(value = "时间", required = true)
	private long createDate2;
	public String getConfidence_statistics_max() {
		return confidence_statistics_max;
	}
	public void setConfidence_statistics_max(String confidence_statistics_max) {
		this.confidence_statistics_max = confidence_statistics_max;
	}
	public String getConfidence_statistics_average() {
		return confidence_statistics_average;
	}
	public void setConfidence_statistics_average(String confidence_statistics_average) {
		this.confidence_statistics_average = confidence_statistics_average;
	}
	public String getConfidence_statistics_min() {
		return confidence_statistics_min;
	}
	public void setConfidence_statistics_min(String confidence_statistics_min) {
		this.confidence_statistics_min = confidence_statistics_min;
	}
	
	public String getConfidence_statistics_max2() {
		return confidence_statistics_max2;
	}
	public void setConfidence_statistics_max2(String confidence_statistics_max2) {
		this.confidence_statistics_max2 = confidence_statistics_max2;
	}
	public String getConfidence_statistics_average2() {
		return confidence_statistics_average2;
	}
	public void setConfidence_statistics_average2(String confidence_statistics_average2) {
		this.confidence_statistics_average2 = confidence_statistics_average2;
	}
	public String getConfidence_statistics_min2() {
		return confidence_statistics_min2;
	}
	public void setConfidence_statistics_min2(String confidence_statistics_min2) {
		this.confidence_statistics_min2 = confidence_statistics_min2;
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
