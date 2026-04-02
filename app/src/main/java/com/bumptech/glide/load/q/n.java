package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public interface n<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {
        public final com.bumptech.glide.load.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.g> f3090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.o.d<Data> f3091c;

        public a(@NonNull com.bumptech.glide.load.g gVar, @NonNull com.bumptech.glide.load.o.d<Data> dVar) {
            this(gVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.bumptech.glide.load.g gVar, @NonNull List<com.bumptech.glide.load.g> list, @NonNull com.bumptech.glide.load.o.d<Data> dVar) {
            this.a = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar);
            this.f3090b = (List) com.bumptech.glide.util.j.a(list);
            this.f3091c = (com.bumptech.glide.load.o.d) com.bumptech.glide.util.j.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar);

    boolean a(@NonNull Model model);
}
