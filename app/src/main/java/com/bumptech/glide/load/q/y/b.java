package com.bumptech.glide.load.q.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.m;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements n<com.bumptech.glide.load.q.g, InputStream> {

    /* JADX INFO: renamed from: b */
    public static final i<Integer> f3113b = i.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    @Nullable
    private final m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> a;

    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class a implements o<com.bumptech.glide.load.q.g, InputStream> {
        private final m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> a = new m<>(500);

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<com.bumptech.glide.load.q.g, InputStream> a(r rVar) {
            return new b(this.a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull com.bumptech.glide.load.q.g gVar) {
        return true;
    }

    public b(@Nullable m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> mVar) {
        this.a = mVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull com.bumptech.glide.load.q.g gVar, int i2, int i3, @NonNull j jVar) {
        m<com.bumptech.glide.load.q.g, com.bumptech.glide.load.q.g> mVar = this.a;
        if (mVar != null) {
            com.bumptech.glide.load.q.g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.a.a(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new com.bumptech.glide.load.o.j(gVar, ((Integer) jVar.a(f3113b)).intValue()));
    }
}
