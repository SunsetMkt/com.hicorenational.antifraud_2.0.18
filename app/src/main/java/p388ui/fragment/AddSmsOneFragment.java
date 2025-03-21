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
public class AddSmsOneFragment extends BaseFragment {

    /* renamed from: b */
    private CriminalSmsAddActivity f23759b;

    /* renamed from: c */
    private SmsPictureAdapter f23760c;

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
    private CriminalSmsBean f23758a = null;

    /* renamed from: d */
    private List<LocalMedia> f23761d = new ArrayList();

    /* renamed from: ui.fragment.AddSmsOneFragment$a */
    class ViewOnTouchListenerC6837a implements View.OnTouchListener {
        ViewOnTouchListenerC6837a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsOneFragment.this.mEtDescribe.setFocusable(true);
                AddSmsOneFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsOneFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    /* renamed from: ui.fragment.AddSmsOneFragment$b */
    class C6838b implements SmsPictureAdapter.InterfaceC0074b {
        C6838b() {
        }

        @Override // adapter.SmsPictureAdapter.InterfaceC0074b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsOneFragment.this.f23759b.onItemClickListener(i2, list);
        }
    }

    /* renamed from: ui.fragment.AddSmsOneFragment$c */
    class C6839c implements BaseQuickAdapter.InterfaceC1895i {
        C6839c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsOneFragment.this.f23759b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    /* renamed from: ui.fragment.AddSmsOneFragment$d */
    class C6840d implements IClickListener {
        C6840d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AddSmsOneFragment.this.f23759b.confirm(AddSmsOneFragment.this.f23758a);
        }
    }

    /* renamed from: h */
    private void m25541h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f23761d;
        this.f23759b.getClass();
        this.f23760c = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, list, 6, this.f23759b.isOnlyShow());
        this.f23760c.m5103a(this.mRecyclerview);
        this.f23760c.setOnItemClickListener(new C6838b());
        this.f23760c.setOnItemChildClickListener(new C6839c());
        this.mRecyclerview.setAdapter(this.f23760c);
    }

    /* renamed from: i */
    private void m25542i() {
        this.mEtPhone.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f23761d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    /* renamed from: d */
    public void m25543d() {
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
        if (this.f23758a == null) {
            this.f23758a = new CriminalSmsBean();
        }
        this.f23758a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23758a.setSuspectMobile(obj);
        this.f23758a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f23758a.setContent(obj2);
        this.f23758a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23758a.setDeliveryTime(this.mTvTime.getText().toString());
        if (TextUtils.equals(obj, AccountManager.getVisiblePhone())) {
            C7257b1.m26184a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue, true, (IClickListener) new C6840d());
        } else {
            this.f23759b.confirm(this.f23758a);
        }
    }

    /* renamed from: e */
    public CriminalSmsBean m25544e() {
        return this.f23758a;
    }

    /* renamed from: f */
    public List<LocalMedia> m25545f() {
        return this.f23761d;
    }

    /* renamed from: g */
    public void m25546g() {
        this.f23760c.notifyDataSetChanged();
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_sms;
    }

    @Override // p388ui.fragment.BaseFragment
    public void initPage() {
        this.f23759b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new ViewOnTouchListenerC6837a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 1) {
                this.f23758a = criminalSmsBean;
            }
            if (this.f23758a != null) {
                String victimMobile = this.f23758a.getVictimMobile();
                String suspectMobile = this.f23758a.getSuspectMobile();
                String deliveryTime = this.f23758a.getDeliveryTime();
                String content = this.f23758a.getContent();
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
                List<SmsPictureBean> smsDetails = this.f23758a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f23761d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f23758a == null) {
            this.f23758a = new CriminalSmsBean();
            this.f23758a.setSmsType(1);
            this.f23758a.setSmsTypeText(this.f23759b.strs[0]);
        }
        this.f23759b.setChildBean(this.f23758a);
        m25541h();
        if (this.f23759b.isOnlyShow()) {
            m25542i();
        }
    }

    @OnClick({C2113R.id.tv_time, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            m25543d();
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            C7319s1.m26565a(this.mActivity, this.mTvTime);
        }
    }
}
