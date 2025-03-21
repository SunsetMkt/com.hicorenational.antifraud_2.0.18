package com.vivo.push.p232b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C4010u;

/* compiled from: BaseAppCommand.java */
/* renamed from: com.vivo.push.b.c */
/* loaded from: classes2.dex */
public class C3831c extends AbstractC4016v {

    /* renamed from: a */
    private String f13911a;

    /* renamed from: b */
    private String f13912b;

    /* renamed from: c */
    private long f13913c;

    /* renamed from: d */
    private int f13914d;

    /* renamed from: e */
    private int f13915e;

    /* renamed from: f */
    private String f13916f;

    /* renamed from: g */
    private String f13917g;

    /* renamed from: h */
    private String f13918h;

    public C3831c(int i2, String str) {
        super(i2);
        this.f13913c = -1L;
        this.f13914d = -1;
        this.f13911a = null;
        this.f13912b = str;
    }

    /* renamed from: a */
    public final int m12836a(Context context) {
        if (this.f13914d == -1) {
            String str = this.f13912b;
            if (TextUtils.isEmpty(str)) {
                C4010u.m13292a("BaseAppCommand", "pkg name is null");
                String m13321a = m13321a();
                if (TextUtils.isEmpty(m13321a)) {
                    C4010u.m13292a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = m13321a;
            }
            this.f13914d = C3984aa.m13184b(context, str);
            if (!TextUtils.isEmpty(this.f13916f)) {
                this.f13914d = 2;
            }
        }
        return this.f13914d;
    }

    /* renamed from: b */
    public final void m12837b(int i2) {
        this.f13915e = i2;
    }

    /* renamed from: c */
    public final void m12839c(String str) {
        this.f13918h = str;
    }

    /* renamed from: d */
    public final int m12840d() {
        return this.f13915e;
    }

    /* renamed from: e */
    public final void m12842e() {
        this.f13916f = null;
    }

    /* renamed from: f */
    public final String m12843f() {
        return this.f13911a;
    }

    @Override // com.vivo.push.AbstractC4016v
    public String toString() {
        return "BaseAppCommand";
    }

    /* renamed from: b */
    public final void m12838b(String str) {
        this.f13911a = str;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected void mo12833c(C3862d c3862d) {
        c3862d.m12917a("req_id", this.f13911a);
        c3862d.m12917a("package_name", this.f13912b);
        c3862d.m12915a("sdk_version", 341L);
        c3862d.m12914a("PUSH_APP_STATUS", this.f13914d);
        if (!TextUtils.isEmpty(this.f13916f)) {
            c3862d.m12917a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f13916f);
        }
        c3862d.m12917a("BaseAppCommand.EXTRA_APPID", this.f13918h);
        c3862d.m12917a("BaseAppCommand.EXTRA_APPKEY", this.f13917g);
    }

    /* renamed from: d */
    public final void m12841d(String str) {
        this.f13917g = str;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected void mo12834d(C3862d c3862d) {
        this.f13911a = c3862d.m12913a("req_id");
        this.f13912b = c3862d.m12913a("package_name");
        this.f13913c = c3862d.m12922b("sdk_version", 0L);
        this.f13914d = c3862d.m12921b("PUSH_APP_STATUS", 0);
        this.f13916f = c3862d.m12913a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f13918h = c3862d.m12913a("BaseAppCommand.EXTRA_APPID");
        this.f13917g = c3862d.m12913a("BaseAppCommand.EXTRA_APPKEY");
    }
}
