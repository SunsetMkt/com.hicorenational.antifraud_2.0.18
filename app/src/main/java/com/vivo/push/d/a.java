package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import java.util.List;

/* JADX INFO: compiled from: ISyncProfileInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback);
}
