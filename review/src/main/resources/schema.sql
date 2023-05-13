DROP TABLE IF EXISTS review; 

CREATE TABLE review (  
reviewId INT AUTO_INCREMENT  PRIMARY KEY,  
productId VARCHAR(50) NOT NULL , 
numberOfReviews INT NOT NULL , 
averageReviewScore FLOAT NOT NULL
);