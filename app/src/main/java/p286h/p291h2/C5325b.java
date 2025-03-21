package p286h.p291h2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Comparator;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aW\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a;\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aW\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001a>\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001aZ\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aO\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001aO\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001am\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\b\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004¨\u0006'"}, m23546d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "thenDescending", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/comparisons/ComparisonsKt")
/* renamed from: h.h2.b */
/* loaded from: classes2.dex */
public class C5325b {

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$a */
    static final class a<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5506l[] f20189a;

        a(InterfaceC5506l[] interfaceC5506lArr) {
            this.f20189a = interfaceC5506lArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return C5325b.m21830c(t, t2, this.f20189a);
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$b */
    public static final class b<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5506l f20190a;

        public b(InterfaceC5506l interfaceC5506l) {
            this.f20190a = interfaceC5506l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m21811a;
            m21811a = C5325b.m21811a((Comparable) this.f20190a.invoke(t), (Comparable) this.f20190a.invoke(t2));
            return m21811a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$c */
    public static final class c<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20191a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5506l f20192b;

        public c(Comparator comparator, InterfaceC5506l interfaceC5506l) {
            this.f20191a = comparator;
            this.f20192b = interfaceC5506l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f20191a.compare(this.f20192b.invoke(t), this.f20192b.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$d */
    public static final class d<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5506l f20193a;

        public d(InterfaceC5506l interfaceC5506l) {
            this.f20193a = interfaceC5506l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m21811a;
            m21811a = C5325b.m21811a((Comparable) this.f20193a.invoke(t2), (Comparable) this.f20193a.invoke(t));
            return m21811a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$e */
    public static final class e<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20194a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5506l f20195b;

        public e(Comparator comparator, InterfaceC5506l interfaceC5506l) {
            this.f20194a = comparator;
            this.f20195b = interfaceC5506l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f20194a.compare(this.f20195b.invoke(t2), this.f20195b.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$f */
    static final class f<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20196a;

        f(Comparator comparator) {
            this.f20196a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@InterfaceC5817e T t, @InterfaceC5817e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.f20196a.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$g */
    static final class g<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20197a;

        g(Comparator comparator) {
            this.f20197a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@InterfaceC5817e T t, @InterfaceC5817e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.f20197a.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$h */
    static final class h<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20198a;

        /* renamed from: b */
        final /* synthetic */ Comparator f20199b;

        h(Comparator comparator, Comparator comparator2) {
            this.f20198a = comparator;
            this.f20199b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f20198a.compare(t, t2);
            return compare != 0 ? compare : this.f20199b.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$i */
    public static final class i<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20200a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5506l f20201b;

        public i(Comparator comparator, InterfaceC5506l interfaceC5506l) {
            this.f20200a = comparator;
            this.f20201b = interfaceC5506l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m21811a;
            int compare = this.f20200a.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            m21811a = C5325b.m21811a((Comparable) this.f20201b.invoke(t), (Comparable) this.f20201b.invoke(t2));
            return m21811a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$j */
    public static final class j<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20202a;

        /* renamed from: b */
        final /* synthetic */ Comparator f20203b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC5506l f20204c;

        public j(Comparator comparator, Comparator comparator2, InterfaceC5506l interfaceC5506l) {
            this.f20202a = comparator;
            this.f20203b = comparator2;
            this.f20204c = interfaceC5506l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f20202a.compare(t, t2);
            return compare != 0 ? compare : this.f20203b.compare(this.f20204c.invoke(t), this.f20204c.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$k */
    public static final class k<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20205a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5506l f20206b;

        public k(Comparator comparator, InterfaceC5506l interfaceC5506l) {
            this.f20205a = comparator;
            this.f20206b = interfaceC5506l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m21811a;
            int compare = this.f20205a.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            m21811a = C5325b.m21811a((Comparable) this.f20206b.invoke(t2), (Comparable) this.f20206b.invoke(t));
            return m21811a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$l */
    public static final class l<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20207a;

        /* renamed from: b */
        final /* synthetic */ Comparator f20208b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC5506l f20209c;

        public l(Comparator comparator, Comparator comparator2, InterfaceC5506l interfaceC5506l) {
            this.f20207a = comparator;
            this.f20208b = comparator2;
            this.f20209c = interfaceC5506l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f20207a.compare(t, t2);
            return compare != 0 ? compare : this.f20208b.compare(this.f20209c.invoke(t2), this.f20209c.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$m */
    public static final class m<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20210a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5510p f20211b;

        public m(Comparator comparator, InterfaceC5510p interfaceC5510p) {
            this.f20210a = comparator;
            this.f20211b = interfaceC5510p;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f20210a.compare(t, t2);
            return compare != 0 ? compare : ((Number) this.f20211b.invoke(t, t2)).intValue();
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$n */
    static final class n<T> implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Comparator f20212a;

        /* renamed from: b */
        final /* synthetic */ Comparator f20213b;

        n(Comparator comparator, Comparator comparator2) {
            this.f20212a = comparator;
            this.f20213b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f20212a.compare(t, t2);
            return compare != 0 ? compare : this.f20213b.compare(t2, t);
        }
    }

    /* renamed from: b */
    public static final <T> int m21823b(T t, T t2, @InterfaceC5816d InterfaceC5506l<? super T, ? extends Comparable<?>>... interfaceC5506lArr) {
        C5544i0.m22546f(interfaceC5506lArr, "selectors");
        if (interfaceC5506lArr.length > 0) {
            return m21830c(t, t2, interfaceC5506lArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final <T> int m21830c(T t, T t2, InterfaceC5506l<? super T, ? extends Comparable<?>>[] interfaceC5506lArr) {
        int m21811a;
        for (InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l : interfaceC5506lArr) {
            m21811a = m21811a(interfaceC5506l.invoke(t), interfaceC5506l.invoke(t2));
            if (m21811a != 0) {
                return m21811a;
            }
        }
        return 0;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <T> Comparator<T> m21835d(@InterfaceC5816d Comparator<T> comparator, InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l) {
        return new k(comparator, interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> int m21812a(T t, T t2, InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l) {
        int m21811a;
        m21811a = m21811a(interfaceC5506l.invoke(t), interfaceC5506l.invoke(t2));
        return m21811a;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static <T extends Comparable<? super T>> Comparator<T> m21834d() {
        C5329f c5329f = C5329f.f20215a;
        if (c5329f != null) {
            return c5329f;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T, K> int m21813a(T t, T t2, Comparator<? super K> comparator, InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        return comparator.compare(interfaceC5506l.invoke(t), interfaceC5506l.invoke(t2));
    }

    /* renamed from: a */
    public static <T extends Comparable<?>> int m21811a(@InterfaceC5817e T t, @InterfaceC5817e T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> Comparator<T> m21825b(InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l) {
        return new d(interfaceC5506l);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Comparator<T> m21822a(@InterfaceC5816d InterfaceC5506l<? super T, ? extends Comparable<?>>... interfaceC5506lArr) {
        C5544i0.m22546f(interfaceC5506lArr, "selectors");
        if (interfaceC5506lArr.length > 0) {
            return new a(interfaceC5506lArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T, K> Comparator<T> m21827b(Comparator<? super K> comparator, InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        return new e(comparator, interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> Comparator<T> m21833c(@InterfaceC5816d Comparator<T> comparator, InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l) {
        return new i(comparator, interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T, K> Comparator<T> m21829b(@InterfaceC5816d Comparator<T> comparator, Comparator<? super K> comparator2, InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        return new l(comparator, comparator2, interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T extends Comparable<? super T>> Comparator<T> m21831c() {
        return m21826b(m21815a());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Comparator<T> m21828b(@InterfaceC5816d Comparator<T> comparator, @InterfaceC5816d Comparator<? super T> comparator2) {
        C5544i0.m22546f(comparator, "$this$thenDescending");
        C5544i0.m22546f(comparator2, "comparator");
        return new n(comparator, comparator2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> Comparator<T> m21832c(@InterfaceC5816d Comparator<T> comparator) {
        C5544i0.m22546f(comparator, "$this$reversed");
        if (comparator instanceof C5330g) {
            return ((C5330g) comparator).m21870a();
        }
        if (C5544i0.m22531a(comparator, C5328e.f20214a)) {
            C5329f c5329f = C5329f.f20215a;
            if (c5329f != null) {
                return c5329f;
            }
            throw new C5226e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        if (!C5544i0.m22531a(comparator, C5329f.f20215a)) {
            return new C5330g(comparator);
        }
        C5328e c5328e = C5328e.f20214a;
        if (c5328e != null) {
            return c5328e;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> Comparator<T> m21816a(InterfaceC5506l<? super T, ? extends Comparable<?>> interfaceC5506l) {
        return new b(interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T extends Comparable<? super T>> Comparator<T> m21824b() {
        return m21817a(m21815a());
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T, K> Comparator<T> m21818a(Comparator<? super K> comparator, InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        return new c(comparator, interfaceC5506l);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Comparator<T> m21826b(@InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return new g(comparator);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T, K> Comparator<T> m21821a(@InterfaceC5816d Comparator<T> comparator, Comparator<? super K> comparator2, InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        return new j(comparator, comparator2, interfaceC5506l);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> Comparator<T> m21819a(@InterfaceC5816d Comparator<T> comparator, InterfaceC5510p<? super T, ? super T, Integer> interfaceC5510p) {
        return new m(comparator, interfaceC5510p);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Comparator<T> m21820a(@InterfaceC5816d Comparator<T> comparator, @InterfaceC5816d Comparator<? super T> comparator2) {
        C5544i0.m22546f(comparator, "$this$then");
        C5544i0.m22546f(comparator2, "comparator");
        return new h(comparator, comparator2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Comparator<T> m21817a(@InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return new f(comparator);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> Comparator<T> m21815a() {
        C5328e c5328e = C5328e.f20214a;
        if (c5328e != null) {
            return c5328e;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
}
