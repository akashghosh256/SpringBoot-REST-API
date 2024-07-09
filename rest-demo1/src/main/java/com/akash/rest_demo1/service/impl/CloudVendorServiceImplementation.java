package com.akash.rest_demo1.service.impl;

import com.akash.rest_demo1.exception.CloudVendorNotFoundException;
import com.akash.rest_demo1.model.CloudVendor;
import com.akash.rest_demo1.repository.CloudVendorRepository;
import com.akash.rest_demo1.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "save success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "update success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
      cloudVendorRepository.deleteById(cloudVendorId);
        return "delete success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId)
    {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
           throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {

        return cloudVendorRepository.findAll();
    }
    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
