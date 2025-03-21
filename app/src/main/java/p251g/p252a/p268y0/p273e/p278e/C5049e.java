package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p254b1.EnumC4470a;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelFilterTry.java */
/* renamed from: g.a.y0.e.e.e */
/* loaded from: classes2.dex */
public final class C5049e<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final AbstractC4471b<T> f19588a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19589b;

    /* renamed from: c */
    final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19590c;

    /* compiled from: ParallelFilterTry.java */
    /* renamed from: g.a.y0.e.e.e$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f19591a = new int[EnumC4470a.values().length];

        static {
            try {
                f19591a[EnumC4470a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19591a[EnumC4470a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19591a[EnumC4470a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelFilterTry.java */
    /* renamed from: g.a.y0.e.e.e$b */
    static abstract class b<T> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC4587r<? super T> f19592a;

        /* renamed from: b */
        final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19593b;

        /* renamed from: c */
        InterfaceC5823d f19594c;

        /* renamed from: d */
        boolean f19595d;

        b(InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            this.f19592a = interfaceC4587r;
            this.f19593b = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.f19594c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f19595d) {
                return;
            }
            this.f19594c.request(1L);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            this.f19594c.request(j2);
        }
    }

    /* compiled from: ParallelFilterTry.java */
    /* renamed from: g.a.y0.e.e.e$c */
    static final class c<T> extends b<T> {

        /* renamed from: e */
        final InterfaceC4602a<? super T> f19596e;

        c(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            super(interfaceC4587r, interfaceC4572c);
            this.f19596e = interfaceC4602a;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19595d) {
                return;
            }
            this.f19595d = true;
            this.f19596e.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19595d) {
                C4476a.m17152b(th);
            } else {
                this.f19595d = true;
                this.f19596e.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19594c, interfaceC5823d)) {
                this.f19594c = interfaceC5823d;
                this.f19596e.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f19595d) {
                long j2 = 0;
                do {
                    try {
                        return this.f19592a.test(t) && this.f19596e.tryOnNext(t);
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        try {
                            j2++;
                            i2 = a.f19591a[((EnumC4470a) C4601b.m18284a(this.f19593b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            cancel();
                            onError(new C4560a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: ParallelFilterTry.java */
    /* renamed from: g.a.y0.e.e.e$d */
    static final class d<T> extends b<T> {

        /* renamed from: e */
        final InterfaceC5822c<? super T> f19597e;

        d(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            super(interfaceC4587r, interfaceC4572c);
            this.f19597e = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19595d) {
                return;
            }
            this.f19595d = true;
            this.f19597e.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19595d) {
                C4476a.m17152b(th);
            } else {
                this.f19595d = true;
                this.f19597e.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19594c, interfaceC5823d)) {
                this.f19594c = interfaceC5823d;
                this.f19597e.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f19595d) {
                long j2 = 0;
                do {
                    try {
                        if (!this.f19592a.test(t)) {
                            return false;
                        }
                        this.f19597e.onNext(t);
                        return true;
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        try {
                            j2++;
                            i2 = a.f19591a[((EnumC4470a) C4601b.m18284a(this.f19593b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            cancel();
                            onError(new C4560a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    public C5049e(AbstractC4471b<T> abstractC4471b, InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        this.f19588a = abstractC4471b;
        this.f19589b = interfaceC4587r;
        this.f19590c = interfaceC4572c;
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
                    interfaceC5822cArr2[i2] = new c((InterfaceC4602a) interfaceC5822c, this.f19589b, this.f19590c);
                } else {
                    interfaceC5822cArr2[i2] = new d(interfaceC5822c, this.f19589b, this.f19590c);
                }
            }
            this.f19588a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19588a.mo16967a();
    }
}
