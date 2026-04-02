package com.vivo.push;

import android.content.Context;

/* JADX INFO: compiled from: PushClientTask.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements Runnable {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v f8630c;

    public s(v vVar) {
        this.f8629b = -1;
        this.f8630c = vVar;
        this.f8629b = vVar.b();
        if (this.f8629b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.a = m.a().h();
    }

    public final int a() {
        return this.f8629b;
    }

    protected abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        if (context != null && !(this.f8630c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[\u6267\u884c\u6307\u4ee4]" + this.f8630c);
        }
        a(this.f8630c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        v vVar = this.f8630c;
        sb.append(vVar == null ? "[null]" : vVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
