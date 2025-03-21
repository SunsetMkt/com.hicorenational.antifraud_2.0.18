package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4077af;
import com.xiaomi.push.providers.C4307a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.fz */
/* loaded from: classes2.dex */
public class C4232fz {

    /* renamed from: a */
    private static C4077af f15425a = new C4077af(true);

    /* renamed from: a */
    private static volatile int f15423a = -1;

    /* renamed from: a */
    private static long f15424a = System.currentTimeMillis();

    /* renamed from: a */
    private static final Object f15427a = new Object();

    /* renamed from: a */
    private static List<a> f15429a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    private static String f15428a = "";

    /* renamed from: a */
    private static C4307a f15426a = null;

    /* renamed from: com.xiaomi.push.fz$a */
    static class a {

        /* renamed from: a */
        public int f15431a;

        /* renamed from: a */
        public long f15432a;

        /* renamed from: a */
        public String f15433a;

        /* renamed from: b */
        public int f15434b;

        /* renamed from: b */
        public long f15435b;

        /* renamed from: b */
        public String f15436b;

        public a(String str, long j2, int i2, int i3, String str2, long j3) {
            this.f15433a = "";
            this.f15432a = 0L;
            this.f15431a = -1;
            this.f15434b = -1;
            this.f15436b = "";
            this.f15435b = 0L;
            this.f15433a = str;
            this.f15432a = j2;
            this.f15431a = i2;
            this.f15434b = i3;
            this.f15436b = str2;
            this.f15435b = j3;
        }

        /* renamed from: a */
        public boolean m14923a(a aVar) {
            return TextUtils.equals(aVar.f15433a, this.f15433a) && TextUtils.equals(aVar.f15436b, this.f15436b) && aVar.f15431a == this.f15431a && aVar.f15434b == this.f15434b && Math.abs(aVar.f15432a - this.f15432a) <= C2084a.f6136r;
        }
    }

    /* renamed from: b */
    private static int m14921b(Context context) {
        C4093av m13784a = C4092au.m13784a();
        if (m13784a == null) {
            return -1;
        }
        return m13784a.m13811a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m14922b(Context context, List<a> list) {
        try {
            synchronized (C4307a.f16393a) {
                SQLiteDatabase writableDatabase = m14911a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f15433a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f15432a));
                        contentValues.put(C3351bh.f11568T, Integer.valueOf(aVar.f15431a));
                        contentValues.put("bytes", Long.valueOf(aVar.f15435b));
                        contentValues.put("rcv", Integer.valueOf(aVar.f15434b));
                        contentValues.put(Constants.KEY_IMSI, aVar.f15436b);
                        writableDatabase.insert(C3397d.f11880F, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            AbstractC4022b.m13351a(th);
        }
    }

    /* renamed from: a */
    public static void m14915a(Context context) {
        f15423a = m14921b(context);
    }

    /* renamed from: a */
    public static int m14908a(Context context) {
        if (f15423a == -1) {
            f15423a = m14921b(context);
        }
        return f15423a;
    }

    /* renamed from: a */
    private static synchronized String m14913a(Context context) {
        synchronized (C4232fz.class) {
            if (TextUtils.isEmpty(f15428a)) {
                return "";
            }
            return f15428a;
        }
    }

    /* renamed from: a */
    public static synchronized void m14920a(String str) {
        synchronized (C4232fz.class) {
            if (!C4300j.m15691d() && !TextUtils.isEmpty(str)) {
                f15428a = str;
            }
        }
    }

    /* renamed from: a */
    public static void m14917a(Context context, String str, long j2, boolean z, boolean z2, long j3) {
        m14916a(context, str, m14910a(m14908a(context), j2, z, j3, z2), z, j3);
    }

    /* renamed from: a */
    private static void m14916a(final Context context, String str, long j2, boolean z, long j3) {
        int m14908a;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (m14908a = m14908a(context))) {
            return;
        }
        synchronized (f15427a) {
            isEmpty = f15429a.isEmpty();
            m14919a(new a(str, j3, m14908a, z ? 1 : 0, m14908a == 0 ? m14913a(context) : "", j2));
        }
        if (isEmpty) {
            f15425a.m13720a(new C4077af.b() { // from class: com.xiaomi.push.fz.1
                @Override // com.xiaomi.push.C4077af.b
                /* renamed from: b */
                public void mo13724b() {
                    ArrayList arrayList;
                    synchronized (C4232fz.f15427a) {
                        arrayList = new ArrayList(C4232fz.f15429a);
                        C4232fz.f15429a.clear();
                    }
                    C4232fz.m14922b(context, arrayList);
                }
            }, C2084a.f6136r);
        }
    }

    /* renamed from: a */
    private static long m14910a(int i2, long j2, boolean z, long j3, boolean z2) {
        if (z && z2) {
            long j4 = f15424a;
            f15424a = j3;
            if (j3 - j4 > 30000 && j2 > 1024) {
                return j2 * 2;
            }
        }
        return (j2 * (i2 == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a */
    private static C4307a m14911a(Context context) {
        C4307a c4307a = f15426a;
        if (c4307a != null) {
            return c4307a;
        }
        f15426a = new C4307a(context);
        return f15426a;
    }

    /* renamed from: a */
    public static int m14909a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    /* renamed from: a */
    private static void m14919a(a aVar) {
        for (a aVar2 : f15429a) {
            if (aVar2.m14923a(aVar)) {
                aVar2.f15435b += aVar.f15435b;
                return;
            }
        }
        f15429a.add(aVar);
    }
}
