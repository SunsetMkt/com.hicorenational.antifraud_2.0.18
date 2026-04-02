package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
