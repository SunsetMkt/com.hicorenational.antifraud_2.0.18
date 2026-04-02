package d.b.c.y.a;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: EmailAddressResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9953f = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    @Override // d.b.c.y.a.u
    public h a(d.b.c.r rVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String strB = u.b(rVar);
        if (!strB.startsWith("mailto:") && !strB.startsWith("MAILTO:")) {
            if (j.e(strB)) {
                return new h(strB);
            }
            return null;
        }
        String strSubstring = strB.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        String strD = u.d(strSubstring);
        String[] strArrSplit = !strD.isEmpty() ? f9953f.split(strD) : null;
        Map<String, String> mapB = u.b(strB);
        if (mapB != null) {
            if (strArrSplit == null && (str3 = mapB.get("to")) != null) {
                strArrSplit = f9953f.split(str3);
            }
            String str4 = mapB.get(com.umeng.ccg.a.a);
            String[] strArrSplit2 = str4 != null ? f9953f.split(str4) : null;
            String str5 = mapB.get("bcc");
            String[] strArrSplit3 = str5 != null ? f9953f.split(str5) : null;
            String str6 = mapB.get("subject");
            str2 = mapB.get("body");
            strArr = strArrSplit;
            strArr3 = strArrSplit3;
            strArr2 = strArrSplit2;
            str = str6;
        } else {
            strArr = strArrSplit;
            strArr2 = null;
            strArr3 = null;
            str = null;
            str2 = null;
        }
        return new h(strArr, strArr2, strArr3, str, str2);
    }
}
