package com.huawei.agconnect.config.impl;

import com.huawei.agconnect.AGCRoutePolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            } else {
                writer.write(cArr, 0, read);
            }
        }
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(fixPath(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static String fixPath(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return "/" + str.substring(i2);
    }

    public static AGCRoutePolicy getRoutePolicyFromJson(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return AGCRoutePolicy.CHINA;
                }
                if (str2.contains("connect-dre")) {
                    return AGCRoutePolicy.GERMANY;
                }
                if (str2.contains("connect-drru")) {
                    return AGCRoutePolicy.RUSSIA;
                }
                if (str2.contains("connect-dra")) {
                    return AGCRoutePolicy.SINGAPORE;
                }
            }
            return AGCRoutePolicy.UNKNOWN;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2155) {
            if (hashCode != 2177) {
                if (hashCode != 2627) {
                    if (hashCode == 2644 && str.equals("SG")) {
                        c2 = 3;
                    }
                } else if (str.equals("RU")) {
                    c2 = 2;
                }
            } else if (str.equals("DE")) {
                c2 = 1;
            }
        } else if (str.equals("CN")) {
            c2 = 0;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? AGCRoutePolicy.UNKNOWN : AGCRoutePolicy.SINGAPORE : AGCRoutePolicy.RUSSIA : AGCRoutePolicy.GERMANY : AGCRoutePolicy.CHINA;
    }

    public static String toString(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
