package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.push.C4186eg;
import com.xiaomi.push.C4187eh;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.at */
/* loaded from: classes2.dex */
public class C4368at {

    /* renamed from: a */
    private final ConcurrentHashMap<String, c> f16643a = new ConcurrentHashMap<>();

    /* renamed from: com.xiaomi.push.service.at$a */
    public static class a extends XMPushService.AbstractC4337j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public String mo14643a() {
            return "RecordTimeManager clear";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
        /* renamed from: a */
        public void mo14644a() {
            C4368at.m16002a().m16004a();
        }
    }

    /* renamed from: com.xiaomi.push.service.at$b */
    private static class b {

        /* renamed from: a */
        private static final C4368at f16644a = new C4368at();
    }

    /* renamed from: com.xiaomi.push.service.at$c */
    private static class c {

        /* renamed from: a */
        long f16645a;

        /* renamed from: b */
        long f16646b;

        /* renamed from: c */
        long f16647c;

        /* renamed from: d */
        long f16648d;

        private c() {
        }

        /* renamed from: a */
        public long m16009a() {
            long j2 = this.f16647c;
            long j3 = this.f16646b;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }

        /* renamed from: b */
        public long m16010b() {
            long j2 = this.f16648d;
            long j3 = this.f16647c;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }
    }

    /* renamed from: a */
    public static C4368at m16002a() {
        return b.f16644a;
    }

    /* renamed from: b */
    public void m16007b(String str, long j2) {
        c remove = this.f16643a.remove(str);
        if (remove != null) {
            remove.f16648d = j2;
            m16003a(str, remove);
        }
    }

    /* renamed from: a */
    public void m16004a() {
        if (this.f16643a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.f16643a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.f16646b) > C2084a.f6135q) {
                    m16003a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    public void m16006a(String str, long j2, long j3) {
        c cVar = new c();
        cVar.f16645a = j3;
        cVar.f16646b = j2;
        this.f16643a.put(str, cVar);
    }

    /* renamed from: a */
    public void m16005a(String str, long j2) {
        c cVar = this.f16643a.get(str);
        if (cVar != null) {
            cVar.f16647c = j2;
        }
    }

    /* renamed from: a */
    private void m16003a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xmsfVC", Long.valueOf(cVar.f16645a));
        hashMap.put("packetId", str);
        hashMap.put("pTime", Long.valueOf(cVar.m16009a()));
        hashMap.put("bTime", Long.valueOf(cVar.m16010b()));
        C4187eh.m14597a().mo14595a(new C4186eg("msg_process_time", hashMap));
    }
}
