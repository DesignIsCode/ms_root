package org.ms.mapper.ablecloud;

import org.apache.ibatis.annotations.Param;
import org.ms.module.ablecloud.AbleCloudMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbleCloudMemberMapper {
    int insertAbleCloudMember(@Param("ableCloudMembers") List<AbleCloudMember> listAbleCloudMember);

    List<AbleCloudMember> getAllAbleCloudMember();
}
