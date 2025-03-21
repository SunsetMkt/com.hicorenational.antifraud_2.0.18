package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: anet.channel.c */
/* loaded from: classes.dex */
class C0753c {

    /* renamed from: a */
    Map<String, Integer> f766a = new HashMap();

    /* renamed from: b */
    Map<String, SessionInfo> f767b = new ConcurrentHashMap();

    C0753c() {
    }

    /* renamed from: a */
    void m451a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        }
        if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.f767b.put(sessionInfo.host, sessionInfo);
    }

    /* renamed from: b */
    SessionInfo m453b(String str) {
        return this.f767b.get(str);
    }

    /* renamed from: c */
    public int m454c(String str) {
        Integer num;
        synchronized (this.f766a) {
            num = this.f766a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* renamed from: a */
    SessionInfo m449a(String str) {
        return this.f767b.remove(str);
    }

    /* renamed from: a */
    Collection<SessionInfo> m450a() {
        return this.f767b.values();
    }

    /* renamed from: a */
    void m452a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f766a) {
                this.f766a.put(str, Integer.valueOf(i2));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
