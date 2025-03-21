package com.huawei.agconnect;

import com.huawei.agconnect.core.p169a.C2263a;

/* loaded from: classes.dex */
public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = new C2263a();

    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback aGCInitFinishCallback);
}
