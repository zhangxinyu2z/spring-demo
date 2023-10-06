package com.z2xinyu.wiring.beans.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MediaPlayerConfig.class, CompactDiscConfig.class})
public class SoundSystemConfig {

}
