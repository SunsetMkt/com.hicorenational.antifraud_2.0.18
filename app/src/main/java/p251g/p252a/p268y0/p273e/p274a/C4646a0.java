package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: CompletableMergeDelayErrorArray.java */
/* renamed from: g.a.y0.e.a.a0 */
/* loaded from: classes2.dex */
public final class C4646a0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i[] f17632a;

    /* compiled from: CompletableMergeDelayErrorArray.java */
    /* renamed from: g.a.y0.e.a.a0$a */
    static final class a implements InterfaceC4491f {

        /* renamed from: a */
        final InterfaceC4491f f17633a;

        /* renamed from: b */
        final C4551b f17634b;

        /* renamed from: c */
        final C5163c f17635c;

        /* renamed from: d */
        final AtomicInteger f17636d;

        a(InterfaceC4491f interfaceC4491f, C4551b c4551b, C5163c c5163c, AtomicInteger atomicInteger) {
            this.f17633a = interfaceC4491f;
            this.f17634b = c4551b;
            this.f17635c = c5163c;
            this.f17636d = atomicInteger;
        }

        /* renamed from: a */
        void m18309a() {
            if (this.f17636d.decrementAndGet() == 0) {
                Throwable terminate = this.f17635c.terminate();
                if (terminate == null) {
                    this.f17633a.onComplete();
                } else {
                    this.f17633a.onError(terminate);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            m18309a();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            if (this.f17635c.addThrowable(th)) {
                m18309a();
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17634b.mo18181b(interfaceC4552c);
        }
    }

    public C4646a0(InterfaceC4513i[] interfaceC4513iArr) {
        this.f17632a = interfaceC4513iArr;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4551b c4551b = new C4551b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f17632a.length + 1);
        C5163c c5163c = new C5163c();
        interfaceC4491f.onSubscribe(c4551b);
        for (InterfaceC4513i interfaceC4513i : this.f17632a) {
            if (c4551b.isDisposed()) {
                return;
            }
            if (interfaceC4513i == null) {
                c5163c.addThrowable(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                interfaceC4513i.mo17074a(new a(interfaceC4491f, c4551b, c5163c, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable terminate = c5163c.terminate();
            if (terminate == null) {
                interfaceC4491f.onComplete();
            } else {
                interfaceC4491f.onError(terminate);
            }
        }
    }
}
