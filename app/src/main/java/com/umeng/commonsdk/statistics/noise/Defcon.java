package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.InterfaceC3516d;

/* loaded from: classes2.dex */
public class Defcon implements InterfaceC3516d {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static final long MILLIS_24_HOURS = 86400000;
    private static final long MILLIS_4_HOURS = 14400000;
    private static final long MILLIS_8_HOURS = 28800000;
    private static Defcon instanse;
    private int mLevel = 0;

    private Defcon() {
    }

    public static synchronized Defcon getService(Context context) {
        Defcon defcon;
        synchronized (Defcon.class) {
            if (instanse == null) {
                instanse = new Defcon();
                instanse.setLevel(Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue());
            }
            defcon = instanse;
        }
        return defcon;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public long getReqInterval() {
        int i2 = this.mLevel;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? 0L : 86400000L : MILLIS_8_HOURS : MILLIS_4_HOURS;
    }

    public long getRetryInterval() {
        return this.mLevel == 0 ? 0L : 300000L;
    }

    public boolean isOpen() {
        return this.mLevel != 0;
    }

    @Override // com.umeng.commonsdk.statistics.internal.InterfaceC3516d
    public void onImprintChanged(ImprintHandler.C3500a c3500a) {
        setLevel(Integer.valueOf(c3500a.m11842a("defcon", String.valueOf(0))).intValue());
    }

    public void setLevel(int i2) {
        if (i2 < 0 || i2 > 3) {
            return;
        }
        this.mLevel = i2;
    }
}
