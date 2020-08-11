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
	
	/*
	 * public MessageService() { messages.put(1L,new
	 * Message(1,"Hello World","Prathyuhsa")); messages.put(2L,new
	 * Message(2,"Hello Jersey","Anusha"));
	 * 
	 * }
	 */
	
	public List<Comment> getAllComments(long messageId){
		
		Map<Long, Comment> comments= messages.get(messageId).getComments();
		
		return new ArrayList<Comment>(comments.values());
	}
	
	/*
	 * public List<Message> getAllMessagesForYear(int year){ List<Message>
	 * messagesForyear = new ArrayList<>(); Calendar cal = Calendar.getInstance();
	 * 
	 * for(Message message : messages.values()) { cal.setTime(message.getCreated());
	 * if(cal.get(Calendar.YEAR)== year) { messagesForyear.add(message); } } return
	 * messagesForyear; }
	 * 
	 * public List<Message> getAllMessagesPaginated(int start,int size){
	 * ArrayList<Message> list= new ArrayList<Message>(messages.values()); if(start
	 * + size > list.size()) return new ArrayList<Message>();
	 * 
	 * return list.subList(start, start + size); }
	 */
	
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
