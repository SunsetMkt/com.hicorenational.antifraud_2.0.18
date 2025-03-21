package p251g.p252a.p268y0.p273e.p275b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableToList.java */
/* renamed from: g.a.y0.e.b.h4 */
/* loaded from: classes2.dex */
public final class C4733h4<T, U extends Collection<? super T>> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final Callable<U> f17949c;

    /* compiled from: FlowableToList.java */
    /* renamed from: g.a.y0.e.b.h4$a */
    static final class a<T, U extends Collection<? super T>> extends C5156f<U> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -8134157938864266736L;

        /* renamed from: s */
        InterfaceC5823d f17950s;

        /* JADX WARN: Multi-variable type inference failed */
        a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            super(interfaceC5822c);
            this.value = u;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f17950s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            complete(this.value);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17950s, interfaceC5823d)) {
                this.f17950s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4733h4(AbstractC4519l<T> abstractC4519l, Callable<U> callable) {
        super(abstractC4519l);
        this.f17949c = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        try {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, (Collection) C4601b.m18284a(this.f17949c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
