/*
 * Fetion Connect
 *  
 * Create by 李会军  Jun 7, 2011
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package thirdparty.sina.oauth2;

import com.fasterxml.jackson.databind.ObjectReader;
import com.ning.http.client.Response;
import thirdparty.Output;

/**
 * 这个类实现了对新浪的错误码的解析。因为任意一个新浪的接口都会返回这个错误
 * 码，因此它也会被继承到各个返回值内。
 *
 * @author shangrenpeng
 * @date 2012-9-20 下午4:18:12
 */
public abstract class SinaOauth2Output extends Output {

    protected String request;//请求地址
    protected String error_code;//错误码
    protected String error;//错误说明
    protected String userDescription;//自定义，用来存储给用户显示的文字内容

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String value) {
        this.request = value;
    }

    public String getErrorCode() {
        return this.getError_code();
    }

    public void setErrorCode(String value) {
        this.setError_code(value);
    }

    public String getError() {
        return this.error;
    }

    public void setError(String value) {
        this.error = value;
    }

    /* (non-Javadoc)
     * @see thirdparty.Merchandise#MerchandiseOK()
     */
    @Override
    public boolean outputOK() {
        return getError_code() == null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.feinno.app.sync.engine.ErrorResponse#needRetry()
     */
    @Override
    public boolean needRetry() {
        int code = 0;
        try {
            if (null != getError_code()) {
                code = Integer.parseInt(getError_code());
            }
        } catch (Exception e) {
            LOGGER.error(getError_code());
        }

        if (code == 0) {
            return false;
        }

        int[] whatNeedRetry = {
                10001, 10002, 10003, 10009, 10010, 10011, 10025, 20014, -502
        };


        for (int needRetry : whatNeedRetry) {
            if (code == needRetry) {
                return true;
            }
        }

        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.feinno.app.sync.engine.ErrorResponse#needLog()
     */
    @Override
    public boolean needLog() {
        int code = 0;
        try {
            if (null != getError_code()) {
                code = Integer.parseInt(getError_code());
            }
        } catch (Exception e) {
            LOGGER.error(getError_code());
        }

        if (code == 0) {
            return false;
        }

        if (code > 10000) {
            return true;
        } else if (code > 0) {
            LOGGER.error("code:" + code + "." + error);
        }

        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.feinno.app.sync.engine.ErrorResponse#logError()
     */
    @Override
    public void logError() {
        if (userDescription == null) {
            initUserDescription();
        }
        LOGGER.error(userDescription);
    }

    /* (non-Javadoc)
     * @see com.feinno.app.sync.engine.ErrorResponse#needUserKnow()
     */
    @Override
    public boolean needUserKnow() {
        int code = 0;
        try {
            code = Integer.parseInt(getError_code());
        } catch (Exception e) {
            LOGGER.error(getError_code());
        }

        if (code == 0) {
            return false;
        }

        int[] whatNeedToKnow = {
                10013, 10023, 10024, 20003, 20005, 20006, 20012, 20013, 20016,
                20017, 20019, 20023, 20032, 20103, 20111, 20120, 20206, 20207,
                21331,
        };

        for (int needToKnow : whatNeedToKnow) {
            if (code == needToKnow) {
                return true;
            }
        }

        return false;
    }

    /* (non-Javadoc)
     * @see com.feinno.app.sync.engine.ErrorResponse#letUserKnow()
     */
    @Override
    public void letUserKnow() {
        if (userDescription == null) {
            initUserDescription();
        }
        //TODO 暂时不需要前端展示。可以通过缓存来展示
    }

    protected void initUserDescription() {
        int code = 0;
        try {
            code = Integer.parseInt(getError_code());
        } catch (Exception e) {
            LOGGER.error(getError_code());
        }

        switch (code) {
            case 10001:
                userDescription = "系统错误";
                break;
            case 10002:
                userDescription = "服务端资源不可用";
                break;
            case 10003:
                userDescription = "远程服务出错";
                break;
            case 10005:
                userDescription = "该资源需要appkey拥有更高级的授权";
                break;
            case 10006:
                userDescription = "缺少 source参数(appkey)";
                break;
            case 10007:
                userDescription = "不支持的 MediaType (%s)";
                break;
            case 10008:
                userDescription = "错误:参数错误，请参考API文档";
                break;
            case 10009:
                userDescription = "任务过多，系统繁忙";
                break;
            case 10010:
                userDescription = "任务超时";
                break;
            case 10011:
                userDescription = "RPC错误";
                break;
            case 10012:
                userDescription = "非法请求";
                break;
            case 10013:
                userDescription = "不合法的微博用户";
                break;
            case 10014:
                userDescription = "第三方应用访问api接口权限受限制";
                break;
            case 10016:
                userDescription = "错误:缺失必选参数:%s，请参考API文档";
                break;
            case 10017:
                userDescription = "错误:参数值非法,希望得到 (%s),实际得到 (%s)，请参考API文档";
                break;
            case 10018:
                userDescription = "请求长度超过限制";
                break;
            case 10020:
                userDescription = "接口不存在";
                break;
            case 10021:
                userDescription = "请求的HTTP METHOD不支持";
                break;
            case 10022:
                userDescription = "IP请求超过上限";
                break;
            case 10023:
                userDescription = "用户请求超过上限";
                break;
            case 10024:
                userDescription = "用户请求接口%s超过上限";
                break;
            case 10025:
                userDescription = "内部接口参数错误";
                break;
            case 20001:
                userDescription = "IDS参数为空";
                break;
            case 20002:
                userDescription = "uid参数为空";
                break;
            case 20003:
                userDescription = "用户不存在";
                break;
            case 20005:
                userDescription = "不支持的图片类型,仅仅支持JPG,GIF,PNG";
                break;
            case 20006:
                userDescription = "图片太大";
                break;
            case 20007:
                userDescription = "请确保使用multpart上传了图片";
                break;
            case 20008:
                userDescription = "内容为空";
                break;
            case 20009:
                userDescription = "id列表太长了";
                break;
            case 20012:
                userDescription = "输入文字太长，请确认不超过140个字符";
                break;
            case 20013:
                userDescription = "输入文字太长，请确认不超过300个字符";
                break;
            case 20014:
                userDescription = "传入参数有误，请再调用一次";
                break;
            case 20016:
                userDescription = "发微博太多啦，休息一会儿吧";
                break;
            case 20017:
                userDescription = "你刚刚已经发送过相似内容了哦，先休息一会吧";
                break;
            case 20019:
                userDescription = "不要太贪心哦，发一次就够啦";
                break;
            case 20023:
                userDescription = "很抱歉，此功能暂时无法使用，如需帮助请联系@微博客服 或者致电客服电话400 690 0000";
                break;
            case 20031:
                userDescription = "需要弹出验证码";
                break;
            case 20032:
                userDescription = "微博发布成功。目前服务器数据同步可能会有延迟，请耐心等待1-2分钟。谢谢";
                break;
            case 20033:
                userDescription = "登陆状态异常";
                break;
            case 20101:
                userDescription = "不存在的微博";
                break;
            case 20102:
                userDescription = "不是你发布的微博";
                break;
            case 20103:
                userDescription = "不能转发自己的微博";
                break;
            case 20109:
                userDescription = "微博 id为空";
                break;
            case 20111:
                userDescription = "不能发布相同的微博";
                break;
            case 20112:
                userDescription = "由于作者隐私设置，你没有权限查看此微博";
                break;
            case 20114:
                userDescription = "标签名太长";
                break;
            case 20115:
                userDescription = "标签不存在";
                break;
            case 20116:
                userDescription = "标签已存在";
                break;
            case 20117:
                userDescription = "最多200个标签";
                break;
            case 20118:
                userDescription = "最多5个标签";
                break;
            case 20119:
                userDescription = "标签搜索失败";
                break;
            case 20120:
                userDescription = "由于作者设置了可见性，你没有权限转发此微博";
                break;
            case 20121:
                userDescription = "visible参数非法";
                break;
            case 20122:
                userDescription = "应用不存在";
                break;
            case 20123:
                userDescription = "最多屏蔽200个应用";
                break;
            case 20124:
                userDescription = "最多屏蔽500条微博";
                break;
            case 20125:
                userDescription = "没有屏蔽过此应用";
                break;
            case 20126:
                userDescription = "不能屏蔽新浪应用";
                break;
            case 20127:
                userDescription = "已添加了此屏蔽";
                break;
            case 20128:
                userDescription = "删除屏蔽失败";
                break;
            case 20129:
                userDescription = "没有屏蔽任何应用";
                break;
            case 20201:
                userDescription = "不存在的微博评论";
                break;
            case 20203:
                userDescription = "不是你发布的评论";
                break;
            case 20204:
                userDescription = "评论ID为空";
                break;
            case 20206:
                userDescription = "作者只允许关注用户评论";
                break;
            case 20207:
                userDescription = "作者只允许可信用户评论";
                break;
            case 20401:
                userDescription = "域名不存在";
                break;
            case 20402:
                userDescription = "verifier错误";
                break;
            case 20403:
                userDescription = "屏蔽用户列表中存在此uid";
                break;
            case 20404:
                userDescription = "屏蔽用户列表中不存在此uid";
                break;
            case 20405:
                userDescription = "uid对应用户不是登录用户的好友";
                break;
            case 20406:
                userDescription = "屏蔽用户个数超出上限";
                break;
            case 20407:
                userDescription = "没有合适的uid";
                break;
            case 20408:
                userDescription = "从feed屏蔽列表中，处理用户失败";
                break;
            case 20501:
                userDescription = "错误:source_user 或者target_user用户不存在";
                break;
            case 20502:
                userDescription = "必须输入目标用户id或者 screen_name";
                break;
            case 20503:
                userDescription = "关系错误，user_id必须是你关注的用户";
                break;
            case 20504:
                userDescription = "你不能关注自己";
                break;
            case 20505:
                userDescription = "加关注请求超过上限";
                break;
            case 20506:
                userDescription = "已经关注此用户";
                break;
            case 20507:
                userDescription = "需要输入验证码";
                break;
            case 20508:
                userDescription = "根据对方的设置，你不能进行此操作";
                break;
            case 20509:
                userDescription = "悄悄关注个数到达上限";
                break;
            case 20510:
                userDescription = "不是悄悄关注人";
                break;
            case 20511:
                userDescription = "已经悄悄关注此用户";
                break;
            case 20512:
                userDescription = "你已经把此用户加入黑名单，加关注前请先解除";
                break;
            case 20513:
                userDescription = "你的关注人数已达上限";
                break;
            case 20522:
                userDescription = "还未关注此用户";
                break;
            case 20523:
                userDescription = "还不是粉丝";
                break;
            case 20601:
                userDescription = "列表名太长，请确保输入的文本不超过10个字符";
                break;
            case 20602:
                userDescription = "列表描叙太长，请确保输入的文本不超过70个字符";
                break;
            case 20603:
                userDescription = "列表不存在";
                break;
            case 20604:
                userDescription = "不是对象所属者";
                break;
            case 20605:
                userDescription = "列表名或描叙不合法";
                break;
            case 20606:
                userDescription = "记录已存在";
                break;
            case 20607:
                userDescription = "错误:数据库错误，请联系系统管理员";
                break;
            case 20608:
                userDescription = "列表名冲突";
                break;
            case 20610:
                userDescription = "目前不支持私有分组";
                break;
            case 20611:
                userDescription = "创建list失败";
                break;
            case 20612:
                userDescription = "目前只支持私有分组";
                break;
            case 20613:
                userDescription = "错误:不能创建更多的列表";
                break;
            case 20614:
                userDescription = "已拥有列表上下，请参考API文档";
                break;
            case 20615:
                userDescription = "成员上线，请参考API文档";
                break;
            case 20616:
                userDescription = "不支持的分组类型";
                break;
            case 20617:
                userDescription = "最大返回300条";
                break;
            case 20618:
                userDescription = "uid 不在列表中";
                break;
            case 20701:
                userDescription = "不能提交相同的标签";
                break;
            case 20702:
                userDescription = "最多两个标签";
                break;
            case 20704:
                userDescription = "您已经收藏了此微博";
                break;
            case 20705:
                userDescription = "此微博不是您的收藏";
                break;
            case 20706:
                userDescription = "操作失败";
                break;
            case 20801:
                userDescription = "trend_name是空值";
                break;
            case 20802:
                userDescription = "trend_id是空值";
                break;
            case 21001:
                userDescription = "标签参数为空";
                break;
            case 21002:
                userDescription = "标签名太长，请确保每个标签名不超过14个字符";
                break;
            case 21103:
                userDescription = "该用户已经绑定手机";
                break;
            case 21104:
                userDescription = "verifier错误";
                break;
            case 21105:
                userDescription = "你的手机号近期频繁绑定过多个帐号，如果想要继续绑定此帐号，请拨打客服电话400 690 0000申请绑定";
                break;
            case 21108:
                userDescription = "原始密码错误";
                break;
            case 21109:
                userDescription = "新密码错误";
                break;
            case 21110:
                userDescription = "此用户暂时没有绑定手机";
                break;
            case 21113:
                userDescription = "教育信息不存在";
                break;
            case 21115:
                userDescription = "职业信息不存在";
                break;
            case 21117:
                userDescription = "此用户没有qq信息";
                break;
            case 21120:
                userDescription = "此用户没有微号信息";
                break;
            case 21121:
                userDescription = "此微号已经存在";
                break;
            case 21301:
                userDescription = "认证失败";
                break;
            case 21302:
                userDescription = "用户名或密码不正确";
                break;
            case 21303:
                userDescription = "用户名密码认证超过请求限制";
                break;
            case 21304:
                userDescription = "版本号错误";
                break;
            case 21305:
                userDescription = "缺少必要的参数";
                break;
            case 21306:
                userDescription = "Oauth参数被拒绝";
                break;
            case 21307:
                userDescription = "时间戳不正确";
                break;
            case 21308:
                userDescription = "nonce参数已经被使用";
                break;
            case 21309:
                userDescription = "签名算法不支持";
                break;
            case 21310:
                userDescription = "签名值不合法";
                break;
            case 21311:
                userDescription = "consumer_key不存在";
                break;
            case 21312:
                userDescription = "consumer_key不合法";
                break;
            case 21313:
                userDescription = "consumer_key缺失";
                break;
            case 21314:
                userDescription = "Token已经被使用";
                break;
            case 21315:
                userDescription = "Token已经过期";
                break;
            case 21316:
                userDescription = "Token不合法";
                break;
            case 21317:
                userDescription = "Token不合法";
                break;
            case 21318:
                userDescription = "Pin码认证失败";
                break;
            case 21319:
                userDescription = "授权关系已经被解除";
                break;
            case 21320:
                userDescription = "不支持的协议";
                break;
            case 21321:
                userDescription = "未审核的应用使用人数超过限制";
                break;
            case 21322:
                userDescription = "重定向地址不匹配";
                break;
            case 21323:
                userDescription = "请求不合法";
                break;
            case 21324:
                userDescription = "client_id或client_secret参数无效";
                break;
            case 21325:
                userDescription = "提供的Access Grant是无效的、过期的或已撤销的";
                break;
            case 21326:
                userDescription = "客户端没有权限";
                break;
            case 21327:
                userDescription = "token过期";
                break;
            case 21328:
                userDescription = "不支持的 GrantType";
                break;
            case 21329:
                userDescription = "不支持的 ResponseType";
                break;
            case 21330:
                userDescription = "用户或授权服务器拒绝授予数据访问权限";
                break;
            case 21331:
                userDescription = "服务暂时无法访问";
                break;
            case 21332:
                userDescription = "access_token 无效";
                break;
            case 21333:
                userDescription = "禁止使用此认证方式";
                break;
            default:
                userDescription = "Code:" + getError_code();
                break;
        }
    }

    /* (non-Javadoc)
     * @see com.feinno.message.HttpConvertibleOutput#fromHttpResponse(com.ning.http.client.Response, java.lang.Throwable)
     */
    @Override
    public void fromHttpResponse(Response response, Throwable throwable) {
        if (throwable != null) {
            LOGGER.error(throwable.getMessage());
            return;
        }
        if (response.getStatusCode() == 200) {
            try {
                String content;
                if ((content = response.getResponseBody("UTF-8")) != null) {
                    ObjectReader reader = mapper.readerForUpdating(this);
                    reader.readValue(content);
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                error_code = "0";
                error = e.getMessage();
                return;
            }
        } else {
            try {
                ObjectReader reader = mapper.readerForUpdating(this);
                reader.readValue(response.getResponseBody("UTF-8"));
                return;
            } catch (Exception e) {
                LOGGER.error(response.getStatusCode() + "\n" + e.getMessage());
                error_code = "0";
                return;
            }
        }
    }
}
