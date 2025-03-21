package manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.IOException;
import ui.Hicore;
import ui.c;
import util.f1;
import util.o1;
import util.u1;

/* loaded from: classes2.dex */
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

        /* JADX WARN: Can't wrap try/catch for region: R(17:35|(1:37)|38|(1:42)|43|(6:48|(1:50)|51|(2:67|68)|(2:60|61)|(3:55|56|57)(1:59))|74|75|76|77|(2:78|(1:1)(3:82|(3:86|87|88)|89))|93|(1:95)|97|(0)|(0)|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x0177, code lost:
        
            r2 = r0;
            r0 = r4;
            r4 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x01a7, code lost:
        
            r3.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x01b0, code lost:
        
            if (r14.this$0.mHandler != null) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x01b2, code lost:
        
            r14.this$0.mHandler.sendEmptyMessage(4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01bb, code lost:
        
            if (r0 != null) goto L166;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x01ca, code lost:
        
            if (r2 != null) goto L154;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x01d9, code lost:
        
            if (r4 != null) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01db, code lost:
        
            r4.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01cc, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x01d5, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x01d6, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x01d0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x01d1, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x01bd, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x01c6, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x01c7, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x01c1, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x01c2, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x01e4, code lost:
        
            r1 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x01e5, code lost:
        
            if (r0 != null) goto L159;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x01f4, code lost:
        
            if (r2 != null) goto L168;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0203, code lost:
        
            if (r4 == null) goto L185;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0205, code lost:
        
            r4.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0209, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x020a, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x020d, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x01f6, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x01ff, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0200, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x01fa, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x01fb, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x01e7, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x01f0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x01f1, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x01eb, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x01ec, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x016f, code lost:
        
            r1 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0170, code lost:
        
            r2 = r0;
            r0 = r4;
            r4 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0176, code lost:
        
            r3 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:136:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x016a A[Catch: Exception -> 0x01df, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x01df, blocks: (B:55:0x016a, B:109:0x01db), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 526
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: manager.UpdateManager.DownloadThread.run():void");
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
        try {
            Activity c2 = c.i().c();
            try {
                if (Build.VERSION.SDK_INT >= 26 && !Hicore.getApp().getPackageManager().canRequestPackageInstalls()) {
                    c2.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + c2.getPackageName())), REQUESTCODE_INSTALL_PERMISS_CODE);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                Runtime.getRuntime().exec("chmod 777 " + str + File.separator + UPDATE_FILE_NAME);
            } catch (IOException e3) {
                e3.printStackTrace();
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
            c2.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        c.i().d();
    }

    private boolean doNormalSignCheck(File file) {
        return u1.b(u1.p).equalsIgnoreCase(o1.a(file));
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
        this.mDownloadPath = f1.a() + UPDATE_FILE_PATH;
    }
}
