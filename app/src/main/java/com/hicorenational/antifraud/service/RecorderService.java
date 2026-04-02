package com.hicorenational.antifraud.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import util.j1;

/* JADX INFO: loaded from: classes.dex */
public class RecorderService extends Service {
    private MediaRecorder a;

    class a extends PhoneStateListener {
        a() {
        }

        private void a() {
            File file = new File(j1.b() + "/recorder");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }

        private String b() {
            return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            if (i2 == 0) {
                if (RecorderService.this.a != null) {
                    RecorderService.this.a.stop();
                    RecorderService.this.a.release();
                    RecorderService.this.a = null;
                    return;
                }
                return;
            }
            if (i2 != 1) {
                if (i2 == 2 && RecorderService.this.a != null) {
                    RecorderService.this.a.start();
                    return;
                }
                return;
            }
            if (RecorderService.this.a == null) {
                RecorderService.this.a = new MediaRecorder();
                RecorderService.this.a.setAudioSource(1);
                RecorderService.this.a.setOutputFormat(1);
                a();
                RecorderService.this.a.setOutputFile("sdcard/recorder/" + b() + ".3gp");
                RecorderService.this.a.setAudioEncoder(1);
                try {
                    RecorderService.this.a.prepare();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ((TelephonyManager) getSystemService("phone")).listen(new a(), 32);
    }
}
