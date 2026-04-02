package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: LogAdaptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4492b;
    private int a = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f4493c = new c();

    private void b() {
    }

    public void a(Context context, int i2, String str) {
        this.a = i2;
        this.f4492b = str;
        this.f4493c.a(context, "HMSCore");
    }

    public void b(int i2, String str, String str2, Throwable th) {
        try {
            if (a(i2)) {
                e eVarA = a(i2, str, str2, th);
                String str3 = eVarA.c() + eVarA.a();
                this.f4493c.a(str3, i2, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.f4493c;
    }

    public void a(d dVar) {
        this.f4493c = dVar;
    }

    public boolean a(int i2) {
        return i2 >= this.a;
    }

    public void a(int i2, String str, String str2) {
        try {
            if (a(i2)) {
                e eVarA = a(i2, str, str2, null);
                this.f4493c.a(eVarA.c() + eVarA.a(), i2, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e eVarA = a(4, str, str2, null);
            this.f4493c.a(eVarA.c() + '\n' + eVarA.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i2, String str, String str2, Throwable th) {
        e eVar = new e(8, this.f4492b, i2, str);
        eVar.a(str2);
        eVar.a(th);
        return eVar;
    }
}
