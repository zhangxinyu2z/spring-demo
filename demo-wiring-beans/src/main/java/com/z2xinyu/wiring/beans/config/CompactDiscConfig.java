package com.z2xinyu.wiring.beans.config;

import com.z2xinyu.wiring.beans.sample.CompactDisc;
import com.z2xinyu.wiring.beans.sample.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompactDiscConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

}
