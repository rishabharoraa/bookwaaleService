package com.bookwaale.service.dto.response;

import com.bookwaale.service.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class BookPreviewResponseDTO implements Serializable {
    Long id;
    String title;

    public static BookPreviewResponseDTO toBookPreviewResponseDTO(Book book) {
        return new BookPreviewResponseDTO(
                book.getId(), book.getTitle()
        );
    }
}
