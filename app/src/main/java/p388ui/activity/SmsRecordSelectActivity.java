package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.hihonor.honorid.core.data.UserInfo;
import com.umeng.analytics.pro.C3355bl;
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
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import util.C7292k1;
import util.C7301n1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class SmsRecordSelectActivity extends BaseActivity implements SmsSelectAdapter.InterfaceC0076b {

    /* renamed from: h */
    public static final String f23201h = "select_type_name";

    /* renamed from: i */
    public static final int f23202i = 1;

    /* renamed from: j */
    public static final int f23203j = 2;

    /* renamed from: k */
    public static final String f23204k = "select_mode";

    /* renamed from: l */
    public static final String f23205l = "single";

    /* renamed from: a */
    private SmsSelectAdapter f23206a;

    /* renamed from: b */
    private List<SmsBean> f23207b = new ArrayList();

    /* renamed from: c */
    private List<SmsBean> f23208c = new ArrayList();

    /* renamed from: d */
    private Uri f23209d = Uri.parse("content://sms/");

    /* renamed from: e */
    private int f23210e = 0;

    /* renamed from: f */
    private int f23211f = 100;

    /* renamed from: g */
    private String f23212g = "";

    @BindView(C2113R.id.btn_report)
    Button mBtnReport;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.SmsRecordSelectActivity$a */
    class RunnableC6605a implements Runnable {

        /* renamed from: ui.activity.SmsRecordSelectActivity$a$a */
        class a implements Comparator<SmsBean> {

            /* renamed from: a */
            final /* synthetic */ Collator f23214a;

            a(Collator collator) {
                this.f23214a = collator;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(SmsBean smsBean, SmsBean smsBean2) {
                return this.f23214a.compare(smsBean2.getStringDate(), smsBean.getStringDate());
            }
        }

        /* renamed from: ui.activity.SmsRecordSelectActivity$a$b */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f23216a;

            b(List list) {
                this.f23216a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                smsRecordSelectActivity.f23206a = new SmsSelectAdapter(C2113R.layout.recyclerview_sms_select, this.f23216a, smsRecordSelectActivity.f23208c);
                SmsRecordSelectActivity.this.f23206a.m5103a(SmsRecordSelectActivity.this.mRecyclerview);
                SmsRecordSelectActivity smsRecordSelectActivity2 = SmsRecordSelectActivity.this;
                smsRecordSelectActivity2.mRecyclerview.setAdapter(smsRecordSelectActivity2.f23206a);
                SmsRecordSelectActivity.this.f23206a.setOnItemClickListener(SmsRecordSelectActivity.this);
                SmsRecordSelectActivity.this.hideProgressDialog();
            }
        }

        RunnableC6605a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List arrayList = new ArrayList();
            int i2 = SmsRecordSelectActivity.this.f23210e;
            if (i2 == 1) {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                List m25369a = smsRecordSelectActivity.m25369a((Context) smsRecordSelectActivity);
                if (m25369a != null && m25369a.size() > 0) {
                    arrayList.addAll(m25369a);
                }
                List m25377c = SmsRecordSelectActivity.this.m25377c();
                if (m25377c != null && m25377c.size() > 0) {
                    arrayList.addAll(m25377c);
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, new a(Collator.getInstance(Locale.CHINA)));
                }
            } else if (i2 == 2) {
                arrayList = SmsRecordSelectActivity.m25368a((Activity) SmsRecordSelectActivity.this, false);
            }
            SmsRecordSelectActivity.this.runOnUiThread(new b(arrayList));
        }
    }

    /* renamed from: ui.activity.SmsRecordSelectActivity$b */
    class RunnableC6606b implements Runnable {
        RunnableC6606b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsRecordSelectActivity.this.showDlogPrimssExcept();
        }
    }

    private void initData() {
        showProgressDialog();
        new Thread(new RunnableC6605a()).start();
    }

    private void initView() {
        if (this.f23210e != 2) {
            this.mTvTitle.setText(C2113R.string.sms_record_select);
        } else {
            this.mTvTitle.setText("浏览器历史记录选择");
        }
        if (TextUtils.equals(this.f23212g, f23205l)) {
            this.mBtnReport.setVisibility(8);
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.f23210e = getIntent().getIntExtra(f23201h, 0);
        this.f23212g = getIntent().getStringExtra(f23204k);
        this.f23208c = (ArrayList) getIntent().getSerializableExtra(C7292k1.f25436u);
        initView();
        initData();
        try {
            this.f23211f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f23211f = 0;
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_report})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == C2113R.id.btn_report) {
            m25371a();
        } else {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_record_select;
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
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m25374b(android.content.Context r2, java.lang.String r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.SmsRecordSelectActivity.m25374b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public List<SmsBean> m25377c() {
        try {
            ArrayList arrayList = new ArrayList();
            Cursor query = getContentResolver().query(this.f23209d, new String[]{C3355bl.f11732d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(UserInfo.ADDRESS));
                query.getString(query.getColumnIndex("person"));
                String string2 = query.getString(query.getColumnIndex("body"));
                arrayList.add(new SmsBean(string, string2, C7337y1.m26737a(Long.valueOf(Long.parseLong(query.getString(query.getColumnIndex("date")))), "yyyy-MM-dd HH:mm:ss"), false));
                Matcher matcher = Pattern.compile(" [a-zA-Z0-9]{10}").matcher(string2);
                if (matcher.find()) {
                    matcher.group().substring(1, 11);
                }
            }
            query.close();
            return arrayList;
        } catch (Exception unused) {
            runOnUiThread(new RunnableC6606b());
            return null;
        }
    }

    @Override // adapter.SmsSelectAdapter.InterfaceC0076b
    /* renamed from: a */
    public void mo287a(int i2, List<SmsBean> list, SmsBean smsBean) {
        try {
            SmsBean smsBean2 = list.get(i2);
            if (!smsBean2.isSelect()) {
                if (this.f23207b.size() == this.f23211f) {
                    C7331w1.m26688a("最多选择" + this.f23211f + "个");
                    return;
                }
                if (!this.f23207b.contains(smsBean2)) {
                    this.f23207b.add(smsBean2);
                }
                smsBean2.setSelect(true);
            } else {
                smsBean2.setSelect(false);
                this.f23207b.remove(smsBean2);
                if (smsBean != null && this.f23208c.contains(smsBean)) {
                    this.f23208c.remove(smsBean);
                }
            }
            this.f23206a.notifyDataSetChanged();
            if (TextUtils.equals(this.f23212g, f23205l)) {
                m25371a();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static String m25373b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (C7337y1.m26768b()) {
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

    /* renamed from: a */
    private void m25371a() {
        List<SmsBean> list = this.f23208c;
        if (list != null && list.size() > 0) {
            this.f23207b.addAll(this.f23208c);
        }
        if (this.f23207b.size() != 0) {
            int i2 = this.f23210e;
            if (i2 == 1) {
                C6049c.m24987f().m25000d(new C7265a(302, this.f23207b));
            } else if (i2 == 2) {
                C6049c.m24987f().m25000d(new C7265a(13, this.f23207b));
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<SmsBean> m25369a(Context context) {
        String sb;
        ArrayList arrayList = new ArrayList();
        Cursor query = getContentResolver().query(Uri.parse("content://mms"), null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            SmsBean smsBean = new SmsBean();
            String string = query.getString(query.getColumnIndex(C3355bl.f11732d));
            String m25366a = m25366a(this, string);
            C7301n1.m26453a("彩信--phonenumber》" + m25366a);
            String m26737a = C7337y1.m26737a(Long.valueOf(((long) query.getInt(query.getColumnIndex("date"))) * 1000), "yyyy-MM-dd HH:mm:ss");
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
                        C7301n1.m26453a("彩信--type》" + string3);
                        String lowerCase = string3.toLowerCase();
                        if ("text/plain".equals(lowerCase)) {
                            if (query2.getString(query2.getColumnIndex("_data")) != null) {
                                String m25374b = m25374b(context, query2.getString(query2.getColumnIndex(C3355bl.f11732d)));
                                C7301n1.m26453a("彩信--》" + string2 + "\n" + m25374b);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string2);
                                sb2.append(m25374b);
                                sb = sb2.toString();
                            } else {
                                String string4 = query2.getString(query2.getColumnIndex("text"));
                                C7301n1.m26453a("彩信--》" + string2 + "\n" + string4);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(string2);
                                sb3.append(string4);
                                sb = sb3.toString();
                            }
                            smsBean.setSmsContent(sb);
                        } else if (lowerCase.contains("image")) {
                            Uri parse = Uri.parse("content://mms/part/" + query2.getString(query2.getColumnIndex(C3355bl.f11732d)));
                            C7301n1.m26457b("partURI", "彩信==>" + parse.toString());
                            smsBean.setType(lowerCase);
                            smsBean.setFileUri(parse.toString());
                        }
                    } while (query2.moveToNext());
                }
                if (!TextUtils.isEmpty(smsBean.getSmsContent())) {
                    smsBean.setSmsNum(m25366a);
                    smsBean.setStringDate(m26737a);
                    arrayList.add(smsBean);
                }
            }
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: a */
    private static String m25366a(Context context, String str) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m25367a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.SmsRecordSelectActivity.m25367a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #3 {Exception -> 0x009a, blocks: (B:52:0x0096, B:45:0x009e), top: B:51:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m25372a(android.content.Context r5, android.net.Uri r6, java.lang.String r7) {
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
            java.lang.String r3 = util.C7277f1.m26357b()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
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
            util.C7301n1.m26457b(r0, r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
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
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.SmsRecordSelectActivity.m25372a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    /* renamed from: a */
    public static List<SmsBean> m25368a(Activity activity, boolean z) {
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
                    C7301n1.m26463e("urlIdx-->", string);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        arrayList.add(new SmsBean(string2, string, "", false));
                    }
                    C7301n1.m26463e("titleIdx-->", string2);
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
