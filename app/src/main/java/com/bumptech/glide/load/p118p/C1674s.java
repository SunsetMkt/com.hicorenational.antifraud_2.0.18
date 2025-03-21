package com.bumptech.glide.load.p118p;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.InterfaceC1593g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* renamed from: com.bumptech.glide.load.p.s */
/* loaded from: classes.dex */
final class C1674s {

    /* renamed from: a */
    private final Map<InterfaceC1593g, C1667l<?>> f4623a = new HashMap();

    /* renamed from: b */
    private final Map<InterfaceC1593g, C1667l<?>> f4624b = new HashMap();

    C1674s() {
    }

    @VisibleForTesting
    /* renamed from: a */
    Map<InterfaceC1593g, C1667l<?>> m4198a() {
        return Collections.unmodifiableMap(this.f4623a);
    }

    /* renamed from: b */
    void m4200b(InterfaceC1593g interfaceC1593g, C1667l<?> c1667l) {
        Map<InterfaceC1593g, C1667l<?>> m4196a = m4196a(c1667l.m4175g());
        if (c1667l.equals(m4196a.get(interfaceC1593g))) {
            m4196a.remove(interfaceC1593g);
        }
    }

    /* renamed from: a */
    C1667l<?> m4197a(InterfaceC1593g interfaceC1593g, boolean z) {
        return m4196a(z).get(interfaceC1593g);
    }

    /* renamed from: a */
    void m4199a(InterfaceC1593g interfaceC1593g, C1667l<?> c1667l) {
        m4196a(c1667l.m4175g()).put(interfaceC1593g, c1667l);
    }

    /* renamed from: a */
    private Map<InterfaceC1593g, C1667l<?>> m4196a(boolean z) {
        return z ? this.f4624b : this.f4623a;
    }
}
