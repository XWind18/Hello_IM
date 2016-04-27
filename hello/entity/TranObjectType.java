package hello.entity;


public enum TranObjectType {
	
	REGISTER, // 注册  
	FORGETPWD, //忘记密码
    LOGIN, // 用户登录  
    LOGOUT, // 用户退出登录  
    FRIENDLOGIN, // 好友上线  
    FRIENDLOGOUT, // 好友下线  
    MESSAGE, // 用户发送消息  
    GROUPMESSAGE,	//群聊消息
    UNCONNECTED, // 无法连接  
    REFRESH,//刷新好友列表   
}
