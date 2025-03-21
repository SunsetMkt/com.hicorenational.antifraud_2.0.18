package p251g.p252a.p268y0.p272d;

/* compiled from: BlockingLastObserver.java */
/* renamed from: g.a.y0.d.g */
/* loaded from: classes2.dex */
public final class C4625g<T> extends AbstractC4623e<T> {
    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        this.f17570a = null;
        this.f17571b = th;
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        this.f17570a = t;
    }
}
