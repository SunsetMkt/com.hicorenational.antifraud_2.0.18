package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"Lkotlin/sequences/GeneratorSequence;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.j */
/* loaded from: classes2.dex */
final class C5696j<T> implements InterfaceC5699m<T> {

    /* renamed from: a */
    private final InterfaceC5495a<T> f20590a;

    /* renamed from: b */
    private final InterfaceC5506l<T, T> f20591b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.j$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5817e
        private T f20592a;

        /* renamed from: b */
        private int f20593b = -2;

        a() {
        }

        /* renamed from: d */
        private final void m23315d() {
            T t;
            if (this.f20593b == -2) {
                t = (T) C5696j.this.f20590a.invoke();
            } else {
                InterfaceC5506l interfaceC5506l = C5696j.this.f20591b;
                T t2 = this.f20592a;
                if (t2 == null) {
                    C5544i0.m22545f();
                }
                t = (T) interfaceC5506l.invoke(t2);
            }
            this.f20592a = t;
            this.f20593b = this.f20592a == null ? 0 : 1;
        }

        /* renamed from: a */
        public final void m23316a(int i2) {
            this.f20593b = i2;
        }

        @InterfaceC5817e
        /* renamed from: b */
        public final T m23317b() {
            return this.f20592a;
        }

        /* renamed from: c */
        public final int m23319c() {
            return this.f20593b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20593b < 0) {
                m23315d();
            }
            return this.f20593b == 1;
        }

        @Override // java.util.Iterator
        @InterfaceC5816d
        public T next() {
            if (this.f20593b < 0) {
                m23315d();
            }
            if (this.f20593b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f20592a;
            if (t == null) {
                throw new C5226e1("null cannot be cast to non-null type T");
            }
            this.f20593b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: b */
        public final void m23318b(@InterfaceC5817e T t) {
            this.f20592a = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5696j(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a, @InterfaceC5816d InterfaceC5506l<? super T, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5495a, "getInitialValue");
        C5544i0.m22546f(interfaceC5506l, "getNextValue");
        this.f20590a = interfaceC5495a;
        this.f20591b = interfaceC5506l;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }
}
