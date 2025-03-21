package cn.cloudwalk.libproject.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FileUtil {
    public static final String DST_FOLDER_NAME = "FaceRecog";
    public static final String TAG = "FileUtil";
    public static String storagePath = "";

    public static void assetsDataToDest(Context context, String str, String str2) throws IOException {
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[1024];
        for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        open.close();
        fileOutputStream.close();
    }

    public static void copyFile(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            int i2 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                } else {
                    i2 += read;
                    System.out.println(i2);
                    fileOutputStream.write(bArr, 0, read);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void copyRawFileToSdcard(String str, AssetManager assetManager, String str2) {
        InputStream inputStream;
        try {
            inputStream = assetManager.open(str);
        } catch (IOException e2) {
            LogUtils.LOGE("tag", e2.getMessage());
            inputStream = null;
        }
        if (inputStream != null) {
            inputStreamToFile(inputStream, str2);
        }
    }

    public static void createModelFile(String str, String str2, AssetManager assetManager) {
        List<String> list;
        String str3 = str.endsWith("/") ? str + str2 : str + "/" + str2;
        if (new File(str3).exists()) {
            return;
        }
        mkDir(str);
        try {
            list = Arrays.asList(assetManager.list(Constants.KEY_MODEL));
        } catch (IOException e2) {
            LogUtils.LOGE(TAG, e2.getMessage());
            list = null;
        }
        for (String str4 : list) {
            LogUtils.LOGE(TAG, str4);
            writeStringToFile(readRawFileToString(Constants.KEY_MODEL + File.separator + str4, assetManager), str3);
        }
    }

    public static void createModelFileAll(String str, AssetManager assetManager) {
        List<String> list;
        String str2 = str.endsWith("/") ? str : str + "/";
        mkDir(str);
        try {
            list = Arrays.asList(assetManager.list(Constants.KEY_MODEL));
        } catch (IOException e2) {
            LogUtils.LOGE(TAG, e2.getMessage());
            list = null;
        }
        for (String str3 : list) {
            LogUtils.LOGE(TAG, str3);
            if (!new File(str2 + str3).exists()) {
                copyRawFileToSdcard(Constants.KEY_MODEL + File.separator + str3, assetManager, str2 + str3);
            }
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    public static byte[] file2byte(File file) throws IOException {
        int read;
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        int length = (int) file.length();
        if (length > Integer.MAX_VALUE) {
            System.out.println("this file is max ");
            fileInputStream.close();
            return null;
        }
        byte[] bArr = new byte[length];
        int i2 = 0;
        while (i2 < bArr.length && (read = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
            i2 += read;
        }
        fileInputStream.close();
        if (i2 >= bArr.length) {
            return bArr;
        }
        System.out.println("file length is error");
        return null;
    }

    public static String getExtensionNameWithDot(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf);
    }

    public static byte[] inputStreamToByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byteArrayOutputStream.close();
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void inputStreamToFile(InputStream inputStream, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream = new FileOutputStream(str, false);
                    fileOutputStream.write(byteArray);
                    fileOutputStream.close();
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public static String inputStreamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byteArrayOutputStream.close();
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    public static void mkDir(String str) {
        String[] split = str.split("/");
        String str2 = "";
        for (int i2 = 1; i2 < split.length; i2++) {
            str2 = str2 + "/" + split[i2];
            File file = new File(split[0] + str2);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public static void mkParentDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static byte[] readRawFileToByteArray(String str, AssetManager assetManager) {
        InputStream inputStream;
        try {
            inputStream = assetManager.open(str);
        } catch (IOException e2) {
            LogUtils.LOGE("tag", e2.getMessage());
            inputStream = null;
        }
        if (inputStream != null) {
            return inputStreamToByteArray(inputStream);
        }
        return null;
    }

    public static String readRawFileToString(String str, AssetManager assetManager) {
        InputStream inputStream;
        try {
            inputStream = assetManager.open(str);
        } catch (IOException e2) {
            LogUtils.LOGE("tag", e2.getMessage());
            inputStream = null;
        }
        if (inputStream != null) {
            return inputStreamToString(inputStream);
        }
        return null;
    }

    public static void unZipModelFolder(String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (!name.contains("../")) {
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else if (getExtensionNameWithDot(name).equals(".bin") || getExtensionNameWithDot(name).equals(".mdl") || getExtensionNameWithDot(name).equals(".txt")) {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void writeByteArrayToFile(byte[] bArr, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str).getCanonicalPath());
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public static void writeStringToFile(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2).getCanonicalPath());
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
