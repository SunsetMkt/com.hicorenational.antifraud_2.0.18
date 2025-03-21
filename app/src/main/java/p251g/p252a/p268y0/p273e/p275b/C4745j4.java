package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableUnsubscribeOn.java */
/* renamed from: g.a.y0.e.b.j4 */
/* loaded from: classes2.dex */
public final class C4745j4<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final AbstractC4516j0 f17984c;

    /* compiled from: FlowableUnsubscribeOn.java */
    /* renamed from: g.a.y0.e.b.j4$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 1015244841293359600L;
        final InterfaceC5822c<? super T> actual;

        /* renamed from: s */
        InterfaceC5823d f17985s;
        final AbstractC4516j0 scheduler;

        /* compiled from: FlowableUnsubscribeOn.java */
        /* renamed from: g.a.y0.e.b.j4$a$a, reason: collision with other inner class name */
        final class RunnableC7393a implements Runnable {
            RunnableC7393a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17985s.cancel();
            }
        }

        a(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC5822c;
            this.scheduler = abstractC4516j0;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.mo17407a(new RunnableC7393a());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (get()) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17985s, interfaceC5823d)) {
                this.f17985s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17985s.request(j2);
        }
    }

    public C4745j4(AbstractC4519l<T> abstractC4519l, AbstractC4516j0 abstractC4516j0) {
        super(abstractC4519l);
        this.f17984c = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17984c));
    }
}
