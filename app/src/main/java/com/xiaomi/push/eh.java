package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class eh implements ef {
    private ef a;

    private static class a {
        private static eh a = new eh();
    }

    public static eh a() {
        return a.a;
    }

    private eh() {
    }

    @Override // com.xiaomi.push.ef
    public void a(ee eeVar) {
        ef efVar = this.a;
        if (efVar != null) {
            efVar.a(eeVar);
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(String str, Map<String, Object> map) {
        ef efVar = this.a;
        if (efVar != null) {
            efVar.a(str, map);
        }
    }
}
