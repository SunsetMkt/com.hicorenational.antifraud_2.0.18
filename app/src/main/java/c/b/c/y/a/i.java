package c.b.c.y.a;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: EmailAddressResultParser.java */
/* loaded from: classes.dex */
public final class i extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2958f = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    @Override // c.b.c.y.a.u
    public h a(c.b.c.r rVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String b2 = u.b(rVar);
        if (!b2.startsWith("mailto:") && !b2.startsWith("MAILTO:")) {
            if (j.e(b2)) {
                return new h(b2);
            }
            return null;
        }
        String substring = b2.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        String d2 = u.d(substring);
        String[] split = !d2.isEmpty() ? f2958f.split(d2) : null;
        Map<String, String> b3 = u.b(b2);
        if (b3 != null) {
            if (split == null && (str3 = b3.get("to")) != null) {
                split = f2958f.split(str3);
            }
            String str4 = b3.get(com.umeng.ccg.a.f10591a);
            String[] split2 = str4 != null ? f2958f.split(str4) : null;
            String str5 = b3.get("bcc");
            String[] split3 = str5 != null ? f2958f.split(str5) : null;
            String str6 = b3.get("subject");
            str2 = b3.get("body");
            strArr = split;
            strArr3 = split3;
            strArr2 = split2;
            str = str6;
        } else {
            strArr = split;
            strArr2 = null;
            strArr3 = null;
            str = null;
            str2 = null;
        }
        return new h(strArr, strArr2, strArr3, str, str2);
    }
}
