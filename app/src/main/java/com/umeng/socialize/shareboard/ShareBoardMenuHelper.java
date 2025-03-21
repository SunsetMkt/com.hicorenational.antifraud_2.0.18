package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class ShareBoardMenuHelper {
    private static String TAG = "ShareBoardMenuHelper";
    private ShareBoardConfig mShareBoardConfig;

    public ShareBoardMenuHelper(ShareBoardConfig shareBoardConfig) {
        this.mShareBoardConfig = shareBoardConfig;
    }

    private View createBtnView(Context context, final SnsPlatform snsPlatform) {
        String str;
        LinearLayout linearLayout = new LinearLayout(context);
        int i2 = 0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        if (snsPlatform != null) {
            ResContainer resContainer = ResContainer.get(context);
            View inflate = LayoutInflater.from(context).inflate(resContainer.layout("socialize_share_menu_item"), (ViewGroup) null);
            SocializeImageView socializeImageView = (SocializeImageView) inflate.findViewById(resContainer.m12637id("socialize_image_view"));
            TextView textView = (TextView) inflate.findViewById(resContainer.m12637id("socialize_text_view"));
            ShareBoardConfig shareBoardConfig = this.mShareBoardConfig;
            int i3 = shareBoardConfig.mMenuBgColor;
            if (i3 == 0 || shareBoardConfig.mMenuBgShape == ShareBoardConfig.BG_SHAPE_NONE) {
                socializeImageView.setPadding(0, 0, 0, 0);
            } else {
                socializeImageView.setBackgroundColor(i3, shareBoardConfig.mMenuBgPressedColor);
                ShareBoardConfig shareBoardConfig2 = this.mShareBoardConfig;
                socializeImageView.setBackgroundShape(shareBoardConfig2.mMenuBgShape, shareBoardConfig2.mMenuBgShapeAngle);
            }
            int i4 = this.mShareBoardConfig.mMenuIconPressedColor;
            if (i4 != 0) {
                socializeImageView.setPressedColor(i4);
            }
            try {
                str = snsPlatform.mShowWord;
            } catch (Exception e2) {
                SHARE_MEDIA share_media = snsPlatform.mPlatform;
                SLog.error(UmengText.SHAREBOARD.NULLNAME + (share_media == null ? "" : share_media.toString()), e2);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(snsPlatform.mShowWord);
            }
            textView.setGravity(17);
            try {
                i2 = ResContainer.getResourceId(context, "drawable", snsPlatform.mIcon);
            } catch (Exception e3) {
                SHARE_MEDIA share_media2 = snsPlatform.mPlatform;
                SLog.error(UmengText.SHAREBOARD.NULLNAME + (share_media2 != null ? share_media2.toString() : ""), e3);
            }
            if (i2 != 0) {
                socializeImageView.setImageResource(i2);
            }
            int i5 = this.mShareBoardConfig.mMenuTextColor;
            if (i5 != 0) {
                textView.setTextColor(i5);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.shareboard.ShareBoardMenuHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SHARE_MEDIA share_media3 = snsPlatform.mPlatform;
                    if (ShareBoardMenuHelper.this.mShareBoardConfig == null || ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener() == null) {
                        return;
                    }
                    ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener().onclick(snsPlatform, share_media3);
                }
            });
            linearLayout.addView(inflate);
        }
        return linearLayout;
    }

    private View createRowLayout(Context context, SnsPlatform[] snsPlatformArr, boolean z) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            layoutParams.topMargin = dip2px(context, 20.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        for (SnsPlatform snsPlatform : snsPlatformArr) {
            linearLayout.addView(createBtnView(context, snsPlatform));
        }
        return linearLayout;
    }

    private int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View createPageLayout(Context context, SnsPlatform[][] snsPlatformArr) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i2 = 0;
        while (i2 < snsPlatformArr.length) {
            linearLayout.addView(createRowLayout(context, snsPlatformArr[i2], i2 != 0));
            i2++;
        }
        return linearLayout;
    }

    public List<SnsPlatform[][]> formatPageData(List<SnsPlatform> list) {
        int i2;
        int i3 = this.mShareBoardConfig.mMenuColumnNum * 2;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i4 = this.mShareBoardConfig.mMenuColumnNum;
        if (size < i4) {
            SnsPlatform[][] snsPlatformArr = (SnsPlatform[][]) Array.newInstance((Class<?>) SnsPlatform.class, 1, size);
            for (int i5 = 0; i5 < list.size(); i5++) {
                snsPlatformArr[0][i5] = list.get(i5);
            }
            arrayList.add(snsPlatformArr);
            return arrayList;
        }
        int i6 = size / i3;
        int i7 = size % i3;
        if (i7 != 0) {
            i2 = (i7 / i4) + (i7 % i4 == 0 ? 0 : 1);
            i6++;
        } else {
            i2 = -1;
        }
        int i8 = 0;
        while (i8 < i6) {
            arrayList.add((SnsPlatform[][]) Array.newInstance((Class<?>) SnsPlatform.class, (i8 != i6 + (-1) || i2 == -1) ? 2 : i2, this.mShareBoardConfig.mMenuColumnNum));
            i8++;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < arrayList.size()) {
            SnsPlatform[][] snsPlatformArr2 = (SnsPlatform[][]) arrayList.get(i9);
            int length = snsPlatformArr2.length;
            int i11 = i10;
            int i12 = 0;
            while (i12 < length) {
                SnsPlatform[] snsPlatformArr3 = snsPlatformArr2[i12];
                int i13 = i11;
                for (int i14 = 0; i14 < snsPlatformArr3.length; i14++) {
                    if (i13 < size) {
                        snsPlatformArr3[i14] = list.get(i13);
                    }
                    i13++;
                }
                i12++;
                i11 = i13;
            }
            i9++;
            i10 = i11;
        }
        return arrayList;
    }
}
