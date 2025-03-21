package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SinglePostCompleteSubscriber.java */
/* renamed from: g.a.y0.h.s */
/* loaded from: classes2.dex */
public abstract class AbstractC5148s<T, R> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final InterfaceC5822c<? super R> actual;
    protected long produced;

    /* renamed from: s */
    protected InterfaceC5823d f20018s;
    protected R value;

    public AbstractC5148s(InterfaceC5822c<? super R> interfaceC5822c) {
        this.actual = interfaceC5822c;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        this.f20018s.cancel();
    }

    protected final void complete(R r) {
        long j2 = this.produced;
        if (j2 != 0) {
            C5164d.m18610c(this, j2);
        }
        while (true) {
            long j3 = get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            }
            if ((j3 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r);
                this.actual.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    protected void onDrop(R r) {
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f20018s, interfaceC5823d)) {
            this.f20018s = interfaceC5823d;
            this.actual.onSubscribe(this);
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public final void request(long j2) {
        long j3;
        if (EnumC5160j.validate(j2)) {
            do {
                j3 = get();
                if ((j3 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.onNext(this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j3, C5164d.m18606a(j3, j2)));
            this.f20018s.request(j2);
        }
    }
}
