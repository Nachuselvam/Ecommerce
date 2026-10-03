package com.service;

import com.Repository.VendorRepository;
import com.model.Vendor;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public void insert(Vendor vendor) {
        int vendorId = (int) (Math.random() * 10000);
        vendor.setId(vendorId);
        vendorRepository.insert(vendor);
    }
}
