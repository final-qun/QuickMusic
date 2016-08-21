package com.quicksand.quickmusic.MusicView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import com.quicksand.quickmusic.MusicUtil.MusicConstant;

/**
 * Created by quicksand on 2016 year 08.
 */
public class MusicUpdateReceiver extends BroadcastReceiver {
    private int state = MusicConstant.MUSIC_START;
    private MediaPlayer mPlayer;
    public MusicUpdateReceiver(){
        mPlayer = new MediaPlayer();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int command = intent.getIntExtra("cmd",-1);
        switch (command) {
            case MusicConstant.MUSIC_PLAYMODE:
                // TODO: 16/8/21  
                break;
            case MusicConstant.MUSIC_START:
                // TODO: 16/8/21  
                break;
            case MusicConstant.MUSIC_PLAY:
                String path = intent.getStringExtra("path");
                if(path != null) { //播放当前歌曲
                    musicPlay(path);
                } else { //播放新歌曲
                    musicNewPlay();
                }
                state = MusicConstant.MUSIC_PLAY;
                break;
            case MusicConstant.MUSIC_PAUSE:
                if(state == MusicConstant.MUSIC_PLAY) {
                    state = MusicConstant.MUSIC_PAUSE;
                    mPlayer.pause();
                }
                break;
            case MusicConstant.MUSIC_STOP:
                state = MusicConstant.MUSIC_STOP;
                release();
                break;
        }
    }
    public void release() {
        if(mPlayer != null) {
            mPlayer.release();
        }
    }
    public void updateUI(Context context) {

    }
    private void musicPlay(String path) {

    }
    private void musicNewPlay() {

    }
}
