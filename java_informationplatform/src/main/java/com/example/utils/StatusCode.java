package com.example.utils;

public class StatusCode {
   public static final int OK=200;//成功
   public static final int ERROR =201;//失败
   public static final int LOGINERROR =202;//用户名或密码错误
   public static final int ACCESSERROR =203;//权限不足
   public static final int REMOTEERROR =204;//远程调用失败
   public static final int REPERROR =205;//重复操作
   public static final int EXIST=206; //存在
   public static final int MAXSCOPE=207; //范围
   public static final int FORMAT=208; //格式不正确
   public static final int AUDIT=209; //审计
}
