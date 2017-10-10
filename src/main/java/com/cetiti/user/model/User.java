package com.cetiti.user.model;

import java.util.Date;
import java.util.List;

/**
 * 用户实体
 * 
 * @author iyinlei@126.com
 * @since 2015年4月29日 下午2:55:47
 */
public class User {
	private static final long serialVersionUID = -2213083098326707532L;

    /**
     * 用户来源，1web，2app，3wap，4其他
     */
    private Integer source;

    /**
     * 用户唯一标示，token，所有的接口都需要这个参数，登录注册除外，公共的接口除外
     */
    private String tokenId;

	/** 用户头像 */
	private String avatar;
	
	/** 用户简介 */
	private String summary;
	
	/** 生日 */
	private Date birthday;
	
	/** 个性签名 */
	private String signature;
	
	/** 职称 */
	private String title;
	
	/** 被赞数 */
	private Long loveNumber;
	
	/** 关注数 */
	private Long focusNumber;
	
    /**
     * order by 排序语句
     * 对应数据库表字段 user
     */
    private transient String orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 user
     */
    private transient Integer start;

    /**
     * 分页大小
     * 对应数据库表字段 user
     */
    private transient int pageSize = 10;

    /**
     * 是否去重
     * 对应数据库表字段 user
     */
    private transient boolean distinct;

    /**
     * 对应数据库表字段 user.id
     */
    private String id;

    /**
     * 对应数据库表字段 user.name
     */
    private String name;

    /**
     * 对应数据库表字段 user.nick_name
     */
    private String nickName;

    /**
     * 对应数据库表字段 user.account
     */
    private String account;

    /**
     * 对应数据库表字段 user.email
     */
    private String email;

    /**
     * 对应数据库表字段 user.mobile
     */
    private String mobile;

    /**
     * 用户密码
     */
    private String password;
    
    /**
     * 对应数据库表字段 user.regsiter_date
     */
    private Date registerDate;

    /**
     * 对应数据库表字段 user.age
     */
    private Integer age;

    /**
     * 对应数据库表字段 user.last_login_date
     */
    private Date lastLoginDate;

    /**
     * 对应数据库表字段 user.state
     */
    private Integer state;

    /**
     * 对应数据库表字段 user.level
     */
    private Integer level;

    /**
     * 对应数据库表字段 user.asker
     */
    private Integer asker;

    /**
     * 对应数据库表字段 user.answer
     */
    private Integer answer;

    /**
     * 对应数据库表字段 user.identity_card
     */
    private String identityCard;

    /**
     * 对应数据库表字段 user.identity_type
     */
    private Integer identityType;

    /**
     * 对应数据库表字段 user.alipay
     */
    private String alipay;

    /**
     * 对应数据库表字段 user.weixin
     */
    private String weixin;

    /**
     * 对应数据库表字段 user.qq
     */
    private String qq;

    /**
     * 对应数据库表字段 user.address
     */
    private String address;

    // 以下字段是页面数据封装
    /** 再次输入密码 */
    private String checkPasswd;
    /** 登录成功后重定向的url */
    private String redirectUrl;
    /** 验证码 */
    private String authCode;
    /** 旧密码 */
    private String oldPassword;
    /** 目标对象id */
    private String targetId;
    /** 业务类型 */
    private int type;
    
    /**
     * 设置 order by 排序语句
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 获得 order by 排序语句
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置 start，分页开始记录
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 获得 start，分页开始记录
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 设置 pageSize，分页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获得 pageSize，分页大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置 distinct，是否去重
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 获得 distinct，是否去重
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获得字段 user.id 的值
     *
     * @return the value of user.id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置字段 user.id 的值
     *
     * @param id the value for user.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获得字段 user.name 的值
     *
     * @return the value of user.name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字段 user.name 的值
     *
     * @param name the value for user.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得字段 user.nick_name 的值
     *
     * @return the value of user.nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置字段 user.nick_name 的值
     *
     * @param nickName the value for user.nick_name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获得字段 user.account 的值
     *
     * @return the value of user.account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置字段 user.account 的值
     *
     * @param account the value for user.account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获得字段 user.email 的值
     *
     * @return the value of user.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置字段 user.email 的值
     *
     * @param email the value for user.email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获得字段 user.mobile 的值
     *
     * @return the value of user.mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置字段 user.mobile 的值
     *
     * @param mobile the value for user.mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获得注册时间
     *
     * @return the value of user.register_date
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册时间
     *
     * @param registerDate the value for user.register_date
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 获得字段 user.age 的值
     *
     * @return the value of user.age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置字段 user.age 的值
     *
     * @param age the value for user.age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获得字段 user.last_login_date 的值
     *
     * @return the value of user.last_login_date
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 设置字段 user.last_login_date 的值
     *
     * @param lastLoginDate the value for user.last_login_date
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 获得字段 user.state 的值
     *
     * @return the value of user.state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置字段 user.state 的值
     *
     * @param state the value for user.state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获得字段 user.level 的值
     *
     * @return the value of user.level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置字段 user.level 的值
     *
     * @param level the value for user.level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获得字段 user.asker 的值
     *
     * @return the value of user.asker
     */
    public Integer getAsker() {
        return asker;
    }

    /**
     * 设置字段 user.asker 的值
     *
     * @param asker the value for user.asker
     */
    public void setAsker(Integer asker) {
        this.asker = asker;
    }

    /**
     * 获得字段 user.answer 的值
     *
     * @return the value of user.answer
     */
    public Integer getAnswer() {
        return answer;
    }

    /**
     * 设置字段 user.answer 的值
     *
     * @param answer the value for user.answer
     */
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    /**
     * 获得字段 user.identity_card 的值
     *
     * @return the value of user.identity_card
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 设置字段 user.identity_card 的值
     *
     * @param identityCard the value for user.identity_card
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * 获得字段 user.identity_type 的值
     *
     * @return the value of user.identity_type
     */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
     * 设置字段 user.identity_type 的值
     *
     * @param identityType the value for user.identity_type
     */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    /**
     * 获得字段 user.alipay 的值
     *
     * @return the value of user.alipay
     */
    public String getAlipay() {
        return alipay;
    }

    /**
     * 设置字段 user.alipay 的值
     *
     * @param alipay the value for user.alipay
     */
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    /**
     * 获得字段 user.weixin 的值
     *
     * @return the value of user.weixin
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * 设置字段 user.weixin 的值
     *
     * @param weixin the value for user.weixin
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * 获得字段 user.qq 的值
     *
     * @return the value of user.qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置字段 user.qq 的值
     *
     * @param qq the value for user.qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获得字段 user.address 的值
     *
     * @return the value of user.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置字段 user.address 的值
     *
     * @param address the value for user.address
     */
    public void setAddress(String address) {
        this.address = address;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckPasswd() {
		return checkPasswd;
	}

	public void setCheckPasswd(String checkPasswd) {
		this.checkPasswd = checkPasswd;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLoveNumber() {
		return loveNumber;
	}

	public void setLoveNumber(Long loveNumber) {
		this.loveNumber = loveNumber;
	}

	public Long getFocusNumber() {
		return focusNumber;
	}

	public void setFocusNumber(Long focusNumber) {
		this.focusNumber = focusNumber;
	}

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}