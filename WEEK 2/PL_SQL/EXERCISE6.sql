set serveroutput on
declare
v_transID Transactions.transactionID%type;
v_amount Transactions.amount%type;
v_AccountID Transactions.AccountID%type;
v_TransactionDate Transactions.TransactionDate%type;
v_TransactionType Transactions.TransactionType%type;
cursor GenerateMonthlyStatements is select * from transactions where extract(month from transactionDate)=extract(month from sysdate);
begin
open GenerateMonthlyStatements;
loop
fetch GenerateMonthlyStatements into v_transID,v_AccountID,v_TransactionDate,v_amount,v_TransactionType;
exit when GenerateMonthlyStatements%notfound;
dbms_output.put_line('TransId: '||v_transID||'AccID: '||v_AccountID ||'date: '||v_TransactionDate||'amount: ' ||v_amount||'type: '||v_TransactionType);
end loop;
close GenerateMonthlyStatements;
end;
/

declare
v_balance Accounts.balance%type;
v_AccountID Accounts.AccountID%type;
maintenance number:=100;
cursor ApplyAnnualFee is select AccountID,balance from Accounts;
begin
open ApplyAnnualFee;
loop
fetch ApplyAnnualFee into v_AccountID,v_balance;
exit when ApplyAnnualFee%notfound;
v_balance := v_balance - maintenance;
update Accounts set balance = v_balance where AccountID = v_AccountID;
dbms_output.put_line('AccountId: '||v_AccountID||' Balance: '||v_balance);
end loop;
close ApplyAnnualFee;
end;
/

declare
v_LoanID Loans.LoanID%type;
v_CustomerID Loans.CustomerID%type;
v_LoanAmount Loans.LoanAmount%type;
v_InterestRate Loans.InterestRate%type;
v_StartDate Loans.StartDate%type;
v_EndDate Loans.EndDate%type;
new_interest number:=1;
cursor UpdateLoanInterestRates is select * from Loans;
begin
open UpdateLoanInterestRates;
loop
fetch UpdateLoanInterestRates into v_LoanID,v_CustomerID,v_LoanAmount,v_InterestRate,v_StartDate,v_EndDate;
exit when UpdateLoanInterestRates%notfound;
v_InterestRate:=v_InterestRate+new_interest;
update Loans set InterestRate = v_InterestRate where LoanID = v_LoanID;
dbms_output.put_line('LoanId: '||v_LoanID||' CustomerId: '||v_CustomerID||' Loan maount: '||v_LoanAmount||' interest rate: '||v_InterestRate||' startDate: '||v_StartDate||' endDate: '||v_EndDate); 
end loop;
close UpdateLoanInterestRates;
end;
/