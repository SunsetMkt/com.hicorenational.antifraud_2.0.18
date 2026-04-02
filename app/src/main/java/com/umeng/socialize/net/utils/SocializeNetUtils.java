package com.umeng.socialize.net.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.Config;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class SocializeNetUtils {
    private static final String TAG = "SocializeNetUtils";

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line + "/n");
                    } catch (IOException e2) {
                        SLog.error(UmengText.NET.TOOL, e2);
                    }
                } catch (IOException e3) {
                    SLog.error(UmengText.NET.TOOL, e3);
                    inputStream.close();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    SLog.error(UmengText.NET.TOOL, e4);
                }
                throw th;
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                try {
                    bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    SLog.error(UmengText.NET.TOOL, e2);
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007b -> B:93:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00b7 -> B:98:0x00d8). Please report as a decompilation issue!!! */
    public static byte[] getNetData(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
                httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = 0;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = 0;
        }
        if (httpURLConnection.getResponseCode() == 301) {
            String headerField = httpURLConnection.getHeaderField("Location");
            if (!headerField.equals(str)) {
                return getNetData(headerField);
            }
            SLog.E(UmengText.NET.NET_AGAIN_ERROR);
            return null;
        }
        inputStream = httpURLConnection.getInputStream();
        try {
            try {
                SLog.I(UmengText.IMAGE.IMAGEURL + str);
                bArr = new byte[4096];
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream;
            }
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                th = th3;
                inputStream2 = inputStream;
                try {
                    if (inputStream2 != null) {
                        try {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                                SLog.error(UmengText.NET.TOOL, e4);
                                if (byteArrayOutputStream != 0) {
                                    byteArrayOutputStream.close();
                                }
                            }
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.close();
                            }
                        } finally {
                        }
                    }
                } catch (IOException e5) {
                    SLog.error(UmengText.NET.CLOSE, e5);
                }
                throw th;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                try {
                } finally {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        SLog.error(UmengText.NET.CLOSE, e6);
                    }
                }
            } catch (IOException e7) {
                SLog.error(UmengText.NET.CLOSE, e7);
                byteArrayOutputStream = e7;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream;
                } catch (IOException e8) {
                    SLog.error(UmengText.NET.TOOL, e8);
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream;
                }
            }
            return byteArray;
        } catch (Exception e9) {
            e = e9;
            SLog.error(UmengText.NET.IMAGEDOWN, e);
            try {
            } catch (IOException e10) {
                SLog.error(UmengText.NET.CLOSE, e10);
            }
            if (inputStream != null) {
                try {
                    try {
                        inputStream.close();
                        if (byteArrayOutputStream != 0) {
                            byteArrayOutputStream.close();
                        }
                    } finally {
                    }
                } catch (IOException e11) {
                    SLog.error(UmengText.NET.TOOL, e11);
                    if (byteArrayOutputStream != 0) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public static boolean isConSpeCharacters(String str) {
        return str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0;
    }

    public static boolean isSelfAppkey(String str) {
        return str.equals("5126ff896c738f2bfa000438") && !ContextUtil.getPackageName().equals("com.umeng.soexample");
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e2) {
            SLog.error(UmengText.NET.TOOL, e2);
            return new Bundle();
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle bundleDecodeUrl = decodeUrl(url.getQuery());
            bundleDecodeUrl.putAll(decodeUrl(url.getRef()));
            return bundleDecodeUrl;
        } catch (MalformedURLException e2) {
            SLog.error(UmengText.NET.TOOL, e2);
            return new Bundle();
        }
    }

    public static String request(String str) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            if (uRLConnectionOpenConnection == null) {
                return "";
            }
            uRLConnectionOpenConnection.connect();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            return inputStream == null ? "" : convertStreamToString(inputStream);
        } catch (Exception e2) {
            SLog.error(UmengText.NET.TOOL, e2);
            return "";
        }
    }

    public static boolean startWithHttp(String str) {
        return str.startsWith(DefaultWebClient.HTTP_SCHEME) || str.startsWith(DefaultWebClient.HTTPS_SCHEME);
    }
}
