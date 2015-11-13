package com.capgemini.spring.repository;

import com.capgemini.spring.SpringIntroductionApplication;
import com.capgemini.spring.model.BookEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringIntroductionApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAllShodReturnBooks() {
        // given when
        List<BookEntity> books = bookRepository.findAll();
        // then
        Assert.assertEquals(2, books.size());
    }

    @Test
    public void shouldFindBookByTitle() {
        // given
        final String title = "Fi";
        // when
        List<BookEntity> books = bookRepository.findBookByTitle2(title);
        // then
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("First Book", books.get(0).getTitle());
    }
}
