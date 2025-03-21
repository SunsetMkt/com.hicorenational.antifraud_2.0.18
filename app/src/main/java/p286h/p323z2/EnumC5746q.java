package p286h.p323z2;

import p286h.p309q2.p311t.C5586v;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Regex.kt */
/* renamed from: h.z2.q */
/* loaded from: classes2.dex */
public final class EnumC5746q implements InterfaceC5737i {
    public static final EnumC5746q CANON_EQ;
    public static final EnumC5746q COMMENTS;
    public static final EnumC5746q DOT_MATCHES_ALL;
    public static final EnumC5746q IGNORE_CASE;
    public static final EnumC5746q LITERAL;
    public static final EnumC5746q MULTILINE;
    public static final EnumC5746q UNIX_LINES;

    /* renamed from: a */
    private static final /* synthetic */ EnumC5746q[] f20747a;
    private final int mask;
    private final int value;

    static {
        EnumC5746q enumC5746q = new EnumC5746q("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = enumC5746q;
        EnumC5746q enumC5746q2 = new EnumC5746q("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = enumC5746q2;
        int i2 = 0;
        int i3 = 2;
        C5586v c5586v = null;
        EnumC5746q enumC5746q3 = new EnumC5746q("LITERAL", 2, 16, i2, i3, c5586v);
        LITERAL = enumC5746q3;
        EnumC5746q enumC5746q4 = new EnumC5746q("UNIX_LINES", 3, 1, i2, i3, c5586v);
        UNIX_LINES = enumC5746q4;
        EnumC5746q enumC5746q5 = new EnumC5746q("COMMENTS", 4, 4, i2, i3, c5586v);
        COMMENTS = enumC5746q5;
        EnumC5746q enumC5746q6 = new EnumC5746q("DOT_MATCHES_ALL", 5, 32, i2, i3, c5586v);
        DOT_MATCHES_ALL = enumC5746q6;
        EnumC5746q enumC5746q7 = new EnumC5746q("CANON_EQ", 6, 128, i2, i3, c5586v);
        CANON_EQ = enumC5746q7;
        f20747a = new EnumC5746q[]{enumC5746q, enumC5746q2, enumC5746q3, enumC5746q4, enumC5746q5, enumC5746q6, enumC5746q7};
    }

    private EnumC5746q(String str, int i2, int i3, int i4) {
        this.value = i3;
        this.mask = i4;
    }

    public static EnumC5746q valueOf(String str) {
        return (EnumC5746q) Enum.valueOf(EnumC5746q.class, str);
    }

    public static EnumC5746q[] values() {
        return (EnumC5746q[]) f20747a.clone();
    }

    @Override // p286h.p323z2.InterfaceC5737i
    public int getMask() {
        return this.mask;
    }

    @Override // p286h.p323z2.InterfaceC5737i
    public int getValue() {
        return this.value;
    }

    /* synthetic */ EnumC5746q(String str, int i2, int i3, int i4, int i5, C5586v c5586v) {
        this(str, i2, i3, (i5 & 2) != 0 ? i3 : i4);
    }
}
