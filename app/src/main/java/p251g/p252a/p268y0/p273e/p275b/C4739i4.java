package p251g.p252a.p268y0.p273e.p275b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5162b;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableToListSingle.java */
/* renamed from: g.a.y0.e.b.i4 */
/* loaded from: classes2.dex */
public final class C4739i4<T, U extends Collection<? super T>> extends AbstractC4518k0<U> implements InterfaceC4603b<U> {

    /* renamed from: a */
    final AbstractC4519l<T> f17958a;

    /* renamed from: b */
    final Callable<U> f17959b;

    /* compiled from: FlowableToListSingle.java */
    /* renamed from: g.a.y0.e.b.i4$a */
    static final class a<T, U extends Collection<? super T>> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super U> f17960a;

        /* renamed from: b */
        InterfaceC5823d f17961b;

        /* renamed from: c */
        U f17962c;

        a(InterfaceC4524n0<? super U> interfaceC4524n0, U u) {
            this.f17960a = interfaceC4524n0;
            this.f17962c = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17961b.cancel();
            this.f17961b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17961b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17961b = EnumC5160j.CANCELLED;
            this.f17960a.onSuccess(this.f17962c);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17962c = null;
            this.f17961b = EnumC5160j.CANCELLED;
            this.f17960a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f17962c.add(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17961b, interfaceC5823d)) {
                this.f17961b = interfaceC5823d;
                this.f17960a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4739i4(AbstractC4519l<T> abstractC4519l) {
        this(abstractC4519l, EnumC5162b.asCallable());
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super U> interfaceC4524n0) {
        try {
            this.f17958a.m17799a((InterfaceC4529q) new a(interfaceC4524n0, (Collection) C4601b.m18284a(this.f17959b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }

    public C4739i4(AbstractC4519l<T> abstractC4519l, Callable<U> callable) {
        this.f17958a = abstractC4519l;
        this.f17959b = callable;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<U> mo18286b() {
        return C4476a.m17129a(new C4733h4(this.f17958a, this.f17959b));
    }
}
