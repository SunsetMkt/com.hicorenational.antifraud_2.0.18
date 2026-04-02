package com.alibaba.sdk.android.beacon;

import com.alibaba.sdk.android.beacon.Beacon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private final List<Beacon.Config> a = new ArrayList();

    b(Beacon beacon) {
    }

    List<Beacon.Config> a() {
        return Collections.unmodifiableList(this.a);
    }
}
