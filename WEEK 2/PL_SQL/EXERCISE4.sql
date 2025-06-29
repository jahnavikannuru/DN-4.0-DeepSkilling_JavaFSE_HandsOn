set SERVEROUTPUT on;
create or replace function CalculateAge(v_dob in date)
return number
is
v_age number;
begin
v_age:=trunc(months_between(sysdate,v_dob)/12);
return v_age;
end;
/
select CalculateAge(dob) as age from Customers;
select * from Customers;

create or replace function CalculateMonthlyInstallment(
    p_loan_amount in number,
    p_interest_rate in number,
    p_loan_years in number
)
return number
is
    v_monthly_rate number := p_interest_rate / 12 / 100;
    v_months number := p_loan_years * 12;
    v_installment  number;
begin
    if v_monthly_rate = 0 then
        v_installment := p_loan_amount / v_months;
    else
        v_installment := p_loan_amount * v_monthly_rate /(1 - power(1 + v_monthly_rate, -v_months));
    end if;
    return round(v_installment,2);
end;
/
select CalculateMonthlyInstallment(LoanAmount,InterestRate,5) As monthly_installment from Loans where loanID=1;

create or replace function HasSufficientBalance(
    v_accID in number,
    v_amount in number
)
return boolean
is
    v_balance number;
begin
    select balance into v_balance from accounts where accountid = v_accID;
    return v_balance>=v_amount;
exception 
    when no_data_found then
        return FALSE;
end;
/
declare
    result boolean;
begin
    result := HasSufficientBalance(1, 500);
    if result then
        DBMS_OUTPUT.PUT_LINE('Sufficient balance');
    else
        DBMS_OUTPUT.PUT_LINE('Insufficient balance');
    end if;
end;


