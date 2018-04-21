package arch.in.clean_arch_poc.data.mapper;

public interface Mapper<E, D> {
    D mapFromEntity(E entity);

    E mapToEntity(D data);
}
