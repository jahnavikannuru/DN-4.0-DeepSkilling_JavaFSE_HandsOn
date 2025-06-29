SET SERVEROUTPUT ON;

begin
for i in ( SELECT CustomerID FROM Customers WHERE (MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60 )
LOOP
UPDATE Loans SET InterestRate = InterestRate - 1 WHERE CustomerID = i.CustomerID;
END LOOP;
end;

begin
for i in (select CustomerID,Balance from Customers)
loop
if(i.Balance>10000) then
update Customers set IsVIP='TRUE' where CustomerID= i.CustomerID;
else
update Customers set IsVIP='FALSE' where CustomerID= i.CustomerID;
end if;
end loop;
end;

begin
for i in(select l.loanID,c.CustomerID,c.name,l.endDate from loans l join Customers c on l.CustomerID=c.CustomerID where l.endDate between SYSDATE and SYSDATE+30)
loop
dbms_output.put_line('your loan is due '||i.loanID);
end loop;
end;
/
ALTER TABLE Customers ADD IsVIP VARCHAR2(5);
select * from Customers;
select * from Loans;