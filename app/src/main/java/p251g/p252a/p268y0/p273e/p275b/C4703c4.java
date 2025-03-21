package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableThrottleFirstTimed.java */
/* renamed from: g.a.y0.e.b.c4 */
/* loaded from: classes2.dex */
public final class C4703c4<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f17810c;

    /* renamed from: d */
    final TimeUnit f17811d;

    /* renamed from: e */
    final AbstractC4516j0 f17812e;

    /* compiled from: FlowableThrottleFirstTimed.java */
    /* renamed from: g.a.y0.e.b.c4$a */
    static final class a<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        final InterfaceC5822c<? super T> actual;
        boolean done;
        volatile boolean gate;

        /* renamed from: s */
        InterfaceC5823d f17813s;
        final long timeout;
        final C4599k timer = new C4599k();
        final TimeUnit unit;
        final AbstractC4516j0.c worker;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            this.actual = interfaceC5822c;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17813s.cancel();
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done || this.gate) {
                return;
            }
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.actual.onError(new C4562c("Could not deliver value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                C5164d.m18610c(this, 1L);
                InterfaceC4552c interfaceC4552c = this.timer.get();
                if (interfaceC4552c != null) {
                    interfaceC4552c.dispose();
                }
                this.timer.replace(this.worker.mo17283a(this, this.timeout, this.unit));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17813s, interfaceC5823d)) {
                this.f17813s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public C4703c4(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(abstractC4519l);
        this.f17810c = j2;
        this.f17811d = timeUnit;
        this.f17812e = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(new C4509e(interfaceC5822c), this.f17810c, this.f17811d, this.f17812e.mo17277a()));
    }
}
