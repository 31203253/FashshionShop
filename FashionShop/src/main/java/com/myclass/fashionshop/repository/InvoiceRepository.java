package com.myclass.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.fashionshop.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
