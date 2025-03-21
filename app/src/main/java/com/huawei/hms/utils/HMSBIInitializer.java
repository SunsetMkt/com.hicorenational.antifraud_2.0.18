package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C2507a;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class HMSBIInitializer {

    /* renamed from: d */
    private static final Object f7936d = new Object();

    /* renamed from: e */
    private static HMSBIInitializer f7937e;

    /* renamed from: f */
    private static HiAnalyticsInstance f7938f;

    /* renamed from: a */
    private final Context f7939a;

    /* renamed from: b */
    private AtomicBoolean f7940b = new AtomicBoolean(false);

    /* renamed from: c */
    private boolean f7941c = HianalyticsExist.isHianalyticsExist();

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$a */
    class C2540a implements IQueryUrlCallBack {
        C2540a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i2) {
            HMSLog.m7715e("HMSBIInitializer", "get grs failed, the errorcode is " + i2);
            HMSBIInitializer.this.f7940b.set(false);
            C2507a.m7656c().m7657a();
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (HMSBIInitializer.this.f7941c) {
                    HMSBIInitializer.this.m7737a(str);
                } else {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f7939a, false, false, false, str, "com.huawei.hwid");
                }
                HMSLog.m7717i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.f7940b.set(false);
            C2507a.m7656c().m7659b();
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$b */
    private class AsyncTaskC2541b extends AsyncTask<String, Integer, Void> {
        private AsyncTaskC2541b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.m7741b(strArr[0]);
            return null;
        }

        /* synthetic */ AsyncTaskC2541b(HMSBIInitializer hMSBIInitializer, C2540a c2540a) {
            this();
        }
    }

    private HMSBIInitializer(Context context) {
        this.f7939a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f7936d) {
            if (f7937e == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f7937e = new HMSBIInitializer(applicationContext);
                } else {
                    f7937e = new HMSBIInitializer(context);
                }
            }
        }
        return f7937e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f7938f;
    }

    public void initBI() {
        boolean initFlag = !this.f7941c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        HMSLog.m7717i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || AnalyticsSwitchHolder.isAnalyticsDisabled(this.f7939a)) {
            return;
        }
        HMSLog.m7717i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
        initHaSDK();
    }

    protected void initHaSDK() {
        if (this.f7940b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f7939a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
                new AsyncTaskC2541b(this, null).execute(issueCountryCode);
            } else {
                HMSLog.m7715e("HMSBIInitializer", "Failed to get device issue country");
                this.f7940b.set(false);
            }
        }
    }

    public boolean isInit() {
        return !this.f7941c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7737a(String str) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f7938f = instanceByTag;
        if (instanceByTag != null) {
            instanceByTag.setAppid("com.huawei.hwid");
            return;
        }
        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
        HiAnalyticsInstance create = new HiAnalyticsInstance.Builder(this.f7939a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f7938f = create;
        if (create != null) {
            create.setAppid("com.huawei.hwid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7741b(String str) {
        HMSLog.m7717i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f7939a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new C2540a());
    }
}
