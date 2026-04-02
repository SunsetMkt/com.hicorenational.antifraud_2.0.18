package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.aa;

/* JADX INFO: compiled from: BaseAppCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends com.vivo.push.v {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8450h;

    public c(int i2, String str) {
        super(i2);
        this.f8445c = -1L;
        this.f8446d = -1;
        this.a = null;
        this.f8444b = str;
    }

    public final int a(Context context) {
        if (this.f8446d == -1) {
            String str = this.f8444b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.u.a("BaseAppCommand", "pkg name is null");
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    com.vivo.push.util.u.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = strA;
            }
            this.f8446d = aa.b(context, str);
            if (!TextUtils.isEmpty(this.f8448f)) {
                this.f8446d = 2;
            }
        }
        return this.f8446d;
    }

    public final void b(int i2) {
        this.f8447e = i2;
    }

    public final void c(String str) {
        this.f8450h = str;
    }

    public final int d() {
        return this.f8447e;
    }

    public final void e() {
        this.f8448f = null;
    }

    public final String f() {
        return this.a;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.a = str;
    }

    @Override // com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.a);
        dVar.a("package_name", this.f8444b);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_APP_STATUS", this.f8446d);
        if (!TextUtils.isEmpty(this.f8448f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f8448f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.f8450h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.f8449g);
    }

    public final void d(String str) {
        this.f8449g = str;
    }

    @Override // com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        this.a = dVar.a("req_id");
        this.f8444b = dVar.a("package_name");
        this.f8445c = dVar.b("sdk_version", 0L);
        this.f8446d = dVar.b("PUSH_APP_STATUS", 0);
        this.f8448f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f8450h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.f8449g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
