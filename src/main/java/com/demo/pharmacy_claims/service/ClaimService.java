package com.demo.pharmacy_claims.service;

import com.demo.pharmacy_claims.entity.Claim;
import com.demo.pharmacy_claims.enums.ClaimStatus;
import com.demo.pharmacy_claims.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Transactional
    public void processClaims() {
        claimRepository.processPharmacyClaims();
    }

    @Transactional
    public List<Claim> getClaimsByStatus(String status) {
        if (!status.equalsIgnoreCase("PENDING") &&
                !status.equalsIgnoreCase("APPROVED") &&
                !status.equalsIgnoreCase("DENIED")) {
            throw new IllegalArgumentException("Invalid claim status: " + status);
        }

        List<Object[]> rawClaims = claimRepository.getClaimsByStatus(status.toUpperCase());

        // Convert `Object[]` to `Claim` objects
        return rawClaims.stream().map(this::mapToClaim).collect(Collectors.toList());
    }

    private Claim mapToClaim(Object[] obj) {
        Claim claim = new Claim();
        claim.setClaimId((Integer) obj[0]);
        claim.setPrescriptionId((Integer) obj[1]);
        claim.setInsuranceId((Integer) obj[2]);
        claim.setAmount((Double) obj[3]);
        claim.setStatus(ClaimStatus.valueOf((String) obj[4]));
        claim.setDenialReason(obj[5] != null ? obj[5].toString() : null);
        return claim;
    }
}