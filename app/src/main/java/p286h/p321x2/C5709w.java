package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m23546d2 = {"Lkotlin/sequences/TakeSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.w */
/* loaded from: classes2.dex */
public final class C5709w<T> implements InterfaceC5699m<T>, InterfaceC5691e<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20645a;

    /* renamed from: b */
    private final int f20646b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.w$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        private int f20647a;

        /* renamed from: b */
        @InterfaceC5816d
        private final Iterator<T> f20648b;

        a() {
            this.f20647a = C5709w.this.f20646b;
            this.f20648b = C5709w.this.f20645a.iterator();
        }

        /* renamed from: a */
        public final void m23524a(int i2) {
            this.f20647a = i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23525b() {
            return this.f20648b;
        }

        /* renamed from: c */
        public final int m23526c() {
            return this.f20647a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20647a > 0 && this.f20648b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i2 = this.f20647a;
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            this.f20647a = i2 - 1;
            return this.f20648b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5709w(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, int i2) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        this.f20645a = interfaceC5699m;
        this.f20646b = i2;
        if (this.f20646b >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + this.f20646b + '.').toString());
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // p286h.p321x2.InterfaceC5691e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5699m<T> mo23283a(int i2) {
        return i2 >= this.f20646b ? this : new C5709w(this.f20645a, i2);
    }

    @Override // p286h.p321x2.InterfaceC5691e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5699m<T> mo23284b(int i2) {
        int i3 = this.f20646b;
        return i2 >= i3 ? C5705s.m23360b() : new C5708v(this.f20645a, i2, i3);
    }
}
