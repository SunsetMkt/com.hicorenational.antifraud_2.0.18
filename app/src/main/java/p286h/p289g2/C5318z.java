package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.AccsClientConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p286h.C5218c1;
import p286h.C5334i0;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002¢\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001¨\u0006\u0017"}, m23546d2 = {"Iterable", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", AccsClientConfig.DEFAULT_CONFIGTAG, "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/collections/CollectionsKt")
/* renamed from: h.g2.z */
/* loaded from: classes2.dex */
public class C5318z extends C5315y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* renamed from: h.g2.z$a */
    public static final class a<T> implements Iterable<T>, InterfaceC5569a {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5495a f20187a;

        public a(InterfaceC5495a interfaceC5495a) {
            this.f20187a = interfaceC5495a;
        }

        @Override // java.lang.Iterable
        @InterfaceC5816d
        public Iterator<T> iterator() {
            return (Iterator) this.f20187a.invoke();
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> Iterable<T> m21798a(InterfaceC5495a<? extends Iterator<? extends T>> interfaceC5495a) {
        return new a(interfaceC5495a);
    }

    /* renamed from: b */
    private static final <T> boolean m21801b(@InterfaceC5816d Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> List<T> m21802c(@InterfaceC5816d Iterable<? extends Iterable<? extends T>> iterable) {
        C5544i0.m22546f(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            C5253d0.m19665a((Collection) arrayList, (Iterable) it.next());
        }
        return arrayList;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <T, R> C5334i0<List<T>, List<R>> m21803d(@InterfaceC5816d Iterable<? extends C5334i0<? extends T, ? extends R>> iterable) {
        C5544i0.m22546f(iterable, "$this$unzip");
        int m21796a = m21796a(iterable, 10);
        ArrayList arrayList = new ArrayList(m21796a);
        ArrayList arrayList2 = new ArrayList(m21796a);
        for (C5334i0<? extends T, ? extends R> c5334i0 : iterable) {
            arrayList.add(c5334i0.getFirst());
            arrayList2.add(c5334i0.getSecond());
        }
        return C5218c1.m18838a(arrayList, arrayList2);
    }

    @InterfaceC5440n0
    @InterfaceC5817e
    /* renamed from: a */
    public static final <T> Integer m21797a(@InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static <T> Collection<T> m21800b(@InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(iterable, "$this$convertToSetForSetOperation");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return C5262g0.m19766M(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return m21801b((Collection) collection) ? C5262g0.m19766M(iterable) : collection;
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static <T> int m21796a(@InterfaceC5816d Iterable<? extends T> iterable, int i2) {
        C5544i0.m22546f(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Collection<T> m21799a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d Iterable<? extends T> iterable2) {
        C5544i0.m22546f(iterable, "$this$convertToSetForSetOperationWith");
        C5544i0.m22546f(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
                return (Collection) iterable;
            }
            Collection<T> collection = (Collection) iterable;
            return m21801b((Collection) collection) ? C5262g0.m19766M(iterable) : collection;
        }
        return C5262g0.m19766M(iterable);
    }
}
