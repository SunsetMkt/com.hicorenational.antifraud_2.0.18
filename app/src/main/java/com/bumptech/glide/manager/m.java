package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3340d = "RequestTracker";
    private final Set<com.bumptech.glide.r.d> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.r.d> f3341b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3342c;

    @VisibleForTesting
    void a(com.bumptech.glide.r.d dVar) {
        this.a.add(dVar);
    }

    public boolean b(@Nullable com.bumptech.glide.r.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(dVar);
        if (!this.f3341b.remove(dVar) && !zRemove) {
            z = false;
        }
        if (z) {
            dVar.clear();
        }
        return z;
    }

    public void c(@NonNull com.bumptech.glide.r.d dVar) {
        this.a.add(dVar);
        if (!this.f3342c) {
            dVar.c();
            return;
        }
        dVar.clear();
        Log.isLoggable(f3340d, 2);
        this.f3341b.add(dVar);
    }

    public void d() {
        this.f3342c = true;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.a)) {
            if (dVar.isRunning()) {
                dVar.pause();
                this.f3341b.add(dVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.a)) {
            if (!dVar.d() && !dVar.b()) {
                dVar.clear();
                if (this.f3342c) {
                    this.f3341b.add(dVar);
                } else {
                    dVar.c();
                }
            }
        }
    }

    public void f() {
        this.f3342c = false;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.a)) {
            if (!dVar.d() && !dVar.isRunning()) {
                dVar.c();
            }
        }
        this.f3341b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.f3342c + "}";
    }

    public void a() {
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            b((com.bumptech.glide.r.d) it.next());
        }
        this.f3341b.clear();
    }

    public boolean b() {
        return this.f3342c;
    }

    public void c() {
        this.f3342c = true;
        for (com.bumptech.glide.r.d dVar : com.bumptech.glide.util.l.a(this.a)) {
            if (dVar.isRunning() || dVar.d()) {
                dVar.clear();
                this.f3341b.add(dVar);
            }
        }
    }
}
