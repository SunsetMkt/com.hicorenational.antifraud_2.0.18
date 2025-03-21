package com.tencent.open.log;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.open.log.C3277d;
import com.tencent.open.utils.C3295m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.b */
/* loaded from: classes2.dex */
public class C3275b {

    /* renamed from: a */
    private static SimpleDateFormat f11245a = C3277d.d.m10559a("yy.MM.dd.HH");

    /* renamed from: g */
    private File f11251g;

    /* renamed from: b */
    private String f11246b = "Tracer.File";

    /* renamed from: c */
    private int f11247c = Integer.MAX_VALUE;

    /* renamed from: d */
    private int f11248d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f11249e = 4096;

    /* renamed from: f */
    private long f11250f = C2084a.f6135q;

    /* renamed from: h */
    private int f11252h = 10;

    /* renamed from: i */
    private String f11253i = ".log";

    /* renamed from: j */
    private long f11254j = C5556m0.f20396b;

    public C3275b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        m10535a(file);
        m10538b(i2);
        m10534a(i3);
        m10542c(i4);
        m10536a(str);
        m10539b(j2);
        m10545d(i5);
        m10540b(str2);
        m10543c(j3);
    }

    /* renamed from: c */
    private String m10531c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    /* renamed from: d */
    private File m10532d(long j2) {
        String m10531c = m10531c(m10530a(j2));
        String m10685b = C3295m.m10685b();
        if (!TextUtils.isEmpty(m10685b) || m10685b != null) {
            try {
                File file = new File(m10685b, C3276c.f11269o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, m10531c);
            } catch (Exception e2) {
                SLog.m10501e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public File m10533a() {
        return m10532d(System.currentTimeMillis());
    }

    /* renamed from: b */
    public String m10537b() {
        return this.f11246b;
    }

    /* renamed from: a */
    public static String m10530a(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    /* renamed from: b */
    public void m10538b(int i2) {
        this.f11248d = i2;
    }

    /* renamed from: c */
    public int m10541c() {
        return this.f11249e;
    }

    /* renamed from: b */
    public void m10539b(long j2) {
        this.f11250f = j2;
    }

    /* renamed from: c */
    public void m10542c(int i2) {
        this.f11249e = i2;
    }

    /* renamed from: b */
    public void m10540b(String str) {
        this.f11253i = str;
    }

    /* renamed from: c */
    public void m10543c(long j2) {
        this.f11254j = j2;
    }

    /* renamed from: a */
    public void m10536a(String str) {
        this.f11246b = str;
    }

    /* renamed from: a */
    public void m10534a(int i2) {
        this.f11247c = i2;
    }

    /* renamed from: a */
    public void m10535a(File file) {
        this.f11251g = file;
    }

    /* renamed from: d */
    public int m10544d() {
        return this.f11252h;
    }

    /* renamed from: d */
    public void m10545d(int i2) {
        this.f11252h = i2;
    }
}
