package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.cloudwalk.libproject.Contants;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bh;
import com.tencent.bugly.proguard.bi;
import com.tencent.bugly.proguard.bm;
import com.tencent.bugly.proguard.m;
import com.umeng.analytics.pro.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6151d;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BUGLY */
    class RunnableC0111a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private UserInfoBean f6154c;

        public RunnableC0111a(UserInfoBean userInfoBean, boolean z) {
            this.f6154c = userInfoBean;
            this.f6153b = z;
        }

        private void a(UserInfoBean userInfoBean) {
            com.tencent.bugly.crashreport.common.info.a aVarB;
            if (userInfoBean == null || (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
                return;
            }
            userInfoBean.f6144j = aVarB.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f6154c != null) {
                    a(this.f6154c);
                    an.c("[UserInfo] Record user info.", new Object[0]);
                    a.this.a(this.f6154c, false);
                }
                if (this.f6153b) {
                    a.this.b();
                }
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < a.this.f6149b) {
                am.a().a(a.this.new b(), (a.this.f6149b - jCurrentTimeMillis) + com.heytap.mcssdk.constant.a.r);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6155b;

        public c(long j2) {
            this.f6155b = 21600000L;
            this.f6155b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            a.this.b(this.f6155b);
        }
    }

    public a(Context context, boolean z) {
        this.f6151d = true;
        this.a = context;
        this.f6151d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:112:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c() {
        boolean z;
        bm bmVarA;
        if (this.f6151d) {
            ak akVarA = ak.a();
            if (akVarA == null) {
                return;
            }
            com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
            if (aVarA == null) {
                return;
            }
            if (!aVarA.b() || akVarA.b(1001)) {
                String str = com.tencent.bugly.crashreport.common.info.a.a(this.a).f6176e;
                ArrayList arrayList = new ArrayList();
                final List<UserInfoBean> listA = a(str);
                if (listA != null) {
                    int size = listA.size() - 20;
                    if (size > 0) {
                        int i2 = 0;
                        while (i2 < listA.size() - 1) {
                            int i3 = i2 + 1;
                            for (int i4 = i3; i4 < listA.size(); i4++) {
                                if (listA.get(i2).f6139e > listA.get(i4).f6139e) {
                                    UserInfoBean userInfoBean = listA.get(i2);
                                    listA.set(i2, listA.get(i4));
                                    listA.set(i4, userInfoBean);
                                }
                            }
                            i2 = i3;
                        }
                        for (int i5 = 0; i5 < size; i5++) {
                            arrayList.add(listA.get(i5));
                        }
                    }
                    Iterator<UserInfoBean> it = listA.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        UserInfoBean next = it.next();
                        if (next.f6140f != -1) {
                            it.remove();
                            if (next.f6139e < aq.b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.f6139e > System.currentTimeMillis() - 600000 && (next.f6136b == 1 || next.f6136b == 4 || next.f6136b == 3)) {
                            i6++;
                        }
                    }
                    if (i6 > 15) {
                        an.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i6));
                        z = false;
                    }
                    if (arrayList.size() > 0) {
                        a(arrayList);
                    }
                    if (z && listA.size() != 0) {
                        an.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                        bmVarA = ah.a(listA, this.f6150c != 1 ? 1 : 2);
                        if (bmVarA != null) {
                            an.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                            return;
                        }
                        byte[] bArrA = ah.a((m) bmVarA);
                        if (bArrA == null) {
                            an.d("[UserInfo] Failed to encode data.", new Object[0]);
                            return;
                        }
                        bh bhVarA = ah.a(this.a, akVarA.f6377b ? 840 : Contants.PREVIEW_W, bArrA);
                        if (bhVarA == null) {
                            an.d("[UserInfo] Request package is null.", new Object[0]);
                            return;
                        }
                        aj ajVar = new aj() { // from class: com.tencent.bugly.crashreport.biz.a.1
                            @Override // com.tencent.bugly.proguard.aj
                            public void a(int i7) {
                            }

                            @Override // com.tencent.bugly.proguard.aj
                            public void a(int i7, bi biVar, long j2, long j3, boolean z2, String str2) {
                                if (z2) {
                                    an.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    for (UserInfoBean userInfoBean2 : listA) {
                                        userInfoBean2.f6140f = jCurrentTimeMillis;
                                        a.this.a(userInfoBean2, true);
                                    }
                                }
                            }
                        };
                        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                        ak.a().a(1001, bhVarA, akVarA.f6377b ? strategyBeanC.r : strategyBeanC.t, akVarA.f6377b ? StrategyBean.f6190b : StrategyBean.a, ajVar, this.f6150c == 1);
                        return;
                    }
                    an.c("[UserInfo] There is no user info in local database.", new Object[0]);
                }
                listA = new ArrayList<>();
                z = true;
                if (arrayList.size() > 0) {
                }
                if (z) {
                    an.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                    bmVarA = ah.a(listA, this.f6150c != 1 ? 1 : 2);
                    if (bmVarA != null) {
                    }
                }
                an.c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        }
    }

    public void b(long j2) {
        am.a().a(new c(j2), j2);
    }

    private static UserInfoBean a(Context context, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f6136b = i2;
        userInfoBean.f6137c = aVarA.f6176e;
        userInfoBean.f6138d = aVarA.g();
        userInfoBean.f6139e = System.currentTimeMillis();
        userInfoBean.f6140f = -1L;
        userInfoBean.f6148n = aVarA.p;
        userInfoBean.o = i2 != 1 ? 0 : 1;
        userInfoBean.f6146l = aVarA.a();
        userInfoBean.f6147m = aVarA.w;
        userInfoBean.f6141g = aVarA.x;
        userInfoBean.f6142h = aVarA.y;
        userInfoBean.f6143i = aVarA.z;
        userInfoBean.f6145k = aVarA.A;
        userInfoBean.r = aVarA.B();
        userInfoBean.s = aVarA.G();
        userInfoBean.p = aVarA.H();
        userInfoBean.q = aVarA.I();
        return userInfoBean;
    }

    public void b() {
        am amVarA = am.a();
        if (amVarA != null) {
            amVarA.a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.c();
                    } catch (Throwable th) {
                        an.a(th);
                    }
                }
            });
        }
    }

    public void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null && !aVarA.c().f6196h && i2 != 1 && i2 != 3) {
            an.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f6150c++;
        }
        am.a().a(new RunnableC0111a(a(this.a, i2), z), j2);
    }

    public void a(long j2) {
        am.a().a(new RunnableC0111a(null, true), j2);
    }

    public void a() {
        this.f6149b = aq.b() + 86400000;
        am.a().a(new b(), (this.f6149b - System.currentTimeMillis()) + com.heytap.mcssdk.constant.a.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> listA;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f6136b != 1 && (listA = a(com.tencent.bugly.crashreport.common.info.a.a(this.a).f6176e)) != null && listA.size() >= 20) {
            an.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listA.size()));
            return;
        }
        long jA = ae.a().a("t_ui", a(userInfoBean), (ad) null, true);
        if (jA >= 0) {
            an.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jA));
            userInfoBean.a = jA;
        }
    }

    public List<UserInfoBean> a(String str) {
        Cursor cursorA;
        String str2;
        try {
            if (aq.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorA = ae.a().a("t_ui", null, str2, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorA.moveToNext()) {
                    UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            long j2 = cursorA.getLong(cursorA.getColumnIndex(bl.f7101d));
                            sb.append(" or ");
                            sb.append(bl.f7101d);
                            sb.append(" = ");
                            sb.append(j2);
                        } catch (Throwable unused) {
                            an.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    an.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", string.substring(4), (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append(bl.f7101d);
            sb.append(" = ");
            sb.append(userInfoBean.a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        String str = string;
        sb.setLength(0);
        try {
            an.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(ae.a().a("t_ui", str, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.a > 0) {
                contentValues.put(bl.f7101d, Long.valueOf(userInfoBean.a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f6139e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f6140f));
            contentValues.put(bl.f7102e, Integer.valueOf(userInfoBean.f6136b));
            contentValues.put("_pc", userInfoBean.f6137c);
            contentValues.put("_dt", aq.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(bl.f7101d));
            UserInfoBean userInfoBean = (UserInfoBean) aq.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
