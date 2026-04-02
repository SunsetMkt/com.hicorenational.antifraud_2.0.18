package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/TransformingIndexedSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function2;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class y<T, R> implements m<R> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i.q2.s.p<Integer, T, R> f12395b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12396b;

        a() {
            this.a = y.this.a.iterator();
        }

        public final void a(int i2) {
            this.f12396b = i2;
        }

        public final int b() {
            return this.f12396b;
        }

        @j.c.a.d
        public final Iterator<T> c() {
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            i.q2.s.p pVar = y.this.f12395b;
            int i2 = this.f12396b;
            this.f12396b = i2 + 1;
            if (i2 < 0) {
                i.g2.y.f();
            }
            return (R) pVar.invoke(Integer.valueOf(i2), this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(@j.c.a.d m<? extends T> mVar, @j.c.a.d i.q2.s.p<? super Integer, ? super T, ? extends R> pVar) {
        i0.f(mVar, "sequence");
        i0.f(pVar, "transformer");
        this.a = mVar;
        this.f12395b = pVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<R> iterator() {
        return new a();
    }
}
