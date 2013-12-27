package thirdparty.rss;



public class FetchContext {
	private String lastSyncTime;//使用String是为了兼容没有pubdate的rss。
	private boolean hasChanged;//表明lastSyncTime和lastSyncTimeS是否变化过。变化过且超过十分钟就要存一次数据库啊
	private long lastSQLTime;//上次保存到sql的时间
	private String titleXpath;//必须有的
	private String pubDateXpath;//如果没有pubdate，则填写titlexpath的内容，这样采用title作为是否新发布的依据。
	private String textXpath;//必须有的
	private String itemXpath;//必须有的,表示一个item的位置
	private boolean rssUpward;//必须有的,表示rss中目标的发布顺序。如果最上方是最新的，则此字段为true
	
	public FetchContext(){
		lastSyncTime = null;
		setHasChanged(false);
		lastSQLTime = System.currentTimeMillis();
	}

	public String getLastSyncTime() {
		return lastSyncTime;
	}

	public void setLastSyncTime(String lastSyncTimeS) {
		this.lastSyncTime = lastSyncTimeS;
		setHasChanged(true);
	}
	
	public boolean firstSync(){
		return lastSyncTime == null;
	}
	
	/**
	 * 返回说明该用户的状态是否需要保存进入数据库。如果需要，会当作立刻更新了sql数据库。
	 * 但实际写入数据库的动作要自己做。
	 * @return 是否需要把cotext写入数据库
	 */
	public boolean needSQL(){
		long current = System.currentTimeMillis();
		boolean savedOver12Hours = (current - lastSQLTime) > (12 * 60 * 60 * 1000);
		if(savedOver12Hours && isHasChanged()){
			lastSQLTime = current;
			setHasChanged(false);
			return true;
		}
		return false;
	}

	public String getTitleXpath() {
		return titleXpath;
	}

	public void setTitleXpath(String titleXpath) {
		this.titleXpath = titleXpath;
	}

	public String getPubDateXpath() {
		return pubDateXpath;
	}

	public void setPubDateXpath(String pubDateXpath) {
		this.pubDateXpath = pubDateXpath;
	}

	public String getTextXpath() {
		return textXpath;
	}

	public void setTextXpath(String textXpath) {
		this.textXpath = textXpath;
	}

	public String getItemXpath() {
		return itemXpath;
	}

	public void setItemXpath(String itemXpath) {
		this.itemXpath = itemXpath;
	}

	public boolean isRssUpward() {
		return rssUpward;
	}

	public void setRssUpward(boolean rssUpward) {
		this.rssUpward = rssUpward;
	}

	public boolean isHasChanged() {
		return hasChanged;
	}

	public void setHasChanged(boolean hasChanged) {
		this.hasChanged = hasChanged;
	}

	/**
	 * @return the lastSQLTime
	 */
	public long getLastSQLTime() {
		return lastSQLTime;
	}

	/**
	 * @param lastSQLTime the lastSQLTime to set
	 */
	public void setLastSQLTime(long lastSQLTime) {
		this.lastSQLTime = lastSQLTime;
	}
	

}
