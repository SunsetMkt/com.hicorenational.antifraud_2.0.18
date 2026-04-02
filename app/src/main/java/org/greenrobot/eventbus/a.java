package org.greenrobot.eventbus;

/* JADX INFO: compiled from: AsyncPoster.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements Runnable, l {
    private final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f12891b;

    a(c cVar) {
        this.f12891b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        this.a.a(j.a(qVar, obj));
        this.f12891b.a().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVarA = this.a.a();
        if (jVarA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f12891b.a(jVarA);
    }
}
