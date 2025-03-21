package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p284j.C5182v;

/* compiled from: InnerQueuedObserver.java */
/* renamed from: g.a.y0.d.t */
/* loaded from: classes2.dex */
public final class C4638t<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final InterfaceC4639u<T> parent;
    final int prefetch;
    InterfaceC4616o<T> queue;

    public C4638t(InterfaceC4639u<T> interfaceC4639u, int i2) {
        this.parent = interfaceC4639u;
        this.prefetch = i2;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC4592d.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.setOnce(this, interfaceC4552c)) {
            if (interfaceC4552c instanceof InterfaceC4611j) {
                InterfaceC4611j interfaceC4611j = (InterfaceC4611j) interfaceC4552c;
                int requestFusion = interfaceC4611j.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4611j;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4611j;
                    return;
                }
            }
            this.queue = C5182v.m18646a(-this.prefetch);
        }
    }

    public InterfaceC4616o<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
