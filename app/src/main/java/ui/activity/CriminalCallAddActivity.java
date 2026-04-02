package ui.activity;

import android.content.Intent;
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
import butterknife.OnClick;
import c.a.a.e.d;
import com.hicorenational.antifraud.R;
import com.umeng.analytics.pro.bh;
import interfaces.IClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import manager.AccountManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.CriminalPhoneView;
import ui.presenter.CriminalPhonePresenter;
import ui.view.y;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: CriminalCallAddActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020\tH\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0014J\u0012\u0010D\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0007J\u0018\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020JH\u0016J\u0016\u0010K\u001a\u00020@2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020\u001aH\u0016J\u0010\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020%H\u0007J\u0006\u0010P\u001a\u00020@J\b\u0010Q\u001a\u00020@H\u0002J\b\u0010R\u001a\u00020,H\u0016J\b\u0010S\u001a\u00020@H\u0002J\b\u0010T\u001a\u00020@H\u0002J\b\u0010U\u001a\u00020@H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001e\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001e\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000f\u00a8\u0006V"}, d2 = {"Lui/activity/CriminalCallAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalPhoneView;", "()V", "CNATelList", "", "", "caseInfoId", "isEdit", "", "mAudioNum", "Landroid/widget/TextView;", "getMAudioNum", "()Landroid/widget/TextView;", "setMAudioNum", "(Landroid/widget/TextView;)V", "mAudios", "", "Lbean/UploadFileBean;", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mCallBean", "Lbean/CallBean;", "mEtPhone", "Landroid/widget/EditText;", "getMEtPhone", "()Landroid/widget/EditText;", "setMEtPhone", "(Landroid/widget/EditText;)V", "mEtVictimPhone", "getMEtVictimPhone", "setMEtVictimPhone", "mLlClause", "Landroid/view/View;", "getMLlClause", "()Landroid/view/View;", "setMLlClause", "(Landroid/view/View;)V", "mPhoneList", "mPosition", "", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvDuration", "getMTvDuration", "setMTvDuration", "mTvOccurTime", "getMTvOccurTime", "setMTvOccurTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "checkListRepeat", "editChangeListner", "", com.umeng.socialize.tracker.a.f8365c, "initPage", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccess", "onSuccessSave", "bean", "onViewClicked", "view", "onkeyback", "saveHttpApi", "setLayoutView", "showData", "showDurationPiker", "showTimePiker", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class CriminalCallAddActivity extends BaseActivity implements CriminalPhoneView {
    private List<String> CNATelList;
    private boolean isEdit;

    @BindView(R.id.tv_audio_num)
    @j.c.a.d
    public TextView mAudioNum;

    @BindView(R.id.btn_confirm)
    @j.c.a.d
    public Button mBtnConfirm;
    private CallBean mCallBean;

    @BindView(R.id.et_phone)
    @j.c.a.d
    public EditText mEtPhone;

    @BindView(R.id.et_victim_phone)
    @j.c.a.d
    public EditText mEtVictimPhone;

    @BindView(R.id.ll_clause)
    @j.c.a.d
    public View mLlClause;
    private CriminalPhonePresenter mPresenter;

    @BindView(R.id.cb_select)
    @j.c.a.d
    public CheckBox mTCbSelect;

    @BindView(R.id.tv_duration)
    @j.c.a.d
    public TextView mTvDuration;

    @BindView(R.id.tv_occur_time)
    @j.c.a.d
    public TextView mTvOccurTime;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private List<CallBean> mPhoneList = new ArrayList();
    private int mPosition = -1;
    private List<UploadFileBean> mAudios = new ArrayList();
    private String caseInfoId = "";

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@j.c.a.d Editable editable) {
            i.q2.t.i0.f(editable, bh.aE);
            if (g2.a(editable.toString(), (List<String>) CriminalCallAddActivity.this.CNATelList)) {
                View mLlClause = CriminalCallAddActivity.this.getMLlClause();
                if (mLlClause == null) {
                    i.q2.t.i0.f();
                }
                mLlClause.setVisibility(0);
                return;
            }
            View mLlClause2 = CriminalCallAddActivity.this.getMLlClause();
            if (mLlClause2 == null) {
                i.q2.t.i0.f();
            }
            mLlClause2.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@j.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            i.q2.t.i0.f(charSequence, bh.aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@j.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            i.q2.t.i0.f(charSequence, bh.aE);
        }
    }

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    static final class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(@j.c.a.e CompoundButton compoundButton, boolean z) {
            CheckBox mTCbSelect = CriminalCallAddActivity.this.getMTCbSelect();
            if (mTCbSelect == null) {
                i.q2.t.i0.f();
            }
            mTCbSelect.setChecked(z);
        }
    }

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    public static final class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CriminalCallAddActivity.this.saveHttpApi();
        }
    }

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalCallAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    static final class e implements y.l {
        e() {
        }

        @Override // ui.view.y.l
        public final void a(String str, String str2, String str3) {
            int i2;
            int i3;
            String str4;
            int i4 = 0;
            try {
                i.q2.t.i0.a((Object) str, "hour");
                i2 = Integer.parseInt(str);
                i.q2.t.i0.a((Object) str2, "minute");
                i3 = Integer.parseInt(str2);
                i.q2.t.i0.a((Object) str3, "second");
                i4 = Integer.parseInt(str3);
            } catch (Exception unused) {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > 0) {
                str4 = String.valueOf(i2) + "\u5c0f\u65f6" + i3 + "\u5206\u949f" + i4 + "\u79d2";
            } else if (i3 > 0) {
                str4 = String.valueOf(i3) + "\u5206\u949f" + i4 + "\u79d2";
            } else {
                str4 = String.valueOf(i4) + "\u79d2";
            }
            TextView mTvDuration = CriminalCallAddActivity.this.getMTvDuration();
            if (mTvDuration == null) {
                i.q2.t.i0.f();
            }
            mTvDuration.setText(str4);
        }
    }

    /* JADX INFO: compiled from: CriminalCallAddActivity.kt */
    static final class f implements d.m {
        f() {
        }

        @Override // c.a.a.e.d.m
        public final void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView mTvOccurTime = CriminalCallAddActivity.this.getMTvOccurTime();
            if (mTvOccurTime == null) {
                i.q2.t.i0.f();
            }
            mTvOccurTime.setText(str6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean checkListRepeat() {
        List<CallBean> list = this.mPhoneList;
        if (list == null) {
            if (this.mPhoneList == null) {
                this.mPhoneList = new ArrayList();
            }
            List<CallBean> list2 = this.mPhoneList;
            if (list2 == null) {
                i.q2.t.i0.f();
            }
            list2.add(this.mCallBean);
        } else {
            if (list == null) {
                i.q2.t.i0.f();
            }
            if (list.size() > 0) {
                List<CallBean> list3 = this.mPhoneList;
                if (list3 == null) {
                    i.q2.t.i0.f();
                }
                int iIndexOf = list3.indexOf(this.mCallBean);
                int i2 = 0;
                while (true) {
                    List<CallBean> list4 = this.mPhoneList;
                    if (list4 == null) {
                        i.q2.t.i0.f();
                    }
                    if (i2 < list4.size()) {
                        if (i2 != this.mPosition && i2 != iIndexOf) {
                            CallBean callBean = this.mCallBean;
                            if (callBean == null) {
                                i.q2.t.i0.f();
                            }
                            String suspectMobile = callBean.getSuspectMobile();
                            List<CallBean> list5 = this.mPhoneList;
                            if (list5 == null) {
                                i.q2.t.i0.f();
                            }
                            CallBean callBean2 = list5.get(i2);
                            if (callBean2 == null) {
                                i.q2.t.i0.f();
                            }
                            if (i.q2.t.i0.a((Object) suspectMobile, (Object) callBean2.getSuspectMobile())) {
                                CallBean callBean3 = this.mCallBean;
                                if (callBean3 == null) {
                                    i.q2.t.i0.f();
                                }
                                String victimMobile = callBean3.getVictimMobile();
                                List<CallBean> list6 = this.mPhoneList;
                                if (list6 == null) {
                                    i.q2.t.i0.f();
                                }
                                CallBean callBean4 = list6.get(i2);
                                if (callBean4 == null) {
                                    i.q2.t.i0.f();
                                }
                                if (i.q2.t.i0.a((Object) victimMobile, (Object) callBean4.getVictimMobile())) {
                                    CallBean callBean5 = this.mCallBean;
                                    if (callBean5 == null) {
                                        i.q2.t.i0.f();
                                    }
                                    String callDuration = callBean5.getCallDuration();
                                    List<CallBean> list7 = this.mPhoneList;
                                    if (list7 == null) {
                                        i.q2.t.i0.f();
                                    }
                                    CallBean callBean6 = list7.get(i2);
                                    if (callBean6 == null) {
                                        i.q2.t.i0.f();
                                    }
                                    if (i.q2.t.i0.a((Object) callDuration, (Object) callBean6.getCallDuration())) {
                                        CallBean callBean7 = this.mCallBean;
                                        if (callBean7 == null) {
                                            i.q2.t.i0.f();
                                        }
                                        String talkTime = callBean7.getTalkTime();
                                        List<CallBean> list8 = this.mPhoneList;
                                        if (list8 == null) {
                                            i.q2.t.i0.f();
                                        }
                                        CallBean callBean8 = list8.get(i2);
                                        if (callBean8 == null) {
                                            i.q2.t.i0.f();
                                        }
                                        if (i.q2.t.i0.a((Object) talkTime, (Object) callBean8.getTalkTime())) {
                                            e2.a("\u8f93\u5165\u4fe1\u606f\u91cd\u590d\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
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
                    } else if (iIndexOf == -1 && this.mPosition == -1) {
                        List<CallBean> list9 = this.mPhoneList;
                        if (list9 == null) {
                            i.q2.t.i0.f();
                        }
                        list9.add(this.mCallBean);
                    }
                }
            }
        }
        return false;
    }

    private final void editChangeListner() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            i.q2.t.i0.k("mEtPhone");
        }
        if (editText == null) {
            i.q2.t.i0.f();
        }
        editText.addTextChangedListener(new a());
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            i.q2.t.i0.k("mTCbSelect");
        }
        if (checkBox == null) {
            i.q2.t.i0.f();
        }
        checkBox.setOnCheckedChangeListener(new b());
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPhoneList = i.q2.t.n1.d(getIntent().getSerializableExtra(util.p1.f15011c));
        this.mPosition = getIntent().getIntExtra(util.p1.f15013e, -1);
        List<CallBean> list = this.mPhoneList;
        if (list == null || this.mPosition < 0) {
            this.isEdit = false;
        } else {
            if (list == null) {
                i.q2.t.i0.f();
            }
            this.mCallBean = list.get(this.mPosition);
            showData();
            this.isEdit = true;
        }
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u901a\u8bdd\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd\u8be6\u60c5");
        Button button = this.mBtnConfirm;
        if (button == null) {
            i.q2.t.i0.k("mBtnConfirm");
        }
        if (button == null) {
            i.q2.t.i0.f();
        }
        button.setText("\u6dfb\u52a0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            i.q2.t.i0.f();
        }
        CallBean callBean = this.mCallBean;
        if (callBean == null) {
            i.q2.t.i0.f();
        }
        criminalPhonePresenter.criminalCallSave(callBean);
    }

    private final void showData() {
        CallBean callBean = this.mCallBean;
        if (callBean != null) {
            if (callBean == null) {
                i.q2.t.i0.f();
            }
            if (callBean.getIsInput() == 1) {
                EditText editText = this.mEtPhone;
                if (editText == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText == null) {
                    i.q2.t.i0.f();
                }
                editText.setFocusable(false);
                EditText editText2 = this.mEtPhone;
                if (editText2 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText2 == null) {
                    i.q2.t.i0.f();
                }
                editText2.setTextColor(Color.parseColor("#999999"));
                TextView textView = this.mTvOccurTime;
                if (textView == null) {
                    i.q2.t.i0.k("mTvOccurTime");
                }
                if (textView == null) {
                    i.q2.t.i0.f();
                }
                textView.setEnabled(false);
                TextView textView2 = this.mTvOccurTime;
                if (textView2 == null) {
                    i.q2.t.i0.k("mTvOccurTime");
                }
                if (textView2 == null) {
                    i.q2.t.i0.f();
                }
                textView2.setTextColor(Color.parseColor("#999999"));
                TextView textView3 = this.mTvDuration;
                if (textView3 == null) {
                    i.q2.t.i0.k("mTvDuration");
                }
                if (textView3 == null) {
                    i.q2.t.i0.f();
                }
                textView3.setEnabled(false);
                TextView textView4 = this.mTvDuration;
                if (textView4 == null) {
                    i.q2.t.i0.k("mTvDuration");
                }
                if (textView4 == null) {
                    i.q2.t.i0.f();
                }
                textView4.setTextColor(Color.parseColor("#999999"));
                TextView textView5 = this.mTvOccurTime;
                if (textView5 == null) {
                    i.q2.t.i0.k("mTvOccurTime");
                }
                if (textView5 == null) {
                    i.q2.t.i0.f();
                }
                textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView6 = this.mTvDuration;
                if (textView6 == null) {
                    i.q2.t.i0.k("mTvDuration");
                }
                if (textView6 == null) {
                    i.q2.t.i0.f();
                }
                textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                CallBean callBean2 = this.mCallBean;
                if (callBean2 == null) {
                    i.q2.t.i0.f();
                }
                CallBean callBean3 = this.mCallBean;
                if (callBean3 == null) {
                    i.q2.t.i0.f();
                }
                callBean2.setTalkTime(callBean3.getTalkTime());
            }
            EditText editText3 = this.mEtVictimPhone;
            if (editText3 == null) {
                i.q2.t.i0.k("mEtVictimPhone");
            }
            if (editText3 == null) {
                i.q2.t.i0.f();
            }
            CallBean callBean4 = this.mCallBean;
            if (callBean4 == null) {
                i.q2.t.i0.f();
            }
            editText3.setText(callBean4.getVictimMobile());
            EditText editText4 = this.mEtPhone;
            if (editText4 == null) {
                i.q2.t.i0.k("mEtPhone");
            }
            if (editText4 == null) {
                i.q2.t.i0.f();
            }
            CallBean callBean5 = this.mCallBean;
            if (callBean5 == null) {
                i.q2.t.i0.f();
            }
            editText4.setText(callBean5.getSuspectMobile());
            TextView textView7 = this.mTvOccurTime;
            if (textView7 == null) {
                i.q2.t.i0.k("mTvOccurTime");
            }
            if (textView7 == null) {
                i.q2.t.i0.f();
            }
            CallBean callBean6 = this.mCallBean;
            if (callBean6 == null) {
                i.q2.t.i0.f();
            }
            textView7.setText(callBean6.getTalkTime());
            TextView textView8 = this.mTvDuration;
            if (textView8 == null) {
                i.q2.t.i0.k("mTvDuration");
            }
            if (textView8 == null) {
                i.q2.t.i0.f();
            }
            CallBean callBean7 = this.mCallBean;
            if (callBean7 == null) {
                i.q2.t.i0.f();
            }
            textView8.setText(callBean7.getCallDuration());
            CallBean callBean8 = this.mCallBean;
            if (callBean8 == null) {
                i.q2.t.i0.f();
            }
            if (callBean8.getCallTelDetails() != null) {
                CallBean callBean9 = this.mCallBean;
                if (callBean9 == null) {
                    i.q2.t.i0.f();
                }
                List<UploadFileBean> callTelDetails = callBean9.getCallTelDetails();
                i.q2.t.i0.a((Object) callTelDetails, "mCallBean!!.callTelDetails");
                this.mAudios = callTelDetails;
                List<UploadFileBean> list = this.mAudios;
                if (list == null) {
                    i.q2.t.i0.f();
                }
                if (list.size() > 0) {
                    TextView textView9 = this.mAudioNum;
                    if (textView9 == null) {
                        i.q2.t.i0.k("mAudioNum");
                    }
                    if (textView9 == null) {
                        i.q2.t.i0.f();
                    }
                    StringBuilder sb = new StringBuilder();
                    List<UploadFileBean> list2 = this.mAudios;
                    if (list2 == null) {
                        i.q2.t.i0.f();
                    }
                    sb.append(String.valueOf(list2.size()));
                    sb.append("\u6761");
                    textView9.setText(sb.toString());
                    TextView textView10 = this.mAudioNum;
                    if (textView10 == null) {
                        i.q2.t.i0.k("mAudioNum");
                    }
                    if (textView10 == null) {
                        i.q2.t.i0.f();
                    }
                    textView10.setTextColor(Color.parseColor("#333333"));
                }
            }
            TextView textView11 = this.mTvTitle;
            if (textView11 == null) {
                i.q2.t.i0.k("mTvTitle");
            }
            if (textView11 == null) {
                i.q2.t.i0.f();
            }
            textView11.setText("\u8bc8\u9a97\u7535\u8bdd\u8be6\u60c5");
            Button button = this.mBtnConfirm;
            if (button == null) {
                i.q2.t.i0.k("mBtnConfirm");
            }
            if (button == null) {
                i.q2.t.i0.f();
            }
            button.setText("\u6dfb\u52a0");
            CallBean callBean10 = this.mCallBean;
            if (callBean10 == null) {
                i.q2.t.i0.f();
            }
            if (callBean10.getSwindleTelTypeText() != null) {
                CallBean callBean11 = this.mCallBean;
                if (callBean11 == null) {
                    i.q2.t.i0.f();
                }
                if (i.z2.b0.c(callBean11.getSwindleTelTypeText(), "FaceTime", true)) {
                    View view = this.mLlClause;
                    if (view == null) {
                        i.q2.t.i0.k("mLlClause");
                    }
                    if (view == null) {
                        i.q2.t.i0.f();
                    }
                    view.setVisibility(0);
                    CheckBox checkBox = this.mTCbSelect;
                    if (checkBox == null) {
                        i.q2.t.i0.k("mTCbSelect");
                    }
                    if (checkBox == null) {
                        i.q2.t.i0.f();
                    }
                    checkBox.setChecked(true);
                }
            }
        }
    }

    private final void showDurationPiker() {
        ui.view.y yVar = new ui.view.y(this, -1, 3);
        yVar.c(23, 59, 59);
        yVar.a(0, 0, 0, 0, 0);
        yVar.setOnDateTimePickListener(new e());
        yVar.m();
    }

    private final void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        c.a.a.e.d dVar = new c.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new f());
        dVar.m();
    }

    @j.c.a.d
    public final TextView getMAudioNum() {
        TextView textView = this.mAudioNum;
        if (textView == null) {
            i.q2.t.i0.k("mAudioNum");
        }
        return textView;
    }

    @j.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            i.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @j.c.a.d
    public final EditText getMEtPhone() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            i.q2.t.i0.k("mEtPhone");
        }
        return editText;
    }

    @j.c.a.d
    public final EditText getMEtVictimPhone() {
        EditText editText = this.mEtVictimPhone;
        if (editText == null) {
            i.q2.t.i0.k("mEtVictimPhone");
        }
        return editText;
    }

    @j.c.a.d
    public final View getMLlClause() {
        View view = this.mLlClause;
        if (view == null) {
            i.q2.t.i0.k("mLlClause");
        }
        return view;
    }

    @j.c.a.d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            i.q2.t.i0.k("mTCbSelect");
        }
        return checkBox;
    }

    @j.c.a.d
    public final TextView getMTvDuration() {
        TextView textView = this.mTvDuration;
        if (textView == null) {
            i.q2.t.i0.k("mTvDuration");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvOccurTime() {
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            i.q2.t.i0.k("mTvOccurTime");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mPresenter = new CriminalPhonePresenter(this, this);
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            i.q2.t.i0.f();
        }
        criminalPhonePresenter.getCriminakTel();
        editChangeListner();
        initData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@j.c.a.e util.n2.a aVar) {
        if (aVar == null || aVar.a() != 4) {
            return;
        }
        List<UploadFileBean> list = this.mAudios;
        if (list != null) {
            list.clear();
        }
        TextView textView = this.mAudioNum;
        if (textView == null) {
            i.q2.t.i0.k("mAudioNum");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u8bf7\u9009\u62e9");
        TextView textView2 = this.mAudioNum;
        if (textView2 == null) {
            i.q2.t.i0.k("mAudioNum");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setTextColor(Color.parseColor("#cccccc"));
        ArrayList arrayList = (ArrayList) aVar.b();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        List<UploadFileBean> list2 = this.mAudios;
        if (list2 == null) {
            i.q2.t.i0.f();
        }
        list2.addAll(arrayList);
        TextView textView3 = this.mAudioNum;
        if (textView3 == null) {
            i.q2.t.i0.k("mAudioNum");
        }
        if (textView3 == null) {
            i.q2.t.i0.f();
        }
        StringBuilder sb = new StringBuilder();
        List<UploadFileBean> list3 = this.mAudios;
        if (list3 == null) {
            i.q2.t.i0.f();
        }
        sb.append(String.valueOf(list3.size()));
        sb.append("\u6761");
        textView3.setText(sb.toString());
        TextView textView4 = this.mAudioNum;
        if (textView4 == null) {
            i.q2.t.i0.k("mAudioNum");
        }
        if (textView4 == null) {
            i.q2.t.i0.f();
        }
        textView4.setTextColor(Color.parseColor("#333333"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @j.c.a.d KeyEvent keyEvent) {
        i.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccess(@j.c.a.d List<String> list) {
        i.q2.t.i0.f(list, "CNATelList");
        this.CNATelList = list;
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessList(@j.c.a.d List<? extends CallBean> list) {
        i.q2.t.i0.f(list, "callBeans");
        CriminalPhoneView.a.b(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@j.c.a.d CriminalPhoneNumBean criminalPhoneNumBean) {
        i.q2.t.i0.f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.a.a(this, criminalPhoneNumBean);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.a.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    @Override // ui.callview.CriminalPhoneView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccessSave(@j.c.a.d CallBean callBean) {
        i.q2.t.i0.f(callBean, "bean");
        CallBean callBean2 = this.mCallBean;
        if (callBean2 == null) {
            e2.a("\u6dfb\u52a0\u6210\u529f");
        } else {
            if (callBean2 == null) {
                i.q2.t.i0.f();
            }
            if (!TextUtils.isEmpty(callBean2.getCallTelInfoID())) {
                e2.a("\u4fee\u6539\u6210\u529f");
            }
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0230  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @OnClick({R.id.iv_back, R.id.tv_occur_time, R.id.tv_duration, R.id.tv_audio_num, R.id.btn_confirm})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onViewClicked(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        i.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_confirm /* 2131296408 */:
                EditText editText = this.mEtVictimPhone;
                if (editText == null) {
                    i.q2.t.i0.k("mEtVictimPhone");
                }
                if (editText == null) {
                    i.q2.t.i0.f();
                }
                if (editText.length() == 0) {
                    e2.a("\u8bf7\u8f93\u5165\u53d7\u5bb3\u4eba\u7535\u8bdd");
                    return;
                }
                EditText editText2 = this.mEtPhone;
                if (editText2 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText2 == null) {
                    i.q2.t.i0.f();
                }
                if (editText2.length() == 0) {
                    e2.a("\u8bf7\u8f93\u5165\u8bc8\u9a97\u7535\u8bdd");
                    return;
                }
                TextView textView = this.mTvOccurTime;
                if (textView == null) {
                    i.q2.t.i0.k("mTvOccurTime");
                }
                if (textView == null) {
                    i.q2.t.i0.f();
                }
                if (textView.length() == 0) {
                    e2.a("\u8bf7\u9009\u62e9\u901a\u8bdd\u65f6\u95f4");
                    return;
                }
                TextView textView2 = this.mTvDuration;
                if (textView2 == null) {
                    i.q2.t.i0.k("mTvDuration");
                }
                if (textView2 == null) {
                    i.q2.t.i0.f();
                }
                if (textView2.length() == 0) {
                    e2.a("\u8bf7\u9009\u62e9\u901a\u8bdd\u65f6\u957f");
                    return;
                }
                if (this.mCallBean == null) {
                    this.mCallBean = new CallBean();
                    CallBean callBean = this.mCallBean;
                    if (callBean == null) {
                        i.q2.t.i0.f();
                    }
                    callBean.setIsInput(0);
                }
                CallBean callBean2 = this.mCallBean;
                if (callBean2 == null) {
                    i.q2.t.i0.f();
                }
                callBean2.setCaseInfoID(this.caseInfoId);
                CallBean callBean3 = this.mCallBean;
                if (callBean3 == null) {
                    i.q2.t.i0.f();
                }
                EditText editText3 = this.mEtVictimPhone;
                if (editText3 == null) {
                    i.q2.t.i0.k("mEtVictimPhone");
                }
                if (editText3 == null) {
                    i.q2.t.i0.f();
                }
                callBean3.setVictimMobile(editText3.getText().toString());
                CallBean callBean4 = this.mCallBean;
                if (callBean4 == null) {
                    i.q2.t.i0.f();
                }
                EditText editText4 = this.mEtPhone;
                if (editText4 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText4 == null) {
                    i.q2.t.i0.f();
                }
                callBean4.setSuspectMobile(editText4.getText().toString());
                CallBean callBean5 = this.mCallBean;
                if (callBean5 == null) {
                    i.q2.t.i0.f();
                }
                CheckBox checkBox = this.mTCbSelect;
                if (checkBox == null) {
                    i.q2.t.i0.k("mTCbSelect");
                }
                if (checkBox == null) {
                    i.q2.t.i0.f();
                }
                callBean5.setIsCheck(checkBox.isChecked() ? 1 : 0);
                CallBean callBean6 = this.mCallBean;
                if (callBean6 == null) {
                    i.q2.t.i0.f();
                }
                TextView textView3 = this.mTvOccurTime;
                if (textView3 == null) {
                    i.q2.t.i0.k("mTvOccurTime");
                }
                if (textView3 == null) {
                    i.q2.t.i0.f();
                }
                callBean6.setTalkTime(textView3.getText().toString());
                CallBean callBean7 = this.mCallBean;
                if (callBean7 == null) {
                    i.q2.t.i0.f();
                }
                TextView textView4 = this.mTvDuration;
                if (textView4 == null) {
                    i.q2.t.i0.k("mTvDuration");
                }
                if (textView4 == null) {
                    i.q2.t.i0.f();
                }
                callBean7.setCallDuration(textView4.getText().toString());
                if (this.mAudios.size() > 0) {
                    CallBean callBean8 = this.mCallBean;
                    if (callBean8 == null) {
                        i.q2.t.i0.f();
                    }
                    callBean8.setCallTelDetails(this.mAudios);
                }
                if (checkListRepeat()) {
                    return;
                }
                EditText editText5 = this.mEtPhone;
                if (editText5 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText5 == null) {
                    i.q2.t.i0.f();
                }
                String string = editText5.getText().toString();
                int length = string.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = string.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            if (i.q2.t.i0.a((Object) string.subSequence(i2, length + 1).toString(), (Object) AccountManager.getVisiblePhone())) {
                                saveHttpApi();
                                return;
                            } else {
                                util.f1.a(this.mActivity, "\u6dfb\u52a0\u7684\u8bc8\u9a97\u7535\u8bdd\u4e2d\u5305\u542b\u60a8\u7684\u767b\u5f55\u53f7\u7801\uff0c\u786e\u5b9a\u6dfb\u52a0\u4e2a\u4eba\u53f7\u7801\u4e3a\u8bc8\u9a97\u53f7\u7801\uff1f", "", "\u53d6\u6d88", "\u786e\u5b9a", -1, -1, (IClickListener) new c());
                                return;
                            }
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                if (i.q2.t.i0.a((Object) string.subSequence(i2, length + 1).toString(), (Object) AccountManager.getVisiblePhone())) {
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onkeyback();
                return;
            case R.id.tv_audio_num /* 2131297590 */:
                Intent intent = new Intent(this, (Class<?>) SurveyAudioActivity.class);
                intent.putExtra(util.p1.C0, this.caseInfoId);
                List<UploadFileBean> list = this.mAudios;
                if (list != null) {
                    if (list == null) {
                        i.q2.t.i0.f();
                    }
                    if (list.size() > 0) {
                        List<UploadFileBean> list2 = this.mAudios;
                        if (list2 == null) {
                            throw new i.e1("null cannot be cast to non-null type java.io.Serializable");
                        }
                        intent.putExtra(util.p1.p, (Serializable) list2);
                    }
                }
                startActivity(intent);
                return;
            case R.id.tv_duration /* 2131297702 */:
                EditText editText6 = this.mEtPhone;
                if (editText6 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText6 == null) {
                    i.q2.t.i0.f();
                }
                if (editText6.length() == 0) {
                    e2.a("\u8bf7\u586b\u5199\u8bc8\u9a97\u7535\u8bdd");
                    return;
                } else {
                    showDurationPiker();
                    return;
                }
            case R.id.tv_occur_time /* 2131297780 */:
                EditText editText7 = this.mEtPhone;
                if (editText7 == null) {
                    i.q2.t.i0.k("mEtPhone");
                }
                if (editText7 == null) {
                    i.q2.t.i0.f();
                }
                if (editText7.length() == 0) {
                    e2.a("\u8bf7\u586b\u5199\u8bc8\u9a97\u7535\u8bdd");
                    return;
                } else {
                    showTimePiker();
                    return;
                }
            default:
                return;
        }
    }

    public final void onkeyback() {
        util.f1.b(this.mActivity, "\u653e\u5f03\u672c\u6b21\u4fe1\u606f\u7f16\u8f91\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new d());
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_criminal_add;
    }

    public final void setMAudioNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mAudioNum = textView;
    }

    public final void setMBtnConfirm(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtPhone(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtPhone = editText;
    }

    public final void setMEtVictimPhone(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtVictimPhone = editText;
    }

    public final void setMLlClause(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlClause = view;
    }

    public final void setMTCbSelect(@j.c.a.d CheckBox checkBox) {
        i.q2.t.i0.f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvDuration(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvDuration = textView;
    }

    public final void setMTvOccurTime(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvOccurTime = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
