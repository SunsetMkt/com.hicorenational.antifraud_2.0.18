package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.AbstractC3071a;
import com.umeng.analytics.pro.C3355bl;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ae */
/* loaded from: classes2.dex */
public class C3142ae {

    /* renamed from: a */
    public static boolean f10480a = false;

    /* renamed from: b */
    private static C3142ae f10481b;

    /* renamed from: c */
    private static C3143af f10482c;

    private C3142ae(Context context, List<AbstractC3071a> list) {
        f10482c = new C3143af(context, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00cb, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e6, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00c9, code lost:
    
        if (r1 != null) goto L44;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.C3144ag> m9825c(int r12) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9825c(int):java.util.List");
    }

    /* renamed from: d */
    private synchronized boolean m9826d(C3144ag c3144ag) {
        ContentValues m9841c;
        if (c3144ag == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f10482c.getWritableDatabase();
            if (sQLiteDatabase == null || (m9841c = m9841c(c3144ag)) == null) {
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            }
            long replace = sQLiteDatabase.replace("t_pf", C3355bl.f11732d, m9841c);
            if (replace >= 0) {
                C3151an.m9921c("[Database] insert %s success.", "t_pf");
                c3144ag.f10505a = replace;
                return true;
            }
            if (f10480a && sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized void m9840b(int i2) {
        String str;
        SQLiteDatabase writableDatabase = f10482c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th) {
                    try {
                        if (!C3151an.m9916a(th)) {
                            th.printStackTrace();
                        }
                        if (f10480a && writableDatabase != null) {
                        }
                    } finally {
                        if (f10480a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                str = null;
            }
            C3151an.m9921c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ae$a */
    class a extends Thread {

        /* renamed from: b */
        private int f10484b;

        /* renamed from: c */
        private InterfaceC3141ad f10485c;

        /* renamed from: d */
        private String f10486d;

        /* renamed from: e */
        private ContentValues f10487e;

        /* renamed from: f */
        private boolean f10488f;

        /* renamed from: g */
        private String[] f10489g;

        /* renamed from: h */
        private String f10490h;

        /* renamed from: i */
        private String[] f10491i;

        /* renamed from: j */
        private String f10492j;

        /* renamed from: k */
        private String f10493k;

        /* renamed from: l */
        private String f10494l;

        /* renamed from: m */
        private String f10495m;

        /* renamed from: n */
        private String f10496n;

        /* renamed from: o */
        private String[] f10497o;

        /* renamed from: p */
        private int f10498p;

        /* renamed from: q */
        private String f10499q;

        /* renamed from: r */
        private byte[] f10500r;

        public a(int i2, InterfaceC3141ad interfaceC3141ad) {
            this.f10484b = i2;
            this.f10485c = interfaceC3141ad;
        }

        /* renamed from: a */
        public void m9845a(String str, ContentValues contentValues) {
            this.f10486d = str;
            this.f10487e = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f10484b) {
                case 1:
                    C3142ae.this.m9814a(this.f10486d, this.f10487e, this.f10485c);
                    break;
                case 2:
                    C3142ae.this.m9812a(this.f10486d, this.f10496n, this.f10497o, this.f10485c);
                    break;
                case 3:
                    Cursor m9816a = C3142ae.this.m9816a(this.f10488f, this.f10486d, this.f10489g, this.f10490h, this.f10491i, this.f10492j, this.f10493k, this.f10494l, this.f10495m, this.f10485c);
                    if (m9816a != null) {
                        m9816a.close();
                        break;
                    }
                    break;
                case 4:
                    C3142ae.this.m9822a(this.f10498p, this.f10499q, this.f10500r, this.f10485c);
                    break;
                case 5:
                    C3142ae.this.m9819a(this.f10498p, this.f10485c);
                    break;
                case 6:
                    C3142ae.this.m9821a(this.f10498p, this.f10499q, this.f10485c);
                    break;
            }
        }

        /* renamed from: a */
        public void m9847a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f10488f = z;
            this.f10486d = str;
            this.f10489g = strArr;
            this.f10490h = str2;
            this.f10491i = strArr2;
            this.f10492j = str3;
            this.f10493k = str4;
            this.f10494l = str5;
            this.f10495m = str6;
        }

        /* renamed from: a */
        public void m9846a(String str, String str2, String[] strArr) {
            this.f10486d = str;
            this.f10496n = str2;
            this.f10497o = strArr;
        }

        /* renamed from: a */
        public void m9844a(int i2, String str, byte[] bArr) {
            this.f10498p = i2;
            this.f10499q = str;
            this.f10500r = bArr;
        }

        /* renamed from: a */
        public void m9842a(int i2) {
            this.f10498p = i2;
        }

        /* renamed from: a */
        public void m9843a(int i2, String str) {
            this.f10498p = i2;
            this.f10499q = str;
        }
    }

    /* renamed from: a */
    public static synchronized C3142ae m9818a(Context context, List<AbstractC3071a> list) {
        C3142ae c3142ae;
        synchronized (C3142ae.class) {
            if (f10481b == null) {
                f10481b = new C3142ae(context, list);
            }
            c3142ae = f10481b;
        }
        return c3142ae;
    }

    /* renamed from: a */
    public static synchronized C3142ae m9817a() {
        C3142ae c3142ae;
        synchronized (C3142ae.class) {
            c3142ae = f10481b;
        }
        return c3142ae;
    }

    /* renamed from: a */
    public long m9828a(String str, ContentValues contentValues, InterfaceC3141ad interfaceC3141ad, boolean z) {
        if (!z) {
            a aVar = new a(1, interfaceC3141ad);
            aVar.m9845a(str, contentValues);
            C3150am.m9906a().m9908a(aVar);
            return 0L;
        }
        return m9814a(str, contentValues, interfaceC3141ad);
    }

    /* renamed from: b */
    protected ContentValues m9838b(C3144ag c3144ag) {
        if (c3144ag == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c3144ag.f10505a > 0) {
                contentValues.put(C3355bl.f11732d, Long.valueOf(c3144ag.f10505a));
            }
            contentValues.put(C3355bl.f11733e, Integer.valueOf(c3144ag.f10506b));
            contentValues.put("_pc", c3144ag.f10507c);
            contentValues.put("_th", c3144ag.f10508d);
            contentValues.put("_tm", Long.valueOf(c3144ag.f10509e));
            if (c3144ag.f10511g != null) {
                contentValues.put("_dt", c3144ag.f10511g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public Cursor m9829a(String str, String[] strArr, String str2, String[] strArr2, InterfaceC3141ad interfaceC3141ad, boolean z) {
        return m9830a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, interfaceC3141ad, z);
    }

    /* renamed from: a */
    public Cursor m9830a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, InterfaceC3141ad interfaceC3141ad, boolean z2) {
        if (!z2) {
            a aVar = new a(3, interfaceC3141ad);
            aVar.m9847a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            C3150am.m9906a().m9908a(aVar);
            return null;
        }
        return m9816a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, interfaceC3141ad);
    }

    /* renamed from: a */
    public int m9827a(String str, String str2, String[] strArr, InterfaceC3141ad interfaceC3141ad, boolean z) {
        if (!z) {
            a aVar = new a(2, interfaceC3141ad);
            aVar.m9846a(str, str2, strArr);
            C3150am.m9906a().m9908a(aVar);
            return 0;
        }
        return m9812a(str, str2, strArr, interfaceC3141ad);
    }

    /* renamed from: b */
    protected C3144ag m9839b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3144ag c3144ag = new C3144ag();
            c3144ag.f10505a = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
            c3144ag.f10509e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3144ag.f10510f = cursor.getString(cursor.getColumnIndex(C3355bl.f11733e));
            c3144ag.f10511g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c3144ag;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        if (0 != 0) goto L17;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long m9814a(java.lang.String r8, android.content.ContentValues r9, com.tencent.bugly.proguard.InterfaceC3141ad r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.af r3 = com.tencent.bugly.proguard.C3142ae.f10482c     // Catch: java.lang.Throwable -> L43
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L2e
            if (r9 == 0) goto L2e
            java.lang.String r3 = "_id"
            long r3 = r0.replace(r8, r3, r9)     // Catch: java.lang.Throwable -> L43
            r9 = 0
            r5 = 1
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 < 0) goto L24
            java.lang.String r6 = "[Database] insert %s success."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L43
            r5[r9] = r8     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.C3151an.m9921c(r6, r5)     // Catch: java.lang.Throwable -> L43
            goto L2d
        L24:
            java.lang.String r6 = "[Database] replace %s error."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L43
            r5[r9] = r8     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.C3151an.m9922d(r6, r5)     // Catch: java.lang.Throwable -> L43
        L2d:
            r1 = r3
        L2e:
            if (r10 == 0) goto L37
            java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L41
            r10.m9810a(r8)     // Catch: java.lang.Throwable -> L41
        L37:
            boolean r8 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L41
            if (r8 == 0) goto L5d
            if (r0 == 0) goto L5d
        L3d:
            r0.close()     // Catch: java.lang.Throwable -> L41
            goto L5d
        L41:
            r8 = move-exception
            goto L73
        L43:
            r8 = move-exception
            boolean r9 = com.tencent.bugly.proguard.C3151an.m9916a(r8)     // Catch: java.lang.Throwable -> L5f
            if (r9 != 0) goto L4d
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L5f
        L4d:
            if (r10 == 0) goto L56
            java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L41
            r10.m9810a(r8)     // Catch: java.lang.Throwable -> L41
        L56:
            boolean r8 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L41
            if (r8 == 0) goto L5d
            if (r0 == 0) goto L5d
            goto L3d
        L5d:
            monitor-exit(r7)
            return r1
        L5f:
            r8 = move-exception
            if (r10 == 0) goto L69
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L41
            r10.m9810a(r9)     // Catch: java.lang.Throwable -> L41
        L69:
            boolean r9 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L41
            if (r9 == 0) goto L72
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> L41
        L72:
            throw r8     // Catch: java.lang.Throwable -> L41
        L73:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9814a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.ad):long");
    }

    /* renamed from: c */
    protected ContentValues m9841c(C3144ag c3144ag) {
        if (c3144ag != null && !C3154aq.m9970a(c3144ag.f10510f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (c3144ag.f10505a > 0) {
                    contentValues.put(C3355bl.f11732d, Long.valueOf(c3144ag.f10505a));
                }
                contentValues.put(C3355bl.f11733e, c3144ag.f10510f);
                contentValues.put("_tm", Long.valueOf(c3144ag.f10509e));
                if (c3144ag.f10511g != null) {
                    contentValues.put("_dt", c3144ag.f10511g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        if (r23 != null) goto L9;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.database.Cursor m9816a(boolean r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.tencent.bugly.proguard.InterfaceC3141ad r23) {
        /*
            r13 = this;
            r1 = r23
            monitor-enter(r13)
            r2 = 0
            com.tencent.bugly.proguard.af r0 = com.tencent.bugly.proguard.C3142ae.f10482c     // Catch: java.lang.Throwable -> L28
            android.database.sqlite.SQLiteDatabase r3 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L20
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L28
        L20:
            if (r1 == 0) goto L35
        L22:
            r1.m9810a(r2)     // Catch: java.lang.Throwable -> L26
            goto L35
        L26:
            r0 = move-exception
            goto L3e
        L28:
            r0 = move-exception
            boolean r3 = com.tencent.bugly.proguard.C3151an.m9916a(r0)     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto L32
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L37
        L32:
            if (r1 == 0) goto L35
            goto L22
        L35:
            monitor-exit(r13)
            return r2
        L37:
            r0 = move-exception
            if (r1 == 0) goto L3d
            r1.m9810a(r2)     // Catch: java.lang.Throwable -> L26
        L3d:
            throw r0     // Catch: java.lang.Throwable -> L26
        L3e:
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9816a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.proguard.ad):android.database.Cursor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
    
        if (r1 != null) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int m9812a(java.lang.String r4, java.lang.String r5, java.lang.String[] r6, com.tencent.bugly.proguard.InterfaceC3141ad r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.af r2 = com.tencent.bugly.proguard.C3142ae.f10482c     // Catch: java.lang.Throwable -> L24
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto Lf
            int r0 = r1.delete(r4, r5, r6)     // Catch: java.lang.Throwable -> L24
        Lf:
            if (r7 == 0) goto L18
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L22
            r7.m9810a(r4)     // Catch: java.lang.Throwable -> L22
        L18:
            boolean r4 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L22
            if (r4 == 0) goto L3e
            if (r1 == 0) goto L3e
        L1e:
            r1.close()     // Catch: java.lang.Throwable -> L22
            goto L3e
        L22:
            r4 = move-exception
            goto L54
        L24:
            r4 = move-exception
            boolean r5 = com.tencent.bugly.proguard.C3151an.m9916a(r4)     // Catch: java.lang.Throwable -> L40
            if (r5 != 0) goto L2e
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L40
        L2e:
            if (r7 == 0) goto L37
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L22
            r7.m9810a(r4)     // Catch: java.lang.Throwable -> L22
        L37:
            boolean r4 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L22
            if (r4 == 0) goto L3e
            if (r1 == 0) goto L3e
            goto L1e
        L3e:
            monitor-exit(r3)
            return r0
        L40:
            r4 = move-exception
            if (r7 == 0) goto L4a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L22
            r7.m9810a(r5)     // Catch: java.lang.Throwable -> L22
        L4a:
            boolean r5 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L22
            if (r5 == 0) goto L53
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.lang.Throwable -> L22
        L53:
            throw r4     // Catch: java.lang.Throwable -> L22
        L54:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9812a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.ad):int");
    }

    /* renamed from: a */
    public boolean m9836a(int i2, String str, byte[] bArr, InterfaceC3141ad interfaceC3141ad, boolean z) {
        if (!z) {
            a aVar = new a(4, interfaceC3141ad);
            aVar.m9844a(i2, str, bArr);
            C3150am.m9906a().m9908a(aVar);
            return true;
        }
        return m9822a(i2, str, bArr, interfaceC3141ad);
    }

    /* renamed from: a */
    public Map<String, byte[]> m9833a(int i2, InterfaceC3141ad interfaceC3141ad, boolean z) {
        if (!z) {
            a aVar = new a(5, interfaceC3141ad);
            aVar.m9842a(i2);
            C3150am.m9906a().m9908a(aVar);
            return null;
        }
        return m9819a(i2, interfaceC3141ad);
    }

    /* renamed from: a */
    public boolean m9835a(int i2, String str, InterfaceC3141ad interfaceC3141ad, boolean z) {
        if (!z) {
            a aVar = new a(6, interfaceC3141ad);
            aVar.m9843a(i2, str);
            C3150am.m9906a().m9908a(aVar);
            return false;
        }
        return m9821a(i2, str, interfaceC3141ad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r8 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m9822a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.InterfaceC3141ad r8) {
        /*
            r4 = this;
            r0 = 0
            com.tencent.bugly.proguard.ag r1 = new com.tencent.bugly.proguard.ag     // Catch: java.lang.Throwable -> L21
            r1.<init>()     // Catch: java.lang.Throwable -> L21
            long r2 = (long) r5     // Catch: java.lang.Throwable -> L21
            r1.f10505a = r2     // Catch: java.lang.Throwable -> L21
            r1.f10510f = r6     // Catch: java.lang.Throwable -> L21
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L21
            r1.f10509e = r5     // Catch: java.lang.Throwable -> L21
            r1.f10511g = r7     // Catch: java.lang.Throwable -> L21
            boolean r0 = r4.m9826d(r1)     // Catch: java.lang.Throwable -> L21
            if (r8 == 0) goto L2e
        L19:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            r8.m9810a(r5)
            goto L2e
        L21:
            r5 = move-exception
            boolean r6 = com.tencent.bugly.proguard.C3151an.m9916a(r5)     // Catch: java.lang.Throwable -> L2f
            if (r6 != 0) goto L2b
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2f
        L2b:
            if (r8 == 0) goto L2e
            goto L19
        L2e:
            return r0
        L2f:
            r5 = move-exception
            if (r8 == 0) goto L39
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r8.m9810a(r6)
        L39:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9822a(int, java.lang.String, byte[], com.tencent.bugly.proguard.ad):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
    
        if (r5 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, byte[]> m9819a(int r4, com.tencent.bugly.proguard.InterfaceC3141ad r5) {
        /*
            r3 = this;
            r0 = 0
            java.util.List r4 = r3.m9825c(r4)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L2b
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L31
            r1.<init>()     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L28
        L10:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L26
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L28
            com.tencent.bugly.proguard.ag r0 = (com.tencent.bugly.proguard.C3144ag) r0     // Catch: java.lang.Throwable -> L28
            byte[] r2 = r0.f10511g     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L10
            java.lang.String r0 = r0.f10510f     // Catch: java.lang.Throwable -> L28
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L28
            goto L10
        L26:
            r0 = r1
            goto L2b
        L28:
            r4 = move-exception
            r0 = r1
            goto L32
        L2b:
            if (r5 == 0) goto L3e
        L2d:
            r5.m9810a(r0)
            goto L3e
        L31:
            r4 = move-exception
        L32:
            boolean r1 = com.tencent.bugly.proguard.C3151an.m9916a(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L3b
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3f
        L3b:
            if (r5 == 0) goto L3e
            goto L2d
        L3e:
            return r0
        L3f:
            r4 = move-exception
            if (r5 == 0) goto L45
            r5.m9810a(r0)
        L45:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9819a(int, com.tencent.bugly.proguard.ad):java.util.Map");
    }

    /* renamed from: a */
    public synchronized boolean m9837a(C3144ag c3144ag) {
        ContentValues m9838b;
        if (c3144ag == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f10482c.getWritableDatabase();
            if (sQLiteDatabase != null && (m9838b = m9838b(c3144ag)) != null) {
                long replace = sQLiteDatabase.replace("t_lr", C3355bl.f11732d, m9838b);
                if (replace >= 0) {
                    C3151an.m9921c("[Database] insert %s success.", "t_lr");
                    c3144ag.f10505a = replace;
                    return true;
                }
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            }
            if (f10480a && sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f10480a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:50:0x00bc, B:52:0x00c2), top: B:49:0x00bc, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7 A[Catch: all -> 0x00e6, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:11:0x0035, B:12:0x0038, B:15:0x003e, B:41:0x00ad, B:42:0x00b0, B:45:0x00b6, B:55:0x00c7, B:56:0x00ca, B:59:0x00d0, B:62:0x00d7, B:63:0x00da, B:66:0x00e0, B:67:0x00e3, B:50:0x00bc, B:52:0x00c2), top: B:2:0x0001, inners: #0 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.tencent.bugly.proguard.C3144ag> m9832a(int r11) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9832a(int):java.util.List");
    }

    /* renamed from: a */
    public synchronized void m9834a(List<C3144ag> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f10482c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (C3144ag c3144ag : list) {
                        sb.append(" or ");
                        sb.append(C3355bl.f11732d);
                        sb.append(" = ");
                        sb.append(c3144ag.f10505a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        C3151an.m9921c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    } catch (Throwable th) {
                        try {
                            if (!C3151an.m9916a(th)) {
                                th.printStackTrace();
                            }
                            if (f10480a) {
                            }
                        } finally {
                            if (f10480a) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected C3144ag m9831a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3144ag c3144ag = new C3144ag();
            c3144ag.f10505a = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
            c3144ag.f10506b = cursor.getInt(cursor.getColumnIndex(C3355bl.f11733e));
            c3144ag.f10507c = cursor.getString(cursor.getColumnIndex("_pc"));
            c3144ag.f10508d = cursor.getString(cursor.getColumnIndex("_th"));
            c3144ag.f10509e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3144ag.f10511g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c3144ag;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        if (r2 != null) goto L20;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m9821a(int r6, java.lang.String r7, com.tencent.bugly.proguard.InterfaceC3141ad r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.af r2 = com.tencent.bugly.proguard.C3142ae.f10482c     // Catch: java.lang.Throwable -> L7f
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L6a
            boolean r3 = com.tencent.bugly.proguard.C3154aq.m9970a(r7)     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L23
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r7.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "_id = "
            r7.append(r3)     // Catch: java.lang.Throwable -> L68
            r7.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> L68
            goto L4b
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "_id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L68
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = " and "
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = "_tp"
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = " = \""
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            r3.append(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = "\""
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L68
        L4b:
            java.lang.String r7 = "t_pf"
            int r6 = r2.delete(r7, r6, r0)     // Catch: java.lang.Throwable -> L68
            java.lang.String r7 = "[Database] deleted %s data %d"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "t_pf"
            r0[r1] = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L68
            r4 = 1
            r0[r4] = r3     // Catch: java.lang.Throwable -> L68
            com.tencent.bugly.proguard.C3151an.m9921c(r7, r0)     // Catch: java.lang.Throwable -> L68
            if (r6 <= 0) goto L6a
            r1 = 1
            goto L6a
        L68:
            r6 = move-exception
            goto L81
        L6a:
            if (r8 == 0) goto L73
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.m9810a(r6)     // Catch: java.lang.Throwable -> L7d
        L73:
            boolean r6 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L7d
            if (r6 == 0) goto L9a
            if (r2 == 0) goto L9a
        L79:
            r2.close()     // Catch: java.lang.Throwable -> L7d
            goto L9a
        L7d:
            r6 = move-exception
            goto Lb0
        L7f:
            r6 = move-exception
            r2 = r0
        L81:
            boolean r7 = com.tencent.bugly.proguard.C3151an.m9916a(r6)     // Catch: java.lang.Throwable -> L9c
            if (r7 != 0) goto L8a
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L9c
        L8a:
            if (r8 == 0) goto L93
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.m9810a(r6)     // Catch: java.lang.Throwable -> L7d
        L93:
            boolean r6 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L7d
            if (r6 == 0) goto L9a
            if (r2 == 0) goto L9a
            goto L79
        L9a:
            monitor-exit(r5)
            return r1
        L9c:
            r6 = move-exception
            if (r8 == 0) goto La6
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.m9810a(r7)     // Catch: java.lang.Throwable -> L7d
        La6:
            boolean r7 = com.tencent.bugly.proguard.C3142ae.f10480a     // Catch: java.lang.Throwable -> L7d
            if (r7 == 0) goto Laf
            if (r2 == 0) goto Laf
            r2.close()     // Catch: java.lang.Throwable -> L7d
        Laf:
            throw r6     // Catch: java.lang.Throwable -> L7d
        Lb0:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3142ae.m9821a(int, java.lang.String, com.tencent.bugly.proguard.ad):boolean");
    }
}
