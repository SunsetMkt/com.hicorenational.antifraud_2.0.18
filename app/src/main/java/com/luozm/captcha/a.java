package com.luozm.captcha;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: BitmapLoaderTask.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends AsyncTask<String, Integer, Bitmap> {
    private InterfaceC0099a a;

    /* JADX INFO: renamed from: com.luozm.captcha.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapLoaderTask.java */
    interface InterfaceC0099a {
        void a(Bitmap bitmap);
    }

    public a(InterfaceC0099a interfaceC0099a) {
        this.a = interfaceC0099a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0078: MOVE (r3 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:52:0x0078 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) throws Throwable {
        InputStream inputStream;
        ?? r1;
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        Bitmap bitmapDecodeStream;
        InputStream inputStream3 = null;
        try {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                } catch (MalformedURLException e2) {
                    e = e2;
                    httpURLConnection = null;
                    inputStream2 = null;
                } catch (IOException e3) {
                    e = e3;
                    httpURLConnection = null;
                    inputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    r1 = 0;
                }
                try {
                    httpURLConnection.setRequestMethod("GET");
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream2 = httpURLConnection.getInputStream();
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream2);
                            inputStream3 = inputStream2;
                        } catch (MalformedURLException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection == null) {
                                return null;
                            }
                            httpURLConnection.disconnect();
                            return null;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection == null) {
                                return null;
                            }
                            httpURLConnection.disconnect();
                            return null;
                        }
                    } else {
                        bitmapDecodeStream = null;
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bitmapDecodeStream;
                } catch (MalformedURLException e7) {
                    e = e7;
                    inputStream2 = null;
                } catch (IOException e8) {
                    e = e8;
                    inputStream2 = null;
                } catch (Throwable th3) {
                    r1 = httpURLConnection;
                    th = th3;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                    if (r1 == 0) {
                        throw th;
                    }
                    r1.disconnect();
                    throw th;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        } catch (Throwable th4) {
            r1 = strArr;
            th = th4;
            inputStream3 = inputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        this.a.a(bitmap);
    }
}
