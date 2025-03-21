package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5182v;
import p324i.p338d.InterfaceC5823d;

/* compiled from: InnerQueuedSubscriber.java */
/* renamed from: g.a.y0.h.j */
/* loaded from: classes2.dex */
public final class C5139j<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InterfaceC5140k<T> parent;
    final int prefetch;
    long produced;
    volatile InterfaceC4616o<T> queue;

    public C5139j(InterfaceC5140k<T> interfaceC5140k, int i2) {
        this.parent = interfaceC5140k;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        EnumC5160j.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this, interfaceC5823d)) {
            if (interfaceC5823d instanceof InterfaceC4613l) {
                InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                int requestFusion = interfaceC4613l.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4613l;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4613l;
                    C5182v.m18650a(interfaceC5823d, this.prefetch);
                    return;
                }
            }
            this.queue = C5182v.m18646a(this.prefetch);
            C5182v.m18650a(interfaceC5823d, this.prefetch);
        }
    }

    public InterfaceC4616o<T> queue() {
        return this.queue;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        if (this.fusionMode != 1) {
            long j3 = this.produced + j2;
            if (j3 < this.limit) {
                this.produced = j3;
            } else {
                this.produced = 0L;
                get().request(j3);
            }
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j2 = this.produced + 1;
            if (j2 != this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}
