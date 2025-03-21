package p251g.p252a.p268y0.p272d;

/* compiled from: InnerQueuedObserverSupport.java */
/* renamed from: g.a.y0.d.u */
/* loaded from: classes2.dex */
public interface InterfaceC4639u<T> {
    void drain();

    void innerComplete(C4638t<T> c4638t);

    void innerError(C4638t<T> c4638t, Throwable th);

    void innerNext(C4638t<T> c4638t, T t);
}
