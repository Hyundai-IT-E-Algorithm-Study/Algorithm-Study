SELECT category, price as max_price, product_name
from food_product
where (category, price) 
in (select category, max(price) from food_product
    where category in ('과자', '국', '김치', '식용유')
    group by category)
group by category, product_name, price
order by price desc;
