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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class SmsRecordSelectActivity extends BaseActivity implements SmsSelectAdapter.b {

    /* JADX INFO: renamed from: h */
    public static final String f13859h = "select_type_name";

    /* JADX INFO: renamed from: i */
    public static final int f13860i = 1;

    /* JADX INFO: renamed from: j */
    public static final int f13861j = 2;

    /* JADX INFO: renamed from: k */
    public static final String f13862k = "select_mode";

    /* JADX INFO: renamed from: l */
    public static final String f13863l = "single";
    private SmsSelectAdapter a;

    /* JADX INFO: renamed from: b */
    private List<SmsBean> f13864b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private List<SmsBean> f13865c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private Uri f13866d = Uri.parse("content://sms/");

    /* JADX INFO: renamed from: e */
    private int f13867e = 0;

    /* JADX INFO: renamed from: f */
    private int f13868f = 100;

    /* JADX INFO: renamed from: g */
    private String f13869g = "";

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

        /* JADX INFO: renamed from: ui.activity.SmsRecordSelectActivity$a$a */
        class C0287a implements Comparator<SmsBean> {
            final /* synthetic */ Collator a;

            C0287a(Collator collator) {
                this.a = collator;
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a */
            public int compare(SmsBean smsBean, SmsBean smsBean2) {
                return this.a.compare(smsBean2.getStringDate(), smsBean.getStringDate());
            }
        }

        class b implements Runnable {
            final /* synthetic */ List a;

            b(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                smsRecordSelectActivity.a = new SmsSelectAdapter(R.layout.recyclerview_sms_select, this.a, smsRecordSelectActivity.f13865c);
                SmsRecordSelectActivity.this.a.a(SmsRecordSelectActivity.this.mRecyclerview);
                SmsRecordSelectActivity smsRecordSelectActivity2 = SmsRecordSelectActivity.this;
                smsRecordSelectActivity2.mRecyclerview.setAdapter(smsRecordSelectActivity2.a);
                SmsRecordSelectActivity.this.a.setOnItemClickListener(SmsRecordSelectActivity.this);
                SmsRecordSelectActivity.this.hideProgressDialog();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List arrayList = new ArrayList();
            int i2 = SmsRecordSelectActivity.this.f13867e;
            if (i2 == 1) {
                SmsRecordSelectActivity smsRecordSelectActivity = SmsRecordSelectActivity.this;
                List listA = smsRecordSelectActivity.a((Context) smsRecordSelectActivity);
                if (listA != null && listA.size() > 0) {
                    arrayList.addAll(listA);
                }
                List listC = SmsRecordSelectActivity.this.c();
                if (listC != null && listC.size() > 0) {
                    arrayList.addAll(listC);
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, new C0287a(Collator.getInstance(Locale.CHINA)));
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
        if (this.f13867e != 2) {
            this.mTvTitle.setText(R.string.sms_record_select);
        } else {
            this.mTvTitle.setText("\u6d4f\u89c8\u5668\u5386\u53f2\u8bb0\u5f55\u9009\u62e9");
        }
        if (TextUtils.equals(this.f13869g, f13863l)) {
            this.mBtnReport.setVisibility(8);
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.f13867e = getIntent().getIntExtra(f13859h, 0);
        this.f13869g = getIntent().getStringExtra(f13862k);
        this.f13865c = (ArrayList) getIntent().getSerializableExtra(util.p1.u);
        initView();
        initData();
        try {
            this.f13868f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f13868f = 0;
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

    /* JADX WARN: Removed duplicated region for block: B:61:0x0049 A[EXC_TOP_SPLITTER, PHI: r1
  0x0049: PHI (r1v5 java.io.InputStream) = (r1v3 java.io.InputStream), (r1v6 java.io.InputStream) binds: [B:55:0x0053, B:49:0x0047] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context, String str) {
        Uri uri = Uri.parse("content://mms/part/" + str);
        StringBuilder sb = new StringBuilder();
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, "UTF-8"));
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        sb.append(line);
                    }
                }
            } catch (IOException unused) {
                if (inputStreamOpenInputStream != null) {
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        if (inputStreamOpenInputStream != null) {
            try {
                inputStreamOpenInputStream.close();
            } catch (IOException unused3) {
            }
        }
        return sb.toString();
    }

    public List<SmsBean> c() {
        try {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = getContentResolver().query(this.f13866d, new String[]{bl.f7101d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(UserInfo.ADDRESS));
                cursorQuery.getString(cursorQuery.getColumnIndex("person"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("body"));
                arrayList.add(new SmsBean(string, string2, g2.a(Long.valueOf(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("date")))), "yyyy-MM-dd HH:mm:ss"), false));
                Matcher matcher = Pattern.compile(" [a-zA-Z0-9]{10}").matcher(string2);
                if (matcher.find()) {
                    matcher.group().substring(1, 11);
                }
            }
            cursorQuery.close();
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
                if (this.f13864b.size() == this.f13868f) {
                    e2.a("\u6700\u591a\u9009\u62e9" + this.f13868f + "\u4e2a");
                    return;
                }
                if (!this.f13864b.contains(smsBean2)) {
                    this.f13864b.add(smsBean2);
                }
                smsBean2.setSelect(true);
            } else {
                smsBean2.setSelect(false);
                this.f13864b.remove(smsBean2);
                if (smsBean != null && this.f13865c.contains(smsBean)) {
                    this.f13865c.remove(smsBean);
                }
            }
            this.a.notifyDataSetChanged();
            if (TextUtils.equals(this.f13869g, f13863l)) {
                a();
            }
        } catch (Exception unused) {
        }
    }

    public static String b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (g2.b()) {
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
        List<SmsBean> list = this.f13865c;
        if (list != null && list.size() > 0) {
            this.f13864b.addAll(this.f13865c);
        }
        if (this.f13864b.size() != 0) {
            int i2 = this.f13867e;
            if (i2 == 1) {
                org.greenrobot.eventbus.c.f().d(new util.n2.a(302, this.f13864b));
            } else if (i2 == 2) {
                org.greenrobot.eventbus.c.f().d(new util.n2.a(13, this.f13864b));
            }
        }
        finish();
    }

    public List<SmsBean> a(Context context) {
        String string;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = getContentResolver().query(Uri.parse("content://mms"), null, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return arrayList;
        }
        do {
            SmsBean smsBean = new SmsBean();
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(bl.f7101d));
            String strA = a(this, string2);
            util.s1.a("\u5f69\u4fe1--phonenumber\u300b" + strA);
            String strA2 = g2.a(Long.valueOf(((long) cursorQuery.getInt(cursorQuery.getColumnIndex("date"))) * 1000), "yyyy-MM-dd HH:mm:ss");
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("sub"));
            try {
                string3 = !TextUtils.isEmpty(string3) ? new String(string3.getBytes("ISO8859_1"), "UTF-8") : "";
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            Cursor cursorQuery2 = getContentResolver().query(Uri.parse("content://mms/part"), null, "mid=" + string2, null, null);
            if (cursorQuery2 != null) {
                if (cursorQuery2.moveToFirst()) {
                    do {
                        String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex("ct"));
                        util.s1.a("\u5f69\u4fe1--type\u300b" + string4);
                        String lowerCase = string4.toLowerCase();
                        if ("text/plain".equals(lowerCase)) {
                            if (cursorQuery2.getString(cursorQuery2.getColumnIndex("_data")) != null) {
                                String strB = b(context, cursorQuery2.getString(cursorQuery2.getColumnIndex(bl.f7101d)));
                                util.s1.a("\u5f69\u4fe1--\u300b" + string3 + "\n" + strB);
                                StringBuilder sb = new StringBuilder();
                                sb.append(string3);
                                sb.append(strB);
                                string = sb.toString();
                            } else {
                                String string5 = cursorQuery2.getString(cursorQuery2.getColumnIndex("text"));
                                util.s1.a("\u5f69\u4fe1--\u300b" + string3 + "\n" + string5);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string3);
                                sb2.append(string5);
                                string = sb2.toString();
                            }
                            smsBean.setSmsContent(string);
                        } else if (lowerCase.contains("image")) {
                            Uri uri = Uri.parse("content://mms/part/" + cursorQuery2.getString(cursorQuery2.getColumnIndex(bl.f7101d)));
                            util.s1.b("partURI", "\u5f69\u4fe1==>" + uri.toString());
                            smsBean.setType(lowerCase);
                            smsBean.setFileUri(uri.toString());
                        }
                    } while (cursorQuery2.moveToNext());
                }
                if (!TextUtils.isEmpty(smsBean.getSmsContent())) {
                    smsBean.setSmsNum(strA);
                    smsBean.setStringDate(strA2);
                    arrayList.add(smsBean);
                }
            }
        } while (cursorQuery.moveToNext());
        return arrayList;
    }

    private static String a(Context context, String str) {
        String string;
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(MessageFormat.format("content://mms/{0}/addr", str)), null, null, null, null);
        if (cursorQuery.moveToFirst()) {
            do {
                string = cursorQuery.getString(cursorQuery.getColumnIndex(UserInfo.ADDRESS));
                if (!TextUtils.isEmpty(string)) {
                    break;
                }
            } while (cursorQuery.moveToNext());
            string = "";
        } else {
            string = "";
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0118 A[Catch: Exception -> 0x0114, TRY_LEAVE, TryCatch #9 {Exception -> 0x0114, blocks: (B:167:0x0110, B:171:0x0118), top: B:183:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, String str2) throws Throwable {
        String str3;
        String string;
        InputStream inputStreamOpenInputStream;
        FileOutputStream fileOutputStream;
        int iLastIndexOf;
        if (TextUtils.isEmpty(str2) || (iLastIndexOf = str2.lastIndexOf("/")) <= -1) {
            str3 = "";
        } else {
            str3 = "." + str2.substring(iLastIndexOf + 1);
        }
        String strA = util.j1.a(context, str);
        int iLastIndexOf2 = strA.lastIndexOf("/");
        if (iLastIndexOf2 > -1) {
            string = strA.substring(iLastIndexOf2 + 1);
            if (!string.contains(".")) {
                string = string + str3;
            }
        } else {
            string = "";
        }
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        InputStream inputStream = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
            if (inputStreamOpenInputStream == null) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return "";
            }
            try {
                if (TextUtils.isEmpty(string)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = ".jpg";
                    }
                    sb.append(str3);
                    string = sb.toString();
                }
                File file = new File(util.j1.b(), string);
                String path = file.getPath();
                util.s1.b("\u5f69\u4fe1", "\u5f69\u4fe1==>" + path);
                util.s1.b("filePath", "\u5f69\u4fe1==>" + path);
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    fileOutputStream.close();
                    return path;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = inputStreamOpenInputStream;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                return "";
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        inputStreamOpenInputStream = inputStream;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStreamOpenInputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                if (inputStreamOpenInputStream != null) {
                }
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x009e A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #3 {Exception -> 0x009a, blocks: (B:124:0x0096, B:128:0x009e), top: B:134:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, Uri uri, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        InputStream inputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    File file = new File(util.j1.b(), "saved_file" + str + ".jpg");
                    util.s1.b("\u5f69\u4fe1", "\u5f69\u4fe1==>" + file.getPath());
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (inputStreamOpenInputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    inputStream = inputStreamOpenInputStream;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamOpenInputStream = inputStream;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStreamOpenInputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamOpenInputStream = null;
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public static List<SmsBean> a(Activity activity, boolean z) {
        Uri uri = Uri.parse("content://browser/bookmarks");
        Uri.parse("content://com.android.chrome.browser/bookmarks");
        Uri.parse("content://com.sec.android.app.sbrowser.browser/bookmarks");
        String[] strArr = {"url", "title"};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorLoadInBackground = new CursorLoader(activity, uri, strArr, null, null, null).loadInBackground();
            if (cursorLoadInBackground != null && cursorLoadInBackground.moveToFirst() && cursorLoadInBackground.getCount() > 0) {
                while (!cursorLoadInBackground.isAfterLast()) {
                    String string = cursorLoadInBackground.getString(0);
                    String string2 = cursorLoadInBackground.getString(1);
                    util.s1.e("urlIdx-->", string);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        arrayList.add(new SmsBean(string2, string, "", false));
                    }
                    util.s1.e("titleIdx-->", string2);
                    if (z && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        break;
                    }
                    cursorLoadInBackground.moveToNext();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
