package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class); 
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("entering method retrieveAllUsers"); 
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
			
			} 
			l.info("exiting method retrieveAllUsers");  
		}catch (Exception e) {
			l.error("error with method retrieveAllUsers : "+e); 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("entering method addUser"); 
		User uSaved = userRepository.save(u); 
		l.info("exiting method addUser"); 
		return uSaved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("entering method updateUser"); 
		User uSaved = userRepository.save(u); 
		l.info("exiting method updateUser"); 
		return uSaved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("entering method deleteUser"); 
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("exiting method deleteUser"); 
	}

	@Override
	public User retrieveUser(String id) {
		l.info("entering method retrieveUser"); 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u = null;
		try {
			u =  userRepository.findById(Long.parseLong(id)).get(); 
		} catch (Exception e) {
			l.info("exception :",e); 
		}
		l.info("exiting method retrieveUser"); 
		return u; 
	}

}