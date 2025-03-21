package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: MaybeDelayOtherPublisher.java */
/* renamed from: g.a.y0.e.c.m */
/* loaded from: classes2.dex */
public final class C4872m<T, U> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC5821b<U> f18648b;

    /* compiled from: MaybeDelayOtherPublisher.java */
    /* renamed from: g.a.y0.e.c.m$a */
    static final class a<T, U> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final b<T> f18649a;

        /* renamed from: b */
        final InterfaceC5821b<U> f18650b;

        /* renamed from: c */
        InterfaceC4552c f18651c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC5821b<U> interfaceC5821b) {
            this.f18649a = new b<>(interfaceC4559v);
            this.f18650b = interfaceC5821b;
        }

        /* renamed from: a */
        void m18411a() {
            this.f18650b.subscribe(this.f18649a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18651c.dispose();
            this.f18651c = EnumC4592d.DISPOSED;
            EnumC5160j.cancel(this.f18649a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(this.f18649a.get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18651c = EnumC4592d.DISPOSED;
            m18411a();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18651c = EnumC4592d.DISPOSED;
            this.f18649a.error = th;
            m18411a();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18651c, interfaceC4552c)) {
                this.f18651c = interfaceC4552c;
                this.f18649a.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18651c = EnumC4592d.DISPOSED;
            this.f18649a.value = t;
            m18411a();
        }
    }

    /* compiled from: MaybeDelayOtherPublisher.java */
    /* renamed from: g.a.y0.e.c.m$b */
    static final class b<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final InterfaceC4559v<? super T> actual;
        Throwable error;
        T value;

        b(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == null) {
                this.actual.onError(th);
            } else {
                this.actual.onError(new C4560a(th2, th));
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            InterfaceC5823d interfaceC5823d = get();
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d != enumC5160j) {
                lazySet(enumC5160j);
                interfaceC5823d.cancel();
                onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4872m(InterfaceC4588y<T> interfaceC4588y, InterfaceC5821b<U> interfaceC5821b) {
        super(interfaceC4588y);
        this.f18648b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18648b));
    }
}
