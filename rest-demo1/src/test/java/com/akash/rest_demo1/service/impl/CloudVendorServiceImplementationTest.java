package com.akash.rest_demo1.service.impl;

import com.akash.rest_demo1.model.CloudVendor;
import com.akash.rest_demo1.repository.CloudVendorRepository;
import com.akash.rest_demo1.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplementationTest {
    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImplementation(cloudVendorRepository); //injecting
        cloudVendor = new CloudVendor("1","Amazon","Texas","xxx5556660");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    // mock all the other layers
    @Test
    void testCreateCloudVendor() {
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
    assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("save success");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("update success");


    }

    @Test
    void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

            doAnswer(Answers.CALLS_REAL_METHODS).
            when(cloudVendorRepository).deleteById(any());

            assertThat(cloudVendorService.deleteCloudVendor("1")).
            isEqualTo("delete success");




    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById(any())).thenReturn(Optional.of(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singletonList(cloudVendor))
        );
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber())
                .isEqualTo(cloudVendor.getVendorPhoneNumber());
    }

    @Test
    void testGetByVendorName() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singletonList(cloudVendor))
        );
        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId())
                .isEqualTo(cloudVendor.getVendorId());
    }
}