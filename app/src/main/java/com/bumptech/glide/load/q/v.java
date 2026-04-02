package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {
    private static final v<?> a = new v<>();

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {
        private static final a<?> a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> b() {
            return (a<T>) a;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Model, Model> a(r rVar) {
            return v.a();
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.o.d<Model> {
        private final Model a;

        b(Model model) {
            this.a = model;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Model> aVar) {
            aVar.a(this.a);
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.a.getClass();
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> a() {
        return (v<T>) a;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Model> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(model), new b(model));
    }
}
