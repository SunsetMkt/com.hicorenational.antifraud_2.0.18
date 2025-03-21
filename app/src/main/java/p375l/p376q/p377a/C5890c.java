package p375l.p376q.p377a;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p375l.C5884m;
import p375l.InterfaceC5873b;

/* compiled from: CallExecuteObservable.java */
/* renamed from: l.q.a.c */
/* loaded from: classes2.dex */
final class C5890c<T> extends AbstractC4469b0<C5884m<T>> {

    /* renamed from: a */
    private final InterfaceC5873b<T> f21340a;

    /* compiled from: CallExecuteObservable.java */
    /* renamed from: l.q.a.c$a */
    private static final class a implements InterfaceC4552c {

        /* renamed from: a */
        private final InterfaceC5873b<?> f21341a;

        /* renamed from: b */
        private volatile boolean f21342b;

        a(InterfaceC5873b<?> interfaceC5873b) {
            this.f21341a = interfaceC5873b;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f21342b = true;
            this.f21341a.cancel();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f21342b;
        }
    }

    C5890c(InterfaceC5873b<T> interfaceC5873b) {
        this.f21340a = interfaceC5873b;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super C5884m<T>> interfaceC4514i0) {
        boolean z;
        InterfaceC5873b<T> clone = this.f21340a.clone();
        a aVar = new a(clone);
        interfaceC4514i0.onSubscribe(aVar);
        try {
            C5884m<T> execute = clone.execute();
            if (!aVar.isDisposed()) {
                interfaceC4514i0.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                interfaceC4514i0.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                C4561b.m18199b(th);
                if (z) {
                    C4476a.m17152b(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    interfaceC4514i0.onError(th);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    C4476a.m17152b(new C4560a(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
