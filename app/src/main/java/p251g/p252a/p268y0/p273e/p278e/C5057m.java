package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.Callable;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.AbstractC5136g;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelReduce.java */
/* renamed from: g.a.y0.e.e.m */
/* loaded from: classes2.dex */
public final class C5057m<T, R> extends AbstractC4471b<R> {

    /* renamed from: a */
    final AbstractC4471b<? extends T> f19651a;

    /* renamed from: b */
    final Callable<R> f19652b;

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f19653c;

    /* compiled from: ParallelReduce.java */
    /* renamed from: g.a.y0.e.e.m$a */
    static final class a<T, R> extends AbstractC5136g<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final InterfaceC4572c<R, ? super T, R> reducer;

        a(InterfaceC5822c<? super R> interfaceC5822c, R r, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
            super(interfaceC5822c);
            this.accumulator = r;
            this.reducer = interfaceC4572c;
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5136g, p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f19962s.cancel();
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5136g, p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5136g, p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) C4601b.m18284a(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5136g, p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19962s, interfaceC5823d)) {
                this.f19962s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C5057m(AbstractC4471b<? extends T> abstractC4471b, Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        this.f19651a = abstractC4471b;
        this.f19652b = callable;
        this.f19653c = interfaceC4572c;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super R>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super Object>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    interfaceC5822cArr2[i2] = new a(interfaceC5822cArr[i2], C4601b.m18284a(this.f19652b.call(), "The initialSupplier returned a null value"), this.f19653c);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    m18524a(interfaceC5822cArr, th);
                    return;
                }
            }
            this.f19651a.mo16994a(interfaceC5822cArr2);
        }
    }

    /* renamed from: a */
    void m18524a(InterfaceC5822c<?>[] interfaceC5822cArr, Throwable th) {
        for (InterfaceC5822c<?> interfaceC5822c : interfaceC5822cArr) {
            EnumC5157g.error(th, interfaceC5822c);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19651a.mo16967a();
    }
}
