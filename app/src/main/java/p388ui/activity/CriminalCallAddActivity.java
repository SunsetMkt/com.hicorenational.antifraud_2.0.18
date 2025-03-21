package p388ui.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import bean.UploadFileBean;
import butterknife.BindView;
import com.hicorenational.antifraud.C2113R;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.tracker.C3773a;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p023b.p024a.p025a.p027e.C0918d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5560n1;
import p286h.p323z2.C5724b0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CriminalPhoneView;
import p388ui.presenter.CriminalPhonePresenter;
import p388ui.view.C7247w;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* compiled from: CriminalCallAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020\tH\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0014J\u0012\u0010D\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0007J\u0018\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020JH\u0016J\u0016\u0010K\u001a\u00020@2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020\u001aH\u0016J\u0010\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020%H\u0007J\u0006\u0010P\u001a\u00020@J\b\u0010Q\u001a\u00020@H\u0002J\b\u0010R\u001a\u00020,H\u0016J\b\u0010S\u001a\u00020@H\u0002J\b\u0010T\u001a\u00020@H\u0002J\b\u0010U\u001a\u00020@H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001e\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001e\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000f¨\u0006V"}, m23546d2 = {"Lui/activity/CriminalCallAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalPhoneView;", "()V", "CNATelList", "", "", "caseInfoId", "isEdit", "", "mAudioNum", "Landroid/widget/TextView;", "getMAudioNum", "()Landroid/widget/TextView;", "setMAudioNum", "(Landroid/widget/TextView;)V", "mAudios", "", "Lbean/UploadFileBean;", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mCallBean", "Lbean/CallBean;", "mEtPhone", "Landroid/widget/EditText;", "getMEtPhone", "()Landroid/widget/EditText;", "setMEtPhone", "(Landroid/widget/EditText;)V", "mEtVictimPhone", "getMEtVictimPhone", "setMEtVictimPhone", "mLlClause", "Landroid/view/View;", "getMLlClause", "()Landroid/view/View;", "setMLlClause", "(Landroid/view/View;)V", "mPhoneList", "mPosition", "", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvDuration", "getMTvDuration", "setMTvDuration", "mTvOccurTime", "getMTvOccurTime", "setMTvOccurTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "checkListRepeat", "editChangeListner", "", C3773a.f13769c, "initPage", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccess", "onSuccessSave", "bean", "onViewClicked", "view", "onkeyback", "saveHttpApi", "setLayoutView", "showData", "showDurationPiker", "showTimePiker", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalCallAddActivity extends BaseActivity implements CriminalPhoneView {
    private List<String> CNATelList;
    private boolean isEdit;

    @BindView(C2113R.id.tv_audio_num)
    @InterfaceC5816d
    public TextView mAudioNum;

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;
    private CallBean mCallBean;

    @BindView(C2113R.id.et_phone)
    @InterfaceC5816d
    public EditText mEtPhone;

    @BindView(C2113R.id.et_victim_phone)
    @InterfaceC5816d
    public EditText mEtVictimPhone;

    @BindView(C2113R.id.ll_clause)
    @InterfaceC5816d
    public View mLlClause;
    private CriminalPhonePresenter mPresenter;

    @BindView(C2113R.id.cb_select)
    @InterfaceC5816d
    public CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_duration)
    @InterfaceC5816d
    public TextView mTvDuration;

    @BindView(C2113R.id.tv_occur_time)
    @InterfaceC5816d
    public TextView mTvOccurTime;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private List<CallBean> mPhoneList = new ArrayList();
    private int mPosition = -1;
    private List<UploadFileBean> mAudios = new ArrayList();
    private String caseInfoId = "";

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$a */
    public static final class C6239a implements TextWatcher {
        C6239a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@InterfaceC5816d Editable editable) {
            C5544i0.m22546f(editable, C3351bh.f11580aE);
            if (C7337y1.m26759a(editable.toString(), (List<String>) CriminalCallAddActivity.this.CNATelList)) {
                View mLlClause = CriminalCallAddActivity.this.getMLlClause();
                if (mLlClause == null) {
                    C5544i0.m22545f();
                }
                mLlClause.setVisibility(0);
                return;
            }
            View mLlClause2 = CriminalCallAddActivity.this.getMLlClause();
            if (mLlClause2 == null) {
                C5544i0.m22545f();
            }
            mLlClause2.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$b */
    static final class C6240b implements CompoundButton.OnCheckedChangeListener {
        C6240b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(@InterfaceC5817e CompoundButton compoundButton, boolean z) {
            CheckBox mTCbSelect = CriminalCallAddActivity.this.getMTCbSelect();
            if (mTCbSelect == null) {
                C5544i0.m22545f();
            }
            mTCbSelect.setChecked(z);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$c */
    public static final class C6241c implements IClickListener {
        C6241c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CriminalCallAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$d */
    public static final class C6242d implements IClickListener {
        C6242d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalCallAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$e */
    static final class C6243e implements C7247w.l {
        C6243e() {
        }

        @Override // p388ui.view.C7247w.l
        /* renamed from: a */
        public final void mo25212a(String str, String str2, String str3) {
            int i2;
            int i3;
            String str4;
            int i4 = 0;
            try {
                C5544i0.m22521a((Object) str, "hour");
                i2 = Integer.parseInt(str);
                C5544i0.m22521a((Object) str2, "minute");
                i3 = Integer.parseInt(str2);
                C5544i0.m22521a((Object) str3, "second");
                i4 = Integer.parseInt(str3);
            } catch (Exception unused) {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > 0) {
                str4 = String.valueOf(i2) + "小时" + i3 + "分钟" + i4 + "秒";
            } else if (i3 > 0) {
                str4 = String.valueOf(i3) + "分钟" + i4 + "秒";
            } else {
                str4 = String.valueOf(i4) + "秒";
            }
            TextView mTvDuration = CriminalCallAddActivity.this.getMTvDuration();
            if (mTvDuration == null) {
                C5544i0.m22545f();
            }
            mTvDuration.setText(str4);
        }
    }

    /* compiled from: CriminalCallAddActivity.kt */
    /* renamed from: ui.activity.CriminalCallAddActivity$f */
    static final class C6244f implements C0918d.m {
        C6244f() {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public final void mo880a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView mTvOccurTime = CriminalCallAddActivity.this.getMTvOccurTime();
            if (mTvOccurTime == null) {
                C5544i0.m22545f();
            }
            mTvOccurTime.setText(str6);
        }
    }

    private final boolean checkListRepeat() {
        List<CallBean> list = this.mPhoneList;
        if (list != null) {
            if (list == null) {
                C5544i0.m22545f();
            }
            if (list.size() > 0) {
                List<CallBean> list2 = this.mPhoneList;
                if (list2 == null) {
                    C5544i0.m22545f();
                }
                int indexOf = list2.indexOf(this.mCallBean);
                int i2 = 0;
                while (true) {
                    List<CallBean> list3 = this.mPhoneList;
                    if (list3 == null) {
                        C5544i0.m22545f();
                    }
                    if (i2 < list3.size()) {
                        if (i2 != this.mPosition && i2 != indexOf) {
                            CallBean callBean = this.mCallBean;
                            if (callBean == null) {
                                C5544i0.m22545f();
                            }
                            String suspectMobile = callBean.getSuspectMobile();
                            List<CallBean> list4 = this.mPhoneList;
                            if (list4 == null) {
                                C5544i0.m22545f();
                            }
                            CallBean callBean2 = list4.get(i2);
                            if (callBean2 == null) {
                                C5544i0.m22545f();
                            }
                            if (C5544i0.m22531a((Object) suspectMobile, (Object) callBean2.getSuspectMobile())) {
                                CallBean callBean3 = this.mCallBean;
                                if (callBean3 == null) {
                                    C5544i0.m22545f();
                                }
                                String victimMobile = callBean3.getVictimMobile();
                                List<CallBean> list5 = this.mPhoneList;
                                if (list5 == null) {
                                    C5544i0.m22545f();
                                }
                                CallBean callBean4 = list5.get(i2);
                                if (callBean4 == null) {
                                    C5544i0.m22545f();
                                }
                                if (C5544i0.m22531a((Object) victimMobile, (Object) callBean4.getVictimMobile())) {
                                    CallBean callBean5 = this.mCallBean;
                                    if (callBean5 == null) {
                                        C5544i0.m22545f();
                                    }
                                    String callDuration = callBean5.getCallDuration();
                                    List<CallBean> list6 = this.mPhoneList;
                                    if (list6 == null) {
                                        C5544i0.m22545f();
                                    }
                                    CallBean callBean6 = list6.get(i2);
                                    if (callBean6 == null) {
                                        C5544i0.m22545f();
                                    }
                                    if (C5544i0.m22531a((Object) callDuration, (Object) callBean6.getCallDuration())) {
                                        CallBean callBean7 = this.mCallBean;
                                        if (callBean7 == null) {
                                            C5544i0.m22545f();
                                        }
                                        String talkTime = callBean7.getTalkTime();
                                        List<CallBean> list7 = this.mPhoneList;
                                        if (list7 == null) {
                                            C5544i0.m22545f();
                                        }
                                        CallBean callBean8 = list7.get(i2);
                                        if (callBean8 == null) {
                                            C5544i0.m22545f();
                                        }
                                        if (C5544i0.m22531a((Object) talkTime, (Object) callBean8.getTalkTime())) {
                                            C7331w1.m26688a("输入信息重复，请重新输入");
                                            return true;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                        i2++;
                    } else if (indexOf == -1 && this.mPosition == -1) {
                        List<CallBean> list8 = this.mPhoneList;
                        if (list8 == null) {
                            C5544i0.m22545f();
                        }
                        list8.add(this.mCallBean);
                    }
                }
            }
        }
        if (this.mPhoneList == null) {
            this.mPhoneList = new ArrayList();
        }
        List<CallBean> list9 = this.mPhoneList;
        if (list9 == null) {
            C5544i0.m22545f();
        }
        list9.add(this.mCallBean);
        return false;
    }

    private final void editChangeListner() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtPhone");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        editText.addTextChangedListener(new C6239a());
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        if (checkBox == null) {
            C5544i0.m22545f();
        }
        checkBox.setOnCheckedChangeListener(new C6240b());
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPhoneList = C5560n1.m22597d(getIntent().getSerializableExtra(C7292k1.f25391c));
        this.mPosition = getIntent().getIntExtra(C7292k1.f25397e, -1);
        List<CallBean> list = this.mPhoneList;
        if (list == null || this.mPosition < 0) {
            this.isEdit = false;
        } else {
            if (list == null) {
                C5544i0.m22545f();
            }
            this.mCallBean = list.get(this.mPosition);
            showData();
            this.isEdit = true;
        }
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("通话类嫌疑人电话详情");
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setText("添加");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            C5544i0.m22545f();
        }
        CallBean callBean = this.mCallBean;
        if (callBean == null) {
            C5544i0.m22545f();
        }
        criminalPhonePresenter.criminalCallSave(callBean);
    }

    private final void showData() {
        CallBean callBean = this.mCallBean;
        if (callBean != null) {
            if (callBean == null) {
                C5544i0.m22545f();
            }
            if (callBean.getIsInput() == 1) {
                EditText editText = this.mEtPhone;
                if (editText == null) {
                    C5544i0.m22554k("mEtPhone");
                }
                if (editText == null) {
                    C5544i0.m22545f();
                }
                editText.setFocusable(false);
                EditText editText2 = this.mEtPhone;
                if (editText2 == null) {
                    C5544i0.m22554k("mEtPhone");
                }
                if (editText2 == null) {
                    C5544i0.m22545f();
                }
                editText2.setTextColor(Color.parseColor("#999999"));
                TextView textView = this.mTvOccurTime;
                if (textView == null) {
                    C5544i0.m22554k("mTvOccurTime");
                }
                if (textView == null) {
                    C5544i0.m22545f();
                }
                textView.setEnabled(false);
                TextView textView2 = this.mTvOccurTime;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvOccurTime");
                }
                if (textView2 == null) {
                    C5544i0.m22545f();
                }
                textView2.setTextColor(Color.parseColor("#999999"));
                TextView textView3 = this.mTvDuration;
                if (textView3 == null) {
                    C5544i0.m22554k("mTvDuration");
                }
                if (textView3 == null) {
                    C5544i0.m22545f();
                }
                textView3.setEnabled(false);
                TextView textView4 = this.mTvDuration;
                if (textView4 == null) {
                    C5544i0.m22554k("mTvDuration");
                }
                if (textView4 == null) {
                    C5544i0.m22545f();
                }
                textView4.setTextColor(Color.parseColor("#999999"));
                TextView textView5 = this.mTvOccurTime;
                if (textView5 == null) {
                    C5544i0.m22554k("mTvOccurTime");
                }
                if (textView5 == null) {
                    C5544i0.m22545f();
                }
                textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView6 = this.mTvDuration;
                if (textView6 == null) {
                    C5544i0.m22554k("mTvDuration");
                }
                if (textView6 == null) {
                    C5544i0.m22545f();
                }
                textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                CallBean callBean2 = this.mCallBean;
                if (callBean2 == null) {
                    C5544i0.m22545f();
                }
                CallBean callBean3 = this.mCallBean;
                if (callBean3 == null) {
                    C5544i0.m22545f();
                }
                callBean2.setTalkTime(callBean3.getTalkTime());
            }
            EditText editText3 = this.mEtVictimPhone;
            if (editText3 == null) {
                C5544i0.m22554k("mEtVictimPhone");
            }
            if (editText3 == null) {
                C5544i0.m22545f();
            }
            CallBean callBean4 = this.mCallBean;
            if (callBean4 == null) {
                C5544i0.m22545f();
            }
            editText3.setText(callBean4.getVictimMobile());
            EditText editText4 = this.mEtPhone;
            if (editText4 == null) {
                C5544i0.m22554k("mEtPhone");
            }
            if (editText4 == null) {
                C5544i0.m22545f();
            }
            CallBean callBean5 = this.mCallBean;
            if (callBean5 == null) {
                C5544i0.m22545f();
            }
            editText4.setText(callBean5.getSuspectMobile());
            TextView textView7 = this.mTvOccurTime;
            if (textView7 == null) {
                C5544i0.m22554k("mTvOccurTime");
            }
            if (textView7 == null) {
                C5544i0.m22545f();
            }
            CallBean callBean6 = this.mCallBean;
            if (callBean6 == null) {
                C5544i0.m22545f();
            }
            textView7.setText(callBean6.getTalkTime());
            TextView textView8 = this.mTvDuration;
            if (textView8 == null) {
                C5544i0.m22554k("mTvDuration");
            }
            if (textView8 == null) {
                C5544i0.m22545f();
            }
            CallBean callBean7 = this.mCallBean;
            if (callBean7 == null) {
                C5544i0.m22545f();
            }
            textView8.setText(callBean7.getCallDuration());
            CallBean callBean8 = this.mCallBean;
            if (callBean8 == null) {
                C5544i0.m22545f();
            }
            if (callBean8.getCallTelDetails() != null) {
                CallBean callBean9 = this.mCallBean;
                if (callBean9 == null) {
                    C5544i0.m22545f();
                }
                List<UploadFileBean> callTelDetails = callBean9.getCallTelDetails();
                C5544i0.m22521a((Object) callTelDetails, "mCallBean!!.callTelDetails");
                this.mAudios = callTelDetails;
                List<UploadFileBean> list = this.mAudios;
                if (list == null) {
                    C5544i0.m22545f();
                }
                if (list.size() > 0) {
                    TextView textView9 = this.mAudioNum;
                    if (textView9 == null) {
                        C5544i0.m22554k("mAudioNum");
                    }
                    if (textView9 == null) {
                        C5544i0.m22545f();
                    }
                    StringBuilder sb = new StringBuilder();
                    List<UploadFileBean> list2 = this.mAudios;
                    if (list2 == null) {
                        C5544i0.m22545f();
                    }
                    sb.append(String.valueOf(list2.size()));
                    sb.append("条");
                    textView9.setText(sb.toString());
                    TextView textView10 = this.mAudioNum;
                    if (textView10 == null) {
                        C5544i0.m22554k("mAudioNum");
                    }
                    if (textView10 == null) {
                        C5544i0.m22545f();
                    }
                    textView10.setTextColor(Color.parseColor("#333333"));
                }
            }
            TextView textView11 = this.mTvTitle;
            if (textView11 == null) {
                C5544i0.m22554k("mTvTitle");
            }
            if (textView11 == null) {
                C5544i0.m22545f();
            }
            textView11.setText("诈骗电话详情");
            Button button = this.mBtnConfirm;
            if (button == null) {
                C5544i0.m22554k("mBtnConfirm");
            }
            if (button == null) {
                C5544i0.m22545f();
            }
            button.setText("添加");
            CallBean callBean10 = this.mCallBean;
            if (callBean10 == null) {
                C5544i0.m22545f();
            }
            if (callBean10.getSwindleTelTypeText() != null) {
                CallBean callBean11 = this.mCallBean;
                if (callBean11 == null) {
                    C5544i0.m22545f();
                }
                if (C5724b0.m23631c(callBean11.getSwindleTelTypeText(), "FaceTime", true)) {
                    View view = this.mLlClause;
                    if (view == null) {
                        C5544i0.m22554k("mLlClause");
                    }
                    if (view == null) {
                        C5544i0.m22545f();
                    }
                    view.setVisibility(0);
                    CheckBox checkBox = this.mTCbSelect;
                    if (checkBox == null) {
                        C5544i0.m22554k("mTCbSelect");
                    }
                    if (checkBox == null) {
                        C5544i0.m22545f();
                    }
                    checkBox.setChecked(true);
                }
            }
        }
    }

    private final void showDurationPiker() {
        C7247w c7247w = new C7247w(this, -1, 3);
        c7247w.m26112c(23, 59, 59);
        c7247w.m26108a(0, 0, 0, 0, 0);
        c7247w.setOnDateTimePickListener(new C6243e());
        c7247w.m1045m();
    }

    private final void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(this, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new C6244f());
        c0918d.m1045m();
    }

    @InterfaceC5816d
    public final TextView getMAudioNum() {
        TextView textView = this.mAudioNum;
        if (textView == null) {
            C5544i0.m22554k("mAudioNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        return button;
    }

    @InterfaceC5816d
    public final EditText getMEtPhone() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtVictimPhone() {
        EditText editText = this.mEtVictimPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtVictimPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final View getMLlClause() {
        View view = this.mLlClause;
        if (view == null) {
            C5544i0.m22554k("mLlClause");
        }
        return view;
    }

    @InterfaceC5816d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        return checkBox;
    }

    @InterfaceC5816d
    public final TextView getMTvDuration() {
        TextView textView = this.mTvDuration;
        if (textView == null) {
            C5544i0.m22554k("mTvDuration");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvOccurTime() {
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            C5544i0.m22554k("mTvOccurTime");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mPresenter = new CriminalPhonePresenter(this, this);
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            C5544i0.m22545f();
        }
        criminalPhonePresenter.getCriminakTel();
        editChangeListner();
        initData();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@InterfaceC5817e C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 4) {
            return;
        }
        List<UploadFileBean> list = this.mAudios;
        if (list != null) {
            list.clear();
        }
        TextView textView = this.mAudioNum;
        if (textView == null) {
            C5544i0.m22554k("mAudioNum");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("请选择");
        TextView textView2 = this.mAudioNum;
        if (textView2 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setTextColor(Color.parseColor("#cccccc"));
        ArrayList arrayList = (ArrayList) c7265a.m26300b();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        List<UploadFileBean> list2 = this.mAudios;
        if (list2 == null) {
            C5544i0.m22545f();
        }
        list2.addAll(arrayList);
        TextView textView3 = this.mAudioNum;
        if (textView3 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        if (textView3 == null) {
            C5544i0.m22545f();
        }
        StringBuilder sb = new StringBuilder();
        List<UploadFileBean> list3 = this.mAudios;
        if (list3 == null) {
            C5544i0.m22545f();
        }
        sb.append(String.valueOf(list3.size()));
        sb.append("条");
        textView3.setText(sb.toString());
        TextView textView4 = this.mAudioNum;
        if (textView4 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        if (textView4 == null) {
            C5544i0.m22545f();
        }
        textView4.setTextColor(Color.parseColor("#333333"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccess(@InterfaceC5816d List<String> list) {
        C5544i0.m22546f(list, "CNATelList");
        this.CNATelList = list;
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessList(@InterfaceC5816d List<? extends CallBean> list) {
        C5544i0.m22546f(list, "callBeans");
        CriminalPhoneView.C6814a.m25458b(this, list);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean) {
        C5544i0.m22546f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.C6814a.m25456a(this, criminalPhoneNumBean);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.C6814a.m25454a(this);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessSave(@InterfaceC5816d CallBean callBean) {
        C5544i0.m22546f(callBean, "bean");
        CallBean callBean2 = this.mCallBean;
        if (callBean2 != null) {
            if (callBean2 == null) {
                C5544i0.m22545f();
            }
            if (!TextUtils.isEmpty(callBean2.getCallTelInfoID())) {
                C7331w1.m26688a("修改成功");
                finish();
            }
        }
        C7331w1.m26688a("添加成功");
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0230  */
    @butterknife.OnClick({com.hicorenational.antifraud.C2113R.id.iv_back, com.hicorenational.antifraud.C2113R.id.tv_occur_time, com.hicorenational.antifraud.C2113R.id.tv_duration, com.hicorenational.antifraud.C2113R.id.tv_audio_num, com.hicorenational.antifraud.C2113R.id.btn_confirm})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewClicked(@p324i.p336c.p337a.InterfaceC5816d android.view.View r9) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.CriminalCallAddActivity.onViewClicked(android.view.View):void");
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6242d());
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_criminal_add;
    }

    public final void setMAudioNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mAudioNum = textView;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtPhone = editText;
    }

    public final void setMEtVictimPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtVictimPhone = editText;
    }

    public final void setMLlClause(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlClause = view;
    }

    public final void setMTCbSelect(@InterfaceC5816d CheckBox checkBox) {
        C5544i0.m22546f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvDuration(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvDuration = textView;
    }

    public final void setMTvOccurTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvOccurTime = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
