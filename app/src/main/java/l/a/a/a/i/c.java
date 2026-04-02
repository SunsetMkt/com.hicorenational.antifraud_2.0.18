package l.a.a.a.i;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: VersionUpdateHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static List<a> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new d());
        a.add(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001e A[Catch: all -> 0x003d, TryCatch #1 {, blocks: (B:30:0x0003, B:32:0x000e, B:37:0x001e, B:38:0x0024, B:40:0x002a, B:41:0x0034, B:34:0x0013), top: B:49:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context) {
        String strA = l.a.a.a.c.a(context);
        int i2 = -1;
        if (TextUtils.isEmpty(strA)) {
            if (i2 < 3) {
            }
            l.a.a.a.c.c(context, String.valueOf(3));
        } else {
            try {
                i2 = Integer.parseInt(strA);
            } catch (Exception unused) {
                e.a("VersionUpdateHelper", "parse encryptversion error:", true);
            }
            if (i2 < 3) {
                Iterator<a> it = a.iterator();
                while (it.hasNext()) {
                    it.next().a(context, i2, 3);
                }
            }
            l.a.a.a.c.c(context, String.valueOf(3));
        }
    }
}
