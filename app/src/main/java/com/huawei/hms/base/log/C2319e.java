package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord.java */
/* renamed from: com.huawei.hms.base.log.e */
/* loaded from: classes.dex */
public class C2319e {

    /* renamed from: b */
    private String f7181b;

    /* renamed from: c */
    private String f7182c;

    /* renamed from: d */
    private int f7183d;

    /* renamed from: g */
    private String f7186g;

    /* renamed from: h */
    private int f7187h;

    /* renamed from: i */
    private int f7188i;

    /* renamed from: j */
    private int f7189j;

    /* renamed from: a */
    private final StringBuilder f7180a = new StringBuilder();

    /* renamed from: e */
    private long f7184e = 0;

    /* renamed from: f */
    private long f7185f = 0;

    C2319e(int i2, String str, int i3, String str2) {
        this.f7182c = "HMS";
        this.f7189j = i2;
        this.f7181b = str;
        this.f7183d = i3;
        if (str2 != null) {
            this.f7182c = str2;
        }
        m6675b();
    }

    /* renamed from: a */
    public static String m6673a(int i2) {
        return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D";
    }

    /* renamed from: b */
    private C2319e m6675b() {
        this.f7184e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f7185f = currentThread.getId();
        this.f7187h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.f7189j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.f7186g = stackTraceElement.getFileName();
            this.f7188i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    /* renamed from: c */
    public String m6680c() {
        StringBuilder sb = new StringBuilder();
        m6676b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m6676b(sb);
        m6674a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    public <T> C2319e m6677a(T t) {
        this.f7180a.append(t);
        return this;
    }

    /* renamed from: a */
    public C2319e m6678a(Throwable th) {
        m6677a((C2319e) '\n').m6677a((C2319e) Log.getStackTraceString(th));
        return this;
    }

    /* renamed from: a */
    public String m6679a() {
        StringBuilder sb = new StringBuilder();
        m6674a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    private StringBuilder m6674a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.f7180a.toString());
        return sb;
    }

    /* renamed from: b */
    private StringBuilder m6676b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f7184e)));
        String m6673a = m6673a(this.f7183d);
        sb.append(' ');
        sb.append(m6673a);
        sb.append('/');
        sb.append(this.f7182c);
        sb.append('/');
        sb.append(this.f7181b);
        sb.append(' ');
        sb.append(this.f7187h);
        sb.append(':');
        sb.append(this.f7185f);
        sb.append(' ');
        sb.append(this.f7186g);
        sb.append(':');
        sb.append(this.f7188i);
        sb.append(']');
        return sb;
    }
}
