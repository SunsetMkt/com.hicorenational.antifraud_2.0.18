package p286h.p321x2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.C5475q0;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.p294k2.C5363i;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p300m.C5397d;
import p286h.p294k2.p301n.p302a.C5405h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SequenceBuilder.kt */
/* renamed from: h.x2.n */
/* loaded from: classes2.dex */
final class C5700n<T> extends AbstractC5701o<T> implements Iterator<T>, InterfaceC5358d<C5715y1>, InterfaceC5569a {

    /* renamed from: a */
    private int f20605a;

    /* renamed from: b */
    private T f20606b;

    /* renamed from: c */
    private Iterator<? extends T> f20607c;

    /* renamed from: d */
    @InterfaceC5817e
    private InterfaceC5358d<? super C5715y1> f20608d;

    /* renamed from: c */
    private final Throwable m23329c() {
        int i2 = this.f20605a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f20605a);
    }

    /* renamed from: d */
    private final T m23330d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public final void m23333a(@InterfaceC5817e InterfaceC5358d<? super C5715y1> interfaceC5358d) {
        this.f20608d = interfaceC5358d;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public final InterfaceC5358d<C5715y1> m23334b() {
        return this.f20608d;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        return C5363i.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i2 = this.f20605a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw m23329c();
                }
                Iterator<? extends T> it = this.f20607c;
                if (it == null) {
                    C5544i0.m22545f();
                }
                if (it.hasNext()) {
                    this.f20605a = 2;
                    return true;
                }
                this.f20607c = null;
            }
            this.f20605a = 5;
            InterfaceC5358d<? super C5715y1> interfaceC5358d = this.f20608d;
            if (interfaceC5358d == null) {
                C5544i0.m22545f();
            }
            this.f20608d = null;
            C5715y1 c5715y1 = C5715y1.f20665a;
            C5475q0.a aVar = C5475q0.Companion;
            interfaceC5358d.resumeWith(C5475q0.m26855constructorimpl(c5715y1));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i2 = this.f20605a;
        if (i2 == 0 || i2 == 1) {
            return m23330d();
        }
        if (i2 == 2) {
            this.f20605a = 1;
            Iterator<? extends T> it = this.f20607c;
            if (it == null) {
                C5544i0.m22545f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw m23329c();
        }
        this.f20605a = 0;
        T t = this.f20606b;
        this.f20606b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public void resumeWith(@InterfaceC5816d Object obj) {
        C5597r0.m22717b(obj);
        this.f20605a = 4;
    }

    @Override // p286h.p321x2.AbstractC5701o
    @InterfaceC5817e
    /* renamed from: a */
    public Object mo23331a(T t, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d) {
        Object m22117b;
        Object m22117b2;
        Object m22117b3;
        this.f20606b = t;
        this.f20605a = 3;
        this.f20608d = interfaceC5358d;
        m22117b = C5397d.m22117b();
        m22117b2 = C5397d.m22117b();
        if (m22117b == m22117b2) {
            C5405h.m22142c(interfaceC5358d);
        }
        m22117b3 = C5397d.m22117b();
        return m22117b == m22117b3 ? m22117b : C5715y1.f20665a;
    }

    @Override // p286h.p321x2.AbstractC5701o
    @InterfaceC5817e
    /* renamed from: a */
    public Object mo23332a(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d) {
        Object m22117b;
        Object m22117b2;
        Object m22117b3;
        if (!it.hasNext()) {
            return C5715y1.f20665a;
        }
        this.f20607c = it;
        this.f20605a = 2;
        this.f20608d = interfaceC5358d;
        m22117b = C5397d.m22117b();
        m22117b2 = C5397d.m22117b();
        if (m22117b == m22117b2) {
            C5405h.m22142c(interfaceC5358d);
        }
        m22117b3 = C5397d.m22117b();
        return m22117b == m22117b3 ? m22117b : C5715y1.f20665a;
    }
}
