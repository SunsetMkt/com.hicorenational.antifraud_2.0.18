package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.huawei.hms.hatool.p0 */
/* loaded from: classes.dex */
public class C2440p0 {

    /* renamed from: a */
    private long f7592a = 1800000;

    /* renamed from: b */
    private volatile boolean f7593b = false;

    /* renamed from: c */
    private a f7594c = null;

    /* renamed from: com.huawei.hms.hatool.p0$a */
    private class a {

        /* renamed from: a */
        String f7595a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* renamed from: b */
        boolean f7596b;

        /* renamed from: c */
        private long f7597c;

        a(long j2) {
            this.f7595a += AbstractC1191a.f2606s1 + j2;
            this.f7597c = j2;
            this.f7596b = true;
            C2440p0.this.f7593b = false;
        }

        /* renamed from: a */
        private boolean m7283a(long j2, long j3) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        /* renamed from: b */
        private void m7284b(long j2) {
            C2452v.m7385c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f7595a = uuid;
            this.f7595a = uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f7595a += AbstractC1191a.f2606s1 + j2;
            this.f7597c = j2;
            this.f7596b = true;
        }

        /* renamed from: b */
        private boolean m7285b(long j2, long j3) {
            return j3 - j2 >= C2440p0.this.f7592a;
        }

        /* renamed from: a */
        void m7286a(long j2) {
            if (C2440p0.this.f7593b) {
                C2440p0.this.f7593b = false;
                m7284b(j2);
            } else if (m7285b(this.f7597c, j2) || m7283a(this.f7597c, j2)) {
                m7284b(j2);
            } else {
                this.f7597c = j2;
                this.f7596b = false;
            }
        }
    }

    /* renamed from: a */
    public String m7280a() {
        a aVar = this.f7594c;
        if (aVar != null) {
            return aVar.f7595a;
        }
        C2452v.m7390f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* renamed from: a */
    void m7281a(long j2) {
        a aVar = this.f7594c;
        if (aVar != null) {
            aVar.m7286a(j2);
        } else {
            C2452v.m7385c("hmsSdk", "Session is first flush");
            this.f7594c = new a(j2);
        }
    }

    /* renamed from: b */
    public boolean m7282b() {
        a aVar = this.f7594c;
        if (aVar != null) {
            return aVar.f7596b;
        }
        C2452v.m7390f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
