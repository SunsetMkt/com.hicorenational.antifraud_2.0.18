package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private OnChooseActivityListener mActivityChoserModelPolicy;
    final Context mContext;
    final String mHistoryFileName;
    private Intent mIntent;
    static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Object sRegistryLock = new Object();
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private final Object mInstanceLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private ActivitySorter mActivitySorter = new DefaultSorter();
    private int mHistoryMaxSize = 50;
    boolean mCanReadHistoricalData = true;
    private boolean mReadShareHistoryCalled = false;
    private boolean mHistoricalRecordsChanged = true;
    private boolean mReloadActivities = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActivityResolveInfo activityResolveInfo = list.get(i2);
                activityResolveInfo.weight = 0.0f;
                map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f2;
                    f2 *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j2, float f2) {
            this(ComponentName.unflattenFromString(str), j2, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j2 = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j2, float f2) {
            this.activity = componentName;
            this.time = j2;
            this.weight = f2;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006e, code lost:
        
            if (r15 != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00c4, code lost:
        
            if (r15 == null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        
            if (r15 == null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
        
            if (r15 == null) goto L27;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.io.FileNotFoundException -> Ld2
                android.content.Context r7 = r7.mContext     // Catch: java.io.FileNotFoundException -> Ld2
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch: java.io.FileNotFoundException -> Ld2
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.startDocument(r8, r9)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.startTag(r6, r1)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                int r8 = r4.size()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r9 = 0
            L31:
                if (r9 >= r8) goto L64
                java.lang.Object r10 = r4.remove(r3)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.startTag(r6, r0)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.activity     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r12 = r12.flattenToString()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.attribute(r6, r11, r12)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r11 = "time"
                long r12 = r10.time     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.attribute(r6, r11, r12)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r11 = "weight"
                float r10 = r10.weight     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.attribute(r6, r11, r10)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.endTag(r6, r0)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                int r9 = r9 + 1
                goto L31
            L64:
                r7.endTag(r6, r1)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                r7.endDocument()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.lang.IllegalStateException -> L91 java.lang.IllegalArgumentException -> Lac
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto Lc7
            L70:
                r15.close()     // Catch: java.io.IOException -> Lc7
                goto Lc7
            L74:
                r0 = move-exception
                goto Lc8
            L76:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L74
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
                r0.<init>()     // Catch: java.lang.Throwable -> L74
                r0.append(r2)     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L74
                java.lang.String r1 = r1.mHistoryFileName     // Catch: java.lang.Throwable -> L74
                r0.append(r1)     // Catch: java.lang.Throwable -> L74
                r0.toString()     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto Lc7
                goto L70
            L91:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L74
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
                r0.<init>()     // Catch: java.lang.Throwable -> L74
                r0.append(r2)     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L74
                java.lang.String r1 = r1.mHistoryFileName     // Catch: java.lang.Throwable -> L74
                r0.append(r1)     // Catch: java.lang.Throwable -> L74
                r0.toString()     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto Lc7
                goto L70
            Lac:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch: java.lang.Throwable -> L74
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
                r0.<init>()     // Catch: java.lang.Throwable -> L74
                r0.append(r2)     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L74
                java.lang.String r1 = r1.mHistoryFileName     // Catch: java.lang.Throwable -> L74
                r0.append(r1)     // Catch: java.lang.Throwable -> L74
                r0.toString()     // Catch: java.lang.Throwable -> L74
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto Lc7
                goto L70
            Lc7:
                return r6
            Lc8:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.mCanReadHistoricalData = r5
                if (r15 == 0) goto Ld1
                r15.close()     // Catch: java.io.IOException -> Ld1
            Ld1:
                throw r0
            Ld2:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                r0.append(r15)
                r0.toString()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
            return;
        }
        this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean add = this.mHistoricalRecords.add(historicalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return add;
    }

    private void ensureConsistentState() {
        boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            activityChooserModel = sDataModelRegistry.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                sDataModelRegistry.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mActivities.add(new ActivityResolveInfo(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if (TextUtils.isEmpty(this.mHistoryFileName)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
        }
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i2 = 0; i2 < size; i2++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        FileInputStream openFileInput;
        XmlPullParser newPullParser;
        try {
            try {
                openFileInput = this.mContext.openFileInput(this.mHistoryFileName);
                try {
                    newPullParser = Xml.newPullParser();
                    newPullParser.setInput(openFileInput, "UTF-8");
                    for (int i2 = 0; i2 != 1 && i2 != 2; i2 = newPullParser.next()) {
                    }
                } catch (IOException unused) {
                    String str = "Error reading historical recrod file: " + this.mHistoryFileName;
                    if (openFileInput == null) {
                        return;
                    }
                } catch (XmlPullParserException unused2) {
                    String str2 = "Error reading historical recrod file: " + this.mHistoryFileName;
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!TAG_HISTORICAL_RECORDS.equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.mHistoricalRecords;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!TAG_HISTORICAL_RECORD.equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, ATTRIBUTE_WEIGHT))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused3) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public Intent chooseActivity(int i2) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(i2);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i2).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> list = this.mActivities;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).resolveInfo == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (this.mActivities.isEmpty()) {
                return null;
            }
            return this.mActivities.get(0).resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i2;
        synchronized (this.mInstanceLock) {
            i2 = this.mHistoryMaxSize;
        }
        return i2;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i2) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(i2);
            ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
            addHistoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f));
        }
    }

    public void setHistoryMaxSize(int i2) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == i2) {
                return;
            }
            this.mHistoryMaxSize = i2;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
