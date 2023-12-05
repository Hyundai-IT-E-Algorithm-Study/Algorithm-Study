select car_id, max(case when '20221016' between to_char(start_date, 'YYYYMMDD') and to_char(end_date,'YYYYMMDD') 
                   then '대여중'
                   else '대여 가능'
                   end) as availability 
from car_rental_company_rental_history
group by car_id
order by car_id desc;
