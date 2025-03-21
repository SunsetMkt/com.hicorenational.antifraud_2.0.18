package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.Callable;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.AbstractC5136g;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelCollect.java */
/* renamed from: g.a.y0.e.e.a */
/* loaded from: classes2.dex */
public final class C5045a<T, C> extends AbstractC4471b<C> {

    /* renamed from: a */
    final AbstractC4471b<? extends T> f19560a;

    /* renamed from: b */
    final Callable<? extends C> f19561b;

    /* renamed from: c */
    final InterfaceC4571b<? super C, ? super T> f19562c;

    /* compiled from: ParallelCollect.java */
    /* renamed from: g.a.y0.e.e.a$a */
    static final class a<T, C> extends AbstractC5136g<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final InterfaceC4571b<? super C, ? super T> collector;
        boolean done;

        a(InterfaceC5822c<? super C> interfaceC5822c, C c2, InterfaceC4571b<? super C, ? super T> interfaceC4571b) {
            super(interfaceC5822c);
            this.collection = c2;
            this.collector = interfaceC4571b;
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
            C c2 = this.collection;
            this.collection = null;
            complete(c2);
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5136g, p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.collection = null;
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.mo18209a(this.collection, t);
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

    public C5045a(AbstractC4471b<? extends T> abstractC4471b, Callable<? extends C> callable, InterfaceC4571b<? super C, ? super T> interfaceC4571b) {
        this.f19560a = abstractC4471b;
        this.f19561b = callable;
        this.f19562c = interfaceC4571b;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super C>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super Object>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    interfaceC5822cArr2[i2] = new a(interfaceC5822cArr[i2], C4601b.m18284a(this.f19561b.call(), "The initialSupplier returned a null value"), this.f19562c);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    m18523a(interfaceC5822cArr, th);
                    return;
                }
            }
            this.f19560a.mo16994a(interfaceC5822cArr2);
        }
    }

    /* renamed from: a */
    void m18523a(InterfaceC5822c<?>[] interfaceC5822cArr, Throwable th) {
        for (InterfaceC5822c<?> interfaceC5822c : interfaceC5822cArr) {
            EnumC5157g.error(th, interfaceC5822c);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19560a.mo16967a();
    }
}
