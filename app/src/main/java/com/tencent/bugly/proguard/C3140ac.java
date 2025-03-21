package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C3113a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ac */
/* loaded from: classes2.dex */
public class C3140ac {

    /* renamed from: a */
    public static final long f10469a = System.currentTimeMillis();

    /* renamed from: b */
    private static C3140ac f10470b;

    /* renamed from: c */
    private Context f10471c;

    /* renamed from: f */
    private SharedPreferences f10474f;

    /* renamed from: e */
    private Map<Integer, Map<String, C3139ab>> f10473e = new HashMap();

    /* renamed from: d */
    private String f10472d = C3113a.m9532b().f10197e;

    public C3140ac(Context context) {
        this.f10471c = context;
        this.f10474f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T m9807c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            android.content.Context r3 = r5.f10471c     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = ""
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r6 != 0) goto L29
            monitor-exit(r5)
            return r0
        L29:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            monitor-exit(r5)
            return r2
        L3e:
            r2 = move-exception
            r6 = r0
            goto L5b
        L41:
            r6 = r0
        L42:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            com.tencent.bugly.proguard.C3151an.m9915a(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
        L4b:
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L6a
        L4f:
            r6 = r0
        L50:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            com.tencent.bugly.proguard.C3151an.m9915a(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
            goto L4b
        L5a:
            r2 = move-exception
        L5b:
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L60:
            throw r2     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L61:
            r6 = move-exception
            goto L6c
        L63:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L61
            com.tencent.bugly.proguard.C3151an.m9923e(r6, r1)     // Catch: java.lang.Throwable -> L61
        L6a:
            monitor-exit(r5)
            return r0
        L6c:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3140ac.m9807c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m9804b(int i2) {
        try {
            List<C3139ab> m9807c = m9807c(i2);
            if (m9807c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C3139ab c3139ab : m9807c) {
                if (c3139ab.f10463b != null && c3139ab.f10463b.equalsIgnoreCase(this.f10472d) && c3139ab.f10465d > 0) {
                    arrayList.add(c3139ab);
                }
                if (c3139ab.f10464c + 86400000 < currentTimeMillis) {
                    arrayList2.add(c3139ab);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((C3139ab) arrayList.get(arrayList.size() - 1)).f10464c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                m9807c.clear();
                m9801a(i2, (int) m9807c);
                return false;
            }
            m9807c.removeAll(arrayList2);
            m9801a(i2, (int) m9807c);
            return false;
        } catch (Exception unused) {
            C3151an.m9923e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized C3140ac m9798a(Context context) {
        C3140ac c3140ac;
        synchronized (C3140ac.class) {
            if (f10470b == null) {
                f10470b = new C3140ac(context);
            }
            c3140ac = f10470b;
        }
        return c3140ac;
    }

    /* renamed from: a */
    public static synchronized C3140ac m9797a() {
        C3140ac c3140ac;
        synchronized (C3140ac.class) {
            c3140ac = f10470b;
        }
        return c3140ac;
    }

    /* renamed from: a */
    public void m9808a(final int i2, final int i3) {
        C3150am.m9906a().m9908a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.1
            @Override // java.lang.Runnable
            public void run() {
                C3139ab c3139ab;
                try {
                    if (TextUtils.isEmpty(C3140ac.this.f10472d)) {
                        return;
                    }
                    List<C3139ab> m9807c = C3140ac.this.m9807c(i2);
                    if (m9807c == null) {
                        m9807c = new ArrayList();
                    }
                    if (C3140ac.this.f10473e.get(Integer.valueOf(i2)) == null) {
                        C3140ac.this.f10473e.put(Integer.valueOf(i2), new HashMap());
                    }
                    if (((Map) C3140ac.this.f10473e.get(Integer.valueOf(i2))).get(C3140ac.this.f10472d) == null) {
                        c3139ab = new C3139ab();
                        c3139ab.f10462a = i2;
                        c3139ab.f10468g = C3140ac.f10469a;
                        c3139ab.f10463b = C3140ac.this.f10472d;
                        c3139ab.f10467f = C3113a.m9532b().f10208p;
                        c3139ab.f10466e = C3113a.m9532b().f10202j;
                        c3139ab.f10464c = System.currentTimeMillis();
                        c3139ab.f10465d = i3;
                        ((Map) C3140ac.this.f10473e.get(Integer.valueOf(i2))).put(C3140ac.this.f10472d, c3139ab);
                    } else {
                        c3139ab = (C3139ab) ((Map) C3140ac.this.f10473e.get(Integer.valueOf(i2))).get(C3140ac.this.f10472d);
                        c3139ab.f10465d = i3;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (C3139ab c3139ab2 : m9807c) {
                        if (c3139ab2.f10468g == c3139ab.f10468g && c3139ab2.f10463b != null && c3139ab2.f10463b.equalsIgnoreCase(c3139ab.f10463b)) {
                            z = true;
                            c3139ab2.f10465d = c3139ab.f10465d;
                        }
                        if ((c3139ab2.f10466e != null && !c3139ab2.f10466e.equalsIgnoreCase(c3139ab.f10466e)) || ((c3139ab2.f10467f != null && !c3139ab2.f10467f.equalsIgnoreCase(c3139ab.f10467f)) || c3139ab2.f10465d <= 0)) {
                            arrayList.add(c3139ab2);
                        }
                    }
                    m9807c.removeAll(arrayList);
                    if (!z) {
                        m9807c.add(c3139ab);
                    }
                    C3140ac.this.m9801a(i2, (int) m9807c);
                } catch (Exception unused) {
                    C3151an.m9923e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized <T extends List<?>> void m9801a(int i2, T t) {
        if (t == null) {
            return;
        }
        try {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(this.f10471c.getDir("crashrecord", 0), i2 + "")));
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        C3151an.m9915a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Exception unused) {
            C3151an.m9923e("writeCrashRecord error", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized boolean m9809a(final int i2) {
        boolean z;
        z = true;
        try {
            z = this.f10474f.getBoolean(i2 + AbstractC1191a.f2606s1 + this.f10472d, true);
            C3150am.m9906a().m9908a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean m9804b = C3140ac.this.m9804b(i2);
                    C3140ac.this.f10474f.edit().putBoolean(i2 + AbstractC1191a.f2606s1 + C3140ac.this.f10472d, !m9804b).commit();
                }
            });
        } catch (Exception unused) {
            C3151an.m9923e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
