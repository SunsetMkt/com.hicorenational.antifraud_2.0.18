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
import util.C7277f1;

/* loaded from: classes.dex */
public class RecorderService extends Service {

    /* renamed from: a */
    private MediaRecorder f6335a;

    /* renamed from: com.hicorenational.antifraud.service.RecorderService$a */
    class C2119a extends PhoneStateListener {
        C2119a() {
        }

        /* renamed from: a */
        private void m5959a() {
            File file = new File(C7277f1.m26357b() + "/recorder");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }

        /* renamed from: b */
        private String m5960b() {
            return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            if (i2 == 0) {
                if (RecorderService.this.f6335a != null) {
                    RecorderService.this.f6335a.stop();
                    RecorderService.this.f6335a.release();
                    RecorderService.this.f6335a = null;
                    return;
                }
                return;
            }
            if (i2 != 1) {
                if (i2 == 2 && RecorderService.this.f6335a != null) {
                    RecorderService.this.f6335a.start();
                    return;
                }
                return;
            }
            if (RecorderService.this.f6335a == null) {
                RecorderService.this.f6335a = new MediaRecorder();
                RecorderService.this.f6335a.setAudioSource(1);
                RecorderService.this.f6335a.setOutputFormat(1);
                m5959a();
                RecorderService.this.f6335a.setOutputFile("sdcard/recorder/" + m5960b() + ".3gp");
                RecorderService.this.f6335a.setAudioEncoder(1);
                try {
                    RecorderService.this.f6335a.prepare();
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
        ((TelephonyManager) getSystemService("phone")).listen(new C2119a(), 32);
    }
}
