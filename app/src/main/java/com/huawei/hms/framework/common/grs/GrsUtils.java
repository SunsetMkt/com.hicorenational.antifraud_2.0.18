package com.huawei.hms.framework.common.grs;

import com.huawei.hms.framework.common.StringUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class GrsUtils {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";

    public static String fixResult(String[] strArr, String str) {
        if (strArr.length <= 2) {
            return str;
        }
        if (str.endsWith(SEPARATOR)) {
            return str + strArr[2];
        }
        return str + SEPARATOR + strArr[2];
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith(GRS_SCHEMA);
    }

    public static String[] parseGRSSchema(String str) {
        String[] split = StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split(SEPARATOR, 3);
        return split.length == 1 ? new String[]{split[0], "ROOT"} : split;
    }

    public static String[] parseParams(String str) {
        if (str.endsWith(SEPARATOR)) {
            str = StringUtils.substring(str, str.indexOf(GRS_SCHEMA), str.length() - 1);
        }
        return parseGRSSchema(str);
    }
}
