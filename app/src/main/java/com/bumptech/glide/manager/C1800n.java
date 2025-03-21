package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.util.C1878l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* renamed from: com.bumptech.glide.manager.n */
/* loaded from: classes.dex */
public final class C1800n implements InterfaceC1795i {

    /* renamed from: a */
    private final Set<InterfaceC1848p<?>> f5100a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public void m4563a(@NonNull InterfaceC1848p<?> interfaceC1848p) {
        this.f5100a.add(interfaceC1848p);
    }

    /* renamed from: b */
    public void m4565b(@NonNull InterfaceC1848p<?> interfaceC1848p) {
        this.f5100a.remove(interfaceC1848p);
    }

    @NonNull
    /* renamed from: c */
    public List<InterfaceC1848p<?>> m4566c() {
        return C1878l.m5001a(this.f5100a);
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onDestroy() {
        Iterator it = C1878l.m5001a(this.f5100a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1848p) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
        Iterator it = C1878l.m5001a(this.f5100a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1848p) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
        Iterator it = C1878l.m5001a(this.f5100a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1848p) it.next()).onStop();
        }
    }

    /* renamed from: b */
    public void m4564b() {
        this.f5100a.clear();
    }
}
