package com.vivo.push;

import android.content.Context;
import com.vivo.push.p232b.C3842n;
import com.vivo.push.util.C4010u;

/* compiled from: PushClientTask.java */
/* renamed from: com.vivo.push.s */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC3971s implements Runnable {

    /* renamed from: a */
    protected Context f14186a;

    /* renamed from: b */
    private int f14187b;

    /* renamed from: c */
    private AbstractC4016v f14188c;

    public AbstractRunnableC3971s(AbstractC4016v abstractC4016v) {
        this.f14187b = -1;
        this.f14188c = abstractC4016v;
        this.f14187b = abstractC4016v.m13325b();
        if (this.f14187b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f14186a = C3924m.m13016a().m13049h();
    }

    /* renamed from: a */
    public final int m13160a() {
        return this.f14187b;
    }

    /* renamed from: a */
    protected abstract void mo12952a(AbstractC4016v abstractC4016v);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f14186a;
        if (context != null && !(this.f14188c instanceof C3842n)) {
            C4010u.m13297a(context, "[执行指令]" + this.f14188c);
        }
        mo12952a(this.f14188c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        AbstractC4016v abstractC4016v = this.f14188c;
        sb.append(abstractC4016v == null ? "[null]" : abstractC4016v.toString());
        sb.append("}");
        return sb.toString();
    }
}
