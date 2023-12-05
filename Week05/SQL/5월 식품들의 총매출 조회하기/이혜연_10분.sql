select p.product_id, p.product_name, sum(p.price*o.amount) as total_sales
from food_product p, food_order o
where p.product_id = o.product_id
and to_char(o.produce_date, 'YYYYMM')='202205'
group by p.product_id, p.product_name
order by 3 desc, 1 asc;
