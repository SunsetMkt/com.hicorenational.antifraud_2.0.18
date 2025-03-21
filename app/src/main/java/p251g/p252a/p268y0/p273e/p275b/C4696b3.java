package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSamplePublisher.java */
/* renamed from: g.a.y0.e.b.b3 */
/* loaded from: classes2.dex */
public final class C4696b3<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<T> f17784b;

    /* renamed from: c */
    final InterfaceC5821b<?> f17785c;

    /* renamed from: d */
    final boolean f17786d;

    /* compiled from: FlowableSamplePublisher.java */
    /* renamed from: g.a.y0.e.b.b3$a */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC5821b<?> interfaceC5821b) {
            super(interfaceC5822c, interfaceC5821b);
            this.wip = new AtomicInteger();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* renamed from: g.a.y0.e.b.b3$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC5821b<?> interfaceC5821b) {
            super(interfaceC5822c, interfaceC5821b);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4696b3.c
        void run() {
            emit();
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* renamed from: g.a.y0.e.b.b3$c */
    static abstract class c<T> extends AtomicReference<T> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -3517602651313910099L;
        final InterfaceC5822c<? super T> actual;

        /* renamed from: s */
        InterfaceC5823d f17787s;
        final InterfaceC5821b<?> sampler;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<InterfaceC5823d> other = new AtomicReference<>();

        c(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC5821b<?> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.sampler = interfaceC5821b;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.other);
            this.f17787s.cancel();
        }

        public void complete() {
            this.f17787s.cancel();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    C5164d.m18610c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new C4562c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        public void error(Throwable th) {
            this.f17787s.cancel();
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            EnumC5160j.cancel(this.other);
            completeMain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            EnumC5160j.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17787s, interfaceC5823d)) {
                this.f17787s = interfaceC5823d;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                    interfaceC5823d.request(C5556m0.f20396b);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
            }
        }

        abstract void run();

        boolean setOther(InterfaceC5823d interfaceC5823d) {
            return EnumC5160j.setOnce(this.other, interfaceC5823d);
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* renamed from: g.a.y0.e.b.b3$d */
    static final class d<T> implements InterfaceC4529q<Object> {

        /* renamed from: a */
        final c<T> f17788a;

        d(c<T> cVar) {
            this.f17788a = cVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17788a.complete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17788a.error(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            this.f17788a.run();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (this.f17788a.setOther(interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4696b3(InterfaceC5821b<T> interfaceC5821b, InterfaceC5821b<?> interfaceC5821b2, boolean z) {
        this.f17784b = interfaceC5821b;
        this.f17785c = interfaceC5821b2;
        this.f17786d = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        if (this.f17786d) {
            this.f17784b.subscribe(new a(c4509e, this.f17785c));
        } else {
            this.f17784b.subscribe(new b(c4509e, this.f17785c));
        }
    }
}
