package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import p031c.p035b.p043c.C1102m;

/* compiled from: FieldParser.java */
/* renamed from: c.b.c.d0.a0.g.e.r */
/* loaded from: classes.dex */
final class C1017r {

    /* renamed from: a */
    private static final Object f1865a = new Object();

    /* renamed from: b */
    private static final Object[][] f1866b = {new Object[]{"00", 18}, new Object[]{HiAnalyticsConstant.KeyAndValue.NUMBER_01, 14}, new Object[]{"02", 14}, new Object[]{"10", f1865a, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{Constants.VIA_REPORT_TYPE_START_GROUP, 6}, new Object[]{"20", 2}, new Object[]{"21", f1865a, 20}, new Object[]{"22", f1865a, 29}, new Object[]{"30", f1865a, 8}, new Object[]{"37", f1865a, 8}, new Object[]{"90", f1865a, 30}, new Object[]{"91", f1865a, 30}, new Object[]{"92", f1865a, 30}, new Object[]{"93", f1865a, 30}, new Object[]{"94", f1865a, 30}, new Object[]{"95", f1865a, 30}, new Object[]{"96", f1865a, 30}, new Object[]{"97", f1865a, 30}, new Object[]{"98", f1865a, 30}, new Object[]{"99", f1865a, 30}};

    /* renamed from: c */
    private static final Object[][] f1867c = {new Object[]{"240", f1865a, 30}, new Object[]{"241", f1865a, 30}, new Object[]{"242", f1865a, 6}, new Object[]{"250", f1865a, 30}, new Object[]{"251", f1865a, 30}, new Object[]{"253", f1865a, 17}, new Object[]{"254", f1865a, 20}, new Object[]{"400", f1865a, 30}, new Object[]{"401", f1865a, 30}, new Object[]{"402", 17}, new Object[]{"403", f1865a, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f1865a, 20}, new Object[]{"421", f1865a, 15}, new Object[]{"422", 3}, new Object[]{"423", f1865a, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};

    /* renamed from: d */
    private static final Object[][] f1868d = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f1865a, 15}, new Object[]{"391", f1865a, 18}, new Object[]{"392", f1865a, 15}, new Object[]{"393", f1865a, 18}, new Object[]{"703", f1865a, 30}};

    /* renamed from: e */
    private static final Object[][] f1869e = {new Object[]{"7001", 13}, new Object[]{"7002", f1865a, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f1865a, 20}, new Object[]{"8003", f1865a, 30}, new Object[]{"8004", f1865a, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f1865a, 30}, new Object[]{"8008", f1865a, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f1865a, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f1865a, 70}, new Object[]{"8200", f1865a, 70}};

    private C1017r() {
    }

    /* renamed from: a */
    static String m1461a(String str) throws C1102m {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw C1102m.getNotFoundInstance();
        }
        String substring = str.substring(0, 2);
        for (Object[] objArr : f1866b) {
            if (objArr[0].equals(substring)) {
                return objArr[1] == f1865a ? m1462b(2, ((Integer) objArr[2]).intValue(), str) : m1460a(2, ((Integer) objArr[1]).intValue(), str);
            }
        }
        if (str.length() < 3) {
            throw C1102m.getNotFoundInstance();
        }
        String substring2 = str.substring(0, 3);
        for (Object[] objArr2 : f1867c) {
            if (objArr2[0].equals(substring2)) {
                return objArr2[1] == f1865a ? m1462b(3, ((Integer) objArr2[2]).intValue(), str) : m1460a(3, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        for (Object[] objArr3 : f1868d) {
            if (objArr3[0].equals(substring2)) {
                return objArr3[1] == f1865a ? m1462b(4, ((Integer) objArr3[2]).intValue(), str) : m1460a(4, ((Integer) objArr3[1]).intValue(), str);
            }
        }
        if (str.length() < 4) {
            throw C1102m.getNotFoundInstance();
        }
        String substring3 = str.substring(0, 4);
        for (Object[] objArr4 : f1869e) {
            if (objArr4[0].equals(substring3)) {
                return objArr4[1] == f1865a ? m1462b(4, ((Integer) objArr4[2]).intValue(), str) : m1460a(4, ((Integer) objArr4[1]).intValue(), str);
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: b */
    private static String m1462b(int i2, int i3, String str) throws C1102m {
        String substring = str.substring(0, i2);
        int i4 = i3 + i2;
        if (str.length() < i4) {
            i4 = str.length();
        }
        String substring2 = str.substring(i2, i4);
        String str2 = '(' + substring + ')' + substring2;
        String m1461a = m1461a(str.substring(i4));
        if (m1461a == null) {
            return str2;
        }
        return str2 + m1461a;
    }

    /* renamed from: a */
    private static String m1460a(int i2, int i3, String str) throws C1102m {
        if (str.length() >= i2) {
            String substring = str.substring(0, i2);
            int i4 = i3 + i2;
            if (str.length() >= i4) {
                String substring2 = str.substring(i2, i4);
                String str2 = '(' + substring + ')' + substring2;
                String m1461a = m1461a(str.substring(i4));
                if (m1461a == null) {
                    return str2;
                }
                return str2 + m1461a;
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }
}
