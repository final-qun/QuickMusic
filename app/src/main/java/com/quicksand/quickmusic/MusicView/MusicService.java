package com.quicksand.quickmusic.MusicView;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.quicksand.quickmusic.MusicUtil.MusicConstant;
/**
 * Created by quicksand on 2016 year 08.
 */
public class MusicService extends Service {
    private MusicUpdateReceiver mMusicUpdate;
    @Override
    public void onCreate() {
        super.onCreate();
        mMusicUpdate = new MusicUpdateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MusicConstant.MUSIC_CONTROL);
        this.registerReceiver(mMusicUpdate,filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMusicUpdate.updateUI(this.getApplicationContext());
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMusicUpdate.release();
        this.unregisterReceiver(mMusicUpdate);
    }
}
