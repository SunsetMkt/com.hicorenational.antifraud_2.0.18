package p388ui;

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
import com.leon.channel.helper.C2620b;
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
import p245d.C4440a;
import receiver.C6088e;
import util.C7298m1;
import util.C7307p1;
import util.C7325u1;
import util.C7327v0;
import util.C7328v1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class Hicore extends Application implements CameraXConfig.Provider {
    private static Hicore app = null;
    public static boolean fromPageReport = false;
    private static CallIntercepeUtil mCallIntercepeUtile;
    public static String schemeString;
    public final int MIN_CLICK_DELAY_TIME = BannerConfig.DURATION;
    private long mLastClickTime = 0;

    private void compatibleWarn160() {
        if (C7325u1.m26623a(C7325u1.f25629D, false)) {
            C7325u1.m26623a(C7325u1.f25633F, true);
            C7325u1.m26623a(C7325u1.f25635G, true);
            C7325u1.m26623a(C7325u1.f25637H, true);
        }
    }

    public static Hicore getApp() {
        return app;
    }

    private void initBugly() {
        Bugly.setAppChannel(TinkerManager.getApplication(), getChannel());
        Bugly.init(app, C7298m1.f25474u.m26433b(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAddressData, reason: merged with bridge method [inline-methods] */
    public void m25194b() {
        AddressHttp.initAddressJson();
    }

    private void startAlarm() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new C7327v0().m26640a(app, checkTimeBean.getCode());
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25193a() {
        C6088e.m25179a((Application) app, getChannel());
        initBugly();
        Tencent.setIsPermissionGranted(true);
        PlatformConfig.setWeixin(C7298m1.f25474u.m26450r(), C7298m1.f25474u.m26451s());
        PlatformConfig.setSinaWeibo(C7298m1.f25474u.m26439g(), C7298m1.f25474u.m26440h(), C7298m1.f25474u.m26441i());
        PlatformConfig.setQQZone(C7298m1.f25474u.m26437e(), C7298m1.f25474u.m26438f());
        PlatformConfig.setDing(C7298m1.f25474u.m26435c());
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
        String str;
        try {
            str = C2620b.m8089c(getApp());
        } catch (Exception unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : OSSConstants.RESOURCE_NAME_OSS;
    }

    public String getCurActivityName() {
        return C6813c.m25437i().m25453h().getLocalClassName();
    }

    public void initSDK() {
        new Thread(new Runnable() { // from class: ui.b
            @Override // java.lang.Runnable
            public final void run() {
                Hicore.this.m25193a();
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
        C4440a.m16410l();
        registerActivityLifecycleCallbacks(C6813c.m25437i());
        C7328v1.m26675l(app);
        C6088e.m25186b(this, getChannel());
        if (C7307p1.m26481a(C7307p1.f25505n, false)) {
            initSDK();
        }
        new Thread(new Runnable() { // from class: ui.a
            @Override // java.lang.Runnable
            public final void run() {
                Hicore.this.m25194b();
            }
        }).start();
        registerPhoneStateListener();
        C7337y1.m26746a(this, 0);
        C7337y1.m26766b(this, 0);
    }

    public void registerPhoneStateListener() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7308a.f25531j);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(C7308a.f25539r);
        }
        if (C7310c.m26520a(this, (String[]) arrayList.toArray(new String[arrayList.size()]))) {
            mCallIntercepeUtile = new CallIntercepeUtil();
            CallIntercepeUtil callIntercepeUtil = mCallIntercepeUtile;
            if (callIntercepeUtil != null) {
                callIntercepeUtil.getIncomingCall(this);
            }
        }
    }
}
