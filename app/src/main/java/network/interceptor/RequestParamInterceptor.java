package network.interceptor;

import android.text.TextUtils;
import com.google.gson.C2051e;
import com.hihonor.honorid.core.data.UserInfo;
import interfaces.IOneClickListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import manager.AccountManager;
import network.APICode;
import network.Api;
import network.FileRequestBody;
import network.http.RegionConfigHttp;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
import p245d.C4441b;
import p245d.C4443d;
import p388ui.Hicore;
import p388ui.presenter.JNIHandStamp;
import receiver.C6088e;
import util.C7301n1;
import util.C7328v1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class RequestParamInterceptor implements Interceptor {
    /* renamed from: a */
    static /* synthetic */ void m24921a(Request.Builder builder) {
        builder.header("deviceid", JNIHandStamp.getInstance().getUUID());
        builder.header("identity", JNIHandStamp.identity + "");
        builder.header("seqid", JNIHandStamp.getInstance().getSeqid());
    }

    private static String encodeHead(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String getDecodeParam(Request request) throws IOException {
        RequestBody body = request.body();
        if (body != null && !(body instanceof FormBody) && !(body instanceof MultipartBody) && !(body instanceof FileRequestBody) && body.contentLength() > 0) {
            try {
                String optString = new JSONObject(getParamContent(body)).optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    return JNIHandStamp.jni.paramJsonDecode(optString);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private String getParamContent(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }

    private synchronized Request handleRequest(Request request, String str, int i2) {
        RequestBody body = request.body();
        if (body == null) {
            return request;
        }
        if (infilterRequest(request)) {
            return request;
        }
        if (!(body instanceof FormBody) && !(body instanceof MultipartBody) && !(body instanceof FileRequestBody)) {
            try {
                String m26781g = C7337y1.m26781g(request.url().toString());
                String str2 = Api.getmHost();
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(m26781g, str2)) {
                    JNIHandStamp.getInstance().cleanJNIData();
                    i2 = APICode.CODE_EXPRIE;
                }
                Api.setHost(m26781g);
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                final Request.Builder newBuilder = request.newBuilder();
                if (JNIHandStamp.getInstance().expireFail(false) || i2 == 470) {
                    JNIHandStamp.getInstance().expireFail(true);
                    JNIHandStamp.getInstance().handshareKeySyn(m26781g, new IOneClickListener() { // from class: network.interceptor.a
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            RequestParamInterceptor.m24921a(Request.Builder.this);
                        }
                    });
                }
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("data", JNIHandStamp.jni.paramJsonEncode(str));
                    jSONObject = new JSONObject(hashMap);
                }
                request = newBuilder.method(request.method(), RequestBody.create(body.contentType(), jSONObject.toString())).build();
            } catch (Exception unused) {
                return request;
            }
        }
        return request;
    }

    private Response handleResponse(Interceptor.Chain chain, Request request, String str) throws IOException {
        Response proceed = chain.proceed(request);
        C7301n1.m26457b("RetrofitLog", "<-- " + proceed.code() + "  " + new C2051e().m5572a(request.newBuilder()) + C4443d.f16920D);
        return proceed.code() == 470 ? chain.proceed(handleRequest(request, str, APICode.CODE_EXPRIE)) : proceed;
    }

    private boolean infilterRequest(Request request) {
        String httpUrl = request.url().toString();
        return httpUrl.contains("getalldictionaryv2") || httpUrl.contains("handshark") || httpUrl.contains("oss-test.gjfzpt.cn") || httpUrl.contains("oss.gjfzpt.cn");
    }

    private void setHeader(Request.Builder builder) {
        if (builder == null) {
            return;
        }
        builder.addHeader("deviceid", JNIHandStamp.getInstance().getUUID());
        builder.addHeader("identity", JNIHandStamp.identity + "");
        builder.addHeader("seqid", JNIHandStamp.getInstance().getSeqid());
        if (JNIHandStamp.getInstance().isNeedDelay()) {
            builder.addHeader("delay", "1");
        } else {
            builder.addHeader("delay", "0");
        }
        builder.addHeader("os-version", C7328v1.m26668i());
        builder.addHeader("os-type", "0");
        builder.addHeader("os-brand", C7328v1.m26650b());
        builder.addHeader("os-model", C7328v1.m26672k());
        builder.addHeader("market", Hicore.getApp().getChannel());
        builder.addHeader("app-version", C7328v1.m26678o());
        builder.addHeader("app-version-code", C7328v1.m26677n() + "");
        builder.addHeader("api-version", "175");
        builder.addHeader("UM-deviceToken", C6088e.f21713a + "");
        builder.addHeader("nodeid", RegionConfigHttp.getNodeRegionId());
        builder.addHeader("nodeCode", RegionConfigHttp.getNodeRegionId());
        builder.addHeader("longitude", "0");
        builder.addHeader("latitude", "0");
        builder.addHeader(UserInfo.ADDRESS, "");
        builder.addHeader("Authorization", AccountManager.getAccountToken());
        builder.addHeader("policeToken", C4441b.m16415c());
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        setHeader(newBuilder);
        if (request.body() instanceof FormBody) {
            FormBody.Builder builder = new FormBody.Builder();
            FormBody formBody = (FormBody) request.body();
            for (int i2 = 0; i2 < formBody.size(); i2++) {
                builder.addEncoded(formBody.encodedName(i2), formBody.encodedValue(i2));
            }
            newBuilder.method(request.method(), builder.build());
        }
        Request build = newBuilder.build();
        String decodeParam = getDecodeParam(build);
        return handleResponse(chain, handleRequest(build, decodeParam, 0), decodeParam);
    }
}
