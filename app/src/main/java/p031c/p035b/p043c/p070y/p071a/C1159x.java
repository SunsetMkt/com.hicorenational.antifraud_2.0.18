package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: SMSTOMMSTOResultParser.java */
/* renamed from: c.b.c.y.a.x */
/* loaded from: classes.dex */
public final class C1159x extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1158w mo2004a(C1107r c1107r) {
        String str;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("smsto:") && !m2128b.startsWith("SMSTO:") && !m2128b.startsWith("mmsto:") && !m2128b.startsWith("MMSTO:")) {
            return null;
        }
        String substring = m2128b.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str = null;
        }
        return new C1158w(substring, (String) null, (String) null, str);
    }
}
