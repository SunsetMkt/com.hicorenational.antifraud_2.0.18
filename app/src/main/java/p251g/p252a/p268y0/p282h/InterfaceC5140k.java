package p251g.p252a.p268y0.p282h;

/* compiled from: InnerQueuedSubscriberSupport.java */
/* renamed from: g.a.y0.h.k */
/* loaded from: classes2.dex */
public interface InterfaceC5140k<T> {
    void drain();

    void innerComplete(C5139j<T> c5139j);

    void innerError(C5139j<T> c5139j, Throwable th);

    void innerNext(C5139j<T> c5139j, T t);
}
