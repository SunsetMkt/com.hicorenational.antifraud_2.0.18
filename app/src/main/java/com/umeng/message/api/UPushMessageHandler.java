package com.umeng.message.api;

import android.content.Context;
import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes2.dex */
public interface UPushMessageHandler {
    void handleMessage(Context context, UMessage uMessage);
}
