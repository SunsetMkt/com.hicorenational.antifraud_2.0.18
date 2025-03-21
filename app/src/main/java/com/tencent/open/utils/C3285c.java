package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.c */
/* loaded from: classes2.dex */
public class C3285c {

    /* renamed from: c */
    private static String f11291c;

    /* renamed from: a */
    private String f11292a;

    /* renamed from: b */
    private InterfaceC3286d f11293b;

    /* renamed from: d */
    private long f11294d;

    /* renamed from: e */
    private Handler f11295e;

    /* renamed from: f */
    private WeakReference<Activity> f11296f;

    /* renamed from: g */
    private Runnable f11297g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            SLog.m10506v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + C3295m.m10704g(C3285c.this.f11292a) + ".jpg";
            String str2 = C3285c.f11291c + str;
            File file = new File(str2);
            Message obtainMessage = C3285c.this.f11295e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.m10506v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - C3285c.this.f11294d));
            } else {
                Bitmap m10585a = C3285c.m10585a(C3285c.this.f11292a);
                if (m10585a != null) {
                    z = C3285c.this.m10592a(m10585a, str);
                } else {
                    SLog.m10506v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.m10506v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - C3285c.this.f11294d));
            }
            C3285c.this.f11295e.sendMessage(obtainMessage);
        }
    };

    public C3285c(Activity activity) {
        this.f11296f = new WeakReference<>(activity);
        this.f11295e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.m10506v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    C3285c.this.f11293b.mo10333a(message.arg1, (String) message.obj);
                } else {
                    C3285c.this.f11293b.mo10333a(message.arg1, (String) null);
                }
            }
        };
    }

    /* renamed from: a */
    public void m10591a(String str, InterfaceC3286d interfaceC3286d) {
        SLog.m10506v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!C3295m.m10677a()) {
                interfaceC3286d.mo10333a(2, (String) null);
                return;
            }
            if (this.f11296f.get() != null) {
                Activity activity = this.f11296f.get();
                File m10707h = C3295m.m10707h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (m10707h == null) {
                    SLog.m10500e("AsynLoadImg", "externalImageFile is null");
                    interfaceC3286d.mo10333a(2, (String) null);
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C3293k.m10649d(activity) ? m10707h.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb.append("/tmp/");
                    f11291c = sb.toString();
                }
            }
            this.f11294d = System.currentTimeMillis();
            this.f11292a = str;
            this.f11293b = interfaceC3286d;
            new Thread(this.f11297g).start();
            return;
        }
        interfaceC3286d.mo10333a(1, (String) null);
    }

    /* renamed from: a */
    public boolean m10592a(Bitmap bitmap, String str) {
        String str2 = f11291c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.m10506v("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    SLog.m10501e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    /* renamed from: a */
    public static Bitmap m10585a(String str) {
        SLog.m10506v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.m10506v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            SLog.m10506v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            SLog.m10506v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
