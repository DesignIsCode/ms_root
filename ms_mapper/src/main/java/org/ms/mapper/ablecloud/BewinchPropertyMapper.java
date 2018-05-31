package org.ms.mapper.ablecloud;

import org.apache.ibatis.annotations.Param;
import org.ms.module.ablecloud.BewinchProperty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BewinchPropertyMapper {
    int insertBewinchPropertyBatch(@Param("bewinchProperties") List<BewinchProperty> bewinchProperties);
}
