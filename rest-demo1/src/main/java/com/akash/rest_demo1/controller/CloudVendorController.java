package com.akash.rest_demo1.controller;


import com.akash.rest_demo1.model.CloudVendor;
import com.akash.rest_demo1.response.ResponseHandler;
import com.akash.rest_demo1.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// logger classes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {



    // http://localhost:8080/cloudvendor/1
   // CloudVendor cloudVendor;
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    private static final Logger loginfo = LoggerFactory.getLogger(CloudVendorController.class);

    // read specific id
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
       //return new CloudVendor("c1","Dukan","Telco", "99999");


    loginfo.info("Vendor found logging worked");
    loginfo.debug("Debug enabled from yaml");
      return ResponseHandler.responseBuilder("Requested Vendor details are given here",HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));

      //  return cloudVendorService.getCloudVendor(vendorId);

    }
// all cloud id
    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails() {
        //return new CloudVendor("c1","Dukan","Telco", "99999");
        return cloudVendorService.getAllCloudVendors();

    }
    @GetMapping("{vendorName}")
    public List<CloudVendor>  getByVendorName(@PathVariable("vendorName") String vendorName){
        return cloudVendorService.getByVendorName(vendorName);

    }


    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {

        cloudVendorService.createCloudVendor(cloudVendor);
     return "Cloud vendor Created Successfully";
    }

    @PutMapping  // for update
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
       cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
       cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor Deleted Successfully";
    }


}
