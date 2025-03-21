package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.InterfaceC3141ad;
import com.umeng.analytics.pro.C3355bl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.a */
/* loaded from: classes2.dex */
public class C3110a {

    /* renamed from: a */
    private Context f10099a;

    /* renamed from: b */
    private long f10100b;

    /* renamed from: c */
    private int f10101c;

    /* renamed from: d */
    private boolean f10102d;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a */
    class a implements Runnable {

        /* renamed from: b */
        private boolean f10107b;

        /* renamed from: c */
        private UserInfoBean f10108c;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.f10108c = userInfoBean;
            this.f10107b = z;
        }

        /* renamed from: a */
        private void m9488a(UserInfoBean userInfoBean) {
            C3113a m9532b;
            if (userInfoBean == null || (m9532b = C3113a.m9532b()) == null) {
                return;
            }
            userInfoBean.f10089j = m9532b.m9569e();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f10108c != null) {
                    m9488a(this.f10108c);
                    C3151an.m9921c("[UserInfo] Record user info.", new Object[0]);
                    C3110a.this.m9474a(this.f10108c, false);
                }
                if (this.f10107b) {
                    C3110a.this.m9486b();
                }
            } catch (Throwable th) {
                if (C3151an.m9916a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C3110a.this.f10100b) {
                C3150am.m9906a().m9909a(C3110a.this.new b(), (C3110a.this.f10100b - currentTimeMillis) + C2084a.f6136r);
            } else {
                C3110a.this.m9483a(3, false, 0L);
                C3110a.this.m9482a();
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$c */
    class c implements Runnable {

        /* renamed from: b */
        private long f10111b;

        public c(long j2) {
            this.f10111b = 21600000L;
            this.f10111b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3110a.this.m9486b();
            C3110a.this.m9487b(this.f10111b);
        }
    }

    public C3110a(Context context, boolean z) {
        this.f10102d = true;
        this.f10099a = context;
        this.f10102d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00ff, B:84:0x0117, B:86:0x011d, B:89:0x0126, B:91:0x012c, B:94:0x0135, B:97:0x013e, B:99:0x0146, B:102:0x014f, B:104:0x0160, B:105:0x0165, B:107:0x016a, B:108:0x016f, B:111:0x017d, B:115:0x016d, B:116:0x0163, B:119:0x0182, B:123:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011d A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00ff, B:84:0x0117, B:86:0x011d, B:89:0x0126, B:91:0x012c, B:94:0x0135, B:97:0x013e, B:99:0x0146, B:102:0x014f, B:104:0x0160, B:105:0x0165, B:107:0x016a, B:108:0x016f, B:111:0x017d, B:115:0x016d, B:116:0x0163, B:119:0x0182, B:123:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0126 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00ff, B:84:0x0117, B:86:0x011d, B:89:0x0126, B:91:0x012c, B:94:0x0135, B:97:0x013e, B:99:0x0146, B:102:0x014f, B:104:0x0160, B:105:0x0165, B:107:0x016a, B:108:0x016f, B:111:0x017d, B:115:0x016d, B:116:0x0163, B:119:0x0182, B:123:0x00e6), top: B:2:0x0001 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m9478c() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C3110a.m9478c():void");
    }

    /* renamed from: b */
    public void m9487b(long j2) {
        C3150am.m9906a().m9909a(new c(j2), j2);
    }

    /* renamed from: a */
    private static UserInfoBean m9473a(Context context, int i2) {
        C3113a m9531a = C3113a.m9531a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f10081b = i2;
        userInfoBean.f10082c = m9531a.f10197e;
        userInfoBean.f10083d = m9531a.m9573g();
        userInfoBean.f10084e = System.currentTimeMillis();
        userInfoBean.f10085f = -1L;
        userInfoBean.f10093n = m9531a.f10208p;
        userInfoBean.f10094o = i2 != 1 ? 0 : 1;
        userInfoBean.f10091l = m9531a.m9559a();
        userInfoBean.f10092m = m9531a.f10215w;
        userInfoBean.f10086g = m9531a.f10216x;
        userInfoBean.f10087h = m9531a.f10217y;
        userInfoBean.f10088i = m9531a.f10218z;
        userInfoBean.f10090k = m9531a.f10134A;
        userInfoBean.f10097r = m9531a.m9536B();
        userInfoBean.f10098s = m9531a.m9541G();
        userInfoBean.f10095p = m9531a.m9542H();
        userInfoBean.f10096q = m9531a.m9543I();
        return userInfoBean;
    }

    /* renamed from: b */
    public void m9486b() {
        C3150am m9906a = C3150am.m9906a();
        if (m9906a != null) {
            m9906a.m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C3110a.this.m9478c();
                    } catch (Throwable th) {
                        C3151an.m9916a(th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m9483a(int i2, boolean z, long j2) {
        C3116a m9635a = C3116a.m9635a();
        if (m9635a != null && !m9635a.m9644c().f10231h && i2 != 1 && i2 != 3) {
            C3151an.m9923e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f10101c++;
        }
        C3150am.m9906a().m9909a(new a(m9473a(this.f10099a, i2), z), j2);
    }

    /* renamed from: a */
    public void m9484a(long j2) {
        C3150am.m9906a().m9909a(new a(null, true), j2);
    }

    /* renamed from: a */
    public void m9482a() {
        this.f10100b = C3154aq.m9978b() + 86400000;
        C3150am.m9906a().m9909a(new b(), (this.f10100b - System.currentTimeMillis()) + C2084a.f6136r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9474a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> m9481a;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f10081b != 1 && (m9481a = m9481a(C3113a.m9531a(this.f10099a).f10197e)) != null && m9481a.size() >= 20) {
            C3151an.m9915a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(m9481a.size()));
            return;
        }
        long m9828a = C3142ae.m9817a().m9828a("t_ui", m9479a(userInfoBean), (InterfaceC3141ad) null, true);
        if (m9828a >= 0) {
            C3151an.m9921c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(m9828a));
            userInfoBean.f10080a = m9828a;
        }
    }

    /* renamed from: a */
    public List<UserInfoBean> m9481a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (C3154aq.m9970a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = C3142ae.m9817a().m9829a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean m9480a = m9480a(cursor);
                    if (m9480a != null) {
                        arrayList.add(m9480a);
                    } else {
                        try {
                            long j2 = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
                            sb.append(" or ");
                            sb.append(C3355bl.f11732d);
                            sb.append(" = ");
                            sb.append(j2);
                        } catch (Throwable unused) {
                            C3151an.m9922d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    C3151an.m9922d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(C3142ae.m9817a().m9827a("t_ui", sb2.substring(4), (String[]) null, (InterfaceC3141ad) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    public void m9485a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append(C3355bl.f11732d);
            sb.append(" = ");
            sb.append(userInfoBean.f10080a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            C3151an.m9921c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C3142ae.m9817a().m9827a("t_ui", str, (String[]) null, (InterfaceC3141ad) null, true)));
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    protected ContentValues m9479a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f10080a > 0) {
                contentValues.put(C3355bl.f11732d, Long.valueOf(userInfoBean.f10080a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f10084e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f10085f));
            contentValues.put(C3355bl.f11733e, Integer.valueOf(userInfoBean.f10081b));
            contentValues.put("_pc", userInfoBean.f10082c);
            contentValues.put("_dt", C3154aq.m9973a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    protected UserInfoBean m9480a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
            UserInfoBean userInfoBean = (UserInfoBean) C3154aq.m9951a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f10080a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
