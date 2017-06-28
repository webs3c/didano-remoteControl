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

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryEntity;

import io.swagger.annotations.ApiModel;

/**
 * 
 * @author stephen.wang
 */
@Document
@QueryEntity
@ApiModel
public class rInfo {

	@Id // 自动生成唯一索引号
	@JsonIgnore // json转换，忽略该属性
	private ObjectId id;

	@CreatedDate // 自动生成时间
	//@JsonIgnore // json转换，忽略该属性
	private Date createDate;

	@Version // 自动生成自然数
	@JsonIgnore // json转换，忽略该属性
	private int version;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
