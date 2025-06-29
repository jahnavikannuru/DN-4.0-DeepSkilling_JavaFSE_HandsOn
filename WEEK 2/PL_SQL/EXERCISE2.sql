create or replace procedure SafeTransferFunds(v_FromAccountID number,v_ToAccountID number,v_amount number)
as
v_balance number;
begin
savepoint before_transfer;
select balance into v_balance from Accounts where AccountID=v_FromAccountID;
if v_balance<v_amount then
raise_application_error(-20001,'Insufficient fund');
end if;
update Accounts set Balance=Balance-v_amount where AccountID=v_FromAccountID;
update Accounts set Balance=Balance+v_amount where AccountID=v_ToAccountID;
exception
when no_data_found then
rollback to before_transfer;
raise_application_error(-20002,'no id found');
when others then
rollback to before_transfer;
if sqlcode between -20999 and -20000 then
raise;
else
raise_application_error(-20003,
'transfer failed' || substr(sqlerrm,1,1000));
end if;
end;
/

exec SafeTransferFunds(1,2,500);

create or replace procedure UpdateSalary(v_EmpID number,v_percentage number)
as
v_salary number;
begin
select salary into v_salary from Employees where EmployeeID=v_EmpID;
update Employees set salary=salary+(salary*v_percentage/100) where EmployeeID=v_EmpID;
exception
when no_data_found then
raise_application_error(-20002,'customerID not found');
if sqlcode between -20999 and -20000 then
raise;
else
raise_application_error(-20003,
'update failed' || sqlerrm);
end if;
end;
/
exec UpdateSalary(1,10);

create or replace procedure AddNewCustomer(v_CusID number,v_name VARCHAR2,v_dob DATE,v_balance NUMBER,v_lastMod DATE,v_vip VARCHAR2)
as
begin
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified,ISVIP)
VALUES (v_CusID,v_name,v_dob,v_balance,v_lastMod,v_vip);
exception 
when DUP_VAL_ON_INDEX then
raise_application_error(-20001,'Customer id already exists');
when others then 
raise_application_error(-20002,'insert failed');
end;
/
EXEC AddNewCustomer(3, 'Alice Green', TO_DATE('1993-12-12','YYYY-MM-DD'), 2500, SYSDATE, 'FALSE');
select * from Accounts;
select * from Employees;
select * from Customers;