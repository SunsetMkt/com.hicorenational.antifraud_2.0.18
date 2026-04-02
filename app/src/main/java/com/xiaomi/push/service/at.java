package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eg;
import com.xiaomi.push.eh;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class at {
    private final ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();

    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            at.a().m702a();
        }
    }

    private static class b {
        private static final at a = new at();
    }

    private static class c {
        long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f9390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f9392d;

        private c() {
        }

        public long a() {
            long j2 = this.f9391c;
            long j3 = this.f9390b;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }

        public long b() {
            long j2 = this.f9392d;
            long j3 = this.f9391c;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }
    }

    public static at a() {
        return b.a;
    }

    public void b(String str, long j2) {
        c cVarRemove = this.a.remove(str);
        if (cVarRemove != null) {
            cVarRemove.f9392d = j2;
            a(str, cVarRemove);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m702a() {
        if (this.a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.f9390b) > com.heytap.mcssdk.constant.a.q) {
                    a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    public void a(String str, long j2, long j3) {
        c cVar = new c();
        cVar.a = j3;
        cVar.f9390b = j2;
        this.a.put(str, cVar);
    }

    public void a(String str, long j2) {
        c cVar = this.a.get(str);
        if (cVar != null) {
            cVar.f9391c = j2;
        }
    }

    private void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("xmsfVC", Long.valueOf(cVar.a));
        map.put("packetId", str);
        map.put("pTime", Long.valueOf(cVar.a()));
        map.put("bTime", Long.valueOf(cVar.b()));
        eh.a().a(new eg("msg_process_time", map));
    }
}
