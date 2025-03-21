package p000a.p001a.p011r;

import anet.channel.util.StringUtils;
import java.util.Collections;
import java.util.Map;
import p000a.p001a.p012s.C0035a;

/* compiled from: Taobao */
/* renamed from: a.a.r.d */
/* loaded from: classes.dex */
class C0034d implements InterfaceC0031a {

    /* renamed from: b */
    private static final int f80b = 100;

    /* renamed from: c */
    private static final String f81c = "{\"oneWayTime\" : 0, \"totalSize\" : 0}";

    /* renamed from: a */
    private Map<String, String> f82a;

    /* compiled from: Taobao */
    /* renamed from: a.a.r.d$a */
    private static class a {

        /* renamed from: a */
        public static C0034d f83a = new C0034d(null);

        private a() {
        }
    }

    /* synthetic */ C0034d(C0033c c0033c) {
        this();
    }

    /* renamed from: a */
    public static C0034d m172a() {
        return a.f83a;
    }

    @Override // p000a.p001a.p011r.InterfaceC0031a
    public String get(String str) {
        return this.f82a.get(str);
    }

    private C0034d() {
        this.f82a = Collections.synchronizedMap(new C0033c(this));
    }

    @Override // p000a.p001a.p011r.InterfaceC0031a
    /* renamed from: a */
    public void mo170a(String str, C0035a c0035a) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(c0035a.oneWayTime_ANet);
        sb.append(", \"totalSize\" : ");
        sb.append(c0035a.totalSize);
        sb.append("}");
        this.f82a.put(str, sb.toString());
    }

    @Override // p000a.p001a.p011r.InterfaceC0031a
    /* renamed from: a */
    public void mo169a(String str) {
        if (this.f82a.containsKey(str)) {
            this.f82a.put(str, f81c);
        }
    }
}
