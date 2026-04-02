package com.tencent.bugly.beta.utils;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    a a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6134d;

    public d(String str, long j2, long j3) {
        this.f6132b = null;
        this.f6133c = 0L;
        this.f6134d = 0L;
        this.f6132b = str;
        this.f6133c = j2;
        this.f6134d = j3;
    }

    private boolean b() {
        return (this.f6133c == 0 || this.f6134d == 0) ? false : true;
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.a == null) {
            try {
                this.a = new a(this.f6132b);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public synchronized void a() {
        if (this.a == null) {
            return;
        }
        this.a.a();
        this.a = null;
    }

    private synchronized String b(long j2) {
        if (this.a == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.a.b(this.f6133c);
            this.a.b(j2);
        } catch (Exception e2) {
            this.a = null;
            e2.printStackTrace();
        }
        while (true) {
            byte b2 = this.a.b();
            if (b2 == 0) {
                break;
            }
            stringBuffer.append((char) b2);
            return stringBuffer.toString();
        }
        this.a.a();
        this.a = new a(this.f6132b);
        return stringBuffer.toString();
    }

    public synchronized String a(long j2) {
        if (j2 >= 0) {
            if (j2 < this.f6134d) {
                if (this.a == null && !c()) {
                    return null;
                }
                return b(j2);
            }
        }
        return null;
    }
}
