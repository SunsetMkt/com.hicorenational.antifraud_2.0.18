package com.vivo.push;

import android.content.Intent;
import com.vivo.push.p237f.AbstractC3882aa;

/* loaded from: classes2.dex */
public interface IPushClientFactory {
    AbstractC3882aa createReceiveTask(AbstractC4016v abstractC4016v);

    AbstractC4016v createReceiverCommand(Intent intent);

    AbstractRunnableC3971s createTask(AbstractC4016v abstractC4016v);
}
