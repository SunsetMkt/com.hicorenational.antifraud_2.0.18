package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.C1878l;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* renamed from: com.bumptech.glide.manager.a */
/* loaded from: classes.dex */
class C1787a implements InterfaceC1794h {

    /* renamed from: a */
    private final Set<InterfaceC1795i> f5070a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f5071b;

    /* renamed from: c */
    private boolean f5072c;

    C1787a() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1794h
    /* renamed from: a */
    public void mo4524a(@NonNull InterfaceC1795i interfaceC1795i) {
        this.f5070a.add(interfaceC1795i);
        if (this.f5072c) {
            interfaceC1795i.onDestroy();
        } else if (this.f5071b) {
            interfaceC1795i.onStart();
        } else {
            interfaceC1795i.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1794h
    /* renamed from: b */
    public void mo4526b(@NonNull InterfaceC1795i interfaceC1795i) {
        this.f5070a.remove(interfaceC1795i);
    }

    /* renamed from: c */
    void m4527c() {
        this.f5071b = false;
        Iterator it = C1878l.m5001a(this.f5070a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1795i) it.next()).onStop();
        }
    }

    /* renamed from: b */
    void m4525b() {
        this.f5071b = true;
        Iterator it = C1878l.m5001a(this.f5070a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1795i) it.next()).onStart();
        }
    }

    /* renamed from: a */
    void m4523a() {
        this.f5072c = true;
        Iterator it = C1878l.m5001a(this.f5070a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1795i) it.next()).onDestroy();
        }
    }
}
