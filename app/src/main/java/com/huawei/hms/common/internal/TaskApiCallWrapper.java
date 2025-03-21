package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a */
    private final TaskApiCall<? extends AnyClient, TResult> f7303a;

    /* renamed from: b */
    private final TaskCompletionSource<TResult> f7304b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f7303a = taskApiCall;
        this.f7304b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f7303a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f7304b;
    }
}
