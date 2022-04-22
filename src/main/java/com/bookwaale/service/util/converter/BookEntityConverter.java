package com.bookwaale.service.util.converter;

import com.bookwaale.service.dto.response.BookPreviewResponseDTO;
import com.bookwaale.service.model.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class BookEntityConverter {

    public BookPreviewResponseDTO toBookPreviewResponseDTO(@NotNull Book book) {
        return new BookPreviewResponseDTO(
                book.getId(), book.getTitle()
        );
    }
}
