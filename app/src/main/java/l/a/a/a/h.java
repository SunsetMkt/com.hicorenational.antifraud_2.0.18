package l.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: compiled from: TerminalInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static String a = "";

    public static String a(Context context, int i2) {
        if (i2 >= 2) {
            return "NULL";
        }
        int i3 = i2 + 1;
        if (TextUtils.isEmpty(a)) {
            a(l.a.a.b.a.a.a(context).a("UUID", ""));
            if (TextUtils.isEmpty(a)) {
                a(UUID.randomUUID().toString());
                if (TextUtils.isEmpty(a)) {
                    return "NULL";
                }
                l.a.a.b.a.a.a(context).b("UUID", a);
            }
        }
        if (!TextUtils.isEmpty(a) && (a.length() > 40 || !com.hihonor.honorid.f.a.c(a))) {
            a = "";
            l.a.a.b.a.a.a(context).a("UUID");
            a = a(context, i3);
        }
        return a;
    }

    private static synchronized void a(String str) {
        a = str;
    }
}
