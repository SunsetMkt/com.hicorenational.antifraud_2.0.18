package org.greenrobot.eventbus;

/* compiled from: Subscription.java */
/* renamed from: org.greenrobot.eventbus.q */
/* loaded from: classes2.dex */
final class C6063q {

    /* renamed from: a */
    final Object f21613a;

    /* renamed from: b */
    final C6061o f21614b;

    /* renamed from: c */
    volatile boolean f21615c = true;

    C6063q(Object obj, C6061o c6061o) {
        this.f21613a = obj;
        this.f21614b = c6061o;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6063q)) {
            return false;
        }
        C6063q c6063q = (C6063q) obj;
        return this.f21613a == c6063q.f21613a && this.f21614b.equals(c6063q.f21614b);
    }

    public int hashCode() {
        return this.f21613a.hashCode() + this.f21614b.f21595f.hashCode();
    }
}
