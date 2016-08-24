/**
 * Copyright (c) 2010~2012 All Rights Reserved by
 * G-Net Integrated Service Co.,  Ltd.
 *
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22
 * Revision History
 * - 2012-9-26: change content for what reason
 ****************************************************************************************/
/**
 * @file DeviceUtil.java
 * @author wenhui.li
 * @date 2012-9-26 下午8:00:22 
 * Revision History 
 *     - 2012-9-26: change content for what reason
 ****************************************************************************************/

package com.leihan.launcherbadge;

public class DeviceUtil {

    public final static String DEVICE_XIAOMI = "xiaomi";
    public final static String DEVICE_MEIZU = "meizu";
    public final static String DEVICE_SAMSUNG = "samsung";
    public final static String DEVICE_HTC = "htc";

    /**
     * 判断该手机设备是否是某特殊机型
     * @param compareManufacturer 需要比较的特殊机型
     * @return
     */
    public static boolean isSpecialDevice(String compareManufacturer) {
        String manufacturer = android.os.Build.MANUFACTURER;
        if (manufacturer.equalsIgnoreCase(compareManufacturer)) {
            return true;
        }
        return false;
    }

}
