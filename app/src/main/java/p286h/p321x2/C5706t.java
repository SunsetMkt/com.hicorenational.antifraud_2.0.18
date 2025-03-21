package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: _SequencesJvm.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a8\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010¨\u0006\u0011"}, m23546d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/sequences/SequencesKt")
/* renamed from: h.x2.t */
/* loaded from: classes2.dex */
class C5706t extends C5705s {

    /* compiled from: _SequencesJvm.kt */
    /* renamed from: h.x2.t$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5506l<Object, Boolean> {
        final /* synthetic */ Class $klass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls) {
            super(1);
            this.$klass = cls;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(@InterfaceC5817e Object obj) {
            return this.$klass.isInstance(obj);
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <R> InterfaceC5699m<R> m23366a(@InterfaceC5816d InterfaceC5699m<?> interfaceC5699m, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(interfaceC5699m, "$this$filterIsInstance");
        C5544i0.m22546f(cls, "klass");
        InterfaceC5699m<R> m23475i = C5707u.m23475i(interfaceC5699m, new a(cls));
        if (m23475i != null) {
            return m23475i;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <T extends Comparable<? super T>> SortedSet<T> m23369d(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$toSortedSet");
        return (SortedSet) C5707u.m23446c((InterfaceC5699m) interfaceC5699m, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m23367a(@InterfaceC5816d InterfaceC5699m<?> interfaceC5699m, @InterfaceC5816d C c2, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(interfaceC5699m, "$this$filterIsInstanceTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(cls, "klass");
        for (Object obj : interfaceC5699m) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> SortedSet<T> m23368a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(interfaceC5699m, "$this$toSortedSet");
        C5544i0.m22546f(comparator, "comparator");
        return (SortedSet) C5707u.m23446c((InterfaceC5699m) interfaceC5699m, new TreeSet(comparator));
    }
}
