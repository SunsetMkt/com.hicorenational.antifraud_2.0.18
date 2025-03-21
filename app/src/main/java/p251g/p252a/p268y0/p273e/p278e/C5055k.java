package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p254b1.EnumC4470a;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelMapTry.java */
/* renamed from: g.a.y0.e.e.k */
/* loaded from: classes2.dex */
public final class C5055k<T, R> extends AbstractC4471b<R> {

    /* renamed from: a */
    final AbstractC4471b<T> f19624a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends R> f19625b;

    /* renamed from: c */
    final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19626c;

    /* compiled from: ParallelMapTry.java */
    /* renamed from: g.a.y0.e.e.k$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f19627a = new int[EnumC4470a.values().length];

        static {
            try {
                f19627a[EnumC4470a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19627a[EnumC4470a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19627a[EnumC4470a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelMapTry.java */
    /* renamed from: g.a.y0.e.e.k$b */
    static final class b<T, R> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC4602a<? super R> f19628a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f19629b;

        /* renamed from: c */
        final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19630c;

        /* renamed from: d */
        InterfaceC5823d f19631d;

        /* renamed from: e */
        boolean f19632e;

        b(InterfaceC4602a<? super R> interfaceC4602a, InterfaceC4584o<? super T, ? extends R> interfaceC4584o, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            this.f19628a = interfaceC4602a;
            this.f19629b = interfaceC4584o;
            this.f19630c = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19631d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19632e) {
                return;
            }
            this.f19632e = true;
            this.f19628a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19632e) {
                C4476a.m17152b(th);
            } else {
                this.f19632e = true;
                this.f19628a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f19632e) {
                return;
            }
            this.f19631d.request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19631d, interfaceC5823d)) {
                this.f19631d = interfaceC5823d;
                this.f19628a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19631d.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f19632e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    return this.f19628a.tryOnNext(C4601b.m18284a(this.f19629b.apply(t), "The mapper returned a null value"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    try {
                        j2++;
                        i2 = a.f19627a[((EnumC4470a) C4601b.m18284a(this.f19630c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        cancel();
                        onError(new C4560a(th, th2));
                        return false;
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
    }

    /* compiled from: ParallelMapTry.java */
    /* renamed from: g.a.y0.e.e.k$c */
    static final class c<T, R> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super R> f19633a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f19634b;

        /* renamed from: c */
        final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19635c;

        /* renamed from: d */
        InterfaceC5823d f19636d;

        /* renamed from: e */
        boolean f19637e;

        c(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends R> interfaceC4584o, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            this.f19633a = interfaceC5822c;
            this.f19634b = interfaceC4584o;
            this.f19635c = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19636d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19637e) {
                return;
            }
            this.f19637e = true;
            this.f19633a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19637e) {
                C4476a.m17152b(th);
            } else {
                this.f19637e = true;
                this.f19633a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f19637e) {
                return;
            }
            this.f19636d.request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19636d, interfaceC5823d)) {
                this.f19636d = interfaceC5823d;
                this.f19633a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19636d.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f19637e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f19633a.onNext(C4601b.m18284a(this.f19634b.apply(t), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    try {
                        j2++;
                        i2 = a.f19627a[((EnumC4470a) C4601b.m18284a(this.f19635c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        cancel();
                        onError(new C4560a(th, th2));
                        return false;
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
    }

    public C5055k(AbstractC4471b<T> abstractC4471b, InterfaceC4584o<? super T, ? extends R> interfaceC4584o, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        this.f19624a = abstractC4471b;
        this.f19625b = interfaceC4584o;
        this.f19626c = interfaceC4572c;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super R>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                InterfaceC5822c<? super R> interfaceC5822c = interfaceC5822cArr[i2];
                if (interfaceC5822c instanceof InterfaceC4602a) {
                    interfaceC5822cArr2[i2] = new b((InterfaceC4602a) interfaceC5822c, this.f19625b, this.f19626c);
                } else {
                    interfaceC5822cArr2[i2] = new c(interfaceC5822c, this.f19625b, this.f19626c);
                }
            }
            this.f19624a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19624a.mo16967a();
    }
}
