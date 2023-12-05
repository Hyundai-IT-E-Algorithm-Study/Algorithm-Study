select to_char(s.sales_date,'YYYY'), 
       to_number(to_char(s.sales_date, 'MM')),
       i.gender,
       count(distinct(i.user_id))
from user_info i inner join online_sale s
on i.user_id = s.user_id
group by to_char(s.sales_date,'YYYY'), 
         to_number(to_char(s.sales_date, 'MM')),
         i.gender
having i.gender is not null
order by 1,2,3;
