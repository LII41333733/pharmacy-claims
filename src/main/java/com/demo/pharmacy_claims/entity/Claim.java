package com.demo.pharmacy_claims.entity;

import com.demo.pharmacy_claims.enums.ClaimStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "Claims")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Claim.processPharmacyClaims",
                procedureName = "ProcessPharmacyClaims"
        )
})
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimId;

    private int prescriptionId;
    private int insuranceId;
    private double amount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    private String denialReason;

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public String getDenialReason() {
        return denialReason;
    }

    public void setDenialReason(String denialReason) {
        this.denialReason = denialReason;
    }
}