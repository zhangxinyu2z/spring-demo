package com.z2xinyu.aop.soundsystem;

/** 唱片 */
public interface CompactDisc {
    /**
     * 播放指定磁道曲目
     * @param trackNumber  播放某一个磁道中的歌曲
     * */
    void playTrack(int trackNumber);
}
