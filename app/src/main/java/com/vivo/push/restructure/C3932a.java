package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.C4020z;
import com.vivo.push.InterfaceC3922k;
import com.vivo.push.p233c.C3856a;
import com.vivo.push.restructure.p239a.p240a.C3937d;
import com.vivo.push.restructure.p241b.C3953d;
import com.vivo.push.restructure.p241b.C3955f;
import com.vivo.push.restructure.p241b.InterfaceC3950a;
import com.vivo.push.restructure.p241b.InterfaceC3951b;
import com.vivo.push.restructure.p242c.C3957b;
import com.vivo.push.restructure.p242c.InterfaceC3956a;
import com.vivo.push.util.C4015z;

/* compiled from: PushClientController.java */
/* renamed from: com.vivo.push.restructure.a */
/* loaded from: classes2.dex */
public final class C3932a {

    /* renamed from: a */
    private Context f14112a;

    /* renamed from: b */
    private InterfaceC3956a f14113b;

    /* renamed from: c */
    private C3937d f14114c;

    /* renamed from: d */
    private InterfaceC3950a f14115d;

    /* renamed from: e */
    private InterfaceC3951b f14116e;

    /* renamed from: f */
    private C3856a f14117f;

    /* renamed from: g */
    private InterfaceC3922k f14118g;

    /* compiled from: PushClientController.java */
    /* renamed from: com.vivo.push.restructure.a$a */
    private static class a {

        /* renamed from: a */
        static C3932a f14119a = new C3932a(0);
    }

    /* synthetic */ C3932a(byte b2) {
        this();
    }

    /* renamed from: a */
    public static C3932a m13069a() {
        return a.f14119a;
    }

    /* renamed from: b */
    public final synchronized Context m13071b() {
        return this.f14112a;
    }

    /* renamed from: c */
    public final InterfaceC3956a m13072c() {
        return this.f14113b;
    }

    /* renamed from: d */
    public final C3937d m13073d() {
        return this.f14114c;
    }

    /* renamed from: e */
    public final synchronized InterfaceC3950a m13074e() {
        return this.f14115d;
    }

    /* renamed from: f */
    public final InterfaceC3951b m13075f() {
        return this.f14116e;
    }

    /* renamed from: g */
    public final C3856a m13076g() {
        return this.f14117f;
    }

    /* renamed from: h */
    public final InterfaceC3922k m13077h() {
        return this.f14118g;
    }

    private C3932a() {
    }

    /* renamed from: a */
    public final synchronized void m13070a(Context context) {
        if (context == null) {
            return;
        }
        if (context != null) {
            this.f14112a = context;
        }
        this.f14115d = new C3953d(new C4015z(context));
        this.f14113b = new C3957b(this.f14115d);
        this.f14114c = new C3937d();
        this.f14116e = new C3955f();
        this.f14117f = new C3856a(context);
        this.f14118g = new C4020z(this.f14117f, m13074e());
    }
}
