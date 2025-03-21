package com.sina.weibo.sdk.web.p196b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.InterfaceC2932c;
import com.sina.weibo.sdk.p193a.C2908b;
import com.sina.weibo.sdk.p193a.C2910d;
import com.sina.weibo.sdk.p194b.C2925c;
import com.sina.weibo.sdk.p194b.C2927e;
import com.sina.weibo.sdk.web.p196b.AbstractC2957b;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.sina.weibo.sdk.web.b.d */
/* loaded from: classes.dex */
public final class C2959d extends AbstractC2957b {

    /* renamed from: aE */
    public WeiboMultiMessage f9362aE;

    /* renamed from: aF */
    private byte[] f9363aF;

    /* renamed from: aG */
    String f9364aG;

    /* renamed from: ae */
    public String f9365ae;
    public String packageName;
    private String text;

    public C2959d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b
    /* renamed from: a */
    protected final void mo8901a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.f9362aE;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.f9365ae);
        bundle.putString(Constants.KEY_PACKAGE_NAME, this.packageName);
    }

    @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b
    /* renamed from: b */
    protected final void mo8902b(Bundle bundle) {
        byte[] bArr;
        this.f9362aE = new WeiboMultiMessage();
        this.f9362aE.readFromBundle(bundle);
        this.f9365ae = bundle.getString("token");
        this.packageName = bundle.getString(Constants.KEY_PACKAGE_NAME);
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.f9362aE.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        ImageObject imageObject = this.f9362aE.imageObject;
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
                                this.f9363aF = C2927e.m8843b(bArr2);
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
                                    this.f9363aF = C2927e.m8843b(bArr);
                                }
                                this.text = sb.toString();
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
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.f9363aF = C2927e.m8843b(bArr);
            }
        }
        this.text = sb.toString();
    }

    @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b
    public final String getUrl() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.text);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.f9360aC.m8891a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.f9365ae)) {
            buildUpon.appendQueryParameter("access_token", this.f9365ae);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.f9364aG)) {
            buildUpon.appendQueryParameter("picinfo", this.f9364aG);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_".concat(String.valueOf(appKey)));
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b
    /* renamed from: t */
    public final boolean mo8904t() {
        byte[] bArr = this.f9363aF;
        if (bArr == null || bArr.length <= 0) {
            return super.mo8904t();
        }
        return true;
    }

    public C2959d(Context context) {
        this.f9359Z = context;
    }

    @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b
    /* renamed from: a */
    public final void mo8903a(final AbstractC2957b.a aVar) {
        C2908b c2908b;
        C2910d c2910d = new C2910d(this.f9359Z, new String(this.f9363aF), this.f9360aC.m8891a().getAppKey(), this.f9365ae, new InterfaceC2932c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            @Override // com.sina.weibo.sdk.net.InterfaceC2932c
            /* renamed from: a */
            public final /* synthetic */ void mo8814a(String str) {
                String str2 = str;
                C2925c.m8837a("WbShareTag", "handle image result :".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    AbstractC2957b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onError("处理图片，服务端返回null!");
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("code");
                    String optString = jSONObject.optString("data");
                    if (optInt != 1 || TextUtils.isEmpty(optString)) {
                        if (aVar != null) {
                            aVar.onError("图片内容不合适，禁止上传！");
                        }
                    } else {
                        C2959d.this.f9364aG = optString;
                        if (aVar != null) {
                            aVar.onComplete();
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    AbstractC2957b.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.onError("解析服务端返回的字符串时发生异常！");
                    }
                }
            }

            @Override // com.sina.weibo.sdk.net.InterfaceC2932c
            public final void onError(Throwable th) {
                AbstractC2957b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(th.getMessage());
                }
            }
        });
        c2908b = C2908b.a.f9268K;
        c2908b.m8806a(c2910d);
    }
}
