package com.heytap.msp.push.notification;

import android.app.Notification;
import java.util.List;

/* loaded from: classes.dex */
public interface ISortListener {
    void buildCompleted(boolean z, Notification.Builder builder, List<String> list);
}
