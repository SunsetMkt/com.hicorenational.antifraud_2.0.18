package com.huawei.hms.framework.network.grs;

import java.util.Map;

/* loaded from: classes.dex */
public interface IQueryUrlsCallBack {
    void onCallBackFail(int i2);

    void onCallBackSuccess(Map<String, String> map);
}
