package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* renamed from: com.hihonor.push.sdk.l */
/* loaded from: classes.dex */
public class C2214l {

    /* renamed from: e */
    public static final C2214l f6798e = new C2214l();

    /* renamed from: a */
    public WeakReference<Context> f6799a;

    /* renamed from: b */
    public volatile boolean f6800b = false;

    /* renamed from: c */
    public volatile boolean f6801c = false;

    /* renamed from: d */
    public C2228s f6802d;

    /* renamed from: com.hihonor.push.sdk.l$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Runnable f6803a;

        /* renamed from: b */
        public final /* synthetic */ HonorPushCallback f6804b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.f6803a = runnable;
            this.f6804b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2214l.this.f6800b) {
                this.f6803a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.f6804b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    /* renamed from: a */
    public boolean m6395a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == C2186b.m6371b(context);
    }

    /* renamed from: a */
    public Context m6393a() {
        return this.f6799a.get();
    }

    /* renamed from: a */
    public final void m6394a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        C2188b1.m6373a(new a(runnable, honorPushCallback));
    }
}
