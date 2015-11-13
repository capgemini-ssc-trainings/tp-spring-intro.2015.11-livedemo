package com.capgemini.spring.rest;

import com.capgemini.spring.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BookRestServiceTest {

    @InjectMocks
    private BookRestService bookRestService;
    @Mock
    private BookService bookService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookRestService).build();
    }

    @Test
    public void shouldCallFindBook() throws Exception {
        // given
        final long bookId = 1;
        // when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/book/" + bookId));
        // then
        result.andExpect(MockMvcResultMatchers.status().is(200));
        Mockito.verify(bookService).findBookById(bookId);
    }
}
