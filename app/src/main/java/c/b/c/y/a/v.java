package c.b.c.y.a;

import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: SMSMMSResultParser.java */
/* loaded from: classes.dex */
public final class v extends u {
    @Override // c.b.c.y.a.u
    public w a(c.b.c.r rVar) {
        String str;
        String b2 = u.b(rVar);
        String str2 = null;
        if (!b2.startsWith(DefaultWebClient.SCHEME_SMS) && !b2.startsWith("SMS:") && !b2.startsWith("mms:") && !b2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> b3 = u.b(b2);
        boolean z = false;
        if (b3 == null || b3.isEmpty()) {
            str = null;
        } else {
            str2 = b3.get("subject");
            str = b3.get("body");
            z = true;
        }
        int indexOf = b2.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? b2.substring(4) : b2.substring(4, indexOf);
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int indexOf2 = substring.indexOf(44, i3);
            if (indexOf2 <= i2) {
                a(arrayList, arrayList2, substring.substring(i3));
                return new w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            a(arrayList, arrayList2, substring.substring(i3, indexOf2));
            i2 = indexOf2;
        }
    }

    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
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
