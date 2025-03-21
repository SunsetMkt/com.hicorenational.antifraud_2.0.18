package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IteratorsJVM.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, m23546d2 = {"iterator", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/collections/CollectionsKt")
/* renamed from: h.g2.a0 */
/* loaded from: classes2.dex */
public class C5241a0 extends C5318z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IteratorsJVM.kt */
    /* renamed from: h.g2.a0$a */
    public static final class a<T> implements Iterator<T>, InterfaceC5569a {

        /* renamed from: a */
        final /* synthetic */ Enumeration f20095a;

        a(Enumeration<T> enumeration) {
            this.f20095a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20095a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f20095a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static <T> Iterator<T> m18993a(@InterfaceC5816d Enumeration<T> enumeration) {
        C5544i0.m22546f(enumeration, "$this$iterator");
        return new a(enumeration);
    }
}
