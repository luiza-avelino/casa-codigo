package com.example.casa_do_codigo.service;

import com.example.casa_do_codigo.controllers.dto.request.CreateBookDto;
import com.example.casa_do_codigo.entites.AuthorEntity;
import com.example.casa_do_codigo.entites.BookEntity;
import com.example.casa_do_codigo.entites.CategoryEntity;
import com.example.casa_do_codigo.exceptions.FieldAlreadyInUseException;
import com.example.casa_do_codigo.exceptions.NotFoundException;
import com.example.casa_do_codigo.repository.AuthorRepository;
import com.example.casa_do_codigo.repository.BookRepository;
import com.example.casa_do_codigo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public Long create(CreateBookDto body) {
        if (bookRepository.existsByIsbn(body.isbn().toLowerCase())) {
            throw new FieldAlreadyInUseException("ISBN already in use");
        }

        if (bookRepository.existsByTitle(body.title().toLowerCase())) {
            throw new FieldAlreadyInUseException("Title already in use");
        }

        CategoryEntity category = categoryRepository.findByName(body.category())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        AuthorEntity author = authorRepository.findById(body.authorId())
                .orElseThrow(() -> new NotFoundException("Author not found"));

        var entity = new BookEntity();
        entity.setAuthor(author);
        entity.setCategory(category);
        entity.setIsbn(body.isbn());
        entity.setPrice(body.price());
        entity.setTitle(body.title());
        entity.setNumberOfPages(body.numberOfPages());
        entity.setSummary(body.summary());
        entity.setTableOfContents(body.tableOfContents());
        entity.setReleaseDate(body.releaseDate());

        return bookRepository.save(entity).getId();
    }
}
