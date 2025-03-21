package p251g.p252a.p268y0.p280f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p284j.C5180t;

/* compiled from: SpscArrayQueue.java */
/* renamed from: g.a.y0.f.b */
/* loaded from: classes2.dex */
public final class C5110b<E> extends AtomicReferenceArray<E> implements InterfaceC4615n<E> {

    /* renamed from: a */
    private static final Integer f19828a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public C5110b(int i2) {
        super(C5180t.m18645b(i2));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i2 / 4, f19828a.intValue());
    }

    int calcElementOffset(long j2) {
        return this.mask & ((int) j2);
    }

    int calcElementOffset(long j2, int i2) {
        return ((int) j2) & i2;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    E lvElement(int i2) {
        return get(i2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i2 = this.mask;
        long j2 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j2, i2);
        if (j2 >= this.producerLookAhead) {
            long j3 = this.lookAheadStep + j2;
            if (lvElement(calcElementOffset(j3, i2)) == null) {
                this.producerLookAhead = j3;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e2);
        soProducerIndex(j2 + 1);
        return true;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4615n, p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public E poll() {
        long j2 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j2);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j2 + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    void soConsumerIndex(long j2) {
        this.consumerIndex.lazySet(j2);
    }

    void soElement(int i2, E e2) {
        lazySet(i2, e2);
    }

    void soProducerIndex(long j2) {
        this.producerIndex.lazySet(j2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
