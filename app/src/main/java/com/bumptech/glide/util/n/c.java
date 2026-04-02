package com.bumptech.glide.util.n;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private static final boolean a = false;

    @NonNull
    public static c b() {
        return new C0068c();
    }

    public abstract void a();

    abstract void a(boolean z);

    /* JADX INFO: compiled from: StateVerifier.java */
    private static class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile RuntimeException f3580b;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.n.c
        public void a() {
            if (this.f3580b != null) {
                throw new IllegalStateException("Already released", this.f3580b);
            }
        }

        @Override // com.bumptech.glide.util.n.c
        void a(boolean z) {
            if (z) {
                this.f3580b = new RuntimeException("Released");
            } else {
                this.f3580b = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.util.n.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StateVerifier.java */
    private static class C0068c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f3581b;

        C0068c() {
            super();
        }

        @Override // com.bumptech.glide.util.n.c
        public void a() {
            if (this.f3581b) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.n.c
        public void a(boolean z) {
            this.f3581b = z;
        }
    }

    private c() {
    }
}
