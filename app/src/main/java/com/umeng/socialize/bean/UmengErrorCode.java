package com.umeng.socialize.bean;

import p388ui.activity.BaseProgressUploadActivity;

/* loaded from: classes2.dex */
public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2),
    ShareFailed(2003),
    RequestForUserProfileFailed(2004),
    ShareDataNil(2004),
    ShareDataTypeIllegal(2004),
    NotInstall(2008);


    /* renamed from: a */
    private final int f13583a;

    UmengErrorCode(int i2) {
        this.f13583a = i2;
    }

    /* renamed from: a */
    private String m12609a() {
        return "错误码：" + this.f13583a + " 错误信息：";
    }

    public String getMessage() {
        if (this == UnKnowCode) {
            return m12609a() + "未知错误----";
        }
        if (this == AuthorizeFailed) {
            return m12609a() + "授权失败----";
        }
        if (this == ShareFailed) {
            return m12609a() + "分享失败----";
        }
        if (this == RequestForUserProfileFailed) {
            return m12609a() + "获取用户资料失败----";
        }
        if (this == ShareDataNil) {
            return m12609a() + "分享内容为空";
        }
        if (this == ShareDataTypeIllegal) {
            return m12609a() + "分享内容不合法----";
        }
        if (this != NotInstall) {
            return "unkonw";
        }
        return m12609a() + "没有安装应用";
    }
}
