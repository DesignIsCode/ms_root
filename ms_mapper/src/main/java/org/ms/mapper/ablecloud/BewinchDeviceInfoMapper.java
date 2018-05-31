package org.ms.mapper.ablecloud;


import org.apache.ibatis.annotations.Param;
import org.ms.module.ablecloud.BewinchDeviceInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BewinchDeviceInfoMapper {
    BewinchDeviceInfo getBewinchDeviceInfoByPhysicalId(String physicalId);

    List<BewinchDeviceInfo> getAllBewinchDeviceInfos();

    Integer insertBewinchDeviceInfosBatch(@Param("deviceInfos") List<BewinchDeviceInfo> newBewinchDeviceInfos);
}
