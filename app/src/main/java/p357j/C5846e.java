package p357j;

import android.app.Activity;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;

/* compiled from: PictureLib.java */
/* renamed from: j.e */
/* loaded from: classes2.dex */
public class C5846e {

    /* renamed from: b */
    private static PictureParameterStyle f21124b;

    /* renamed from: c */
    private static PictureCropParameterStyle f21125c;

    /* renamed from: g */
    private static boolean f21129g;

    /* renamed from: a */
    private static int f21123a = PictureMimeType.ofImage();

    /* renamed from: d */
    private static PictureWindowAnimationStyle f21126d = new PictureWindowAnimationStyle();

    /* renamed from: e */
    private static int f21127e = 2131821098;

    /* renamed from: f */
    private static boolean f21128f = false;

    /* renamed from: h */
    private static boolean f21130h = true;

    /* renamed from: a */
    public static PictureSelectionModel m24617a(Activity activity, long j2, int i2, int i3) {
        f21127e = 2131821098;
        f21128f = false;
        f21129g = false;
        m24619a(activity);
        return m24622c(activity, j2, i2, i3);
    }

    /* renamed from: b */
    public static PictureSelectionModel m24620b(Activity activity, long j2, int i2, int i3) {
        f21127e = 2131821097;
        f21128f = true;
        f21129g = true;
        m24621b(activity);
        return m24622c(activity, j2, i2, i3);
    }

    /* renamed from: c */
    private static PictureSelectionModel m24622c(Activity activity, long j2, int i2, int i3) {
        return PictureSelector.create(activity).openGallery(i2).loadImageEngine(C5843b.m24586a()).theme(f21127e).isWeChatStyle(f21128f).setLanguage(-1).setPictureStyle(f21124b).setPictureCropStyle(f21125c).setPictureWindowAnimationStyle(f21126d).isWithVideoImage(true).loadCacheResourcesCallback(C5842a.m24585a()).maxSelectNum(i3).minSelectNum(1).maxVideoSelectNum(i3).imageSpanCount(4).isReturnEmpty(false).setRequestedOrientation(1).previewImage(true).previewVideo(true).enablePreviewAudio(true).isCamera(f21130h).isZoomAnim(true).isGif(true).cutOutQuality(90).enableCrop(f21129g).freeStyleCropEnabled(true).showCropFrame(true).showCropGrid(true).queryMaxFileSize((int) j2).minimumCompressSize(100);
    }

    /* renamed from: a */
    public static PictureSelectionModel m24618a(Activity activity, long j2, int i2, int i3, boolean z) {
        f21127e = 2131821098;
        f21128f = false;
        f21129g = false;
        f21130h = z;
        m24619a(activity);
        return m24622c(activity, j2, i2, i3);
    }

    /* renamed from: b */
    private static void m24621b(Activity activity) {
        f21124b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f21124b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = true;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f21124b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        f21124b.pictureContainerBackgroundColor = ContextCompat.getColor(activity, C2113R.color.app_color_black);
        PictureParameterStyle pictureParameterStyle2 = f21124b;
        pictureParameterStyle2.pictureTitleUpResId = C2113R.drawable.picture_icon_wechat_up;
        pictureParameterStyle2.pictureTitleDownResId = C2113R.drawable.picture_icon_wechat_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = C2113R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = C2113R.drawable.picture_icon_close;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.pictureCancelTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_53575e);
        f21124b.pictureRightDefaultTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_53575e);
        f21124b.pictureRightSelectedTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f21124b;
        pictureParameterStyle3.pictureUnCompleteBackgroundStyle = C2113R.drawable.picture_send_button_default_bg;
        pictureParameterStyle3.pictureCompleteBackgroundStyle = C2113R.drawable.picture_send_button_bg;
        pictureParameterStyle3.pictureCheckedStyle = C2113R.drawable.picture_wechat_num_selector;
        pictureParameterStyle3.pictureWeChatTitleBackgroundStyle = C2113R.drawable.picture_album_bg;
        pictureParameterStyle3.pictureWeChatChooseStyle = C2113R.drawable.picture_wechat_select_cb;
        pictureParameterStyle3.pictureWeChatLeftBackStyle = C2113R.drawable.picture_icon_back;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, C2113R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f21124b;
        pictureParameterStyle4.pictureCheckNumBgStyle = C2113R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_9b);
        f21124b.pictureCompleteTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_53575e);
        f21124b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, C2113R.color.picture_color_half_grey);
        PictureParameterStyle pictureParameterStyle5 = f21124b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = C2113R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = C2113R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, C2113R.color.app_color_white);
        PictureParameterStyle pictureParameterStyle6 = f21124b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
        f21125c = new PictureCropParameterStyle(ContextCompat.getColor(activity, C2113R.color.app_color_grey), ContextCompat.getColor(activity, C2113R.color.app_color_grey), Color.parseColor("#393a3e"), ContextCompat.getColor(activity, C2113R.color.app_color_white), f21124b.isChangeStatusBarFontColor);
    }

    /* renamed from: a */
    private static void m24619a(Activity activity) {
        if (f21124b != null) {
            return;
        }
        f21124b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f21124b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = false;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f21124b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        PictureParameterStyle pictureParameterStyle2 = f21124b;
        pictureParameterStyle2.pictureTitleUpResId = C2113R.drawable.picture_icon_arrow_up;
        pictureParameterStyle2.pictureTitleDownResId = C2113R.drawable.picture_icon_arrow_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = C2113R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = C2113R.drawable.picture_icon_back;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.pictureCancelTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f21124b;
        pictureParameterStyle3.pictureCheckedStyle = C2113R.drawable.picture_checkbox_selector;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, C2113R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f21124b;
        pictureParameterStyle4.pictureCheckNumBgStyle = C2113R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_fa632d);
        f21124b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.pictureCompleteTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_fa632d);
        f21124b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, C2113R.color.picture_color_white);
        f21124b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, C2113R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle5 = f21124b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = C2113R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = C2113R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, C2113R.color.white);
        PictureParameterStyle pictureParameterStyle6 = f21124b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
    }
}
