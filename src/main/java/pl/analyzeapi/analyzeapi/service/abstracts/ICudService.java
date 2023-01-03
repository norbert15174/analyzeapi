package pl.analyzeapi.analyzeapi.service.abstracts;

public interface ICudService<T> {

    T create(T entity);

    T update(T entity);

}
