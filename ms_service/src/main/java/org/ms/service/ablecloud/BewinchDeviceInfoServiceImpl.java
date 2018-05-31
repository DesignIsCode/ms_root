package org.ms.service.ablecloud;

import com.ablecloud.common.ACDeviceInfo;
import com.ablecloud.common.ACObject;
import com.ablecloud.service.AC;
import org.ms.mapper.ablecloud.BewinchDeviceInfoMapper;
import org.ms.module.ablecloud.BewinchDeviceInfo;
import org.ms.tool.ablecloud.MyAcSingleton;
import org.ms.tool.ablecloud.SystemVairable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 9:54
 */
@Service
public class BewinchDeviceInfoServiceImpl implements BewinchDeviceInfoService{
    private Logger logger = LoggerFactory.getLogger("baseBack");

    private BewinchDeviceInfoMapper bewinchDeviceInfoMapper;

    @Autowired
    public BewinchDeviceInfoServiceImpl(BewinchDeviceInfoMapper bewinchDeviceInfoMapper) {
        this.bewinchDeviceInfoMapper = bewinchDeviceInfoMapper;
    }

    public List<BewinchDeviceInfo> getBewinchDeviceInfos() {
        return bewinchDeviceInfoMapper.getAllBewinchDeviceInfos();
    }

    @Override
    public int initAllDevices() {
        int result = 0;
        List<BewinchDeviceInfo> list = getAbleCloudDevices();
        list.stream().forEach(deviceInfo -> {
            try {
                deviceInfo
                        .setLogicId(MyAcSingleton.newInstance().warehouseMgr(MyAcSingleton.newInstance().newContext(""))
                                .getDeviceLogicalId(deviceInfo.getSubDomainName(), deviceInfo.getPhysicalId()));
            } catch (Exception e) {
                logger.error("云端列表查询逻辑ID错误:" + e.getMessage());
            }
        });
        if (list.size() > 0) {
            result = bewinchDeviceInfoMapper.insertBewinchDeviceInfosBatch(list);
            return result;
        } else {
            return result;
        }
    }

    /**
     * 已激活时间，判断增量更新
     */
    @Override
    public int dailyActivateDevices() {
        int result = 0;
        try {
            List<BewinchDeviceInfo> deviceInfos;
            if (SystemVairable.compareDate != null) {
                deviceInfos = getAbleCloudDevices().stream().filter(deviceInfo -> SystemVairable.compareDate
                        .compareTo(deviceInfo.getActiveTime().toLocalDate()) < 0).collect(Collectors.toList());
            } else {
                deviceInfos = getAbleCloudDevices().stream()
                        .filter(deviceInfo -> LocalDate.now().minusDays(1)
                                .compareTo(deviceInfo.getActiveTime().toLocalDate()) == 0)
                        // .filter(deviceInfo ->
                        // LocalDate.parse("2018-02-05").compareTo(deviceInfo.getActiveTime().toLocalDate())
                        // == 0)
                        .collect(Collectors.toList());
            }
            if (deviceInfos.size() > 0) {
                deviceInfos.stream().forEach(deviceInfo -> {
                    try {
                        deviceInfo.setLogicId(
                                MyAcSingleton.newInstance().warehouseMgr(MyAcSingleton.newInstance().newContext(""))
                                        .getDeviceLogicalId(deviceInfo.getSubDomainName(), deviceInfo.getPhysicalId()));
                    } catch (Exception e) {
                        logger.error("云端列表查询逻辑ID错误:" + e.getMessage());
                    }
                });
                // System.out.println("找到今天新增的设备："+deviceInfos.size());
                result = bewinchDeviceInfoMapper.insertBewinchDeviceInfosBatch(deviceInfos);
                SystemVairable.compareDate = null;
                return result;
            } else {
                return result;
            }
        } catch (Exception e) {
            SystemVairable.compareDate = LocalDate.now();
            logger.error("云端每日抓取机器列表错误:" + e.getMessage());
            return result;
        }
    }

    /**
     * 获取云端机器列表
     *
     * @return
     */
    private List<BewinchDeviceInfo> getAbleCloudDevices() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        AC ac = MyAcSingleton.newInstance();
        ACObject acObject = null;
        int offset = 0, limit = 100, inWarehouseDevices, activeDevices, onlineDevices;
        List<ACDeviceInfo> allDevices = new ArrayList<>();
        List<BewinchDeviceInfo> insertDevices = new ArrayList<>();
        try {
            acObject = ac.warehouseMgr(ac.newContext("")).getDeviceCountExt("");
            inWarehouseDevices = Integer.valueOf(acObject.getString("count"));
            /*
             * activeDevices = Integer.valueOf(acObject.getString("activeCount"));
             * onlineDevices = Integer.valueOf(acObject.getString("onlineCount"));
             */
            while (offset <= inWarehouseDevices) {
                List<ACDeviceInfo> partDevices = ac.warehouseMgr(ac.newContext("")).listDevices("", offset, limit);
                allDevices.addAll(partDevices);
                offset += limit;
            }
            allDevices.stream().filter(deviceInfo -> deviceInfo.getStatus() == 2).collect(Collectors.toList())
                    .forEach(acDeviceInfo -> {
                        BewinchDeviceInfo deviceInfo = new BewinchDeviceInfo();
                        // try {
                        deviceInfo.setPhysicalId(acDeviceInfo.getPhysicalId());
                        deviceInfo.setMajorDomain(acDeviceInfo.getMajorDomain());
                        deviceInfo.setSubDomain(acDeviceInfo.getSubDomain());
                        deviceInfo.setSubDomainName(acDeviceInfo.getSubDomainName());
                        deviceInfo.setDevVersion(acDeviceInfo.getDevVersion());
                        deviceInfo.setModVersion(acDeviceInfo.getModVersion());
                        deviceInfo.setIpAddress(acDeviceInfo.getIPAddress());
                        deviceInfo.setMacAddress(acDeviceInfo.getMacAddress());
                        deviceInfo.setActiveTime(!"".equals(acDeviceInfo.getActiveTime())
                                ? LocalDateTime.parse(acDeviceInfo.getActiveTime(), dtf)
                                : null);
                        /*
                         * deviceInfo.setCountry("GBK".equalsIgnoreCase(System.getProperty(
                         * "file.encoding")) ? new String(acDeviceInfo.getCountry().getBytes("gbk"),
                         * "utf-8") : acDeviceInfo.getCountry());
                         */
                        deviceInfo.setCountry(acDeviceInfo.getCountry());
                        /*
                         * deviceInfo.setProvince("GBK".equalsIgnoreCase(System.getProperty(
                         * "file.encoding")) ? new String(acDeviceInfo.getProvince().getBytes("gbk"),
                         * "utf-8") : acDeviceInfo.getProvince());
                         */
                        deviceInfo.setProvince(acDeviceInfo.getProvince());
                        /*
                         * deviceInfo.setCity("GBK".equalsIgnoreCase(System.getProperty("file.encoding")
                         * ) ? new String(acDeviceInfo.getCity().getBytes("gbk"), "utf-8") :
                         * acDeviceInfo.getCity());
                         */
                        deviceInfo.setCity(acDeviceInfo.getCity());
                        /*
                         * deviceInfo.setStreet("GBK".equalsIgnoreCase(System.getProperty(
                         * "file.encoding")) ? new String(acDeviceInfo.getStreet().getBytes("gbk"),
                         * "utf-8") : acDeviceInfo.getStreet());
                         */
                        deviceInfo.setStreet(acDeviceInfo.getStreet());
                        deviceInfo.setLastOnlineTime(!"".equals(acDeviceInfo.getLastOnlineTime())
                                ? LocalDateTime.parse(acDeviceInfo.getLastOnlineTime(), dtf)
                                : null);
                        deviceInfo.setStatus(acDeviceInfo.getStatus());
                        deviceInfo.setAcType(acDeviceInfo.getType());
                        /*
                         * } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
                         */
                        insertDevices.add(deviceInfo);
                    });
            /*
             * System.out.println("cloudDecices:" + insertDevices.size());
             * System.out.println(insertDevices.get(0).toString());
             */

        } catch (Exception e) {
            logger.error("云端抓取机器列表错误:" + e.getMessage());
        }
        return insertDevices;
    }
}
