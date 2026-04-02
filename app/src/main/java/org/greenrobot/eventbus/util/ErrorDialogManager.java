package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorDialogManager {
    public static c<?> a = null;

    /* JADX INFO: renamed from: b */
    protected static final String f12967b = "de.greenrobot.eventbus.error_dialog";

    /* JADX INFO: renamed from: c */
    protected static final String f12968c = "de.greenrobot.eventbus.error_dialog_manager";

    /* JADX INFO: renamed from: d */
    public static final String f12969d = "de.greenrobot.eventbus.errordialog.title";

    /* JADX INFO: renamed from: e */
    public static final String f12970e = "de.greenrobot.eventbus.errordialog.message";

    /* JADX INFO: renamed from: f */
    public static final String f12971f = "de.greenrobot.eventbus.errordialog.finish_after_dialog";

    /* JADX INFO: renamed from: g */
    public static final String f12972g = "de.greenrobot.eventbus.errordialog.icon_id";

    /* JADX INFO: renamed from: h */
    public static final String f12973h = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    private static boolean b(Activity activity) {
        String name;
        Class<?> superclass = activity.getClass();
        do {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = superclass.getName();
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

    public static void a(Activity activity) {
        a(activity, false, null);
    }

    public static void a(Activity activity, boolean z) {
        a(activity, z, null);
    }

    public static void a(Activity activity, boolean z, Bundle bundle) {
        a(activity, activity.getClass(), z, bundle);
    }

    public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (a != null) {
            if (b(activity)) {
                SupportManagerFragment.a(activity, obj, z, bundle);
                return;
            } else {
                HoneycombManagerFragment.a(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {
        protected boolean a;

        /* JADX INFO: renamed from: b */
        protected Bundle f12974b;

        /* JADX INFO: renamed from: c */
        private org.greenrobot.eventbus.c f12975c;

        /* JADX INFO: renamed from: d */
        private Object f12976d;

        public void a(f fVar) {
            if (ErrorDialogManager.b(this.f12976d, fVar)) {
                ErrorDialogManager.a(fVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f12967b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.a.a(fVar, this.a, this.f12974b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f12967b);
                }
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f12975c.g(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.f12975c = ErrorDialogManager.a.a.b();
            this.f12975c.e(this);
        }

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f12968c);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, ErrorDialogManager.f12968c).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.a = z;
            honeycombManagerFragment.f12974b = bundle;
            honeycombManagerFragment.f12976d = obj;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        protected boolean a;

        /* JADX INFO: renamed from: b */
        protected Bundle f12977b;

        /* JADX INFO: renamed from: c */
        private org.greenrobot.eventbus.c f12978c;

        /* JADX INFO: renamed from: d */
        private boolean f12979d;

        /* JADX INFO: renamed from: e */
        private Object f12980e;

        public void a(f fVar) {
            if (ErrorDialogManager.b(this.f12980e, fVar)) {
                ErrorDialogManager.a(fVar);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f12967b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                androidx.fragment.app.DialogFragment dialogFragment2 = (androidx.fragment.app.DialogFragment) ErrorDialogManager.a.a(fVar, this.a, this.f12977b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f12967b);
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f12978c = ErrorDialogManager.a.a.b();
            this.f12978c.e(this);
            this.f12979d = true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f12978c.g(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f12979d) {
                this.f12979d = false;
            } else {
                this.f12978c = ErrorDialogManager.a.a.b();
                this.f12978c.e(this);
            }
        }

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag(ErrorDialogManager.f12968c);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, ErrorDialogManager.f12968c).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.a = z;
            supportManagerFragment.f12977b = bundle;
            supportManagerFragment.f12980e = obj;
        }
    }

    protected static void a(f fVar) {
        b bVar = a.a;
        if (bVar.f12991f) {
            if (bVar.f12992g == null) {
                String str = org.greenrobot.eventbus.c.s;
            }
            Throwable th = fVar.a;
        }
    }

    public static boolean b(Object obj, f fVar) {
        Object objA;
        return fVar == null || (objA = fVar.a()) == null || objA.equals(obj);
    }
}
