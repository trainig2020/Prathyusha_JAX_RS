package org.demo.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.demo.messenger.database.DatabaseClass;
import org.demo.messenger.model.Message;
import org.demo.messenger.model.Comment;

public class CommentService {


	private Map<Long, Message> messages= DatabaseClass.getMessages();

	
	public List<Comment> getAllComments(long messageId){
		
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	
	
	public Comment getComment(long messageId,long commentId) {
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	
	public Comment addComment(long messageId,Comment comment) {
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
		
	}
	
	public Comment updateComment(long messageId,Comment comment) {
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		if(comment.getId() <= 0) {
			return null;
		}
		
		comments.put(comment.getId(), comment);
		return comment;
		
	}
	
	public Comment removeComment(long messageId,long commentId) {
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
	
	
	
	
	
}
