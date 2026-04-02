package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: e */
    public static final l f4263e = new l();
    public WeakReference<Context> a;

    /* JADX INFO: renamed from: b */
    public volatile boolean f4264b = false;

    /* JADX INFO: renamed from: c */
    public volatile boolean f4265c = false;

    /* JADX INFO: renamed from: d */
    public s f4266d;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ HonorPushCallback f4267b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.a = runnable;
            this.f4267b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f4264b) {
                this.a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.f4267b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public boolean a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == b.b(context);
    }

    public Context a() {
        return this.a.get();
    }

    public final void a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        b1.a(new a(runnable, honorPushCallback));
    }
}
