package com.hihonor.honorid;

import com.hihonor.honorid.UseCase;

/* compiled from: UseCaseHandler.java */
/* renamed from: com.hihonor.honorid.b */
/* loaded from: classes.dex */
public final class C2152b {

    /* renamed from: a */
    private final InterfaceC2153c f6491a;

    /* compiled from: UseCaseHandler.java */
    /* renamed from: com.hihonor.honorid.b$a */
    private static final class a implements UseCase.InterfaceC2150a {
        public a(UseCase.InterfaceC2150a interfaceC2150a, C2152b c2152b) {
        }
    }

    /* compiled from: UseCaseHandler.java */
    /* renamed from: com.hihonor.honorid.b$b */
    static final class b implements Runnable {

        /* renamed from: a */
        UseCase f6492a;

        b(UseCase useCase) {
            this.f6492a = useCase;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6492a.m6089a();
        }
    }

    public C2152b(InterfaceC2153c interfaceC2153c) {
        this.f6491a = interfaceC2153c;
    }

    /* renamed from: a */
    public <T extends UseCase.RequestValues> void m6098a(UseCase<T> useCase, T t, UseCase.InterfaceC2150a interfaceC2150a) {
        useCase.m6092b(t);
        useCase.m6091a(new a(interfaceC2150a, this));
        this.f6491a.execute(new b(useCase));
    }
}
