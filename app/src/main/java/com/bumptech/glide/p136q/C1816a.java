package com.bumptech.glide.p136q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1590d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* renamed from: com.bumptech.glide.q.a */
/* loaded from: classes.dex */
public class C1816a {

    /* renamed from: a */
    private final List<a<?>> f5243a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.q.a$a */
    private static final class a<T> {

        /* renamed from: a */
        private final Class<T> f5244a;

        /* renamed from: b */
        final InterfaceC1590d<T> f5245b;

        a(@NonNull Class<T> cls, @NonNull InterfaceC1590d<T> interfaceC1590d) {
            this.f5244a = cls;
            this.f5245b = interfaceC1590d;
        }

        /* renamed from: a */
        boolean m4694a(@NonNull Class<?> cls) {
            return this.f5244a.isAssignableFrom(cls);
        }
    }

    @Nullable
    /* renamed from: a */
    public synchronized <T> InterfaceC1590d<T> m4691a(@NonNull Class<T> cls) {
        for (a<?> aVar : this.f5243a) {
            if (aVar.m4694a(cls)) {
                return (InterfaceC1590d<T>) aVar.f5245b;
            }
        }
        return null;
    }

    /* renamed from: b */
    public synchronized <T> void m4693b(@NonNull Class<T> cls, @NonNull InterfaceC1590d<T> interfaceC1590d) {
        this.f5243a.add(0, new a<>(cls, interfaceC1590d));
    }

    /* renamed from: a */
    public synchronized <T> void m4692a(@NonNull Class<T> cls, @NonNull InterfaceC1590d<T> interfaceC1590d) {
        this.f5243a.add(new a<>(cls, interfaceC1590d));
    }
}
