package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.AbstractC5148s;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableMapNotification.java */
/* renamed from: g.a.y0.e.b.z1 */
/* loaded from: classes2.dex */
public final class C4833z1<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends R> f18540c;

    /* renamed from: d */
    final InterfaceC4584o<? super Throwable, ? extends R> f18541d;

    /* renamed from: e */
    final Callable<? extends R> f18542e;

    /* compiled from: FlowableMapNotification.java */
    /* renamed from: g.a.y0.e.b.z1$a */
    static final class a<T, R> extends AbstractC5148s<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final InterfaceC4584o<? super Throwable, ? extends R> onErrorMapper;
        final InterfaceC4584o<? super T, ? extends R> onNextMapper;

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends R> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends R> interfaceC4584o2, Callable<? extends R> callable) {
            super(interfaceC5822c);
            this.onNextMapper = interfaceC4584o;
            this.onErrorMapper = interfaceC4584o2;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            try {
                complete(C4601b.m18284a(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            try {
                complete(C4601b.m18284a(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.actual.onError(new C4560a(th, th2));
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                Object m18284a = C4601b.m18284a(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.actual.onNext(m18284a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
            }
        }
    }

    public C4833z1(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends R> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends R> interfaceC4584o2, Callable<? extends R> callable) {
        super(abstractC4519l);
        this.f18540c = interfaceC4584o;
        this.f18541d = interfaceC4584o2;
        this.f18542e = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18540c, this.f18541d, this.f18542e));
    }
}
