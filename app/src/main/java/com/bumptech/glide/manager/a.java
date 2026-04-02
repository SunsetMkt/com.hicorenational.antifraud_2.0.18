package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
class a implements h {
    private final Set<i> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3320c;

    a() {
    }

    @Override // com.bumptech.glide.manager.h
    public void a(@NonNull i iVar) {
        this.a.add(iVar);
        if (this.f3320c) {
            iVar.onDestroy();
        } else if (this.f3319b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public void b(@NonNull i iVar) {
        this.a.remove(iVar);
    }

    void c() {
        this.f3319b = false;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStop();
        }
    }

    void b() {
        this.f3319b = true;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    void a() {
        this.f3320c = true;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onDestroy();
        }
    }
}
