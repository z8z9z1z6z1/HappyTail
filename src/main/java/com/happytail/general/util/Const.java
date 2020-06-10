package com.happytail.general.util;

public class Const {

	public static class NoticeType {
		public static final String ReceiveReply = "ReceiveReply";
		public static final String AtReply = "AtReply";
		public static final String LikeTopic = "LikeTopic";
		public static final String LikeReply = "LikeReply";
		public static final String UpdateTopic = "UpdateTopic";
		public static final String ReceiveReservation = "ReceiveReservation";
	}
	
	public static class Admin {
		public static final String AdminUserId = "1";
		public static final	String AdminUserName = "admin@gmail.com";
	}
	
	public static class ModuleType {
		public static final String Forum = "Forum";
		public static final String Reservation = "Reservation";
	}

	public static class CategoryType {
		public static final String topicCategory = "topicCategory";
		public static final String likeCategory = "likeCategory";
		public static final String reportCategory = "reportCategory";
	}

	public static class ThumbsUpType {
		public static final String topic = "topic";
		public static final String reply = "reply";
	}

	/** 每頁筆數 預設值 **/

	public static final Integer DEFAULT_PAGE_SIZE = 10;

	/** 第一頁 頁碼 **/

	public static final Integer FIRST_PAGE_NUM = 1;

	/** 每頁筆數 參數名稱 **/

	public static final String PAGE_SIZE = "pageSize";

	/** 目前頁碼 參數名稱 **/

	public static final String PAGE_NUM = "pageNum";

	/** 排序欄位 參數名稱 **/

	public static final String ORDER_COLUMNS = "columnNames";

	/** 排序方向 參數名稱 **/

	public static final String ORDER_DIRECTION = "direction";

	/** 排序方向 升冪 **/

	public static final String ORDER_ASC = "ASC";

	/** 排序方向 降冪 **/

	public static final String ORDER_DESC = "DESC";

}
