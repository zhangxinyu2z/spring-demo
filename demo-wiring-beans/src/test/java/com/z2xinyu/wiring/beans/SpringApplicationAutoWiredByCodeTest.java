package com.z2xinyu.wiring.beans;

import com.z2xinyu.wiring.beans.config.SoundSystemConfig;
import com.z2xinyu.wiring.beans.sample.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xinyu.zhang
 * @since 2022/11/6 12:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 也可以分别引入CompactDiscConfig和MediaPlayerConfig
@ContextConfiguration(classes = {SoundSystemConfig.class})
public class SpringApplicationAutoWiredByCodeTest {
    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void play() {
        mediaPlayer.play();
    }
}
