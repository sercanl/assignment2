package no.uio.inf5750.assignment2.dao.hibernate;
import java.util.Collection;
import java.util.List;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.model.Course;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class HibernateCourseDao implements CourseDAO
{
    static Logger logger = Logger.getLogger(HibernateCourseDao.class);
    private SessionFactory sessionFactory;
    
    /**
     * Persists a course. A unique id is generated if the object is persisted
     * for the first time, and which is both set in the given course object and
     * returned.
     * 
     * @param course the course to add for persistence.
     * @return the id of the course.
     */
    public int saveCourse( Course course ) {
    	
    	return (Integer) sessionFactory.getCurrentSession().save( course );
    }

    /**
     * Returns a course.
     * 
     * @param id the id of the course to return.
     * @return the course or null if it doesn't exist.
     */
    public Course getCourse( int id ) {
    	return (Course) sessionFactory.getCurrentSession().get( Course.class, id );
    }

    /**
     * Returns a course with a specific course code.
     * 
     * @param courseCode the course code of the course to return.
     * @return the course code or null if it doesn't exist.
     */
    public Course getCourseByCourseCode( String courseCode ) {
    	
    	Session session = sessionFactory.openSession();
    	
    	Criteria cr = session.createCriteria(Course.class);
    	cr.add(Restrictions.eq("courseCode", courseCode));
    	List results = cr.list();
    	
    	if (!results.isEmpty()) { 
    		return (Course) results.listIterator(0);
    	}
    	else
    		return null;
    }

    /**
     * Returns a course with a specific name.
     * 
     * @param courseCode the course code of the course to return.
     * @return the course code or null if it doesn't exist.
     */
    public Course getCourseByName( String name ) {
    	Session session = sessionFactory.openSession();
    	
    	Criteria cr = session.createCriteria(Course.class);
    	cr.add(Restrictions.eq("name", name));
    	List results = cr.list();
    	
    	if (!results.isEmpty()) { 
    		return (Course) results.listIterator(0); 
    	}
    	else
    		return null; // no such course exists 
    }

    /**
     * Returns all courses.
     * 
     * @return all courses.
     */
    public Collection<Course> getAllCourses() {
    	
    	Session session = sessionFactory.openSession();
    	Criteria cr = session.createCriteria(Course.class);
    	return (Collection<Course>) cr.list();
    }
    
    /**
     * Deletes a course.
     * 
     * @param course the course to delete.
     */
    public void delCourse( Course course ) {
    	Session session = sessionFactory.openSession();
    	session.createCriteria(Course.class)
               .add(Restrictions.eq("name", course.getName())).uniqueResult();
    	session.delete(course);	
    }
}