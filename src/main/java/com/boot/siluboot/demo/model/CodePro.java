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

/**
* 项目字典表（示例）
* @author anjh
* @since 2020年7月10日
*/
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class CodePro implements Serializable {

	/**
	 * 字典ID
	 */
	private String dictId;
	
	/**
	 * 字典值
	 */
	private String dictName;
	
	/**
	 * 字典类型
	 */
	private String dictType;

}
