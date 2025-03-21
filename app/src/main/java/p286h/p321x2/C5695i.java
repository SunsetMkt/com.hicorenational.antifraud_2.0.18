package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"Lkotlin/sequences/FlatteningSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.i */
/* loaded from: classes2.dex */
public final class C5695i<T, R, E> implements InterfaceC5699m<E> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20584a;

    /* renamed from: b */
    private final InterfaceC5506l<T, R> f20585b;

    /* renamed from: c */
    private final InterfaceC5506l<R, Iterator<E>> f20586c;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.i$a */
    public static final class a implements Iterator<E>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20587a;

        /* renamed from: b */
        @InterfaceC5817e
        private Iterator<? extends E> f20588b;

        a() {
            this.f20587a = C5695i.this.f20584a.iterator();
        }

        /* renamed from: d */
        private final boolean m23309d() {
            Iterator<? extends E> it = this.f20588b;
            if (it != null && !it.hasNext()) {
                this.f20588b = null;
            }
            while (true) {
                if (this.f20588b != null) {
                    break;
                }
                if (!this.f20587a.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) C5695i.this.f20586c.invoke(C5695i.this.f20585b.invoke(this.f20587a.next()));
                if (it2.hasNext()) {
                    this.f20588b = it2;
                    break;
                }
            }
            return true;
        }

        /* renamed from: a */
        public final void m23310a(@InterfaceC5817e Iterator<? extends E> it) {
            this.f20588b = it;
        }

        @InterfaceC5817e
        /* renamed from: b */
        public final Iterator<E> m23311b() {
            return this.f20588b;
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final Iterator<T> m23312c() {
            return this.f20587a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return m23309d();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!m23309d()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f20588b;
            if (it == null) {
                C5544i0.m22545f();
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5695i(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5506l<? super T, ? extends R> interfaceC5506l, @InterfaceC5816d InterfaceC5506l<? super R, ? extends Iterator<? extends E>> interfaceC5506l2) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        C5544i0.m22546f(interfaceC5506l, "transformer");
        C5544i0.m22546f(interfaceC5506l2, "iterator");
        this.f20584a = interfaceC5699m;
        this.f20585b = interfaceC5506l;
        this.f20586c = interfaceC5506l2;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<E> iterator() {
        return new a();
    }
}
