package p358k.p359a.p360a.p361a.p362i;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: VersionUpdateHelper.java */
/* renamed from: k.a.a.a.i.c */
/* loaded from: classes2.dex */
public class C5857c {

    /* renamed from: a */
    private static List<InterfaceC5855a> f21139a;

    static {
        ArrayList arrayList = new ArrayList();
        f21139a = arrayList;
        arrayList.add(new C5858d());
        f21139a.add(new C5856b());
    }

    /* renamed from: a */
    public static synchronized void m24653a(Context context) {
        synchronized (C5857c.class) {
            String m24627a = C5849c.m24627a(context);
            int i2 = -1;
            if (!TextUtils.isEmpty(m24627a)) {
                try {
                    i2 = Integer.parseInt(m24627a);
                } catch (Exception unused) {
                    C5863e.m24691a("VersionUpdateHelper", "parse encryptversion error:", true);
                }
            }
            if (i2 < 3) {
                Iterator<InterfaceC5855a> it = f21139a.iterator();
                while (it.hasNext()) {
                    it.next().mo24651a(context, i2, 3);
                }
            }
            C5849c.m24635c(context, String.valueOf(3));
        }
    }
}
