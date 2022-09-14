package com.api.bluehappyface.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "blog_post")
public class DevEntity {
	@Id
	private int id;
	@Column
	private String title;
	@Column
	private String subtitle;
	@Column
	private String body;
	@Column
	private String media;
	@Column
	private String tags;
	@Column
	private Date submission_date;
}
