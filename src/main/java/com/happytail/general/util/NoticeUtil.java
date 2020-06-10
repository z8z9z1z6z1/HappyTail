package com.happytail.general.util;

import com.happytail.general.util.Const.NoticeType;

public class NoticeUtil {
	
	public static void main(String[] args) {
		NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReply);
		NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReservation);
		System.out.println(NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReply));
		System.out.println(NoticeUtil.getNoticeTemplate(NoticeType.AtReply));
		System.out.println(NoticeUtil.getNoticeTemplate(NoticeType.LikeTopic));
		System.out.println(NoticeUtil.getNoticeTemplate(NoticeType.LikeReply));
		System.out.println(NoticeUtil.getNoticeTemplate(NoticeType.UpdateTopic));
		
		String template = NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReply);
		String template2 = NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReservation);
		System.out.println(String.format(template, "AAA","123456789"));
	}

	
	public static String getNoticeTemplate(String type) {
		String template = "";
		
		switch(type) {
			case NoticeType.ReceiveReply:
				template = "%s 回覆了你的文章 %s";
				break;
			
			case NoticeType.AtReply:
				template = "%s 在回覆中提及了你";
				break;
			
			case NoticeType.LikeTopic:
				template = "%s 對你的文章 %s 按了 %s 表示心情";
				break;
				
			case NoticeType.LikeReply:
				template = "%s 對你的回覆按了讚";
				break;
				
			case NoticeType.UpdateTopic:
				template = "追蹤的文章 %s 更新了，快去看看吧！";
				break;
			
			case NoticeType.ReceiveReservation:
				template = "使用者 %s %s 了";
				break;
				
			default: 
				template = "";
				break;
		}
		
		return template;
	}
	

}
