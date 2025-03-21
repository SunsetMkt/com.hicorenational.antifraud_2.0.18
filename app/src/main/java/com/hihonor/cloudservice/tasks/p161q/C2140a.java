package com.hihonor.cloudservice.tasks.p161q;

import java.util.ArrayList;
import java.util.List;
import p031c.p075c.p076a.p090d.AbstractC1204a;

/* compiled from: CancellationTokenImpl.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.a */
/* loaded from: classes.dex */
public class C2140a extends AbstractC1204a {

    /* renamed from: a */
    public final List<Runnable> f6433a = new ArrayList();

    /* renamed from: b */
    public final Object f6434b = new Object();

    /* renamed from: c */
    public boolean f6435c = false;

    @Override // p031c.p075c.p076a.p090d.AbstractC1204a
    /* renamed from: a */
    public boolean mo2314a() {
        return this.f6435c;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1204a
    /* renamed from: a */
    public AbstractC1204a mo2313a(Runnable runnable) {
        synchronized (this.f6434b) {
            if (this.f6435c) {
                runnable.run();
            } else {
                this.f6433a.add(runnable);
            }
        }
        return this;
    }
}
