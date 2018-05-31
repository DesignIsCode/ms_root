package org.ms.service.ablecloud;

import org.ms.module.ablecloud.BewinchDeviceInfo;

import java.util.List;

public interface BewinchDeviceInfoService {
    public List<BewinchDeviceInfo> getBewinchDeviceInfos();

    /**
     * 初始化所有设备
     * @return
     */
    int initAllDevices();

    /**
     * 每天新增设备
     * @return
     */
    int dailyActivateDevices();
}
