package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> a;

    /* JADX INFO: renamed from: b */
    private final Pools.Pool<List<Throwable>> f3093b;

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.f3093b = pool;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        n.a<Data> aVarA;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.g gVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.a.get(i4);
            if (nVar.a(model) && (aVarA = nVar.a(model, i2, i3, jVar)) != null) {
                gVar = aVarA.a;
                arrayList.add(aVarA.f3091c);
            }
        }
        if (arrayList.isEmpty() || gVar == null) {
            return null;
        }
        return new n.a<>(gVar, new a(arrayList, this.f3093b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.o.d<Data>, d.a<Data> {
        private final List<com.bumptech.glide.load.o.d<Data>> a;

        /* JADX INFO: renamed from: b */
        private final Pools.Pool<List<Throwable>> f3094b;

        /* JADX INFO: renamed from: c */
        private int f3095c;

        /* JADX INFO: renamed from: d */
        private com.bumptech.glide.h f3096d;

        /* JADX INFO: renamed from: e */
        private d.a<? super Data> f3097e;

        /* JADX INFO: renamed from: f */
        @Nullable
        private List<Throwable> f3098f;

        /* JADX INFO: renamed from: g */
        private boolean f3099g;

        a(@NonNull List<com.bumptech.glide.load.o.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f3094b = pool;
            com.bumptech.glide.util.j.a(list);
            this.a = list;
            this.f3095c = 0;
        }

        private void d() {
            if (this.f3099g) {
                return;
            }
            if (this.f3095c < this.a.size() - 1) {
                this.f3095c++;
                a(this.f3096d, this.f3097e);
            } else {
                com.bumptech.glide.util.j.a(this.f3098f);
                this.f3097e.a((Exception) new com.bumptech.glide.load.p.q("Fetch failed", new ArrayList(this.f3098f)));
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            this.f3096d = hVar;
            this.f3097e = aVar;
            this.f3098f = this.f3094b.acquire();
            this.a.get(this.f3095c).a(hVar, this);
            if (this.f3099g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            List<Throwable> list = this.f3098f;
            if (list != null) {
                this.f3094b.release(list);
            }
            this.f3098f = null;
            Iterator<com.bumptech.glide.load.o.d<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return this.a.get(0).c();
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
            this.f3099g = true;
            Iterator<com.bumptech.glide.load.o.d<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Data> a() {
            return this.a.get(0).a();
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.f3097e.a(data);
            } else {
                d();
            }
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@NonNull Exception exc) {
            ((List) com.bumptech.glide.util.j.a(this.f3098f)).add(exc);
            d();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }
}
