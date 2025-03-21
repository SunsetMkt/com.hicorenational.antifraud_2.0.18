package p388ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import p388ui.activity.CriminalSmsAddActivity;
import util.C7257b1;
import util.C7319s1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class AddSmsTwoFragment extends BaseFragment {

    /* renamed from: b */
    private CriminalSmsAddActivity f23789b;

    /* renamed from: c */
    private SmsPictureAdapter f23790c;

    @BindView(C2113R.id.confirm)
    TextView mBtnCommit;

    @BindView(C2113R.id.et_describe)
    EditText mEtDescribe;

    @BindView(C2113R.id.et_phone)
    EditText mEtPhone;

    @BindView(C2113R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(C2113R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_describe_label)
    TextView mTvDescribeLabel;

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_tip)
    TextView mTvTip;

    @BindView(C2113R.id.tv_tip_picture)
    TextView mTvTipPicture;

    /* renamed from: a */
    private CriminalSmsBean f23788a = null;

    /* renamed from: d */
    private List<LocalMedia> f23791d = new ArrayList();

    /* renamed from: ui.fragment.AddSmsTwoFragment$a */
    class ViewOnTouchListenerC6849a implements View.OnTouchListener {
        ViewOnTouchListenerC6849a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsTwoFragment.this.mEtDescribe.setFocusable(true);
                AddSmsTwoFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsTwoFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    /* renamed from: ui.fragment.AddSmsTwoFragment$b */
    class C6850b implements SmsPictureAdapter.InterfaceC0074b {
        C6850b() {
        }

        @Override // adapter.SmsPictureAdapter.InterfaceC0074b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsTwoFragment.this.f23789b.onItemClickListener(i2, list);
        }
    }

    /* renamed from: ui.fragment.AddSmsTwoFragment$c */
    class C6851c implements BaseQuickAdapter.InterfaceC1895i {
        C6851c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsTwoFragment.this.f23789b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    /* renamed from: ui.fragment.AddSmsTwoFragment$d */
    class C6852d implements IClickListener {
        C6852d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AddSmsTwoFragment.this.f23789b.confirm(AddSmsTwoFragment.this.f23788a);
        }
    }

    /* renamed from: h */
    private void m25557h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f23791d;
        this.f23789b.getClass();
        this.f23790c = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, list, 6, this.f23789b.isOnlyShow());
        this.f23790c.m5103a(this.mRecyclerview);
        this.f23790c.setOnItemClickListener(new C6850b());
        this.f23790c.setOnItemChildClickListener(new C6851c());
        this.mRecyclerview.setAdapter(this.f23790c);
    }

    /* renamed from: i */
    private void m25558i() {
        this.mEtPhone.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (TextUtils.isEmpty(this.f23788a.getContent())) {
            this.mTvTip.setVisibility(8);
            this.mTvDescribeLabel.setVisibility(8);
            this.mEtDescribe.setVisibility(8);
        } else {
            this.mEtDescribe.setEnabled(false);
        }
        if (this.f23791d.size() <= 0) {
            this.mTvTip.setVisibility(4);
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    /* renamed from: d */
    public void m25559d() {
        String obj = this.mEtPhone.getText().toString();
        String obj2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            C7331w1.m26688a("请输入接收短信号码");
            return;
        }
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入涉诈短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            C7331w1.m26688a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(obj2) && this.f23791d.size() <= 0) {
            C7331w1.m26688a("涉诈短信内容及上传彩信图片至少录入一项");
            return;
        }
        if (this.f23788a == null) {
            this.f23788a = new CriminalSmsBean();
        }
        this.f23788a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23788a.setSuspectMobile(obj);
        this.f23788a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f23788a.setContent(obj2);
        this.f23788a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23788a.setDeliveryTime(this.mTvTime.getText().toString());
        if (TextUtils.equals(obj, AccountManager.getVisiblePhone())) {
            C7257b1.m26184a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue, true, (IClickListener) new C6852d());
        } else {
            this.f23789b.confirm(this.f23788a);
        }
    }

    /* renamed from: e */
    public CriminalSmsBean m25560e() {
        return this.f23788a;
    }

    /* renamed from: f */
    public List<LocalMedia> m25561f() {
        return this.f23791d;
    }

    /* renamed from: g */
    public void m25562g() {
        this.f23790c.notifyDataSetChanged();
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_sms_multimedia;
    }

    @Override // p388ui.fragment.BaseFragment
    public void initPage() {
        this.f23789b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new ViewOnTouchListenerC6849a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 2) {
                this.f23788a = criminalSmsBean;
            }
            if (this.f23788a != null) {
                String victimMobile = this.f23788a.getVictimMobile();
                String suspectMobile = this.f23788a.getSuspectMobile();
                String deliveryTime = this.f23788a.getDeliveryTime();
                String content = this.f23788a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(suspectMobile)) {
                    this.mEtPhone.setText(suspectMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mEtDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.f23788a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f23791d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f23788a == null) {
            this.f23788a = new CriminalSmsBean();
            this.f23788a.setSmsType(2);
            this.f23788a.setSmsTypeText(this.f23789b.strs[1]);
        }
        this.f23789b.setChildBean(this.f23788a);
        m25557h();
        if (this.f23789b.isOnlyShow()) {
            m25558i();
        }
    }

    @OnClick({C2113R.id.tv_time, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            m25559d();
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            C7319s1.m26565a(this.mActivity, this.mTvTime);
        }
    }
}
