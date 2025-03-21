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
public class AddSmsThreeFragment extends BaseFragment {

    /* renamed from: b */
    private CriminalSmsAddActivity f23774b;

    /* renamed from: c */
    private SmsPictureAdapter f23775c;

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

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_tip_picture)
    TextView mTvTipPicture;

    /* renamed from: a */
    private CriminalSmsBean f23773a = null;

    /* renamed from: d */
    private List<LocalMedia> f23776d = new ArrayList();

    /* renamed from: ui.fragment.AddSmsThreeFragment$a */
    class ViewOnTouchListenerC6843a implements View.OnTouchListener {
        ViewOnTouchListenerC6843a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsThreeFragment.this.mEtDescribe.setFocusable(true);
                AddSmsThreeFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsThreeFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    /* renamed from: ui.fragment.AddSmsThreeFragment$b */
    class C6844b implements SmsPictureAdapter.InterfaceC0074b {
        C6844b() {
        }

        @Override // adapter.SmsPictureAdapter.InterfaceC0074b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsThreeFragment.this.f23774b.onItemClickListener(i2, list);
        }
    }

    /* renamed from: ui.fragment.AddSmsThreeFragment$c */
    class C6845c implements BaseQuickAdapter.InterfaceC1895i {
        C6845c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsThreeFragment.this.f23774b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    /* renamed from: ui.fragment.AddSmsThreeFragment$d */
    class C6846d implements IClickListener {
        C6846d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AddSmsThreeFragment.this.f23774b.confirm(AddSmsThreeFragment.this.f23773a);
        }
    }

    /* renamed from: h */
    private void m25549h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f23776d;
        this.f23774b.getClass();
        this.f23775c = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, list, 6, this.f23774b.isOnlyShow());
        this.f23775c.m5103a(this.mRecyclerview);
        this.f23775c.setOnItemClickListener(new C6844b());
        this.f23775c.setOnItemChildClickListener(new C6845c());
        this.mRecyclerview.setAdapter(this.f23775c);
    }

    /* renamed from: i */
    private void m25550i() {
        this.mEtPhone.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f23776d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    /* renamed from: d */
    public CriminalSmsBean m25551d() {
        return this.f23773a;
    }

    /* renamed from: e */
    public List<LocalMedia> m25552e() {
        return this.f23776d;
    }

    /* renamed from: f */
    public void m25553f() {
        this.f23775c.notifyDataSetChanged();
    }

    /* renamed from: g */
    public void m25554g() {
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
        if (TextUtils.isEmpty(obj2)) {
            C7331w1.m26688a("请输入涉诈短信内容");
            return;
        }
        if (this.f23773a == null) {
            this.f23773a = new CriminalSmsBean();
        }
        this.f23773a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23773a.setSuspectMobile(obj);
        this.f23773a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f23773a.setContent(obj2);
        this.f23773a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23773a.setDeliveryTime(this.mTvTime.getText().toString());
        if (TextUtils.equals(obj, AccountManager.getVisiblePhone())) {
            C7257b1.m26184a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue, true, (IClickListener) new C6846d());
        } else {
            this.f23774b.confirm(this.f23773a);
        }
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_sms_imessage;
    }

    @Override // p388ui.fragment.BaseFragment
    public void initPage() {
        this.f23774b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new ViewOnTouchListenerC6843a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 3) {
                this.f23773a = criminalSmsBean;
            }
            if (this.f23773a != null) {
                String victimMobile = this.f23773a.getVictimMobile();
                String suspectMobile = this.f23773a.getSuspectMobile();
                String deliveryTime = this.f23773a.getDeliveryTime();
                String content = this.f23773a.getContent();
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
                List<SmsPictureBean> smsDetails = this.f23773a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f23776d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f23773a == null) {
            this.f23773a = new CriminalSmsBean();
            this.f23773a.setSmsType(3);
            this.f23773a.setSmsTypeText(this.f23774b.strs[2]);
        }
        this.f23774b.setChildBean(this.f23773a);
        m25549h();
        if (this.f23774b.isOnlyShow()) {
            m25550i();
        }
    }

    @OnClick({C2113R.id.tv_time, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            m25554g();
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            C7319s1.m26565a(this.mActivity, this.mTvTime);
        }
    }
}
