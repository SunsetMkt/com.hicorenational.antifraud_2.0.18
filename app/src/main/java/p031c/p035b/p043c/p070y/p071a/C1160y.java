package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: SMTPResultParser.java */
/* renamed from: c.b.c.y.a.y */
/* loaded from: classes.dex */
public final class C1160y extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1139h mo2004a(C1107r c1107r) {
        String str;
        String str2;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("smtp:") && !m2128b.startsWith("SMTP:")) {
            return null;
        }
        String substring = m2128b.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            String substring2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            int indexOf2 = substring2.indexOf(58);
            if (indexOf2 >= 0) {
                String substring3 = substring2.substring(indexOf2 + 1);
                str = substring2.substring(0, indexOf2);
                str2 = substring3;
            } else {
                str2 = null;
                str = substring2;
            }
        } else {
            str = null;
            str2 = null;
        }
        return new C1139h(new String[]{substring}, null, null, str, str2);
    }
}
