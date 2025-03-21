package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleSubscribeOn.java */
/* renamed from: g.a.y0.e.f.m0 */
/* loaded from: classes2.dex */
public final class C5086m0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19746a;

    /* renamed from: b */
    final AbstractC4516j0 f19747b;

    /* compiled from: SingleSubscribeOn.java */
    /* renamed from: g.a.y0.e.f.m0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final InterfaceC4524n0<? super T> actual;
        final InterfaceC4530q0<? extends T> source;
        final C4599k task = new C4599k();

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4530q0<? extends T> interfaceC4530q0) {
            this.actual = interfaceC4524n0;
            this.source = interfaceC4530q0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            this.task.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.mo17490a(this);
        }
    }

    public C5086m0(InterfaceC4530q0<? extends T> interfaceC4530q0, AbstractC4516j0 abstractC4516j0) {
        this.f19746a = interfaceC4530q0;
        this.f19747b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0, this.f19746a);
        interfaceC4524n0.onSubscribe(aVar);
        aVar.task.replace(this.f19747b.mo17407a(aVar));
    }
}
