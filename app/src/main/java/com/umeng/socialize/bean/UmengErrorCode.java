package com.umeng.socialize.bean;

import ui.activity.BaseProgressUploadActivity;

/* JADX INFO: loaded from: classes2.dex */
public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2),
    ShareFailed(2003),
    RequestForUserProfileFailed(2004),
    ShareDataNil(2004),
    ShareDataTypeIllegal(2004),
    NotInstall(2008);

    private final int a;

    UmengErrorCode(int i2) {
        this.a = i2;
    }

    private String a() {
        return "\u9519\u8bef\u7801\uff1a" + this.a + " \u9519\u8bef\u4fe1\u606f\uff1a";
    }

    public String getMessage() {
        if (this == UnKnowCode) {
            return a() + "\u672a\u77e5\u9519\u8bef----";
        }
        if (this == AuthorizeFailed) {
            return a() + "\u6388\u6743\u5931\u8d25----";
        }
        if (this == ShareFailed) {
            return a() + "\u5206\u4eab\u5931\u8d25----";
        }
        if (this == RequestForUserProfileFailed) {
            return a() + "\u83b7\u53d6\u7528\u6237\u8d44\u6599\u5931\u8d25----";
        }
        if (this == ShareDataNil) {
            return a() + "\u5206\u4eab\u5185\u5bb9\u4e3a\u7a7a";
        }
        if (this == ShareDataTypeIllegal) {
            return a() + "\u5206\u4eab\u5185\u5bb9\u4e0d\u5408\u6cd5----";
        }
        if (this != NotInstall) {
            return "unkonw";
        }
        return a() + "\u6ca1\u6709\u5b89\u88c5\u5e94\u7528";
    }
}
