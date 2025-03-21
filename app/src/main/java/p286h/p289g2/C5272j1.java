package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SlidingWindow.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m23546d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.g2.j1 */
/* loaded from: classes2.dex */
final class C5272j1<T> extends AbstractC5252d<T> implements RandomAccess {

    /* renamed from: a */
    private final int f20129a;

    /* renamed from: b */
    private int f20130b;

    /* renamed from: c */
    private int f20131c;

    /* renamed from: d */
    private final Object[] f20132d;

    /* compiled from: SlidingWindow.kt */
    /* renamed from: h.g2.j1$a */
    public static final class a extends AbstractC5249c<T> {

        /* renamed from: c */
        private int f20133c;

        /* renamed from: d */
        private int f20134d;

        a() {
            this.f20133c = C5272j1.this.size();
            this.f20134d = C5272j1.this.f20130b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p286h.p289g2.AbstractC5249c
        /* renamed from: b */
        protected void mo19567b() {
            if (this.f20133c == 0) {
                m19569c();
                return;
            }
            m19568b(C5272j1.this.f20132d[this.f20134d]);
            this.f20134d = (this.f20134d + 1) % C5272j1.this.f20129a;
            this.f20133c--;
        }
    }

    public C5272j1(@InterfaceC5816d Object[] objArr, int i2) {
        C5544i0.m22546f(objArr, "buffer");
        this.f20132d = objArr;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= this.f20132d.length) {
            this.f20129a = this.f20132d.length;
            this.f20131c = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + this.f20132d.length).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (m19976b()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f20132d[(this.f20130b + size()) % this.f20129a] = t;
        this.f20131c = size() + 1;
    }

    @Override // p286h.p289g2.AbstractC5252d, java.util.List
    public T get(int i2) {
        AbstractC5252d.Companion.m19651a(i2, size());
        return (T) this.f20132d[(this.f20130b + i2) % this.f20129a];
    }

    @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
    public int getSize() {
        return this.f20131c;
    }

    @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
    @InterfaceC5816d
    public <T> T[] toArray(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            C5544i0.m22521a((Object) tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f20130b; i3 < size && i4 < this.f20129a; i4++) {
            tArr[i3] = this.f20132d[i4];
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.f20132d[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: b */
    public final boolean m19976b() {
        return size() == this.f20129a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: a */
    public final C5272j1<T> m19974a(int i2) {
        int m23101b;
        Object[] array;
        int i3 = this.f20129a;
        m23101b = C5648q.m23101b(i3 + (i3 >> 1) + 1, i2);
        if (this.f20130b == 0) {
            array = Arrays.copyOf(this.f20132d, m23101b);
            C5544i0.m22521a((Object) array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[m23101b]);
        }
        return new C5272j1<>(array, size());
    }

    /* renamed from: b */
    public final void m19975b(int i2) {
        if (i2 >= 0) {
            if (!(i2 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            }
            if (i2 > 0) {
                int i3 = this.f20130b;
                int i4 = (i3 + i2) % this.f20129a;
                if (i3 > i4) {
                    C5291q.m20273b(this.f20132d, (Object) null, i3, this.f20129a);
                    C5291q.m20273b(this.f20132d, (Object) null, 0, i4);
                } else {
                    C5291q.m20273b(this.f20132d, (Object) null, i3, i4);
                }
                this.f20130b = i4;
                this.f20131c = size() - i2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
    }

    public C5272j1(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public final int m19966a(int i2, int i3) {
        return (i2 + i3) % this.f20129a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
    @InterfaceC5816d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
