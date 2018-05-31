package org.ms.service.ablecloud;

import com.ablecloud.common.ACObject;
import com.ablecloud.service.AC;
import com.ablecloud.service.ACDStore;
import org.ms.mapper.ablecloud.BewinchDeviceInfoMapper;
import org.ms.mapper.ablecloud.BewinchPropertyMapper;
import org.ms.module.ablecloud.BewinchDeviceInfo;
import org.ms.module.ablecloud.BewinchProperty;
import org.ms.tool.ablecloud.MyAcSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 9:57
 */
@Service
public class BewinchPropertyServiceImpl implements BewinchPropertyService{

    private Logger logger = LoggerFactory.getLogger("baseBack");

    @Autowired
    private BewinchDeviceInfoMapper bewinchDeviceInfoMapper;
    @Autowired
    private BewinchPropertyMapper bewinchPropertyMapper;

    @Override
    public void dailyBackBewinchProperty() {
        AC ac = MyAcSingleton.newInstance();
        long yesterday=System.currentTimeMillis()-24*60*60*1000;
        long startTime = yesterday/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
        long endTime = startTime+(24*60*60-1)*1000;
        //System.out.println("机器属性时间段:"+startTime + " - " + endTime);

        // 取所有的机器，如果机器列表太大，则这边考虑优化
        List<BewinchDeviceInfo> deviceInfos = bewinchDeviceInfoMapper.getAllBewinchDeviceInfos();
        //System.out.println("取得的机器列表大小:"+deviceInfos.size());

		/*for (DeviceInfo deviceInfo : deviceInfos) {
			handleDeviceInfo(ac,deviceInfo,startTime,endTime);
		}*/

        for(int i = 0;i < deviceInfos.size();i++) {
            //if (i < 10) {

            handleDeviceInfo(ac, deviceInfos.get(i), startTime, endTime);
            //}
        }
    }

    private void handleDeviceInfo(AC ac,BewinchDeviceInfo bewinchDeviceInfo, long startTime, long endTime) {
        List<ACObject> acObjects;
        try {
            acObjects = ac.dstore(bewinchDeviceInfo.getSubDomainName())
                    .scanHistory(bewinchDeviceInfo.getLogicId())
                    .select(ACDStore.TIMESTAMP, "rawWaterValue", "cleanTotalWater", "cleanWaterValue",
                            "temperatureLock", "handleWaterSpeed", "currentPumpADValue", "todayCleanHotWater",
                            "currentPumpPWNValue", "currentVoltageValue", "firstFilterLifeTIme",
                            "forthFilterLifeTime", "measureWaterForever", "thridFilterLifeTIme",
                            "todayCleanColdWater", "secondFilterLifeTime", "measureFetchWaterValue",
                            "afterLastFetchWaterTime", "firstFilterSurplusScale", "thridFilterSurplusScale",
                            "fourthFilterSurplusScale", "secondFilterSurplusScale", "currentTotalCleanWaterValue",
                            "currentFetchWaterRealityTemper", "currentFetchWaterLockTemperature", "snCode",
                            "reservePlace")
                    .startTime(startTime).endTime(endTime).limit(1000).execute();

            //System.out.println(deviceInfo.getPhysicalId()+"查询到数据条数：" + acObjects.size() +"时间段:"+startTime +" 至: "+endTime);

            List<BewinchProperty> bewinchProperties = new ArrayList<>();
            for (ACObject acObject : acObjects) {
                BewinchProperty bp = new BewinchProperty();
                bp.setPhysicalId(bewinchDeviceInfo.getPhysicalId());
                bp.setReportTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(acObject.getLong(ACDStore.TIMESTAMP)),
                        ZoneId.systemDefault()));
                bp.setRawWaterValue(acObject.getInt("rawWaterValue"));
                bp.setCleanTotalWater(acObject.getInt("cleanTotalWater"));
                bp.setCleanWaterValue(acObject.getInt("cleanWaterValue"));
                bp.setDeviceBreakdown(acObject.getInt("deviceBreakdown"));
                bp.setTemperatureLock(acObject.getInt("temperatureLock"));
                bp.setHandleWaterSpeed(acObject.getInt("handleWaterSpeed"));
                bp.setCurrentPumpADValue(acObject.getInt("currentPumpADValue"));
                bp.setTodayCleanHotWater(acObject.getInt("todayCleanHotWater"));
                bp.setCurrentPumpPWNValue(acObject.getInt("currentPumpPWNValue"));
                bp.setCurrentVoltageValue(acObject.getInt("currentVoltageValue"));
                bp.setFirstFilterLifeTIme(acObject.getInt("firstFilterLifeTIme"));
                bp.setForthFilterLifeTime(acObject.getInt("forthFilterLifeTime"));
                bp.setMeasureWaterForever(acObject.getInt("measureWaterForever"));
                bp.setThridFilterLifeTIme(acObject.getInt("thridFilterLifeTIme"));
                bp.setTodayCleanColdWater(acObject.getInt("todayCleanColdWater"));
                bp.setSecondFilterLifeTime(acObject.getInt("secondFilterLifeTime"));
                bp.setMeasureFetchWaterValue(acObject.getInt("measureFetchWaterValue"));
                bp.setAfterLastFetchWaterTime(acObject.getInt("afterLastFetchWaterTime"));
                bp.setFirstFilterSurplusScale(acObject.getInt("firstFilterSurplusScale"));
                bp.setThridFilterSurplusScale(acObject.getInt("thridFilterSurplusScale"));
                bp.setFourthFilterSurplusScale(acObject.getInt("fourthFilterSurplusScale"));
                bp.setSecondFilterSurplusScale(acObject.getInt("secondFilterSurplusScale"));
                bp.setCurrentTotalCleanWaterValue(acObject.getInt("currentTotalCleanWaterValue"));
                bp.setCurrentFetchWaterRealityTemper(acObject.getInt("currentFetchWaterRealityTemper"));
                bp.setCurrentFetchWaterLockTemperature(acObject.getInt("currentFetchWaterLockTemperature"));
                bp.setSnCode(acObject.getString("snCode"));
                bp.setReservePlace(acObject.getInt("reservePlace"));
                bp.setCreateTime(LocalDateTime.now());
                bewinchProperties.add(bp);
            }

            if (bewinchProperties.size() > 0 && bewinchProperties.size() < 1000) {
                int result = bewinchPropertyMapper.insertBewinchPropertyBatch(bewinchProperties);
                //System.out.println("成功插入"+result+"条");
            }else if (bewinchProperties.size()==1000) {
                int result = bewinchPropertyMapper.insertBewinchPropertyBatch(bewinchProperties);
                //System.out.println("成功插入"+result+"条，进行递归"+deviceInfo.getPhysicalId());
                long middleTime = bewinchProperties.get(999).getReportTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()+1;
                handleDeviceInfo(ac, bewinchDeviceInfo, middleTime, endTime);
            }

        } catch (Exception e) {
			/*System.out.println("出现问题的机器编号"+deviceInfo.getPhysicalId());
			e.printStackTrace();*/
            logger.error("出现问题的机器编号"+bewinchDeviceInfo.getPhysicalId()+" 错误:"+e.getMessage());
        }
    }
}
