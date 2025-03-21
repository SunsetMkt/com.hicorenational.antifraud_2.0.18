package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelFilter.java */
/* renamed from: g.a.y0.e.e.d */
/* loaded from: classes2.dex */
public final class C5048d<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final AbstractC4471b<T> f19581a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19582b;

    /* compiled from: ParallelFilter.java */
    /* renamed from: g.a.y0.e.e.d$a */
    static abstract class a<T> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC4587r<? super T> f19583a;

        /* renamed from: b */
        InterfaceC5823d f19584b;

        /* renamed from: c */
        boolean f19585c;

        a(InterfaceC4587r<? super T> interfaceC4587r) {
            this.f19583a = interfaceC4587r;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.f19584b.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f19585c) {
                return;
            }
            this.f19584b.request(1L);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            this.f19584b.request(j2);
        }
    }

    /* compiled from: ParallelFilter.java */
    /* renamed from: g.a.y0.e.e.d$b */
    static final class b<T> extends a<T> {

        /* renamed from: d */
        final InterfaceC4602a<? super T> f19586d;

        b(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC4587r);
            this.f19586d = interfaceC4602a;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19585c) {
                return;
            }
            this.f19585c = true;
            this.f19586d.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19585c) {
                C4476a.m17152b(th);
            } else {
                this.f19585c = true;
                this.f19586d.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19584b, interfaceC5823d)) {
                this.f19584b = interfaceC5823d;
                this.f19586d.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (!this.f19585c) {
                try {
                    if (this.f19583a.test(t)) {
                        return this.f19586d.tryOnNext(t);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    /* compiled from: ParallelFilter.java */
    /* renamed from: g.a.y0.e.e.d$c */
    static final class c<T> extends a<T> {

        /* renamed from: d */
        final InterfaceC5822c<? super T> f19587d;

        c(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC4587r);
            this.f19587d = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19585c) {
                return;
            }
            this.f19585c = true;
            this.f19587d.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19585c) {
                C4476a.m17152b(th);
            } else {
                this.f19585c = true;
                this.f19587d.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19584b, interfaceC5823d)) {
                this.f19584b = interfaceC5823d;
                this.f19587d.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (!this.f19585c) {
                try {
                    if (this.f19583a.test(t)) {
                        this.f19587d.onNext(t);
                        return true;
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public C5048d(AbstractC4471b<T> abstractC4471b, InterfaceC4587r<? super T> interfaceC4587r) {
        this.f19581a = abstractC4471b;
        this.f19582b = interfaceC4587r;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super T>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                InterfaceC5822c<? super T> interfaceC5822c = interfaceC5822cArr[i2];
                if (interfaceC5822c instanceof InterfaceC4602a) {
                    interfaceC5822cArr2[i2] = new b((InterfaceC4602a) interfaceC5822c, this.f19582b);
                } else {
                    interfaceC5822cArr2[i2] = new c(interfaceC5822c, this.f19582b);
                }
            }
            this.f19581a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19581a.mo16967a();
    }
}
