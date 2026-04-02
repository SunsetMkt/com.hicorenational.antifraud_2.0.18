package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/FilteringSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class h<T> implements m<T> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i.q2.s.l<T, Boolean> f12353c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12354b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @j.c.a.e
        private T f12355c;

        a() {
            this.a = h.this.a.iterator();
        }

        private final void e() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) h.this.f12353c.invoke(next)).booleanValue() == h.this.f12352b) {
                    this.f12355c = next;
                    this.f12354b = 1;
                    return;
                }
            }
            this.f12354b = 0;
        }

        public final void a(int i2) {
            this.f12354b = i2;
        }

        @j.c.a.d
        public final Iterator<T> b() {
            return this.a;
        }

        @j.c.a.e
        public final T c() {
            return this.f12355c;
        }

        public final int d() {
            return this.f12354b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12354b == -1) {
                e();
            }
            return this.f12354b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12354b == -1) {
                e();
            }
            if (this.f12354b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f12355c;
            this.f12355c = null;
            this.f12354b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@j.c.a.e T t) {
            this.f12355c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@j.c.a.d m<? extends T> mVar, boolean z, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "predicate");
        this.a = mVar;
        this.f12352b = z;
        this.f12353c = lVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    public /* synthetic */ h(m mVar, boolean z, i.q2.s.l lVar, int i2, i.q2.t.v vVar) {
        this(mVar, (i2 & 2) != 0 ? true : z, lVar);
    }
}
