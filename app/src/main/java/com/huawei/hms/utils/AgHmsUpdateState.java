package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class AgHmsUpdateState {

    /* renamed from: c */
    private static final Object f7918c = new Object();

    /* renamed from: d */
    private static volatile AgHmsUpdateState f7919d;

    /* renamed from: a */
    private HmsCheckedState f7920a = HmsCheckedState.UNCHECKED;

    /* renamed from: b */
    private int f7921b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f7919d == null) {
            synchronized (f7918c) {
                if (f7919d == null) {
                    f7919d = new AgHmsUpdateState();
                }
            }
        }
        return f7919d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f7920a;
    }

    public int getTargetVersionCode() {
        return this.f7921b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f7921b != 0;
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
            HMSLog.m7715e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f7920a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i2) {
        this.f7921b = i2;
    }
}
