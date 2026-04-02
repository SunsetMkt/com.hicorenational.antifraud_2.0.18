package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {
    private final String a;

    /* JADX INFO: renamed from: b */
    private final String f4573b;

    /* JADX INFO: renamed from: c */
    private Parcelable f4574c;

    /* JADX INFO: renamed from: d */
    private String f4575d;

    /* JADX INFO: renamed from: e */
    private CancellationToken f4576e;

    /* JADX INFO: renamed from: f */
    private int f4577f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f4577f = 1;
        this.a = str;
        this.f4573b = str2;
        this.f4574c = null;
        this.f4575d = null;
    }

    protected abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f4577f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f4574c;
    }

    public String getRequestJson() {
        return this.f4573b;
    }

    public CancellationToken getToken() {
        return this.f4576e;
    }

    public String getTransactionId() {
        return this.f4575d;
    }

    public String getUri() {
        return this.a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f4576e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.a + ", transactionId:" + this.f4575d);
            return;
        }
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f4575d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i2) {
        this.f4577f = i2;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f4574c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f4576e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f4575d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f4577f = 1;
        this.a = str;
        this.f4573b = str2;
        this.f4574c = null;
        this.f4575d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i2) {
        this.a = str;
        this.f4573b = str2;
        this.f4574c = null;
        this.f4575d = str3;
        this.f4577f = i2;
    }
}
