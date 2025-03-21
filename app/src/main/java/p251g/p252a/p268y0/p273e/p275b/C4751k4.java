package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableUsing.java */
/* renamed from: g.a.y0.e.b.k4 */
/* loaded from: classes2.dex */
public final class C4751k4<T, D> extends AbstractC4519l<T> {

    /* renamed from: b */
    final Callable<? extends D> f18007b;

    /* renamed from: c */
    final InterfaceC4584o<? super D, ? extends InterfaceC5821b<? extends T>> f18008c;

    /* renamed from: d */
    final InterfaceC4576g<? super D> f18009d;

    /* renamed from: e */
    final boolean f18010e;

    /* compiled from: FlowableUsing.java */
    /* renamed from: g.a.y0.e.b.k4$a */
    static final class a<T, D> extends AtomicBoolean implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 5904473792286235046L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4576g<? super D> disposer;
        final boolean eager;
        final D resource;

        /* renamed from: s */
        InterfaceC5823d f18011s;

        a(InterfaceC5822c<? super T> interfaceC5822c, D d2, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
            this.actual = interfaceC5822c;
            this.resource = d2;
            this.disposer = interfaceC4576g;
            this.eager = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            disposeAfter();
            this.f18011s.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.f18011s.cancel();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.f18011s.cancel();
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.f18011s.cancel();
                disposeAfter();
                return;
            }
            Throwable th2 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    th2 = th3;
                    C4561b.m18199b(th2);
                }
            }
            this.f18011s.cancel();
            if (th2 != null) {
                this.actual.onError(new C4560a(th, th2));
            } else {
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18011s, interfaceC5823d)) {
                this.f18011s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18011s.request(j2);
        }
    }

    public C4751k4(Callable<? extends D> callable, InterfaceC4584o<? super D, ? extends InterfaceC5821b<? extends T>> interfaceC4584o, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
        this.f18007b = callable;
        this.f18008c = interfaceC4584o;
        this.f18009d = interfaceC4576g;
        this.f18010e = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            D call = this.f18007b.call();
            try {
                ((InterfaceC5821b) C4601b.m18284a(this.f18008c.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new a(interfaceC5822c, call, this.f18009d, this.f18010e));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                try {
                    this.f18009d.accept(call);
                    EnumC5157g.error(th, interfaceC5822c);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    EnumC5157g.error(new C4560a(th, th2), interfaceC5822c);
                }
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            EnumC5157g.error(th3, interfaceC5822c);
        }
    }
}
