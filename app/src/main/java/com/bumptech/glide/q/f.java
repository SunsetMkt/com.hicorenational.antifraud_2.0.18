package com.bumptech.glide.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {
        private final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m<T> f3438b;

        a(@NonNull Class<T> cls, @NonNull m<T> mVar) {
            this.a = cls;
            this.f3438b = mVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull m<Z> mVar) {
        this.a.add(new a<>(cls, mVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull m<Z> mVar) {
        this.a.add(0, new a<>(cls, mVar));
    }

    @Nullable
    public synchronized <Z> m<Z> a(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.a.get(i2);
            if (aVar.a(cls)) {
                return (m<Z>) aVar.f3438b;
            }
        }
        return null;
    }
}
