package com.bumptech.glide.load.p.b0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.n.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private final com.bumptech.glide.util.g<com.bumptech.glide.load.g, String> a = new com.bumptech.glide.util.g<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f2858b = com.bumptech.glide.util.n.a.b(10, new a());

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    class a implements a.d<b> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.n.a.d
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    private static final class b implements a.f {
        final MessageDigest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.n.c f2859b = com.bumptech.glide.util.n.c.b();

        b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // com.bumptech.glide.util.n.a.f
        @NonNull
        public com.bumptech.glide.util.n.c c() {
            return this.f2859b;
        }
    }

    private String b(com.bumptech.glide.load.g gVar) {
        b bVar = (b) com.bumptech.glide.util.j.a(this.f2858b.acquire());
        try {
            gVar.a(bVar.a);
            return com.bumptech.glide.util.l.a(bVar.a.digest());
        } finally {
            this.f2858b.release(bVar);
        }
    }

    public String a(com.bumptech.glide.load.g gVar) {
        String strB;
        synchronized (this.a) {
            strB = this.a.b(gVar);
        }
        if (strB == null) {
            strB = b(gVar);
        }
        synchronized (this.a) {
            this.a.b(gVar, strB);
        }
        return strB;
    }
}
