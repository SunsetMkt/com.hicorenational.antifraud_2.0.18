package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableLimit.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.b.x1 */
/* loaded from: classes2.dex */
public final class C4823x1<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18489c;

    /* compiled from: FlowableLimit.java */
    /* renamed from: g.a.y0.e.b.x1$a */
    static final class a<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 2288246011222124525L;
        final InterfaceC5822c<? super T> actual;
        long remaining;
        InterfaceC5823d upstream;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2) {
            this.actual = interfaceC5822c;
            this.remaining = j2;
            lazySet(j2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.remaining <= 0) {
                C4476a.m17152b(th);
            } else {
                this.remaining = 0L;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = this.remaining;
            if (j2 > 0) {
                long j3 = j2 - 1;
                this.remaining = j3;
                this.actual.onNext(t);
                if (j3 == 0) {
                    this.upstream.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.upstream, interfaceC5823d)) {
                if (this.remaining == 0) {
                    interfaceC5823d.cancel();
                    EnumC5157g.complete(this.actual);
                } else {
                    this.upstream = interfaceC5823d;
                    this.actual.onSubscribe(this);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            long j3;
            long j4;
            if (EnumC5160j.validate(j2)) {
                do {
                    j3 = get();
                    if (j3 == 0) {
                        return;
                    } else {
                        j4 = j3 <= j2 ? j3 : j2;
                    }
                } while (!compareAndSet(j3, j3 - j4));
                this.upstream.request(j4);
            }
        }
    }

    public C4823x1(AbstractC4519l<T> abstractC4519l, long j2) {
        super(abstractC4519l);
        this.f18489c = j2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18489c));
    }
}
