package i.x2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class v<T> implements m<T>, e<T> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12385c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i.q2.t.q1.a {

        @j.c.a.d
        private final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12386b;

        a() {
            this.a = v.this.a.iterator();
        }

        private final void d() {
            while (this.f12386b < v.this.f12384b && this.a.hasNext()) {
                this.a.next();
                this.f12386b++;
            }
        }

        public final void a(int i2) {
            this.f12386b = i2;
        }

        @j.c.a.d
        public final Iterator<T> b() {
            return this.a;
        }

        public final int c() {
            return this.f12386b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d();
            return this.f12386b < v.this.f12385c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            d();
            if (this.f12386b >= v.this.f12385c) {
                throw new NoSuchElementException();
            }
            this.f12386b++;
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@j.c.a.d m<? extends T> mVar, int i2, int i3) {
        i0.f(mVar, "sequence");
        this.a = mVar;
        this.f12384b = i2;
        this.f12385c = i3;
        if (!(this.f12384b >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + this.f12384b).toString());
        }
        if (!(this.f12385c >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + this.f12385c).toString());
        }
        if (this.f12385c >= this.f12384b) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.f12385c + " < " + this.f12384b).toString());
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    private final int a() {
        return this.f12385c - this.f12384b;
    }

    @Override // i.x2.e
    @j.c.a.d
    public m<T> b(int i2) {
        return i2 >= a() ? s.b() : new v(this.a, this.f12384b + i2, this.f12385c);
    }

    @Override // i.x2.e
    @j.c.a.d
    public m<T> a(int i2) {
        if (i2 >= a()) {
            return this;
        }
        m<T> mVar = this.a;
        int i3 = this.f12384b;
        return new v(mVar, i3, i2 + i3);
    }
}
