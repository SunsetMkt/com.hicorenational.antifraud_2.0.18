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
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m23546d2 = {"Lkotlin/sequences/TakeWhileSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.x2.x */
/* loaded from: classes2.dex */
public final class C5710x<T> implements InterfaceC5699m<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20650a;

    /* renamed from: b */
    private final InterfaceC5506l<T, Boolean> f20651b;

    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.x$a */
    public static final class a implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        @InterfaceC5816d
        private final Iterator<T> f20652a;

        /* renamed from: b */
        private int f20653b = -1;

        /* renamed from: c */
        @InterfaceC5817e
        private T f20654c;

        a() {
            this.f20652a = C5710x.this.f20650a.iterator();
        }

        /* renamed from: e */
        private final void m23529e() {
            if (this.f20652a.hasNext()) {
                T next = this.f20652a.next();
                if (((Boolean) C5710x.this.f20651b.invoke(next)).booleanValue()) {
                    this.f20653b = 1;
                    this.f20654c = next;
                    return;
                }
            }
            this.f20653b = 0;
        }

        /* renamed from: a */
        public final void m23530a(int i2) {
            this.f20653b = i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final Iterator<T> m23531b() {
            return this.f20652a;
        }

        @InterfaceC5817e
        /* renamed from: c */
        public final T m23533c() {
            return this.f20654c;
        }

        /* renamed from: d */
        public final int m23534d() {
            return this.f20653b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20653b == -1) {
                m23529e();
            }
            return this.f20653b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f20653b == -1) {
                m23529e();
            }
            if (this.f20653b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f20654c;
            this.f20654c = null;
            this.f20653b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: b */
        public final void m23532b(@InterfaceC5817e T t) {
            this.f20654c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5710x(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        this.f20650a = interfaceC5699m;
        this.f20651b = interfaceC5506l;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new a();
    }
}
