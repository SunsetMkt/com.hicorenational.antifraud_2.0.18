package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import ui.activity.BaseProgressUploadActivity;

/* JADX INFO: loaded from: classes.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f4440j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BinderAdapter f4441k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f4440j) {
            if (f4441k == null) {
                f4441k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f4441k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
    }
}
