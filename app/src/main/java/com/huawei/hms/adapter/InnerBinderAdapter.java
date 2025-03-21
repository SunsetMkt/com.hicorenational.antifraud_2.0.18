package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import p388ui.activity.BaseProgressUploadActivity;

/* loaded from: classes.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j */
    private static final Object f7078j = new Object();

    /* renamed from: k */
    private static BinderAdapter f7079k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.m7717i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f7078j) {
            if (f7079k == null) {
                f7079k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f7079k;
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
