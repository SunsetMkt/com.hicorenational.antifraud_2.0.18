package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.statistics.C3493a;
import com.umeng.commonsdk.statistics.common.C3499d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.InterfaceC3516d;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class ImLatent implements InterfaceC3516d {
    private static ImLatent instanse;
    private Context context;
    private StatTracer statTracer;
    private C3499d storeHelper;
    private final int _DEFAULT_HOURS = 360;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final long _ONE_HOURS_IN_MS = C2084a.f6123e;
    private final long _360HOURS_IN_MS = AbstractC1191a.f2550a;
    private final long _36HOURS_IN_MS = 129600000;
    private final int LATENT_MAX = 1800000;
    private final int LATENT_WINDOW = 10;
    private long latentHour = AbstractC1191a.f2550a;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private Object mLatentLock = new Object();

    private ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = C3499d.m11813a(context);
        this.statTracer = statTracer;
    }

    public static synchronized ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            if (instanse == null) {
                instanse = new ImLatent(context, statTracer);
                instanse.onImprintChanged(ImprintHandler.getImprintService(context).m11839c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j2;
        synchronized (this.mLatentLock) {
            j2 = this.mDelay;
        }
        return j2;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.InterfaceC3516d
    public void onImprintChanged(ImprintHandler.C3500a c3500a) {
        this.latentHour = (Integer.valueOf(c3500a.m11842a("latent_hours", String.valueOf(360))).intValue() > 36 ? r1 : 360) * C2084a.f6123e;
        int intValue = Integer.valueOf(c3500a.m11842a(C3351bh.f11597aV, "0")).intValue();
        if (intValue < 1 || intValue > 1800) {
            intValue = 0;
        }
        if (intValue != 0) {
            this.latentWindow = intValue;
            return;
        }
        int i2 = C3493a.f12714c;
        if (i2 <= 0 || i2 > 1800000) {
            this.latentWindow = 10;
        } else {
            this.latentWindow = i2;
        }
    }

    public boolean shouldStartLatency() {
        if (this.storeHelper.m11820c() || this.statTracer.isFirstRequest()) {
            return false;
        }
        synchronized (this.mLatentLock) {
            if (this.mLatentActivite) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.statTracer.getLastReqTime();
            if (currentTimeMillis > this.latentHour) {
                String signature = Envelope.getSignature(this.context);
                synchronized (this.mLatentLock) {
                    this.mDelay = DataHelper.random(this.latentWindow, signature);
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            }
            if (currentTimeMillis <= 129600000) {
                return false;
            }
            synchronized (this.mLatentLock) {
                this.mDelay = 0L;
                this.mElapsed = currentTimeMillis;
                this.mLatentActivite = true;
            }
            return true;
        }
    }
}
