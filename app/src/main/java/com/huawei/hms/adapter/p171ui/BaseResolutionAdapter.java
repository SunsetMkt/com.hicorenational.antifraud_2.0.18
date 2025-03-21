package com.huawei.hms.adapter.p171ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f7095a;

    /* renamed from: b */
    private String f7096b = "";

    /* renamed from: c */
    private long f7097c = 0;

    /* renamed from: a */
    private void m6593a(long j2) {
        if (!RegionUtils.isChinaROM(m6596c())) {
            HMSLog.m7717i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity m6596c = m6596c();
        if (m6596c == null || m6596c.isFinishing()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", m6596c.getPackageName());
        hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f7097c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2);
        HiAnalyticsUtils.getInstance().onEvent(m6596c, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
        HMSLog.m7715e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f7096b + ", carriedTimeStamp: " + this.f7097c + ", savedTimeStamp: " + j2);
    }

    /* renamed from: b */
    private void m6595b() {
        Activity m6596c = m6596c();
        if (m6596c == null || m6596c.isFinishing()) {
            return;
        }
        m6596c.finish();
    }

    /* renamed from: c */
    private Activity m6596c() {
        WeakReference<Activity> weakReference = this.f7095a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: d */
    private void m6597d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f7096b);
        m6595b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m7715e("BaseResolutionAdapter", "activity is null");
            m6597d();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m7715e("BaseResolutionAdapter", "activity is finishing");
            return;
        }
        this.f7095a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            m6597d();
            return;
        }
        Bundle bundle = null;
        try {
            bundle = intent.getExtras();
            this.f7096b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            this.f7097c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0L);
        } catch (Throwable th) {
            HMSLog.m7715e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th.getClass().getSimpleName());
        }
        if (!m6594a()) {
            m6597d();
            return;
        }
        if (this.f7096b != null && Build.VERSION.SDK_INT >= 29) {
            HMSLog.m7717i("BaseResolutionAdapter", "remove apk resolution failed task.");
            ApkResolutionFailedManager.getInstance().removeTask(this.f7096b);
        }
        if (bundle == null) {
            m6597d();
            return;
        }
        Parcelable parcelable = bundle.getParcelable("resolution");
        if (parcelable == null) {
            m6597d();
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                return;
            } catch (Throwable unused) {
                m6597d();
                HMSLog.m7715e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                m6597d();
                HMSLog.m7715e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m7717i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f7095a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        if (i2 != getRequestCode()) {
            return false;
        }
        HMSLog.m7717i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i3);
        if (i3 == 1001 || i3 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i3);
        }
        if (i3 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f7096b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(null, this.f7096b);
        }
        m6595b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m7717i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.m7717i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m6594a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f7096b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f7096b);
        if (resolutionFlag != 0 && resolutionFlag == this.f7097c) {
            return true;
        }
        m6593a(resolutionFlag);
        return false;
    }
}
