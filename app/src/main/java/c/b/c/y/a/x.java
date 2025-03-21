package c.b.c.y.a;

/* compiled from: SMSTOMMSTOResultParser.java */
/* loaded from: classes.dex */
public final class x extends u {
    @Override // c.b.c.y.a.u
    public w a(c.b.c.r rVar) {
        String str;
        String b2 = u.b(rVar);
        if (!b2.startsWith("smsto:") && !b2.startsWith("SMSTO:") && !b2.startsWith("mmsto:") && !b2.startsWith("MMSTO:")) {
            return null;
        }
        String substring = b2.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str = null;
        }
        return new w(substring, (String) null, (String) null, str);
    }
}
