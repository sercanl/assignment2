package no.uio.inf5750.assignment2.dao.hibernate;
import java.util.Collection;
import java.util.List;

import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Student;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class HibernateStudentDao implements StudentDAO
{
    static Logger logger = Logger.getLogger(HibernateStudentDao.class);
    private SessionFactory sessionFactory;
    /**
     * Persists a student. An unique id is generated if the object is persisted
     * for the first time, and which is both set in the given student object and
     * returned.
     * 
     * @param student the student to add for persistence.
     * @return the id of the student.
     */
    public int saveStudent( Student student ) {
    	
    	return (Integer) sessionFactory.getCurrentSession().save( student );
    }
    
    /**
     * Returns a student.
     * 
     * @param id the id of the student to return.
     * @return the student or null if it doesn't exist.
     */
    public Student getStudent( int id ) {
    	
    	return (Student) sessionFactory.getCurrentSession().get( Student.class, id );
    }

    /**
     * Returns a student with a specific name.
     * 
     * @param name the name of the student to return.
     * @return the student or null if it doesn't exist.
     */
    public Student getStudentByName( String name ) {
    	
    	Session session = sessionFactory.openSession();
    	
    	Criteria cr = session.createCriteria(Student.class);
    	cr.add(Restrictions.eq("name", name));
    	List results = cr.list();
    	
    	if (!results.isEmpty()) { 
    		return (Student) results.listIterator(0);
    	}
    	else
    		return null; // no such student exists
    }

    /**
     * Returns all students.
     * 
     * @return all students.
     */
    public Collection<Student> getAllStudents() {
    	
    	Session session = sessionFactory.openSession();
    	Criteria cr = session.createCriteria(Student.class);
    	return (Collection<Student>) cr.list();
    }

    /**
     * Deletes a student.
     * 
     * @param student the student to delete.
     */
    public void delStudent( Student student ) {
    	Session session = sessionFactory.openSession();
    	session.createCriteria(Student.class)
               .add(Restrictions.eq("id", student.getId())).uniqueResult();
    	session.delete(student);
    }
}