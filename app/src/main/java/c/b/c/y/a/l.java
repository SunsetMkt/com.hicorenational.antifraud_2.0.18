package c.b.c.y.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import java.util.HashMap;

/* compiled from: ExpandedProductResultParser.java */
/* loaded from: classes.dex */
public final class l extends u {
    private static String b(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i2);
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt != '(') {
                sb.append(charAt);
            } else {
                if (a(i3, substring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // c.b.c.y.a.u
    public k a(c.b.c.r rVar) {
        char c2;
        String substring;
        String str;
        k kVar = null;
        if (rVar.a() != c.b.c.a.RSS_EXPANDED) {
            return null;
        }
        String b2 = u.b(rVar);
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
        while (i2 < b2.length()) {
            String a2 = a(i2, b2);
            if (a2 == null) {
                return kVar;
            }
            int length = i2 + a2.length() + 2;
            String b3 = b(length, b2);
            int length2 = length + b3.length();
            int hashCode = a2.hashCode();
            String str15 = str12;
            String str16 = str11;
            if (hashCode == 1536) {
                if (a2.equals("00")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 1537) {
                if (a2.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 1567) {
                if (a2.equals("10")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 1568) {
                if (a2.equals("11")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode == 1570) {
                if (a2.equals("13")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode == 1572) {
                if (a2.equals("15")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else if (hashCode != 1574) {
                switch (hashCode) {
                    case 1567966:
                        if (a2.equals("3100")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567967:
                        if (a2.equals("3101")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567968:
                        if (a2.equals("3102")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567969:
                        if (a2.equals("3103")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567970:
                        if (a2.equals("3104")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567971:
                        if (a2.equals("3105")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567972:
                        if (a2.equals("3106")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567973:
                        if (a2.equals("3107")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567974:
                        if (a2.equals("3108")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567975:
                        if (a2.equals("3109")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        switch (hashCode) {
                            case 1568927:
                                if (a2.equals("3200")) {
                                    c2 = 17;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568928:
                                if (a2.equals("3201")) {
                                    c2 = 18;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568929:
                                if (a2.equals("3202")) {
                                    c2 = 19;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568930:
                                if (a2.equals("3203")) {
                                    c2 = 20;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568931:
                                if (a2.equals("3204")) {
                                    c2 = 21;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568932:
                                if (a2.equals("3205")) {
                                    c2 = 22;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568933:
                                if (a2.equals("3206")) {
                                    c2 = 23;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568934:
                                if (a2.equals("3207")) {
                                    c2 = 24;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568935:
                                if (a2.equals("3208")) {
                                    c2 = 25;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1568936:
                                if (a2.equals("3209")) {
                                    c2 = 26;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                switch (hashCode) {
                                    case 1575716:
                                        if (a2.equals("3920")) {
                                            c2 = 27;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575717:
                                        if (a2.equals("3921")) {
                                            c2 = 28;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575718:
                                        if (a2.equals("3922")) {
                                            c2 = 29;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1575719:
                                        if (a2.equals("3923")) {
                                            c2 = 30;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1575747:
                                                if (a2.equals("3930")) {
                                                    c2 = 31;
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575748:
                                                if (a2.equals("3931")) {
                                                    c2 = ' ';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575749:
                                                if (a2.equals("3932")) {
                                                    c2 = '!';
                                                    break;
                                                }
                                                c2 = 65535;
                                                break;
                                            case 1575750:
                                                if (a2.equals("3933")) {
                                                    c2 = h.z2.h0.f16704a;
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
                if (a2.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                    c2 = 6;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    str3 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 1:
                    str2 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 2:
                    str4 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 3:
                    str5 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 4:
                    str6 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 5:
                    str7 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 6:
                    str8 = b3;
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
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
                    substring = a2.substring(3);
                    str = k.q;
                    str11 = substring;
                    str10 = str;
                    str12 = str15;
                    str9 = b3;
                    i2 = length2;
                    kVar = null;
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
                    substring = a2.substring(3);
                    str = k.r;
                    str11 = substring;
                    str10 = str;
                    str12 = str15;
                    str9 = b3;
                    i2 = length2;
                    kVar = null;
                case 27:
                case 28:
                case 29:
                case 30:
                    str13 = a2.substring(3);
                    str12 = b3;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                case 31:
                case ' ':
                case '!':
                case '\"':
                    if (b3.length() < 4) {
                        return null;
                    }
                    str12 = b3.substring(3);
                    String substring2 = b3.substring(0, 3);
                    str13 = a2.substring(3);
                    str14 = substring2;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
                default:
                    hashMap.put(a2, b3);
                    str12 = str15;
                    str11 = str16;
                    i2 = length2;
                    kVar = null;
            }
        }
        return new k(b2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, hashMap);
    }

    private static String a(int i2, String str) {
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
