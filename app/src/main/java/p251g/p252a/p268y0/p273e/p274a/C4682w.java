package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableHide.java */
/* renamed from: g.a.y0.e.a.w */
/* loaded from: classes2.dex */
public final class C4682w extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17749a;

    /* compiled from: CompletableHide.java */
    /* renamed from: g.a.y0.e.a.w$a */
    static final class a implements InterfaceC4491f, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f17750a;

        /* renamed from: b */
        InterfaceC4552c f17751b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17750a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17751b.dispose();
            this.f17751b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17751b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17750a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f17750a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f17751b, interfaceC4552c)) {
                this.f17751b = interfaceC4552c;
                this.f17750a.onSubscribe(this);
            }
        }
    }

    public C4682w(InterfaceC4513i interfaceC4513i) {
        this.f17749a = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17749a.mo17074a(new a(interfaceC4491f));
    }
}
