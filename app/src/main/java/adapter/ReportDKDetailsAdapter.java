package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import network.HistoryDetailInfo;
import network.HistoryListInfo;

/* loaded from: classes.dex */
public class ReportDKDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: h */
    public static final int f255h = -1;

    /* renamed from: i */
    public static final int f256i = 1;

    /* renamed from: j */
    public static final int f257j = 8;

    /* renamed from: k */
    public static final int f258k = 9;

    /* renamed from: a */
    public Typeface f259a;

    /* renamed from: b */
    private final Context f260b;

    /* renamed from: c */
    private HistoryListInfo.RowsBean.DetailsBean f261c;

    /* renamed from: d */
    private HistoryListInfo.RowsBean f262d;

    /* renamed from: e */
    private HistoryDetailInfo f263e;

    /* renamed from: f */
    private final List<HistoryDetailInfo> f264f;

    /* renamed from: g */
    private List<List<DetailBean>> f265g;

    public class DefineViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        TextView f266a;

        /* renamed from: b */
        TextView f267b;

        /* renamed from: c */
        TextView f268c;

        /* renamed from: d */
        TextView f269d;

        /* renamed from: e */
        TextView f270e;

        /* renamed from: f */
        TextView f271f;

        /* renamed from: g */
        ImageView f272g;

        /* renamed from: h */
        TextView f273h;

        /* renamed from: i */
        LinearLayout f274i;

        /* renamed from: j */
        LinearLayout f275j;

        /* renamed from: k */
        LinearLayout f276k;

        public DefineViewHolder(View view) {
            super(view);
            this.f266a = (TextView) view.findViewById(C2113R.id.tv_case_type);
            this.f267b = (TextView) view.findViewById(C2113R.id.casecategory);
            this.f268c = (TextView) view.findViewById(C2113R.id.tv_report_name);
            this.f269d = (TextView) view.findViewById(C2113R.id.tv_self);
            this.f270e = (TextView) view.findViewById(C2113R.id.report_size);
            this.f271f = (TextView) view.findViewById(C2113R.id.tv_case_num);
            this.f275j = (LinearLayout) view.findViewById(C2113R.id.ll_report_prog);
            this.f272g = (ImageView) view.findViewById(C2113R.id.iv_dk_tag);
            this.f273h = (TextView) view.findViewById(C2113R.id.report_time);
            this.f274i = (LinearLayout) view.findViewById(C2113R.id.ll_progress);
            this.f276k = (LinearLayout) view.findViewById(C2113R.id.ll_report_progress);
            this.f266a.setText("举报详情");
            this.f275j.setVisibility(8);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public RecyclerView f278a;

        /* renamed from: b */
        public int f279b;

        /* renamed from: c */
        public TextView f280c;

        /* renamed from: d */
        public TextView f281d;

        /* renamed from: e */
        public View f282e;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.f279b = i2;
            this.f278a = (RecyclerView) view.findViewById(C2113R.id.recyclerview);
            this.f280c = (TextView) view.findViewById(C2113R.id.group_report);
            this.f281d = (TextView) view.findViewById(C2113R.id.group_report_count);
            this.f282e = view.findViewById(C2113R.id.item_line);
        }
    }

    public ReportDKDetailsAdapter(Typeface typeface, HistoryListInfo.RowsBean rowsBean, HistoryDetailInfo historyDetailInfo, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f260b = context;
        this.f259a = typeface;
        this.f262d = rowsBean;
        this.f261c = rowsBean == null ? null : rowsBean.getInfo();
        this.f263e = historyDetailInfo;
        this.f264f = list;
        this.f265g = list2;
    }

    /* renamed from: a */
    private void m267a(DefineViewHolder defineViewHolder) {
        HistoryListInfo.RowsBean.DetailsBean detailsBean = this.f261c;
        if (detailsBean != null) {
            String caseCategoryText = detailsBean.getCaseCategoryText();
            if (TextUtils.isEmpty(caseCategoryText)) {
                caseCategoryText = "其他诈骗";
            }
            defineViewHolder.f267b.setText(caseCategoryText);
            defineViewHolder.f270e.setText("(" + this.f262d.getEvidenceCount() + "项举报内容)");
            defineViewHolder.f273h.setText(this.f261c.getSubmitTime());
            this.f261c.getRegion();
            this.f261c.getCaseDescription();
            defineViewHolder.f272g.setVisibility(0);
        }
        if (this.f263e.replys == null) {
            defineViewHolder.f274i.setVisibility(8);
            return;
        }
        defineViewHolder.f274i.setVisibility(0);
        for (int i2 = 0; i2 < this.f263e.replys.size(); i2++) {
            View inflate = LayoutInflater.from(this.f260b).inflate(C2113R.layout.report_reply_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.iv_reply_img);
            TextView textView = (TextView) inflate.findViewById(C2113R.id.tv_title);
            TextView textView2 = (TextView) inflate.findViewById(C2113R.id.tv_time);
            TextView textView3 = (TextView) inflate.findViewById(C2113R.id.tv_content);
            TextView textView4 = (TextView) inflate.findViewById(C2113R.id.tv_line);
            textView.setTypeface(this.f259a);
            HistoryDetailInfo.Replay replay = this.f263e.replys.get(i2);
            int i3 = replay.processType;
            if (i3 == 3) {
                imageView.setImageResource(C2113R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
            } else if (i3 == 2) {
                imageView.setImageResource(C2113R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setBackgroundResource(C2113R.color.divide_line);
            } else {
                imageView.setImageResource(C2113R.drawable.iv_gray_default_img);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setVisibility(8);
            }
            if (TextUtils.isEmpty(replay.description)) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
            defineViewHolder.f276k.addView(inflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f264f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f264f.get(i2).getItemType() == -1) {
            return -1;
        }
        if (this.f264f.get(i2).getItemType() == 1) {
            return 1;
        }
        if (this.f264f.get(i2).getItemType() == 8) {
            return 8;
        }
        return this.f264f.get(i2).getItemType() == 9 ? 9 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof DefineViewHolder) {
            m267a((DefineViewHolder) viewHolder);
        } else if (viewHolder instanceof RecyclerViewHolder) {
            m268a((RecyclerViewHolder) viewHolder, i2 - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == -1) {
            return new DefineViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2113R.layout.history_list_head, viewGroup, false));
        }
        if (i2 == 1 || i2 == 8 || i2 == 9) {
            return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2113R.layout.recyclerview_report_list, viewGroup, false), i2);
        }
        return null;
    }

    /* renamed from: a */
    private void m268a(RecyclerViewHolder recyclerViewHolder, int i2) {
        String title = this.f264f.get(i2 + 1).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f280c.setText(title);
        }
        List<List<DetailBean>> list = this.f265g;
        if (list != null && list.get(i2) != null) {
            recyclerViewHolder.f281d.setText(this.f265g.get(i2).size() + "个");
        } else {
            recyclerViewHolder.f281d.setText("0个");
        }
        if (i2 == 0) {
            recyclerViewHolder.f282e.setVisibility(8);
        }
    }
}
