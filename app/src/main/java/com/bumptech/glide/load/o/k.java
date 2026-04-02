package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import com.bumptech.glide.load.r.d.b0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f2743b = 5242880;
    private final b0 a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {
        private final com.bumptech.glide.load.p.a0.b a;

        public a(com.bumptech.glide.load.p.a0.b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.a);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, com.bumptech.glide.load.p.a0.b bVar) {
        this.a = new b0(inputStream, bVar);
        this.a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
        this.a.d();
    }

    public void c() {
        this.a.c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.o.e
    @NonNull
    public InputStream a() throws IOException {
        this.a.reset();
        return this.a;
    }
}
