package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.p253a1.AbstractC4455b;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: BlockingObservableMostRecent.java */
/* renamed from: g.a.y0.e.d.d */
/* loaded from: classes2.dex */
public final class C4925d<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18884a;

    /* renamed from: b */
    final T f18885b;

    /* compiled from: BlockingObservableMostRecent.java */
    /* renamed from: g.a.y0.e.d.d$a */
    static final class a<T> extends AbstractC4455b<T> {

        /* renamed from: b */
        volatile Object f18886b;

        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: g.a.y0.e.d.d$a$a, reason: collision with other inner class name */
        final class C7411a implements Iterator<T> {

            /* renamed from: a */
            private Object f18887a;

            C7411a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f18887a = a.this.f18886b;
                return !EnumC5177q.isComplete(this.f18887a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f18887a == null) {
                        this.f18887a = a.this.f18886b;
                    }
                    if (EnumC5177q.isComplete(this.f18887a)) {
                        throw new NoSuchElementException();
                    }
                    if (EnumC5177q.isError(this.f18887a)) {
                        throw C5171k.m18626c(EnumC5177q.getError(this.f18887a));
                    }
                    return (T) EnumC5177q.getValue(this.f18887a);
                } finally {
                    this.f18887a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f18886b = EnumC5177q.next(t);
        }

        /* renamed from: c */
        public a<T>.C7411a m18438c() {
            return new C7411a();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18886b = EnumC5177q.complete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18886b = EnumC5177q.error(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f18886b = EnumC5177q.next(t);
        }
    }

    public C4925d(InterfaceC4504g0<T> interfaceC4504g0, T t) {
        this.f18884a = interfaceC4504g0;
        this.f18885b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f18885b);
        this.f18884a.subscribe(aVar);
        return aVar.m18438c();
    }
}
