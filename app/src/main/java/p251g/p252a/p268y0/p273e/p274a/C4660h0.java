package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: CompletableResumeNext.java */
/* renamed from: g.a.y0.e.a.h0 */
/* loaded from: classes2.dex */
public final class C4660h0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17682a;

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC4513i> f17683b;

    /* compiled from: CompletableResumeNext.java */
    /* renamed from: g.a.y0.e.a.h0$a */
    final class a implements InterfaceC4491f {

        /* renamed from: a */
        final InterfaceC4491f f17684a;

        /* renamed from: b */
        final C4599k f17685b;

        /* compiled from: CompletableResumeNext.java */
        /* renamed from: g.a.y0.e.a.h0$a$a, reason: collision with other inner class name */
        final class C7385a implements InterfaceC4491f {
            C7385a() {
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                a.this.f17684a.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                a.this.f17684a.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                a.this.f17685b.update(interfaceC4552c);
            }
        }

        a(InterfaceC4491f interfaceC4491f, C4599k c4599k) {
            this.f17684a = interfaceC4491f;
            this.f17685b = c4599k;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17684a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            try {
                InterfaceC4513i apply = C4660h0.this.f17683b.apply(th);
                if (apply != null) {
                    apply.mo17074a(new C7385a());
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                nullPointerException.initCause(th);
                this.f17684a.onError(nullPointerException);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f17684a.onError(new C4560a(th2, th));
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17685b.update(interfaceC4552c);
        }
    }

    public C4660h0(InterfaceC4513i interfaceC4513i, InterfaceC4584o<? super Throwable, ? extends InterfaceC4513i> interfaceC4584o) {
        this.f17682a = interfaceC4513i;
        this.f17683b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4599k c4599k = new C4599k();
        interfaceC4491f.onSubscribe(c4599k);
        this.f17682a.mo17074a(new a(interfaceC4491f, c4599k));
    }
}
