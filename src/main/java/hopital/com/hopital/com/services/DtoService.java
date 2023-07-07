package hopital.com.hopital.com.services;

/**
 * T represente ici l'entité DTO et V l'entité sans DTO
 * @param <T> represente ici l'entité DTO
 * @param <V> l'entité Sans  DTO
 */
public interface DtoService<T,V>{
    T convertEntiyToDTO(V entity);
    V convertDtoToEntity(T entityDto);
}
