package com.huawei.hms.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.p182ui.SafeIntent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* renamed from: b */
    private static final int f7015b = m6507a("ro.build.hw_emui_api_level", 0);

    /* renamed from: a */
    private IBridgeActivityDelegate f7016a;

    /* renamed from: com.huawei.hms.activity.BridgeActivity$a */
    class ViewOnApplyWindowInsetsListenerC2283a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f7017a;

        ViewOnApplyWindowInsetsListenerC2283a(ViewGroup viewGroup) {
            this.f7017a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object invoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                if (invoke == null) {
                    HMSLog.m7717i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(invoke, new Object[0]);
                    ViewGroup viewGroup = this.f7017a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                HMSLog.m7715e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e2.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    /* renamed from: a */
    private static void m6509a(Window window, boolean z) {
        try {
            window.getClass().getMethod("setHwFloating", Boolean.TYPE).invoke(window, Boolean.valueOf(z));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e2) {
            HMSLog.m7715e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e2.getMessage());
        }
    }

    /* renamed from: b */
    private boolean m6510b() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.m7715e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra(EXTRA_IS_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
            if (stringExtra == null) {
                HMSLog.m7715e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
                return false;
            }
            IBridgeActivityDelegate iBridgeActivityDelegate = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
            this.f7016a = iBridgeActivityDelegate;
            try {
                iBridgeActivityDelegate.onBridgeActivityCreate(this);
                return true;
            } catch (Throwable th) {
                HMSLog.m7715e("BridgeActivity", "onBridgeActivityCreate Exception." + th.getMessage());
                return false;
            }
        } catch (ClassCastException e2) {
            e = e2;
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (ClassNotFoundException e3) {
            e = e3;
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (IllegalAccessException e4) {
            e = e4;
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (IllegalStateException e5) {
            e = e5;
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (InstantiationException e6) {
            e = e6;
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (Throwable unused) {
            HMSLog.m7715e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance, throwable occur.");
            return false;
        }
    }

    /* renamed from: c */
    private void m6511c() {
        try {
            requestWindowFeature(1);
        } catch (Exception e2) {
            HMSLog.m7718w("BridgeActivity", "requestWindowFeature " + e2.getMessage());
        }
        Window window = getWindow();
        if (f7015b >= 9) {
            window.addFlags(AbstractC1191a.f2487B1);
            m6509a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(1280);
            return;
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes2), 65536);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m7715e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        HMSLog.m7717i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent modifyIntentBehaviorsSafe = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            return new SafeIntent(modifyIntentBehaviorsSafe);
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i2, i3, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f7016a;
        if (iBridgeActivityDelegate != null) {
            boolean z = false;
            try {
                z = iBridgeActivityDelegate.onBridgeActivityResult(i2, i3, safeIntent);
            } catch (Throwable unused) {
                HMSLog.m7718w("BridgeActivity", "onBridgeActivityResult failed, throwable occur.");
            }
            if (z || isFinishing()) {
                return;
            }
            setResult(i3, UIUtil.modifyIntentBehaviorsSafe(safeIntent));
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f7016a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HMSLog.m7717i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            setResult(1, null);
            finish();
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        m6511c();
        m6508a();
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (m6510b()) {
            return;
        }
        setResult(1, null);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            ResolutionFlagUtil.getInstance().removeResolutionFlag(new SafeIntent(getIntent()).getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
        } catch (Throwable th) {
            HMSLog.m7718w("BridgeActivity", "get transaction_id from intent fail: " + th.getClass().getSimpleName());
        }
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f7016a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        HMSLog.m7717i("BridgeActivity", "BridgeActivity onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f7016a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i2, keyEvent);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* renamed from: a */
    private void m6508a() {
        View findViewById = getWindow().findViewById(R.id.content);
        if (findViewById != null && (findViewById instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
                cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                HMSLog.m7715e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e2.getMessage());
            }
            if (Build.VERSION.SDK_INT >= 20) {
                getWindow().getDecorView().setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC2283a(viewGroup));
                return;
            }
            return;
        }
        HMSLog.m7715e("BridgeActivity", "rootView is null or not ViewGroup");
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    /* renamed from: a */
    private static int m6507a(String str, int i2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i2))).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m7715e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i2;
        }
    }
}
