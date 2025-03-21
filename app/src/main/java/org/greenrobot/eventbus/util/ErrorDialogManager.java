package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import org.greenrobot.eventbus.C6049c;

/* loaded from: classes2.dex */
public class ErrorDialogManager {

    /* renamed from: a */
    public static AbstractC6071c<?> f21627a = null;

    /* renamed from: b */
    protected static final String f21628b = "de.greenrobot.eventbus.error_dialog";

    /* renamed from: c */
    protected static final String f21629c = "de.greenrobot.eventbus.error_dialog_manager";

    /* renamed from: d */
    public static final String f21630d = "de.greenrobot.eventbus.errordialog.title";

    /* renamed from: e */
    public static final String f21631e = "de.greenrobot.eventbus.errordialog.message";

    /* renamed from: f */
    public static final String f21632f = "de.greenrobot.eventbus.errordialog.finish_after_dialog";

    /* renamed from: g */
    public static final String f21633g = "de.greenrobot.eventbus.errordialog.icon_id";

    /* renamed from: h */
    public static final String f21634h = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    /* renamed from: b */
    private static boolean m25063b(Activity activity) {
        String name;
        Class<?> cls = activity.getClass();
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = cls.getName();
            if (name.equals("androidx.fragment.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    /* renamed from: a */
    public static void m25057a(Activity activity) {
        m25060a(activity, false, null);
    }

    /* renamed from: a */
    public static void m25059a(Activity activity, boolean z) {
        m25060a(activity, z, null);
    }

    /* renamed from: a */
    public static void m25060a(Activity activity, boolean z, Bundle bundle) {
        m25058a(activity, activity.getClass(), z, bundle);
    }

    /* renamed from: a */
    public static void m25058a(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (f21627a != null) {
            if (m25063b(activity)) {
                SupportManagerFragment.m25067a(activity, obj, z, bundle);
                return;
            } else {
                HoneycombManagerFragment.m25065a(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: a */
        protected boolean f21635a;

        /* renamed from: b */
        protected Bundle f21636b;

        /* renamed from: c */
        private C6049c f21637c;

        /* renamed from: d */
        private Object f21638d;

        /* renamed from: a */
        public void m25066a(C6074f c6074f) {
            if (ErrorDialogManager.m25064b(this.f21638d, c6074f)) {
                ErrorDialogManager.m25061a(c6074f);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f21628b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.f21627a.m25089a(c6074f, this.f21635a, this.f21636b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f21628b);
                }
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f21637c.m25003g(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.f21637c = ErrorDialogManager.f21627a.f21662a.m25087b();
            this.f21637c.m25001e(this);
        }

        /* renamed from: a */
        public static void m25065a(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f21629c);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, ErrorDialogManager.f21629c).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.f21635a = z;
            honeycombManagerFragment.f21636b = bundle;
            honeycombManagerFragment.f21638d = obj;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {

        /* renamed from: a */
        protected boolean f21639a;

        /* renamed from: b */
        protected Bundle f21640b;

        /* renamed from: c */
        private C6049c f21641c;

        /* renamed from: d */
        private boolean f21642d;

        /* renamed from: e */
        private Object f21643e;

        /* renamed from: a */
        public void m25068a(C6074f c6074f) {
            if (ErrorDialogManager.m25064b(this.f21643e, c6074f)) {
                ErrorDialogManager.m25061a(c6074f);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f21628b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                androidx.fragment.app.DialogFragment dialogFragment2 = (androidx.fragment.app.DialogFragment) ErrorDialogManager.f21627a.m25089a(c6074f, this.f21639a, this.f21640b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f21628b);
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f21641c = ErrorDialogManager.f21627a.f21662a.m25087b();
            this.f21641c.m25001e(this);
            this.f21642d = true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f21641c.m25003g(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f21642d) {
                this.f21642d = false;
            } else {
                this.f21641c = ErrorDialogManager.f21627a.f21662a.m25087b();
                this.f21641c.m25001e(this);
            }
        }

        /* renamed from: a */
        public static void m25067a(Activity activity, Object obj, boolean z, Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag(ErrorDialogManager.f21629c);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, ErrorDialogManager.f21629c).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.f21639a = z;
            supportManagerFragment.f21640b = bundle;
            supportManagerFragment.f21643e = obj;
        }
    }

    /* renamed from: a */
    protected static void m25061a(C6074f c6074f) {
        C6070b c6070b = f21627a.f21662a;
        if (c6070b.f21658f) {
            if (c6070b.f21659g == null) {
                String str = C6049c.f21526s;
            }
            Throwable th = c6074f.f21664a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m25064b(Object obj, C6074f c6074f) {
        Object mo25095a;
        return c6074f == null || (mo25095a = c6074f.mo25095a()) == null || mo25095a.equals(obj);
    }
}
