<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="allPayAPIForm"
		action="https://payment-stage.ecPay.com.tw/Cashier/AioCheckOut/V5"
		method="post">
		<input type="hidden" name="NeedExtraPaidInfo" value="N"><input
			type="hidden" name="ReturnURL" value="http://211.23.128.214:5000"><input
			type="hidden" name="CheckMacValue"
			value="6DE9934FBFDB0A6C918A0AA1D0DC3D6B618544E65F0ABFEEB180E81E1AF1716D"><input
			type="hidden" name="StoreExpireDate" value="3"><input
			type="hidden" name="InvoiceItemPrice" value="50"><input
			type="hidden" name="InvoiceItemTaxType" value="1"><input
			type="hidden" name="CustomerPhone" value="0911429215"><input
			type="hidden" name="CustomerIdentifier" value=""><input
			type="hidden" name="CustomerID" value="123456"><input
			type="hidden" name="PaymentInfoURL" value=""><input
			type="hidden" name="ClientRedirectURL" value=""><input
			type="hidden" name="StoreID" value=""><input type="hidden"
			name="EncryptType" value="1"><input type="hidden"
			name="InvoiceItemName" value="%E6%B8%AC%E8%A9%A6"><input
			type="hidden" name="TaxType" value="1"><input type="hidden"
			name="IgnorePayment" value=""><input type="hidden"
			name="PaymentType" value="aio"><input type="hidden"
			name="ClearanceMark" value=""><input type="hidden"
			name="InvoiceItemCount" value="1"><input type="hidden"
			name="OrderResultURL" value=""><input type="hidden"
			name="PlatformID" value=""><input type="hidden"
			name="LoveCode" value="X123456"><input type="hidden"
			name="CustomerEmail" value=""><input type="hidden"
			name="ItemName" value="TestItem"><input type="hidden"
			name="InvoiceMark" value="Y"><input type="hidden"
			name="ChoosePayment" value="CVS"><input type="hidden"
			name="MerchantID" value="2000132"><input type="hidden"
			name="InvType" value="07"><input type="hidden"
			name="CustomerName" value="Mark"><input type="hidden"
			name="TradeDesc" value="test Description"><input
			type="hidden" name="ClientBackURL" value=""><input
			type="hidden" name="InvoiceRemark" value=""><input
			type="hidden" name="CarruerNum" value=""><input type="hidden"
			name="Print" value="0"><input type="hidden"
			name="CustomField4" value=""><input type="hidden"
			name="Desc_4" value=""><input type="hidden"
			name="TotalAmount" value="50"><input type="hidden"
			name="CustomField3" value=""><input type="hidden"
			name="Desc_3" value=""><input type="hidden" name="DelayDay"
			value="1"><input type="hidden" name="CustomerAddr"
			value="%E5%8F%B0%E5%8C%97%E5%B8%82%E5%8D%97%E6%B8%AF%E5%8D%80%E4%B8%89%E9%87%8D%E8%B7%AF"><input
			type="hidden" name="CustomField2" value=""><input
			type="hidden" name="Desc_2" value=""><input type="hidden"
			name="MerchantTradeDate" value="2017/01/01 08:05:23"><input
			type="hidden" name="CustomField1" value=""><input
			type="hidden" name="Desc_1" value=""><input type="hidden"
			name="ChooseSubPayment" value=""><input type="hidden"
			name="InvoiceItemWord" value="%E5%80%8B"><input type="hidden"
			name="MerchantTradeNo" value="7e6af66c0e9248cb8982"><input
			type="hidden" name="ItemURL" value=""><input type="hidden"
			name="RelateNumber" value="test201217test"><input
			type="hidden" name="Remark" value=""><input type="hidden"
			name="DeviceSource" value=""><input type="hidden"
			name="Donation" value="2"><input type="hidden"
			name="CarruerType" value="1">
		<script language="JavaScript">
			allPayAPIForm.submit()
		</script>
	</form>

</body>
</html>