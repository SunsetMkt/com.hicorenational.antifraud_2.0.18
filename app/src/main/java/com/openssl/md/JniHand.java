package com.openssl.md;

/* JADX INFO: loaded from: classes2.dex */
public class JniHand {
    static {
        System.loadLibrary("crypto");
        System.loadLibrary("md");
    }

    public native String getAppPubKey();

    public native String paramJsonDecode(String str);

    public native String paramJsonEncode(String str);

    public native void setApiPubKey(String str);
}
