package com.scwang.smartrefresh.layout.p190c;

/* compiled from: DimensionStatus.java */
/* renamed from: com.scwang.smartrefresh.layout.c.a */
/* loaded from: classes.dex */
public enum EnumC2878a {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);

    public final boolean notified;

    EnumC2878a(boolean z) {
        this.notified = z;
    }

    public boolean canReplaceWith(EnumC2878a enumC2878a) {
        return ordinal() < enumC2878a.ordinal() || ((!this.notified || CodeExact == this) && ordinal() == enumC2878a.ordinal());
    }

    public EnumC2878a notified() {
        return !this.notified ? values()[ordinal() + 1] : this;
    }

    public EnumC2878a unNotify() {
        if (!this.notified) {
            return this;
        }
        EnumC2878a enumC2878a = values()[ordinal() - 1];
        return !enumC2878a.notified ? enumC2878a : DefaultUnNotify;
    }
}
