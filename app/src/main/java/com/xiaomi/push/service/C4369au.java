package com.xiaomi.push.service;

import com.xiaomi.push.C4252gs;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.au */
/* loaded from: classes2.dex */
public class C4369au {
    /* renamed from: a */
    public static C4252gs m16011a(C4252gs c4252gs) {
        Map<String, String> map;
        if (c4252gs != null && (map = c4252gs.f15846b) != null) {
            map.remove("score_info");
        }
        return c4252gs;
    }
}
