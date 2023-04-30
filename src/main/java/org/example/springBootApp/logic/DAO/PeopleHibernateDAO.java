package org.example.springBootApp.logic.DAO;

import org.example.springBootApp.logic.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class PeopleHibernateDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public PeopleHibernateDAO(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Transactional(readOnly = true)
    public List<Person> getPeople() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person getPerson(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.openSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        person.setAddress(updatedPerson.getAddress());
        person.setMail(updatedPerson.getMail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }
}