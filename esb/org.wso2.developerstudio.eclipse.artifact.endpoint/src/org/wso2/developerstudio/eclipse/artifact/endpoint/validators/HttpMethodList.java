/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.endpoint.validators;


import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.types.HttpMethodType;


public class HttpMethodList extends AbstractListDataProvider{

	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		for (HttpMethodType type : HttpMethodType.values()) {
			list.add(createListData(type.name(), type));
		}

		return list;
	}

}