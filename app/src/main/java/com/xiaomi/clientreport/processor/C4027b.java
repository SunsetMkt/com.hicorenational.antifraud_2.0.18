package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.C4024a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C4110bl;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.clientreport.processor.b */
/* loaded from: classes2.dex */
public class C4027b implements IPerfProcessor {

    /* renamed from: a */
    protected Context f14335a;

    /* renamed from: a */
    private HashMap<String, HashMap<String, C4024a>> f14336a;

    public C4027b(Context context) {
        this.f14335a = context;
    }

    /* renamed from: c */
    private String m13406c(C4024a c4024a) {
        String m13405b = m13405b(c4024a);
        if (TextUtils.isEmpty(m13405b)) {
            return null;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            String str = m13405b + i2;
            if (C4110bl.m13923a(this.f14335a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4028c
    /* renamed from: a */
    public void mo13398a() {
        C4110bl.m13920a(this.f14335a, "perf", "perfUploading");
        File[] m13925a = C4110bl.m13925a(this.f14335a, "perfUploading");
        if (m13925a == null || m13925a.length <= 0) {
            return;
        }
        for (File file : m13925a) {
            if (file != null) {
                List<String> m13413a = C4030e.m13413a(this.f14335a, file.getAbsolutePath());
                file.delete();
                mo13407a(m13413a);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4029d
    /* renamed from: b */
    public void mo13403b() {
        HashMap<String, HashMap<String, C4024a>> hashMap = this.f14336a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f14336a.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, C4024a> hashMap2 = this.f14336a.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    C4024a[] c4024aArr = new C4024a[hashMap2.size()];
                    hashMap2.values().toArray(c4024aArr);
                    m13408a(c4024aArr);
                }
            }
        }
        this.f14336a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, C4024a>> hashMap) {
        this.f14336a = hashMap;
    }

    /* renamed from: a */
    public void mo13407a(List<String> list) {
        C4110bl.m13921a(this.f14335a, list);
    }

    /* renamed from: a */
    public void m13408a(C4024a[] c4024aArr) {
        String m13406c = m13406c(c4024aArr[0]);
        if (TextUtils.isEmpty(m13406c)) {
            return;
        }
        C4030e.m13415a(m13406c, c4024aArr);
    }

    /* renamed from: b */
    private String m13405b(C4024a c4024a) {
        String str;
        int i2 = c4024a.production;
        String str2 = c4024a.clientInterfaceId;
        if (i2 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i2) + "#" + str2;
        }
        File file = new File(this.f14335a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4029d
    /* renamed from: a */
    public void mo13400a(C4024a c4024a) {
        if ((c4024a instanceof PerfClientReport) && this.f14336a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) c4024a;
            String m13404a = m13404a((C4024a) perfClientReport);
            String m13411a = C4030e.m13411a(perfClientReport);
            HashMap<String, C4024a> hashMap = this.f14336a.get(m13404a);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(m13411a);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(m13411a, perfClientReport);
            this.f14336a.put(m13404a, hashMap);
        }
    }

    /* renamed from: a */
    public static String m13404a(C4024a c4024a) {
        return String.valueOf(c4024a.production) + "#" + c4024a.clientInterfaceId;
    }
}
