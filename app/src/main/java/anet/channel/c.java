package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c {
    Map<String, Integer> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<String, SessionInfo> f1399b = new ConcurrentHashMap();

    c() {
    }

    void a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        }
        if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.f1399b.put(sessionInfo.host, sessionInfo);
    }

    SessionInfo b(String str) {
        return this.f1399b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.a) {
            num = this.a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    SessionInfo a(String str) {
        return this.f1399b.remove(str);
    }

    Collection<SessionInfo> a() {
        return this.f1399b.values();
    }

    void a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                this.a.put(str, Integer.valueOf(i2));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
