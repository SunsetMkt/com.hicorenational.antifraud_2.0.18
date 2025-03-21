package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a */
    private final String f7297a;

    /* renamed from: b */
    private final String f7298b;

    /* renamed from: c */
    private Parcelable f7299c;

    /* renamed from: d */
    private String f7300d;

    /* renamed from: e */
    private CancellationToken f7301e;

    /* renamed from: f */
    private int f7302f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f7302f = 1;
        this.f7297a = str;
        this.f7298b = str2;
        this.f7299c = null;
        this.f7300d = null;
    }

    protected abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f7302f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f7299c;
    }

    public String getRequestJson() {
        return this.f7298b;
    }

    public CancellationToken getToken() {
        return this.f7301e;
    }

    public String getTransactionId() {
        return this.f7300d;
    }

    public String getUri() {
        return this.f7297a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f7301e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.m7717i("TaskApiCall", "This Task has been canceled, uri:" + this.f7297a + ", transactionId:" + this.f7300d);
            return;
        }
        HMSLog.m7717i("TaskApiCall", "doExecute, uri:" + this.f7297a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f7300d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i2) {
        this.f7302f = i2;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f7299c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f7301e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f7300d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f7302f = 1;
        this.f7297a = str;
        this.f7298b = str2;
        this.f7299c = null;
        this.f7300d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i2) {
        this.f7297a = str;
        this.f7298b = str2;
        this.f7299c = null;
        this.f7300d = str3;
        this.f7302f = i2;
    }
}
