package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface HonorPushCallback<T> {
    void onFailure(int i2, String str);

    void onSuccess(T t);
}
