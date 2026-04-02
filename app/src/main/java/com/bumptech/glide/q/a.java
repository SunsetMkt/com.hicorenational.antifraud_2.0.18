package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private final List<C0064a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: com.bumptech.glide.q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0064a<T> {
        private final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.d<T> f3431b;

        C0064a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
            this.a = cls;
            this.f3431b = dVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.d<T> a(@NonNull Class<T> cls) {
        for (C0064a<?> c0064a : this.a) {
            if (c0064a.a(cls)) {
                return (com.bumptech.glide.load.d<T>) c0064a.f3431b;
            }
        }
        return null;
    }

    public synchronized <T> void b(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
        this.a.add(0, new C0064a<>(cls, dVar));
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.d<T> dVar) {
        this.a.add(new C0064a<>(cls, dVar));
    }
}
