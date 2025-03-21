package p286h.p323z2;

import bean.SurveyH5Bean;
import p286h.C5715y1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: StringBuilder.kt */
/* renamed from: h.z2.y */
/* loaded from: classes2.dex */
class C5754y extends C5753x {
    @InterfaceC5426f
    @InterfaceC5216c(level = EnumC5220d.WARNING, message = "Use append(value: Any?) instead", replaceWith = @InterfaceC5467o0(expression = "append(value = obj)", imports = {}))
    /* renamed from: a */
    private static final StringBuilder m24123a(@InterfaceC5816d StringBuilder sb, Object obj) {
        sb.append(obj);
        C5544i0.m22521a((Object) sb, "this.append(obj)");
        return sb;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m24122a(InterfaceC5506l<? super StringBuilder, C5715y1> interfaceC5506l) {
        StringBuilder sb = new StringBuilder();
        interfaceC5506l.invoke(sb);
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final String m24121a(int i2, InterfaceC5506l<? super StringBuilder, C5715y1> interfaceC5506l) {
        StringBuilder sb = new StringBuilder(i2);
        interfaceC5506l.invoke(sb);
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final StringBuilder m24125a(@InterfaceC5816d StringBuilder sb, @InterfaceC5816d String... strArr) {
        C5544i0.m22546f(sb, "$this$append");
        C5544i0.m22546f(strArr, SurveyH5Bean.VALUE);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final StringBuilder m24124a(@InterfaceC5816d StringBuilder sb, @InterfaceC5816d Object... objArr) {
        C5544i0.m22546f(sb, "$this$append");
        C5544i0.m22546f(objArr, SurveyH5Bean.VALUE);
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
