SELECT p.product_code, sum(p.price*o.sales_amount) AS SALES
FROM product p 
INNER JOIN offline_sale o
ON p.product_id = o.product_id
GROUP BY p.product_code
ORDER BY sales desc, product_code asc;
