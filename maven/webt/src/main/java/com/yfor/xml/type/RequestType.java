package com.yfor.xml.type;
/**
 * 清秋类型
 * @author xiaoqiang
 *
 */
public enum RequestType {
	V01, // 省列表查询
	V02, // 车型信息查询
	V03, // 保费测算接口
	V04, // 支付确认接口
	V05, // 银行卡绑定接口
	V06, // 保单列表查询
	V07, // 保单查看详情
	V08, // 订单查看详情（支持继续支付）
	V09, // 保单寄送查询
	V10, // 理赔信息查询
}
