package util;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import bean.FileInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SelectFileUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a2 {
    private static c a;

    /* JADX INFO: compiled from: SelectFileUtils.java */
    public interface b {
        void a(List<FileInfo> list);
    }

    /* JADX INFO: compiled from: SelectFileUtils.java */
    private static class c {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b f14843b;

        private c() {
        }
    }

    public static void a(Activity activity, int i2, b bVar) {
        a = new c();
        c cVar = a;
        cVar.a = i2;
        cVar.f14843b = bVar;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        activity.startActivityForResult(Intent.createChooser(intent, "\u9009\u62e9\u6587\u4ef6"), 1005);
    }

    public static void a(int i2, int i3, Intent intent, Activity activity) {
        c cVar;
        if (i2 != 1005 || (cVar = a) == null || cVar.f14843b == null) {
            return;
        }
        if (i3 == -1 && intent != null) {
            List<Uri> listA = a(intent);
            ArrayList arrayList = new ArrayList();
            int iMin = Math.min(listA.size(), a.a);
            for (int i4 = 0; i4 < iMin; i4++) {
                FileInfo fileInfoA = a(activity, listA.get(i4));
                if (fileInfoA != null) {
                    arrayList.add(fileInfoA);
                }
            }
            a.f14843b.a(arrayList);
        }
        a = null;
    }

    private static List<Uri> a(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                arrayList.add(intent.getClipData().getItemAt(i2).getUri());
            }
        } else if (intent.getData() != null) {
            arrayList.add(intent.getData());
        }
        return arrayList;
    }

    private static FileInfo a(Activity activity, Uri uri) {
        String string;
        try {
            FileInfo fileInfo = new FileInfo();
            string = "unknown";
            long j2 = 0;
            Cursor cursorQuery = activity.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                    string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : "unknown";
                    int columnIndex2 = cursorQuery.getColumnIndex("_size");
                    if (columnIndex2 != -1) {
                        j2 = cursorQuery.getLong(columnIndex2);
                    }
                }
                cursorQuery.close();
            }
            fileInfo.fileName = string;
            fileInfo.fileSize = j2;
            InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                byte[] bArr = new byte[inputStreamOpenInputStream.available()];
                inputStreamOpenInputStream.read(bArr);
                inputStreamOpenInputStream.close();
                fileInfo.fileData = Base64.encodeToString(bArr, 0);
            }
            return fileInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(String str, String str2, String str3) throws Throwable {
        StringBuilder sb;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (!str.toLowerCase().endsWith(".pdf")) {
            str = str + "pdf";
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] bArrDecode = Base64.decode(str2.replaceFirst("^data:application/pdf;base64,", ""), 2);
                if (bArrDecode != null && bArrDecode.length >= 5 && bArrDecode[0] == 37 && bArrDecode[1] == 80 && bArrDecode[2] == 68 && bArrDecode[3] == 70 && bArrDecode[4] == 45) {
                    File file = new File(str3, str);
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArrDecode);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("saveH5FileToSdcard: 4");
                            sb.append(e);
                            sb.toString();
                            return false;
                        }
                    } catch (Exception e3) {
                        fileOutputStream = fileOutputStream2;
                        e = e3;
                        String str4 = "saveH5FileToSdcard: 3 " + e.toString();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e = e4;
                                sb = new StringBuilder();
                                sb.append("saveH5FileToSdcard: 4");
                                sb.append(e);
                                sb.toString();
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                sb = new StringBuilder();
                                sb.append("saveH5FileToSdcard: 4");
                                sb.append(e);
                                sb.toString();
                                return false;
                            }
                        }
                        throw th;
                    }
                }
                return false;
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
