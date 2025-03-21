package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.C1511c;
import com.alibaba.sdk.android.httpdns.C1522i;
import com.alibaba.sdk.android.httpdns.p111a.C1502a;
import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.sdk.android.httpdns.probe.e */
/* loaded from: classes.dex */
public class C1537e implements IPProbeService {

    /* renamed from: a */
    private AtomicLong f3981a = new AtomicLong(0);

    /* renamed from: c */
    private ConcurrentHashMap<String, Long> f3983c = new ConcurrentHashMap<>();

    /* renamed from: a */
    private InterfaceC1534b f3980a = null;

    /* renamed from: b */
    private InterfaceC1538f f3982b = new InterfaceC1538f() { // from class: com.alibaba.sdk.android.httpdns.probe.e.1
        @Override // com.alibaba.sdk.android.httpdns.probe.InterfaceC1538f
        /* renamed from: a */
        public void mo3573a(long j2, C1535c c1535c) {
            if (c1535c != null) {
                try {
                    if (C1537e.this.f3983c.containsKey(c1535c.getHostName()) && ((Long) C1537e.this.f3983c.get(c1535c.getHostName())).longValue() == j2) {
                        if (c1535c != null && c1535c.getIps() != null && c1535c.m3566j() != null && c1535c.m3567k() != null && c1535c.getHostName() != null) {
                            C1522i.m3526e("defultId:" + c1535c.m3566j() + ", selectedIp:" + c1535c.m3567k() + ", promote:" + (c1535c.m3564c() - c1535c.m3565d()));
                            C1537e.this.m3572a(c1535c.getHostName(), c1535c.m3566j(), c1535c.m3567k(), c1535c.m3564c(), c1535c.m3565d(), c1535c.getIps().length);
                            C1537e.this.f3980a.mo3484a(c1535c.getHostName(), c1535c.getIps());
                            C1537e.this.f3983c.remove(c1535c.getHostName());
                        }
                    }
                    C1522i.m3525d("corresponding tasknumber not exists, drop the result");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3572a(String str, String str2, String str3, long j2, long j3, int i2) {
        C1515b m3486a = C1515b.m3486a();
        if (m3486a != null) {
            m3486a.m3494a(str, str2, str3, j2, j3, i2);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public IPProbeService.EnumC1532a getProbeStatus(String str) {
        return this.f3983c.containsKey(str) ? IPProbeService.EnumC1532a.PROBING : IPProbeService.EnumC1532a.NO_PROBING;
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public void launchIPProbeTask(String str, int i2, String[] strArr) {
        if (!C1502a.m3416a().m3425f()) {
            C1522i.m3527f("ip probe is forbidden");
        } else {
            if (getProbeStatus(str) != IPProbeService.EnumC1532a.NO_PROBING) {
                C1522i.m3527f("already launch the same task, drop the task");
                return;
            }
            long addAndGet = this.f3981a.addAndGet(1L);
            this.f3983c.put(str, Long.valueOf(addAndGet));
            C1511c.m3462a().execute(new RunnableC1533a(addAndGet, str, strArr, i2, this.f3982b));
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public void setIPListUpdateCallback(InterfaceC1534b interfaceC1534b) {
        this.f3980a = interfaceC1534b;
    }

    @Override // com.alibaba.sdk.android.httpdns.probe.IPProbeService
    public boolean stopIPProbeTask(String str) {
        if (!this.f3983c.containsKey(str)) {
            return false;
        }
        C1522i.m3525d("stop ip probe task for host:" + str);
        this.f3983c.remove(str);
        return true;
    }
}
