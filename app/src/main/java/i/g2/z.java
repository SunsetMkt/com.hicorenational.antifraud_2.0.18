package i.g2;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.AccsClientConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u00a2\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002\u00a2\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001\u00a8\u0006\u0017"}, d2 = {"Iterable", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", AccsClientConfig.DEFAULT_CONFIGTAG, "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/collections/CollectionsKt")
public class z extends y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, i.q2.t.q1.a {
        final /* synthetic */ i.q2.s.a a;

        public a(i.q2.s.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Iterable
        @j.c.a.d
        public Iterator<T> iterator() {
            return (Iterator) this.a.invoke();
        }
    }

    @i.m2.f
    private static final <T> Iterable<T> a(i.q2.s.a<? extends Iterator<? extends T>> aVar) {
        return new a(aVar);
    }

    private static final <T> boolean b(@j.c.a.d Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    @j.c.a.d
    public static final <T> List<T> c(@j.c.a.d Iterable<? extends Iterable<? extends T>> iterable) {
        i.q2.t.i0.f(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            d0.a((Collection) arrayList, (Iterable) it.next());
        }
        return arrayList;
    }

    @j.c.a.d
    public static final <T, R> i.i0<List<T>, List<R>> d(@j.c.a.d Iterable<? extends i.i0<? extends T, ? extends R>> iterable) {
        i.q2.t.i0.f(iterable, "$this$unzip");
        int iA = a(iterable, 10);
        ArrayList arrayList = new ArrayList(iA);
        ArrayList arrayList2 = new ArrayList(iA);
        for (i.i0<? extends T, ? extends R> i0Var : iterable) {
            arrayList.add(i0Var.getFirst());
            arrayList2.add(i0Var.getSecond());
        }
        return i.c1.a(arrayList, arrayList2);
    }

    @j.c.a.e
    @i.n0
    public static final <T> Integer a(@j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @j.c.a.d
    public static <T> Collection<T> b(@j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(iterable, "$this$convertToSetForSetOperation");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return g0.M(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return b((Collection) collection) ? g0.M(iterable) : collection;
    }

    @i.n0
    public static <T> int a(@j.c.a.d Iterable<? extends T> iterable, int i2) {
        i.q2.t.i0.f(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    @j.c.a.d
    public static final <T> Collection<T> a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d Iterable<? extends T> iterable2) {
        i.q2.t.i0.f(iterable, "$this$convertToSetForSetOperationWith");
        i.q2.t.i0.f(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
                return (Collection) iterable;
            }
            Collection<T> collection = (Collection) iterable;
            return b((Collection) collection) ? g0.M(iterable) : collection;
        }
        return g0.M(iterable);
    }
}
