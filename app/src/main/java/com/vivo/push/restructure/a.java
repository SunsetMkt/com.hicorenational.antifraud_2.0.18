package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* JADX INFO: compiled from: PushClientController.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private Context a;

    /* JADX INFO: renamed from: b */
    private com.vivo.push.restructure.c.a f8578b;

    /* JADX INFO: renamed from: c */
    private d f8579c;

    /* JADX INFO: renamed from: d */
    private com.vivo.push.restructure.b.a f8580d;

    /* JADX INFO: renamed from: e */
    private b f8581e;

    /* JADX INFO: renamed from: f */
    private com.vivo.push.c.a f8582f;

    /* JADX INFO: renamed from: g */
    private k f8583g;

    /* JADX INFO: renamed from: com.vivo.push.restructure.a$a */
    /* JADX INFO: compiled from: PushClientController.java */
    private static class C0150a {
        static a a = new a((byte) 0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0150a.a;
    }

    public final synchronized Context b() {
        return this.a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f8578b;
    }

    public final d d() {
        return this.f8579c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.f8580d;
    }

    public final b f() {
        return this.f8581e;
    }

    public final com.vivo.push.c.a g() {
        return this.f8582f;
    }

    public final k h() {
        return this.f8583g;
    }

    private a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        if (context == null) {
            this.f8580d = new com.vivo.push.restructure.b.d(new z(context));
            this.f8578b = new com.vivo.push.restructure.c.b(this.f8580d);
            this.f8579c = new d();
            this.f8581e = new f();
            this.f8582f = new com.vivo.push.c.a(context);
            this.f8583g = new com.vivo.push.z(this.f8582f, e());
            return;
        }
        this.a = context;
        this.f8580d = new com.vivo.push.restructure.b.d(new z(context));
        this.f8578b = new com.vivo.push.restructure.c.b(this.f8580d);
        this.f8579c = new d();
        this.f8581e = new f();
        this.f8582f = new com.vivo.push.c.a(context);
        this.f8583g = new com.vivo.push.z(this.f8582f, e());
        return;
    }
}
