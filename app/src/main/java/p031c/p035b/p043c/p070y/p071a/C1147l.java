package p031c.p035b.p043c.p070y.p071a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p286h.p323z2.C5736h0;

/* compiled from: ExpandedProductResultParser.java */
/* renamed from: c.b.c.y.a.l */
/* loaded from: classes.dex */
public final class C1147l extends AbstractC1156u {
    /* renamed from: b */
    private static String m2108b(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i2);
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt != '(') {
                sb.append(charAt);
            } else {
                if (m2107a(i3, substring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1145k mo2004a(C1107r c1107r) {
        char c2;
        String substring;
        String str;
        C1145k c1145k = null;
        if (c1107r.m1910a() != EnumC0953a.RSS_EXPANDED) {
            return null;
        }
        String m2128b = AbstractC1156u.m2128b(c1107r);
        HashMap hashMap = new HashMap();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        int i2 = 0;
        while (i2 < m2128b.length()) {
            String m2107a = m2107a(i2, m2128b);
            if (m2107a == null) {
                return c1145k;
            }
            int length = i2 + m2107a.length() + 2;
            String m2108b = m2108b(length, m2128b);
            int length2 = length + m2108b.length();
            int hashCode = m2107a.hashCode();
            String str15 = str12;
            String str16 = str11;
            if (hashCode == 1536) {
                if (m2107a.equals("00")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 1537) {
                if (m2107a.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 1567) {
                if (m2107a.equals("10")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 1568) {
                if (m2107a.equals("11")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode == 1570) {
                if (m2107a.equals("13")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode == 1572) {
                if (m2107a.equals("15")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else if (hashCode != 1574) {
                switch (hashCode) {
                    case 1567966:
                        if (m2107a.equals("3100")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567967:
                        if (m2107a.equals("3101")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567968:
                        if (m2107a.equals("3102")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567969:
                        if (m2107a.equals("3103")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567970:
                        if (m2107a.equals("3104")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567971:
                        if (m2107a.equals("3105")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567972:
                        if (m2107a.equals("3106")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567973:
                        if (m2107a.equals("3107")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567974:
                        if (m2107a.equals("3108")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567975:
                        if (m2107a.equals("3109")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        switch (hashCode) {
                            case 1568927:
                                if (m2107a.equals("3200")) {
                                    c2 = 17;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568928:
                                if (m2107a.equals("3201")) {
                                    c2 = 18;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568929:
                                if (m2107a.equals("3202")) {
                                    c2 = 19;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568930:
                                if (m2107a.equals("3203")) {
                                    c2 = 20;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568931:
                                if (m2107a.equals("3204")) {
                                    c2 = 21;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568932:
                                if (m2107a.equals("3205")) {
                                    c2 = 22;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568933:
                                if (m2107a.equals("3206")) {
                                    c2 = 23;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568934:
                                if (m2107a.equals("3207")) {
                                    c2 = 24;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568935:
                                if (m2107a.equals("3208")) {
                                    c2 = 25;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568936:
                                if (m2107a.equals("3209")) {
                                    c2 = 26;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                switch (hashCode) {
                                    case 1575716:
                                        if (m2107a.equals("3920")) {
                                            c2 = 27;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575717:
                                        if (m2107a.equals("3921")) {
                                            c2 = 28;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575718:
                                        if (m2107a.equals("3922")) {
                                            c2 = 29;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575719:
                                        if (m2107a.equals("3923")) {
                                            c2 = 30;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1575747:
                                                if (m2107a.equals("3930")) {
                                                    c2 = 31;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575748:
                                                if (m2107a.equals("3931")) {
                                                    c2 = ' ';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575749:
                                                if (m2107a.equals("3932")) {
                                                    c2 = '!';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575750:
                                                if (m2107a.equals("3933")) {
                                                    c2 = C5736h0.f20712a;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            default:
                                                c2 = 65535;
                                                break;
                                        }
                                }
                        }
                }
            } else {
                if (m2107a.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                    c2 = 6;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    str3 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 1:
                    str2 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 2:
                    str4 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 3:
                    str5 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 4:
                    str6 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 5:
                    str7 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 6:
                    str8 = m2108b;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                    substring = m2107a.substring(3);
                    str = C1145k.f2347q;
                    str11 = substring;
                    str10 = str;
                    str12 = str15;
                    str9 = m2108b;
                    i2 = length2;
                    c1145k = null;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    substring = m2107a.substring(3);
                    str = C1145k.f2348r;
                    str11 = substring;
                    str10 = str;
                    str12 = str15;
                    str9 = m2108b;
                    i2 = length2;
                    c1145k = null;
                case 27:
                case 28:
                case 29:
                case 30:
                    str13 = m2107a.substring(3);
                    str12 = m2108b;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                case 31:
                case ' ':
                case '!':
                case '\"':
                    if (m2108b.length() < 4) {
                        return null;
                    }
                    str12 = m2108b.substring(3);
                    String substring2 = m2108b.substring(0, 3);
                    str13 = m2107a.substring(3);
                    str14 = substring2;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
                default:
                    hashMap.put(m2107a, m2108b);
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    c1145k = null;
            }
        }
        return new C1145k(m2128b, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, hashMap);
    }

    /* renamed from: a */
    private static String m2107a(int i2, String str) {
        if (str.charAt(i2) != '(') {
            return null;
        }
        String substring = str.substring(i2 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
