package com.z2xinyu.aop.concert;

import com.z2xinyu.aop.annotation.ApiLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PerformanceImpl implements Performance {
    @Override
    @ApiLog(title = "表演",isSaveRequestData = false)
    public String performance(String show) {
        log.info("演员开始表演啦");
        return "本场演出表演的是：" + show;
    }
}
