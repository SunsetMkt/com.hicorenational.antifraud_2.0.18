package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m23546d2 = {"Lkotlin/sequences/TransformingSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", ExifInterface.LONGITUDE_EAST, "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.z */
/* loaded from: classes2.dex */
public final class C5712z<T, R> implements InterfaceC5699m<R> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20661a;

    /* renamed from: b */
    private final InterfaceC5506l<T, R> f20662b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.z$a */
    public static final class a implements Iterator<R>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20663a;

        a() {
            this.f20663a = C5712z.this.f20661a.iterator();
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23543b() {
            return this.f20663a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20663a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) C5712z.this.f20662b.invoke(this.f20663a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5712z(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        C5544i0.m22546f(interfaceC5506l, "transformer");
        this.f20661a = interfaceC5699m;
        this.f20662b = interfaceC5506l;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<R> iterator() {
        return new a();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final <E> InterfaceC5699m<E> m23542a(@InterfaceC5816d InterfaceC5506l<? super R, ? extends Iterator<? extends E>> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "iterator");
        return new C5695i(this.f20661a, this.f20662b, interfaceC5506l);
    }
}
