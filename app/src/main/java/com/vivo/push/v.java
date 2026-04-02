package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: PushCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v {
    private int a;

    /* JADX INFO: renamed from: b */
    private String f8696b;

    public v(int i2) {
        this.a = -1;
        if (i2 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.a = i2;
    }

    private void e(d dVar) {
        dVar.a("command", this.a);
        dVar.a("client_pkgname", this.f8696b);
        c(dVar);
    }

    public final String a() {
        return this.f8696b;
    }

    public final int b() {
        return this.a;
    }

    protected abstract void c(d dVar);

    public boolean c() {
        return false;
    }

    protected abstract void d(d dVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f8696b = str;
    }

    public final void b(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        dVarA.a("method", this.a);
        e(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(d dVar) {
        String strA = x.a(this.a);
        if (strA == null) {
            strA = "";
        }
        dVar.a("method", strA);
        e(dVar);
    }

    public final void b(d dVar) {
        String strA = dVar.a();
        if (!TextUtils.isEmpty(strA)) {
            this.f8696b = strA;
        } else {
            this.f8696b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
