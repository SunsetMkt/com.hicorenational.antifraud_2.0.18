package p031c.p035b.p043c.p072z;

import java.util.HashMap;
import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: CharacterSetECI.java */
/* renamed from: c.b.c.z.d */
/* loaded from: classes.dex */
public enum EnumC1165d {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, C5758c.f20750a),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, C5758c.f20753d, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, C5758c.f20751b),
    Big5(28),
    GB18030(29, C1173l.f2433c, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    /* renamed from: a */
    private static final Map<Integer, EnumC1165d> f2395a = new HashMap();

    /* renamed from: b */
    private static final Map<String, EnumC1165d> f2396b = new HashMap();
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        for (EnumC1165d enumC1165d : values()) {
            for (int i2 : enumC1165d.values) {
                f2395a.put(Integer.valueOf(i2), enumC1165d);
            }
            f2396b.put(enumC1165d.name(), enumC1165d);
            for (String str : enumC1165d.otherEncodingNames) {
                f2396b.put(str, enumC1165d);
            }
        }
    }

    EnumC1165d(int i2) {
        this(new int[]{i2}, new String[0]);
    }

    public static EnumC1165d getCharacterSetECIByName(String str) {
        return f2396b.get(str);
    }

    public static EnumC1165d getCharacterSetECIByValue(int i2) throws C1097h {
        if (i2 < 0 || i2 >= 900) {
            throw C1097h.getFormatInstance();
        }
        return f2395a.get(Integer.valueOf(i2));
    }

    public int getValue() {
        return this.values[0];
    }

    EnumC1165d(int i2, String... strArr) {
        this.values = new int[]{i2};
        this.otherEncodingNames = strArr;
    }

    EnumC1165d(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}
