package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {

    /* renamed from: a */
    private R f7824a = null;

    /* renamed from: b */
    private int f7825b;

    /* renamed from: com.huawei.hms.support.api.ErrorResultImpl$a */
    class RunnableC2508a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f7826a;

        /* renamed from: b */
        final /* synthetic */ ErrorResultImpl f7827b;

        RunnableC2508a(ResultCallback resultCallback, ErrorResultImpl errorResultImpl) {
            this.f7826a = resultCallback;
            this.f7827b = errorResultImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultCallback resultCallback = this.f7826a;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.m7661a(errorResultImpl.f7825b, this.f7827b));
        }
    }

    public ErrorResultImpl(int i2) {
        this.f7825b = i2;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return await(0L, null);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    protected void postRunnable(Looper looper, ResultCallback<R> resultCallback, ErrorResultImpl errorResultImpl) {
        if (looper == null) {
            looper = Looper.myLooper();
        }
        new Handler(looper).post(new RunnableC2508a(resultCallback, errorResultImpl));
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j2, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m7661a(this.f7825b, this);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public R m7661a(int i2, ErrorResultImpl errorResultImpl) {
        Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            R r = (R) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
            this.f7824a = r;
            r.setStatus(new Status(i2));
        } catch (IllegalAccessException unused) {
            HMSLog.m7715e("ErrorResultImpl", "IllegalAccessException");
        } catch (InstantiationException unused2) {
            HMSLog.m7715e("ErrorResultImpl", "InstantiationException");
        }
        return this.f7824a;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j2, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        postRunnable(looper, resultCallback, this);
    }
}
