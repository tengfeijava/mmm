package com.example.utils;

import com.example.index.pojo.Install;

import java.util.List;

/*
{
  "code": 0,
  "flag": true,
  "message": "string",
  "data": {
    "total": 0,
    "rows": [
      {
        "id": "string",
        "labelname": "string",
        "state": "string",
        "count": 0,
        "recommend": "string"
      }
    ]
  }
}
 */
public class Result {
   private Integer code;
   private Boolean flag;
   private String message;
   private Object  data;
   private Object  pojo;

   public Result(boolean flag, int ok, List<Install> list) {
   }



   public Result(Boolean flag, Integer code, String message, Object data, Object pojo) {
      this.code = code;
      this.flag = flag;
      this.message = message;
      this.data = data;
      this.pojo =pojo;
   }
   public Result(Boolean flag, Integer code,  String message, Object data) {
      this.code = code;
      this.flag = flag;
      this.message = message;
      this.data = data;
   }



   public Result(Boolean flag, Integer code, String message) {
      this.code = code;
      this.flag = flag;
      this.message = message;
   }

   public Integer getCode() {
      return code;
   }

   public void setCode(Integer code) {
      this.code = code;
   }

   public Boolean getFlag() {
      return flag;
   }

   public void setFlag(Boolean flag) {
      this.flag = flag;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public Object getData() {
      return data;
   }

   public void setData(Object data) {
      this.data = data;
   }

   public Object getPojo() {
      return pojo;
   }

   public void setPojo(Object pojo) {
      this.pojo = pojo;
   }
}
