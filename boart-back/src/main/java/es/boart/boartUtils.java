package es.boart;

public class boartUtils {
	static String imgEmbedLeft = "<img src=\"/files/";
	static String imgEmbedRight = "\">";
	static String audioEmbedLeft = "<iframe width=\"100%\" height=\"166\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/";
	static String audioEmbedRight = "&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>";
	static String videoEmbedLeft = "<iframe width=\"100%\" height=\"315px\" src=\"https://www.youtube.com/embed/";
	static String videoEmbedRight = "\" frameborder=\"0\"></iframe>";
	
	public static String getImgEmbedLeft() {
		return imgEmbedLeft;
	}
	public static String getImgEmbedRight() {
		return imgEmbedRight;
	}
	public static String getAudioEmbedLeft() {
		return audioEmbedLeft;
	}
	public static String getAudioEmbedRight() {
		return audioEmbedRight;
	}
	public static String getVideoEmbedLeft() {
		return videoEmbedLeft;
	}
	public static String getVideoEmbedRight() {
		return videoEmbedRight;
	}
	
	


}
