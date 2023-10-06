package com.z2xinyu.wiring.beans.config;

import com.z2xinyu.wiring.beans.sample.CDPlayer;
import com.z2xinyu.wiring.beans.sample.CompactDisc;
import com.z2xinyu.wiring.beans.sample.MediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ImportResource("classpath:cd-config.xml")
@Import(value = {CompactDiscConfig.class})
public class MediaPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}