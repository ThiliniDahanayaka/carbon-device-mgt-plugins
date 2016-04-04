/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.iot.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.device.mgt.core.service.DeviceManagementProviderService;
import org.wso2.carbon.device.mgt.core.service.GroupManagementProviderService;
import org.wso2.carbon.policy.mgt.core.PolicyManagerService;

/**
 * This class provides utility functions used by REST-API.
 */
public class APIUtil {
	private static Log log = LogFactory.getLog(APIUtil.class);

	public static GroupManagementProviderService getGroupManagementProviderService() {
		PrivilegedCarbonContext ctx = PrivilegedCarbonContext.getThreadLocalCarbonContext();
		GroupManagementProviderService groupManagementProviderService =
				(GroupManagementProviderService) ctx.getOSGiService(GroupManagementProviderService.class, null);
		if (groupManagementProviderService == null) {
			String msg = "Group Management service has not initialized.";
			log.error(msg);
			throw new IllegalStateException(msg);
		}
		return groupManagementProviderService;
	}

	public static DeviceManagementProviderService getDeviceManagementService() {
		PrivilegedCarbonContext ctx = PrivilegedCarbonContext.getThreadLocalCarbonContext();
		DeviceManagementProviderService deviceManagementProviderService =
				(DeviceManagementProviderService) ctx.getOSGiService(DeviceManagementProviderService.class, null);
		if (deviceManagementProviderService == null) {
			String msg = "Device Management service has not initialized.";
			log.error(msg);
			throw new IllegalStateException(msg);
		}
		return deviceManagementProviderService;
	}

	public static PolicyManagerService getPolicyManagerService() {
		PrivilegedCarbonContext ctx = PrivilegedCarbonContext.getThreadLocalCarbonContext();
		PolicyManagerService policyManagerService =
				(PolicyManagerService) ctx.getOSGiService(PolicyManagerService.class, null);
		if (policyManagerService == null) {
			String msg = "Policy management service has not initialized.";
			log.error(msg);
			throw new IllegalStateException(msg);
		}
		return policyManagerService;
	}
}