package p000a.p001a.p011r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: a.a.r.c */
/* loaded from: classes.dex */
class C0033c extends LinkedHashMap<String, String> {
    final /* synthetic */ C0034d this$0;

    C0033c(C0034d c0034d) {
        this.this$0 = c0034d;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 100;
    }
}
