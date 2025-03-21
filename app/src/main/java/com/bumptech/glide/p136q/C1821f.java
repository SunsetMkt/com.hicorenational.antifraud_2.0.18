package com.bumptech.glide.p136q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1599m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* renamed from: com.bumptech.glide.q.f */
/* loaded from: classes.dex */
public class C1821f {

    /* renamed from: a */
    private final List<a<?>> f5257a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: com.bumptech.glide.q.f$a */
    private static final class a<T> {

        /* renamed from: a */
        private final Class<T> f5258a;

        /* renamed from: b */
        final InterfaceC1599m<T> f5259b;

        a(@NonNull Class<T> cls, @NonNull InterfaceC1599m<T> interfaceC1599m) {
            this.f5258a = cls;
            this.f5259b = interfaceC1599m;
        }

        /* renamed from: a */
        boolean m4714a(@NonNull Class<?> cls) {
            return this.f5258a.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <Z> void m4712a(@NonNull Class<Z> cls, @NonNull InterfaceC1599m<Z> interfaceC1599m) {
        this.f5257a.add(new a<>(cls, interfaceC1599m));
    }

    /* renamed from: b */
    public synchronized <Z> void m4713b(@NonNull Class<Z> cls, @NonNull InterfaceC1599m<Z> interfaceC1599m) {
        this.f5257a.add(0, new a<>(cls, interfaceC1599m));
    }

    @Nullable
    /* renamed from: a */
    public synchronized <Z> InterfaceC1599m<Z> m4711a(@NonNull Class<Z> cls) {
        int size = this.f5257a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.f5257a.get(i2);
            if (aVar.m4714a(cls)) {
                return (InterfaceC1599m<Z>) aVar.f5259b;
            }
        }
        return null;
    }
}
