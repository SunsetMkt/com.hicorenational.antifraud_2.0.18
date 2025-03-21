package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"Lkotlin/sequences/FilteringSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.h */
/* loaded from: classes2.dex */
public final class C5694h<T> implements InterfaceC5699m<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20577a;

    /* renamed from: b */
    private final boolean f20578b;

    /* renamed from: c */
    private final InterfaceC5506l<T, Boolean> f20579c;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.h$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20580a;

        /* renamed from: b */
        private int f20581b = -1;

        /* renamed from: c */
        @InterfaceC5817e
        private T f20582c;

        a() {
            this.f20580a = C5694h.this.f20577a.iterator();
        }

        /* renamed from: e */
        private final void m23300e() {
            while (this.f20580a.hasNext()) {
                T next = this.f20580a.next();
                if (((Boolean) C5694h.this.f20579c.invoke(next)).booleanValue() == C5694h.this.f20578b) {
                    this.f20582c = next;
                    this.f20581b = 1;
                    return;
                }
            }
            this.f20581b = 0;
        }

        /* renamed from: a */
        public final void m23301a(int i2) {
            this.f20581b = i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23302b() {
            return this.f20580a;
        }

        @InterfaceC5817e
        /* renamed from: c */
        public final T m23304c() {
            return this.f20582c;
        }

        /* renamed from: d */
        public final int m23305d() {
            return this.f20581b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20581b == -1) {
                m23300e();
            }
            return this.f20581b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f20581b == -1) {
                m23300e();
            }
            if (this.f20581b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f20582c;
            this.f20582c = null;
            this.f20581b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: b */
        public final void m23303b(@InterfaceC5817e T t) {
            this.f20582c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5694h(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, boolean z, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        this.f20577a = interfaceC5699m;
        this.f20578b = z;
        this.f20579c = interfaceC5506l;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }

    public /* synthetic */ C5694h(InterfaceC5699m interfaceC5699m, boolean z, InterfaceC5506l interfaceC5506l, int i2, C5586v c5586v) {
        this(interfaceC5699m, (i2 & 2) != 0 ? true : z, interfaceC5506l);
    }
}
