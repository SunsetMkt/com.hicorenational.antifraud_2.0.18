package com.huawei.hms.common.data;

import android.os.Bundle;
import com.xiaomi.push.service.C4383f;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    /* renamed from: a */
    private static boolean m6714a(Bundle bundle, String str) {
        return (bundle == null || bundle.getString(str) == null) ? false : true;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        if (dataBuffer == null) {
            return new ArrayList<>();
        }
        C4383f.AnonymousClass3 anonymousClass3 = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        Iterator<E> it = dataBuffer.iterator();
        while (it.hasNext()) {
            anonymousClass3.add(it.next().freeze());
        }
        dataBuffer.release();
        return anonymousClass3;
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return m6714a(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return m6714a(dataBuffer.getMetadata(), PREV_PAGE);
    }
}
