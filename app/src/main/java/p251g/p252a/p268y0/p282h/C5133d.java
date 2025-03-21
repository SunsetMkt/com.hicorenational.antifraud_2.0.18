package p251g.p252a.p268y0.p282h;

import p251g.p252a.p255c1.C4476a;

/* compiled from: BlockingFirstSubscriber.java */
/* renamed from: g.a.y0.h.d */
/* loaded from: classes2.dex */
public final class C5133d<T> extends AbstractC5132c<T> {
    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f19958a == null) {
            this.f19959b = th;
        } else {
            C4476a.m17152b(th);
        }
        countDown();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f19958a == null) {
            this.f19958a = t;
            this.f19960c.cancel();
            countDown();
        }
    }
}
