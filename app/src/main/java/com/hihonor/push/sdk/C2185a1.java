package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Incorrect class signature: super class is equals to this class */
/* renamed from: com.hihonor.push.sdk.a1 */
/* loaded from: classes.dex */
public final class C2185a1<TResult> {

    /* renamed from: b */
    public boolean f6749b;

    /* renamed from: c */
    public TResult f6750c;

    /* renamed from: d */
    public Exception f6751d;

    /* renamed from: a */
    public final Object f6748a = new Object();

    /* renamed from: e */
    public List<InterfaceC2211j0<TResult>> f6752e = new ArrayList();

    /* renamed from: a */
    public final void m6354a() {
        synchronized (this.f6748a) {
            Iterator<InterfaceC2211j0<TResult>> it = this.f6752e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().mo6390a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f6752e = null;
        }
    }

    /* renamed from: b */
    public final Exception m6355b() {
        Exception exc;
        synchronized (this.f6748a) {
            exc = this.f6751d;
        }
        return exc;
    }

    /* renamed from: c */
    public final TResult m6356c() {
        TResult tresult;
        synchronized (this.f6748a) {
            if (this.f6751d != null) {
                throw new RuntimeException(this.f6751d);
            }
            tresult = this.f6750c;
        }
        return tresult;
    }

    /* renamed from: d */
    public final boolean m6357d() {
        synchronized (this.f6748a) {
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m6358e() {
        boolean z;
        synchronized (this.f6748a) {
            if (this.f6749b) {
                m6357d();
                z = this.f6751d == null;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final C2185a1<TResult> m6353a(InterfaceC2211j0<TResult> interfaceC2211j0) {
        synchronized (this.f6748a) {
            if (!this.f6749b) {
                this.f6752e.add(interfaceC2211j0);
            } else {
                interfaceC2211j0.mo6390a(this);
            }
        }
        return this;
    }
}
