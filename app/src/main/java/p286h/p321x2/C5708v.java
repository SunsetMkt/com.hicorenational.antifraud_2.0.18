package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m23546d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.v */
/* loaded from: classes2.dex */
public final class C5708v<T> implements InterfaceC5699m<T>, InterfaceC5691e<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20639a;

    /* renamed from: b */
    private final int f20640b;

    /* renamed from: c */
    private final int f20641c;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.v$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20642a;

        /* renamed from: b */
        private int f20643b;

        a() {
            this.f20642a = C5708v.this.f20639a.iterator();
        }

        /* renamed from: d */
        private final void m23518d() {
            while (this.f20643b < C5708v.this.f20640b && this.f20642a.hasNext()) {
                this.f20642a.next();
                this.f20643b++;
            }
        }

        /* renamed from: a */
        public final void m23519a(int i2) {
            this.f20643b = i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23520b() {
            return this.f20642a;
        }

        /* renamed from: c */
        public final int m23521c() {
            return this.f20643b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m23518d();
            return this.f20643b < C5708v.this.f20641c && this.f20642a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m23518d();
            if (this.f20643b >= C5708v.this.f20641c) {
                throw new NoSuchElementException();
            }
            this.f20643b++;
            return this.f20642a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5708v(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, int i2, int i3) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        this.f20639a = interfaceC5699m;
        this.f20640b = i2;
        this.f20641c = i3;
        if (!(this.f20640b >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + this.f20640b).toString());
        }
        if (!(this.f20641c >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + this.f20641c).toString());
        }
        if (this.f20641c >= this.f20640b) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.f20641c + " < " + this.f20640b).toString());
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }

    /* renamed from: a */
    private final int m23514a() {
        return this.f20641c - this.f20640b;
    }

    @Override // p286h.p321x2.InterfaceC5691e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5699m<T> mo23284b(int i2) {
        return i2 >= m23514a() ? C5705s.m23360b() : new C5708v(this.f20639a, this.f20640b + i2, this.f20641c);
    }

    @Override // p286h.p321x2.InterfaceC5691e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5699m<T> mo23283a(int i2) {
        if (i2 >= m23514a()) {
            return this;
        }
        InterfaceC5699m<T> interfaceC5699m = this.f20639a;
        int i3 = this.f20640b;
        return new C5708v(interfaceC5699m, i3, i2 + i3);
    }
}
