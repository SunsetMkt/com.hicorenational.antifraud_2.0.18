package network;

import android.text.TextUtils;
import bean.ProgressBean;
import e.d;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import m.m;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.c;
import util.g2;
import util.j1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitFileHelp {
    public static void bean2TextParam(MultipartBody.Builder builder, Object obj) {
        for (Map.Entry<String, Object> entry : g2.a(false, obj).entrySet()) {
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
            j1.a(j1.a(str2, new FileInputStream(file).available()), d.f10176l + str);
            File file2 = new File(d.f10176l + str);
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
            @Override // m.d
            public void onFailure(m.b<String> bVar, Throwable th) {
                s1.a("onFailure RetrofitCallback-->>" + th.getMessage());
            }

            @Override // network.RetrofitCallback
            public void onLoading(long j2, long j3) {
                s1.a("onLoading RetrofitCallback-->>total:" + j2 + "--progress:" + j3);
                c.f().c(new util.n2.a(i2, new ProgressBean(j2, j3)));
            }

            @Override // network.RetrofitCallback
            public void onSuccess(m.b<String> bVar, m<String> mVar) {
                s1.a("onSuccess RetrofitCallback-->>" + mVar.a().toString());
            }
        });
    }
}
