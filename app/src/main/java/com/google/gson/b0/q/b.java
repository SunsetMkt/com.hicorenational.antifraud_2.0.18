package com.google.gson.b0.q;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements z {
    private final com.google.gson.b0.c a;

    /* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
    private static final class a<E> extends y<Collection<E>> {
        private final y<E> a;

        /* JADX INFO: renamed from: b */
        private final com.google.gson.b0.k<? extends Collection<E>> f3682b;

        public a(com.google.gson.e eVar, Type type, y<E> yVar, com.google.gson.b0.k<? extends Collection<E>> kVar) {
            this.a = new n(eVar, yVar, type);
            this.f3682b = kVar;
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.j();
                return;
            }
            dVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.a.write(dVar, it.next());
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        public Collection<E> read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            Collection<E> collectionA = this.f3682b.a();
            aVar.c();
            while (aVar.j()) {
                collectionA.add(this.a.read(aVar));
            }
            aVar.f();
            return collectionA;
        }
    }

    public b(com.google.gson.b0.c cVar) {
        this.a = cVar;
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeA = com.google.gson.b0.b.a(type, (Class<?>) rawType);
        return new a(eVar, typeA, eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeA)), this.a.a(aVar));
    }
}
