package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a1<TResult> {

    /* JADX INFO: renamed from: b */
    public boolean f4233b;

    /* JADX INFO: renamed from: c */
    public TResult f4234c;

    /* JADX INFO: renamed from: d */
    public Exception f4235d;
    public final Object a = new Object();

    /* JADX INFO: renamed from: e */
    public List<j0<TResult>> f4236e = new ArrayList();

    public final void a() {
        synchronized (this.a) {
            Iterator<j0<TResult>> it = this.f4236e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f4236e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f4235d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.a) {
            if (this.f4235d != null) {
                throw new RuntimeException(this.f4235d);
            }
            tresult = this.f4234c;
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.a) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            if (this.f4233b) {
                d();
                z = this.f4235d == null;
            }
        }
        return z;
    }

    public final a1<TResult> a(j0<TResult> j0Var) {
        synchronized (this.a) {
            if (!this.f4233b) {
                this.f4236e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
