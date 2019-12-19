/**
 * Haoyin cookie manager
 * 
 * @author XIASHIPENG
 */
var HY = {}

HY.DOMAIN = 'haoyin.com';
HY.COOKIE_DOMAIN = '.' + HY.DOMAIN;
HY.ROOT = 'http://www.' + HY.DOMAIN;
HY.ROOT_ENCODED = encodeURIComponent(HY.ROOT);

var HaoyinCookie = function(base, logoutLink, debug) {
	this.base = base;
	this.logoutLink = logoutLink ? '?returnUrl=' + encodeURIComponent(logoutLink) : '';
	this.debug = !!debug;
	this.cookieMap = this._getCookies();
}

/** 调试模式 */
HaoyinCookie.DEBUG = true;

/** 会话 TOKEN 的 Cookie 名字 */
HaoyinCookie.TOKEN = 'TOKEN';
HaoyinCookie.LOGS = ['UID', 'LN', 'LT', 'UN', 'UT', 'OI'];

/** 购物车数量 */
HaoyinCookie.SD = "SD";

/**  购物车内容 */
HaoyinCookie.SC = "SC";

/** 登录检查时效 */
HaoyinCookie.CHECKER_INTERVAL = 5 * 60 * 1000;

/** 未登录时顶部导航 HTML 模版 */
HaoyinCookie.UNLOGIN = ' <h4><span>您好</span>，欢迎光临好印网</h4>'
	+'<li><a href="{0}/auth/logout{1}" >安全退出</a></li>';

HaoyinCookie.LOGIN = '<li style="color:#b2b2b2;"><a href="{0}/order/order-setting-agent.htm" style="margin-right:6px;" hidefocus="true">{1}</a> 欢迎来到好印网</li><li><a href="{0}/authz/logout.htm" target="_top" hidefocus="true">安全退出</a></li>';

/** 美乐家未登录时顶部导航 HTML 模版 */
HaoyinCookie.MELA_LOGIN = '<span><i id="orgId" hidden>{3}</i><a href="javascript:void(0);" hidefocus="true">{1}</a> , 欢迎登陆 ! </span><span style="color: #ccc;">&nbsp;&nbsp;<a href="{0}/org/logout.htm" target="_top" hidefocus="true">安全退出 </a></span>&nbsp;|&nbsp;&nbsp;<a class="img6y5" hidefocus="true" href="{0}/org/cart/shopping-cart.htm">购物车</a>';

HaoyinHotline = '';

/** Cookie 写入模版 */
HaoyinCookie.COOKIE_TEMPLATE = '{0}={1}; domain={2}; path={3}; expires={4}';

/**
 * Cookie 写入
 * @param name cookie 名称
 * @param value cookie 值
 * @param domain cookie 写入域（默认为 HY.COOKIE_DOMAIN ）
 * @param path cookie 写入路径（默认为 /）
 * @param expires cookie 时效（分钟）
 */
HaoyinCookie.writeCookie = function(name, value, domain, path, expires) {
  var date = new Date();
  date.setTime(date.getTime() + expires * 60000);
  document.cookie = HaoyinCookie.format( HaoyinCookie.COOKIE_TEMPLATE, name, encodeURIComponent(value), (domain || HY.COOKIE_DOMAIN), (path || '/'), date.toGMTString() );
}

/** 清除一个 Cookie */
HaoyinCookie.clearCookie = function(name, domain, path) {
  HaoyinCookie.writeCookie(name, '', domain, path, 0);
}

HaoyinCookie.format = function(template) {
    if(arguments.length == 1) {
      return template; 
    }
    for(var i = 1, k = arguments.length; i < k; i++) {
      template = template.replace(new RegExp('\\{' + (i - 1) + '\\}', 'g'), arguments[i]);
    }
    if(template.indexOf('\\{') > -1) {
      template = template.replace('\\{', '{');
    }
    if(template.indexOf('\\}') > -1) {
      template = template.replace('\\}', '}');
    }
    return template;
}

HaoyinCookie.prototype = {
		
	/** 判断用户是否登录 */
	isLogin : function() {
	    if(!this._isTokenCorrect()) {
	      return false;
	    }
	    return (this._findLogin().length <= HaoyinCookie.LOGS.length);
	},
	
	getShoppingCartCount : function() {
	    var count = this.getValue(HaoyinCookie.SD);
	    HaoyinCookie.DEBUG && window.console && console.info('cart count: %s', count);
	    if(isNaN(count)) return 0;
	    return count; 
	},

	getShoppingCartContent : function() {
		return this.getValue(HaoyinCookie.SC);
	},

	/**
	 * 根据 Cookie 的名字获取 Cookie 值
	 */
	getValue : function(name) {
		return this.cookieMap[name];
	},

	/**
	 * 显示登录导航信息
	 */
	showLoginNav : function() {
		var returnUrl = encodeURIComponent( this._getReturnUrl() );
	    var find = this._findLogin();
	    // Token 没找到也不会登录。清除所有已找到的登录 Cookie 信息
	    if ( !this._isTokenCorrect() ) {
	      this._write( HaoyinCookie.format( HaoyinCookie.UNLOGIN + HaoyinHotline, this.base, this._isRegister(returnUrl) ? this._getLinkReturnUrl(returnUrl) : '?returnUrl=' + returnUrl ) );
	      this._clearLogin( find );
	      return false;
	    }
	    // 如果找到的登录 Cookie 信息数量与预定数量不符时也不是登录，清除已找到的登录 Cookie 信息
	    if( find.length != HaoyinCookie.LOGS.length ) {
	      this._clearLogin( find );
	      this._write( HaoyinCookie.format( HaoyinCookie.UNLOGIN + HaoyinHotline, this.base, this._isRegister(returnUrl) ? this._getLinkReturnUrl(returnUrl) : '?returnUrl=' + returnUrl ) );
	      return false;
	    }
	    var name = decodeURI(this.getValue( 'UN' ));
	    if(name == '[UNKNOWN]') {
	      this._write( HaoyinCookie.format( HaoyinCookie.LOGIN_NO_NICKNAME, this.base ));
	      return true;
	    }
	    this._write( HaoyinCookie.format( HaoyinCookie.LOGIN + HaoyinHotline, this.base, name, this.logoutLink ));
	},
	
	/**
	 * 显示美乐家登录导航信息
	 */
	showMelaLoginNav : function() {
		var returnUrl = encodeURIComponent( this._getReturnUrl() );
	    var find = this._findLogin();

	    // Token 没找到也不会登录。清除所有已找到的登录 Cookie 信息
	    if ( !this._isTokenCorrect() ) {
	      this._write( HaoyinCookie.format( HaoyinCookie.UNLOGIN + HaoyinHotline, this.base, this._isRegister(returnUrl) ? this._getLinkReturnUrl(returnUrl) : '?returnUrl=' + returnUrl ) );
	      this._clearLogin( find );
	      return false;
	    }

	    // 如果找到的登录 Cookie 信息数量与预定数量不符时也不是登录，清除已找到的登录 Cookie 信息
	    if( find.length != HaoyinCookie.LOGS.length ) {
	      this._clearLogin( find );
	      //this._write( HaoyinCookie.format( HaoyinCookie.UNLOGIN + HaoyinHotline, this.base, this._isRegister(returnUrl) ? this._getLinkReturnUrl(returnUrl) : '?returnUrl=' + returnUrl ) );
	      return false;
	    }

	    var name = decodeURI(this.getValue( 'UN' ));
	    if(name == '[UNKNOWN]') {
	      this._write( HaoyinCookie.format( HaoyinCookie.LOGIN_NO_NICKNAME, this.base ));
	      return true;
	    }
	    var orgId = decodeURI(this.getValue( 'OI' ));
	    this._write( HaoyinCookie.format( HaoyinCookie.MELA_LOGIN + HaoyinHotline, this.base, name, this.logoutLink, orgId ));
	},

	_isRegister : function(returnUrl) {
	    if (returnUrl.indexOf('register.htm') > 0) {
	      return true;
	    }
	    if (returnUrl.indexOf('register-do.htm') > 0) {
	      return true;
	    }
	    return false;
	},

	 _isTokenCorrect : function() {
	    return true;
	},

	_clearLogin : function(find) {
	    var count = 0;
	    for(var i = 0, k = find.length; i < k; i++) {
	      HaoyinCookie.clearCookie( find[i] );
	      count++;
	    }
	    return count;
	},

	_findLogin : function() {
	    var find = [];
	    for(var i = 0, k = HaoyinCookie.LOGS.length; i < k; i++) {
	      if( this.cookieMap[HaoyinCookie.LOGS[i]] ) {
	        find.push( HaoyinCookie.LOGS[i] );
	      }
	    }
	    return find;
	},

	_getCookies : function() {
	    var cookies = document.cookie.split(/;\s+/);
	    var cookieMap = [];
	   
	    for(var i = 0, k = cookies.length; i < k; i++) {
	      var keyValue = cookies[i].split('=');
	      cookieMap[keyValue[0]] = this._removeVersion1Quote( keyValue[1] );
	    }
	    return cookieMap;
	},

	_getReturnUrl : function() {
	    return location.href.replace(/([?&])(?:[?&]?r=[0-9]+)+(.)?/g, function(a, b, c){
	      if(!c) return '';
	      if(b == '?') return '?';
	      return '&';
	    });
	},

	_getLinkReturnUrl : function(returnUrl) {
	    if (!returnUrl) return '';
	    returnUrl = decodeURIComponent(returnUrl);
	    RegExp.lastIndex = 0;
	    var match = returnUrl.match(/[?&]returnUrl=([^&]+)/);
	    if (!match || match.length < 2) return '';
	    return '?returnUrl=' + match[1];
	},

	_write : function(content) {
	    document.write( content );
	},

	/**
	 * 移除 RFC2109/RFC2965 Cookie 版本 1 中的双引号
	 */
	_removeVersion1Quote : function(value) {
	    if(!value || value.indexOf('"') < 0) return value;
	    return value.replace(/^"/, '').replace(/"$/, '');
	}
	
}