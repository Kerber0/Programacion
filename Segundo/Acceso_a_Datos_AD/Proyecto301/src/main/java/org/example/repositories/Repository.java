package org.example.repositories;

import org.hibernate.Session;

import java.util.Optional;

public class Repository<T> {

    private final Session session;

    public Repository(Session session) {
        this.session = session;
    }

    // CREATE
    public void persist(T entity) {
        session.persist(entity);
    }

    // READ por ID
    public T findById(Class<T> clazz, int id) {
        return session.get(clazz, id);
    }

    //READ por Field
    public Optional<T> findOneByField(Class<T> clazz, String field, Object value) {
        String hql = "from " + clazz.getSimpleName() + " e where e." + field + " = :value";
        return session.createQuery(hql, clazz)
                .setParameter("value", value)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    // UPDATE
    public T merge(T entity) {
        return session.merge(entity);
    }

    // DELETE
    public void remove(T entity) {
        session.remove(entity);
    }

    // EXISTE POR ID (GENÉRICO)
    public boolean existsById(Class<T> clazz, int id) {
        return session.get(clazz, id) != null;
    }

    public boolean existsByField(Class<T> clazz, String field, Object value) {
        String hql = "select count(e) from " + clazz.getSimpleName()
                + " e where e." + field + " = :value";

        Long count = session.createQuery(hql, Long.class)
                .setParameter("value", value)
                .getSingleResult();

        return count > 0;
    }

    public int nextId(Class<T> clazz) {
        String hql = "select max(e.id) from " + clazz.getSimpleName() + " e";

        Integer maxId = session.createQuery(hql, Integer.class)
                .getSingleResult();

        return (maxId == null) ? 1 : maxId + 1;
    }

}
