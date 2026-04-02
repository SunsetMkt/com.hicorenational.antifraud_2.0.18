package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class AgHmsUpdateState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4973c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AgHmsUpdateState f4974d;
    private HmsCheckedState a = HmsCheckedState.UNCHECKED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4975b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f4974d == null) {
            synchronized (f4973c) {
                if (f4974d == null) {
                    f4974d = new AgHmsUpdateState();
                }
            }
        }
        return f4974d;
    }

    public HmsCheckedState getCheckedState() {
        return this.a;
    }

    public int getTargetVersionCode() {
        return this.f4975b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f4975b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i2) {
        this.f4975b = i2;
    }
}
