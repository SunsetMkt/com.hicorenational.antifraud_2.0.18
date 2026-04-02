package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class c extends AsyncTask<Void, Void, a> {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OAuthListener f6754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6755d;

    static class a {
        public OAuthErrCode a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6757c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.f6754c = oAuthListener;
        this.f6753b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:20:0x008d, B:22:0x009c, B:26:0x00b5, B:28:0x00b9, B:29:0x00c6, B:33:0x00d1, B:30:0x00c9, B:31:0x00cc, B:32:0x00cf), top: B:63:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a doInBackground(Void[] voidArr) throws Throwable {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        String str2;
        JSONObject jSONObject;
        int i2;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str3 = this.a;
        if (str3 != null && str3.length() != 0) {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6753b);
                if (this.f6755d == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f6755d;
                }
                sb.append(str);
                String string = sb.toString();
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArrA = com.tencent.mm.opensdk.channel.a.a.a(string, 60000);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (bArrA != null && bArrA.length != 0) {
                    try {
                    } catch (Exception e2) {
                        str2 = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    }
                    try {
                        jSONObject = new JSONObject(new String(bArrA, "utf-8"));
                        int i3 = jSONObject.getInt("wx_errcode");
                        aVar.f6757c = i3;
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i3)));
                        i2 = aVar.f6757c;
                    } catch (Exception e3) {
                        str2 = String.format("parse json fail, ex = %s", e3.getMessage());
                        Log.e("MicroMsg.SDK.NoopingResult", str2);
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode2;
                    }
                    if (i2 == 408) {
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                        aVar.a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.a.toString(), Integer.valueOf(aVar.f6757c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                            int i4 = aVar.f6757c;
                            this.f6755d = i4;
                            if (i4 == d.UUID_SCANED.a()) {
                                this.f6754c.onQrcodeScanned();
                            } else if (aVar.f6757c != d.UUID_KEEP_CONNECT.a() && aVar.f6757c == d.UUID_CONFIRM.a()) {
                                String str4 = aVar.f6756b;
                                if (str4 == null || str4.length() == 0) {
                                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                }
                            }
                        } else {
                            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.f6757c)));
                        }
                    } else if (i2 != 500) {
                        switch (i2) {
                            case 402:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                aVar.a = oAuthErrCode4;
                                break;
                            case 403:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                aVar.a = oAuthErrCode4;
                                break;
                            case TinkerReport.KEY_LOADED_SUCC_COST_OTHER /* 404 */:
                                break;
                            case 405:
                                aVar.a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f6756b = jSONObject.getString("wx_code");
                                break;
                            default:
                                oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar.a = oAuthErrCode4;
                                break;
                        }
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.a.toString(), Integer.valueOf(aVar.f6757c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                        }
                    } else {
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.a.toString(), Integer.valueOf(aVar.f6757c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                        oAuthErrCode3 = aVar.a;
                        if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                        }
                    }
                    return aVar;
                }
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.a = oAuthErrCode2;
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVar.a.toString(), Integer.valueOf(aVar.f6757c), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                oAuthErrCode3 = aVar.a;
                if (oAuthErrCode3 != OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.a = oAuthErrCode;
            return aVar;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f6754c.onAuthFinish(aVar2.a, aVar2.f6756b);
    }
}
