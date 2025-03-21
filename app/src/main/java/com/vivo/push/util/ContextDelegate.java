package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext = null;
    private static Method mCreateCredentialProtectedStorageContext = null;
    private static Method mCreateDeviceProtectedStorageContext = null;
    private static boolean mDelegateEnable = false;
    private static Boolean mIsFbeProject;

    /* renamed from: com.vivo.push.util.ContextDelegate$a */
    private static class C3982a {

        /* renamed from: a */
        private static ContextDelegate f14210a = new ContextDelegate();
    }

    private static Context createCredentialProtectedStorageContext(Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return context;
        }
    }

    private static Context createDeviceProtectedStorageContext(Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return context;
        }
    }

    public static Context getContext(Context context) {
        if (!isFBEProject() || context == null) {
            return context;
        }
        Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    public static ContextDelegate getInstance() {
        return C3982a.f14210a;
    }

    public static boolean isFBEProject() {
        if (mIsFbeProject == null) {
            try {
                mIsFbeProject = Boolean.valueOf("file".equals(C4003n.m13267a("ro.crypto.type", "unknow")));
                C4010u.m13301b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (Exception e2) {
                C4010u.m13292a(TAG, "mIsFbeProject = " + e2.getMessage());
            }
        }
        Boolean bool = mIsFbeProject;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        if (mDelegateEnable) {
            mContext = createDeviceProtectedStorageContext(context);
        } else {
            mContext = createCredentialProtectedStorageContext(context);
        }
    }

    public static void setEnable(boolean z) {
        mDelegateEnable = z;
        setAppContext();
    }
}
