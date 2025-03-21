package network;

import bean.APIH5Bean;
import bean.AccountListBean;
import bean.AdBean;
import bean.AddressBean;
import bean.BaseAddressBean;
import bean.BrandBean;
import bean.CallBean;
import bean.CallWarnBean;
import bean.CaseDetailBean;
import bean.CaseDivisonBean;
import bean.CaseHistoryBean;
import bean.ChatDetailResultBean;
import bean.ChatDetailResultBeanTest;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.CheckUserBean;
import bean.CriminalBean;
import bean.CriminalPhoneNumBean;
import bean.CriminalSmsBean;
import bean.CriminalSocialBean;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.GuideBean;
import bean.HandKey;
import bean.HomeNewCaseBean;
import bean.IDVarfyBean;
import bean.InDustryBean;
import bean.ManualListBean;
import bean.NoteDlgBean;
import bean.NoteListBean;
import bean.OssTokenBean;
import bean.PageBean;
import bean.PolicBean;
import bean.QATypeBean;
import bean.RechargeBean;
import bean.RechargePlatBean;
import bean.RecordCountBean;
import bean.RegionConfigBean;
import bean.RelationBean;
import bean.RelationPlatBean;
import bean.ReplyBean;
import bean.ReportCaseBean;
import bean.ReportResultBean;
import bean.ReportWebsitBean;
import bean.ReportZPBean;
import bean.SMSWarnBean;
import bean.SearchVirusAppResultBean;
import bean.SignComitBean;
import bean.SocialTypeBean;
import bean.SurveyAppBean;
import bean.SurveyAudioResultBean;
import bean.SurveyPeopleBean;
import bean.SurveyToH5Bean;
import bean.UserInfoBean;
import bean.VerifyAcceptBean;
import bean.VerifyHomePointBean;
import bean.WebArticleBean;
import bean.WebInfoNumBean;
import bean.YcLicenceBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import network.HistoryListInfo;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterInfo;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import p251g.p252a.AbstractC4469b0;
import p375l.InterfaceC5873b;
import p375l.p380s.InterfaceC5901a;
import p375l.p380s.InterfaceC5906f;
import p375l.p380s.InterfaceC5912l;
import p375l.p380s.InterfaceC5915o;
import p375l.p380s.InterfaceC5917q;
import p375l.p380s.InterfaceC5924x;

/* loaded from: classes2.dex */
public interface IReportService {
    @InterfaceC5915o
    AbstractC4469b0<APIresult<SurveyToH5Bean>> SurveyToH5Bean(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<SurveyAudioResultBean>> SurveyUploadFile2(@InterfaceC5924x String str, @InterfaceC5901a HashMap<String, String> hashMap);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<APIH5Bean>>> allDictionary(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<BrandBean>>> brandList(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> cancelUpdate(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> cancleUploadFile(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CaseHistoryBean>> caseHistoryList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckFraudBean>> checkFraud(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckFraudCountBean>> checkFraudCount(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckFraudBean>> checkFraudIpUrl(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckUserBean>> checkisverify(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> confirmIDAuth(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> deleteCaseWebUrl(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> deletePeople(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> deleteReportCriminal(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> deleteSurveyApp(@InterfaceC5924x String str, @InterfaceC5901a HashMap<String, String> hashMap);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<DownloadInfo>> download(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> evidenceSubmit(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> feedBack2(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5912l
    @InterfaceC5915o
    AbstractC4469b0<APIresult> fileUpload(@InterfaceC5924x String str, @InterfaceC5917q("data") FileInfo_2 fileInfo_2, @InterfaceC5917q MultipartBody.Part part);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Boolean>> getAccHasPwd(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<AdBean>> getAd(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<BaseAddressBean>> getAddress(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5906f
    AbstractC4469b0<List<AddressBean>> getAreaListOss(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckUserBean>> getAuditinfo(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<BannerInfo>>> getBanner(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Integer>> getCaseBankNum(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> getCaseInfoById(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<SignComitBean>> getComitReportNum(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<CriminalBean>>> getCriminalList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<CallBean>>> getCriminalPhoneList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CriminalPhoneNumBean>> getCriminalPhoneNum(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<WebInfoNumBean>> getCriminalWebInfoNum(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<DeliveryBean>>> getDeliveryList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<DeliveryPlatBean>>> getDeliveryPlatList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CaseDetailBean>> getDetail(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<GuideBean>>> getGuideConfig(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HistoryListInfo>> getHistorylist(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<InDustryBean>>> getIndustrys(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<ReportZPBean>>> getNEvidenceType(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<UserInfoBean>> getNew(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HomeNewCaseBean>> getNewCaseList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5906f
    AbstractC4469b0<List<HomeNewCaseBean.RowsBean>> getNewCaseListOss(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<NoteListBean>>> getNoteList(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<NoteListBean>> getNoteListItem(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> getOperation(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<OssTokenBean>> getOssToken(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<AccountListBean>>> getPayment(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<QATypeBean>>> getQAList(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<RechargeBean>>> getRechargePhoneList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<RechargePlatBean>>> getRechargePlatList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<RegionConfigBean>> getRegionJson(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> getRegionJsonData(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5906f
    AbstractC4469b0<ResponseBody> getRegionJsonOss(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<RelationBean>>> getRelationList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<RelationPlatBean>>> getRelationPlatList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<ReplyBean>>> getReply(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<RecordCountBean>> getReportNum(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Integer>> getReportNum(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<SMSWarnBean>> getSMSWarnInfo(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<SocialTypeBean>>> getSocialTags(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<SurveyAppBean>>> getSurveyAppList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<ReportWebsitBean>>> getSurveyWebList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> getTelType(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<VerifyAcceptBean>>> getVerifyAcceptList(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<VerifyHomePointBean>> getVerifyHomePoint(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<IDVarfyBean>> getVerifyList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<SurveyPeopleBean>>> getVictimList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<YcLicenceBean>> getYCLicence(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HistoryDetailInfo>> getdetail(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<String>>> getsocialtels(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HelpUploadInfo>> helpUpload(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HandKey>> jniAppKey(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    InterfaceC5873b<APIresult<HandKey>> jniAppKeySyn(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> listenApp(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> loginOffHttp(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CheckUserBean>> manualAlreadyDetail(@InterfaceC5924x String str, @InterfaceC5901a Map<String, Long> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<PageBean<ManualListBean>>> manualList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, Object> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<PolicBean>> policLogintion(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> policLogot(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<AccountInfo>> postNew(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> postOperation(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Boolean>> redName(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> removeDelivery(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> removeRechargetel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> removeRelationtel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> removecalltel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> reportAddCaseWebUrl(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> reportConfirm(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> reportCriminalAdd(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> reportFraudIpUrl(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<HistoryListInfo.RowsBean>> reportSubmit(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<ReportResultBean>> reportUploadFile(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<ReportCaseBean>> reportUserCases(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<WebArticleBean>> requessArticInfo(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<APIH5Bean>> requestAppConfig(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> requestLoginOut(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<NoteDlgBean>> requestNewNote(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CallWarnBean>> requestOKHttp(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Integer>> requestPhoneCode(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<DeliveryBean>> saveDeliveryTel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> saveRechargeTel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> saveRelationTel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> saveSms(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> saveSocial(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<ChatDetailResultBeanTest>> saveTransfer(@InterfaceC5924x String str, @InterfaceC5901a HashMap<String, String> hashMap);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<CallBean>> savecalltel(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> savexc(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<SearchVirusAppResultBean>>> searchVirusApp(@InterfaceC5924x String str, @InterfaceC5901a Map<Object, Object> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> silentlyreg(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<CriminalSmsBean>>> smsList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<CriminalSocialBean>>> socialList(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> solve(@InterfaceC5924x String str, @InterfaceC5901a Map<String, Object> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> submitaudit(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> surveyAddCasePerson(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> surveyCaseApp(@InterfaceC5924x String str, @InterfaceC5901a HashMap<String, String> hashMap);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<List<CaseDivisonBean>>> surveyCredentType(@InterfaceC5924x String str);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> trackData(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<Double>> updateUserInfo(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<String>> uploadCriminalFile2(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<ChatDetailResultBean>> uploadDetail(@InterfaceC5924x String str, @InterfaceC5901a MultipartBody multipartBody);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> uploadFile(@InterfaceC5924x String str, @InterfaceC5901a MultipartBody multipartBody);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<ChatDetailResultBean>> uploadTransferFile(@InterfaceC5924x String str, @InterfaceC5901a MultipartBody multipartBody);

    @InterfaceC5915o
    AbstractC4469b0<APIresult> verifyCreate(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);

    @InterfaceC5915o
    AbstractC4469b0<APIresult<RegisterInfo>> verityNew(@InterfaceC5924x String str, @InterfaceC5901a Map<String, String> map);
}
