package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a */
    private static final OpenDeviceHmsClientBuilder f7651a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b */
    private static final Api<OpenDeviceOptions> f7652b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c */
    private static OpenDeviceOptions f7653c = new OpenDeviceOptions();

    OpenDeviceClientImpl(Context context) {
        super(context, f7652b, f7653c, f7651a);
        super.setKitSdkVersion(61200300);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 61200300)));
    }
}
