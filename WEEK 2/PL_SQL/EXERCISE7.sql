set serveroutput on;
clear screen;

--Scenario 1
create or replace package CustomerManagement as
procedure addCustomer(v_CusID in number,v_name in varchar2,v_dob in date,v_balance in number,v_lastModified in date);
procedure updateCustomer(v_bal in number,v_lastModified in date,v_CusID in number);
function getBalance(v_CusID in number) return number;
end CustomerManagement;

create or replace package body CustomerManagement as
procedure addCustomer(v_CusID in number,v_name in varchar2,v_dob in date,v_balance in number,v_lastModified in date)
is
begin
insert into customers(CustomerID,Name,DOB,Balance,LastModified ) values (v_CusID,v_name,v_dob,v_balance,v_lastModified);
end addCustomer;

procedure updateCustomer(v_bal in number,v_lastModified in date,v_CusID in number)
is
begin
update Customers set balance=balance+v_bal,lastModified=v_lastModified where CustomerID=v_CusID;
end updateCustomer;

function getBalance(v_CusID in number) 
return number is v_balance number;
begin
select balance into v_balance from Customers where CustomerID=v_CusID;
return v_balance;
end getBalance;
end CustomerManagement;
/
BEGIN
  CustomerManagement.addCustomer(4, 'Jane Doe', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 1000, SYSDATE);
  CustomerManagement.updateCustomer(200, SYSDATE, 1);
  DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || CustomerManagement.getBalance(1));
END;
/

--Scenario 2
create or replace package EmployeeManagement as
procedure hireEmployee(v_empId in number, v_name in varchar2, v_position in varchar2, v_salary in number,v_department in varchar2,v_hiredate in date);
procedure updateEmployeeDetails(v_empId in number,v_position in varchar2, v_salary in number);
function calculateAnnualSalary(v_empId in number) return number;
end EmployeeManagement;
/
create or replace package body EmployeeManagement as
procedure hireEmployee(v_empId in number, v_name in varchar2, v_position in varchar2, v_salary in number,v_department in varchar2,v_hiredate in date) is
begin
insert into employees(EmployeeID,name,position,salary,department,hiredate) values(v_empId, v_name, v_position, v_salary,v_department,v_hiredate);
end hireEmployee;

procedure updateEmployeeDetails(v_empId in number,v_position in varchar2, v_salary in number) is
begin
update employees set position = v_position, salary = v_salary where EmployeeID = v_empId;
end updateEmployeeDetails;

function calculateAnnualSalary(v_empId in number) return number is v_monthlySalary number;
begin
select salary into v_monthlySalary from employees where EmployeeID = v_empId;
return v_monthlySalary * 12;
end calculateAnnualSalary;
end EmployeeManagement;
/
begin
EmployeeManagement.hireEmployee(3,'harry','manager',70000,'hr',sysdate);
EmployeeManagement.updateEmployeeDetails(1,'manager',80000);
DBMS_OUTPUT.PUT_LINE('annual salary: ' || EmployeeManagement.calculateAnnualSalary(1));
end;
/
select * from employees;

--Scenario 3
create or replace package AccountOperations as
procedure openAccount(v_accountId in number, v_customerId in number,v_accType in varchar2, v_balance in number,v_modified in date);
procedure closeAccount(v_accountId in number);
function getTotalBalance(v_customerId in number) return number;
end AccountOperations;
/
create or replace package body AccountOperations as
procedure openAccount(v_accountId in number, v_customerId in number,v_accType in varchar2,v_balance in number,v_modified in date) is
begin
insert into Accounts(AccountId, customerId,AccountType,balance,LastModified) values(v_accountId, v_customerId,v_accType, v_balance,v_modified);
end openAccount;

procedure closeAccount(v_accountId in number) is
begin
delete from accounts where AccountId = v_accountId;
end closeAccount;

function getTotalBalance(v_customerId in number) return number is v_totalBalance number;
begin
select sum(balance) into v_totalBalance from accounts where customerId = v_customerId;
return v_totalBalance;
end getTotalBalance;
end AccountOperations;
/
begin
AccountOperations.openAccount(4,4,'Checking',1000,sysdate);
AccountOperations.closeAccount(4);
dbms_output.put_line(AccountOperations.getTotalBalance(1));
end;
/
select * from accounts;