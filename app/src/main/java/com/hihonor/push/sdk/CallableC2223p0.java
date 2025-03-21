package com.hihonor.push.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.hihonor.push.sdk.p0 */
/* loaded from: classes.dex */
public class CallableC2223p0 implements Callable<List<HonorPushDataMsg>> {

    /* renamed from: a */
    public final Context f6815a;

    public CallableC2223p0(Context context) {
        this.f6815a = context;
    }

    @Override // java.util.concurrent.Callable
    public List<HonorPushDataMsg> call() throws Exception {
        ArrayList<ContentValues> parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARAM_PKG_NAME, this.f6815a.getPackageName());
        Bundle call = this.f6815a.getContentResolver().call(Uri.parse("content://com.hihonor.android.pushagent.provider.MessageBoxProvider/"), "query_unread_msg", "", bundle);
        ArrayList arrayList = new ArrayList();
        if (call != null && (parcelableArrayList = call.getParcelableArrayList("messages")) != null) {
            for (ContentValues contentValues : parcelableArrayList) {
                JSONObject jSONObject = new JSONObject();
                for (String str : contentValues.keySet()) {
                    jSONObject.put(str, contentValues.get(str));
                }
                HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
                honorPushDataMsg.setData(jSONObject.toString());
                honorPushDataMsg.setType(1);
                arrayList.add(honorPushDataMsg);
            }
        }
        return arrayList;
    }
}
