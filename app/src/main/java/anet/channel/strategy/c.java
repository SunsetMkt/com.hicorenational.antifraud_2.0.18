package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1586b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public static c a = new c();

        private a() {
        }
    }

    public void a(boolean z) {
        this.f1586b = z;
    }

    public void b(String str) {
        this.a.put(str, HttpConstant.HTTP);
    }

    public String a(String str) {
        if (!this.f1586b) {
            return null;
        }
        String str2 = this.a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.a.put(str, HttpConstant.HTTPS);
        return HttpConstant.HTTPS;
    }
}
