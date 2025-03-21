package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    private static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        String str = "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")";
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        this.lockRaf = new RandomAccessFile(file3, "rw");
        try {
            this.lockChannel = this.lockRaf.getChannel();
            try {
                String str2 = "Blocking on lock " + file3.getPath();
                this.cacheLock = this.lockChannel.lock();
                String str3 = file3.getPath() + " locked";
            } catch (IOException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            closeQuietly(this.lockRaf);
            throw e5;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            String str = "Failed to list secondary dex dir content (" + this.dexDir.getPath() + ").";
            return;
        }
        for (File file : listFiles) {
            String str2 = "Trying to delete old file " + file.getPath() + " of size " + file.length();
            if (file.delete()) {
                String str3 = "Deleted old file " + file.getPath();
            } else {
                String str4 = "Failed to delete old file " + file.getPath();
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        String str2 = "Extracting " + createTempFile.getPath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                String str3 = "Renaming to " + file.getPath();
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j2, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + KEY_TIME_STAMP, -1L) == getTimeStamp(file)) {
            if (multiDexPreferences.getLong(str + KEY_CRC, -1L) == j2) {
                return false;
            }
        }
        return true;
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i2 = multiDexPreferences.getInt(str + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str2 + i3 + EXTRACTED_SUFFIX);
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.crc = getZipCrc(extractedDex);
            long j2 = multiDexPreferences.getLong(str + KEY_DEX_CRC + i3, -1L);
            long j3 = multiDexPreferences.getLong(str + KEY_DEX_TIME + i3, -1L);
            long lastModified = extractedDex.lastModified();
            if (j3 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = multiDexPreferences;
                if (j2 == extractedDex.crc) {
                    arrayList.add(extractedDex);
                    i3++;
                    multiDexPreferences = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + extractedDex.crc);
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        String str = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        int i2 = 2;
        try {
            ZipEntry entry = zipFile.getEntry(DEX_PREFIX + 2 + DEX_SUFFIX);
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str + i2 + EXTRACTED_SUFFIX);
                arrayList.add(extractedDex);
                String str2 = "Extraction is needed for file " + extractedDex;
                int i3 = 0;
                boolean z = false;
                while (i3 < 3 && !z) {
                    i3++;
                    extract(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                    } catch (IOException unused) {
                        String str3 = "Failed to read crc from " + extractedDex.getAbsolutePath();
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.crc);
                    sb.toString();
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            String str4 = "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'";
                        }
                    }
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
                i2++;
                entry = zipFile.getEntry(DEX_PREFIX + i2 + DEX_SUFFIX);
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j2, long j3, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + KEY_TIME_STAMP, j2);
        edit.putLong(str + KEY_CRC, j3);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i2 = 2;
        for (ExtractedDex extractedDex : list) {
            edit.putLong(str + KEY_DEX_CRC + i2, extractedDex.crc);
            edit.putLong(str + KEY_DEX_TIME + i2, extractedDex.lastModified());
            i2++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    List<? extends File> load(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> performExtractions;
        String str2 = "MultiDexExtractor.load(" + this.sourceApk.getPath() + ", " + z + ", " + str + ")";
        if (!this.cacheLock.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (z || isModified(context, this.sourceApk, this.sourceCrc, str)) {
            performExtractions = performExtractions();
            putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
        } else {
            try {
                performExtractions = loadExistingExtractions(context, str);
            } catch (IOException unused) {
                performExtractions = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            }
        }
        String str3 = "load found " + performExtractions.size() + " secondary dex files";
        return performExtractions;
    }
}
