package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

/* compiled from: ErrorDialogFragmentFactory.java */
/* renamed from: org.greenrobot.eventbus.util.c */
/* loaded from: classes2.dex */
public abstract class AbstractC6071c<T> {

    /* renamed from: a */
    protected final C6070b f21662a;

    /* compiled from: ErrorDialogFragmentFactory.java */
    @TargetApi(11)
    /* renamed from: org.greenrobot.eventbus.util.c$a */
    public static class a extends AbstractC6071c<Fragment> {
        public a(C6070b c6070b) {
            super(c6070b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.AbstractC6071c
        /* renamed from: a */
        public Fragment mo25088a(C6074f c6074f, Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }

    /* compiled from: ErrorDialogFragmentFactory.java */
    /* renamed from: org.greenrobot.eventbus.util.c$b */
    public static class b extends AbstractC6071c<androidx.fragment.app.Fragment> {
        public b(C6070b c6070b) {
            super(c6070b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.AbstractC6071c
        /* renamed from: a */
        public androidx.fragment.app.Fragment mo25088a(C6074f c6074f, Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    protected AbstractC6071c(C6070b c6070b) {
        this.f21662a = c6070b;
    }

    /* renamed from: a */
    protected abstract T mo25088a(C6074f c6074f, Bundle bundle);

    /* renamed from: a */
    protected T m25089a(C6074f c6074f, boolean z, Bundle bundle) {
        int i2;
        Class<?> cls;
        if (c6074f.m25098c()) {
            return null;
        }
        Bundle bundle2 = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle2.containsKey(ErrorDialogManager.f21630d)) {
            bundle2.putString(ErrorDialogManager.f21630d, m25091c(c6074f, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f21631e)) {
            bundle2.putString(ErrorDialogManager.f21631e, m25090b(c6074f, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f21632f)) {
            bundle2.putBoolean(ErrorDialogManager.f21632f, z);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f21634h) && (cls = this.f21662a.f21661i) != null) {
            bundle2.putSerializable(ErrorDialogManager.f21634h, cls);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f21633g) && (i2 = this.f21662a.f21660h) != 0) {
            bundle2.putInt(ErrorDialogManager.f21633g, i2);
        }
        return mo25088a(c6074f, bundle2);
    }

    /* renamed from: b */
    protected String m25090b(C6074f c6074f, Bundle bundle) {
        return this.f21662a.f21653a.getString(this.f21662a.m25080a(c6074f.f21664a));
    }

    /* renamed from: c */
    protected String m25091c(C6074f c6074f, Bundle bundle) {
        C6070b c6070b = this.f21662a;
        return c6070b.f21653a.getString(c6070b.f21654b);
    }
}
