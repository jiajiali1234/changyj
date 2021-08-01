/*
 * Copyright(C) 2000-2011 THS Technology Limited Company, http://www.ths.com.cn
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
package com.boot.siluboot.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目基本信息（示例）
 * @author anjh
 * @since 2020年7月10日
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class ProInfo implements Serializable {

	/**
	 * 项目ID
	 */
	private String proId;
	/**
	 * 项目名称
	 */
	private String proName;
	/**
	 * 类型
	 */
	private String codeKind;
	/**
	 * 联系方式
	 */
	private String contractName;
	/**
	 * 签署日期
	 */
	private Date signDate;
	/**
	 * 状态
	 */
	private String proStatus;
	/**
	 * 项目经理ID
	 */
	private String managerId;
	/**
	 * 项目经理
	 */
	private String manager;
	/**
	 * 项目费用
	 */
	private String proFee;
	/**
	 * 部门ID
	 */
	private String deptId;
	/**
	 * 所属部门
	 */
	private String deptName;
	/**
	 * 部门经理ID
	 */
	private String deptManagerId;
	/**
	 * 部门经理
	 */
	private String deptManager;
	/**
	 * 描述
	 */
	private String proDesc;
	/**
	 * 创建日期
	 */
	private String createDate;
	/**
	 * 修改日期
	 */
	private String modifyDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 最后修改人
	 */
	private String modifyUser;
	/**
	 * 流程实例
	 */
	private String instanceId;

}
