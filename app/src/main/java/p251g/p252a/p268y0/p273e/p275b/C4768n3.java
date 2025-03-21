package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayDeque;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSkipLast.java */
/* renamed from: g.a.y0.e.b.n3 */
/* loaded from: classes2.dex */
public final class C4768n3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final int f18122c;

    /* compiled from: FlowableSkipLast.java */
    /* renamed from: g.a.y0.e.b.n3$a */
    static final class a<T> extends ArrayDeque<T> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -3807491841935125653L;
        final InterfaceC5822c<? super T> actual;

        /* renamed from: s */
        InterfaceC5823d f18123s;
        final int skip;

        a(InterfaceC5822c<? super T> interfaceC5822c, int i2) {
            super(i2);
            this.actual = interfaceC5822c;
            this.skip = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18123s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            } else {
                this.f18123s.request(1L);
            }
            offer(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18123s, interfaceC5823d)) {
                this.f18123s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18123s.request(j2);
        }
    }

    public C4768n3(AbstractC4519l<T> abstractC4519l, int i2) {
        super(abstractC4519l);
        this.f18122c = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18122c));
    }
}
