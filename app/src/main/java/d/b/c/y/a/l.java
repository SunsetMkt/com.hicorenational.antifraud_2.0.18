package d.b.c.y.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.cw;
import java.util.HashMap;

/* JADX INFO: compiled from: ExpandedProductResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends u {
    private static String b(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i2);
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (a(i3, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020d  */
    @Override // d.b.c.y.a.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k a(d.b.c.r rVar) {
        byte b2;
        String strSubstring;
        String str;
        k kVar = null;
        if (rVar.a() != d.b.c.a.RSS_EXPANDED) {
            return null;
        }
        String strB = u.b(rVar);
        HashMap map = new HashMap();
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
        String strSubstring2 = null;
        String strSubstring3 = null;
        String str12 = null;
        int i2 = 0;
        while (i2 < strB.length()) {
            String strA = a(i2, strB);
            if (strA == null) {
                return kVar;
            }
            int length = i2 + strA.length() + 2;
            String strB2 = b(length, strB);
            int length2 = length + strB2.length();
            int iHashCode = strA.hashCode();
            String str13 = strSubstring2;
            String str14 = str11;
            if (iHashCode != 1536) {
                if (iHashCode != 1537) {
                    if (iHashCode != 1567) {
                        if (iHashCode != 1568) {
                            if (iHashCode != 1570) {
                                if (iHashCode != 1572) {
                                    if (iHashCode != 1574) {
                                        switch (iHashCode) {
                                            case 1567966:
                                                b2 = !strA.equals("3100") ? (byte) -1 : (byte) 7;
                                                break;
                                            case 1567967:
                                                if (strA.equals("3101")) {
                                                    b2 = 8;
                                                    break;
                                                }
                                                break;
                                            case 1567968:
                                                if (strA.equals("3102")) {
                                                    b2 = 9;
                                                    break;
                                                }
                                                break;
                                            case 1567969:
                                                if (strA.equals("3103")) {
                                                    b2 = 10;
                                                    break;
                                                }
                                                break;
                                            case 1567970:
                                                if (strA.equals("3104")) {
                                                    b2 = 11;
                                                    break;
                                                }
                                                break;
                                            case 1567971:
                                                if (strA.equals("3105")) {
                                                    b2 = 12;
                                                    break;
                                                }
                                                break;
                                            case 1567972:
                                                if (strA.equals("3106")) {
                                                    b2 = cw.f7203k;
                                                    break;
                                                }
                                                break;
                                            case 1567973:
                                                if (strA.equals("3107")) {
                                                    b2 = cw.f7204l;
                                                    break;
                                                }
                                                break;
                                            case 1567974:
                                                if (strA.equals("3108")) {
                                                    b2 = cw.f7205m;
                                                    break;
                                                }
                                                break;
                                            case 1567975:
                                                if (strA.equals("3109")) {
                                                    b2 = cw.f7206n;
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (iHashCode) {
                                                    case 1568927:
                                                        if (strA.equals("3200")) {
                                                            b2 = 17;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568928:
                                                        if (strA.equals("3201")) {
                                                            b2 = 18;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568929:
                                                        if (strA.equals("3202")) {
                                                            b2 = 19;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568930:
                                                        if (strA.equals("3203")) {
                                                            b2 = 20;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568931:
                                                        if (strA.equals("3204")) {
                                                            b2 = 21;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568932:
                                                        if (strA.equals("3205")) {
                                                            b2 = 22;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568933:
                                                        if (strA.equals("3206")) {
                                                            b2 = 23;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568934:
                                                        if (strA.equals("3207")) {
                                                            b2 = 24;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568935:
                                                        if (strA.equals("3208")) {
                                                            b2 = 25;
                                                            break;
                                                        }
                                                        break;
                                                    case 1568936:
                                                        if (strA.equals("3209")) {
                                                            b2 = 26;
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (iHashCode) {
                                                            case 1575716:
                                                                if (strA.equals("3920")) {
                                                                    b2 = 27;
                                                                    break;
                                                                }
                                                                break;
                                                            case 1575717:
                                                                if (strA.equals("3921")) {
                                                                    b2 = 28;
                                                                    break;
                                                                }
                                                                break;
                                                            case 1575718:
                                                                if (strA.equals("3922")) {
                                                                    b2 = 29;
                                                                    break;
                                                                }
                                                                break;
                                                            case 1575719:
                                                                if (strA.equals("3923")) {
                                                                    b2 = 30;
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (iHashCode) {
                                                                    case 1575747:
                                                                        if (strA.equals("3930")) {
                                                                            b2 = 31;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1575748:
                                                                        if (strA.equals("3931")) {
                                                                            b2 = 32;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1575749:
                                                                        if (strA.equals("3932")) {
                                                                            b2 = 33;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1575750:
                                                                        if (strA.equals("3933")) {
                                                                            b2 = 34;
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                    } else if (strA.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                                        b2 = 6;
                                    }
                                } else if (strA.equals("15")) {
                                    b2 = 5;
                                }
                            } else if (strA.equals("13")) {
                                b2 = 4;
                            }
                        } else if (strA.equals("11")) {
                            b2 = 3;
                        }
                    } else if (strA.equals("10")) {
                        b2 = 2;
                    }
                } else if (strA.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    b2 = 1;
                }
            } else if (strA.equals("00")) {
                b2 = 0;
            }
            switch (b2) {
                case 0:
                    str3 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 1:
                    str2 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 2:
                    str4 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 3:
                    str5 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 4:
                    str6 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 5:
                    str7 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 6:
                    str8 = strB2;
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strA.substring(3);
                    str = k.q;
                    str11 = strSubstring;
                    str10 = str;
                    strSubstring2 = str13;
                    str9 = strB2;
                    i2 = length2;
                    kVar = null;
                    break;
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
                    strSubstring = strA.substring(3);
                    str = k.r;
                    str11 = strSubstring;
                    str10 = str;
                    strSubstring2 = str13;
                    str9 = strB2;
                    i2 = length2;
                    kVar = null;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    strSubstring3 = strA.substring(3);
                    strSubstring2 = strB2;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strB2.length() < 4) {
                        return null;
                    }
                    strSubstring2 = strB2.substring(3);
                    String strSubstring4 = strB2.substring(0, 3);
                    strSubstring3 = strA.substring(3);
                    str12 = strSubstring4;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
                default:
                    map.put(strA, strB2);
                    strSubstring2 = str13;
                    str11 = str14;
                    i2 = length2;
                    kVar = null;
                    break;
            }
        }
        return new k(strB, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, strSubstring2, strSubstring3, str12, map);
    }

    private static String a(int i2, String str) {
        if (str.charAt(i2) != '(') {
            return null;
        }
        String strSubstring = str.substring(i2 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}
