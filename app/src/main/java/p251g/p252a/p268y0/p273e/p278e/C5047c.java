package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p254b1.EnumC4470a;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelDoOnNextTry.java */
/* renamed from: g.a.y0.e.e.c */
/* loaded from: classes2.dex */
public final class C5047c<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final AbstractC4471b<T> f19567a;

    /* renamed from: b */
    final InterfaceC4576g<? super T> f19568b;

    /* renamed from: c */
    final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19569c;

    /* compiled from: ParallelDoOnNextTry.java */
    /* renamed from: g.a.y0.e.e.c$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f19570a = new int[EnumC4470a.values().length];

        static {
            try {
                f19570a[EnumC4470a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19570a[EnumC4470a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19570a[EnumC4470a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelDoOnNextTry.java */
    /* renamed from: g.a.y0.e.e.c$b */
    static final class b<T> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC4602a<? super T> f19571a;

        /* renamed from: b */
        final InterfaceC4576g<? super T> f19572b;

        /* renamed from: c */
        final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19573c;

        /* renamed from: d */
        InterfaceC5823d f19574d;

        /* renamed from: e */
        boolean f19575e;

        b(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            this.f19571a = interfaceC4602a;
            this.f19572b = interfaceC4576g;
            this.f19573c = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19574d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19575e) {
                return;
            }
            this.f19575e = true;
            this.f19571a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19575e) {
                C4476a.m17152b(th);
            } else {
                this.f19575e = true;
                this.f19571a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f19575e) {
                return;
            }
            this.f19574d.request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19574d, interfaceC5823d)) {
                this.f19574d = interfaceC5823d;
                this.f19571a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19574d.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f19575e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f19572b.accept(t);
                    return this.f19571a.tryOnNext(t);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    try {
                        j2++;
                        i2 = a.f19570a[((EnumC4470a) C4601b.m18284a(this.f19573c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    /* compiled from: ParallelDoOnNextTry.java */
    /* renamed from: g.a.y0.e.e.c$c */
    static final class c<T> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f19576a;

        /* renamed from: b */
        final InterfaceC4576g<? super T> f19577b;

        /* renamed from: c */
        final InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> f19578c;

        /* renamed from: d */
        InterfaceC5823d f19579d;

        /* renamed from: e */
        boolean f19580e;

        c(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
            this.f19576a = interfaceC5822c;
            this.f19577b = interfaceC4576g;
            this.f19578c = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19579d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19580e) {
                return;
            }
            this.f19580e = true;
            this.f19576a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19580e) {
                C4476a.m17152b(th);
            } else {
                this.f19580e = true;
                this.f19576a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f19579d.request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19579d, interfaceC5823d)) {
                this.f19579d = interfaceC5823d;
                this.f19576a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19579d.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f19580e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f19577b.accept(t);
                    this.f19576a.onNext(t);
                    return true;
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    try {
                        j2++;
                        i2 = a.f19570a[((EnumC4470a) C4601b.m18284a(this.f19578c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    public C5047c(AbstractC4471b<T> abstractC4471b, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        this.f19567a = abstractC4471b;
        this.f19568b = interfaceC4576g;
        this.f19569c = interfaceC4572c;
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
                    interfaceC5822cArr2[i2] = new b((InterfaceC4602a) interfaceC5822c, this.f19568b, this.f19569c);
                } else {
                    interfaceC5822cArr2[i2] = new c(interfaceC5822c, this.f19568b, this.f19569c);
                }
            }
            this.f19567a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19567a.mo16967a();
    }
}
