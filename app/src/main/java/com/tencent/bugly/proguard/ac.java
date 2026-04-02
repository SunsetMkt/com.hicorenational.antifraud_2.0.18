package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ac {
    public static final long a = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ac f6342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6343c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f6346f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, ab>> f6345e = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6344d = com.tencent.bugly.crashreport.common.info.a.b().f6176e;

    public ac(Context context) {
        this.f6343c = context;
        this.f6346f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[Catch: all -> 0x0061, Exception -> 0x0063, PHI: r6
  0x004b: PHI (r6v11 java.io.ObjectInputStream) = (r6v10 java.io.ObjectInputStream), (r6v12 java.io.ObjectInputStream) binds: [B:17:0x0049, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0063, blocks: (B:4:0x0003, B:10:0x0039, B:18:0x004b, B:26:0x005d, B:27:0x0060), top: B:37:0x0003, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> T c(int i2) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.f6343c.getDir("crashrecord", 0), i2 + "");
            ?? Exists = file.exists();
            try {
                if (Exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Exists = 0;
                    if (Exists != 0) {
                        Exists.close();
                    }
                    throw th;
                }
                try {
                    T t = (T) objectInputStream.readObject();
                    objectInputStream.close();
                    return t;
                } catch (IOException unused3) {
                    an.a("open record file error", new Object[0]);
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                } catch (ClassNotFoundException unused4) {
                    an.a("get object error", new Object[0]);
                    if (objectInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            an.e("readCrashRecord error", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i2) {
        try {
            List<ab> listC = c(i2);
            if (listC == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (ab abVar : listC) {
                if (abVar.f6336b != null && abVar.f6336b.equalsIgnoreCase(this.f6344d) && abVar.f6338d > 0) {
                    arrayList.add(abVar);
                }
                if (abVar.f6337c + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(abVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((ab) arrayList.get(arrayList.size() - 1)).f6337c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listC.clear();
                a(i2, listC);
                return false;
            }
            listC.removeAll(arrayList2);
            a(i2, listC);
            return false;
        } catch (Exception unused) {
            an.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public static synchronized ac a(Context context) {
        if (f6342b == null) {
            f6342b = new ac(context);
        }
        return f6342b;
    }

    public static synchronized ac a() {
        return f6342b;
    }

    public void a(final int i2, final int i3) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.1
            @Override // java.lang.Runnable
            public void run() {
                ab abVar;
                try {
                    if (TextUtils.isEmpty(ac.this.f6344d)) {
                        return;
                    }
                    List<ab> listC = ac.this.c(i2);
                    if (listC == null) {
                        listC = new ArrayList();
                    }
                    if (ac.this.f6345e.get(Integer.valueOf(i2)) == null) {
                        ac.this.f6345e.put(Integer.valueOf(i2), new HashMap());
                    }
                    if (((Map) ac.this.f6345e.get(Integer.valueOf(i2))).get(ac.this.f6344d) == null) {
                        abVar = new ab();
                        abVar.a = i2;
                        abVar.f6341g = ac.a;
                        abVar.f6336b = ac.this.f6344d;
                        abVar.f6340f = com.tencent.bugly.crashreport.common.info.a.b().p;
                        abVar.f6339e = com.tencent.bugly.crashreport.common.info.a.b().f6181j;
                        abVar.f6337c = System.currentTimeMillis();
                        abVar.f6338d = i3;
                        ((Map) ac.this.f6345e.get(Integer.valueOf(i2))).put(ac.this.f6344d, abVar);
                    } else {
                        abVar = (ab) ((Map) ac.this.f6345e.get(Integer.valueOf(i2))).get(ac.this.f6344d);
                        abVar.f6338d = i3;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (ab abVar2 : listC) {
                        if (abVar2.f6341g == abVar.f6341g && abVar2.f6336b != null && abVar2.f6336b.equalsIgnoreCase(abVar.f6336b)) {
                            z = true;
                            abVar2.f6338d = abVar.f6338d;
                        }
                        if ((abVar2.f6339e != null && !abVar2.f6339e.equalsIgnoreCase(abVar.f6339e)) || ((abVar2.f6340f != null && !abVar2.f6340f.equalsIgnoreCase(abVar.f6340f)) || abVar2.f6338d <= 0)) {
                            arrayList.add(abVar2);
                        }
                    }
                    listC.removeAll(arrayList);
                    if (!z) {
                        listC.add(abVar);
                    }
                    ac.this.a(i2, listC);
                } catch (Exception unused) {
                    an.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <T extends List<?>> void a(int i2, T t) {
        if (t == null) {
            return;
        }
        try {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(this.f6343c.getDir("crashrecord", 0), i2 + "")));
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        an.a("open record file error", new Object[0]);
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
            an.e("writeCrashRecord error", new Object[0]);
        }
    }

    public synchronized boolean a(final int i2) {
        boolean z;
        z = true;
        try {
            z = this.f6346f.getBoolean(i2 + d.c.a.b.a.a.s1 + this.f6344d, true);
            am.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean zB = ac.this.b(i2);
                    ac.this.f6346f.edit().putBoolean(i2 + d.c.a.b.a.a.s1 + ac.this.f6344d, !zB).commit();
                }
            });
        } catch (Exception unused) {
            an.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
