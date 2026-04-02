package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class p0 {
    private long a = 1800000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4789b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4790c = null;

    private class a {
        String a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f4792c;

        a(long j2) {
            this.a += d.c.a.b.a.a.s1 + j2;
            this.f4792c = j2;
            this.f4791b = true;
            p0.this.f4789b = false;
        }

        private boolean a(long j2, long j3) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private void b(long j2) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.a = string;
            this.a = string.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.a += d.c.a.b.a.a.s1 + j2;
            this.f4792c = j2;
            this.f4791b = true;
        }

        private boolean b(long j2, long j3) {
            return j3 - j2 >= p0.this.a;
        }

        void a(long j2) {
            if (p0.this.f4789b) {
                p0.this.f4789b = false;
                b(j2);
            } else if (b(this.f4792c, j2) || a(this.f4792c, j2)) {
                b(j2);
            } else {
                this.f4792c = j2;
                this.f4791b = false;
            }
        }
    }

    public String a() {
        a aVar = this.f4790c;
        if (aVar != null) {
            return aVar.a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void a(long j2) {
        a aVar = this.f4790c;
        if (aVar != null) {
            aVar.a(j2);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.f4790c = new a(j2);
        }
    }

    public boolean b() {
        a aVar = this.f4790c;
        if (aVar != null) {
            return aVar.f4791b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
