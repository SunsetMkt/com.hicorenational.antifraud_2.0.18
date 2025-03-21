package com.airbnb.lottie.p110z;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultLottieNetworkFetcher.java */
/* renamed from: com.airbnb.lottie.z.b */
/* loaded from: classes.dex */
public class C1487b implements InterfaceC1491f {
    @Override // com.airbnb.lottie.p110z.InterfaceC1491f
    @NonNull
    /* renamed from: a */
    public InterfaceC1489d mo3399a(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new C1486a(httpURLConnection);
    }
}
