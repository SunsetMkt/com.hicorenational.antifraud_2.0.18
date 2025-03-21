package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.C3202a;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SocialApi {

    /* renamed from: a */
    private SocialApiIml f11097a;

    public SocialApi(QQToken qQToken) {
        this.f11097a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C3202a.m10152a("SocialApi", iUiListener)) {
            return;
        }
        this.f11097a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C3202a.m10152a("SocialApi", iUiListener)) {
            return;
        }
        this.f11097a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C3202a.m10152a("SocialApi", iUiListener)) {
            return;
        }
        this.f11097a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C3202a.m10152a("SocialApi", iUiListener)) {
            return;
        }
        this.f11097a.story(activity, bundle, iUiListener);
    }
}
