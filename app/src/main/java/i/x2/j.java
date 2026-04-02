package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.e1;
import i.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/GeneratorSequence;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
final class j<T> implements m<T> {
    private final i.q2.s.a<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i.q2.s.l<T, T> f12361b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i.q2.t.q1.a {

        @j.c.a.e
        private T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12362b = -2;

        a() {
        }

        private final void d() {
            T t;
            if (this.f12362b == -2) {
                t = (T) j.this.a.invoke();
            } else {
                i.q2.s.l lVar = j.this.f12361b;
                T t2 = this.a;
                if (t2 == null) {
                    i0.f();
                }
                t = (T) lVar.invoke(t2);
            }
            this.a = t;
            this.f12362b = this.a == null ? 0 : 1;
        }

        public final void a(int i2) {
            this.f12362b = i2;
        }

        @j.c.a.e
        public final T b() {
            return this.a;
        }

        public final int c() {
            return this.f12362b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12362b < 0) {
                d();
            }
            return this.f12362b == 1;
        }

        @Override // java.util.Iterator
        @j.c.a.d
        public T next() {
            if (this.f12362b < 0) {
                d();
            }
            if (this.f12362b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.a;
            if (t == null) {
                throw new e1("null cannot be cast to non-null type T");
            }
            this.f12362b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@j.c.a.e T t) {
            this.a = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@j.c.a.d i.q2.s.a<? extends T> aVar, @j.c.a.d i.q2.s.l<? super T, ? extends T> lVar) {
        i0.f(aVar, "getInitialValue");
        i0.f(lVar, "getNextValue");
        this.a = aVar;
        this.f12361b = lVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}
