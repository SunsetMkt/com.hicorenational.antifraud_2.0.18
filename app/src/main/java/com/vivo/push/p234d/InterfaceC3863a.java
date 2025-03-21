package com.vivo.push.p234d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import java.util.List;

/* compiled from: ISyncProfileInfo.java */
/* renamed from: com.vivo.push.d.a */
/* loaded from: classes2.dex */
public interface InterfaceC3863a {
    void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback);
}
