package com.sina.weibo.sdk.web.p196b;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;

/* renamed from: com.sina.weibo.sdk.web.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2957b {

    /* renamed from: Z */
    protected Context f9359Z;

    /* renamed from: aC */
    protected WebData f9360aC;

    /* renamed from: aD */
    protected String f9361aD;

    /* renamed from: com.sina.weibo.sdk.web.b.b$a */
    public interface a {
        void onComplete();

        void onError(String str);
    }

    protected AbstractC2957b() {
    }

    /* renamed from: a */
    protected abstract void mo8901a(Bundle bundle);

    /* renamed from: a */
    public void mo8903a(a aVar) {
    }

    /* renamed from: b */
    protected abstract void mo8902b(Bundle bundle);

    public abstract String getUrl();

    public final void readFromBundle(Bundle bundle) {
        this.f9360aC = (WebData) bundle.getParcelable("web_data");
        this.f9361aD = bundle.getString("_weibo_transaction");
        mo8902b(bundle);
    }

    public final void setContext(Context context) {
        this.f9359Z = context;
    }

    /* renamed from: t */
    public boolean mo8904t() {
        return false;
    }

    /* renamed from: u */
    public final WebData m8905u() {
        return this.f9360aC;
    }

    public final Bundle writeToBundle(Bundle bundle) {
        bundle.putParcelable("web_data", this.f9360aC);
        int type = this.f9360aC.getType();
        if (type == 1) {
            bundle.putInt("web_type", 1);
        } else if (type == 2) {
            bundle.putInt("web_type", 2);
        } else if (type == 3) {
            bundle.putInt("web_type", 3);
        }
        bundle.putString("_weibo_transaction", this.f9361aD);
        mo8901a(bundle);
        return bundle;
    }

    public AbstractC2957b(AuthInfo authInfo, int i2, String str, String str2) {
        this.f9360aC = new WebData(authInfo, i2, str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f9361aD = sb.toString();
    }
}
