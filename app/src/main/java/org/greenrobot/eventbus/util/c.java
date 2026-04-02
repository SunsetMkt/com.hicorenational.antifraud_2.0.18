package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

/* JADX INFO: compiled from: ErrorDialogFragmentFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> {
    protected final org.greenrobot.eventbus.util.b a;

    /* JADX INFO: compiled from: ErrorDialogFragmentFactory.java */
    @TargetApi(11)
    public static class a extends c<Fragment> {
        public a(org.greenrobot.eventbus.util.b bVar) {
            super(bVar);
        }

        @Override // org.greenrobot.eventbus.util.c
        public Fragment a(f fVar, Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }

    /* JADX INFO: compiled from: ErrorDialogFragmentFactory.java */
    public static class b extends c<androidx.fragment.app.Fragment> {
        public b(org.greenrobot.eventbus.util.b bVar) {
            super(bVar);
        }

        @Override // org.greenrobot.eventbus.util.c
        public androidx.fragment.app.Fragment a(f fVar, Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    protected c(org.greenrobot.eventbus.util.b bVar) {
        this.a = bVar;
    }

    protected abstract T a(f fVar, Bundle bundle);

    protected T a(f fVar, boolean z, Bundle bundle) {
        int i2;
        Class<?> cls;
        if (fVar.c()) {
            return null;
        }
        Bundle bundle2 = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle2.containsKey(ErrorDialogManager.f12969d)) {
            bundle2.putString(ErrorDialogManager.f12969d, c(fVar, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f12970e)) {
            bundle2.putString(ErrorDialogManager.f12970e, b(fVar, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f12971f)) {
            bundle2.putBoolean(ErrorDialogManager.f12971f, z);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f12973h) && (cls = this.a.f12994i) != null) {
            bundle2.putSerializable(ErrorDialogManager.f12973h, cls);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f12972g) && (i2 = this.a.f12993h) != 0) {
            bundle2.putInt(ErrorDialogManager.f12972g, i2);
        }
        return a(fVar, bundle2);
    }

    protected String b(f fVar, Bundle bundle) {
        return this.a.a.getString(this.a.a(fVar.a));
    }

    protected String c(f fVar, Bundle bundle) {
        org.greenrobot.eventbus.util.b bVar = this.a;
        return bVar.a.getString(bVar.f12987b);
    }
}
