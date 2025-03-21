package com.bumptech.glide.util.p141n;

import androidx.annotation.NonNull;

/* compiled from: StateVerifier.java */
/* renamed from: com.bumptech.glide.util.n.c */
/* loaded from: classes.dex */
public abstract class AbstractC1882c {

    /* renamed from: a */
    private static final boolean f5511a = false;

    @NonNull
    /* renamed from: b */
    public static AbstractC1882c m5029b() {
        return new c();
    }

    /* renamed from: a */
    public abstract void mo5030a();

    /* renamed from: a */
    abstract void mo5031a(boolean z);

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.n.c$b */
    private static class b extends AbstractC1882c {

        /* renamed from: b */
        private volatile RuntimeException f5512b;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.p141n.AbstractC1882c
        /* renamed from: a */
        public void mo5030a() {
            if (this.f5512b != null) {
                throw new IllegalStateException("Already released", this.f5512b);
            }
        }

        @Override // com.bumptech.glide.util.p141n.AbstractC1882c
        /* renamed from: a */
        void mo5031a(boolean z) {
            if (z) {
                this.f5512b = new RuntimeException("Released");
            } else {
                this.f5512b = null;
            }
        }
    }

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.n.c$c */
    private static class c extends AbstractC1882c {

        /* renamed from: b */
        private volatile boolean f5513b;

        c() {
            super();
        }

        @Override // com.bumptech.glide.util.p141n.AbstractC1882c
        /* renamed from: a */
        public void mo5030a() {
            if (this.f5513b) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.p141n.AbstractC1882c
        /* renamed from: a */
        public void mo5031a(boolean z) {
            this.f5513b = z;
        }
    }

    private AbstractC1882c() {
    }
}
