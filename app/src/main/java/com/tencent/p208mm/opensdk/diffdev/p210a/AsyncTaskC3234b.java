package com.tencent.p208mm.opensdk.diffdev.p210a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.tencent.p208mm.opensdk.channel.p209a.C3232a;
import com.tencent.p208mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p208mm.opensdk.diffdev.OAuthListener;
import com.tencent.p208mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: classes2.dex */
public class AsyncTaskC3234b extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f11062a;

    /* renamed from: b */
    private String f11063b;

    /* renamed from: c */
    private String f11064c;

    /* renamed from: d */
    private String f11065d;

    /* renamed from: e */
    private String f11066e;

    /* renamed from: f */
    private OAuthListener f11067f;

    /* renamed from: g */
    private AsyncTaskC3235c f11068g;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.b$a */
    static class a {

        /* renamed from: a */
        public OAuthErrCode f11069a;

        /* renamed from: b */
        public String f11070b;

        /* renamed from: c */
        public String f11071c;

        /* renamed from: d */
        public String f11072d;

        /* renamed from: e */
        public byte[] f11073e;

        private a() {
        }

        /* renamed from: a */
        public static a m10356a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.m10364e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i2 = jSONObject.getInt("errcode");
                        if (i2 != 0) {
                            Log.m10364e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                            aVar.f11069a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                aVar.f11069a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f11073e = decode;
                                aVar.f11070b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                aVar.f11071c = string2;
                                Log.m10363d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f11070b, string2, Integer.valueOf(aVar.f11073e.length)));
                                return aVar;
                            }
                            Log.m10364e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.f11069a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        Log.m10364e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.f11069a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e2) {
                        format = String.format("parse json fail, ex = %s", e2.getMessage());
                        Log.m10364e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f11069a = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e3) {
                    format = String.format("parse fail, build String fail, ex = %s", e3.getMessage());
                }
            }
            aVar.f11069a = oAuthErrCode;
            return aVar;
        }
    }

    public AsyncTaskC3234b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f11062a = str;
        this.f11063b = str2;
        this.f11064c = str3;
        this.f11065d = str4;
        this.f11066e = str5;
        this.f11067f = oAuthListener;
    }

    /* renamed from: a */
    public boolean m10355a() {
        Log.m10365i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC3235c asyncTaskC3235c = this.f11068g;
        return asyncTaskC3235c == null ? cancel(true) : asyncTaskC3235c.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.m10365i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f11062a, this.f11064c, this.f11065d, this.f11063b, this.f11066e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] m10350a = C3232a.m10350a(format, 60000);
        Log.m10363d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.m10356a(m10350a);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f11069a;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.m10364e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f11067f.onAuthFinish(aVar2.f11069a, null);
            return;
        }
        Log.m10363d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f11073e.length);
        this.f11067f.onAuthGotQrcode(aVar2.f11072d, aVar2.f11073e);
        AsyncTaskC3235c asyncTaskC3235c = new AsyncTaskC3235c(aVar2.f11070b, this.f11067f);
        this.f11068g = asyncTaskC3235c;
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTaskC3235c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            asyncTaskC3235c.execute(new Void[0]);
        }
    }
}
