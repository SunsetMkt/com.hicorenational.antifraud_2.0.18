package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.core.p169a.C2264b;

/* loaded from: classes.dex */
public abstract class AGConnectInstance {
    public static AGConnectInstance buildInstance(AGConnectOptions aGConnectOptions) {
        return C2264b.m6451a(aGConnectOptions);
    }

    public static AGConnectInstance getInstance() {
        return C2264b.m6450a();
    }

    public static AGConnectInstance getInstance(String str) {
        return C2264b.m6453a(str);
    }

    public static void initialize(Context context) {
        C2264b.m6454a(context);
    }

    public static void initialize(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        C2264b.m6456a(context, aGConnectOptionsBuilder);
    }

    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> cls);
}
