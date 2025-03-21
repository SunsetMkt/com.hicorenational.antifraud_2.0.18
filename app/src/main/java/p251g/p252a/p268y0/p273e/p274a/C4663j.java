package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableDisposeOn.java */
/* renamed from: g.a.y0.e.a.j */
/* loaded from: classes2.dex */
public final class C4663j extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17693a;

    /* renamed from: b */
    final AbstractC4516j0 f17694b;

    /* compiled from: CompletableDisposeOn.java */
    /* renamed from: g.a.y0.e.a.j$a */
    static final class a implements InterfaceC4491f, InterfaceC4552c, Runnable {

        /* renamed from: a */
        final InterfaceC4491f f17695a;

        /* renamed from: b */
        final AbstractC4516j0 f17696b;

        /* renamed from: c */
        InterfaceC4552c f17697c;

        /* renamed from: d */
        volatile boolean f17698d;

        a(InterfaceC4491f interfaceC4491f, AbstractC4516j0 abstractC4516j0) {
            this.f17695a = interfaceC4491f;
            this.f17696b = abstractC4516j0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17698d = true;
            this.f17696b.mo17407a(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17698d;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (this.f17698d) {
                return;
            }
            this.f17695a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            if (this.f17698d) {
                C4476a.m17152b(th);
            } else {
                this.f17695a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f17697c, interfaceC4552c)) {
                this.f17697c = interfaceC4552c;
                this.f17695a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17697c.dispose();
            this.f17697c = EnumC4592d.DISPOSED;
        }
    }

    public C4663j(InterfaceC4513i interfaceC4513i, AbstractC4516j0 abstractC4516j0) {
        this.f17693a = interfaceC4513i;
        this.f17694b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17693a.mo17074a(new a(interfaceC4491f, this.f17694b));
    }
}
