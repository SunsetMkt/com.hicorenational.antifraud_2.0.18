package p375l.p376q.p377a;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p375l.C5884m;

/* compiled from: ResultObservable.java */
/* renamed from: l.q.a.f */
/* loaded from: classes2.dex */
final class C5893f<T> extends AbstractC4469b0<C5892e<T>> {

    /* renamed from: a */
    private final AbstractC4469b0<C5884m<T>> f21345a;

    /* compiled from: ResultObservable.java */
    /* renamed from: l.q.a.f$a */
    private static class a<R> implements InterfaceC4514i0<C5884m<R>> {

        /* renamed from: a */
        private final InterfaceC4514i0<? super C5892e<R>> f21346a;

        a(InterfaceC4514i0<? super C5892e<R>> interfaceC4514i0) {
            this.f21346a = interfaceC4514i0;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C5884m<R> c5884m) {
            this.f21346a.onNext(C5892e.m24863a(c5884m));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f21346a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            try {
                this.f21346a.onNext(C5892e.m24862a(th));
                this.f21346a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f21346a.onError(th2);
                } catch (Throwable th3) {
                    C4561b.m18199b(th3);
                    C4476a.m17152b(new C4560a(th2, th3));
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f21346a.onSubscribe(interfaceC4552c);
        }
    }

    C5893f(AbstractC4469b0<C5884m<T>> abstractC4469b0) {
        this.f21345a = abstractC4469b0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super C5892e<T>> interfaceC4514i0) {
        this.f21345a.subscribe(new a(interfaceC4514i0));
    }
}
