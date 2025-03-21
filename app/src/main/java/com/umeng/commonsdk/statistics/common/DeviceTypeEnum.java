package com.umeng.commonsdk.statistics.common;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID),
    MAC(SocializeProtocolConstants.PROTOCOL_KEY_MAC, SocializeProtocolConstants.PROTOCOL_KEY_MAC),
    SERIALNO("serial_no", "serial_no"),
    IDFA("idfa", "idfa"),
    DEFAULT(AbstractC1191a.f2571h, AbstractC1191a.f2571h);

    private String description;
    private String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }
}
