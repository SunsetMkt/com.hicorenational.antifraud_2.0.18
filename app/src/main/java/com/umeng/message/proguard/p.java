package com.umeng.message.proguard;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f8061c;

    static class a {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f8062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f8063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f8064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f8065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f8066f;

        public a(long j2, int i2, long j3, int i3, String str, String str2) {
            this.f8064d = i3;
            this.a = str;
            this.f8062b = str2;
            this.f8063c = j2;
            this.f8065e = i2;
            this.f8066f = j3;
        }
    }

    class c implements Handler.Callback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PrintWriter f8069c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final DateFormat f8071e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final File f8072f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f8073g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f8068b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DateFormat f8070d = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

        c() {
            this.f8070d.setTimeZone(TimeZone.getDefault());
            this.f8071e = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            this.f8071e.setTimeZone(TimeZone.getDefault());
            Application applicationA = x.a();
            this.f8072f = new File(applicationA.getFilesDir(), ".upush_log");
            this.f8073g = f.a(applicationA);
            int iLastIndexOf = this.f8073g.lastIndexOf(Constants.COLON_SEPARATOR);
            if (iLastIndexOf < 0) {
                this.f8073g = "";
                return;
            }
            this.f8073g = this.f8073g.substring(iLastIndexOf + 1) + d.c.a.b.a.a.s1;
        }

        private void a() {
            PrintWriter printWriter = this.f8069c;
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f8069c = null;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2;
            try {
                i2 = message.what;
            } catch (Throwable th) {
                UPLog.d("Log", UPLog.getStackTrace(th));
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    return true;
                }
                a();
                long jCurrentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
                if (Math.abs(jCurrentTimeMillis - this.f8068b) > 86400000) {
                    this.f8068b = jCurrentTimeMillis;
                    File[] fileArrListFiles = this.f8072f.listFiles();
                    if (fileArrListFiles != null) {
                        for (File file : fileArrListFiles) {
                            long jLastModified = file.lastModified() / 86400000;
                            Long.signum(jLastModified);
                            if (Math.abs(jCurrentTimeMillis - (jLastModified * 86400000)) > 86400000) {
                                file.delete();
                            }
                        }
                    }
                }
                return true;
            }
            try {
                if (!this.f8072f.exists()) {
                    this.f8072f.mkdirs();
                }
                a aVar = (a) message.obj;
                String str = String.format("%s%s", this.f8073g, this.f8070d.format(Long.valueOf(aVar.f8063c)));
                String str2 = String.format("%s %s-%s %s %s %s", this.f8071e.format(Long.valueOf(aVar.f8063c)), Integer.valueOf(aVar.f8065e), Long.valueOf(aVar.f8066f), aVar.f8064d == 3 ? "D" : aVar.f8064d == 4 ? "I" : aVar.f8064d == 5 ? ExifInterface.LONGITUDE_WEST : aVar.f8064d == 6 ? ExifInterface.LONGITUDE_EAST : "U", aVar.a, aVar.f8062b);
                File file2 = new File(this.f8072f, str + ".log");
                if (file2.exists() && file2.length() + ((long) str2.length()) > 5242880) {
                    File file3 = new File(this.f8072f, str + ".bak");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file2.renameTo(file3);
                    file2.delete();
                }
                if (!file2.exists()) {
                    a();
                }
                if (this.f8069c == null) {
                    this.f8069c = new PrintWriter(new FileWriter(file2, true));
                }
                this.f8069c.println(str2);
                this.f8069c.flush();
                p.this.b().removeMessages(2);
                p.this.b().sendEmptyMessageDelayed(2, com.heytap.mcssdk.constant.a.r);
            } catch (Throwable th2) {
                UPLog.d("Log", UPLog.getStackTrace(th2));
                a();
            }
            return true;
        }
    }

    private void b(int i2, String str, String str2) {
        Handler handlerB = b();
        if (handlerB != null) {
            handlerB.obtainMessage(1, new a(System.currentTimeMillis(), Process.myPid(), Thread.currentThread().getId(), i2, str, str2)).sendToTarget();
        }
    }

    public final boolean a() {
        if (!f.f8036b) {
            return false;
        }
        if (this.a == null) {
            this.a = Boolean.valueOf(MessageSharedPrefs.getInstance(x.a()).l());
        }
        return this.a.booleanValue();
    }

    public final void a(int i2, String str, String str2) {
        if (i2 >= 4 && str2 != null) {
            b(i2, str, str2);
        }
    }

    final Handler b() {
        Handler handler;
        Handler handler2 = this.f8061c;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (this) {
            if (this.f8061c == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("upush_log", 10);
                    handlerThread.start();
                    this.f8061c = new Handler(handlerThread.getLooper(), new c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                handler = this.f8061c;
            } else {
                handler = this.f8061c;
            }
        }
        return handler;
    }

    public static class b {
        static JSONObject a(String str, String str2, String str3) {
            String zid;
            try {
                Application applicationA = x.a();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("appkey", str);
                jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, str2);
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, str3);
                jSONObject.put("utdid", d.o(applicationA));
                jSONObject.put("umid", d.k(applicationA));
                try {
                    zid = UMUtils.getZid(applicationA);
                    try {
                        jSONObject.put("oaid", DeviceConfig.getOaid(applicationA));
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    zid = null;
                }
                jSONObject.put(bh.al, zid);
                jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                return g.a(jSONObject, "https://offmsg.umeng.com/log/switch", str, true);
            } catch (Throwable th) {
                UPLog.d("Log", UPLog.getStackTrace(th));
                return null;
            }
        }

        final void a(File file, File file2) {
            File[] fileArrListFiles;
            ZipOutputStream zipOutputStream;
            if (!file.exists() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.umeng.message.proguard.p.b.2
                @Override // java.io.FileFilter
                public final boolean accept(File file3) {
                    if (file3.isDirectory() || file3.length() > 5242880) {
                        return false;
                    }
                    String name = file3.getName();
                    return name.endsWith(".log") || name.endsWith(".bak");
                }
            })) == null || fileArrListFiles.length == 0) {
                return;
            }
            if (fileArrListFiles.length > 8) {
                File[] fileArr = new File[8];
                System.arraycopy(fileArrListFiles, 0, fileArr, 0, 8);
                fileArrListFiles = fileArr;
            }
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
                zipOutputStream = null;
            }
            try {
                for (File file3 : fileArrListFiles) {
                    a(file3, zipOutputStream);
                    file3.delete();
                }
                zipOutputStream.finish();
            } catch (Throwable th2) {
                th = th2;
                try {
                    UPLog.d("Log", UPLog.getStackTrace(th));
                } finally {
                    f.a(zipOutputStream);
                }
            }
        }

        private static void a(File file, ZipOutputStream zipOutputStream) {
            FileInputStream fileInputStream;
            if (!file.exists() || file.length() < 256) {
                return;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 != -1) {
                        zipOutputStream.write(bArr, 0, i2);
                    } else {
                        zipOutputStream.closeEntry();
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    UPLog.d("Log", UPLog.getStackTrace(th));
                } finally {
                    f.a(fileInputStream);
                }
            }
        }
    }
}
