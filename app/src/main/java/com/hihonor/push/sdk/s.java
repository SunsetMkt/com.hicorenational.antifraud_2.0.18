package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f4275b = new a0();

    public class a implements Runnable {
        public final /* synthetic */ Callable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HonorPushCallback f4276b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.a = callable;
            this.f4276b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object objCall = this.a.call();
                s sVar = s.this;
                HonorPushCallback honorPushCallback = this.f4276b;
                sVar.getClass();
                b1.a(new t(sVar, honorPushCallback, objCall));
            } catch (ApiException e2) {
                s.a(s.this, this.f4276b, e2.getErrorCode(), e2.getMessage());
            } catch (Exception unused) {
                s sVar2 = s.this;
                HonorPushCallback honorPushCallback2 = this.f4276b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                s.a(sVar2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public s(Context context) {
        this.a = context;
    }

    public static void a(s sVar, HonorPushCallback honorPushCallback, int i2, String str) {
        sVar.getClass();
        b1.a(new u(sVar, honorPushCallback, i2, str));
    }

    public final <T> void a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        b1 b1Var = b1.f4237d;
        if (b1Var.f4238b == null) {
            synchronized (b1Var.f4239c) {
                if (b1Var.f4238b == null) {
                    b1Var.f4238b = b1Var.b();
                }
            }
        }
        b1Var.f4238b.execute(aVar);
    }
}
