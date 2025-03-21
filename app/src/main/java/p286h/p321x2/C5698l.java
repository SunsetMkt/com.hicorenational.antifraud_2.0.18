package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m23546d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.l */
/* loaded from: classes2.dex */
public final class C5698l<T1, T2, V> implements InterfaceC5699m<V> {

    /* renamed from: a */
    private final InterfaceC5699m<T1> f20599a;

    /* renamed from: b */
    private final InterfaceC5699m<T2> f20600b;

    /* renamed from: c */
    private final InterfaceC5510p<T1, T2, V> f20601c;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.l$a */
    public static final class a implements Iterator<V>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T1> f20602a;

        /* renamed from: b */
        @InterfaceC5816d
        private final Iterator<T2> f20603b;

        a() {
            this.f20602a = C5698l.this.f20599a.iterator();
            this.f20603b = C5698l.this.f20600b.iterator();
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T1> m23327b() {
            return this.f20602a;
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final Iterator<T2> m23328c() {
            return this.f20603b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20602a.hasNext() && this.f20603b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) C5698l.this.f20601c.invoke(this.f20602a.next(), this.f20603b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5698l(@InterfaceC5816d InterfaceC5699m<? extends T1> interfaceC5699m, @InterfaceC5816d InterfaceC5699m<? extends T2> interfaceC5699m2, @InterfaceC5816d InterfaceC5510p<? super T1, ? super T2, ? extends V> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5699m, "sequence1");
        C5544i0.m22546f(interfaceC5699m2, "sequence2");
        C5544i0.m22546f(interfaceC5510p, "transform");
        this.f20599a = interfaceC5699m;
        this.f20600b = interfaceC5699m2;
        this.f20601c = interfaceC5510p;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<V> iterator() {
        return new a();
    }
}
