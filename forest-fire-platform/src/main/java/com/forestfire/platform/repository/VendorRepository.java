package com.forestfire.platform.repository;

import com.forestfire.platform.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
