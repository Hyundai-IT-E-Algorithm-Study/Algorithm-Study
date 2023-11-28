select category, price, product_name
from (select category, max(price) as max_price
        from food_product
        group by category
        having category in ('과자','국','김치','식용유')
        ) a left outer join food_product b
where a.category = b.category and a.price = b.price;
