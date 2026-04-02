package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.r.d.q;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class f0 implements com.bumptech.glide.load.l<InputStream, Bitmap> {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f3158b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements q.b {
        private final b0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.c f3159b;

        a(b0 b0Var, com.bumptech.glide.util.c cVar) {
            this.a = b0Var;
            this.f3159b = cVar;
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a() {
            this.a.c();
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionC = this.f3159b.c();
            if (iOExceptionC != null) {
                if (bitmap == null) {
                    throw iOExceptionC;
                }
                eVar.a(bitmap);
                throw iOExceptionC;
            }
        }
    }

    public f0(q qVar, com.bumptech.glide.load.p.a0.b bVar) {
        this.a = qVar;
        this.f3158b = bVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.j jVar) {
        return this.a.a(inputStream);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        b0 b0Var;
        boolean z;
        if (inputStream instanceof b0) {
            b0Var = (b0) inputStream;
            z = false;
        } else {
            b0Var = new b0(inputStream, this.f3158b);
            z = true;
        }
        com.bumptech.glide.util.c cVarB = com.bumptech.glide.util.c.b(b0Var);
        try {
            return this.a.a(new com.bumptech.glide.util.h(cVarB), i2, i3, jVar, new a(b0Var, cVarB));
        } finally {
            cVarB.d();
            if (z) {
                b0Var.d();
            }
        }
    }
}
