package com.tencent.bugly.beta.utils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.d */
/* loaded from: classes2.dex */
public class C3104d {

    /* renamed from: a */
    C3101a f10071a = null;

    /* renamed from: b */
    private String f10072b;

    /* renamed from: c */
    private long f10073c;

    /* renamed from: d */
    private long f10074d;

    public C3104d(String str, long j2, long j3) {
        this.f10072b = null;
        this.f10073c = 0L;
        this.f10074d = 0L;
        this.f10072b = str;
        this.f10073c = j2;
        this.f10074d = j3;
    }

    /* renamed from: b */
    private boolean m9456b() {
        return (this.f10073c == 0 || this.f10074d == 0) ? false : true;
    }

    /* renamed from: c */
    private synchronized boolean m9457c() {
        if (!m9456b()) {
            return false;
        }
        if (this.f10071a == null) {
            try {
                this.f10071a = new C3101a(this.f10072b);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public synchronized void m9459a() {
        if (this.f10071a == null) {
            return;
        }
        this.f10071a.m9394a();
        this.f10071a = null;
    }

    /* renamed from: b */
    private synchronized String m9455b(long j2) {
        if (this.f10071a == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f10071a.m9397b(this.f10073c);
            this.f10071a.m9397b(j2);
            while (true) {
                byte m9396b = this.f10071a.m9396b();
                if (m9396b == 0) {
                    break;
                }
                stringBuffer.append((char) m9396b);
            }
            this.f10071a.m9394a();
            this.f10071a = new C3101a(this.f10072b);
        } catch (Exception e2) {
            this.f10071a = null;
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public synchronized String m9458a(long j2) {
        if (j2 >= 0) {
            if (j2 < this.f10074d) {
                if (this.f10071a == null && !m9457c()) {
                    return null;
                }
                return m9455b(j2);
            }
        }
        return null;
    }
}
