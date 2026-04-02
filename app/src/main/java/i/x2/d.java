package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class d<T> implements m<T>, e<T> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12345b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12346b;

        a() {
            this.a = d.this.a.iterator();
            this.f12346b = d.this.f12345b;
        }

        private final void d() {
            while (this.f12346b > 0 && this.a.hasNext()) {
                this.a.next();
                this.f12346b--;
            }
        }

        public final void a(int i2) {
            this.f12346b = i2;
        }

        @j.c.a.d
        public final Iterator<T> b() {
            return this.a;
        }

        public final int c() {
            return this.f12346b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            d();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@j.c.a.d m<? extends T> mVar, int i2) {
        i0.f(mVar, "sequence");
        this.a = mVar;
        this.f12345b = i2;
        if (this.f12345b >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + this.f12345b + '.').toString());
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // i.x2.e
    @j.c.a.d
    public m<T> a(int i2) {
        int i3 = this.f12345b;
        int i4 = i3 + i2;
        return i4 < 0 ? new w(this, i2) : new v(this.a, i3, i4);
    }

    @Override // i.x2.e
    @j.c.a.d
    public m<T> b(int i2) {
        int i3 = this.f12345b + i2;
        return i3 < 0 ? new d(this, i2) : new d(this.a, i3);
    }
}
