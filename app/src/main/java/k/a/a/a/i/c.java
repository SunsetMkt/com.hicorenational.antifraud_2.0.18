package k.a.a.a.i;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.a.a.a.j.e;

/* compiled from: VersionUpdateHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f17030a;

    static {
        ArrayList arrayList = new ArrayList();
        f17030a = arrayList;
        arrayList.add(new d());
        f17030a.add(new b());
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            String a2 = k.a.a.a.c.a(context);
            int i2 = -1;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    i2 = Integer.parseInt(a2);
                } catch (Exception unused) {
                    e.a("VersionUpdateHelper", "parse encryptversion error:", true);
                }
            }
            if (i2 < 3) {
                Iterator<a> it = f17030a.iterator();
                while (it.hasNext()) {
                    it.next().a(context, i2, 3);
                }
            }
            k.a.a.a.c.c(context, String.valueOf(3));
        }
    }
}
