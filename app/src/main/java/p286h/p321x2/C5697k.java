package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5295r0;
import p286h.p289g2.C5315y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m23546d2 = {"Lkotlin/sequences/IndexingSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "sequence", "(Lkotlin/sequences/Sequence;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.k */
/* loaded from: classes2.dex */
public final class C5697k<T> implements InterfaceC5699m<C5295r0<? extends T>> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20595a;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.k$a */
    public static final class a implements Iterator<C5295r0<? extends T>>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20596a;

        /* renamed from: b */
        private int f20597b;

        a() {
            this.f20596a = C5697k.this.f20595a.iterator();
        }

        /* renamed from: a */
        public final void m23321a(int i2) {
            this.f20597b = i2;
        }

        /* renamed from: b */
        public final int m23322b() {
            return this.f20597b;
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final Iterator<T> m23323c() {
            return this.f20596a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20596a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @InterfaceC5816d
        public C5295r0<T> next() {
            int i2 = this.f20597b;
            this.f20597b = i2 + 1;
            if (i2 < 0) {
                C5315y.m21790f();
            }
            return new C5295r0<>(i2, this.f20596a.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5697k(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        this.f20595a = interfaceC5699m;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<C5295r0<T>> iterator() {
        return new a();
    }
}
