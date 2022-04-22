package com.bookwaale.service.repository;

import com.bookwaale.service.dto.response.BookPreviewResponseDTO;
import com.bookwaale.service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b where b.author.id=?1")
    List<Book> findAllByAuthorId(Long authorId);
}
