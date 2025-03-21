package network;

import android.text.TextUtils;
import bean.ProgressBean;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.C6049c;
import p245d.C4443d;
import p375l.C5884m;
import p375l.InterfaceC5873b;
import util.C7277f1;
import util.C7301n1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class RetrofitFileHelp {
    public static void bean2TextParam(MultipartBody.Builder builder, Object obj) {
        for (Map.Entry<String, Object> entry : C7337y1.m26743a(false, obj).entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue() + "");
        }
    }

    private static FileRequestBody getFileProgress(RequestBody requestBody) {
        return getFileProgress(requestBody, -1);
    }

    public static void setFileParam(MultipartBody.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (TextUtils.isEmpty(str)) {
            str = file.getName();
        }
        try {
            C7277f1.m26348a(C7277f1.m26340a(str2, new FileInputStream(file).available()), C4443d.f16965l + str);
            File file2 = new File(C4443d.f16965l + str);
            if (file.exists()) {
                file = file2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        builder.addFormDataPart("file", str, RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), file));
    }

    public static void setFileParamWithProgress(MultipartBody.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addFormDataPart("file", str, getFileProgress(RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), new File(str2))));
    }

    public static void setTextParam(MultipartBody.Builder builder, String str, String str2) {
        builder.addFormDataPart(str, str2);
    }

    private static FileRequestBody getFileProgress(RequestBody requestBody, final int i2) {
        if (i2 == -1) {
            i2 = 201;
        }
        return new FileRequestBody(requestBody, new RetrofitCallback<String>() { // from class: network.RetrofitFileHelp.1
            @Override // p375l.InterfaceC5875d
            public void onFailure(InterfaceC5873b<String> interfaceC5873b, Throwable th) {
                C7301n1.m26453a("onFailure RetrofitCallback-->>" + th.getMessage());
            }

            @Override // network.RetrofitCallback
            public void onLoading(long j2, long j3) {
                C7301n1.m26453a("onLoading RetrofitCallback-->>total:" + j2 + "--progress:" + j3);
                C6049c.m24987f().m24999c(new C7265a(i2, new ProgressBean(j2, j3)));
            }

            @Override // network.RetrofitCallback
            public void onSuccess(InterfaceC5873b<String> interfaceC5873b, C5884m<String> c5884m) {
                C7301n1.m26453a("onSuccess RetrofitCallback-->>" + c5884m.m24791a().toString());
            }
        });
    }
}
