package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.web.b.b;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    public WeiboMultiMessage aE;
    private byte[] aF;
    String aG;
    public String ae;
    public String packageName;
    private String text;

    /* JADX INFO: renamed from: com.sina.weibo.sdk.web.b.d$1 */
    final class AnonymousClass1 implements com.sina.weibo.sdk.net.c<String> {
        final /* synthetic */ b.a aH;

        AnonymousClass1(b.a aVar) {
            aVar = aVar;
        }

        @Override // com.sina.weibo.sdk.net.c
        public final /* synthetic */ void a(String str) {
            String str2 = str;
            com.sina.weibo.sdk.b.c.a("WbShareTag", "handle image result :".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                b.a aVar = aVar;
                if (aVar != null) {
                    aVar.onError("\u5904\u7406\u56fe\u7247\uff0c\u670d\u52a1\u7aef\u8fd4\u56denull!");
                    return;
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("data");
                if (iOptInt != 1 || TextUtils.isEmpty(strOptString)) {
                    if (aVar != null) {
                        aVar.onError("\u56fe\u7247\u5185\u5bb9\u4e0d\u5408\u9002\uff0c\u7981\u6b62\u4e0a\u4f20\uff01");
                    }
                } else {
                    d.this.aG = strOptString;
                    if (aVar != null) {
                        aVar.onComplete();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError("\u89e3\u6790\u670d\u52a1\u7aef\u8fd4\u56de\u7684\u5b57\u7b26\u4e32\u65f6\u53d1\u751f\u5f02\u5e38\uff01");
                }
            }
        }

        @Override // com.sina.weibo.sdk.net.c
        public final void onError(Throwable th) {
            b.a aVar = aVar;
            if (aVar != null) {
                aVar.onError(th.getMessage());
            }
        }
    }

    public d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.aE;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.ae);
        bundle.putString(Constants.KEY_PACKAGE_NAME, this.packageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0096  */
    @Override // com.sina.weibo.sdk.web.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void b(Bundle bundle) throws Throwable {
        byte[] bArr;
        this.aE = new WeiboMultiMessage();
        this.aE.readFromBundle(bundle);
        this.ae = bundle.getString("token");
        this.packageName = bundle.getString(Constants.KEY_PACKAGE_NAME);
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.aE.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        ImageObject imageObject = this.aE.imageObject;
        if (imageObject != null) {
            String str = imageObject.imagePath;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                fileInputStream2.read(bArr2);
                                this.aF = e.b(bArr2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                bArr = imageObject.imageData;
                                if (bArr != null) {
                                    this.aF = e.b(bArr);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                } else {
                    bArr = imageObject.imageData;
                    if (bArr != null && bArr.length > 0) {
                        this.aF = e.b(bArr);
                    }
                }
            }
        }
        this.text = sb.toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final String getUrl() {
        Uri.Builder builderBuildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        builderBuildUpon.appendQueryParameter("title", this.text);
        builderBuildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.aC.a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            builderBuildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.ae)) {
            builderBuildUpon.appendQueryParameter("access_token", this.ae);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            builderBuildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.aG)) {
            builderBuildUpon.appendQueryParameter("picinfo", this.aG);
        }
        builderBuildUpon.appendQueryParameter("luicode", "10000360");
        builderBuildUpon.appendQueryParameter("lfid", "OP_".concat(String.valueOf(appKey)));
        return builderBuildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final boolean t() {
        byte[] bArr = this.aF;
        if (bArr == null || bArr.length <= 0) {
            return super.t();
        }
        return true;
    }

    public d(Context context) {
        this.Z = context;
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(b.a aVar) {
        b.a.K.a(new com.sina.weibo.sdk.a.d(this.Z, new String(this.aF), this.aC.a().getAppKey(), this.ae, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            final /* synthetic */ b.a aH;

            AnonymousClass1(b.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.sina.weibo.sdk.net.c
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                com.sina.weibo.sdk.b.c.a("WbShareTag", "handle image result :".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onError("\u5904\u7406\u56fe\u7247\uff0c\u670d\u52a1\u7aef\u8fd4\u56denull!");
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int iOptInt = jSONObject.optInt("code");
                    String strOptString = jSONObject.optString("data");
                    if (iOptInt != 1 || TextUtils.isEmpty(strOptString)) {
                        if (aVar != null) {
                            aVar.onError("\u56fe\u7247\u5185\u5bb9\u4e0d\u5408\u9002\uff0c\u7981\u6b62\u4e0a\u4f20\uff01");
                        }
                    } else {
                        d.this.aG = strOptString;
                        if (aVar != null) {
                            aVar.onComplete();
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    b.a aVar22 = aVar;
                    if (aVar22 != null) {
                        aVar22.onError("\u89e3\u6790\u670d\u52a1\u7aef\u8fd4\u56de\u7684\u5b57\u7b26\u4e32\u65f6\u53d1\u751f\u5f02\u5e38\uff01");
                    }
                }
            }

            @Override // com.sina.weibo.sdk.net.c
            public final void onError(Throwable th) {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(th.getMessage());
                }
            }
        }));
    }
}
