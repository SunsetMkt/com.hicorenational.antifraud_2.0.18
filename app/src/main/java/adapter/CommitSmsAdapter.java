package adapter;

import android.text.TextUtils;
import bean.CriminalSmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class CommitSmsAdapter extends BaseQuickAdapter<CriminalSmsBean, BaseViewHolder> {
    public CommitSmsAdapter(List<CriminalSmsBean> list) {
        super(C2113R.layout.recyclerview_commit_sms, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CriminalSmsBean criminalSmsBean) {
        String content = criminalSmsBean.getContent();
        if (criminalSmsBean.getSmsType() == 2 && TextUtils.isEmpty(content)) {
            content = "[图片]";
        }
        if (criminalSmsBean.getSmsType() == 4) {
            baseViewHolder.m5226c(C2113R.id.tv_sms_phone, false).m5226c(C2113R.id.tv_tag, false);
        } else {
            baseViewHolder.m5226c(C2113R.id.tv_sms_phone, true).m5226c(C2113R.id.tv_tag, true).m5211a(C2113R.id.tv_sms_phone, (CharSequence) ("涉诈短信号码：" + criminalSmsBean.getSuspectMobile())).m5211a(C2113R.id.tv_tag, (CharSequence) criminalSmsBean.getSuspectMobileTypeText());
        }
        baseViewHolder.m5211a(C2113R.id.tv_sms_content, (CharSequence) content);
        baseViewHolder.m5211a(C2113R.id.tv_type_sms, (CharSequence) criminalSmsBean.getSmsTypeText()).m5211a(C2113R.id.tv_victim_phone, (CharSequence) ("接收短信号码：" + criminalSmsBean.getVictimMobile())).m5211a(C2113R.id.tv_time, (CharSequence) criminalSmsBean.getDeliveryTime());
    }
}
