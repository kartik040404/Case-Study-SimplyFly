package com.example.simplyfly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.repository.UserRepo;



@Service
public class MyDbUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		 User  registerUser= userRepo.findByEmail(email);
				
		if(registerUser==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("UserNotFound Exception");
		}
		
		
		UserDetails priciples= new UserDetails() {
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				SimpleGrantedAuthority sga=new SimpleGrantedAuthority("ROLE_"+registerUser.getRole().name());
				
				Collection<SimpleGrantedAuthority> collectionObj=new ArrayList<SimpleGrantedAuthority>();
				collectionObj.add(sga);
				return collectionObj;

			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return registerUser.getPassword();
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return registerUser.getEmail();
			}
			
		};
		return priciples;
	}

}
