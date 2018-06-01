package org.ms.api.ablecloud;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SuperAndy
 * @Date 2018-06-01 16:39
 */
@RestController
@RequestMapping("/ablecloudMember")
public class AbleCloudMemberController {

    @RequestMapping("/findAbleCloudMemberById")
    public JSONObject findAbleCloudMemberById(){
        return null;
    }
}
