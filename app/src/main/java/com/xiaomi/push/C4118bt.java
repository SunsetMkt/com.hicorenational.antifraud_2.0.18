package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.C4121bw;

/* renamed from: com.xiaomi.push.bt */
/* loaded from: classes2.dex */
public class C4118bt extends C4121bw.e {

    /* renamed from: a */
    private String f14661a;

    public C4118bt(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f14661a = "MessageInsertJob";
        this.f14661a = str2;
    }

    /* renamed from: a */
    public static C4118bt m13953a(Context context, String str, C4243gj c4243gj) {
        byte[] m15567a = C4276hp.m15567a(c4243gj);
        if (m15567a == null || m15567a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", c4243gj.m15001d());
        contentValues.put("messageItem", m15567a);
        contentValues.put("appId", C4112bn.m13932a(context).m13944b());
        contentValues.put(Constants.KEY_PACKAGE_NAME, C4112bn.m13932a(context).m13939a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new C4118bt(str, contentValues, "a job build to insert message to db");
    }
}
