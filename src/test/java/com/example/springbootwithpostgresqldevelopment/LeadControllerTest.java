package com.example.springbootwithpostgresqldevelopment;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LeadControllerTest {

    @InjectMocks
    private LeadController leadController;

    @Mock
    private LeadService leadService;

    @Test
    public void testFetchLeadsByMobileNumber_Success() {
        // Arrange
        List<Lead> leads = Arrays.asList(
                new Lead(5678L, "Vineet", "", "KV", "8877887788", "Male", "01/01/1990", "v@gmail.com"),
                new Lead(5679L, "Vishal", "", "Sonar", "8877887788", "Male", "01/01/1995", "vi@gmail.com")
        );
        when(leadService.findByMobileNumber("8877887788")).thenReturn(leads);

        // Act
        ResponseEntity<Object> response = leadController.fetchLeadsByMobileNumber("8877887788");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", ((Map<String, String>) response.getBody()).get("status"));
    }

    @Test
    public void testFetchLeadsByMobileNumber_NoLeadsFound() {
        // Arrange
        when(leadService.findByMobileNumber("8877887788")).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<Object> response = leadController.fetchLeadsByMobileNumber("8877887788");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("error", ((Map<String, String>) response.getBody()).get("status"));
        assertEquals("E10011", ((Map<String, String>) response.getBody()).get("errorResponse.code"));
        assertEquals("No Lead found with the Mobile Number 8877887788",
                ((List<String>) ((Map<String, Object>) response.getBody()).get("errorResponse.messages")).get(0));
    }
}
