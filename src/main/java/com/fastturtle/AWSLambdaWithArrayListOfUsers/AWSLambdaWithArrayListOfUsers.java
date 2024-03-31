package com.fastturtle.AWSLambdaWithArrayListOfUsers;

import java.util.ArrayList;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastturtle.AWSLambdaWithArrayListOfUsers.AWSLambdaWithArrayListOfUsers.RequestClass;

public class AWSLambdaWithArrayListOfUsers implements RequestHandler<RequestClass, String> {
	
	
	@Override
	public String handleRequest(RequestClass input, Context context) {
		ArrayList<User> users = input.getUsers();
		
		String name1 = users.get(0).getName();
		name1 = name1.replace('a', 'A');
		
		String name2 = users.get(1).getName();
		name2 = name2.replace('b', 'B');
		
		int age1 = users.get(0).getAge();
		int age2 = users.get(1).getAge();
		
		age1++;
		age2++;
		StringBuilder sb = new StringBuilder();
		sb.append(name1 + " ");
		sb.append(name2 + " ");
		sb.append(age1);
		sb.append(" ");
		sb.append(age2);
		
		return sb.toString();
		
	}
		
	
	
	public static class RequestClass {
		private ArrayList<User> users;

		public ArrayList<User> getUsers() {
			return users;
		}

		public void setUsers(ArrayList<User> users) {
			this.users = users;
		}
		
	}

}
