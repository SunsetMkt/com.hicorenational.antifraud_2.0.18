package com.hihonor.cloudservice.tasks.q;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CancellationTokenImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends d.c.a.d.a {
    public final List<Runnable> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4067b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4068c = false;

    @Override // d.c.a.d.a
    public boolean a() {
        return this.f4068c;
    }

    @Override // d.c.a.d.a
    public d.c.a.d.a a(Runnable runnable) {
        synchronized (this.f4067b) {
            if (this.f4068c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
