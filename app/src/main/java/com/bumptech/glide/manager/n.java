package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.r.l.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes.dex */
public final class n implements i {
    private final Set<p<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public void a(@NonNull p<?> pVar) {
        this.a.add(pVar);
    }

    public void b(@NonNull p<?> pVar) {
        this.a.remove(pVar);
    }

    @NonNull
    public List<p<?>> c() {
        return com.bumptech.glide.util.l.a(this.a);
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onStop();
        }
    }

    public void b() {
        this.a.clear();
    }
}
