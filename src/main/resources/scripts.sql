# CREATE DATABASE IF NOT EXISTS pharmacy_db;


# USE pharmacy_db;


# CREATE TABLE IF NOT EXISTS Claims (
                                                   #     claim_id INT PRIMARY KEY AUTO_INCREMENT,
                                                   #     prescription_id INT NOT NULL UNIQUE,
                                                   #     insurance_id INT,
                                                   #     amount DECIMAL(10,2),
    #     status ENUM('PENDING', 'APPROVED', 'DENIED') DEFAULT 'PENDING',
    #     denial_reason VARCHAR(255)
    # );


# INSERT IGNORE INTO Claims (prescription_id, insurance_id, amount, status) VALUES
# (101, 201, 4500, 'PENDING'),
# (102, 202, 5500, 'PENDING'),
# (103, 203, 3000, 'PENDING');


# DELIMITER $$
#
# CREATE PROCEDURE ProcessPharmacyClaims()
    # BEGIN
#     -- Approve claims below $5000
#     UPDATE Claims
    #     SET status = 'APPROVED'
                #     WHERE status = 'PENDING' AND amount < 5000;
#
#     -- Deny claims above or equal to $5000
#     UPDATE Claims
    #     SET status = 'DENIED', denial_reason = 'Requires Prior Authorization'
          #     WHERE status = 'PENDING' AND amount >= 5000;
# END $$
#
# DELIMITER ;


# SELECT * FROM Claims;


# DELIMITER $$
#
# CREATE PROCEDURE GetClaimsByStatus(IN claim_status ENUM('PENDING', 'APPROVED', 'DENIED'))
    # BEGIN
#     SELECT * FROM Claims WHERE status = claim_status;
# END $$
#
# DELIMITER ;


# SHOW PROCEDURE STATUS WHERE Db = 'pharmacy_db';
