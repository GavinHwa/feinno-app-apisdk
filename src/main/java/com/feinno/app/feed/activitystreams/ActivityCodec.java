/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;

public class ActivityCodec {

	private static final Gson GSON;

	static {
		GSON = new GsonBuilder().registerTypeAdapter(ActivityObject.class,
				new ActivityObjectDeserializer()).create();
	}

	/**
	 * 推荐使用方法 obj2Json
	 * 
	 * @param activity
	 * @return
	 * @throws java.io.IOException
	 */
	public static String toJson(Activity activity) throws IOException {
		return GSON.toJson(activity);
	}

	public static String toJson(ActivityObject activity) throws IOException {
		return GSON.toJson(activity);
	}

	/**
	 * 推荐使用方法 json2Obj
	 *
	 * @param activity
	 * @return
	 * @throws java.io.IOException
	 */

	public static ActivityObject fromJson(String activity) throws IOException {

		return GSON.fromJson(activity, ActivityObject.class);
	}

	public static String obj2Json(Object obj) throws IOException {

		return GSON.toJson(obj);
	}

	public static Object json2Obj(String json) throws IOException {

		return GSON.fromJson(json, ActivityObject.class);
	}

	/**
	 * 推荐使用方法 obj2Json
	 *
	 * @param activityapp
	 * @return
	 * @throws java.io.IOException
	 */
	public static String toJsonApp(ActivityApp activityapp) throws IOException {

		return GSON.toJson(activityapp);
	}

	/**
	 * 推荐使用方法 json2Obj
	 *
	 * @param activityapp
	 * @return
	 * @throws java.io.IOException
	 */
	public static ActivityApp fromJsonApp(String activityapp)
			throws IOException {
		return GSON.fromJson(activityapp, ActivityApp.class);
	}

	/**
	 * public static String toJson(ActivityObject activity) throws IOException {
	 * return GSON.toJson(activity); }
	 */
	public static class ActivityObjectDeserializer implements
			JsonDeserializer<ActivityObject> {

		@Override
		public ActivityObject deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			String objType = json.getAsJsonObject().get("obj_type")
					.getAsString();
			// 兼容豆瓣
			if (objType.equals("book") || objType.equals("movie")
					|| objType.equals("music")) {
				return context.deserialize(json, ActivityArticle.class);
			}
			if (objType.equals(ActivityObjectType.ARTICLE)) {
				return context.deserialize(json, ActivityArticle.class);
			}
			if (objType.equals(ActivityObjectType.PHOTO_ALBUM)) {
				return context.deserialize(json, ActivityAlbum.class);
			}
			if (objType.equals(ActivityObjectType.PHOTO)) {
				return context.deserialize(json, ActivityPhoto.class);
			}
			if (objType.equals(ActivityObjectType.FILE)) {
				return context.deserialize(json, ActivityFile.class);
			}
			if (objType.equals(ActivityObjectType.VIDEO)) {
				return context.deserialize(json, ActivityVideo.class);
			}
			if (objType.equals(ActivityObjectType.SERVICE)) {
				return context.deserialize(json, ActivityService.class);
			}
			if (objType.equals(ActivityObjectType.MEDAL)) {
				return context.deserialize(json, ActivityMedal.class);
			}
			if (objType.equals(ActivityObjectType.STATUS)) {
				return context.deserialize(json, ActivityStatus.class);
			}
			if (objType.equals(ActivityObjectType.COMMENT)) {
				return context.deserialize(json, ActivityComment.class);
			}
			

			// 签到的状态解序列化
			if (objType.equals(ActivityObjectType.CHECKIN)) {
				return context.deserialize(json, ActivityStatusCheckin.class);
			}
			if (objType.equals(ActivityObjectType.PERSON)) {
				return context.deserialize(json, ActivityAuthor.class);
			}
			if (objType.equals(ActivityObjectType.BOOKMARK)) {
				return context.deserialize(json, ActivityBookmark.class);
			}
			if (objType.equals(ActivityObjectType.APP)) {
				return context.deserialize(json, ActivityApp.class);
			}

			if (objType.equals(ActivityObjectType.ACTIVITY)) {
				return context.deserialize(json, Activity.class);
			}
			throw new JsonParseException("invalid obj_type=" + objType);
		}
	}
}
