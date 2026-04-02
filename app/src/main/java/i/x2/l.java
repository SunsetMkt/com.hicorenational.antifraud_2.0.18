package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class l<T1, T2, V> implements m<V> {
    private final m<T1> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<T2> f12366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i.q2.s.p<T1, T2, V> f12367c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<V>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T1> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @j.c.a.d
        private final Iterator<T2> f12368b;

        a() {
            this.a = l.this.a.iterator();
            this.f12368b = l.this.f12366b.iterator();
        }

        @j.c.a.d
        public final Iterator<T1> b() {
            return this.a;
        }

        @j.c.a.d
        public final Iterator<T2> c() {
            return this.f12368b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() && this.f12368b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) l.this.f12367c.invoke(this.a.next(), this.f12368b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@j.c.a.d m<? extends T1> mVar, @j.c.a.d m<? extends T2> mVar2, @j.c.a.d i.q2.s.p<? super T1, ? super T2, ? extends V> pVar) {
        i0.f(mVar, "sequence1");
        i0.f(mVar2, "sequence2");
        i0.f(pVar, "transform");
        this.a = mVar;
        this.f12366b = mVar2;
        this.f12367c = pVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<V> iterator() {
        return new a();
    }
}
