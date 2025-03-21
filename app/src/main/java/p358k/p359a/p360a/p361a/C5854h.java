package p358k.p359a.p360a.p361a;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.honorid.p165f.C2171a;
import java.util.UUID;
import p358k.p359a.p360a.p365b.p366a.C5865a;

/* compiled from: TerminalInfo.java */
/* renamed from: k.a.a.a.h */
/* loaded from: classes2.dex */
public class C5854h {

    /* renamed from: a */
    private static String f21138a = "";

    /* renamed from: a */
    public static String m24649a(Context context, int i2) {
        if (i2 >= 2) {
            return "NULL";
        }
        int i3 = i2 + 1;
        if (TextUtils.isEmpty(f21138a)) {
            m24650a(C5865a.m24711a(context).m24712a("UUID", ""));
            if (TextUtils.isEmpty(f21138a)) {
                m24650a(UUID.randomUUID().toString());
                if (TextUtils.isEmpty(f21138a)) {
                    return "NULL";
                }
                C5865a.m24711a(context).m24714b("UUID", f21138a);
            }
        }
        if (!TextUtils.isEmpty(f21138a) && (f21138a.length() > 40 || !C2171a.m6325c(f21138a))) {
            f21138a = "";
            C5865a.m24711a(context).m24713a("UUID");
            f21138a = m24649a(context, i3);
        }
        return f21138a;
    }

    /* renamed from: a */
    private static synchronized void m24650a(String str) {
        synchronized (C5854h.class) {
            f21138a = str;
        }
    }
}
