package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.s */
/* loaded from: classes.dex */
public class C2228s {

    /* renamed from: a */
    public final Context f6823a;

    /* renamed from: b */
    public C2184a0 f6824b = new C2184a0();

    /* renamed from: com.hihonor.push.sdk.s$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Callable f6825a;

        /* renamed from: b */
        public final /* synthetic */ HonorPushCallback f6826b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.f6825a = callable;
            this.f6826b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object call = this.f6825a.call();
                C2228s c2228s = C2228s.this;
                HonorPushCallback honorPushCallback = this.f6826b;
                c2228s.getClass();
                C2188b1.m6373a(new RunnableC2230t(c2228s, honorPushCallback, call));
            } catch (ApiException e2) {
                C2228s.m6398a(C2228s.this, this.f6826b, e2.getErrorCode(), e2.getMessage());
            } catch (Exception unused) {
                C2228s c2228s2 = C2228s.this;
                HonorPushCallback honorPushCallback2 = this.f6826b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                C2228s.m6398a(c2228s2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public C2228s(Context context) {
        this.f6823a = context;
    }

    /* renamed from: a */
    public static void m6398a(C2228s c2228s, HonorPushCallback honorPushCallback, int i2, String str) {
        c2228s.getClass();
        C2188b1.m6373a(new RunnableC2232u(c2228s, honorPushCallback, i2, str));
    }

    /* renamed from: a */
    public final <T> void m6399a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        C2188b1 c2188b1 = C2188b1.f6753d;
        if (c2188b1.f6755b == null) {
            synchronized (c2188b1.f6756c) {
                if (c2188b1.f6755b == null) {
                    c2188b1.f6755b = c2188b1.m6375b();
                }
            }
        }
        c2188b1.f6755b.execute(aVar);
    }
}
