package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.AbstractC4505a;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: BlockingFlowableMostRecent.java */
/* renamed from: g.a.y0.e.b.d */
/* loaded from: classes2.dex */
public final class C4704d<T> implements Iterable<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f17814a;

    /* renamed from: b */
    final T f17815b;

    /* compiled from: BlockingFlowableMostRecent.java */
    /* renamed from: g.a.y0.e.b.d$a */
    static final class a<T> extends AbstractC4505a<T> {

        /* renamed from: b */
        volatile Object f17816b;

        /* compiled from: BlockingFlowableMostRecent.java */
        /* renamed from: g.a.y0.e.b.d$a$a, reason: collision with other inner class name */
        final class C7389a implements Iterator<T> {

            /* renamed from: a */
            private Object f17817a;

            C7389a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f17817a = a.this.f17816b;
                return !EnumC5177q.isComplete(this.f17817a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f17817a == null) {
                        this.f17817a = a.this.f17816b;
                    }
                    if (EnumC5177q.isComplete(this.f17817a)) {
                        throw new NoSuchElementException();
                    }
                    if (EnumC5177q.isError(this.f17817a)) {
                        throw C5171k.m18626c(EnumC5177q.getError(this.f17817a));
                    }
                    return (T) EnumC5177q.getValue(this.f17817a);
                } finally {
                    this.f17817a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f17816b = EnumC5177q.next(t);
        }

        /* renamed from: c */
        public a<T>.C7389a m18314c() {
            return new C7389a();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17816b = EnumC5177q.complete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17816b = EnumC5177q.error(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f17816b = EnumC5177q.next(t);
        }
    }

    public C4704d(AbstractC4519l<T> abstractC4519l, T t) {
        this.f17814a = abstractC4519l;
        this.f17815b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f17815b);
        this.f17814a.m17799a((InterfaceC4529q) aVar);
        return aVar.m18314c();
    }
}
