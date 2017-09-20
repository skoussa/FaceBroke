package facebroke.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Comments")
public class Comment {
	
	// Instance variables to be serialized
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "creator_id")
	private User creator;
	
	@OneToOne
	@JoinColumn(name = "parent_post_id")
	private Post parent;
	
	private String content;
	
	private ZonedDateTime created, updated;
	
	
	// Constructor for Hibernate
	public Comment() {}
	
	/**
	 * Build a Comment
	 * @param creator - user creating the comment
	 * @param parent - parent the comment is on
	 * @param content
	 */
	public Comment(User creator, Post parent, String content) {
		this.parent = parent;
		this.creator = creator;
		this.content = content;
		this.created = this.updated = ZonedDateTime.now();
	}
	
	
	// Getters and Setters
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Post getParent() {
		return this.parent;
	}
	
	public void setParent(Post parent) {
		this.parent = parent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

}