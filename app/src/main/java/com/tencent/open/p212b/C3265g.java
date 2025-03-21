package com.tencent.open.p212b;

import android.content.Context;
import com.tencent.open.utils.C3289g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.g */
/* loaded from: classes2.dex */
public class C3265g {
    /* renamed from: a */
    static void m10464a() {
        Context m10603a = C3289g.m10603a();
        if (m10603a == null) {
            return;
        }
        m10603a.deleteDatabase("sdk_report.db");
    }

    /* renamed from: a */
    public static void m10465a(String str) {
    }

    /* renamed from: a */
    public static void m10466a(String str, List<Serializable> list) {
    }

    /* renamed from: b */
    public static List<Serializable> m10467b(String str) {
        return Collections.synchronizedList(new ArrayList());
    }
}
