package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lkotlin/sequences/DropWhileSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class f<T> implements m<T> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i.q2.s.l<T, Boolean> f12348b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12349b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @j.c.a.e
        private T f12350c;

        a() {
            this.a = f.this.a.iterator();
        }

        private final void e() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (!((Boolean) f.this.f12348b.invoke(next)).booleanValue()) {
                    this.f12350c = next;
                    this.f12349b = 1;
                    return;
                }
            }
            this.f12349b = 0;
        }

        public final void a(int i2) {
            this.f12349b = i2;
        }

        public final int b() {
            return this.f12349b;
        }

        @j.c.a.d
        public final Iterator<T> c() {
            return this.a;
        }

        @j.c.a.e
        public final T d() {
            return this.f12350c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12349b == -1) {
                e();
            }
            return this.f12349b == 1 || this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12349b == -1) {
                e();
            }
            if (this.f12349b != 1) {
                return this.a.next();
            }
            T t = this.f12350c;
            this.f12350c = null;
            this.f12349b = 0;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@j.c.a.e T t) {
            this.f12350c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@j.c.a.d m<? extends T> mVar, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "predicate");
        this.a = mVar;
        this.f12348b = lVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}
