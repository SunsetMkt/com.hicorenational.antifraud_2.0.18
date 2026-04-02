package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: LogRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4496d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4502j;
    private final StringBuilder a = new StringBuilder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4497e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4498f = 0;

    e(int i2, String str, int i3, String str2) {
        this.f4495c = "HMS";
        this.f4502j = i2;
        this.f4494b = str;
        this.f4496d = i3;
        if (str2 != null) {
            this.f4495c = str2;
        }
        b();
    }

    public static String a(int i2) {
        return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D";
    }

    private e b() {
        this.f4497e = System.currentTimeMillis();
        Thread threadCurrentThread = Thread.currentThread();
        this.f4498f = threadCurrentThread.getId();
        this.f4500h = Process.myPid();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.f4502j;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.f4499g = stackTraceElement.getFileName();
            this.f4501i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> e a(T t) {
        this.a.append(t);
        return this;
    }

    public e a(Throwable th) {
        a('\n').a(Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    private StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    private StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f4497e)));
        String strA = a(this.f4496d);
        sb.append(' ');
        sb.append(strA);
        sb.append('/');
        sb.append(this.f4495c);
        sb.append('/');
        sb.append(this.f4494b);
        sb.append(' ');
        sb.append(this.f4500h);
        sb.append(':');
        sb.append(this.f4498f);
        sb.append(' ');
        sb.append(this.f4499g);
        sb.append(':');
        sb.append(this.f4501i);
        sb.append(']');
        return sb;
    }
}
