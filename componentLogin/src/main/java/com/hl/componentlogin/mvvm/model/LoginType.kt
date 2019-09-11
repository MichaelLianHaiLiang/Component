package com.hl.componentlogin.mvvm.model

/**
 * @Author: maijie20180425
 * Time: 2019/9/11
 * Description:
 * 0 代表失败
 * 1 代表成功
 */
enum class LoginType(code: Int?, des: String?) {

    LOGIN_FAILED(0, "登录失败"),
    LOGIN_SUCCESS(1, "登录成功");

}