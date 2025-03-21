package c.b.c.y.a;

/* compiled from: TelResultParser.java */
/* loaded from: classes.dex */
public final class a0 extends u {
    @Override // c.b.c.y.a.u
    public z a(c.b.c.r rVar) {
        String str;
        String b2 = u.b(rVar);
        if (!b2.startsWith("tel:") && !b2.startsWith("TEL:")) {
            return null;
        }
        if (b2.startsWith("TEL:")) {
            str = "tel:" + b2.substring(4);
        } else {
            str = b2;
        }
        int indexOf = b2.indexOf(63, 4);
        return new z(indexOf < 0 ? b2.substring(4) : b2.substring(4, indexOf), str, null);
    }
}
