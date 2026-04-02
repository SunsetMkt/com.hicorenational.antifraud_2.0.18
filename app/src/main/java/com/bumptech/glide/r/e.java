package com.bumptech.glide.r;

/* JADX INFO: compiled from: RequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: compiled from: RequestCoordinator.java */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    void b(d dVar);

    boolean c(d dVar);

    boolean d(d dVar);

    void e(d dVar);

    boolean f(d dVar);

    e getRoot();
}
