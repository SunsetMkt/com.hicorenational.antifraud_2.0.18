package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m23546d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.d */
/* loaded from: classes2.dex */
public final class C5690d<T> implements InterfaceC5699m<T>, InterfaceC5691e<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20565a;

    /* renamed from: b */
    private final int f20566b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.d$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20567a;

        /* renamed from: b */
        private int f20568b;

        a() {
            this.f20567a = C5690d.this.f20565a.iterator();
            this.f20568b = C5690d.this.f20566b;
        }

        /* renamed from: d */
        private final void m23285d() {
            while (this.f20568b > 0 && this.f20567a.hasNext()) {
                this.f20567a.next();
                this.f20568b--;
            }
        }

        /* renamed from: a */
        public final void m23286a(int i2) {
            this.f20568b = i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23287b() {
            return this.f20567a;
        }

        /* renamed from: c */
        public final int m23288c() {
            return this.f20568b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m23285d();
            return this.f20567a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m23285d();
            return this.f20567a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5690d(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, int i2) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        this.f20565a = interfaceC5699m;
        this.f20566b = i2;
        if (this.f20566b >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + this.f20566b + '.').toString());
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
        int i3 = this.f20566b;
        int i4 = i3 + i2;
        return i4 < 0 ? new C5709w(this, i2) : new C5708v(this.f20565a, i3, i4);
    }

    @Override // p286h.p321x2.InterfaceC5691e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5699m<T> mo23284b(int i2) {
        int i3 = this.f20566b + i2;
        return i3 < 0 ? new C5690d(this, i2) : new C5690d(this.f20565a, i3);
    }
}
