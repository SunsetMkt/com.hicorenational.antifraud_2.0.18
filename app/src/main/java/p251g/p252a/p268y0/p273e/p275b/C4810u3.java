package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTake.java */
/* renamed from: g.a.y0.e.b.u3 */
/* loaded from: classes2.dex */
public final class C4810u3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18447c;

    /* compiled from: FlowableTake.java */
    /* renamed from: g.a.y0.e.b.u3$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -5636543848937116287L;
        final InterfaceC5822c<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        InterfaceC5823d subscription;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2) {
            this.actual = interfaceC5822c;
            this.limit = j2;
            this.remaining = j2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.remaining;
            this.remaining = j2 - 1;
            if (j2 > 0) {
                boolean z = this.remaining == 0;
                this.actual.onNext(t);
                if (z) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.subscription, interfaceC5823d)) {
                this.subscription = interfaceC5823d;
                if (this.limit != 0) {
                    this.actual.onSubscribe(this);
                    return;
                }
                interfaceC5823d.cancel();
                this.done = true;
                EnumC5157g.complete(this.actual);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                if (get() || !compareAndSet(false, true) || j2 < this.limit) {
                    this.subscription.request(j2);
                } else {
                    this.subscription.request(C5556m0.f20396b);
                }
            }
        }
    }

    public C4810u3(AbstractC4519l<T> abstractC4519l, long j2) {
        super(abstractC4519l);
        this.f18447c = j2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18447c));
    }
}
