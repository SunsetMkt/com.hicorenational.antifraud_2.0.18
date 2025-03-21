package p251g.p252a.p268y0.p284j;

import java.util.concurrent.CountDownLatch;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;

/* compiled from: BlockingIgnoringReceiver.java */
/* renamed from: g.a.y0.j.f */
/* loaded from: classes2.dex */
public final class C5166f extends CountDownLatch implements InterfaceC4576g<Throwable>, InterfaceC4570a {

    /* renamed from: a */
    public Throwable f20027a;

    public C5166f() {
        super(1);
    }

    @Override // p251g.p252a.p267x0.InterfaceC4576g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.f20027a = th;
        countDown();
    }

    @Override // p251g.p252a.p267x0.InterfaceC4570a
    public void run() {
        countDown();
    }
}
