package p286h.p323z2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5309w;
import p286h.p289g2.C5315y;
import p286h.p289g2.C5318z;
import p286h.p304m2.C5432l;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.C5707u;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Indent.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, m23546d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/text/StringsKt")
/* renamed from: h.z2.u */
/* loaded from: classes2.dex */
class C5750u extends C5749t {

    /* compiled from: Indent.kt */
    /* renamed from: h.z2.u$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5506l<String, String> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "line");
            return str;
        }
    }

    /* compiled from: Indent.kt */
    /* renamed from: h.z2.u$b */
    static final class b extends AbstractC5547j0 implements InterfaceC5506l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "line");
            return this.$indent + str;
        }
    }

    /* compiled from: Indent.kt */
    /* renamed from: h.z2.u$c */
    static final class c extends AbstractC5547j0 implements InterfaceC5506l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "it");
            if (C5724b0.m23599a((CharSequence) str)) {
                return str.length() < this.$indent.length() ? this.$indent : str;
            }
            return this.$indent + str;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m24080a(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        if ((i2 & 2) != 0) {
            str3 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return m24079a(str, str2, str3);
    }

    /* renamed from: b */
    public static /* synthetic */ String m24084b(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        return m24083b(str, str2);
    }

    /* renamed from: c */
    public static /* synthetic */ String m24087c(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return m24086c(str, str2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m24079a(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        int i2;
        String invoke;
        C5544i0.m22546f(str, "$this$replaceIndentByMargin");
        C5544i0.m22546f(str2, "newIndent");
        C5544i0.m22546f(str3, "marginPrefix");
        if (!(!C5724b0.m23599a((CharSequence) str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> m23798k = C5726c0.m23798k((CharSequence) str);
        int length = str.length() + (str2.length() * m23798k.size());
        InterfaceC5506l<String, String> m24076a = m24076a(str2);
        int m21757a = C5315y.m21757a((List) m23798k);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : m23798k) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                C5315y.m21790f();
            }
            String str4 = (String) obj;
            String str5 = null;
            if ((i3 == 0 || i3 == m21757a) && C5724b0.m23599a((CharSequence) str4)) {
                str4 = null;
            } else {
                int length2 = str4.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i2 = -1;
                        break;
                    }
                    if (!C5727d.m23823p(str4.charAt(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = i2;
                    if (C5724b0.m23606a(str4, str3, i2, false, 4, (Object) null)) {
                        int length3 = i6 + str3.length();
                        if (str4 == null) {
                            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
                        }
                        str5 = str4.substring(length3);
                        C5544i0.m22521a((Object) str5, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (str5 != null && (invoke = m24076a.invoke(str5)) != null) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i3 = i4;
        }
        String sb = ((StringBuilder) C5309w.m21715a(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        C5544i0.m22521a((Object) sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m24083b(@InterfaceC5816d String str, @InterfaceC5816d String str2) {
        String invoke;
        C5544i0.m22546f(str, "$this$replaceIndent");
        C5544i0.m22546f(str2, "newIndent");
        List<String> m23798k = C5726c0.m23798k((CharSequence) str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : m23798k) {
            if (!C5724b0.m23599a((CharSequence) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C5318z.m21796a(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(m24082b((String) it.next())));
        }
        Integer num = (Integer) C5309w.m21736y((Iterable) arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * m23798k.size());
        InterfaceC5506l<String, String> m24076a = m24076a(str2);
        int m21757a = C5315y.m21757a((List) m23798k);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : m23798k) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C5315y.m21790f();
            }
            String str3 = (String) obj2;
            if ((i2 == 0 || i2 == m21757a) && C5724b0.m23599a((CharSequence) str3)) {
                str3 = null;
            } else {
                String m23916f = C5730e0.m23916f(str3, intValue);
                if (m23916f != null && (invoke = m24076a.invoke(m23916f)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) C5309w.m21715a(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        C5544i0.m22521a((Object) sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m24086c(@InterfaceC5816d String str, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "$this$trimMargin");
        C5544i0.m22546f(str2, "marginPrefix");
        return m24079a(str, "", str2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m24085c(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$trimIndent");
        return m24083b(str, "");
    }

    /* renamed from: a */
    public static /* synthetic */ String m24078a(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "    ";
        }
        return m24077a(str, str2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m24077a(@InterfaceC5816d String str, @InterfaceC5816d String str2) {
        String m23414a;
        C5544i0.m22546f(str, "$this$prependIndent");
        C5544i0.m22546f(str2, "indent");
        m23414a = C5707u.m23414a(C5707u.m23502w(C5726c0.m23797j((CharSequence) str), new c(str2)), "\n", null, null, 0, null, null, 62, null);
        return m23414a;
    }

    /* renamed from: b */
    private static final int m24082b(@InterfaceC5816d String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!C5727d.m23823p(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    /* renamed from: a */
    private static final InterfaceC5506l<String, String> m24076a(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    /* renamed from: a */
    private static final String m24081a(@InterfaceC5816d List<String> list, int i2, InterfaceC5506l<? super String, String> interfaceC5506l, InterfaceC5506l<? super String, String> interfaceC5506l2) {
        String invoke;
        int m21757a = C5315y.m21757a((List) list);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                if (!C5432l.m22181a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                C5315y.m21790f();
            }
            String str = (String) obj;
            if ((i3 == 0 || i3 == m21757a) && C5724b0.m23599a((CharSequence) str)) {
                str = null;
            } else {
                String invoke2 = interfaceC5506l2.invoke(str);
                if (invoke2 != null && (invoke = interfaceC5506l.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i3 = i4;
        }
        String sb = ((StringBuilder) C5309w.m21715a(arrayList, new StringBuilder(i2), "\n", null, null, 0, null, null, 124, null)).toString();
        C5544i0.m22521a((Object) sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }
}
