package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ResumeSingleObserver.java */
/* renamed from: g.a.y0.d.a0 */
/* loaded from: classes2.dex */
public final class C4618a0<T> implements InterfaceC4524n0<T> {

    /* renamed from: a */
    final AtomicReference<InterfaceC4552c> f17566a;

    /* renamed from: b */
    final InterfaceC4524n0<? super T> f17567b;

    public C4618a0(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f17566a = atomicReference;
        this.f17567b = interfaceC4524n0;
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(Throwable th) {
        this.f17567b.onError(th);
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.replace(this.f17566a, interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        this.f17567b.onSuccess(t);
    }
}
