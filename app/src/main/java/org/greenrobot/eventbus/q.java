package org.greenrobot.eventbus;

/* JADX INFO: compiled from: Subscription.java */
/* JADX INFO: loaded from: classes2.dex */
final class q {
    final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o f12957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f12958c = true;

    q(Object obj, o oVar) {
        this.a = obj;
        this.f12957b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.f12957b.equals(qVar.f12957b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.f12957b.f12941f.hashCode();
    }
}
