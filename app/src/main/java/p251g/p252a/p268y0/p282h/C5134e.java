package p251g.p252a.p268y0.p282h;

/* compiled from: BlockingLastSubscriber.java */
/* renamed from: g.a.y0.h.e */
/* loaded from: classes2.dex */
public final class C5134e<T> extends AbstractC5132c<T> {
    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        this.f19958a = null;
        this.f19959b = th;
        countDown();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        this.f19958a = t;
    }
}
