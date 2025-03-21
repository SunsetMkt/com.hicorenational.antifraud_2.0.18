package p286h.p323z2;

import p286h.InterfaceC5440n0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* renamed from: h.z2.d */
/* loaded from: classes2.dex */
public class C5727d {
    @InterfaceC5816d
    /* renamed from: a */
    public static final EnumC5721a m23808a(char c2) {
        return EnumC5721a.Companion.m23557a(Character.getType(c2));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final EnumC5723b m23809b(char c2) {
        return EnumC5723b.Companion.m23568a(Character.getDirectionality(c2));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final boolean m23810c(char c2) {
        return Character.isDefined(c2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final boolean m23811d(char c2) {
        return Character.isDigit(c2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final boolean m23812e(char c2) {
        return Character.isHighSurrogate(c2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final boolean m23813f(char c2) {
        return Character.isISOControl(c2);
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final boolean m23814g(char c2) {
        return Character.isIdentifierIgnorable(c2);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final boolean m23815h(char c2) {
        return Character.isJavaIdentifierPart(c2);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final boolean m23816i(char c2) {
        return Character.isJavaIdentifierStart(c2);
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final boolean m23817j(char c2) {
        return Character.isLetter(c2);
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final boolean m23818k(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final boolean m23819l(char c2) {
        return Character.isLowSurrogate(c2);
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final boolean m23820m(char c2) {
        return Character.isLowerCase(c2);
    }

    @InterfaceC5426f
    /* renamed from: n */
    private static final boolean m23821n(char c2) {
        return Character.isTitleCase(c2);
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final boolean m23822o(char c2) {
        return Character.isUpperCase(c2);
    }

    /* renamed from: p */
    public static final boolean m23823p(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final char m23824q(char c2) {
        return Character.toLowerCase(c2);
    }

    @InterfaceC5426f
    /* renamed from: r */
    private static final char m23825r(char c2) {
        return Character.toTitleCase(c2);
    }

    @InterfaceC5426f
    /* renamed from: s */
    private static final char m23826s(char c2) {
        return Character.toUpperCase(c2);
    }

    /* renamed from: a */
    public static final int m23806a(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static int m23807a(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new C5642k(2, 36));
    }
}
