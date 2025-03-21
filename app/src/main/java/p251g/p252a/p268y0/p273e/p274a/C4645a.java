package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: CompletableAmb.java */
/* renamed from: g.a.y0.e.a.a */
/* loaded from: classes2.dex */
public final class C4645a extends AbstractC4474c {

    /* renamed from: a */
    private final InterfaceC4513i[] f17627a;

    /* renamed from: b */
    private final Iterable<? extends InterfaceC4513i> f17628b;

    /* compiled from: CompletableAmb.java */
    /* renamed from: g.a.y0.e.a.a$a */
    static final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final AtomicBoolean f17629a;

        /* renamed from: b */
        private final C4551b f17630b;

        /* renamed from: c */
        private final InterfaceC4491f f17631c;

        a(AtomicBoolean atomicBoolean, C4551b c4551b, InterfaceC4491f interfaceC4491f) {
            this.f17629a = atomicBoolean;
            this.f17630b = c4551b;
            this.f17631c = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (this.f17629a.compareAndSet(false, true)) {
                this.f17630b.dispose();
                this.f17631c.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            if (!this.f17629a.compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                this.f17630b.dispose();
                this.f17631c.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17630b.mo18181b(interfaceC4552c);
        }
    }

    public C4645a(InterfaceC4513i[] interfaceC4513iArr, Iterable<? extends InterfaceC4513i> iterable) {
        this.f17627a = interfaceC4513iArr;
        this.f17628b = iterable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        int length;
        InterfaceC4513i[] interfaceC4513iArr = this.f17627a;
        if (interfaceC4513iArr == null) {
            interfaceC4513iArr = new InterfaceC4513i[8];
            try {
                length = 0;
                for (InterfaceC4513i interfaceC4513i : this.f17628b) {
                    if (interfaceC4513i == null) {
                        EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4491f);
                        return;
                    }
                    if (length == interfaceC4513iArr.length) {
                        InterfaceC4513i[] interfaceC4513iArr2 = new InterfaceC4513i[(length >> 2) + length];
                        System.arraycopy(interfaceC4513iArr, 0, interfaceC4513iArr2, 0, length);
                        interfaceC4513iArr = interfaceC4513iArr2;
                    }
                    int i2 = length + 1;
                    interfaceC4513iArr[length] = interfaceC4513i;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4491f);
                return;
            }
        } else {
            length = interfaceC4513iArr.length;
        }
        C4551b c4551b = new C4551b();
        interfaceC4491f.onSubscribe(c4551b);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar = new a(atomicBoolean, c4551b, interfaceC4491f);
        for (int i3 = 0; i3 < length; i3++) {
            InterfaceC4513i interfaceC4513i2 = interfaceC4513iArr[i3];
            if (c4551b.isDisposed()) {
                return;
            }
            if (interfaceC4513i2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    C4476a.m17152b(nullPointerException);
                    return;
                } else {
                    c4551b.dispose();
                    interfaceC4491f.onError(nullPointerException);
                    return;
                }
            }
            interfaceC4513i2.mo17074a(aVar);
        }
        if (length == 0) {
            interfaceC4491f.onComplete();
        }
    }
}
