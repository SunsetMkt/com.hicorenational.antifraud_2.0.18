package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: DataRewinderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.a<?> f2728b = new a();
    private final Map<Class<?>, e.a<?>> a = new HashMap();

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<Object> a(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    private static final class b implements e<Object> {
        private final Object a;

        b(@NonNull Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.o.e
        @NonNull
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.o.e
        public void b() {
        }
    }

    public synchronized void a(@NonNull e.a<?> aVar) {
        this.a.put(aVar.a(), aVar);
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        com.bumptech.glide.util.j.a(t);
        aVar = this.a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f2728b;
        }
        return (e<T>) aVar.a(t);
    }
}
