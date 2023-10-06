package com.z2xinyu.aop.concert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        log.info("演唱会演出很好，返场");
    }
}
