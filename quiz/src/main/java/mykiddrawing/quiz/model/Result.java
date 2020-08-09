package mykiddrawing.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Results")
public class Result extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@NotBlank
    private String topic;

	@NotBlank
    private Integer score;

    @NotBlank
    private Integer coin;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
	
	public Result()
	{
		
	}

	public Result( int id,  String topic, int score,int coin, User user) {
		super();
		this.id=id;
		this.topic=topic;
		this.score=score;
		this.coin=coin;
		this.user = user;
	}

    // Getters and Setters ... (Omitted for brevity)


	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	

	public String getTopic() {
		return topic;
	}

	public Integer getScore() {
		return score;
	}

	public Integer getCoin() {
		return coin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}