package br.com.caelum.fj36.rest.models;

import br.com.caelum.fj36.rest.products.UpdateProductCommand;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private static final AtomicLong counter = new AtomicLong();

    private Long id;
    private String isbn;
    private String name;
    private BigDecimal price;
    private Author author;


    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private Product() { }



    public Product(String isbn, String name, BigDecimal price, Author author) {
        this.id = counter.incrementAndGet();
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public void updateBy(UpdateProductCommand updateCommand) {
        isbn = updateCommand.getIsbn();
        name = updateCommand.getName();
        price = updateCommand.getPrice();
    }
}
