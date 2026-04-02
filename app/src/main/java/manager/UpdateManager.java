package manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.heytap.mcssdk.constant.a;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import ui.Hicore;
import ui.c;
import util.c2;
import util.j1;
import util.t1;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateManager {
    private static final int COMPLETED = 2;
    private static final int ERROR = 4;
    private static final int INSTALL_FINALY = 5;
    public static final int REQUESTCODE_INSTALL_PERMISS_CODE = 50001;
    private static final int RESTART = 6;
    private static final String UPDATE_FILE_NAME = "update.apk";
    private static final String UPDATE_FILE_PATH = "/downloads";
    private DownLoadBack mDownLoadBack;
    private String mDownloadPath;
    private DownloadHandler mHandler;
    private String mUrl;
    boolean stopTh;

    public static class DownLoadBack {
        public void onCompleted(String str) {
            UpdateManager.getInstance().completed(str);
        }

        public void onDownLoading(int i2) {
        }

        public void onError() {
        }

        public void onFinaly() {
        }
    }

    private static class DownloadHandler extends Handler {
        private DownloadHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 2) {
                UpdateManager.getInstance().onCompleted();
                return;
            }
            if (i2 == 4) {
                UpdateManager.getInstance().onError();
            } else if (i2 != 5) {
                UpdateManager.getInstance().onDownLoading(((Integer) message.obj).intValue());
            } else {
                UpdateManager.getInstance().onFinaly();
            }
        }
    }

    private class DownloadThread extends Thread {
        private String mParam;
        private String mQuestType;
        private String mUrl;

        /* JADX WARN: Removed duplicated region for block: B:145:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:168:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            InputStream inputStream2;
            RandomAccessFile randomAccessFile = null;
            RandomAccessFile randomAccessFile2 = null;
            inputStream = null;
            InputStream inputStream3 = null;
            randomAccessFile = null;
            randomAccessFile = null;
            randomAccessFile = null;
            try {
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL(this.mUrl).openConnection();
                    try {
                        if (TextUtils.isEmpty(this.mQuestType)) {
                            this.mQuestType = "POST";
                        }
                        httpURLConnection2.setRequestMethod(this.mQuestType);
                        if (TextUtils.equals("POST", this.mQuestType)) {
                            httpURLConnection2.setDoOutput(true);
                            httpURLConnection2.setDoInput(true);
                            httpURLConnection2.setUseCaches(false);
                            httpURLConnection2.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                        }
                        httpURLConnection2.setConnectTimeout(Util.checkDuration("timeout", a.r, TimeUnit.SECONDS));
                        httpURLConnection2.connect();
                        if (TextUtils.equals("POST", this.mQuestType) && !TextUtils.isEmpty(this.mParam)) {
                            String str = this.mParam;
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection2.getOutputStream(), "UTF-8"));
                            bufferedWriter.write(str);
                            bufferedWriter.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    httpURLConnection = null;
                }
                if (httpURLConnection2.getResponseCode() != 200) {
                    if (UpdateManager.this.mHandler != null) {
                        UpdateManager.this.mHandler.sendEmptyMessage(4);
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                int contentLength = httpURLConnection2.getContentLength();
                if (contentLength <= 0) {
                    if (UpdateManager.this.mHandler != null) {
                        UpdateManager.this.mHandler.sendEmptyMessage(4);
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            return;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                File file = new File(UpdateManager.this.mDownloadPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, UpdateManager.UPDATE_FILE_NAME);
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
                if (httpURLConnection2.getResponseCode() == 200 || httpURLConnection2.getResponseCode() == 206) {
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(file2, "rwd");
                    try {
                        randomAccessFile3.setLength(contentLength);
                        inputStream3 = httpURLConnection2.getInputStream();
                        byte[] bArr = new byte[10240];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = inputStream3.read(bArr);
                            if (i4 == -1 || UpdateManager.this.stopTh) {
                                break;
                            }
                            randomAccessFile3.write(bArr, 0, i4);
                            i2 += i4;
                            int i5 = (int) ((((double) i2) * 100.0d) / ((double) contentLength));
                            if (UpdateManager.this.mHandler != null && i5 != i3) {
                                Message message = new Message();
                                message.obj = Integer.valueOf(i5);
                                UpdateManager.this.mHandler.sendMessage(message);
                                i3 = i5;
                            }
                        }
                        if (UpdateManager.this.mHandler != null) {
                            UpdateManager.this.mHandler.sendEmptyMessage(2);
                        }
                        inputStream2 = inputStream3;
                        randomAccessFile2 = randomAccessFile3;
                    } catch (Exception e6) {
                        e = e6;
                        inputStream = inputStream3;
                        randomAccessFile = randomAccessFile3;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e.printStackTrace();
                            if (UpdateManager.this.mHandler != null) {
                                UpdateManager.this.mHandler.sendEmptyMessage(4);
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            } else {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                throw th;
                            }
                            try {
                                httpURLConnection.disconnect();
                                throw th;
                            } catch (Exception e15) {
                                e15.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = inputStream3;
                        randomAccessFile = randomAccessFile3;
                        httpURLConnection = httpURLConnection2;
                        if (randomAccessFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                    }
                } else {
                    if (UpdateManager.this.mHandler != null) {
                        UpdateManager.this.mHandler.sendEmptyMessage(4);
                    }
                    inputStream2 = null;
                }
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e20) {
                e20.printStackTrace();
            }
        }

        private DownloadThread(String str) {
            this.mUrl = str;
        }

        private DownloadThread(String str, String str2) {
            this.mUrl = str;
            this.mParam = str2;
        }

        private DownloadThread(String str, String str2, String str3) {
            this.mUrl = str;
            this.mParam = str2;
            this.mQuestType = str3;
        }
    }

    private static class SingletonHolder {
        private static final UpdateManager INSTANCE = new UpdateManager();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completed(String str) {
        Activity activityC;
        try {
            activityC = c.i().c();
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 26 && !Hicore.getApp().getPackageManager().canRequestPackageInstalls()) {
            activityC.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + activityC.getPackageName())), REQUESTCODE_INSTALL_PERMISS_CODE);
            return;
        }
        try {
            Runtime.getRuntime().exec("chmod 777 " + str + File.separator + UPDATE_FILE_NAME);
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        File file = new File(str + File.separator + UPDATE_FILE_NAME);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(5);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(Hicore.getApp(), Hicore.getApp().getPackageName() + ".fileprovider", file);
            intent.addFlags(1);
            intent.addFlags(2);
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        activityC.startActivity(intent);
        c.i().d();
        e3.printStackTrace();
        c.i().d();
    }

    private boolean doNormalSignCheck(File file) {
        return c2.b(c2.p).equalsIgnoreCase(t1.a(file));
    }

    public static UpdateManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private boolean isDownloading() {
        return this.mHandler != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onCompleted(this.mDownloadPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownLoading(int i2) {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onDownLoading(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinaly() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onFinaly();
        }
        this.mUrl = null;
        this.mHandler = null;
        this.mDownLoadBack = null;
    }

    public void deleteApk() {
        File file = new File(this.mDownloadPath + File.separator + UPDATE_FILE_NAME);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void downloadApp(boolean z, String str, String str2, DownLoadBack downLoadBack) {
        this.mUrl = str;
        this.stopTh = false;
        if (downLoadBack != null) {
            this.mDownLoadBack = downLoadBack;
        } else {
            this.mDownLoadBack = new DownLoadBack();
        }
        this.mHandler = new DownloadHandler();
        if (z) {
            new DownloadThread(str, str2, "POST").start();
        } else {
            new DownloadThread(str, str2, "GET").start();
        }
    }

    public boolean existsApk() {
        File file = new File(this.mDownloadPath + File.separator + UPDATE_FILE_NAME);
        if (!file.exists()) {
            return false;
        }
        if (doNormalSignCheck(file)) {
            return true;
        }
        file.delete();
        return false;
    }

    public void onReinstall() {
        if (TextUtils.isEmpty(this.mDownloadPath)) {
            return;
        }
        completed(this.mDownloadPath);
    }

    public void stopThread(boolean z) {
        deleteApk();
        this.stopTh = z;
        this.mHandler = null;
    }

    private UpdateManager() {
        this.mDownloadPath = j1.a() + UPDATE_FILE_PATH;
    }
}
