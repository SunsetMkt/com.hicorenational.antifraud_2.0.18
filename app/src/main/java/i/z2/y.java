package i.z2;

import bean.SurveyH5Bean;
import i.o0;
import i.t0;
import i.y1;

/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
class y extends x {
    @i.c(level = i.d.WARNING, message = "Use append(value: Any?) instead", replaceWith = @o0(expression = "append(value = obj)", imports = {}))
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, Object obj) {
        sb.append(obj);
        i.q2.t.i0.a((Object) sb, "this.append(obj)");
        return sb;
    }

    @i.m2.f
    private static final String a(i.q2.s.l<? super StringBuilder, y1> lVar) {
        StringBuilder sb = new StringBuilder();
        lVar.invoke(sb);
        String string = sb.toString();
        i.q2.t.i0.a((Object) string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final String a(int i2, i.q2.s.l<? super StringBuilder, y1> lVar) {
        StringBuilder sb = new StringBuilder(i2);
        lVar.invoke(sb);
        String string = sb.toString();
        i.q2.t.i0.a((Object) string, "StringBuilder(capacity).\u2026builderAction).toString()");
        return string;
    }

    @j.c.a.d
    public static final StringBuilder a(@j.c.a.d StringBuilder sb, @j.c.a.d String... strArr) {
        i.q2.t.i0.f(sb, "$this$append");
        i.q2.t.i0.f(strArr, SurveyH5Bean.VALUE);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    @j.c.a.d
    public static final StringBuilder a(@j.c.a.d StringBuilder sb, @j.c.a.d Object... objArr) {
        i.q2.t.i0.f(sb, "$this$append");
        i.q2.t.i0.f(objArr, SurveyH5Bean.VALUE);
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
