package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.C4010u;

/* compiled from: PushCommand.java */
/* renamed from: com.vivo.push.v */
/* loaded from: classes2.dex */
public abstract class AbstractC4016v {

    /* renamed from: a */
    private int f14283a;

    /* renamed from: b */
    private String f14284b;

    public AbstractC4016v(int i2) {
        this.f14283a = -1;
        if (i2 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f14283a = i2;
    }

    /* renamed from: e */
    private void m13320e(C3862d c3862d) {
        c3862d.m12914a("command", this.f14283a);
        c3862d.m12917a("client_pkgname", this.f14284b);
        mo12833c(c3862d);
    }

    /* renamed from: a */
    public final String m13321a() {
        return this.f14284b;
    }

    /* renamed from: b */
    public final int m13325b() {
        return this.f14283a;
    }

    /* renamed from: c */
    protected abstract void mo12833c(C3862d c3862d);

    /* renamed from: c */
    public boolean mo12884c() {
        return false;
    }

    /* renamed from: d */
    protected abstract void mo12834d(C3862d c3862d);

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: a */
    public final void m13324a(String str) {
        this.f14284b = str;
    }

    /* renamed from: b */
    public final void m13326b(Intent intent) {
        C3862d m12911a = C3862d.m12911a(intent);
        if (m12911a == null) {
            C4010u.m13301b("PushCommand", "bundleWapper is null");
            return;
        }
        m12911a.m12914a("method", this.f14283a);
        m13320e(m12911a);
        Bundle m12923b = m12911a.m12923b();
        if (m12923b != null) {
            intent.putExtras(m12923b);
        }
    }

    /* renamed from: a */
    public final void m13322a(Intent intent) {
        C3862d m12911a = C3862d.m12911a(intent);
        if (m12911a == null) {
            C4010u.m13301b("PushCommand", "bundleWapper is null");
            return;
        }
        m13323a(m12911a);
        Bundle m12923b = m12911a.m12923b();
        if (m12923b != null) {
            intent.putExtras(m12923b);
        }
    }

    /* renamed from: a */
    public final void m13323a(C3862d c3862d) {
        String m13328a = C4018x.m13328a(this.f14283a);
        if (m13328a == null) {
            m13328a = "";
        }
        c3862d.m12917a("method", m13328a);
        m13320e(c3862d);
    }

    /* renamed from: b */
    public final void m13327b(C3862d c3862d) {
        String m12912a = c3862d.m12912a();
        if (!TextUtils.isEmpty(m12912a)) {
            this.f14284b = m12912a;
        } else {
            this.f14284b = c3862d.m12913a("client_pkgname");
        }
        mo12834d(c3862d);
    }
}
