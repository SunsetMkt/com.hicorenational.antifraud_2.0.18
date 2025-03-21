package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3369bz;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.InterfaceC3516d;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.proto.C3526d;
import com.umeng.commonsdk.statistics.proto.C3527e;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a */
    private static final String f12756a = "ImprintHandler";

    /* renamed from: k */
    private static Context f12763k = null;

    /* renamed from: l */
    private static FileLockUtil f12764l = null;

    /* renamed from: m */
    private static final int f12765m = 0;

    /* renamed from: n */
    private static final int f12766n = 1;

    /* renamed from: e */
    private InterfaceC3516d f12769e;

    /* renamed from: h */
    private C3500a f12770h = new C3500a();

    /* renamed from: i */
    private C3526d f12771i = null;

    /* renamed from: b */
    private static Object f12757b = new Object();

    /* renamed from: c */
    private static final String f12758c = C3336at.m10865b().m10868b(C3336at.f11489c);

    /* renamed from: d */
    private static final byte[] f12759d = "pbl0".getBytes();

    /* renamed from: f */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f12760f = new HashMap();

    /* renamed from: g */
    private static Object f12761g = new Object();

    /* renamed from: j */
    private static ImprintHandler f12762j = null;

    /* renamed from: o */
    private static Map<String, UMImprintPreProcessCallback> f12767o = new HashMap();

    /* renamed from: p */
    private static Object f12768p = new Object();

    private ImprintHandler(Context context) {
        f12763k = context.getApplicationContext();
    }

    /* renamed from: a */
    private static void m11825a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f12761g) {
            try {
                int i2 = 0;
                if (f12760f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f12760f.get(str);
                    int size = arrayList.size();
                    ULog.m11780i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i2 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i2)) {
                            ULog.m11780i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.m11780i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.m11780i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i2 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i2)) {
                            ULog.m11780i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.m11780i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f12760f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f12763k, th);
            }
        }
    }

    /* renamed from: b */
    private static void m11827b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f12761g) {
            try {
                if (f12760f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f12760f.get(str);
                    if (uMImprintChangeCallback != null && arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.m11780i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i2)) {
                                ULog.m11780i("--->>> removeCallback: remove index " + i2);
                                arrayList.remove(i2);
                                break;
                            }
                            i2++;
                        }
                        ULog.m11780i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.m11780i("--->>> removeCallback: remove key from map: key = " + str);
                            f12760f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: c */
    private boolean m11828c(C3526d c3526d) {
        if (!c3526d.m12037i().equals(m11832a(c3526d))) {
            return false;
        }
        for (C3527e c3527e : c3526d.m12030c().values()) {
            String m12070h = c3527e.m12070h();
            if (!TextUtils.isEmpty(m12070h)) {
                byte[] reverseHexString = DataHelper.reverseHexString(m12070h);
                byte[] m11836a = m11836a(c3527e);
                for (int i2 = 0; i2 < 4; i2++) {
                    if (reverseHexString[i2] != m11836a[i2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    private C3526d m11829d(C3526d c3526d) {
        Map<String, C3527e> m12030c = c3526d.m12030c();
        if (m12030c.containsKey(C3351bh.f11652f)) {
            m12030c.remove(C3351bh.f11652f);
            this.f12770h.m11844a(C3351bh.f11652f);
            c3526d.m12022a(c3526d.m12034f());
            c3526d.m12023a(m11832a(c3526d));
        }
        return c3526d;
    }

    /* renamed from: e */
    private C3526d m11830e(C3526d c3526d) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, C3527e> m12030c = c3526d.m12030c();
        ArrayList<String> arrayList3 = new ArrayList(m12030c.size() / 2);
        Iterator<Map.Entry<String, C3527e>> it = m12030c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, C3527e> next = it.next();
            if (next.getValue().m12066d()) {
                String key = next.getKey();
                String str = next.getValue().f12918a;
                synchronized (f12768p) {
                    z = !TextUtils.isEmpty(key) && f12767o.containsKey(key) && (uMImprintPreProcessCallback = f12767o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (f12761g) {
                    if (!TextUtils.isEmpty(key) && f12760f.containsKey(key) && (arrayList2 = f12760f.get(key)) != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            arrayList2.get(i2).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f12761g) {
                if (!TextUtils.isEmpty(str2) && f12760f.containsKey(str2) && (arrayList = f12760f.get(str2)) != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        arrayList.get(i3).onImprintValueChanged(str2, null);
                    }
                }
            }
            m12030c.remove(str2);
        }
        return c3526d;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f12762j == null) {
                f12762j = new ImprintHandler(context);
                f12764l = new FileLockUtil();
                if (f12764l != null) {
                    f12764l.doFileOperateion(new File(f12763k.getFilesDir(), f12758c), f12762j, 0);
                }
            }
            imprintHandler = f12762j;
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i2) {
        if (i2 == 0) {
            f12762j.m11831e();
        } else if (i2 == 1) {
            f12762j.m11824a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m11825a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f12768p) {
            try {
                if (f12767o.containsKey(str)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    f12767o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m11827b(str, uMImprintChangeCallback);
    }

    /* renamed from: com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a */
    public static class C3500a {

        /* renamed from: a */
        private Map<String, String> f12772a = new HashMap();

        C3500a() {
        }

        /* renamed from: b */
        private synchronized void m11841b(C3526d c3526d) {
            C3527e c3527e;
            if (c3526d != null) {
                if (c3526d.m12033e()) {
                    Map<String, C3527e> m12030c = c3526d.m12030c();
                    for (String str : m12030c.keySet()) {
                        if (!TextUtils.isEmpty(str) && (c3527e = m12030c.get(str)) != null) {
                            String m12062b = c3527e.m12062b();
                            if (!TextUtils.isEmpty(m12062b)) {
                                this.f12772a.put(str, m12062b);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str2 = "imKey is " + str + ", imValue is " + m12062b;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public synchronized void m11844a(String str) {
            if (this.f12772a != null && this.f12772a.size() > 0 && !TextUtils.isEmpty(str) && this.f12772a.containsKey(str)) {
                this.f12772a.remove(str);
            }
        }

        C3500a(C3526d c3526d) {
            m11843a(c3526d);
        }

        /* renamed from: a */
        public void m11843a(C3526d c3526d) {
            if (c3526d == null) {
                return;
            }
            m11841b(c3526d);
        }

        /* renamed from: a */
        public synchronized String m11842a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f12772a.size() > 0) {
                String str3 = this.f12772a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    /* renamed from: d */
    public void m11840d() {
        if (this.f12771i == null || f12764l == null) {
            return;
        }
        File file = new File(f12763k.getFilesDir(), f12758c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(f12763k, e2);
            }
        }
        f12764l.doFileOperateion(file, f12762j, 1);
    }

    /* renamed from: c */
    public C3500a m11839c() {
        return this.f12770h;
    }

    /* renamed from: b */
    public void m11838b(C3526d c3526d) {
        C3526d m11823a;
        boolean z;
        if (c3526d == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.m11554d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!m11828c(c3526d)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z2 = AnalyticsConstants.UM_DEBUG;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            C3526d c3526d2 = this.f12771i;
            C3526d m11829d = m11829d(c3526d);
            String str = null;
            String m12037i = c3526d2 == null ? null : c3526d2.m12037i();
            if (c3526d2 == null) {
                m11823a = m11830e(m11829d);
            } else {
                m11823a = m11823a(c3526d2, m11829d, hashMap);
            }
            this.f12771i = m11823a;
            if (m11823a != null) {
                str = m11823a.m12037i();
            }
            z = !m11826a(m12037i, str);
        }
        C3526d c3526d3 = this.f12771i;
        if (c3526d3 != null) {
            boolean z3 = AnalyticsConstants.UM_DEBUG;
            if (z) {
                this.f12770h.m11843a(c3526d3);
                InterfaceC3516d interfaceC3516d = this.f12769e;
                if (interfaceC3516d != null) {
                    interfaceC3516d.onImprintChanged(this.f12770h);
                }
            }
        }
        if (hashMap.size() > 0) {
            synchronized (f12761g) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f12760f.containsKey(key)) {
                        ULog.m11780i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f12760f.get(key);
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                arrayList.get(i2).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m11834a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f12768p) {
            try {
                if (f12767o.containsKey(str)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f12760f.remove(str);
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11831e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f12763k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f12758c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f12757b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L18
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            return
        L18:
            r0 = 0
            android.content.Context r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f12763k     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            java.lang.String r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f12758c     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L58
        L25:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L60
            goto L33
        L29:
            r3 = move-exception
            goto L2f
        L2b:
            r2 = move-exception
            goto L5c
        L2d:
            r3 = move-exception
            r2 = r0
        L2f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L58
            goto L25
        L33:
            if (r0 == 0) goto L56
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r2.<init>()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.analytics.pro.bt r3 = new com.umeng.analytics.pro.bt     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r3.m11061a(r2, r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r5.f12771i = r2     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f12770h     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r0.m11843a(r2)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f12771i     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.proto.d r0 = r5.m11829d(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r5.f12771i = r0     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            goto L56
        L52:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L60
        L56:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            return
        L58:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L5c:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0)     // Catch: java.lang.Throwable -> L60
            throw r2     // Catch: java.lang.Throwable -> L60
        L60:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.m11831e():void");
    }

    /* renamed from: a */
    public void m11833a(InterfaceC3516d interfaceC3516d) {
        this.f12769e = interfaceC3516d;
    }

    /* renamed from: a */
    public String m11832a(C3526d c3526d) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(c3526d.m12030c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((C3527e) entry.getValue()).m12066d()) {
                sb.append(((C3527e) entry.getValue()).m12062b());
            }
        }
        sb.append(c3526d.f12900b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public byte[] m11836a(C3527e c3527e) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(c3527e.m12067e());
        byte[] array = allocate.array();
        byte[] bArr = f12759d;
        byte[] bArr2 = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i2] = (byte) (array[i2] ^ bArr[i2]);
        }
        return bArr2;
    }

    /* renamed from: a */
    public byte[] m11835a() {
        try {
            synchronized (this) {
                if (this.f12771i == null) {
                    return null;
                }
                if (this.f12771i.m12027b() <= 0) {
                    return null;
                }
                return new C3369bz().m11073a(this.f12771i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12763k, th);
            return null;
        }
    }

    /* renamed from: b */
    public synchronized C3526d m11837b() {
        return this.f12771i;
    }

    /* renamed from: a */
    private boolean m11826a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    private C3526d m11823a(C3526d c3526d, C3526d c3526d2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (c3526d2 == null) {
            return c3526d;
        }
        Map<String, C3527e> m12030c = c3526d.m12030c();
        for (Map.Entry<String, C3527e> entry : c3526d2.m12030c().entrySet()) {
            int i2 = 0;
            if (entry.getValue().m12066d()) {
                String key = entry.getKey();
                String str = entry.getValue().f12918a;
                synchronized (f12768p) {
                    if (!TextUtils.isEmpty(key) && f12767o.containsKey(key) && (uMImprintPreProcessCallback = f12767o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    m12030c.put(entry.getKey(), entry.getValue());
                    synchronized (f12761g) {
                        if (!TextUtils.isEmpty(key) && f12760f.containsKey(key) && f12760f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f12761g) {
                    if (!TextUtils.isEmpty(key2) && f12760f.containsKey(key2) && (arrayList = f12760f.get(key2)) != null) {
                        while (i2 < arrayList.size()) {
                            arrayList.get(i2).onImprintValueChanged(key2, null);
                            i2++;
                        }
                    }
                }
                m12030c.remove(key2);
                this.f12770h.m11844a(key2);
            }
        }
        c3526d.m12022a(c3526d2.m12034f());
        c3526d.m12023a(m11832a(c3526d));
        return c3526d;
    }

    /* renamed from: a */
    private void m11824a(File file) {
        if (this.f12771i == null) {
            return;
        }
        try {
            synchronized (f12757b) {
                byte[] m11073a = new C3369bz().m11073a(this.f12771i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(m11073a);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
