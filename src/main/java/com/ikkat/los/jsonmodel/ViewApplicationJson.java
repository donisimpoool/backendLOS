package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.ApplicationScoreEntity;
import com.ikkat.los.entity.ViewApplicationEntityV1;

public class ViewApplicationJson {
	private ViewApplicationEntityV1 viewapp;
	private ApplicationScoreEntity viewscore;
	public ViewApplicationEntityV1 getViewapp() {
		return viewapp;
	}
	public void setViewapp(ViewApplicationEntityV1 viewapp) {
		this.viewapp = viewapp;
	}
	public ApplicationScoreEntity getViewscore() {
		return viewscore;
	}
	public void setViewscore(ApplicationScoreEntity viewscore) {
		this.viewscore = viewscore;
	}
}
