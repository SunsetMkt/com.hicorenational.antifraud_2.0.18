package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckTimeBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class CheckTimeAdapter extends BaseQuickAdapter<CheckTimeBean, BaseViewHolder> {

    /* renamed from: V */
    private InterfaceC0059b f187V;

    /* renamed from: adapter.CheckTimeAdapter$a */
    class ViewOnClickListenerC0058a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f188a;

        /* renamed from: b */
        final /* synthetic */ int f189b;

        ViewOnClickListenerC0058a(BaseViewHolder baseViewHolder, int i2) {
            this.f188a = baseViewHolder;
            this.f189b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CheckTimeAdapter.this.f187V != null) {
                CheckTimeAdapter.this.f187V.onItemClickListener(this.f188a.getAdapterPosition(), ((BaseQuickAdapter) CheckTimeAdapter.this).f5546A);
            }
            for (int i2 = 0; i2 < ((BaseQuickAdapter) CheckTimeAdapter.this).f5546A.size(); i2++) {
                if (i2 == this.f189b) {
                    ((CheckTimeBean) ((BaseQuickAdapter) CheckTimeAdapter.this).f5546A.get(i2)).setSelect(true);
                } else {
                    ((CheckTimeBean) ((BaseQuickAdapter) CheckTimeAdapter.this).f5546A.get(i2)).setSelect(false);
                }
            }
            CheckTimeAdapter.this.notifyDataSetChanged();
        }
    }

    /* renamed from: adapter.CheckTimeAdapter$b */
    public interface InterfaceC0059b {
        void onItemClickListener(int i2, List<CheckTimeBean> list);
    }

    public CheckTimeAdapter(int i2, List<CheckTimeBean> list) {
        super(i2, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<CheckTimeBean> list) {
        this.f5546A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(InterfaceC0059b interfaceC0059b) {
        this.f187V = interfaceC0059b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CheckTimeBean checkTimeBean) {
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.content);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.img);
        textView.setText(checkTimeBean.getContent());
        if (checkTimeBean.isSelect()) {
            textView.setTextColor(this.f5580x.getResources().getColor(C2113R.color._4966FF));
            imageView.setVisibility(0);
        } else {
            textView.setTextColor(this.f5580x.getResources().getColor(C2113R.color.black_dark));
            imageView.setVisibility(8);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CheckTimeAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0058a(baseViewHolder, i2));
    }
}
