package p286h.p323z2;

import bean.SurveyH5Bean;
import p286h.C5226e1;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* renamed from: h.z2.t */
/* loaded from: classes2.dex */
public class C5749t {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Appendable> T m24073a(@InterfaceC5816d T t, @InterfaceC5817e CharSequence charSequence, int i2, int i3) {
        C5544i0.m22546f(t, "$this$appendRange");
        T t2 = (T) t.append(charSequence, i2, i3);
        if (t2 != null) {
            return t2;
        }
        throw new C5226e1("null cannot be cast to non-null type T");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Appendable> T m24074a(@InterfaceC5816d T t, @InterfaceC5816d CharSequence... charSequenceArr) {
        C5544i0.m22546f(t, "$this$append");
        C5544i0.m22546f(charSequenceArr, SurveyH5Bean.VALUE);
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> void m24075a(@InterfaceC5816d Appendable appendable, T t, @InterfaceC5817e InterfaceC5506l<? super T, ? extends CharSequence> interfaceC5506l) {
        C5544i0.m22546f(appendable, "$this$appendElement");
        if (interfaceC5506l != null) {
            appendable.append(interfaceC5506l.invoke(t));
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
