package com.alibaba.sdk.android.oss.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Owner implements Serializable {
    private static final long serialVersionUID = -1942759024112448066L;
    private String displayName;

    /* renamed from: id */
    private String f4020id;

    public Owner() {
        this(null, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String id = owner.getId();
        String displayName = owner.getDisplayName();
        String id2 = getId();
        String displayName2 = getDisplayName();
        if (id == null) {
            id = "";
        }
        if (displayName == null) {
            displayName = "";
        }
        if (id2 == null) {
            id2 = "";
        }
        if (displayName2 == null) {
            displayName2 = "";
        }
        return id.equals(id2) && displayName.equals(displayName2);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.f4020id;
    }

    public int hashCode() {
        String str = this.f4020id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.f4020id = str;
    }

    public String toString() {
        return "Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
    }

    public Owner(String str, String str2) {
        this.f4020id = str;
        this.displayName = str2;
    }
}
