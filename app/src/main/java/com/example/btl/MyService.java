package com.example.btl;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mymusic;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //khởi tạo các đối tượng thiết lập caác đối tượng mà service quản lý
    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this,R.raw.mymusic);
    //để bài hát lặp đi laặp lại        
        mymusic.setLooping(true); 
    }
    //Hàm khởi động đối tượng Service quản lý

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       if(mymusic.isPlaying())
           mymusic.pause();
       else
           mymusic.start();
        return super.onStartCommand(intent, flags, startId);
    }
    //  Hàm để dừng đối tượng Service quản lý

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();

    }

}

