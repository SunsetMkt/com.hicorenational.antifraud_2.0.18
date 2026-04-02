package b.a.r;

import anet.channel.util.StringUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements b.a.r.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f1850b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f1851c = "{\"oneWayTime\" : 0, \"totalSize\" : 0}";
    private Map<String, String> a;

    /* JADX INFO: compiled from: Taobao */
    private static class a {
        public static d a = new d(null);

        private a() {
        }
    }

    /* synthetic */ d(c cVar) {
        this();
    }

    public static d a() {
        return a.a;
    }

    @Override // b.a.r.a
    public String get(String str) {
        return this.a.get(str);
    }

    private d() {
        this.a = Collections.synchronizedMap(new c(this));
    }

    @Override // b.a.r.a
    public void a(String str, b.a.s.a aVar) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(aVar.oneWayTime_ANet);
        sb.append(", \"totalSize\" : ");
        sb.append(aVar.totalSize);
        sb.append("}");
        this.a.put(str, sb.toString());
    }

    @Override // b.a.r.a
    public void a(String str) {
        if (this.a.containsKey(str)) {
            this.a.put(str, f1851c);
        }
    }
}
