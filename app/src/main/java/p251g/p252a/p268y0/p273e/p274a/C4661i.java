package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableDetach.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.a.i */
/* loaded from: classes2.dex */
public final class C4661i extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17688a;

    /* compiled from: CompletableDetach.java */
    /* renamed from: g.a.y0.e.a.i$a */
    static final class a implements InterfaceC4491f, InterfaceC4552c {

        /* renamed from: a */
        InterfaceC4491f f17689a;

        /* renamed from: b */
        InterfaceC4552c f17690b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17689a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17689a = null;
            this.f17690b.dispose();
            this.f17690b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17690b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17690b = EnumC4592d.DISPOSED;
            InterfaceC4491f interfaceC4491f = this.f17689a;
            if (interfaceC4491f != null) {
                this.f17689a = null;
                interfaceC4491f.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f17690b = EnumC4592d.DISPOSED;
            InterfaceC4491f interfaceC4491f = this.f17689a;
            if (interfaceC4491f != null) {
                this.f17689a = null;
                interfaceC4491f.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f17690b, interfaceC4552c)) {
                this.f17690b = interfaceC4552c;
                this.f17689a.onSubscribe(this);
            }
        }
    }

    public C4661i(InterfaceC4513i interfaceC4513i) {
        this.f17688a = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17688a.mo17074a(new a(interfaceC4491f));
    }
}
