package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class SerializeHelper {
    private static final String TAG = "awcn.SerializeHelper";
    private static File cacheDir;

    public static File getCacheFiles(String str) {
        Context context;
        if (cacheDir == null && (context = GlobalAppRuntimeInfo.getContext()) != null) {
            cacheDir = context.getCacheDir();
        }
        return new File(cacheDir, str);
    }

    public static synchronized void persist(Serializable serializable, File file) {
        persist(serializable, file, null);
    }

    public static synchronized <T> T restore(File file) {
        return (T) restore(file, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(1:18)|19|(2:54|20)|(4:52|21|(1:23)|24)|59|25|40|41) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x0095, TryCatch #4 {all -> 0x0095, blocks: (B:10:0x0012, B:12:0x001a, B:14:0x0020, B:18:0x0037, B:19:0x0039), top: B:58:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized <T> T restore(File file, StrategyStatObject strategyStatObject) {
        FileInputStream fileInputStream;
        T t;
        ObjectInputStream objectInputStream;
        if (strategyStatObject != null) {
            strategyStatObject.readStrategyFilePath = String.valueOf(file);
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                t = null;
            }
            if (file.exists()) {
                if (ALog.isPrintLog(3)) {
                    ALog.w(TAG, "file not exist.", null, "file", file.getName());
                }
                return null;
            }
            if (strategyStatObject != null) {
                strategyStatObject.isFileExists = 1;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                t = (T) objectInputStream.readObject();
            } catch (Throwable th2) {
                th = th2;
                t = null;
            }
            try {
                objectInputStream.close();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (strategyStatObject != null) {
                    strategyStatObject.isReadObjectSucceed = 1;
                    strategyStatObject.readCostTime = jCurrentTimeMillis2;
                }
                ALog.i(TAG, "restore end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(jCurrentTimeMillis2));
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (ALog.isPrintLog(3)) {
                        ALog.w(TAG, "restore file fail.", null, th, new Object[0]);
                    }
                    if (strategyStatObject != null) {
                        strategyStatObject.appendErrorTrace("SerializeHelper.restore()", th);
                    }
                    if (fileInputStream != null) {
                    }
                    return t;
                } catch (Throwable th4) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
            fileInputStream.close();
            return t;
        }
        if (file.exists()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void persist(Serializable serializable, File file, StrategyStatObject strategyStatObject) {
        File cacheFiles;
        FileOutputStream fileOutputStream;
        boolean z;
        boolean zRenameTo;
        FileOutputStream fileOutputStream2 = null;
        if (serializable != null && file != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i2 = 1;
            try {
                try {
                    try {
                        cacheFiles = getCacheFiles(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
                        try {
                            cacheFiles.createNewFile();
                            cacheFiles.setReadable(true);
                            fileOutputStream = new FileOutputStream(cacheFiles);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                                objectOutputStream.writeObject(serializable);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                                z = true;
                            } catch (Exception e2) {
                                e = e2;
                                ALog.e(TAG, "persist fail. ", null, e, "file", file.getName());
                                if (strategyStatObject != null) {
                                    strategyStatObject.appendErrorTrace("SerializeHelper.persist()", e);
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                z = false;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cacheFiles = null;
                        fileOutputStream = null;
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (strategyStatObject != null) {
                        strategyStatObject.writeTempFilePath = String.valueOf(cacheFiles);
                        strategyStatObject.writeStrategyFilePath = String.valueOf(file);
                        strategyStatObject.isTempWriteSucceed = z ? 1 : 0;
                        strategyStatObject.writeCostTime = jCurrentTimeMillis2;
                    }
                    if (z) {
                        zRenameTo = cacheFiles.renameTo(file);
                        if (zRenameTo) {
                            ALog.i(TAG, "persist end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(jCurrentTimeMillis2));
                        } else {
                            ALog.e(TAG, "rename failed.", null, new Object[0]);
                        }
                        if (strategyStatObject != null) {
                            strategyStatObject.isRenameSucceed = zRenameTo ? 1 : 0;
                            if (!zRenameTo) {
                                i2 = 0;
                            }
                            strategyStatObject.isSucceed = i2;
                            AppMonitor.getInstance().commitStat(strategyStatObject);
                        }
                    } else {
                        zRenameTo = false;
                    }
                    if (!z || !zRenameTo) {
                        try {
                            cacheFiles.delete();
                        } catch (Exception unused3) {
                            ALog.e(TAG, "delete failed.", null, new Object[0]);
                        }
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        ALog.e(TAG, "persist fail. Invalid parameter", null, new Object[0]);
    }
}
