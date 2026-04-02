package ui;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;
import androidx.multidex.MultiDex;
import bean.CheckTimeBean;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.hicorenational.antifraud.service.CallIntercepeUtil;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.mmkv.MMKV;
import com.tencent.tauth.Tencent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.PlatformConfig;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import java.util.Calendar;
import network.http.AddressHttp;
import receiver.e;
import util.c2;
import util.d2;
import util.g2;
import util.r1;
import util.u1;
import util.y0;

/* JADX INFO: loaded from: classes2.dex */
public class Hicore extends Application implements CameraXConfig.Provider {
    private static Hicore app = null;
    public static boolean fromPageReport = false;
    private static CallIntercepeUtil mCallIntercepeUtile;
    public static String schemeString;
    public final int MIN_CLICK_DELAY_TIME = BannerConfig.DURATION;
    private long mLastClickTime = 0;

    private void compatibleWarn160() {
        if (c2.a(c2.D, false)) {
            c2.a(c2.F, true);
            c2.a(c2.G, true);
            c2.a(c2.H, true);
        }
    }

    public static Hicore getApp() {
        return app;
    }

    private void initBugly() {
        Bugly.setAppChannel(TinkerManager.getApplication(), getChannel());
        Bugly.init(app, r1.u.b(), false);
    }

    /* JADX INFO: renamed from: saveAddressData */
    public void b() {
        AddressHttp.initAddressJson();
    }

    private void startAlarm() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new y0().a(app, checkTimeBean.getCode());
        }
    }

    public /* synthetic */ void a() {
        e.a((Application) app, getChannel());
        initBugly();
        Tencent.setIsPermissionGranted(true);
        PlatformConfig.setWeixin(r1.u.r(), r1.u.s());
        PlatformConfig.setSinaWeibo(r1.u.g(), r1.u.h(), r1.u.i());
        PlatformConfig.setQQZone(r1.u.e(), r1.u.f());
        PlatformConfig.setDing(r1.u.c());
        PlatformConfig.setWXFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setSinaFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setQQFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setDingFileProvider(getPackageName() + ".fileprovider");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
        startAlarm();
        compatibleWarn160();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override // androidx.camera.core.CameraXConfig.Provider
    @NonNull
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.defaultConfig();
    }

    public String getChannel() {
        String strC;
        try {
            strC = com.leon.channel.helper.b.c(getApp());
        } catch (Exception unused) {
            strC = "";
        }
        return !TextUtils.isEmpty(strC) ? strC : OSSConstants.RESOURCE_NAME_OSS;
    }

    public String getCurActivityName() {
        return c.i().h().getLocalClassName();
    }

    public void initSDK() {
        new Thread(new Runnable() { // from class: ui.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }).start();
    }

    public boolean isDouble() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j2 = timeInMillis - this.mLastClickTime;
        if (j2 <= 800 && j2 >= 0) {
            return true;
        }
        this.mLastClickTime = timeInMillis;
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        app = this;
        MMKV.initialize(this);
        e.a.l();
        registerActivityLifecycleCallbacks(c.i());
        d2.l(app);
        e.b(this, getChannel());
        if (u1.a(u1.f15091n, false)) {
            initSDK();
        }
        new Thread(new Runnable() { // from class: ui.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        }).start();
        registerPhoneStateListener();
        g2.a(this, 0);
        g2.b(this, 0);
    }

    public void registerPhoneStateListener() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.f15033j);
        arrayList.add(util.permissionutil.a.z);
        arrayList.add(util.permissionutil.a.A);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(util.permissionutil.a.r);
        }
        if (util.permissionutil.c.a(this, (String[]) arrayList.toArray(new String[arrayList.size()]))) {
            mCallIntercepeUtile = new CallIntercepeUtil();
            CallIntercepeUtil callIntercepeUtil = mCallIntercepeUtile;
            if (callIntercepeUtil != null) {
                callIntercepeUtil.getIncomingCall(this);
            }
        }
    }
}
