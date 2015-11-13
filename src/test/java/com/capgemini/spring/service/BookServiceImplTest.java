package com.capgemini.spring.service;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.repository.BookRepository;
import com.capgemini.spring.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findBookByIdShouldReturnBook() {
        // given
        long bookId = 1;
        BookEntity mockedEntity = new BookEntity(bookId, "title", "author");
        Mockito.when(bookRepository.findOne(bookId)).thenReturn(mockedEntity);
        // when
        BookEntity bookEntity = bookService.findBookById(bookId);
        // then
        Assert.assertNotNull(bookEntity);

        Mockito.verify(bookRepository).findOne(bookId);

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(bookRepository).findOne(longArgumentCaptor.capture());

        Assert.assertEquals(bookId, longArgumentCaptor.getValue().longValue());
    }
}
