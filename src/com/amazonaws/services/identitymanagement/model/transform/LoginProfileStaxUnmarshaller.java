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

import com.amazonaws.services.identitymanagement.model.LoginProfile;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

import javax.xml.stream.events.XMLEvent;


/**
 * Login Profile StAX Unmarshaller
 */
public class LoginProfileStaxUnmarshaller implements Unmarshaller<LoginProfile, StaxUnmarshallerContext> {

    public LoginProfile unmarshall(StaxUnmarshallerContext context) throws Exception {
        LoginProfile loginProfile = new LoginProfile();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        
        if (context.isStartOfDocument()) targetDepth += 2;
        

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return loginProfile;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("UserName", targetDepth)) {
                    loginProfile.setUserName(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("CreateDate", targetDepth)) {
                    loginProfile.setCreateDate(DateStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return loginProfile;
                }
            }
        }
    }

    private static LoginProfileStaxUnmarshaller instance;
    public static LoginProfileStaxUnmarshaller getInstance() {
        if (instance == null) instance = new LoginProfileStaxUnmarshaller();
        return instance;
    }
}
    