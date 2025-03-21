package com.huawei.agconnect.core.p169a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.agconnect.core.a.a */
/* loaded from: classes.dex */
public class C2263a extends AGCInitFinishManager {

    /* renamed from: a */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f6925a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static void m6449a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> it = f6925a.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f6925a.add(aGCInitFinishCallback);
        }
    }
}
