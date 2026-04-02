package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes.dex */
public class m<A, B> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3085b = 250;
    private final com.bumptech.glide.util.g<b<A>, B> a;

    /* JADX INFO: compiled from: ModelCache.java */
    class a extends com.bumptech.glide.util.g<b<A>, B> {
        a(long j2) {
            super(j2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.g
        public void a(@NonNull b<A> bVar, @Nullable B b2) {
            bVar.a();
        }
    }

    public m() {
        this(250L);
    }

    @Nullable
    public B a(A a2, int i2, int i3) {
        b<A> bVarA = b.a(a2, i2, i3);
        B b2 = this.a.b(bVarA);
        bVarA.a();
        return b2;
    }

    public m(long j2) {
        this.a = new a(j2);
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.a.b(b.a(a2, i2, i3), b2);
    }

    /* JADX INFO: compiled from: ModelCache.java */
    @VisibleForTesting
    static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f3087d = com.bumptech.glide.util.l.a(0);
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private A f3089c;

        private b() {
        }

        static <A> b<A> a(A a, int i2, int i3) {
            b<A> bVar;
            synchronized (f3087d) {
                bVar = (b) f3087d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i2, i3);
            return bVar;
        }

        private void b(A a, int i2, int i3) {
            this.f3089c = a;
            this.f3088b = i2;
            this.a = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3088b == bVar.f3088b && this.a == bVar.a && this.f3089c.equals(bVar.f3089c);
        }

        public int hashCode() {
            return (((this.a * 31) + this.f3088b) * 31) + this.f3089c.hashCode();
        }

        public void a() {
            synchronized (f3087d) {
                f3087d.offer(this);
            }
        }
    }

    public void a() {
        this.a.a();
    }
}
