package com.sandesh.learn.mybatis_mysql;

import java.util.List;



import com.sandesh.learn.mybatis_mysql.mybatis.MyBatisConnectionFactory;
import com.sandesh.learn.mybatis_mysql.dao.PersonDAO;
import com.sandesh.learn.mybatis_mysql.vo.Person;



public class Main {

	public static void main(String args[]){
		
		// Laod spring-config.xml file
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hmkcode/config/spring-config.xml");
		
		//get jdbcTemplatePersonDAO
		PersonDAO personDAO = new PersonDAO(MyBatisConnectionFactory.getSqlSessionFactory());

		//create person bean to insert
		Person person = new Person();
		person.setId(19);
		person.setName("Person 1");
		
		//( 1 ) insert person 
		personDAO.insert(person);

		//**set name of person
		person.setId(48);
		person.setName("Person 2");	
		//** insert another person
		int id = personDAO.insert(person);
		
		//( 2 ) select persons by id
		personDAO.selectById(id);
		
		//( 3 ) select all
		List<Person> persons = personDAO.selectAll();
		
		//**set name of all persons
		for(int i = 0; i < persons.size(); i++){
			persons.get(i).setName("Person Name "+i);
			//( 4 ) update person
			personDAO.update(persons.get(i));
		}
				
		//**check update
		persons = personDAO.selectAll();
		
		personDAO.delete(id);


	}
}
