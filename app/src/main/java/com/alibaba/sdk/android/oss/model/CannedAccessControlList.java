package com.alibaba.sdk.android.oss.model;

import com.taobao.accs.AccsClientConfig;

/* loaded from: classes.dex */
public enum CannedAccessControlList {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default(AccsClientConfig.DEFAULT_CONFIGTAG);

    private String ACLString;

    CannedAccessControlList(String str) {
        this.ACLString = str;
    }

    public static CannedAccessControlList parseACL(String str) {
        for (CannedAccessControlList cannedAccessControlList : values()) {
            if (cannedAccessControlList.toString().equals(str)) {
                return cannedAccessControlList;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ACLString;
    }
}
