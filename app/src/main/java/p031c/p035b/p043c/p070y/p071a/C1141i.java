package p031c.p035b.p043c.p070y.p071a;

import com.umeng.ccg.C3438a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;

/* compiled from: EmailAddressResultParser.java */
/* renamed from: c.b.c.y.a.i */
/* loaded from: classes.dex */
public final class C1141i extends AbstractC1156u {

    /* renamed from: f */
    private static final Pattern f2339f = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1139h mo2004a(C1107r c1107r) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("mailto:") && !m2128b.startsWith("MAILTO:")) {
            if (C1143j.m2085e(m2128b)) {
                return new C1139h(m2128b);
            }
            return null;
        }
        String substring = m2128b.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        String m2134d = AbstractC1156u.m2134d(substring);
        String[] split = !m2134d.isEmpty() ? f2339f.split(m2134d) : null;
        Map<String, String> m2130b = AbstractC1156u.m2130b(m2128b);
        if (m2130b != null) {
            if (split == null && (str3 = m2130b.get("to")) != null) {
                split = f2339f.split(str3);
            }
            String str4 = m2130b.get(C3438a.f12328a);
            String[] split2 = str4 != null ? f2339f.split(str4) : null;
            String str5 = m2130b.get("bcc");
            String[] split3 = str5 != null ? f2339f.split(str5) : null;
            String str6 = m2130b.get("subject");
            str2 = m2130b.get("body");
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
        return new C1139h(strArr, strArr2, strArr3, str, str2);
    }
}
