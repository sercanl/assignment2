package no.uio.inf5750.assignment2.dao.hibernate;
import java.util.Collection;
import java.util.List;

import no.uio.inf5750.assignment2.dao.DegreeDAO;
import no.uio.inf5750.assignment2.model.Degree;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class HibernateDegreeDao implements DegreeDAO
{
    static Logger logger = Logger.getLogger(HibernateDegreeDao.class);
    private SessionFactory sessionFactory;
	/**
     * Persists a degree. An unique id is generated if the object is persisted
     * for the first time, and which is both set in the given degree object and
     * returned.
     * 
     * @param degree the degree to add for persistence.
     * @return the id of the degree.
     */
    public int saveDegree( Degree degree ) {
    	
    	return (Integer) sessionFactory.getCurrentSession().save( degree );
    }

    /**
     * Returns a degree.
     * 
     * @param id the id of the degree to return.
     * @return the degree or null if it doesn't exist.
     */
    public Degree getDegree( int id ) {
    	
    	return (Degree) sessionFactory.getCurrentSession().get( Degree.class, id );
    }

    /**
     * Returns a degree with a specific type.
     * 
     * @param type the type of the degree to return.
     * @return the degree or null if it doesn't exist.
     */
    public Degree getDegreeByType( String type ) {
    	
    	Session session = sessionFactory.openSession();
    	
    	Criteria cr = session.createCriteria(Degree.class);
    	cr.add(Restrictions.eq("type", type));
    	List results = cr.list();
    	
    	if (!results.isEmpty()) { 
    		return (Degree) results.listIterator(0);
    	}
    	else
    		return null; // no such degree exists
    }

    /**
     * Returns all degrees.
     * 
     * @return all degrees.
     */
    public Collection<Degree> getAllDegrees() {
    	
    	Session session = sessionFactory.openSession();
    	Criteria cr = session.createCriteria(Degree.class);
    	return (Collection<Degree>) cr.list();
    }

    /**
     * Deletes a degree.
     * 
     * @param degree the degree to delete.
     */
    public void delDegree( Degree degree ) {
    	Session session = sessionFactory.openSession();
    	session.createCriteria(Degree.class)
               .add(Restrictions.eq("id", degree.getId())).uniqueResult();
    	session.delete(degree);	
    }
}