create or replace trigger updatecustomerlastmodified
before update on customers
for each row
begin
    :new.lastmodified := sysdate;
end;
/
update customers set name = 'john' where customerid = 1;

create table auditlog (
    log_id number generated always as identity primary key,
    transaction_id number,account_id number,transaction_date date,amount number,transaction_type varchar2(10),log_timestamp date
);
create or replace trigger logtransaction
after insert on transactions
for each row
begin
    insert into auditlog (transaction_id,account_id,transaction_date,amount,transaction_type,log_timestamp)
    values(:new.transactionid,:new.accountid,:new.transactiondate,:new.amount,:new.transactiontype,sysdate);
end;
/
insert into transactions (transactionid, accountid, transactiondate, amount, transactiontype)
values (3, 1, sysdate, 100, 'deposit');


create or replace trigger checktransactionrules
before insert on transactions
for each row
declare
    v_balance number;
begin
    select balance into v_balance
    from accounts
    where accountid = :new.accountid;

    if lower(:new.transactiontype) = 'withdrawal' then
        if :new.amount > v_balance then
            raise_application_error(-20001, 'insufficient balance for withdrawal');
        end if;
    elsif lower(:new.transactiontype) = 'deposit' then
        if :new.amount <= 0 then
            raise_application_error(-20002, 'deposit amount must be positive');
        end if;
    end if;
end;
/
insert into transactions (transactionid, accountid, transactiondate, amount, transactiontype)
values (4, 1, sysdate, 200, 'deposit');
