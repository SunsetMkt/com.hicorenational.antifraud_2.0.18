package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import p286h.C5715y1;
import p286h.InterfaceC5212b;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p291h2.C5325b;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Collections.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u001a@\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aK\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aC\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\b\u0010%\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010&\u001a3\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010(\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\b+\u001a\b\u0010,\u001a\u00020\u001eH\u0001\u001a\b\u0010-\u001a\u00020\u001eH\u0001\u001a%\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010/\u001aS\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010%\u001a\u0002H\u00072\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000702j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`32\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00104\u001a>\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00100\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u000706*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010%\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00107\u001ad\u00108\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u00109*\b\u0012\u0004\u0012\u0002H906*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010:\u001a\u0004\u0018\u0001H92\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0016\b\u0004\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H90\u000eH\u0086\b¢\u0006\u0002\u0010<\u001a,\u0010=\u001a\u00020>\"\t\b\u0000\u0010\u0007¢\u0006\u0002\b?*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a8\u0010@\u001a\u0002HA\"\u0010\b\u0000\u0010B*\u0006\u0012\u0002\b\u00030\u0002*\u0002HA\"\u0004\b\u0001\u0010A*\u0002HB2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0087\b¢\u0006\u0002\u0010E\u001a\u0019\u0010F\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010G\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006J"}, m23546d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", ExifInterface.GPS_DIRECTION_TRUE, "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", ExifInterface.LONGITUDE_EAST, "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/collections/CollectionsKt")
/* renamed from: h.g2.y */
/* loaded from: classes2.dex */
public class C5315y extends C5312x {

    /* compiled from: Collections.kt */
    /* renamed from: h.g2.y$a */
    public static final class a<T> extends AbstractC5547j0 implements InterfaceC5506l<T, Integer> {
        final /* synthetic */ Comparable $key;
        final /* synthetic */ InterfaceC5506l $selector;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC5506l interfaceC5506l, Comparable comparable) {
            super(1);
            this.$selector = interfaceC5506l;
            this.$key = comparable;
        }

        /* renamed from: invoke */
        public final int invoke2(T t) {
            int m21811a;
            m21811a = C5325b.m21811a((Comparable) this.$selector.invoke(t), this.$key);
            return m21811a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
            return Integer.valueOf(invoke2((a<T>) obj));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final <T> ArrayList<T> m21768a() {
        return new ArrayList<>();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Collection<T> m21774b(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "$this$asCollection");
        return new C5273k(tArr, false);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static <T> List<T> m21783c(@InterfaceC5816d T... tArr) {
        C5544i0.m22546f(tArr, "elements");
        return tArr.length > 0 ? C5291q.m20317d((Object[]) tArr) : m21775b();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: d */
    private static final <T> List<T> m21786d() {
        return new ArrayList();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static <T> List<T> m21788e(@InterfaceC5816d T... tArr) {
        C5544i0.m22546f(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C5273k(tArr, true));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: f */
    public static void m21790f() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> ArrayList<T> m21769a(@InterfaceC5816d T... tArr) {
        C5544i0.m22546f(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new C5273k(tArr, true));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static <T> List<T> m21775b() {
        return C5271j0.INSTANCE;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> List<T> m21780c() {
        return m21775b();
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <T> List<T> m21787d(@InterfaceC5816d T... tArr) {
        C5544i0.m22546f(tArr, "elements");
        return C5294r.m21490q(tArr);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: e */
    public static void m21789e() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final <T> List<T> m21770a(int i2, InterfaceC5506l<? super Integer, ? extends T> interfaceC5506l) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(interfaceC5506l.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> List<T> m21777b(@InterfaceC5817e T t) {
        return t != null ? C5312x.m21750a(t) : m21775b();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    private static final <E> List<E> m21781c(int i2, @InterfaceC5212b InterfaceC5506l<? super List<E>, C5715y1> interfaceC5506l) {
        ArrayList arrayList = new ArrayList(i2);
        interfaceC5506l.invoke(arrayList);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: d */
    private static final <T> Collection<T> m21785d(@InterfaceC5817e Collection<? extends T> collection) {
        return collection != 0 ? collection : m21775b();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final <E> List<E> m21771a(@InterfaceC5212b InterfaceC5506l<? super List<E>, C5715y1> interfaceC5506l) {
        ArrayList arrayList = new ArrayList();
        interfaceC5506l.invoke(arrayList);
        return arrayList;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <T> List<T> m21776b(int i2, InterfaceC5506l<? super Integer, ? extends T> interfaceC5506l) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(interfaceC5506l.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: c */
    private static final <T> boolean m21784c(@InterfaceC5817e Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static C5642k m21766a(@InterfaceC5816d Collection<?> collection) {
        C5544i0.m22546f(collection, "$this$indices");
        return new C5642k(0, collection.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> List<T> m21782c(@InterfaceC5817e List<? extends T> list) {
        return list != 0 ? list : m21775b();
    }

    /* renamed from: a */
    public static <T> int m21757a(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "$this$lastIndex");
        return list.size() - 1;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> boolean m21779b(@InterfaceC5816d Collection<? extends T> collection) {
        return !collection.isEmpty();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final Object m21767a(Collection collection, InterfaceC5495a interfaceC5495a) {
        return collection.isEmpty() ? interfaceC5495a.invoke() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: b */
    public static <T> List<T> m21778b(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : C5312x.m21750a(list.get(0));
        }
        return m21775b();
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> boolean m21773a(@InterfaceC5816d Collection<? extends T> collection, Collection<? extends T> collection2) {
        return collection.containsAll(collection2);
    }

    /* renamed from: a */
    public static /* synthetic */ int m21761a(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return m21760a((List<? extends Comparable>) list, comparable, i2, i3);
    }

    /* renamed from: a */
    public static final <T extends Comparable<? super T>> int m21760a(@InterfaceC5816d List<? extends T> list, @InterfaceC5817e T t, int i2, int i3) {
        int m21811a;
        C5544i0.m22546f(list, "$this$binarySearch");
        m21772a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            m21811a = C5325b.m21811a(list.get(i5), t);
            if (m21811a < 0) {
                i2 = i5 + 1;
            } else {
                if (m21811a <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: a */
    public static /* synthetic */ int m21765a(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return m21764a((List<? extends Object>) list, obj, (Comparator<? super Object>) comparator, i2, i3);
    }

    /* renamed from: a */
    public static final <T> int m21764a(@InterfaceC5816d List<? extends T> list, T t, @InterfaceC5816d Comparator<? super T> comparator, int i2, int i3) {
        C5544i0.m22546f(list, "$this$binarySearch");
        C5544i0.m22546f(comparator, "comparator");
        m21772a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int compare = comparator.compare(list.get(i5), t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else {
                if (compare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: a */
    public static /* synthetic */ int m21763a(List list, Comparable comparable, int i2, int i3, InterfaceC5506l interfaceC5506l, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        C5544i0.m22546f(list, "$this$binarySearchBy");
        C5544i0.m22546f(interfaceC5506l, "selector");
        return m21758a(list, i2, i3, new a(interfaceC5506l, comparable));
    }

    /* renamed from: a */
    public static final <T, K extends Comparable<? super K>> int m21762a(@InterfaceC5816d List<? extends T> list, @InterfaceC5817e K k2, int i2, int i3, @InterfaceC5816d InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        C5544i0.m22546f(list, "$this$binarySearchBy");
        C5544i0.m22546f(interfaceC5506l, "selector");
        return m21758a(list, i2, i3, new a(interfaceC5506l, k2));
    }

    /* renamed from: a */
    public static /* synthetic */ int m21759a(List list, int i2, int i3, InterfaceC5506l interfaceC5506l, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return m21758a(list, i2, i3, interfaceC5506l);
    }

    /* renamed from: a */
    public static final <T> int m21758a(@InterfaceC5816d List<? extends T> list, int i2, int i3, @InterfaceC5816d InterfaceC5506l<? super T, Integer> interfaceC5506l) {
        C5544i0.m22546f(list, "$this$binarySearch");
        C5544i0.m22546f(interfaceC5506l, "comparison");
        m21772a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int intValue = interfaceC5506l.invoke(list.get(i5)).intValue();
            if (intValue < 0) {
                i2 = i5 + 1;
            } else {
                if (intValue <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: a */
    private static final void m21772a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        }
        if (i4 <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
    }
}
