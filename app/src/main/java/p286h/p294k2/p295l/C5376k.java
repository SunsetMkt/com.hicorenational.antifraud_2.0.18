package p286h.p294k2.p295l;

import bean.SurveyH5Bean;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.C5715y1;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p294k2.p295l.p297o.p298a.C5383b;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SequenceBuilder.kt */
/* renamed from: h.k2.l.k */
/* loaded from: classes2.dex */
final class C5376k<T> extends AbstractC5375j<T> implements Iterator<T>, InterfaceC5368c<C5715y1>, InterfaceC5569a {

    /* renamed from: a */
    private int f20253a;

    /* renamed from: b */
    private T f20254b;

    /* renamed from: c */
    private Iterator<? extends T> f20255c;

    /* renamed from: d */
    @InterfaceC5817e
    private InterfaceC5368c<? super C5715y1> f20256d;

    /* renamed from: c */
    private final Throwable m22060c() {
        int i2 = this.f20253a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f20253a);
    }

    /* renamed from: d */
    private final T m22061d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public final void m22062a(@InterfaceC5817e InterfaceC5368c<? super C5715y1> interfaceC5368c) {
        this.f20256d = interfaceC5368c;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public final InterfaceC5368c<C5715y1> m22064b() {
        return this.f20256d;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    @InterfaceC5816d
    public InterfaceC5370e getContext() {
        return C5372g.f20245b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i2 = this.f20253a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw m22060c();
                }
                Iterator<? extends T> it = this.f20255c;
                if (it == null) {
                    C5544i0.m22545f();
                }
                if (it.hasNext()) {
                    this.f20253a = 2;
                    return true;
                }
                this.f20255c = null;
            }
            this.f20253a = 5;
            InterfaceC5368c<? super C5715y1> interfaceC5368c = this.f20256d;
            if (interfaceC5368c == null) {
                C5544i0.m22545f();
            }
            this.f20256d = null;
            interfaceC5368c.resume(C5715y1.f20665a);
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i2 = this.f20253a;
        if (i2 == 0 || i2 == 1) {
            return m22061d();
        }
        if (i2 == 2) {
            this.f20253a = 1;
            Iterator<? extends T> it = this.f20255c;
            if (it == null) {
                C5544i0.m22545f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw m22060c();
        }
        this.f20253a = 0;
        T t = this.f20254b;
        this.f20254b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resumeWithException(@InterfaceC5816d Throwable th) {
        C5544i0.m22546f(th, "exception");
        throw th;
    }

    @Override // p286h.p294k2.p295l.AbstractC5375j
    @InterfaceC5817e
    /* renamed from: a */
    public Object mo22058a(T t, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c) {
        Object m22074b;
        this.f20254b = t;
        this.f20253a = 3;
        m22062a(C5383b.m22083a(interfaceC5368c));
        m22074b = C5380b.m22074b();
        return m22074b;
    }

    @Override // p286h.p294k2.p295l.AbstractC5375j
    @InterfaceC5817e
    /* renamed from: a */
    public Object mo22059a(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c) {
        Object m22074b;
        if (!it.hasNext()) {
            return C5715y1.f20665a;
        }
        this.f20255c = it;
        this.f20253a = 2;
        m22062a(C5383b.m22083a(interfaceC5368c));
        m22074b = C5380b.m22074b();
        return m22074b;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void resume(@InterfaceC5816d C5715y1 c5715y1) {
        C5544i0.m22546f(c5715y1, SurveyH5Bean.VALUE);
        this.f20253a = 4;
    }
}
