package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.exceptions.AuthorNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Author;
import br.com.caelum.fj36.rest.shared.models.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToProductConverter implements Converter<ProductInfoDTO, Product> {

    private final AuthorRepository repository;

    public ProductDTOToProductConverter(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product convert(ProductInfoDTO source) {
        Long authorId = source.getAuthorId();

        Author author = repository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(String.format("Not found author with id %s", authorId)));

        return new Product( source.getIsbn(),
                            source.getName(),
                            source.getPrice(),
                            author);
    }

}
