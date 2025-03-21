package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.hms.push.C2269R;
import com.huawei.hms.push.C2500t;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2269R.layout.hwpush_trans_activity);
        getWindow().addFlags(AbstractC1191a.f2487B1);
        C2500t.m7636a(this, getIntent());
        finish();
    }
}
