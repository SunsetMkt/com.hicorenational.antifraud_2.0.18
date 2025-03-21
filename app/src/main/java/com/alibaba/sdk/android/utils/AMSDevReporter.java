package com.alibaba.sdk.android.utils;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class AMSDevReporter {

    /* renamed from: a */
    private static ConcurrentHashMap<AMSSdkTypeEnum, AMSReportStatusEnum> f4022a = new ConcurrentHashMap<>();

    public enum AMSReportStatusEnum {
        UNREPORTED,
        REPORTED
    }

    public enum AMSSdkExtInfoKeyEnum {
        AMS_EXTINFO_KEY_VERSION("SdkVersion"),
        AMS_EXTINFO_KEY_PACKAGE("PackageName");

        private String description;

        AMSSdkExtInfoKeyEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public enum AMSSdkTypeEnum {
        AMS_MAN("MAN"),
        AMS_HTTPDNS("HTTPDNS"),
        AMS_MPUSH("MPUSH"),
        AMS_MAC("MAC"),
        AMS_API("API"),
        AMS_HOTFIX("HOTFIX"),
        AMS_FEEDBACK("FEEDBACK"),
        AMS_IM("IM");

        private String description;

        AMSSdkTypeEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    static {
        for (AMSSdkTypeEnum aMSSdkTypeEnum : AMSSdkTypeEnum.values()) {
            f4022a.put(aMSSdkTypeEnum, AMSReportStatusEnum.REPORTED);
        }
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum) {
        C1566b.m3601a("Utils:DataTracker", "no man, do nothing");
    }

    public static AMSReportStatusEnum getReportStatus(AMSSdkTypeEnum aMSSdkTypeEnum) {
        return f4022a.get(aMSSdkTypeEnum);
    }

    public static void setLogEnabled(boolean z) {
        C1566b.setLogEnabled(z);
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum, Map<String, Object> map) {
        C1566b.m3601a("Utils:DataTracker", "no man, do nothing");
    }
}
