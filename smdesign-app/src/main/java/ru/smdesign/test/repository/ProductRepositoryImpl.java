package ru.smdesign.test.repository;

import org.springframework.stereotype.Repository;
import ru.smdesign.test.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static EntityManagerFactory emf;

    ProductRepositoryImpl() {
        emf = Persistence.createEntityManagerFactory("ogmjpa");
    }

    @Override
    public List<Product> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> results = em.createNativeQuery("db.Product.find({})", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public List<Product> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String queryByName = "db.Product.find({'name':{$regex:'" + name + "', $options:'i'}})";
        List<Product> results = em.createNativeQuery(queryByName,
                Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public Product findById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product results = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public List<Product> findByParameterKeyAndValue(String key, String value) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String queryByParameter = "db.Product.find({'parametres': { $elemMatch: " +
                "{'key':'" + key + "', 'value':'" + value + "'} } })";
        List<Product> results = em.createNativeQuery(queryByParameter,
                Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public Product saveProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
        return product;
    }

}
