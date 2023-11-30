SELECT p.product_id, p.product_name, SUM(p.price * o.amount) as total_sales
FROM food_product p
    JOIN food_order o
    ON p.product_id = o.product_id
WHERE TO_CHAR(o.produce_date, 'YY-MM') = '22-05'
GROUP BY p.product_id, p.product_name
ORDER BY 3 DESC, 1;
