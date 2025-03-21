package p251g.p252a.p268y0.p284j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable.java */
/* renamed from: g.a.y0.j.c */
/* loaded from: classes2.dex */
public final class C5163c extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return C5171k.m18624a(this, th);
    }

    public boolean isTerminated() {
        return get() == C5171k.f20031a;
    }

    public Throwable terminate() {
        return C5171k.m18622a(this);
    }
}
