package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnBackpressureDrop.java */
/* renamed from: g.a.y0.e.b.g2 */
/* loaded from: classes2.dex */
public final class C4725g2<T> extends AbstractC4686a<T, T> implements InterfaceC4576g<T> {

    /* renamed from: c */
    final InterfaceC4576g<? super T> f17914c;

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* renamed from: g.a.y0.e.b.g2$a */
    static final class a<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -6246093802440953054L;
        final InterfaceC5822c<? super T> actual;
        boolean done;
        final InterfaceC4576g<? super T> onDrop;

        /* renamed from: s */
        InterfaceC5823d f17915s;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4576g<? super T> interfaceC4576g) {
            this.actual = interfaceC5822c;
            this.onDrop = interfaceC4576g;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17915s.cancel();
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
                C4476a.m17152b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.actual.onNext(t);
                C5164d.m18610c(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17915s, interfaceC5823d)) {
                this.f17915s = interfaceC5823d;
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
    }

    public C4725g2(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
        this.f17914c = this;
    }

    @Override // p251g.p252a.p267x0.InterfaceC4576g
    public void accept(T t) {
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17914c));
    }

    public C4725g2(AbstractC4519l<T> abstractC4519l, InterfaceC4576g<? super T> interfaceC4576g) {
        super(abstractC4519l);
        this.f17914c = interfaceC4576g;
    }
}
