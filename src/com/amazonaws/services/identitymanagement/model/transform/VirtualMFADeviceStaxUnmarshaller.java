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

import com.amazonaws.services.identitymanagement.model.VirtualMFADevice;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

import javax.xml.stream.events.XMLEvent;


/**
 * Virtual M F A Device StAX Unmarshaller
 */
public class VirtualMFADeviceStaxUnmarshaller implements Unmarshaller<VirtualMFADevice, StaxUnmarshallerContext> {

    public VirtualMFADevice unmarshall(StaxUnmarshallerContext context) throws Exception {
        VirtualMFADevice virtualMFADevice = new VirtualMFADevice();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        
        if (context.isStartOfDocument()) targetDepth += 2;
        

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return virtualMFADevice;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("SerialNumber", targetDepth)) {
                    virtualMFADevice.setSerialNumber(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Base32StringSeed", targetDepth)) {
                    virtualMFADevice.setBase32StringSeed(ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("QRCodePNG", targetDepth)) {
                    virtualMFADevice.setQRCodePNG(ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("User", targetDepth)) {
                    virtualMFADevice.setUser(UserStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("EnableDate", targetDepth)) {
                    virtualMFADevice.setEnableDate(DateStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return virtualMFADevice;
                }
            }
        }
    }

    private static VirtualMFADeviceStaxUnmarshaller instance;
    public static VirtualMFADeviceStaxUnmarshaller getInstance() {
        if (instance == null) instance = new VirtualMFADeviceStaxUnmarshaller();
        return instance;
    }
}
    