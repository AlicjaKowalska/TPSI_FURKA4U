package wizut.tpsi.ogloszenia.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;


@Service
@Transactional
public class OffersService {
    
    @PersistenceContext
    private EntityManager em;
    
    public CarManufacturer getCarManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }
    
    public CarModel getModel(int id){
        return em.find(CarModel.class, id);
    }
    
    public Offer getOffer3(int id) {
        String jpql = "select cm from Offer cm where cm.id = :id";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    public Offer getOffer(int id) {
        return em.find(Offer.class, id);
    }
    
    public List<FuelType> getFuelTypes() {
        String jpql = "select cm from FuelType cm order by cm.name";
        TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
        List<FuelType> result = query.getResultList();
        return result;
    }
    
    public List<CarModel> getCarModels() {
        String jpql = "select cm from CarModel cm order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        List<CarModel> result = query.getResultList();
        return result;
    }
    
    public List<BodyStyle> getBodyStyles() {
        String jpql = "select cm from BodyStyle cm order by cm.name";
        TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
        List<BodyStyle> result = query.getResultList();
        return result;
    }
    
    public List<CarManufacturer> getCarManufacturers() {
        String jpql = "select cm from CarManufacturer cm order by cm.name";
        TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
        List<CarManufacturer> result = query.getResultList();
        return result;
        
    }
    
    public List<CarModel> getCarModels(int manufacturerId) {
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }
    
    public List<Offer> getOffers() {
        String jpql = "select cm from Offer cm order by cm.id";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        List<Offer> result = query.getResultList();
        return query.getResultList();
    }
    
     public List<Offer> getOffersByModel(int modelId) {
        String jpql = "select cm from Offer cm where cm.model.id = :id order by cm.id";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);
        return query.getResultList();
    }
    
    public List<Offer> getOffersByManufacturer(int manufacturerId) {
        String jpql = "select cm from Offer cm where cm.model.manufacturer.id = :id order by cm.id";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }
    
     public List<CarModel> getManufacturerModels(int modelId) {
        CarModel found = em.find(CarModel.class, modelId); 
        int Id_manufacturer =found.getManufacturer().getId();
         
        String jpql = "select cm from car_model cm where cm.manufacturer.id = :id order by cm.id";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", Id_manufacturer);
        return query.getResultList();
    }
    
    
    public Offer createOffer(Offer offer) {
        em.persist(offer);
        return offer;
    }

    public Offer deleteOffer(Integer id) {
    Offer offer = em.find(Offer.class, id);
        em.remove(offer);
        return offer;
    }
    
    public Offer saveOffer(Offer offer) {
        return em.merge(offer);
    }
    
}