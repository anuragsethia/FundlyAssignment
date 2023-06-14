# FundlyAssignment

Write a Java Program with all the JUNIT test cases. TDD approach will be preferred. 

Problem Statement
There is a scenario where thousands of loans are flowing into one store, assume any way of transmission of Loans. We need to create a one loan store, which store the loans in the following order
Loan ID	Customer Id	Lender Id	Amount	Remaining Amount	Payment Date	Interest Per Day(%)	Due Date	Penalty/Day
(%Day)	Cancel
L1	C1	LEN1	10000	10000	05/06/2023	1	05/07/2023	0.01%	
L2	C1	LEN1	20000	5000	01/06/2023	1	05/08/2023	0.01%	
L3	C2	LEN2	50000	30000	04/04/2023	2	04/05/2023	0.02 %	
L4	C3	LEN2	50000	30000	04/04/2023	2	04/05/2023	0.02 %	

There are couple of requirement/validation
1.	The payment date can’t be greater than the Due Date. If its greater we have to reject the Loan and thrown the exception
2.	We need to write an aggregation on the remaining amount, Interest and Penalty Group by Lender, Group by Interest and Group by Customer ID. 
3.	If the Loan crosses the due date, it should write an alert in the log message.

