create or replace procedure ProcessMonthlyInterest
as
v_interest number:=1;
begin
update Accounts set balance=balance+(balance*v_interest/100),lastModified=SYSDATE where AccountType='Savings';
end;
/
exec ProcessMonthlyInterest;
select * from Accounts;

create or replace procedure UpdateEmployeeBonus(v_dept varchar,v_percent number)
as
begin
update Employees set Salary=salary+(Salary*v_percent/100) where DEPARTMENT=v_dept;
end;
/
exec UpdateEmployeeBonus('HR',20);
select * from Employees;

create or replace procedure TransferFunds(v_FromAccountID number,v_ToAccountID number,v_amount number)
as
v_balance number;
begin
select balance into v_balance from Accounts where AccountID=v_FromAccountID;
if v_balance<v_amount then
raise_application_error(-20001,'Insufficient fund');
end if;
update Accounts set Balance=Balance-v_amount where AccountID=v_FromAccountID;
update Accounts set Balance=Balance+v_amount where AccountID=v_ToAccountID;
end;
/

exec TransferFunds(2,1,1000);
select * from Accounts;