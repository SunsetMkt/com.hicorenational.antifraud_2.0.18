package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMLogUtils;

/* compiled from: UMLogAnalytics.java */
/* renamed from: com.umeng.analytics.pro.j */
/* loaded from: classes2.dex */
public class C3409j {

    /* renamed from: A */
    public static final String f12068A = "MobclickAgent.setSecret方法参数secretkey不能为null，也不能为空字符串。|secretkey参数必须是非空 字符串。";

    /* renamed from: B */
    public static final String f12069B = "统计SDK常见问题索引贴 详见链接 http://developer.umeng.com/docs/66650/cate/66650";

    /* renamed from: H */
    public static final String f12075H = "检测到进入页面生命周期时尚未完成SDK初始化，请检查是否未在Application.onCreate函数中执行SDK初始化函数。";

    /* renamed from: N */
    public static final String f12081N = "MobclickAgent.onDeepLinkReceived方法Context参数不能为null。|参数Context需要指定ApplicationContext值。";

    /* renamed from: O */
    public static final String f12082O = "MobclickAgent.onDeepLinkReceived方法link参数不能为null，也不能为空字符串。|参数link必须为非空字符串。";

    /* renamed from: P */
    public static final String f12083P = "MobclickAgent.onDeepLinkReceived方法link参数长度超过限制。|参数link长度不能超过1024字符。";

    /* renamed from: ar */
    public static final String f12112ar = "请在Application.onCreate函数中使用UMConfigure.preInit函数初始化友盟sdk";

    /* renamed from: z */
    public static final String f12137z = "MobclickAgent.setSecret方法参数context不能为null|参数Context需要指定ApplicationContext值。";

    /* renamed from: a */
    public static final String f12094a = "事件属性集合参数为空|onEvent接口必须传入非空的属性集合。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: b */
    public static final String f12113b = "事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: c */
    public static final String f12114c = "事件ID为null或者为空字符串|onEvent接口传入的事件ID不能为null，也不能为空字符串。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: d */
    public static final String f12115d = "事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: e */
    public static final String f12116e = "事件属性集合map中key值和保留字冲突|事件属性集合map中key值不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: f */
    public static final String f12117f = "事件ID为null或者长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: g */
    public static final String f12118g = "事件属性集合参数为空或者事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: h */
    public static final String f12119h = "事件属性集合map中key非法|事件属性集合参数map中key不能为非法的。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: i */
    public static final String f12120i = "事件属性集合map中value为null|事件属性集合参数map中value不能为null。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: j */
    public static final String f12121j = "事件属性集合map中value长度超过限制|事件属性集合参数map中value如果为字符串时，其长度不能超过256个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: k */
    public static final String f12122k = "事件标签为null或者为空字符串|onEvent接口传入的事件标签不能为null，也不能为空字符串。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: l */
    public static final String f12123l = "事件ID为null或者长度超过限制，或事件标签长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。事件标签长度不能超过256个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: m */
    public static final String f12124m = "事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: n */
    public static final String f12125n = "MobclickAgent.onResume接口参数不能为null|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: o */
    public static final String f12126o = "MobclickAgent.onResume接口参数不是Activity的上下文|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: p */
    public static final String f12127p = "MobclickAgent.onPause接口参数不能为null|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: q */
    public static final String f12128q = "MobclickAgent.onPause接口参数不是Activity的上下文|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: r */
    public static final String f12129r = "@ 遗漏了Mobclick.onResume函数调用|每个Activity的onResume中都必须调用MobclickAgent.onResume。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: s */
    public static final String f12130s = "@ 遗漏了Mobclick.onPaused函数调用|每个Activity的onPaused中都必须调用MobclickAgent.onPaused。详见问题链接 " + UMLogUtils.makeUrl("66948");

    /* renamed from: t */
    public static final String f12131t = "MobclickAgent.onProfileSignIn接口参数 账号ID 不能为null|账号ID不能为空。详见问题链接 " + UMLogUtils.makeUrl("66951");

    /* renamed from: u */
    public static final String f12132u = "MobclickAgent.onProfileSignIn接口参数 账号ID 长度超过限制|账号ID 长度不能超过64个字符。详见问题链接 " + UMLogUtils.makeUrl("66951");

    /* renamed from: v */
    public static final String f12133v = "MobclickAgent.onProfileSignIn接口参数 账号来源 长度超过限制|账号来源 长度不能超过32个字符。详见问题链接 " + UMLogUtils.makeUrl("66951");

    /* renamed from: w */
    public static final String f12134w = "MobclickAgent.reportError方法参数context不能为null|参数Context需要指定ApplicationContext值。详见问题链接 " + UMLogUtils.makeUrl("66971");

    /* renamed from: x */
    public static final String f12135x = "MobclickAgent.reportError方法参数error不能为null，也不能为空字符串。|error参数必须是非空字符串。详见问题链接 " + UMLogUtils.makeUrl("66971");

    /* renamed from: y */
    public static final String f12136y = "MobclickAgent.reportError方法 Context和Throwable参数都不能为空。|参数Context需要指定ApplicationContext值，Throwable参数传入捕获到的异常对象。详见问题链接 " + UMLogUtils.makeUrl("66971");

    /* renamed from: C */
    public static final String f12070C = "MobclickAgent.onPageStart方法参数不能为null，也不能为空字符串。|参数viewName必须为非空字符串。详见链接 " + UMLogUtils.makeUrl("66975");

    /* renamed from: D */
    public static final String f12071D = "MobclickAgent.onPageEnd方法参数不能为null，也不能为空字符串。|参数viewName必须为非空 字符串。详见链接 " + UMLogUtils.makeUrl("66975");

    /* renamed from: E */
    public static final String f12072E = "对于页面@，onPageStart和onPageEnd调用对的参数不一致。|对于同一个页面，请先调用onPageStart，再调用onPageEnd。详见链接 " + UMLogUtils.makeUrl("66975");

    /* renamed from: F */
    public static final String f12073F = "对于页面@，请确保先依序成对调用onPageStart，onPageEnd接口，再调用onPageStart接口对其它页面进行统计。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 " + UMLogUtils.makeUrl("66975");

    /* renamed from: G */
    public static final String f12074G = "对于页面@，请检查是否遗漏onPageStart接口调用。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 " + UMLogUtils.makeUrl("66975");

    /* renamed from: I */
    public static final String f12076I = "当前发送策略为：启动时发送。详见链接 " + UMLogUtils.makeUrl("66976");

    /* renamed from: J */
    public static final String f12077J = "当前发送策略为: 间隔发送。间隔时间为：@秒。详见链接 " + UMLogUtils.makeUrl("66976");

    /* renamed from: K */
    public static final String f12078K = "当前发送策略为: 集成测试。但是SDK未切换到调试模式，所以后台设置未生效。|如想切换到集成测试发送策略，请调用UMConfigure.setLogEnabled(true)将SDK切换到调试模式。详见链接 " + UMLogUtils.makeUrl("66976");

    /* renamed from: L */
    public static final String f12079L = "当前发送策略为：集成测试。详见链接 " + UMLogUtils.makeUrl("66976");

    /* renamed from: M */
    public static final String f12080M = "当前发送策略为: 准实时发送。间隔时间为：@秒。详见链接 " + UMLogUtils.makeUrl("66976");

    /* renamed from: Q */
    public static final String f12084Q = "发送数据时发生java.net.UnknownHostException异常|友盟后端对设备端证书验证失败。请确保设备端没有运行抓包代理类程序。详见链接 " + UMLogUtils.makeUrl("66978");

    /* renamed from: R */
    public static final String f12085R = "发送数据时发生javax.net.sslHandshakeException异常|导致友盟后端域名解析失败。请检查系统DNS服务器配置是否正确。详见链接 " + UMLogUtils.makeUrl("66978");

    /* renamed from: S */
    public static final String f12086S = "track接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: T */
    public static final String f12087T = "registerSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: U */
    public static final String f12088U = "unregisterSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: V */
    public static final String f12089V = "getSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接: " + UMLogUtils.makeUrl("67310");

    /* renamed from: W */
    public static final String f12090W = "getSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: X */
    public static final String f12091X = "clearSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: Y */
    public static final String f12092Y = "setFirstLaunchEvent接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: Z */
    public static final String f12093Z = "registerPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: aa */
    public static final String f12095aa = "unregisterPreProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: ab */
    public static final String f12096ab = "clearPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: ac */
    public static final String f12097ac = "getPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");

    /* renamed from: ad */
    public static final String f12098ad = "eventName为空，请检查|eventName参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67311");

    /* renamed from: ae */
    public static final String f12099ae = "请注意：map为空|track接口的参数说明，详见问题连接：" + UMLogUtils.makeUrl("67311");

    /* renamed from: af */
    public static final String f12100af = "context参数为空｜context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67312");

    /* renamed from: ag */
    public static final String f12101ag = "propertyName参数或propertyValue参数为空｜propertyName、propertyValue参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67312");

    /* renamed from: ah */
    public static final String f12102ah = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67313");

    /* renamed from: ai */
    public static final String f12103ai = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67316");

    /* renamed from: aj */
    public static final String f12104aj = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67318");

    /* renamed from: ak */
    public static final String f12105ak = "trackID参数为空|trackID参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67318");

    /* renamed from: al */
    public static final String f12106al = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67319");

    /* renamed from: am */
    public static final String f12107am = "propertics参数为空|propertics参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67319");

    /* renamed from: an */
    public static final String f12108an = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67320");

    /* renamed from: ao */
    public static final String f12109ao = "未匹配到您传入的property参数|property参数不能匹配，" + UMLogUtils.makeUrl("67320");

    /* renamed from: ap */
    public static final String f12110ap = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67321");

    /* renamed from: aq */
    public static final String f12111aq = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67322");
}
