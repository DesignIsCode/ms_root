package org.ms.mapper.ablecloud;


import org.apache.ibatis.annotations.Param;
import org.ms.module.ablecloud.MemberDevice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDeviceMapper {
    int insertMemberDevice(@Param("memberDevices")List<MemberDevice> listMemberrDevice);
}
