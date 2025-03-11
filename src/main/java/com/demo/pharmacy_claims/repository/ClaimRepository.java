package com.demo.pharmacy_claims.repository;

import com.demo.pharmacy_claims.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    @Transactional
    @Procedure(name = "Claim.processPharmacyClaims")
    void processPharmacyClaims();

    @Procedure(name = "GetClaimsByStatus")
    List<Object[]> getClaimsByStatus(@Param("claim_status") String status);
}