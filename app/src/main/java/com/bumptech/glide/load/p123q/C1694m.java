package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1873g;
import com.bumptech.glide.util.C1878l;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* renamed from: com.bumptech.glide.load.q.m */
/* loaded from: classes.dex */
public class C1694m<A, B> {

    /* renamed from: b */
    private static final int f4719b = 250;

    /* renamed from: a */
    private final C1873g<b<A>, B> f4720a;

    /* compiled from: ModelCache.java */
    /* renamed from: com.bumptech.glide.load.q.m$a */
    class a extends C1873g<b<A>, B> {
        a(long j2) {
            super(j2);
        }

        @Override // com.bumptech.glide.util.C1873g
        /* renamed from: a */
        protected /* bridge */ /* synthetic */ void mo3999a(@NonNull Object obj, @Nullable Object obj2) {
            m4254a((b) obj, (b<A>) obj2);
        }

        /* renamed from: a */
        protected void m4254a(@NonNull b<A> bVar, @Nullable B b2) {
            bVar.m4257a();
        }
    }

    public C1694m() {
        this(250L);
    }

    @Nullable
    /* renamed from: a */
    public B m4251a(A a2, int i2, int i3) {
        b<A> m4255a = b.m4255a(a2, i2, i3);
        B m4977b = this.f4720a.m4977b(m4255a);
        m4255a.m4257a();
        return m4977b;
    }

    public C1694m(long j2) {
        this.f4720a = new a(j2);
    }

    /* renamed from: a */
    public void m4253a(A a2, int i2, int i3, B b2) {
        this.f4720a.m4978b(b.m4255a(a2, i2, i3), b2);
    }

    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.q.m$b */
    static final class b<A> {

        /* renamed from: d */
        private static final Queue<b<?>> f4722d = C1878l.m5002a(0);

        /* renamed from: a */
        private int f4723a;

        /* renamed from: b */
        private int f4724b;

        /* renamed from: c */
        private A f4725c;

        private b() {
        }

        /* renamed from: a */
        static <A> b<A> m4255a(A a2, int i2, int i3) {
            b<A> bVar;
            synchronized (f4722d) {
                bVar = (b) f4722d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.m4256b(a2, i2, i3);
            return bVar;
        }

        /* renamed from: b */
        private void m4256b(A a2, int i2, int i3) {
            this.f4725c = a2;
            this.f4724b = i2;
            this.f4723a = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4724b == bVar.f4724b && this.f4723a == bVar.f4723a && this.f4725c.equals(bVar.f4725c);
        }

        public int hashCode() {
            return (((this.f4723a * 31) + this.f4724b) * 31) + this.f4725c.hashCode();
        }

        /* renamed from: a */
        public void m4257a() {
            synchronized (f4722d) {
                f4722d.offer(this);
            }
        }
    }

    /* renamed from: a */
    public void m4252a() {
        this.f4720a.m4972a();
    }
}
