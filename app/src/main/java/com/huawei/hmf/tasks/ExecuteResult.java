package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes.dex */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
