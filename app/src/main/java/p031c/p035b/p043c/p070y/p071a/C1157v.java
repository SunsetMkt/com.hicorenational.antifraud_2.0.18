package p031c.p035b.p043c.p070y.p071a;

import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.C1107r;

/* compiled from: SMSMMSResultParser.java */
/* renamed from: c.b.c.y.a.v */
/* loaded from: classes.dex */
public final class C1157v extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1158w mo2004a(C1107r c1107r) {
        String str;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        String str2 = null;
        if (!m2128b.startsWith(DefaultWebClient.SCHEME_SMS) && !m2128b.startsWith("SMS:") && !m2128b.startsWith("mms:") && !m2128b.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> m2130b = AbstractC1156u.m2130b(m2128b);
        boolean z = false;
        if (m2130b == null || m2130b.isEmpty()) {
            str = null;
        } else {
            str2 = m2130b.get("subject");
            str = m2130b.get("body");
            z = true;
        }
        int indexOf = m2128b.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? m2128b.substring(4) : m2128b.substring(4, indexOf);
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int indexOf2 = substring.indexOf(44, i3);
            if (indexOf2 <= i2) {
                m2135a(arrayList, arrayList2, substring.substring(i3));
                return new C1158w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            m2135a(arrayList, arrayList2, substring.substring(i3, indexOf2));
            i2 = indexOf2;
        }
    }

    /* renamed from: a */
    private static void m2135a(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            collection2.add(substring.startsWith("via=") ? substring.substring(4) : null);
        }
    }
}
