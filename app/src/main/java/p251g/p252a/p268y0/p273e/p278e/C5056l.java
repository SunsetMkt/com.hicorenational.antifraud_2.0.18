package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4586q;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelPeek.java */
/* renamed from: g.a.y0.e.e.l */
/* loaded from: classes2.dex */
public final class C5056l<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final AbstractC4471b<T> f19638a;

    /* renamed from: b */
    final InterfaceC4576g<? super T> f19639b;

    /* renamed from: c */
    final InterfaceC4576g<? super T> f19640c;

    /* renamed from: d */
    final InterfaceC4576g<? super Throwable> f19641d;

    /* renamed from: e */
    final InterfaceC4570a f19642e;

    /* renamed from: f */
    final InterfaceC4570a f19643f;

    /* renamed from: g */
    final InterfaceC4576g<? super InterfaceC5823d> f19644g;

    /* renamed from: h */
    final InterfaceC4586q f19645h;

    /* renamed from: i */
    final InterfaceC4570a f19646i;

    /* compiled from: ParallelPeek.java */
    /* renamed from: g.a.y0.e.e.l$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f19647a;

        /* renamed from: b */
        final C5056l<T> f19648b;

        /* renamed from: c */
        InterfaceC5823d f19649c;

        /* renamed from: d */
        boolean f19650d;

        a(InterfaceC5822c<? super T> interfaceC5822c, C5056l<T> c5056l) {
            this.f19647a = interfaceC5822c;
            this.f19648b = c5056l;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            try {
                this.f19648b.f19646i.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f19649c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19650d) {
                return;
            }
            this.f19650d = true;
            try {
                this.f19648b.f19642e.run();
                this.f19647a.onComplete();
                try {
                    this.f19648b.f19643f.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19647a.onError(th2);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19650d) {
                C4476a.m17152b(th);
                return;
            }
            this.f19650d = true;
            try {
                this.f19648b.f19641d.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f19647a.onError(th);
            try {
                this.f19648b.f19643f.run();
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(th3);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19650d) {
                return;
            }
            try {
                this.f19648b.f19639b.accept(t);
                this.f19647a.onNext(t);
                try {
                    this.f19648b.f19640c.accept(t);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                onError(th2);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19649c, interfaceC5823d)) {
                this.f19649c = interfaceC5823d;
                try {
                    this.f19648b.f19644g.accept(interfaceC5823d);
                    this.f19647a.onSubscribe(this);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    interfaceC5823d.cancel();
                    this.f19647a.onSubscribe(EnumC5157g.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            try {
                this.f19648b.f19645h.mo18219a(j2);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f19649c.request(j2);
        }
    }

    public C5056l(AbstractC4471b<T> abstractC4471b, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super T> interfaceC4576g2, InterfaceC4576g<? super Throwable> interfaceC4576g3, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2, InterfaceC4576g<? super InterfaceC5823d> interfaceC4576g4, InterfaceC4586q interfaceC4586q, InterfaceC4570a interfaceC4570a3) {
        this.f19638a = abstractC4471b;
        this.f19639b = (InterfaceC4576g) C4601b.m18284a(interfaceC4576g, "onNext is null");
        this.f19640c = (InterfaceC4576g) C4601b.m18284a(interfaceC4576g2, "onAfterNext is null");
        this.f19641d = (InterfaceC4576g) C4601b.m18284a(interfaceC4576g3, "onError is null");
        this.f19642e = (InterfaceC4570a) C4601b.m18284a(interfaceC4570a, "onComplete is null");
        this.f19643f = (InterfaceC4570a) C4601b.m18284a(interfaceC4570a2, "onAfterTerminated is null");
        this.f19644g = (InterfaceC4576g) C4601b.m18284a(interfaceC4576g4, "onSubscribe is null");
        this.f19645h = (InterfaceC4586q) C4601b.m18284a(interfaceC4586q, "onRequest is null");
        this.f19646i = (InterfaceC4570a) C4601b.m18284a(interfaceC4570a3, "onCancel is null");
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super T>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                interfaceC5822cArr2[i2] = new a(interfaceC5822cArr[i2], this);
            }
            this.f19638a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19638a.mo16967a();
    }
}
