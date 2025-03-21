package p023b.p024a.p025a.p026d;

import android.text.TextUtils;

/* compiled from: Area.java */
/* renamed from: b.a.a.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC0903a extends C0908f implements InterfaceC0910h {
    private String areaId;
    private String areaName;

    public AbstractC0903a() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractC0903a)) {
            return false;
        }
        AbstractC0903a abstractC0903a = (AbstractC0903a) obj;
        return !TextUtils.isEmpty(this.areaId) ? this.areaId.equals(abstractC0903a.getAreaId()) : this.areaName.equals(abstractC0903a.getAreaName());
    }

    public String getAreaId() {
        return this.areaId;
    }

    public String getAreaName() {
        return this.areaName;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0910h
    public Object getId() {
        return this.areaId;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0914l
    public String getName() {
        return this.areaName;
    }

    public void setAreaId(String str) {
        this.areaId = str;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    @Override // p023b.p024a.p025a.p026d.C0908f
    public String toString() {
        return "areaId=" + this.areaId + ",areaName=" + this.areaName;
    }

    public AbstractC0903a(String str) {
        this.areaId = "";
        this.areaName = str;
    }

    public AbstractC0903a(String str, String str2) {
        this.areaId = str;
        this.areaName = str2;
    }
}
