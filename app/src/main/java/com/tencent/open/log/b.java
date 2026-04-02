package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import i.q2.t.m0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static SimpleDateFormat a = d.C0121d.a("yy.MM.dd.HH");

    /* JADX INFO: renamed from: g */
    private File f6878g;

    /* JADX INFO: renamed from: b */
    private String f6873b = "Tracer.File";

    /* JADX INFO: renamed from: c */
    private int f6874c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d */
    private int f6875d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e */
    private int f6876e = 4096;

    /* JADX INFO: renamed from: f */
    private long f6877f = com.heytap.mcssdk.constant.a.q;

    /* JADX INFO: renamed from: h */
    private int f6879h = 10;

    /* JADX INFO: renamed from: i */
    private String f6880i = ".log";

    /* JADX INFO: renamed from: j */
    private long f6881j = m0.f12222b;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        b(j2);
        d(i5);
        b(str2);
        c(j3);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File d(long j2) {
        String strC = c(a(j2));
        String strB = m.b();
        if (!TextUtils.isEmpty(strB) || strB != null) {
            try {
                File file = new File(strB, c.o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, strC);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return null;
    }

    public File a() {
        return d(System.currentTimeMillis());
    }

    public String b() {
        return this.f6873b;
    }

    public static String a(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void b(int i2) {
        this.f6875d = i2;
    }

    public int c() {
        return this.f6876e;
    }

    public void b(long j2) {
        this.f6877f = j2;
    }

    public void c(int i2) {
        this.f6876e = i2;
    }

    public void b(String str) {
        this.f6880i = str;
    }

    public void c(long j2) {
        this.f6881j = j2;
    }

    public void a(String str) {
        this.f6873b = str;
    }

    public void a(int i2) {
        this.f6874c = i2;
    }

    public void a(File file) {
        this.f6878g = file;
    }

    public int d() {
        return this.f6879h;
    }

    public void d(int i2) {
        this.f6879h = i2;
    }
}
