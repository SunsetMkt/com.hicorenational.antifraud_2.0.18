package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableSubscribeOn.java */
/* renamed from: g.a.y0.e.a.i0 */
/* loaded from: classes2.dex */
public final class C4662i0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17691a;

    /* renamed from: b */
    final AbstractC4516j0 f17692b;

    /* compiled from: CompletableSubscribeOn.java */
    /* renamed from: g.a.y0.e.a.i0$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final InterfaceC4491f actual;
        final InterfaceC4513i source;
        final C4599k task = new C4599k();

        a(InterfaceC4491f interfaceC4491f, InterfaceC4513i interfaceC4513i) {
            this.actual = interfaceC4491f;
            this.source = interfaceC4513i;
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

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.mo17074a(this);
        }
    }

    public C4662i0(InterfaceC4513i interfaceC4513i, AbstractC4516j0 abstractC4516j0) {
        this.f17691a = interfaceC4513i;
        this.f17692b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f, this.f17691a);
        interfaceC4491f.onSubscribe(aVar);
        aVar.task.replace(this.f17692b.mo17407a(aVar));
    }
}
