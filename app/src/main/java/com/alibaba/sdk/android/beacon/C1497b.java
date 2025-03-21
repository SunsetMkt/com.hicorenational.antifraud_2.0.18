package com.alibaba.sdk.android.beacon;

import com.alibaba.sdk.android.beacon.Beacon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.alibaba.sdk.android.beacon.b */
/* loaded from: classes.dex */
final class C1497b {

    /* renamed from: a */
    private final List<Beacon.Config> f3836a = new ArrayList();

    C1497b(Beacon beacon) {
    }

    /* renamed from: a */
    List<Beacon.Config> m3413a() {
        return Collections.unmodifiableList(this.f3836a);
    }
}
