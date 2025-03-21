package ui.activity;

import adapter.SmsSelectAdapter;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.hihonor.honorid.core.data.UserInfo;
import com.umeng.analytics.pro.bl;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ui.Hicore;
import util.y1;

/* loaded from: classes2.dex */
public class SmsRecordSelectActivity extends BaseActivity implements SmsSelectAdapter.b {

    /* renamed from: h, reason: collision with root package name */
    public static final String f19028h = "select_type_name";

    /* renamed from: i, reason: collision with root package name */
    public static final int f19029i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f19030j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final String f19031k = "select_mode";

    /* renamed from: l, reason: collision with root package name */
    public static final String f19032l = "single";

    /* renamed from: a, reason: collision with root package name */
    private SmsSelectAdapter f19033a;

    /* renamed from: b, reason: collision with root package name */
    private List<SmsBean> f19034b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<SmsBean> f19035c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Uri f19036d = Uri.parse("content://sms/");

    /* renamed from: e, reason: collision with root package name */
    private int f19037e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f19038f = 100;

    /* renamed from: g, reason: collision with root package name */
    private String f19039g = "";

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements Runnable {

        /* renamed from: ui.activity.SmsRecordSelectActivity$a$a, reason: collision with other inner class name */
        class C0286a implements Comparator<SmsBean> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collator f19041a;

            C0286a(Collator collator) {
                this.f19041a = collator;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(SmsBean smsBean, SmsBean smsBean2) {
                return this.f19041a.compare(smsBean2.getStringDate(), smsBean.getStringDate());
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f19043a;

            b(List list) {
                this.f19043a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                smsRecordSelectActivity.f19033a = new SmsSelectAdapter(R.layout.recyclerview_sms_select, this.f19043a, smsRecordSelectActivity.f19035c);
                SmsRecordSelectActivity.this.f19033a.a(SmsRecordSelectActivity.this.mRecyclerview);
                SmsRecordSelectActivity smsRecordSelectActivity2 = SmsRecordSelectActivity.this;
                smsRecordSelectActivity2.mRecyclerview.setAdapter(smsRecordSelectActivity2.f19033a);
                SmsRecordSelectActivity.this.f19033a.setOnItemClickListener(SmsRecordSelectActivity.this);
                SmsRecordSelectActivity.this.hideProgressDialog();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List arrayList = new ArrayList();
            int i2 = SmsRecordSelectActivity.this.f19037e;
            if (i2 == 1) {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                List a2 = smsRecordSelectActivity.a((Context) smsRecordSelectActivity);
                if (a2 != null && a2.size() > 0) {
                    arrayList.addAll(a2);
                }
                List c2 = SmsRecordSelectActivity.this.c();
                if (c2 != null && c2.size() > 0) {
                    arrayList.addAll(c2);
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, new C0286a(Collator.getInstance(Locale.CHINA)));
                }
            } else if (i2 == 2) {
                arrayList = SmsRecordSelectActivity.a((Activity) SmsRecordSelectActivity.this, false);
            }
            SmsRecordSelectActivity.this.runOnUiThread(new b(arrayList));
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsRecordSelectActivity.this.showDlogPrimssExcept();
        }
    }

    private void initData() {
        showProgressDialog();
        new Thread(new a()).start();
    }

    private void initView() {
        if (this.f19037e != 2) {
            this.mTvTitle.setText(R.string.sms_record_select);
        } else {
            this.mTvTitle.setText("浏览器历史记录选择");
        }
        if (TextUtils.equals(this.f19039g, f19032l)) {
            this.mBtnReport.setVisibility(8);
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.f19037e = getIntent().getIntExtra(f19028h, 0);
        this.f19039g = getIntent().getStringExtra(f19031k);
        this.f19035c = (ArrayList) getIntent().getSerializableExtra(util.k1.u);
        initView();
        initData();
        try {
            this.f19038f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f19038f = 0;
        }
    }

    @OnClick({R.id.iv_back, R.id.btn_report})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_report) {
            a();
        } else {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record_select;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "content://mms/part/"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            java.io.InputStream r1 = r2.openInputStream(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            if (r1 == 0) goto L47
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
        L35:
            if (r2 == 0) goto L47
            r0.append(r2)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41 java.io.FileNotFoundException -> L43
            goto L35
        L3f:
            r2 = move-exception
            goto L4d
        L41:
            goto L53
        L43:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
        L47:
            if (r1 == 0) goto L56
        L49:
            r1.close()     // Catch: java.io.IOException -> L56
            goto L56
        L4d:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L52
        L52:
            throw r2
        L53:
            if (r1 == 0) goto L56
            goto L49
        L56:
            java.lang.String r2 = r0.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.SmsRecordSelectActivity.b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmsBean> c() {
        try {
            ArrayList arrayList = new ArrayList();
            Cursor query = getContentResolver().query(this.f19036d, new String[]{bl.f10170d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(UserInfo.ADDRESS));
                query.getString(query.getColumnIndex("person"));
                String string2 = query.getString(query.getColumnIndex("body"));
                arrayList.add(new SmsBean(string, string2, y1.a(Long.valueOf(Long.parseLong(query.getString(query.getColumnIndex("date")))), "yyyy-MM-dd HH:mm:ss"), false));
                Matcher matcher = Pattern.compile(" [a-zA-Z0-9]{10}").matcher(string2);
                if (matcher.find()) {
                    matcher.group().substring(1, 11);
                }
            }
            query.close();
            return arrayList;
        } catch (Exception unused) {
            runOnUiThread(new b());
            return null;
        }
    }

    @Override // adapter.SmsSelectAdapter.b
    public void a(int i2, List<SmsBean> list, SmsBean smsBean) {
        try {
            SmsBean smsBean2 = list.get(i2);
            if (!smsBean2.isSelect()) {
                if (this.f19034b.size() == this.f19038f) {
                    util.w1.a("最多选择" + this.f19038f + "个");
                    return;
                }
                if (!this.f19034b.contains(smsBean2)) {
                    this.f19034b.add(smsBean2);
                }
                smsBean2.setSelect(true);
            } else {
                smsBean2.setSelect(false);
                this.f19034b.remove(smsBean2);
                if (smsBean != null && this.f19035c.contains(smsBean)) {
                    this.f19035c.remove(smsBean);
                }
            }
            this.f19033a.notifyDataSetChanged();
            if (TextUtils.equals(this.f19039g, f19032l)) {
                a();
            }
        } catch (Exception unused) {
        }
    }

    public static String b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (y1.b()) {
                str = Hicore.getApp().getExternalFilesDir("").getAbsolutePath() + "/hicore_national/cache/";
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hicore_national/cache/";
            }
        } else {
            str = Hicore.getApp().getFilesDir().getAbsolutePath() + "/hicore_national/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private void a() {
        List<SmsBean> list = this.f19035c;
        if (list != null && list.size() > 0) {
            this.f19034b.addAll(this.f19035c);
        }
        if (this.f19034b.size() != 0) {
            int i2 = this.f19037e;
            if (i2 == 1) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(302, this.f19034b));
            } else if (i2 == 2) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(13, this.f19034b));
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmsBean> a(Context context) {
        String sb;
        ArrayList arrayList = new ArrayList();
        Cursor query = getContentResolver().query(Uri.parse("content://mms"), null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            SmsBean smsBean = new SmsBean();
            String string = query.getString(query.getColumnIndex(bl.f10170d));
            String a2 = a(this, string);
            util.n1.a("彩信--phonenumber》" + a2);
            String a3 = y1.a(Long.valueOf(((long) query.getInt(query.getColumnIndex("date"))) * 1000), "yyyy-MM-dd HH:mm:ss");
            String string2 = query.getString(query.getColumnIndex("sub"));
            try {
                string2 = !TextUtils.isEmpty(string2) ? new String(string2.getBytes("ISO8859_1"), "UTF-8") : "";
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            Cursor query2 = getContentResolver().query(Uri.parse("content://mms/part"), null, "mid=" + string, null, null);
            if (query2 != null) {
                if (query2.moveToFirst()) {
                    do {
                        String string3 = query2.getString(query2.getColumnIndex("ct"));
                        util.n1.a("彩信--type》" + string3);
                        String lowerCase = string3.toLowerCase();
                        if ("text/plain".equals(lowerCase)) {
                            if (query2.getString(query2.getColumnIndex("_data")) != null) {
                                String b2 = b(context, query2.getString(query2.getColumnIndex(bl.f10170d)));
                                util.n1.a("彩信--》" + string2 + "\n" + b2);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string2);
                                sb2.append(b2);
                                sb = sb2.toString();
                            } else {
                                String string4 = query2.getString(query2.getColumnIndex("text"));
                                util.n1.a("彩信--》" + string2 + "\n" + string4);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(string2);
                                sb3.append(string4);
                                sb = sb3.toString();
                            }
                            smsBean.setSmsContent(sb);
                        } else if (lowerCase.contains("image")) {
                            Uri parse = Uri.parse("content://mms/part/" + query2.getString(query2.getColumnIndex(bl.f10170d)));
                            util.n1.b("partURI", "彩信==>" + parse.toString());
                            smsBean.setType(lowerCase);
                            smsBean.setFileUri(parse.toString());
                        }
                    } while (query2.moveToNext());
                }
                if (!TextUtils.isEmpty(smsBean.getSmsContent())) {
                    smsBean.setSmsNum(a2);
                    smsBean.setStringDate(a3);
                    arrayList.add(smsBean);
                }
            }
        } while (query.moveToNext());
        return arrayList;
    }

    private static String a(Context context, String str) {
        String str2;
        Cursor query = context.getContentResolver().query(Uri.parse(MessageFormat.format("content://mms/{0}/addr", str)), null, null, null, null);
        if (query.moveToFirst()) {
            do {
                str2 = query.getString(query.getColumnIndex(UserInfo.ADDRESS));
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
            } while (query.moveToNext());
        }
        str2 = "";
        if (query != null) {
            query.close();
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0118 A[Catch: Exception -> 0x0114, TRY_LEAVE, TryCatch #9 {Exception -> 0x0114, blocks: (B:75:0x0110, B:68:0x0118), top: B:74:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.SmsRecordSelectActivity.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #3 {Exception -> 0x009a, blocks: (B:52:0x0096, B:45:0x009e), top: B:51:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, android.net.Uri r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "saved_file"
            java.lang.String r1 = ".jpg"
            android.content.ContentResolver r5 = r5.getContentResolver()
            r2 = 0
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            if (r5 != 0) goto L1a
            if (r5 == 0) goto L19
            r5.close()     // Catch: java.lang.Exception -> L15
            goto L19
        L15:
            r5 = move-exception
            r5.printStackTrace()
        L19:
            return
        L1a:
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r3 = util.f1.b()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r0)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4.append(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r6.<init>(r3, r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r6.getPath()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r0 = "彩信"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r3 = "彩信==>"
            r1.append(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r1.append(r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            util.n1.b(r0, r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
        L58:
            int r0 = r5.read(r6)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            r1 = -1
            if (r0 == r1) goto L64
            r1 = 0
            r7.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
            goto L58
        L64:
            if (r5 == 0) goto L69
            r5.close()     // Catch: java.lang.Exception -> L85
        L69:
            r7.close()     // Catch: java.lang.Exception -> L85
            goto L90
        L6d:
            r6 = move-exception
            goto L93
        L6f:
            r6 = move-exception
            goto L75
        L71:
            r6 = move-exception
            goto L94
        L73:
            r6 = move-exception
            r7 = r2
        L75:
            r2 = r5
            goto L7c
        L77:
            r6 = move-exception
            r5 = r2
            goto L94
        L7a:
            r6 = move-exception
            r7 = r2
        L7c:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.lang.Exception -> L85
            goto L87
        L85:
            r5 = move-exception
            goto L8d
        L87:
            if (r7 == 0) goto L90
            r7.close()     // Catch: java.lang.Exception -> L85
            goto L90
        L8d:
            r5.printStackTrace()
        L90:
            return
        L91:
            r6 = move-exception
            r5 = r2
        L93:
            r2 = r7
        L94:
            if (r5 == 0) goto L9c
            r5.close()     // Catch: java.lang.Exception -> L9a
            goto L9c
        L9a:
            r5 = move-exception
            goto La2
        L9c:
            if (r2 == 0) goto La5
            r2.close()     // Catch: java.lang.Exception -> L9a
            goto La5
        La2:
            r5.printStackTrace()
        La5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.SmsRecordSelectActivity.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    public static List<SmsBean> a(Activity activity, boolean z) {
        Uri parse = Uri.parse("content://browser/bookmarks");
        Uri.parse("content://com.android.chrome.browser/bookmarks");
        Uri.parse("content://com.sec.android.app.sbrowser.browser/bookmarks");
        String[] strArr = {"url", "title"};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor loadInBackground = new CursorLoader(activity, parse, strArr, null, null, null).loadInBackground();
            if (loadInBackground != null && loadInBackground.moveToFirst() && loadInBackground.getCount() > 0) {
                while (!loadInBackground.isAfterLast()) {
                    String string = loadInBackground.getString(0);
                    String string2 = loadInBackground.getString(1);
                    util.n1.e("urlIdx-->", string);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        arrayList.add(new SmsBean(string2, string, "", false));
                    }
                    util.n1.e("titleIdx-->", string2);
                    if (z && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        break;
                    }
                    loadInBackground.moveToNext();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
