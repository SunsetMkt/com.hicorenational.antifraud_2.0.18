package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.c */
/* loaded from: classes.dex */
public class C0827c {

    /* renamed from: a */
    private final ConcurrentHashMap<String, String> f1074a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private boolean f1075b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.c$a */
    public static class a {

        /* renamed from: a */
        public static C0827c f1076a = new C0827c();

        private a() {
        }
    }

    /* renamed from: a */
    public void m668a(boolean z) {
        this.f1075b = z;
    }

    /* renamed from: b */
    public void m669b(String str) {
        this.f1074a.put(str, HttpConstant.HTTP);
    }

    /* renamed from: a */
    public String m667a(String str) {
        if (!this.f1075b) {
            return null;
        }
        String str2 = this.f1074a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f1074a.put(str, HttpConstant.HTTPS);
        return HttpConstant.HTTPS;
    }
}
