package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.util.C1878l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* renamed from: com.bumptech.glide.manager.m */
/* loaded from: classes.dex */
public class C1799m {

    /* renamed from: d */
    private static final String f5096d = "RequestTracker";

    /* renamed from: a */
    private final Set<InterfaceC1825d> f5097a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<InterfaceC1825d> f5098b = new ArrayList();

    /* renamed from: c */
    private boolean f5099c;

    @VisibleForTesting
    /* renamed from: a */
    void m4555a(InterfaceC1825d interfaceC1825d) {
        this.f5097a.add(interfaceC1825d);
    }

    /* renamed from: b */
    public boolean m4557b(@Nullable InterfaceC1825d interfaceC1825d) {
        boolean z = true;
        if (interfaceC1825d == null) {
            return true;
        }
        boolean remove = this.f5097a.remove(interfaceC1825d);
        if (!this.f5098b.remove(interfaceC1825d) && !remove) {
            z = false;
        }
        if (z) {
            interfaceC1825d.clear();
        }
        return z;
    }

    /* renamed from: c */
    public void m4559c(@NonNull InterfaceC1825d interfaceC1825d) {
        this.f5097a.add(interfaceC1825d);
        if (!this.f5099c) {
            interfaceC1825d.mo4809c();
            return;
        }
        interfaceC1825d.clear();
        Log.isLoggable(f5096d, 2);
        this.f5098b.add(interfaceC1825d);
    }

    /* renamed from: d */
    public void m4560d() {
        this.f5099c = true;
        for (InterfaceC1825d interfaceC1825d : C1878l.m5001a(this.f5097a)) {
            if (interfaceC1825d.isRunning()) {
                interfaceC1825d.pause();
                this.f5098b.add(interfaceC1825d);
            }
        }
    }

    /* renamed from: e */
    public void m4561e() {
        for (InterfaceC1825d interfaceC1825d : C1878l.m5001a(this.f5097a)) {
            if (!interfaceC1825d.mo4811d() && !interfaceC1825d.mo4808b()) {
                interfaceC1825d.clear();
                if (this.f5099c) {
                    this.f5098b.add(interfaceC1825d);
                } else {
                    interfaceC1825d.mo4809c();
                }
            }
        }
    }

    /* renamed from: f */
    public void m4562f() {
        this.f5099c = false;
        for (InterfaceC1825d interfaceC1825d : C1878l.m5001a(this.f5097a)) {
            if (!interfaceC1825d.mo4811d() && !interfaceC1825d.isRunning()) {
                interfaceC1825d.mo4809c();
            }
        }
        this.f5098b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f5097a.size() + ", isPaused=" + this.f5099c + "}";
    }

    /* renamed from: a */
    public void m4554a() {
        Iterator it = C1878l.m5001a(this.f5097a).iterator();
        while (it.hasNext()) {
            m4557b((InterfaceC1825d) it.next());
        }
        this.f5098b.clear();
    }

    /* renamed from: b */
    public boolean m4556b() {
        return this.f5099c;
    }

    /* renamed from: c */
    public void m4558c() {
        this.f5099c = true;
        for (InterfaceC1825d interfaceC1825d : C1878l.m5001a(this.f5097a)) {
            if (interfaceC1825d.isRunning() || interfaceC1825d.mo4811d()) {
                interfaceC1825d.clear();
                this.f5098b.add(interfaceC1825d);
            }
        }
    }
}
