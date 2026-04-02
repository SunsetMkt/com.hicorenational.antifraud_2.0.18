package i.h2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.e1;
import i.q2.s.p;
import i.q2.t.i0;
import i.y;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\t\u001aW\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a;\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aW\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a>\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u00a2\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\u0014\u001aZ\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u00a2\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aO\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001aO\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001am\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\b\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u00a8\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", bh.ay, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/comparisons/ComparisonsKt")
public class b {

    /* JADX INFO: compiled from: Comparisons.kt */
    static final class a<T> implements Comparator<T> {
        final /* synthetic */ i.q2.s.l[] a;

        a(i.q2.s.l[] lVarArr) {
            this.a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.c(t, t2, this.a);
        }
    }

    /* JADX INFO: renamed from: i.h2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C0240b<T> implements Comparator<T> {
        final /* synthetic */ i.q2.s.l a;

        public C0240b(i.q2.s.l lVar) {
            this.a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.a((Comparable) this.a.invoke(t), (Comparable) this.a.invoke(t2));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12102b;

        public c(Comparator comparator, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12102b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.a.compare(this.f12102b.invoke(t), this.f12102b.invoke(t2));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator<T> {
        final /* synthetic */ i.q2.s.l a;

        public d(i.q2.s.l lVar) {
            this.a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.a((Comparable) this.a.invoke(t2), (Comparable) this.a.invoke(t));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12103b;

        public e(Comparator comparator, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12103b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.a.compare(this.f12103b.invoke(t2), this.f12103b.invoke(t));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    static final class f<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        f(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@j.c.a.e T t, @j.c.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.a.compare(t, t2);
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    static final class g<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        g(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@j.c.a.e T t, @j.c.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.a.compare(t, t2);
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    static final class h<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f12104b;

        h(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.f12104b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12104b.compare(t, t2);
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class i<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12105b;

        public i(Comparator comparator, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12105b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : b.a((Comparable) this.f12105b.invoke(t), (Comparable) this.f12105b.invoke(t2));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class j<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f12106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12107c;

        public j(Comparator comparator, Comparator comparator2, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12106b = comparator2;
            this.f12107c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12106b.compare(this.f12107c.invoke(t), this.f12107c.invoke(t2));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class k<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12108b;

        public k(Comparator comparator, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12108b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : b.a((Comparable) this.f12108b.invoke(t2), (Comparable) this.f12108b.invoke(t));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class l<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f12109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.q2.s.l f12110c;

        public l(Comparator comparator, Comparator comparator2, i.q2.s.l lVar) {
            this.a = comparator;
            this.f12109b = comparator2;
            this.f12110c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12109b.compare(this.f12110c.invoke(t2), this.f12110c.invoke(t));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class m<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f12111b;

        public m(Comparator comparator, p pVar) {
            this.a = comparator;
            this.f12111b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : ((Number) this.f12111b.invoke(t, t2)).intValue();
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    static final class n<T> implements Comparator<T> {
        final /* synthetic */ Comparator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f12112b;

        n(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.f12112b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12112b.compare(t2, t);
        }
    }

    public static final <T> int b(T t, T t2, @j.c.a.d i.q2.s.l<? super T, ? extends Comparable<?>>... lVarArr) {
        i0.f(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return c(t, t2, lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int c(T t, T t2, i.q2.s.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (i.q2.s.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iA = a(lVar.invoke(t), lVar.invoke(t2));
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }

    @i.m2.f
    private static final <T> Comparator<T> d(@j.c.a.d Comparator<T> comparator, i.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new k(comparator, lVar);
    }

    @i.m2.f
    private static final <T> int a(T t, T t2, i.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return a(lVar.invoke(t), lVar.invoke(t2));
    }

    @j.c.a.d
    public static <T extends Comparable<? super T>> Comparator<T> d() {
        i.h2.f fVar = i.h2.f.a;
        if (fVar != null) {
            return fVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @i.m2.f
    private static final <T, K> int a(T t, T t2, Comparator<? super K> comparator, i.q2.s.l<? super T, ? extends K> lVar) {
        return comparator.compare(lVar.invoke(t), lVar.invoke(t2));
    }

    public static <T extends Comparable<?>> int a(@j.c.a.e T t, @j.c.a.e T t2) {
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

    @i.m2.f
    private static final <T> Comparator<T> b(i.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new d(lVar);
    }

    @j.c.a.d
    public static final <T> Comparator<T> a(@j.c.a.d i.q2.s.l<? super T, ? extends Comparable<?>>... lVarArr) {
        i0.f(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return new a(lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @i.m2.f
    private static final <T, K> Comparator<T> b(Comparator<? super K> comparator, i.q2.s.l<? super T, ? extends K> lVar) {
        return new e(comparator, lVar);
    }

    @i.m2.f
    private static final <T> Comparator<T> c(@j.c.a.d Comparator<T> comparator, i.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new i(comparator, lVar);
    }

    @i.m2.f
    private static final <T, K> Comparator<T> b(@j.c.a.d Comparator<T> comparator, Comparator<? super K> comparator2, i.q2.s.l<? super T, ? extends K> lVar) {
        return new l(comparator, comparator2, lVar);
    }

    @i.m2.f
    private static final <T extends Comparable<? super T>> Comparator<T> c() {
        return b(a());
    }

    @j.c.a.d
    public static final <T> Comparator<T> b(@j.c.a.d Comparator<T> comparator, @j.c.a.d Comparator<? super T> comparator2) {
        i0.f(comparator, "$this$thenDescending");
        i0.f(comparator2, "comparator");
        return new n(comparator, comparator2);
    }

    @j.c.a.d
    public static final <T> Comparator<T> c(@j.c.a.d Comparator<T> comparator) {
        i0.f(comparator, "$this$reversed");
        if (comparator instanceof i.h2.g) {
            return ((i.h2.g) comparator).a();
        }
        if (i0.a(comparator, i.h2.e.a)) {
            i.h2.f fVar = i.h2.f.a;
            if (fVar != null) {
                return fVar;
            }
            throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        if (!i0.a(comparator, i.h2.f.a)) {
            return new i.h2.g(comparator);
        }
        i.h2.e eVar = i.h2.e.a;
        if (eVar != null) {
            return eVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @i.m2.f
    private static final <T> Comparator<T> a(i.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new C0240b(lVar);
    }

    @i.m2.f
    private static final <T extends Comparable<? super T>> Comparator<T> b() {
        return a(a());
    }

    @i.m2.f
    private static final <T, K> Comparator<T> a(Comparator<? super K> comparator, i.q2.s.l<? super T, ? extends K> lVar) {
        return new c(comparator, lVar);
    }

    @j.c.a.d
    public static final <T> Comparator<T> b(@j.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return new g(comparator);
    }

    @i.m2.f
    private static final <T, K> Comparator<T> a(@j.c.a.d Comparator<T> comparator, Comparator<? super K> comparator2, i.q2.s.l<? super T, ? extends K> lVar) {
        return new j(comparator, comparator2, lVar);
    }

    @i.m2.f
    private static final <T> Comparator<T> a(@j.c.a.d Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
        return new m(comparator, pVar);
    }

    @j.c.a.d
    public static final <T> Comparator<T> a(@j.c.a.d Comparator<T> comparator, @j.c.a.d Comparator<? super T> comparator2) {
        i0.f(comparator, "$this$then");
        i0.f(comparator2, "comparator");
        return new h(comparator, comparator2);
    }

    @j.c.a.d
    public static final <T> Comparator<T> a(@j.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return new f(comparator);
    }

    @j.c.a.d
    public static final <T extends Comparable<? super T>> Comparator<T> a() {
        i.h2.e eVar = i.h2.e.a;
        if (eVar != null) {
            return eVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
}
