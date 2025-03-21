package com.umeng.message.proguard;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.umeng.message.proguard.p */
/* loaded from: classes2.dex */
public final class C3596p {

    /* renamed from: a */
    Boolean f13313a;

    /* renamed from: b */
    public boolean f13314b;

    /* renamed from: c */
    private Handler f13315c;

    /* renamed from: com.umeng.message.proguard.p$a */
    static class a {

        /* renamed from: a */
        final String f13316a;

        /* renamed from: b */
        final String f13317b;

        /* renamed from: c */
        final long f13318c;

        /* renamed from: d */
        final int f13319d;

        /* renamed from: e */
        final int f13320e;

        /* renamed from: f */
        final long f13321f;

        public a(long j2, int i2, long j3, int i3, String str, String str2) {
            this.f13319d = i3;
            this.f13316a = str;
            this.f13317b = str2;
            this.f13318c = j2;
            this.f13320e = i2;
            this.f13321f = j3;
        }
    }

    /* renamed from: com.umeng.message.proguard.p$c */
    class c implements Handler.Callback {

        /* renamed from: c */
        private PrintWriter f13328c;

        /* renamed from: e */
        private final DateFormat f13330e;

        /* renamed from: f */
        private final File f13331f;

        /* renamed from: g */
        private String f13332g;

        /* renamed from: b */
        private long f13327b = 0;

        /* renamed from: d */
        private final DateFormat f13329d = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

        c() {
            this.f13329d.setTimeZone(TimeZone.getDefault());
            this.f13330e = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            this.f13330e.setTimeZone(TimeZone.getDefault());
            Application m12460a = C3604x.m12460a();
            this.f13331f = new File(m12460a.getFilesDir(), ".upush_log");
            this.f13332g = C3586f.m12381a(m12460a);
            int lastIndexOf = this.f13332g.lastIndexOf(Constants.COLON_SEPARATOR);
            if (lastIndexOf < 0) {
                this.f13332g = "";
                return;
            }
            this.f13332g = this.f13332g.substring(lastIndexOf + 1) + AbstractC1191a.f2606s1;
        }

        /* renamed from: a */
        private void m12429a() {
            PrintWriter printWriter = this.f13328c;
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f13328c = null;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2;
            try {
                i2 = message.what;
            } catch (Throwable th) {
                UPLog.m12142d("Log", UPLog.getStackTrace(th));
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    return true;
                }
                m12429a();
                long currentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
                if (Math.abs(currentTimeMillis - this.f13327b) > 86400000) {
                    this.f13327b = currentTimeMillis;
                    File[] listFiles = this.f13331f.listFiles();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            long lastModified = file.lastModified() / 86400000;
                            Long.signum(lastModified);
                            if (Math.abs(currentTimeMillis - (lastModified * 86400000)) > 86400000) {
                                file.delete();
                            }
                        }
                    }
                }
                return true;
            }
            try {
                if (!this.f13331f.exists()) {
                    this.f13331f.mkdirs();
                }
                a aVar = (a) message.obj;
                String format = String.format("%s%s", this.f13332g, this.f13329d.format(Long.valueOf(aVar.f13318c)));
                String format2 = String.format("%s %s-%s %s %s %s", this.f13330e.format(Long.valueOf(aVar.f13318c)), Integer.valueOf(aVar.f13320e), Long.valueOf(aVar.f13321f), aVar.f13319d == 3 ? "D" : aVar.f13319d == 4 ? "I" : aVar.f13319d == 5 ? ExifInterface.LONGITUDE_WEST : aVar.f13319d == 6 ? ExifInterface.LONGITUDE_EAST : "U", aVar.f13316a, aVar.f13317b);
                File file2 = new File(this.f13331f, format + ".log");
                if (file2.exists() && file2.length() + format2.length() > 5242880) {
                    File file3 = new File(this.f13331f, format + ".bak");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file2.renameTo(file3);
                    file2.delete();
                }
                if (!file2.exists()) {
                    m12429a();
                }
                if (this.f13328c == null) {
                    this.f13328c = new PrintWriter(new FileWriter(file2, true));
                }
                this.f13328c.println(format2);
                this.f13328c.flush();
                C3596p.this.m12425b().removeMessages(2);
                C3596p.this.m12425b().sendEmptyMessageDelayed(2, C2084a.f6136r);
            } catch (Throwable th2) {
                UPLog.m12142d("Log", UPLog.getStackTrace(th2));
                m12429a();
            }
            return true;
        }
    }

    /* renamed from: b */
    private void m12422b(int i2, String str, String str2) {
        Handler m12425b = m12425b();
        if (m12425b != null) {
            m12425b.obtainMessage(1, new a(System.currentTimeMillis(), Process.myPid(), Thread.currentThread().getId(), i2, str, str2)).sendToTarget();
        }
    }

    /* renamed from: a */
    public final boolean m12424a() {
        if (!C3586f.f13277b) {
            return false;
        }
        if (this.f13313a == null) {
            this.f13313a = Boolean.valueOf(MessageSharedPrefs.getInstance(C3604x.m12460a()).m12132l());
        }
        return this.f13313a.booleanValue();
    }

    /* renamed from: a */
    public final void m12423a(int i2, String str, String str2) {
        if (i2 >= 4 && str2 != null) {
            m12422b(i2, str, str2);
        }
    }

    /* renamed from: b */
    final Handler m12425b() {
        Handler handler;
        Handler handler2 = this.f13315c;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (this) {
            if (this.f13315c == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("upush_log", 10);
                    handlerThread.start();
                    this.f13315c = new Handler(handlerThread.getLooper(), new c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            handler = this.f13315c;
        }
        return handler;
    }

    /* renamed from: com.umeng.message.proguard.p$b */
    public static class b {
        /* renamed from: a */
        static JSONObject m12426a(String str, String str2, String str3) {
            String str4;
            try {
                Application m12460a = C3604x.m12460a();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("appkey", str);
                jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, str2);
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, str3);
                jSONObject.put("utdid", C3584d.m12371o(m12460a));
                jSONObject.put("umid", C3584d.m12367k(m12460a));
                try {
                    str4 = UMUtils.getZid(m12460a);
                    try {
                        jSONObject.put("oaid", DeviceConfig.getOaid(m12460a));
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str4 = null;
                }
                jSONObject.put(C3351bh.f11613al, str4);
                jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                return C3587g.m12400a(jSONObject, "https://offmsg.umeng.com/log/switch", str, true);
            } catch (Throwable th) {
                UPLog.m12142d("Log", UPLog.getStackTrace(th));
                return null;
            }
        }

        /* renamed from: a */
        final void m12428a(File file, File file2) {
            File[] listFiles;
            ZipOutputStream zipOutputStream;
            if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.umeng.message.proguard.p.b.2
                @Override // java.io.FileFilter
                public final boolean accept(File file3) {
                    if (file3.isDirectory() || file3.length() > 5242880) {
                        return false;
                    }
                    String name = file3.getName();
                    return name.endsWith(".log") || name.endsWith(".bak");
                }
            })) == null || listFiles.length == 0) {
                return;
            }
            if (listFiles.length > 8) {
                File[] fileArr = new File[8];
                System.arraycopy(listFiles, 0, fileArr, 0, 8);
                listFiles = fileArr;
            }
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
                zipOutputStream = null;
            }
            try {
                for (File file3 : listFiles) {
                    m12427a(file3, zipOutputStream);
                    file3.delete();
                }
                zipOutputStream.finish();
            } catch (Throwable th2) {
                th = th2;
                try {
                    UPLog.m12142d("Log", UPLog.getStackTrace(th));
                } finally {
                    C3586f.m12386a(zipOutputStream);
                }
            }
        }

        /* renamed from: a */
        private static void m12427a(File file, ZipOutputStream zipOutputStream) {
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
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    UPLog.m12142d("Log", UPLog.getStackTrace(th));
                } finally {
                    C3586f.m12386a(fileInputStream);
                }
            }
        }
    }
}
