package i.z2;

import bean.SurveyH5Bean;
import i.e1;
import i.t0;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    @i.j
    @t0(version = "1.3")
    @j.c.a.d
    public static final <T extends Appendable> T a(@j.c.a.d T t, @j.c.a.e CharSequence charSequence, int i2, int i3) {
        i.q2.t.i0.f(t, "$this$appendRange");
        T t2 = (T) t.append(charSequence, i2, i3);
        if (t2 != null) {
            return t2;
        }
        throw new e1("null cannot be cast to non-null type T");
    }

    @j.c.a.d
    public static final <T extends Appendable> T a(@j.c.a.d T t, @j.c.a.d CharSequence... charSequenceArr) throws IOException {
        i.q2.t.i0.f(t, "$this$append");
        i.q2.t.i0.f(charSequenceArr, SurveyH5Bean.VALUE);
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@j.c.a.d Appendable appendable, T t, @j.c.a.e i.q2.s.l<? super T, ? extends CharSequence> lVar) {
        i.q2.t.i0.f(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
