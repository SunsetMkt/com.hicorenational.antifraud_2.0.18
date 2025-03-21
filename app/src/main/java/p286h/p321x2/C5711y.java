package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5315y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"Lkotlin/sequences/TransformingIndexedSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function2;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.y */
/* loaded from: classes2.dex */
public final class C5711y<T, R> implements InterfaceC5699m<R> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20656a;

    /* renamed from: b */
    private final InterfaceC5510p<Integer, T, R> f20657b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.y$a */
    public static final class a implements Iterator<R>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20658a;

        /* renamed from: b */
        private int f20659b;

        a() {
            this.f20658a = C5711y.this.f20656a.iterator();
        }

        /* renamed from: a */
        public final void m23537a(int i2) {
            this.f20659b = i2;
        }

        /* renamed from: b */
        public final int m23538b() {
            return this.f20659b;
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final Iterator<T> m23539c() {
            return this.f20658a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20658a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            InterfaceC5510p interfaceC5510p = C5711y.this.f20657b;
            int i2 = this.f20659b;
            this.f20659b = i2 + 1;
            if (i2 < 0) {
                C5315y.m21790f();
            }
            return (R) interfaceC5510p.invoke(Integer.valueOf(i2), this.f20658a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5711y(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super T, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        C5544i0.m22546f(interfaceC5510p, "transformer");
        this.f20656a = interfaceC5699m;
        this.f20657b = interfaceC5510p;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<R> iterator() {
        return new a();
    }
}
