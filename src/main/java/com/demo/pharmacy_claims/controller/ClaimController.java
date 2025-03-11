package com.demo.pharmacy_claims.controller;

import com.demo.pharmacy_claims.entity.Claim;
import com.demo.pharmacy_claims.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping("/process")
    public String processClaims() {
        claimService.processClaims();
        return "Pharmacy claims processed successfully!";
    }

    @GetMapping("/status/{status}")
    public List<Claim> getClaimsByStatus(@PathVariable String status) {
        try {
            return claimService.getClaimsByStatus(status);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid claim status. Allowed values: PENDING, APPROVED, DENIED.");
        }    }
}