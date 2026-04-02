package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    public static class Builder {
        private String[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f4532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f4534d;

        public DataHolder build(int i2) {
            return new DataHolder(this, i2, (Bundle) null);
        }

        public Builder setDataForContentValuesHashMap(HashMap<String, Object> map) {
            boolean z;
            Object obj;
            Preconditions.checkNotNull(map, "contentValuesHashMap cannot be null");
            String str = this.f4533c;
            int iIntValue = 0;
            if (str == null || (obj = map.get(str)) == null) {
                z = false;
            } else {
                Integer num = this.f4534d.get(obj);
                if (num != null) {
                    iIntValue = num.intValue();
                    z = true;
                } else {
                    this.f4534d.put(obj, Integer.valueOf(this.f4532b.size()));
                    z = false;
                }
            }
            if (z) {
                this.f4532b.remove(iIntValue);
                this.f4532b.add(iIntValue, map);
            } else {
                this.f4532b.add(map);
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> map = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(map);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.a = strArr;
            this.f4532b = new ArrayList<>();
            this.f4533c = str;
            this.f4534d = new HashMap<>();
        }

        public DataHolder build(int i2, Bundle bundle) {
            return new DataHolder(this, i2, bundle, -1);
        }

        Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i2) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i2 < 0 || i2 >= this.dataCount) {
            str2 = "row is out of index:" + i2;
        } else {
            str2 = "";
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i2) {
        return new DataHolder(BUILDER, i2, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int numRows;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                numRows = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                numRows = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, numRows, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4 A[LOOP:1: B:25:0x009e->B:27:0x00a4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i2, List list) {
        CursorWindow cursorWindow;
        Iterator<CursorWindow> it;
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow2 = new CursorWindow((String) null);
        cursorWindow2.setNumColumns(builder.a.length);
        arrayList.add(cursorWindow2);
        CursorWindow cursorWindow3 = cursorWindow2;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
            } catch (RuntimeException unused) {
                cursorWindow = cursorWindow3;
            }
            if (!cursorWindow3.allocRow()) {
                HMSLog.d(TAG, "Failed to allocate a row");
                cursorWindow = new CursorWindow((String) null);
                try {
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.a.length);
                    if (!cursorWindow.allocRow()) {
                        HMSLog.e(TAG, "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow);
                    cursorWindow3 = cursorWindow;
                } catch (RuntimeException unused2) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                    }
                    HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                    cursorWindow3 = cursorWindow;
                }
            }
            HashMap map = (HashMap) list.get(i3);
            boolean zPutValue = true;
            for (int i4 = 0; i4 < builder.a.length && (zPutValue = putValue(cursorWindow3, map.get(builder.a[i4]), i3, i4)); i4++) {
            }
            if (!zPutValue) {
                HMSLog.d(TAG, "fail to put data for row " + i3);
                cursorWindow3.freeLastRow();
                CursorWindow cursorWindow4 = new CursorWindow((String) null);
                cursorWindow4.setStartPosition(i3);
                cursorWindow4.setNumColumns(builder.a.length);
                arrayList.add(cursorWindow4);
                break;
            }
            continue;
            it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
            cursorWindow3 = cursorWindow;
        }
        return arrayList;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i2, int i3) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i2 < i3 && hMSCursorWrapper.moveToPosition(i2)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i2);
                hMSCursorWrapper.fillWindow(i2, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i2 = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i2, int i3) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i2, i3);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i2, i3);
        }
        if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i2, i3);
        }
        if (obj instanceof Long) {
            return cursorWindow.putLong(((Long) obj).longValue(), i2, i3);
        }
        if (obj instanceof Float) {
            return cursorWindow.putDouble(((Float) obj).floatValue(), i2, i3);
        }
        if (obj instanceof Double) {
            return cursorWindow.putDouble(((Double) obj).doubleValue(), i2, i3);
        }
        if (obj instanceof String) {
            return cursorWindow.putString((String) obj, i2, i3);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i2, i3);
        }
        throw new IllegalArgumentException("unsupported type for column: " + obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i2 = 0;
        if (strArr == null || strArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.columns;
            if (i3 >= strArr2.length) {
                break;
            }
            this.columnsBundle.putInt(strArr2[i3], i3);
            i3++;
        }
        CursorWindow[] cursorWindowArr = this.cursorWindows;
        if (cursorWindowArr == null || cursorWindowArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        this.perCursorCounts = new int[cursorWindowArr.length];
        int startPosition = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = this.cursorWindows;
            if (i2 >= cursorWindowArr2.length) {
                this.dataCount = startPosition;
                return;
            } else {
                this.perCursorCounts[i2] = startPosition;
                startPosition = cursorWindowArr2[i2].getStartPosition() + this.cursorWindows[i2].getNumRows();
                i2++;
            }
        }
    }

    public final void copyToBuffer(String str, int i2, int i3, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i2);
        this.cursorWindows[i3].copyStringToBuffer(i2, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    protected final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getValue(String str, int i2, int i3, String str2) {
        str2.hashCode();
        switch (str2) {
            case "type_float":
                checkAvailable(str, i2);
                return Float.valueOf(this.cursorWindows[i3].getFloat(i2, this.columnsBundle.getInt(str)));
            case "type_boolean":
                checkAvailable(str, i2);
                return Boolean.valueOf(this.cursorWindows[i3].getLong(i2, this.columnsBundle.getInt(str)) == 1);
            case "type_int":
                checkAvailable(str, i2);
                return Integer.valueOf(this.cursorWindows[i3].getInt(i2, this.columnsBundle.getInt(str)));
            case "type_double":
                checkAvailable(str, i2);
                return Double.valueOf(this.cursorWindows[i3].getDouble(i2, this.columnsBundle.getInt(str)));
            case "type_long":
                checkAvailable(str, i2);
                return Long.valueOf(this.cursorWindows[i3].getLong(i2, this.columnsBundle.getInt(str)));
            case "type_string":
                checkAvailable(str, i2);
                return this.cursorWindows[i3].getString(i2, this.columnsBundle.getInt(str));
            case "type_byte_array":
                checkAvailable(str, i2);
                return this.cursorWindows[i3].getBlob(i2, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i2) {
        int[] iArr;
        int i3 = 0;
        Preconditions.checkArgument(i2 >= 0 || i2 < this.dataCount, "rowIndex is out of index:" + i2);
        while (true) {
            iArr = this.perCursorCounts;
            if (i3 >= iArr.length) {
                break;
            }
            if (i2 < iArr[i3]) {
                i3--;
                break;
            }
            i3++;
        }
        return i3 == iArr.length ? i3 - 1 : i3;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i2, int i3) {
        checkAvailable(str, i2);
        return this.cursorWindows[i3].getType(i2, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        if (parcel == null) {
            return;
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i2;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i3;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i2) {
        if (builder.a.length == 0) {
            return new CursorWindow[0];
        }
        if (i2 < 0 || i2 >= builder.f4532b.size()) {
            i2 = builder.f4532b.size();
        }
        ArrayList<CursorWindow> arrayListIterCursorWindow = iterCursorWindow(builder, i2, builder.f4532b.subList(0, i2));
        return (CursorWindow[]) arrayListIterCursorWindow.toArray(new CursorWindow[arrayListIterCursorWindow.size()]);
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i2, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i2, bundle);
    }

    public DataHolder(Cursor cursor, int i2, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i2, bundle);
    }

    private DataHolder(Builder builder, int i2, Bundle bundle) {
        this(builder.a, getCursorWindows(builder, -1), i2, (Bundle) null);
    }

    private DataHolder(Builder builder, int i2, Bundle bundle, int i3) {
        this(builder.a, getCursorWindows(builder, -1), i2, bundle);
    }
}
