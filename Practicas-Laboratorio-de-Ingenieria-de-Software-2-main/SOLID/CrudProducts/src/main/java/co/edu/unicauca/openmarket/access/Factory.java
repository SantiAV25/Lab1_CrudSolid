package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;

/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IRepository<Product> getRepository(String type) {

         IRepository<Product> result = null;

        switch (type) {
            case "default":
                result = new ProductRepository();
                break;
        }

        return result;

    }

    public  IRepository<Category> getRepositoryCategory(String type) {

         IRepository<Category> result = null;

        switch (type) {
            case "default":
                result = new CategoryRepository();
                break;
        }

        return result;

    }
}