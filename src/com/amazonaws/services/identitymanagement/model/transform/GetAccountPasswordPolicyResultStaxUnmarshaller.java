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

import com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

import javax.xml.stream.events.XMLEvent;


/**
 * Get Account Password Policy Result StAX Unmarshaller
 */
public class GetAccountPasswordPolicyResultStaxUnmarshaller implements Unmarshaller<GetAccountPasswordPolicyResult, StaxUnmarshallerContext> {

    public GetAccountPasswordPolicyResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        GetAccountPasswordPolicyResult getAccountPasswordPolicyResult = new GetAccountPasswordPolicyResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        
        if (context.isStartOfDocument()) targetDepth += 2;
        

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return getAccountPasswordPolicyResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("PasswordPolicy", targetDepth)) {
                    getAccountPasswordPolicyResult.setPasswordPolicy(PasswordPolicyStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return getAccountPasswordPolicyResult;
                }
            }
        }
    }

    private static GetAccountPasswordPolicyResultStaxUnmarshaller instance;
    public static GetAccountPasswordPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new GetAccountPasswordPolicyResultStaxUnmarshaller();
        return instance;
    }
}
    