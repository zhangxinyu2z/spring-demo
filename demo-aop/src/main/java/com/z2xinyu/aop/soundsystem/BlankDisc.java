package com.z2xinyu.aop.soundsystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/** 空白光盘 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    List<String> tracks;

    /** 关注点是播放本身 */
    @Override
    public void playTrack(int trackNumber) {
        log.info("playTrack title:{}, artist:{}, trackNumber:{}", title, artist, trackNumber);
    }
}
