package com.sandesh.learn.mybatis_mysql.dao;
 

import java.util.List;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sandesh.learn.mybatis_mysql.vo.Person;
 
 
public interface PersonDAO {
 
    
 
    /**
     * Returns the list of all Person instances from the database.
     * @return the list of all Person instances from the database.
     */
    @SuppressWarnings("unchecked")
    public  List<Person> selectAll();
    /**
     * Select instance of Person from the database.
     * @param person the instance to be persisted.
     */
   public Person selectById(int id);
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
   public int insert(Person person);
    /**
   * Update an instance of Person into the database.
   * @param person the instance to be persisted.
   */
  	public void update(Person person);
 
    /**
     * Delete an instance of Person from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id);
}