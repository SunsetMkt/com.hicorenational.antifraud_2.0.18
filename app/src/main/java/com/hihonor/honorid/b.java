package com.hihonor.honorid;

import com.hihonor.honorid.UseCase;

/* JADX INFO: compiled from: UseCaseHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private final c a;

    /* JADX INFO: compiled from: UseCaseHandler.java */
    private static final class a implements UseCase.a {
        public a(UseCase.a aVar, b bVar) {
        }
    }

    /* JADX INFO: renamed from: com.hihonor.honorid.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UseCaseHandler.java */
    static final class RunnableC0089b implements Runnable {
        UseCase a;

        RunnableC0089b(UseCase useCase) {
            this.a = useCase;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    public b(c cVar) {
        this.a = cVar;
    }

    public <T extends UseCase.RequestValues> void a(UseCase<T> useCase, T t, UseCase.a aVar) {
        useCase.b(t);
        useCase.a(new a(aVar, this));
        this.a.execute(new RunnableC0089b(useCase));
    }
}
