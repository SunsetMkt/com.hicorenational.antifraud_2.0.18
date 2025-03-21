package p286h.p309q2.p311t;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import p286h.C5718z;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5262g0;
import p286h.p289g2.C5315y;
import p286h.p309q2.C5477a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p320w2.C5678s;
import p286h.p320w2.EnumC5679t;
import p286h.p320w2.InterfaceC5662c;
import p286h.p320w2.InterfaceC5664e;
import p286h.p320w2.InterfaceC5676q;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: TypeReference.kt */
@InterfaceC5610t0(version = "1.4")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, m23546d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", DispatchConstants.OTHER, "", "hashCode", "", "toString", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.q2.t.p1 */
/* loaded from: classes2.dex */
public final class C5566p1 implements InterfaceC5676q {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5664e f20411a;

    /* renamed from: b */
    @InterfaceC5816d
    private final List<C5678s> f20412b;

    /* renamed from: c */
    private final boolean f20413c;

    /* compiled from: TypeReference.kt */
    /* renamed from: h.q2.t.p1$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5506l<C5678s, String> {
        a() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d C5678s c5678s) {
            C5544i0.m22546f(c5678s, "it");
            return C5566p1.this.m22644a(c5678s);
        }
    }

    public C5566p1(@InterfaceC5816d InterfaceC5664e interfaceC5664e, @InterfaceC5816d List<C5678s> list, boolean z) {
        C5544i0.m22546f(interfaceC5664e, "classifier");
        C5544i0.m22546f(list, "arguments");
        this.f20411a = interfaceC5664e;
        this.f20412b = list;
        this.f20413c = z;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5566p1) {
            C5566p1 c5566p1 = (C5566p1) obj;
            if (C5544i0.m22531a(mo22648p(), c5566p1.mo22648p()) && C5544i0.m22531a(mo22647o(), c5566p1.mo22647o()) && mo22646n() == c5566p1.mo22646n()) {
                return true;
            }
        }
        return false;
    }

    @Override // p286h.p320w2.InterfaceC5660a
    @InterfaceC5816d
    public List<Annotation> getAnnotations() {
        return C5315y.m21775b();
    }

    public int hashCode() {
        return (((mo22648p().hashCode() * 31) + mo22647o().hashCode()) * 31) + Boolean.valueOf(mo22646n()).hashCode();
    }

    @Override // p286h.p320w2.InterfaceC5676q
    /* renamed from: n */
    public boolean mo22646n() {
        return this.f20413c;
    }

    @Override // p286h.p320w2.InterfaceC5676q
    @InterfaceC5816d
    /* renamed from: o */
    public List<C5678s> mo22647o() {
        return this.f20412b;
    }

    @Override // p286h.p320w2.InterfaceC5676q
    @InterfaceC5816d
    /* renamed from: p */
    public InterfaceC5664e mo22648p() {
        return this.f20411a;
    }

    @InterfaceC5816d
    public String toString() {
        return m22642a() + " (Kotlin reflection is not available)";
    }

    /* renamed from: a */
    private final String m22642a() {
        InterfaceC5664e mo22648p = mo22648p();
        if (!(mo22648p instanceof InterfaceC5662c)) {
            mo22648p = null;
        }
        InterfaceC5662c interfaceC5662c = (InterfaceC5662c) mo22648p;
        Class<?> m22455a = interfaceC5662c != null ? C5477a.m22455a(interfaceC5662c) : null;
        return (m22455a == null ? mo22648p().toString() : m22455a.isArray() ? m22645a(m22455a) : m22455a.getName()) + (mo22647o().isEmpty() ? "" : C5262g0.m19786a(mo22647o(), ", ", "<", ">", 0, null, new a(), 24, null)) + (mo22646n() ? "?" : "");
    }

    /* renamed from: a */
    private final String m22645a(@InterfaceC5816d Class<?> cls) {
        return C5544i0.m22531a(cls, boolean[].class) ? "kotlin.BooleanArray" : C5544i0.m22531a(cls, char[].class) ? "kotlin.CharArray" : C5544i0.m22531a(cls, byte[].class) ? "kotlin.ByteArray" : C5544i0.m22531a(cls, short[].class) ? "kotlin.ShortArray" : C5544i0.m22531a(cls, int[].class) ? "kotlin.IntArray" : C5544i0.m22531a(cls, float[].class) ? "kotlin.FloatArray" : C5544i0.m22531a(cls, long[].class) ? "kotlin.LongArray" : C5544i0.m22531a(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public final String m22644a(@InterfaceC5816d C5678s c5678s) {
        String valueOf;
        if (c5678s.m23270d() == null) {
            return "*";
        }
        InterfaceC5676q m23269c = c5678s.m23269c();
        if (!(m23269c instanceof C5566p1)) {
            m23269c = null;
        }
        C5566p1 c5566p1 = (C5566p1) m23269c;
        if (c5566p1 == null || (valueOf = c5566p1.m22642a()) == null) {
            valueOf = String.valueOf(c5678s.m23269c());
        }
        EnumC5679t m23270d = c5678s.m23270d();
        if (m23270d != null) {
            int i2 = C5563o1.f20408a[m23270d.ordinal()];
            if (i2 == 1) {
                return valueOf;
            }
            if (i2 == 2) {
                return "in " + valueOf;
            }
            if (i2 == 3) {
                return "out " + valueOf;
            }
        }
        throw new C5718z();
    }
}
