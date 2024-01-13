package com.example.springbootwithpostgresqldevelopment;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(MockitoJUnitRunner.class)
public class springbootwithpostgresqldevelopmentTest {

    @InjectMocks
    private LeadController leadController;

    @Mock
    private LeadService leadService;

    @Test
    public void testFetchLeadsByMobileNumber() {
        // Implement your test scenario using Mockito
    }
}
