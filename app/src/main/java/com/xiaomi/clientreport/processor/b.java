package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bl;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class b implements IPerfProcessor {

    /* renamed from: a, reason: collision with root package name */
    protected Context f12334a;

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f87a;

    public b(Context context) {
        this.f12334a = context;
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            String str = b2 + i2;
            if (bl.m185a(this.f12334a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bl.a(this.f12334a, "perf", "perfUploading");
        File[] m186a = bl.m186a(this.f12334a, "perfUploading");
        if (m186a == null || m186a.length <= 0) {
            return;
        }
        for (File file : m186a) {
            if (file != null) {
                List<String> a2 = e.a(this.f12334a, file.getAbsolutePath());
                file.delete();
                a(a2);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f87a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f87a.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f87a.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f87a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f87a = hashMap;
    }

    public void a(List<String> list) {
        bl.a(this.f12334a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String c2 = c(aVarArr[0]);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        e.a(c2, aVarArr);
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        int i2 = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i2 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i2) + "#" + str2;
        }
        File file = new File(this.f12334a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo62a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f87a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f87a.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a3, perfClientReport);
            this.f87a.put(a2, hashMap);
        }
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }
}
