package com.api.bluehappyface.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog_post")
public class DevEntity {
	@Id
	private Long id;
	@Column
	private String title;
	@Column
	private String sub_title;
	@Column
	private String body;
	@Column
	private String media;
	@Column
	private String tags;
	@Column
	private Date submission_date;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getsub_title() {
		return sub_title;
	}

	public String getBody() {
		return body;
	}

	public String getMedia() {
		return media;
	}

	public String getTags() {
		return tags;
	}

	public Date getsubmission_date() {
		return submission_date;
	}
}
