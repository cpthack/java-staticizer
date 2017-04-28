package com.github.cptahck.commons.staticizer.exception;

/**
 * 自定义应用级别非受检异常
 * 
 * @author  cpthack cpt@jianzhimao.com
 * @date    Jul 23, 2016 4:36:16 PM <br/>
 * @version 
 * @since   JDK 1.7
 */
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = -9084561727097703075L;
  
  protected String code;
  
  protected String message; 
  
  public ApplicationException() {
    super();
  }
  
  /**
   * @param message
   */
  public ApplicationException(String message) {
    super(message);
    this.message = message;
  }
  
  public ApplicationException(String code, String message){
    super(code + " : " + message);
    this.code = code;
    this.message = message;
  }
  
  
  /**
   * @param t
   */
  public ApplicationException(Throwable t) {
    super(t);
  }  

  /**
   * @see java.lang.Throwable#fillInStackTrace()
   */
  @Override
  public synchronized Throwable fillInStackTrace() {
//    return super.fillInStackTrace();
     // 为了提高性能，不记录堆栈信息
     return null;
  }

  public String code() {
    return code;
  }

  public String message() {
    return message;
  }
  
}
