/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.identitymanagement.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * Delete Group Policy Request Marshaller
 */
public class DeleteGroupPolicyRequestMarshaller implements Marshaller<Request<DeleteGroupPolicyRequest>, DeleteGroupPolicyRequest> {

    public Request<DeleteGroupPolicyRequest> marshall(DeleteGroupPolicyRequest deleteGroupPolicyRequest) {

        if (deleteGroupPolicyRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}

        Request<DeleteGroupPolicyRequest> request = new DefaultRequest<DeleteGroupPolicyRequest>(deleteGroupPolicyRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "DeleteGroupPolicy");
        request.addParameter("Version", "2010-05-08");

        if (deleteGroupPolicyRequest.getGroupName() != null) {
            request.addParameter("GroupName", StringUtils.fromString(deleteGroupPolicyRequest.getGroupName()));
        }
        if (deleteGroupPolicyRequest.getPolicyName() != null) {
            request.addParameter("PolicyName", StringUtils.fromString(deleteGroupPolicyRequest.getPolicyName()));
        }


        return request;
    }
}