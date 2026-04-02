package d.b.c.z;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CharacterSetECI.java */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, j.a.a.a.c.a),
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
    UnicodeBigUnmarked(25, j.a.a.a.c.f12442d, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, j.a.a.a.c.f12440b),
    Big5(28),
    GB18030(29, l.f10031c, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static final Map<Integer, d> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, d> f9999b = new HashMap();
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        for (d dVar : values()) {
            for (int i2 : dVar.values) {
                a.put(Integer.valueOf(i2), dVar);
            }
            f9999b.put(dVar.name(), dVar);
            for (String str : dVar.otherEncodingNames) {
                f9999b.put(str, dVar);
            }
        }
    }

    d(int i2) {
        this(new int[]{i2}, new String[0]);
    }

    public static d getCharacterSetECIByName(String str) {
        return f9999b.get(str);
    }

    public static d getCharacterSetECIByValue(int i2) throws d.b.c.h {
        if (i2 < 0 || i2 >= 900) {
            throw d.b.c.h.getFormatInstance();
        }
        return a.get(Integer.valueOf(i2));
    }

    public int getValue() {
        return this.values[0];
    }

    d(int i2, String... strArr) {
        this.values = new int[]{i2};
        this.otherEncodingNames = strArr;
    }

    d(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}
