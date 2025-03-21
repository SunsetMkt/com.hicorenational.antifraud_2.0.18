package p286h.p323z2;

import bean.SurveyH5Bean;
import java.util.LinkedHashMap;
import java.util.Map;
import p286h.C5629v;
import p286h.InterfaceC5604s;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5248b1;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CharCategory.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b \b\u0086\u0001\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006."}, m23546d2 = {"Lkotlin/text/CharCategory;", "", SurveyH5Bean.VALUE, "", "code", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "()I", "contains", "", "char", "", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.a */
/* loaded from: classes2.dex */
public enum EnumC5721a {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");

    public static final b Companion = new b(null);

    /* renamed from: b */
    private static final InterfaceC5604s f20667b;

    @InterfaceC5816d
    private final String code;
    private final int value;

    /* compiled from: CharCategory.kt */
    /* renamed from: h.z2.a$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5495a<Map<Integer, ? extends EnumC5721a>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5495a
        @InterfaceC5816d
        public final Map<Integer, ? extends EnumC5721a> invoke() {
            int m19562b;
            int m23050a;
            EnumC5721a[] values = EnumC5721a.values();
            m19562b = C5248b1.m19562b(values.length);
            m23050a = C5648q.m23050a(m19562b, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(m23050a);
            for (EnumC5721a enumC5721a : values) {
                linkedHashMap.put(Integer.valueOf(enumC5721a.getValue()), enumC5721a);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharCategory.kt */
    /* renamed from: h.z2.a$b */
    public static final class b {
        private b() {
        }

        /* renamed from: a */
        private final Map<Integer, EnumC5721a> m23556a() {
            InterfaceC5604s interfaceC5604s = EnumC5721a.f20667b;
            b bVar = EnumC5721a.Companion;
            return (Map) interfaceC5604s.getValue();
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final EnumC5721a m23557a(int i2) {
            EnumC5721a enumC5721a = m23556a().get(Integer.valueOf(i2));
            if (enumC5721a != null) {
                return enumC5721a;
            }
            throw new IllegalArgumentException("Category #" + i2 + " is not defined.");
        }

        public /* synthetic */ b(C5586v c5586v) {
            this();
        }
    }

    static {
        InterfaceC5604s m22990a;
        m22990a = C5629v.m22990a(a.INSTANCE);
        f20667b = m22990a;
    }

    EnumC5721a(int i2, String str) {
        this.value = i2;
        this.code = str;
    }

    public final boolean contains(char c2) {
        return Character.getType(c2) == this.value;
    }

    @InterfaceC5816d
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
