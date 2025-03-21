package p375l.p376q.p377a;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p375l.C5884m;

/* compiled from: BodyObservable.java */
/* renamed from: l.q.a.a */
/* loaded from: classes2.dex */
final class C5888a<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    private final AbstractC4469b0<C5884m<T>> f21332a;

    /* compiled from: BodyObservable.java */
    /* renamed from: l.q.a.a$a */
    private static class a<R> implements InterfaceC4514i0<C5884m<R>> {

        /* renamed from: a */
        private final InterfaceC4514i0<? super R> f21333a;

        /* renamed from: b */
        private boolean f21334b;

        a(InterfaceC4514i0<? super R> interfaceC4514i0) {
            this.f21333a = interfaceC4514i0;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C5884m<R> c5884m) {
            if (c5884m.m24795e()) {
                this.f21333a.onNext(c5884m.m24791a());
                return;
            }
            this.f21334b = true;
            C5891d c5891d = new C5891d(c5884m);
            try {
                this.f21333a.onError(c5891d);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(new C4560a(c5891d, th));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f21334b) {
                return;
            }
            this.f21333a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.f21334b) {
                this.f21333a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            C4476a.m17152b(assertionError);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f21333a.onSubscribe(interfaceC4552c);
        }
    }

    C5888a(AbstractC4469b0<C5884m<T>> abstractC4469b0) {
        this.f21332a = abstractC4469b0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f21332a.subscribe(new a(interfaceC4514i0));
    }
}
