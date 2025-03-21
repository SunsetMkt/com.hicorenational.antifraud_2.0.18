package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class WebsiteActivity extends BaseActivity {

    /* renamed from: a */
    private LinkedList<EditText> f23539a;

    /* renamed from: b */
    private LinkedList<ImageView> f23540b;

    /* renamed from: c */
    private List<String> f23541c = new ArrayList();

    /* renamed from: d */
    private int f23542d = 20;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.linearlayout)
    public LinearLayout mLinearLayout;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(C2113R.id.fl_select_history)
    public View mTvSelectHistory;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.v_line)
    public View mVline;

    /* renamed from: ui.activity.WebsiteActivity$a */
    class ViewOnClickListenerC6724a implements View.OnClickListener {
        ViewOnClickListenerC6724a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebsiteActivity.this.m25425a(view);
        }
    }

    /* renamed from: b */
    private void m25428b() {
        this.mLinearLayout.removeAllViews();
        this.f23539a.clear();
        this.f23540b.clear();
    }

    /* renamed from: c */
    private void m25429c() {
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(C7292k1.f25422n);
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            for (int i2 = 0; i2 < 5; i2++) {
                m25424a();
            }
        } else {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                m25426a(it.next());
            }
        }
        List<SmsBean> m25368a = SmsRecordSelectActivity.m25368a((Activity) this, true);
        if (m25368a == null || m25368a.size() <= 0) {
            this.mVline.setVisibility(8);
            this.mTvSelectHistory.setVisibility(8);
        } else {
            this.mVline.setVisibility(0);
            this.mTvSelectHistory.setVisibility(0);
        }
    }

    /* renamed from: d */
    private List<String> m25430d() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f23539a.size(); i2++) {
            String trim = this.f23539a.get(i2).getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && !arrayList.contains(trim)) {
                arrayList.add(trim);
            }
        }
        return arrayList;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗网址");
        this.mTvCommit.setText("最多可添加20条网址");
        this.mBtnCommit.setText("确定");
        this.mLinearLayout = (LinearLayout) findViewById(C2113R.id.linearlayout);
        this.f23539a = new LinkedList<>();
        this.f23540b = new LinkedList<>();
        m25429c();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        sendData();
        C6049c.m24987f().m25003g(this);
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout == null || this.f23539a == null || this.f23540b == null) {
            return;
        }
        linearLayout.removeAllViews();
        this.f23539a.clear();
        this.f23540b.clear();
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        List list;
        if (c7265a == null || c7265a.m26297a() != 13 || (list = (List) c7265a.m26300b()) == null) {
            return;
        }
        this.f23541c = m25430d();
        m25428b();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String smsContent = ((SmsBean) it.next()).getSmsContent();
                if (this.f23541c == null) {
                    this.f23541c = new ArrayList();
                }
                if (this.f23541c.size() <= 0) {
                    this.f23541c.add(smsContent);
                } else if (!this.f23541c.contains(smsContent)) {
                    this.f23541c.add(smsContent);
                }
            }
            List<String> list2 = this.f23541c;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator<String> it2 = this.f23541c.iterator();
            while (it2.hasNext()) {
                m25426a(it2.next());
            }
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.fl_select, C2113R.id.fl_select_history, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                this.f23541c = m25430d();
                finish();
                break;
            case C2113R.id.fl_select /* 2131296641 */:
                if (!rejuctOperation()) {
                    m25424a();
                    break;
                }
                break;
            case C2113R.id.fl_select_history /* 2131296642 */:
                if (!rejuctOperation()) {
                    this.f23541c = m25430d();
                    int i2 = 0;
                    List<String> list = this.f23541c;
                    if (list != null && list.size() > 0) {
                        i2 = this.f23541c.size();
                    }
                    Intent intent = new Intent(this, (Class<?>) SmsRecordSelectActivity.class);
                    intent.putExtra(SmsRecordSelectActivity.f23201h, 2);
                    intent.putExtra("extra_select_can", this.f23542d - i2);
                    startActivity(intent);
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
        }
    }

    public boolean rejuctOperation() {
        LinkedList<EditText> linkedList = this.f23539a;
        if (linkedList == null || linkedList.size() != this.f23542d) {
            return false;
        }
        C7331w1.m26688a("最多可添加" + this.f23542d + "条网址");
        return true;
    }

    public void sendData() {
        List<String> list = this.f23541c;
        if (list == null || list.size() <= 0) {
            this.f23541c = m25430d();
        }
        C6049c.m24987f().m25000d(new C7265a(8, this.f23541c));
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_weburl;
    }

    /* renamed from: a */
    private void m25424a() {
        m25426a("");
    }

    /* renamed from: a */
    private void m25426a(String str) {
        View inflate = View.inflate(this.mActivity, C2113R.layout.recyclerview_url_select, null);
        EditText editText = (EditText) inflate.findViewById(C2113R.id.et_content);
        ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.iv_clear);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(500)});
        imageView.setOnClickListener(new ViewOnClickListenerC6724a());
        this.mLinearLayout.addView(inflate);
        this.f23539a.add(editText);
        this.f23540b.add(imageView);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        editText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25425a(View view) {
        if (view == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f23540b.size()) {
                break;
            }
            if (this.f23540b.get(i3) == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (this.f23539a.size() == 1) {
            this.f23539a.get(i2).setText("");
            return;
        }
        this.f23539a.remove(i2);
        this.f23540b.remove(i2);
        this.mLinearLayout.removeViewAt(i2);
    }
}
